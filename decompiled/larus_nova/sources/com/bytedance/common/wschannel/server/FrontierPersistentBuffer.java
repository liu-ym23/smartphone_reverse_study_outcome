package com.bytedance.common.wschannel.server;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdk.schema.BasicTestActionHandler;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.wschannel.utils.DiskStorageUtils;
import com.bytedance.common.wschannel.utils.Utils;
import com.bytedance.common.wschannel.utils.WsAsyncIOTaskManager;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes15.dex */
public class FrontierPersistentBuffer {
    private static final String TAG = null;
    private PriorityQueue<Integer> mAvailableOffsetQueue;
    private MappedByteBuffer mByteBuffer;
    private final AtomicBoolean mFrontierBufferInitFailed;
    private ConcurrentHashMap<String, MessageContent> mMessageIdStorageMap;
    private byte[] sNullData;

    public static class MessageContent {
        private int mOffset;
        private long mTimeStamp;

        public int getOffset() {
            return this.mOffset;
        }

        public long getTimeStamp() {
            return this.mTimeStamp;
        }

        public void setOffset(int r100) {
            this.mOffset = r100;
        }

        public MessageContent(long r100, int r101) {
            this.mTimeStamp = r100;
            this.mOffset = r101;
        }
    }

    static {
        TAG = "FrontierPersistentBuffer";
    }

    private void flush() {
        this.mByteBuffer.force();
    }

    private long getFileVersion() {
        return this.mByteBuffer.getShort(2);
    }

    private short getMagicNumber() {
        return this.mByteBuffer.getShort(0);
    }

    private int getTotalBytes() {
        return this.mByteBuffer.getInt(8);
    }

    private int getTotalCount() {
        return this.mByteBuffer.getInt(4);
    }

