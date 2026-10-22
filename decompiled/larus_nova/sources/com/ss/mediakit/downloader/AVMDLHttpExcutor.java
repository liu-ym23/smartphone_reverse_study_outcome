package com.ss.mediakit.downloader;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import com.ss.mediakit.medialoader.AVMDLDataLoaderConfigure;
import com.ss.mediakit.medialoader.AVMDLLog;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: loaded from: classes40.dex */
public class AVMDLHttpExcutor {
    private static final String TAG = "AVMDLHttpExcutor";
    private static OkHttpClient okHttpClient;

    public AVMDLHttpExcutor() {
    }

    public static /* synthetic */ String a(long r100, long r101, AVMDLRequest r102, int r103) {
        return lambda$excute$0(r100, r101, r102, r103);
    }

    private static synchronized OkHttpClient getOkHttpClient() {
        monitor-enter(AVMDLHttpExcutor.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (okHttpClient != null) goto L18;
        AVMDLDataLoaderConfigure r100 = AVMDLDataLoader.getInstance().getConfig();     // Catch: Throwable -> L21
        long r101 = 10000;
        if (r100 == null) goto L16;
        int r102 = r100.mOpenTimeOut;     // Catch: Throwable -> L21
        if (r102 <= 0) goto L11;
        long r103 = r102 * 1000;     // Catch: Throwable -> L21
    L12:
        int r104 = r100.mRWTimeOut;     // Catch: Throwable -> L21
        if (r104 <= 0) goto L15;
        r101 = r104 * 1000;     // Catch: Throwable -> L21
    L15:
        long r105 = r101;
        r101 = r103;
        long r106 = r105;
    L17:
        AVMDLLog.d(TAG, "connect timeout:" + r101 + " rwtimeout:" + r106);     // Catch: Throwable -> L21
        OkHttpClient.Builder r107 = new OkHttpClient.Builder();     // Catch: Throwable -> L21
        r107.protocols(Collections.singletonList(Protocol.HTTP_1_1));     // Catch: Throwable -> L21
        TimeUnit r108 = TimeUnit.MILLISECONDS;     // Catch: Throwable -> L21
        r107.connectTimeout(r101, r108).readTimeout(r106, r108).writeTimeout(r106, r108);     // Catch: Throwable -> L21
        okHttpClient = r107.build();     // Catch: Throwable -> L21
        goto L18
    L11:
        r103 = 10000;
        goto L12
    L16:
        r106 = 10000;
    L18:
        OkHttpClient r109 = okHttpClient;     // Catch: Throwable -> L21
        monitor-exit(AVMDLHttpExcutor.class);
        return r109;
    }

    public static synchronized void setOkHttpClient(OkHttpClient r100) {
        monitor-enter(AVMDLHttpExcutor.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (okHttpClient != null) goto L7;
        okHttpClient = r100;     // Catch: Throwable -> L10
        AVMDLLog.d(TAG, "cur client null allow set");     // Catch: Throwable -> L10
    L7:
        AVMDLLog.d(TAG, "set custom client:" + r100);     // Catch: Throwable -> L10
        monitor-exit(AVMDLHttpExcutor.class);
    }

    private static Headers toOkHttpHeaders(AVMDLRequest r100) {
        Headers.Builder r101 = new Headers.Builder();
        HashMap<String, String> r102 = r100.headers;
        if (r102 == null) goto L8;
        Iterator<Map.Entry<String, String>> r103 = r102.entrySet().iterator();
    L6:
        if (r103.hasNext() == false) goto L8;
        Map.Entry<String, String> r104 = r103.next();
        AVMDLLog.d(TAG, "custom header key:" + r104.getKey() + "  value:" + r104.getValue());
        r101.add(r104.getKey(), r104.getValue());
    L8:
        String r105 = buildRangeHeader(r100.reqOff, r100.size);
        if (TextUtils.isEmpty(r105) == true) goto L11;
        AVMDLLog.d(TAG, "range str: " + r105);
        r101.add("Range", r105);
    L11:
        r101.add("Accept-Encoding", DownloadHelper.IDENTITY);
        return r101.build();
    }

    public static String buildRangeHeader(long r100, long r101) {
        String r102 = formRangeStrBySize(r100, r101);
        if (TextUtils.isEmpty(r102) == false) goto L6;
        return "";
    L6:
        return "bytes=" + r102;
    }

    public static AVMDLResponse excute(final AVMDLRequest r110, final int r111) throws IOException {
        Request.Builder r100 = new Request.Builder();
        r100.url(r110.urls[r111]);
        r100.method("GET", null);
        r100.headers(toOkHttpHeaders(r110));
        Call r101 = getOkHttpClient().newCall(r100.build());
        final long r102 = System.currentTimeMillis();     // Catch: Exception -> L5
        Response r103 = r101.execute();     // Catch: Exception -> L5
        final long r104 = System.currentTimeMillis();     // Catch: Exception -> L5
        r110.mCurlUrlIndex = r111;     // Catch: Exception -> L5
        AVMDLLog.d(TAG, new f(r104, r102, r110, r111));     // Catch: Exception -> L5
        return new AVMDLResponse(r110, r103, r101);
    L5:
        e = move-exception;
        AVMDLLog.e(TAG, "request exception is " + e.getLocalizedMessage());
        throw e;
    }

    public static String formRangeStrByPos(long r100, long r101) {
        if (r100 >= 0) goto L5;
    L8:
        if (r100 >= 0) goto L10;
        if (r100 < 0) goto L13;
        return "";
    L13:
        if (r101 > 0) goto L15;
        return "";
    L15:
        return "-" + r101;
    L10:
        return r100 + "-";
    L5:
        if (r101 <= 0) goto L8;
        return r100 + "-" + r101;
    }

    public static String formRangeStrBySize(long r100, long r101) {
        if (r101 <= 0) goto L5;
        long r102 = (r101 + r100) - 1;
    L7:
        return formRangeStrByPos(r100, r102);
    L5:
        r102 = -1;
        goto L7
    }

    private static /* synthetic */ String lambda$excute$0(long r100, long r101, AVMDLRequest r102, int r103) {
        return String.format(Locale.US, "http open cost time:%d url:%s", new Object[]{Long.valueOf(r100 - r101), r102.urls[r103]});
    }
}
