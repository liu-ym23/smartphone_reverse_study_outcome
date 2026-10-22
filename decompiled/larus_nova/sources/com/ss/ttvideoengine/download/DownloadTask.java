package com.ss.ttvideoengine.download;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.bytedance.sdk.account.platform.api.ITwitterService;
import com.larus.avlink.aiproactive.AiProactiveTaskViewModel;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import com.ss.ttvideoengine.utils.EngineThreadPool;
import com.ss.ttvideoengine.utils.Error;
import com.ss.ttvideoengine.utils.TTHelper;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
public class DownloadTask {
    public static final int DOWNLOAD_TASK_STATE_CANCELING = 4;
    public static final int DOWNLOAD_TASK_STATE_COMPLETED = 5;
    public static final int DOWNLOAD_TASK_STATE_INIT = 0;
    public static final int DOWNLOAD_TASK_STATE_RUNNING = 2;
    public static final int DOWNLOAD_TASK_STATE_SUSPENDED = 3;
    public static final int DOWNLOAD_TASK_STATE_WAITING = 1;
    public static final int MESSAGE_CANCEL = 111;
    public static final int MESSAGE_FINISHED = 113;
    public static final int MESSAGE_RECEIVE_ERROR = 112;
    private static final String TAG = "TTVideoEngine.DownloadTask";
    protected String authToken;
    protected String availableLocalFilePath;
    protected long bytesExpectedToReceive;
    protected HashMap<String, Long> bytesExpectedToReceiveMap;
    protected long bytesReceived;
    protected HashMap<String, Long> bytesReceivedMap;
    protected boolean canceled;
    protected String customDir;
    protected Downloader downloader;
    protected EncryptVersion encryptVersion;
    protected Error error;
    protected boolean finished;
    protected boolean mFirstResumeCallback;
    protected Handler mHandler;
    protected MediaType mMediaType;
    protected int mUseOriginalUrlEncode;
    protected ArrayList<String> mediaKeys;
    private int state;
    protected String taskDescription;
    protected long taskIdentifier;
    protected String taskType;
    protected long updateBytesReceived;
    protected long updateTs;
    protected HashMap<String, List<String>> usingUrls;
    protected String videoId;

    public static final enum EncryptVersion extends Enum<EncryptVersion> {
        private static final /* synthetic */ EncryptVersion[] $VALUES = null;
        public static final EncryptVersion MDL_VERSION_1 = null;
        public static final EncryptVersion NONE = null;
        private int version;

        static {
            EncryptVersion r100 = new EncryptVersion(UserProfileEvent.POSITION_NONE, 0, 0);
            NONE = r100;
            EncryptVersion r101 = new EncryptVersion("MDL_VERSION_1", 1, 1);
            MDL_VERSION_1 = r101;
            $VALUES = new EncryptVersion[]{r100, r101};
        }

        public static EncryptVersion[] values() {
            return (EncryptVersion[]) $VALUES.clone();
        }

        public int getVersion() {
            return this.version;
        }

        public static EncryptVersion valueOf(String r100) {
            return (EncryptVersion) a.a(EncryptVersion.class, r100);
        }

        private EncryptVersion(String r100, int r101, int r102) {
            super(r100, r101);
            this.version = r102;
        }
    }

    public static final enum MediaType extends Enum<MediaType> {
        private static final /* synthetic */ MediaType[] $VALUES = null;
        public static final MediaType M3u8 = null;
        public static final MediaType Other = null;
        public static final MediaType Unknown = null;

        static {
            MediaType r100 = new MediaType("Unknown", 0);
            Unknown = r100;
            MediaType r101 = new MediaType("M3u8", 1);
            M3u8 = r101;
            MediaType r102 = new MediaType("Other", 2);
            Other = r102;
            $VALUES = new MediaType[]{r100, r101, r102};
        }

        public static MediaType[] values() {
            return (MediaType[]) $VALUES.clone();
        }

        public static MediaType valueOf(String r100) {
            return (MediaType) a.a(MediaType.class, r100);
        }

        private MediaType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public void downloadEnd() {
        this.error = null;
        setState(5);
        Downloader r100 = this.downloader;
        if (r100 == null) goto L6;
        r100.completeError(this, null);
        return;
    }

    public String getVideoId() {
        return null;
    }

    public void suspend() {
        setState(3);
    }

    public void initHandle() {
        if (this.mHandler == null) goto L5;
        return;
    L5:
        final Looper r100 = TTHelper.getLooper();
        this.mHandler = new AnonymousClass2(this, r100, this);
    }

    public void invalidateAndCancel() {
        StringBuilder r100 = new StringBuilder("[downloader] did call invalidateAndCancel, key = ");
        ArrayList<String> r101 = this.mediaKeys;
        if (r101 == null) goto L5;
        String r102 = r101.toString();
    L6:
        r100.append(r102);
        TTVideoEngineLog.d(TAG, r100.toString());
        if (this.canceled == false) goto L10;
        TTVideoEngineLog.d(TAG, "[downloader] task did canceled, self.taskIdentifier = " + this.taskIdentifier);
        return;
    L10:
        this.canceled = true;
        this.finished = false;
        setState(4);
        initHandle();
        final ArrayList<String> r103 = this.mediaKeys;
        EngineThreadPool.addExecuteTask(new AnonymousClass1(this, r103));
        return;
    L5:
        r102 = null;
        goto L6
    }