    private void initPersistentBuffer() {
        this.mByteBuffer.position(12);
        long r100 = System.currentTimeMillis();
        int r101 = getTotalBytes() / 40;
        int r102 = 0;
        boolean r103 = false;
    L3:
        if (r102 >= r101) goto L19;
        byte[] r104 = new byte[32];
        this.mByteBuffer.get(r104);
        long r105 = this.mByteBuffer.getLong();
        if (isEmptyData(r104) == false) goto L11;
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "Data is empty, bypass remove offset:" + r102);
    L9:
        this.mAvailableOffsetQueue.add(Integer.valueOf(r102));
    L18:
        r102 = r102 + 1;
        goto L3
    L11:
        if (r105 >= r100) goto L15;
        removeMessageFromFileByOffset(r102);
        if (r103 == true) goto L18;
        r103 = true;
        goto L18
    L15:
        String r106 = new String(r104, StandardCharsets.UTF_8);
        MessageContent r107 = new MessageContent(r105, r102);
        this.mMessageIdStorageMap.put(r106, r107);
        if (Logger.debug() == false) goto L18;
        Logger.d(TAG, "initPersistentBuffer item: " + new String(r104) + "&" + r107.getTimeStamp() + "_" + r107.getOffset());
        goto L18
    L19:
        if (r103 == false) goto L22;
        flush();
    L22:
        if (Logger.debug() == false) goto L31;
        Logger.d(TAG, "map size:" + this.mMessageIdStorageMap.size() + " total count:" + getTotalCount() + " data size:" + r101 + " total bytes:" + getTotalBytes());
        return;
    }

    private void removeDataForAvailableStorage() {
        Logger.i(TAG, "available:1092 queue:" + this.mAvailableOffsetQueue.size());
        Iterator<Map.Entry<String, MessageContent>> r100 = this.mMessageIdStorageMap.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        MessageContent r101 = r100.next().getValue();
        if (r101.getOffset() >= 1092) goto L4;
        removeMessageFromFileByOffset(r101.getOffset());
        r100.remove();
        goto L4
    }

    private void reset() {
        Logger.i(TAG, BasicTestActionHandler.TEST_ACTION_RESET);
        this.mByteBuffer.clear();
        this.mByteBuffer.putShort(2114);
        this.mByteBuffer.putShort(1);
        this.mByteBuffer.putInt(0);
        this.mByteBuffer.putInt(0);
    }

    private void removeExpiredCachedData() {
        if (Logger.debug() == false) goto L5;
        Logger.d(TAG, "removeExpiredCachedData");
    L5:
        Iterator<Map.Entry<String, MessageContent>> r100 = this.mMessageIdStorageMap.entrySet().iterator();
        long r101 = System.currentTimeMillis();
        boolean r102 = false;
    L7:
        if (r100.hasNext() == false) goto L13;
        MessageContent r103 = r100.next().getValue();
        if (r103.getTimeStamp() >= r101) goto L7;
        removeMessageFromFileByOffset(r103.getOffset());
        r100.remove();
        if (r102 == true) goto L7;
        r102 = true;
        goto L7
    L13:
        if (r102 == false) goto L23;
        flush();
        return;
    }

    public static /* synthetic */ String access$500() {
        return TAG;
    }

    public void initFinished() {
        FrontierMessageManager.setPersistentBufferInitFinished();
    }

    public FrontierPersistentBuffer(Context r110) {
        this.sNullData = new byte[40];
        this.mAvailableOffsetQueue = new PriorityQueue();
        this.mMessageIdStorageMap = new ConcurrentHashMap();
        this.mFrontierBufferInitFailed = new AtomicBoolean(false);
        FileLock r100 = null;
        long r101 = System.currentTimeMillis();     // Catch: Throwable -> L23
        FileChannel r111 = new RandomAccessFile(DiskStorageUtils.getPersistentFile(r110), "rw").getChannel();     // Catch: Throwable -> L23
        FileLock r102 = r111.tryLock();     // Catch: Throwable -> L21
        this.mByteBuffer = r111.map(FileChannel.MapMode.READ_WRITE, 0, PlaybackStateCompat.ACTION_SET_REPEAT_MODE);     // Catch: Throwable -> L19
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, "magic number: " + getMagicNumber() + " file version: " + getFileVersion() + " total count: " + getTotalCount() + " total bytes: " + getTotalBytes());     // Catch: Throwable -> L19
    L9:
        if (getMagicNumber() == 2114) goto L11;
    L16:
        reset();     // Catch: Throwable -> L19
    L17:
        final long r103 = 3600000;
        final long r104 = 3600000;
        WsAsyncIOTaskManager.getInstance().postTask(new AnonymousClass1(this, r103, r104));     // Catch: Throwable -> L19
        reportPersistentBufferLog(null, 4, System.currentTimeMillis() - r101);     // Catch: Throwable -> L19
        return;
    L11:
        if (getTotalBytes() <= 0) goto L16;
        if (getTotalCount() <= 0) goto L16;
        initPersistentBuffer();     // Catch: Throwable -> L19
    L19:
        th = th;
        r100 = r102;
    L25:
        Logger.e(TAG, "create MappedByteBuffer failed: ", th);
        this.mFrontierBufferInitFailed.set(true);
        reportByteBufferCreatedError(5, th);
        if (r100 != null) goto L38;
    L28:
        if (r111 == null) goto L40;
        r111.close();     // Catch: IOException -> L31
        return;
    L42:
        return;
    L40:
        return;
    L38:
        r100.release();     // Catch: IOException -> L31
    L21:
        th = th;
    L23:
        th = th;
        r111 = null;
        goto L25
    }

    public static /* synthetic */ AtomicBoolean access$000(FrontierPersistentBuffer r100) {
        return r100.mFrontierBufferInitFailed;
    }

    public static /* synthetic */ void access$100(FrontierPersistentBuffer r100) {
        r100.removeExpiredCachedData();
    }

    public static /* synthetic */ ConcurrentHashMap access$400(FrontierPersistentBuffer r100) {
        return r100.mMessageIdStorageMap;
    }

    public static /* synthetic */ void access$700(FrontierPersistentBuffer r100) {
        r100.flush();
    }

    private boolean isEmptyData(byte[] r100) {
        if (r100 != null) goto L5;
    L14:
        return true;
    L5:
        if (r100.length == 0) goto L14;
        int r101 = 0;
    L9:
        if (r101 >= r100.length) goto L14;
        if (r100[r101] != 0) goto L12;
        r101 = r101 + 1;
        goto L9
    L12:
        return false;
    }

    private void removeMessageFromFileByOffset(int r100) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        this.mByteBuffer.position((r100 * 40) + 12);
        this.mByteBuffer.put(this.sNullData);
        setTotalCount(getTotalCount() - 1);
        this.mAvailableOffsetQueue.add(Integer.valueOf(r100));
        if (Logger.debug() == false) goto L8;
        Logger.d(TAG, String.format("remove success: offset=%s, totalCount=%s, totalBytes=%s", new Object[]{Integer.valueOf(r100), Integer.valueOf(getTotalCount()), Integer.valueOf(getTotalBytes())}));
        return;
    }

    private void setTotalBytes(int r100) {
        this.mByteBuffer.putInt(8, r100);
    }

    private void setTotalCount(int r100) {
        this.mByteBuffer.putInt(4, r100);
    }

    public void ackMessage(String[] r100) {
        if (Logger.debug() == false) goto L6;
        Logger.d(TAG, "ack message id: " + Arrays.toString(r100));
    L6:
        if (this.mFrontierBufferInitFailed.get() == true) goto L36;
        if (r100 != null) goto L9;
        return;
    L9:
        if (r100.length == 0) goto L38;
        final ArrayList r101 = new ArrayList();
        int r102 = r100.length;
        int r103 = 0;
    L12:
        if (r103 >= r102) goto L25;
        String r104 = r100[r103];
        if (TextUtils.isEmpty(r104) == true) goto L23;
    L21:
        e = move-exception;
        e.printStackTrace();
        goto L23
    L17:
        if (r104.getBytes("UTF-8").length != 32) goto L23;
        r101.add(r104);     // Catch: UnsupportedEncodingException -> L21
    L23:
        r103 = r103 + 1;
        goto L12
    L25:
        if (r101.isEmpty() == false) goto L27;
        return;
    L27:
        WsAsyncIOTaskManager.getInstance().postTask(new AnonymousClass4(this, r101));
        return;
    L38:
        return;
    }

    public static /* synthetic */ void access$600(FrontierPersistentBuffer r100, int r101) {
        r100.removeMessageFromFileByOffset(r101);
    }

    private int mapToFile(String r100, long r101) {
        byte[] r102 = r100.getBytes();
        if (r102 != null) goto L5;
    L27:
        return -1;
    L5:
        if (r102.length != 32) goto L27;
        int r103 = pushMessageInAvailableSlot(r102, r101);
        if (r103 < 0) goto L11;
        return r103;
    L11:
        if (this.mByteBuffer.remaining() >= 40) goto L13;
    L22:
        String r104 = TAG;
        Logger.i(r104, "remaining:" + this.mByteBuffer.remaining() + " total count:" + getTotalCount() + " threshold:6553 total bytes:" + getTotalBytes() + " threshold:262104");
        reportPersistentBufferLog(r100, 3, -1);
        removeDataForAvailableStorage();
        int r105 = pushMessageInAvailableSlot(r102, r101);
        if (r105 >= 0) goto L26;
        Logger.e(r104, "Push data failed, removeDataForAvailableStorage is not working.");
        return -1;
    L26:
        return r105;
    L13:
        if (getTotalCount() >= 6553) goto L22;
        if (getTotalBytes() >= 262104) goto L22;
        this.mByteBuffer.position(getTotalBytes() + 12);
        this.mByteBuffer.put(r102);
        this.mByteBuffer.putLong(r101);
        int r106 = getTotalCount();
        setTotalCount(r106 + 1);
        setTotalBytes(getTotalBytes() + 40);
        if (Logger.debug() == false) goto L20;
        Logger.d(TAG, String.format("push success in file: offset=%s, totalCount=%s, totalBytes=%s, logItem=%s", new Object[]{Integer.valueOf(r106), Integer.valueOf(getTotalCount()), Integer.valueOf(getTotalBytes()), r100}));
    L20:
        flush();
        return r106;
    }

    private int pushMessageInAvailableSlot(byte[] r100, long r101) {
        if (this.mAvailableOffsetQueue.isEmpty() == false) goto L6;
        return -1;
    L6:
        int r102 = this.mAvailableOffsetQueue.poll().intValue();
        this.mByteBuffer.position((r102 * 40) + 12);
        this.mByteBuffer.put(r100);
        this.mByteBuffer.putLong(r101);
        setTotalCount(getTotalCount() + 1);
        if (Logger.debug() == false) goto L9;
        Logger.d(TAG, String.format("push success in queue: offset=%s, totalCount=%s, totalBytes=%s, logItem=%s", new Object[]{Integer.valueOf(r102), Integer.valueOf(getTotalCount()), Integer.valueOf(getTotalBytes()), new String(r100)}));
    L9:
        return r102;
    }

    private void reportByteBufferCreatedError(int r100, Throwable r101) {
        JSONObject r102 = new JSONObject();
        r102.put("action", r100);     // Catch: JSONException -> L10
        String r103 = Utils.outputThrowableStackTrace(r101);     // Catch: JSONException -> L10
        if (TextUtils.isEmpty(r103) == false) goto L6;
    L8:
        r102.put(a.KEY_EXCEPTION, r103);     // Catch: JSONException -> L10
    L12:
        FrontierMessageManager.reportFrontierMessageLog(r102);
        return;
    L6:
        if (r103.length() <= 2048) goto L8;
        r103 = r103.substring(0, 2048);     // Catch: JSONException -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public boolean shouldDropMessageAndUpdateFile(final String r100, long r101) {
        if (this.mFrontierBufferInitFailed.get() == false) goto L6;
        return false;
    L6:
        if (this.mMessageIdStorageMap.containsKey(r100) == false) goto L9;
        Logger.i(TAG, "Drop existed messageId:" + r100);
        WsAsyncIOTaskManager.getInstance().postTask(new AnonymousClass2(this, r100));
        return true;
    L9:
        final long r102 = System.currentTimeMillis() + r101;
        this.mMessageIdStorageMap.put(r100, new MessageContent(r102, -1));
        WsAsyncIOTaskManager.getInstance().postTask(new AnonymousClass3(this, r100, r102));
        return false;
    }

    public static /* synthetic */ int access$300(FrontierPersistentBuffer r100, String r101, long r102) {
        return r100.mapToFile(r101, r102);
    }

    private void reportPersistentBufferLog(String r100, int r101, long r110) {
        int r102 = this.mMessageIdStorageMap.size();
        int r103 = this.mAvailableOffsetQueue.size();
        int r104 = getTotalCount();
        int r105 = getTotalBytes();
        JSONObject r106 = new JSONObject();
    L11:
        e = move-exception;
        e.printStackTrace();
    L13:
        FrontierMessageManager.reportFrontierMessageLog(r106);
        return;
    L4:
        if (TextUtils.isEmpty(r100) == true) goto L7;
        r106.put("messageId", r100);     // Catch: JSONException -> L11
    L7:
        if (r110 < 0) goto L9;
        r106.put("duration", r110);     // Catch: JSONException -> L11
    L9:
        r106.put("action", r101);     // Catch: JSONException -> L11
        r106.put("mapSize", r102);     // Catch: JSONException -> L11
        r106.put("queueSize", r103);     // Catch: JSONException -> L11
        r106.put("totalCount", r104);     // Catch: JSONException -> L11
        r106.put(DBDefinition.TOTAL_BYTES, r105);     // Catch: JSONException -> L11
        goto L13
    }

    public static /* synthetic */ void access$200(FrontierPersistentBuffer r100, String r101, int r102, long r103) {
        r100.reportPersistentBufferLog(r101, r102, r103);
    }
}
