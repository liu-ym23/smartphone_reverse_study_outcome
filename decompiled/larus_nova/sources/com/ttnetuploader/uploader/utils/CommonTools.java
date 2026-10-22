package com.ttnetuploader.uploader.utils;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.ugc.bytex.pthread.base.proxy.PThreadPoolExecutor;
import com.ttnetuploader.uploader.api.Parameters;
import com.ttnetuploader.uploader.api.ULLog;
import com.ttnetuploader.uploader.slice_task.Range;
import java.io.Closeable;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.zip.CRC32;
import kotlin.UByte;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public class CommonTools {
    private static final int FIXED_IO_POOL_SIZE = 0;
    static final char[] HEX_CHARS = null;
    public static final int HTTP_SUCCESS_MAX = 300;
    public static final int HTTP_SUCCESS_MIN = 200;
    static final int[] PORT_LIST = null;
    static final int SN_KEY_LEN = 10;
    private static volatile int s_taskConcurrencyMax;
    private static ExecutorService s_uploaderTaskExecutor;

    public CommonTools() {
    }

    public static String getNonnullStringValue(String r100) {
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100;
    }

    public static boolean isSuccess(int r100) {
        if (r100 >= 200) goto L5;
    L7:
        return false;
    L5:
        if (r100 >= 300) goto L7;
        return true;
    }

    static {
        HEX_CHARS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
        PORT_LIST = new int[]{22611, 32613, 62616};
        FIXED_IO_POOL_SIZE = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        s_uploaderTaskExecutor = null;
        s_taskConcurrencyMax = 0;
    }

    private static int getTaskConcurrencyMaxInternal() {
        if (s_taskConcurrencyMax <= 0) goto L6;
        return s_taskConcurrencyMax;
    L6:
        return FIXED_IO_POOL_SIZE;
    }

    public static ExecutorService getThreadExecutorService() {
        if (s_uploaderTaskExecutor != null) goto L20;
        monitor-enter(CommonTools.class);
    L16:
        th = move-exception;
        throw th;
    L7:
        if (s_uploaderTaskExecutor != null) goto L14;
        PThreadPoolExecutor r100 = new PThreadPoolExecutor(getTaskConcurrencyMaxInternal(), getTaskConcurrencyMaxInternal(), 15, TimeUnit.SECONDS, new LinkedBlockingQueue(), new DefaultThreadFactory("ttnet_uploader_thread_pool", true));     // Catch: Throwable -> L16
        r100.allowCoreThreadTimeOut(true);     // Catch: Throwable -> L11
    L13:
        s_uploaderTaskExecutor = r100;     // Catch: Throwable -> L16
        goto L14
    L11:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L16
    L14:
        monitor-exit(CommonTools.class);     // Catch: Throwable -> L16
    L20:
        return s_uploaderTaskExecutor;
    }

    public static boolean isMainThread() {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    public static long getCRC32(String r100) {
        CRC32 r101 = new CRC32();
        r101.update(r100.getBytes());
        return r101.getValue();
    }

    public static JSONObject getJsonFromString(String r100) {
        if (r100 != null) goto L10;
        return null;
    L10:
        return new JSONObject(r100);
    L7:
        e = move-exception;
        ULLog.e("error: " + e);
        return null;
    }

    public static String getLastStr(String r100) {
        int r101 = r100.lastIndexOf(HTTP.URL_DEFAULT);
        if (r101 != (-1)) goto L5;
        return r100;
    L5:
        return r100.substring(r101 + 1);
    }

    public static ArrayList<Range> getNeedRangeList(String r110) {
        ArrayList<Range> r100 = new ArrayList();
        if (r110.indexOf(",") != (-1)) goto L9;
        String[] r111 = r110.split("-");
        if (r111 != null) goto L7;
    L18:
        return r100;
    L7:
        if (r111.length != 2) goto L18;
        r100.add(new Range(CastLongProtector.parseLong(r111[0]), CastLongProtector.parseLong(r111[1])));
        goto L18
    L9:
        String[] r112 = r110.split(",");
        int r101 = 0;
    L11:
        if (r101 >= r112.length) goto L18;
        String[] r102 = r112[r101].split("-");
        if (r102 == null) goto L17;
        if (r102.length != 2) goto L17;
        r100.add(new Range(CastLongProtector.parseLong(r102[0]), CastLongProtector.parseLong(r102[1])));
    L17:
        r101 = r101 + 1;
        goto L11
    }

    public static int getPort(int r100) {
        int[] r101 = PORT_LIST;
        return r101[r100 % r101.length];
    }

    public static String getSNId(String r100) {
        if (r100 != null) goto L5;
    L13:
        return "";
    L5:
        if (r100.isEmpty() == true) goto L13;
        String r101 = md5HexStr(r100);
        if (r101 == null) goto L13;
        if (r101.length() < 10) goto L13;
        return r101.substring(0, 10);
    }

    public static long getUnuploadLen(ArrayList<Range> r100) {
        long r101 = 0;
        if (r100 != null) goto L5;
    L11:
        return r101;
    L5:
        if (r100.isEmpty() == true) goto L11;
        Iterator<Range> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L11;
        Range r103 = r102.next();
        r101 = r101 + ((r103.end - r103.start) + 1);
        goto L9
    }

    public static String getUrl(Parameters r100) {
        StringBuilder r101 = new StringBuilder("http");
        if (r100.getIsHttp() == false) goto L5;
        String r102 = "";
    L6:
        r101.append(r102);
        r101.append("://");
        r101.append(r100.getUrl());
        r101.append(":");
        r101.append(r100.getServerPort());
        return r101.toString();
    L5:
        r102 = "s";
        goto L6
    }

    public static String getWifiIpAddress(int r100) {
        return (r100 & 255) + "." + ((r100 >> 8) & 255) + "." + ((r100 >> 16) & 255) + "." + ((r100 >> 24) & 255);
    }

    public static boolean isDirExist(String r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        PolarisFileWrapper r101 = new PolarisFileWrapper(r100);
        if (r101.exists() == true) goto L8;
        return false;
    L8:
        if (r101.isDirectory() == false) goto L12;
        return true;
    L12:
        return false;
    }

    public static String md5HexStr(String r100) {
        if (r100 != null) goto L11;
    L9:
        return null;
    L11:
        if (r100.length() == 0) goto L9;
        MessageDigest r101 = MessageDigest.getInstance("MD5");     // Catch: Exception -> L10
        r101.update(r100.getBytes("UTF-8"));     // Catch: Exception -> L10
        return toHexString(r101.digest());
    }

    public static void safeClose(Closeable... r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.length;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L14;
        Closeable r103 = r100[r102];
        if (r103 == null) goto L13;
        r103.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.printStackTrace();
    L13:
        r102 = r102 + 1;
        goto L5
    }

    public static void setTaskConcurrencyMax(int r100) {
        s_taskConcurrencyMax = r100;
    }

    public static String toHexString(byte[] r100) {
        if (r100 == null) goto L6;
        return toHexString(r100, 0, r100.length);
    L6:
        throw new NullPointerException("bytes is null");
    }

    public static String md5Hex(String r100, Context r101) {
        InputStream r102 = null;
        MessageDigest r103 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L18 Exception -> L21
        if (r103 != null) goto L7;
        safeClose(new Closeable[]{null});
        return null;
    L7:
        InputStream r104 = UploadFileUtils.getFileInputStream(r100, r101);     // Catch: Throwable -> L18 Exception -> L21
    L25:
        byte[] r105 = new byte[8192];     // Catch: Throwable -> L16 Exception -> L24
    L10:
        int r106 = r104.read(r105, 0, 8192);     // Catch: Throwable -> L16 Exception -> L24
        if (r106 <= 0) goto L13;
        r103.update(r105, 0, r106);     // Catch: Throwable -> L16 Exception -> L24
        goto L10
    L13:
        String r107 = toHexString(r103.digest());     // Catch: Throwable -> L16 Exception -> L24
        safeClose(new Closeable[]{r104});
        return r107;
    L16:
        th = th;
        r102 = r104;
    L19:
        safeClose(new Closeable[]{r102});
        throw th;
    L22:
        safeClose(new Closeable[]{r104});
        return null;
    L21:
        r104 = null;
    L18:
        th = th;
        goto L19
    }

    public static <T> T getNonnullValue(Parameters r100, Function<Parameters, T> r101, T r102) {
        if (r100 != null) goto L5;
        return r102;
    L5:
        if (Build.VERSION.SDK_INT < 24) goto L7;
        T r103 = r101.apply(r100);
    L8:
        if (r103 != null) goto L10;
        return r102;
    L10:
        return r103;
    L7:
        r103 = null;
        goto L8
    }

    public static String toHexString(byte[] r100, int r110, int r111) {
        if (r100 == null) goto L14;
        if (r110 < 0) goto L12;
        if ((r110 + r111) > r100.length) goto L12;
        int r101 = r111 * 2;
        char[] r102 = new char[r101];
        int r103 = 0;
        int r104 = 0;
    L7:
        if (r103 >= r111) goto L10;
        int r105 = r100[r103 + r110] & UByte.MAX_VALUE;
        int r106 = r104 + 1;
        char[] r107 = HEX_CHARS;
        r102[r104] = r107[r105 >> 4];
        r104 = r106 + 1;
        r102[r106] = r107[r105 & 15];
        r103 = r103 + 1;
        goto L7
    L10:
        return new String(r102, 0, r101);
    L12:
        throw new IndexOutOfBoundsException();
    L14:
        throw new NullPointerException("bytes is null");
    }
}