    public JSONObject jsonObject() {
        return new JSONObject(mapInfo());
    }

    public Map mapInfo() {
        HashMap r100 = new HashMap();
        putToMap(r100, "id", this.taskIdentifier);
        putToMap(r100, "des", this.taskDescription);
        putToMap(r100, "res_size", this.bytesReceived);
        putToMap(r100, "content_size", this.bytesExpectedToReceive);
        putToMap(r100, "state", this.state);
        Error r101 = this.error;
        if (r101 == null) goto L5;
        putToMap(r100, "error", r101.toMap());
    L5:
        putToMap(r100, "file_path", this.availableLocalFilePath);
        putToMap(r100, "media_keys", this.mediaKeys);
        putToMap(r100, "use_urls", this.usingUrls);
        putToMap(r100, VideoEventOneOutSync.END_TYPE_FINISH, this.finished);
        putToMap(r100, "cancel", this.canceled);
        putToMap(r100, AiProactiveTaskViewModel.PARAM_TASK_TYPE, this.taskType);
        putToMap(r100, "vid", this.videoId);
        putToMap(r100, ITwitterService.ResponseConstants.AUTH_TOKEN, this.authToken);
        putToMap(r100, "bytes_rec_map", this.bytesReceivedMap);
        putToMap(r100, "bytes_expect_map", this.bytesExpectedToReceiveMap);
        putToMap(r100, "encrypt_version", this.encryptVersion.getVersion());
        if (TextUtils.isEmpty(this.customDir) == true) goto L8;
        putToMap(r100, "custom_dir", this.customDir);
    L8:
        return r100;
    }

    public void setupBaseFiled() {
        this.taskIdentifier = -1;
        this.taskType = "base_task";
        this.bytesReceived = 0;
        this.bytesExpectedToReceive = 0;
        this.state = 0;
        this.error = null;
        this.availableLocalFilePath = null;
        this.mediaKeys = new ArrayList();
        this.usingUrls = null;
        this.finished = false;
        this.videoId = null;
        this.updateTs = 0;
        this.bytesReceivedMap = new HashMap();
        this.bytesExpectedToReceiveMap = new HashMap();
    }

    public String toString() {
        return super.toString() + "   id = " + this.taskIdentifier + ", state = " + this.state + ",  videoId " + this.videoId;
    }

    public DownloadTask() {
        this.taskDescription = null;
        this.taskIdentifier = -1;
        this.taskType = "base_task";
        this.bytesReceived = 0;
        this.bytesExpectedToReceive = 0;
        this.state = 0;
        this.error = null;
        this.availableLocalFilePath = null;
        this.mediaKeys = null;
        this.usingUrls = null;
        this.finished = false;
        this.canceled = false;
        this.videoId = null;
        this.mUseOriginalUrlEncode = -1;
        this.authToken = null;
        this.downloader = null;
        this.updateTs = 0;
        this.updateBytesReceived = 0;
        this.bytesReceivedMap = null;
        this.bytesExpectedToReceiveMap = null;
        this.mHandler = null;
        this.encryptVersion = EncryptVersion.NONE;
        this.customDir = null;
        this.mMediaType = MediaType.Unknown;
    }

    public void resume() {
        initHandle();
        this.error = null;
        this.finished = false;
        this.updateTs = System.currentTimeMillis();
    }

    public String getAvailableLocalFilePath() {
        return this.availableLocalFilePath;
    }

    public long getBytesExpectedToReceive() {
        return this.bytesExpectedToReceive;
    }

    public long getBytesReceived() {
        return this.bytesReceived;
    }

    public String getCustomDir() {
        return this.customDir;
    }

    public Error getError() {
        return this.error;
    }

    public MediaType getMediaType() {
        return this.mMediaType;
    }

    public int getState() {
        return this.state;
    }

    public String getTaskDescription() {
        return this.taskDescription;
    }

    public int getUseOriginalUrlEncode() {
        return this.mUseOriginalUrlEncode;
    }

    public boolean _shouldRetry(Error r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        int r101 = r100.code;
        if (r101 != (-9995)) goto L8;
    L18:
        return false;
    L8:
        if (r101 == (-9948)) goto L18;
        if (r101 == (-9949)) goto L18;
        if (r101 == (-9947)) goto L18;
        if (r101 == (-9946)) goto L18;
        return true;
    }

    public void assignWithJson(JSONObject r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        this.taskIdentifier = r100.optLong("id");
        this.taskDescription = r100.optString("des");
        long r101 = r100.optLong("res_size");
        this.bytesReceived = r101;
        this.updateBytesReceived = r101;
        this.bytesExpectedToReceive = r100.optLong("content_size");
        this.state = r100.optInt("state");
        this.error = TTHelper.errorWithJson(r100.optJSONObject("error"));
        this.availableLocalFilePath = r100.optString("file_path");
        this.customDir = r100.optString("custom_dir");
        JSONArray r102 = r100.optJSONArray("media_keys");
        if (r102 != null) goto L7;
    L15:
        this.mediaKeys = new ArrayList();
    L16:
        this.finished = r100.optBoolean(VideoEventOneOutSync.END_TYPE_FINISH);
        this.canceled = r100.optBoolean("cancel");
        this.taskType = r100.optString(AiProactiveTaskViewModel.PARAM_TASK_TYPE);
        this.videoId = r100.optString("vid");
        this.authToken = r100.optString(ITwitterService.ResponseConstants.AUTH_TOKEN);
        if (r100.optInt("encrypt_version", 0) != 1) goto L19;
        this.encryptVersion = EncryptVersion.MDL_VERSION_1;
    L20:
        JSONObject r103 = r100.optJSONObject("bytes_rec_map");
        if (r103 != null) goto L23;
    L28:
        JSONObject r104 = r100.optJSONObject("bytes_expect_map");
        if (r104 != null) goto L31;
        return;
    L31:
        if (r104.length() <= 0) goto L42;
        Iterator<String> r105 = r104.keys();
    L34:
        if (r105.hasNext() == false) goto L43;
        String r106 = r105.next();
        this.bytesExpectedToReceiveMap.put(r106, Long.valueOf(r104.optLong(r106)));
        goto L34
    L43:
        return;
    L42:
        return;
    L23:
        if (r103.length() <= 0) goto L28;
        Iterator<String> r107 = r103.keys();
    L26:
        if (r107.hasNext() == false) goto L28;
        String r108 = r107.next();
        this.bytesReceivedMap.put(r108, Long.valueOf(r103.optLong(r108)));
        goto L26
    L19:
        this.encryptVersion = EncryptVersion.NONE;
        goto L20
    L7:
        if (r102.length() <= 0) goto L15;
        this.mediaKeys = new ArrayList();
        int r109 = 0;
    L10:
        if (r109 >= r102.length()) goto L16;
        String r110 = r102.optString(r109);
        if (TextUtils.isEmpty(r110) == true) goto L14;
        this.mediaKeys.add(r110);
    L14:
        r109 = r109 + 1;
        goto L10
    }

    public void receiveError(Error r100) {
        initHandle();
        Handler r101 = this.mHandler;
        if (r101 == null) goto L6;
        r101.sendMessage(Message.obtain(r101, 112, r100));
        return;
    }

    public void setCustomDir(String r100) {
        if (TextUtils.isEmpty(this.customDir) == true) goto L5;
        return;
    L5:
        this.customDir = r100;
    }

    public void setDownloader(Downloader r100) {
        this.downloader = r100;
    }

    public void setState(int r100) {
        if (r100 == this.state) goto L14;
        this.state = r100;
        StringBuilder r101 = new StringBuilder("[downloader] state did changed. state = ");
        r101.append(r100);
        r101.append(" key = ");
        ArrayList<String> r102 = this.mediaKeys;
        if (r102 == null) goto L7;
        String r103 = r102.toString();
    L8:
        r101.append(r103);
        TTVideoEngineLog.d(TAG, r101.toString());
        Downloader r104 = this.downloader;
        if (r104 != null) goto L11;
        return;
    L11:
        if (r104.getListener() == null) goto L16;
        TTVideoEngineLog.d(TAG, "[downloader] state did changed. and notify downloader state = " + r100);
        this.downloader.getListener().downloaderStateChanged(this.downloader, this, r100);
        return;
    L16:
        return;
    L7:
        r103 = null;
        goto L8
    }

    public void setTaskDescription(String r100) {
        this.taskDescription = r100;
    }

    public void setUseOriginalUrlEncode(int r100) {
        this.mUseOriginalUrlEncode = r100;
    }

    public static void putToMap(Map r100, String r101, ArrayList r102) {
        if (r102 != null) goto L4;
        return;
    L4:
        if (r102.isEmpty() == true) goto L8;
        r100.put(r101, r102);
        return;
    }

    public static void putToMap(Map r100, String r101, Map r102) {
        if (r102 != null) goto L4;
        return;
    L4:
        if (r102.isEmpty() == true) goto L8;
        r100.put(r101, r102);
        return;
    }

    public static void putToMap(Map r100, String r101, String r102) {
        if (TextUtils.isEmpty(r102) == true) goto L6;
        r100.put(r101, r102);
        return;
    }

    public static void putToMap(Map r100, String r101, int r102) {
        r100.put(r101, Integer.valueOf(r102));
    }

    public static void putToMap(Map r100, String r101, long r102) {
        r100.put(r101, Long.valueOf(r102));
    }

    public static void putToMap(Map r100, String r101, boolean r102) {
        r100.put(r101, Boolean.valueOf(r102));
    }
}
