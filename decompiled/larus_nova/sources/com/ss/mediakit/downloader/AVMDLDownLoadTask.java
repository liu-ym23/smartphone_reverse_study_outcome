package com.ss.mediakit.downloader;

import com.ss.mediakit.medialoader.AVMDLLog;
import com.ss.mediakit.net.AVMDLThreadPool;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes40.dex */
public class AVMDLDownLoadTask {
    public static final int IsHttpOpen = 0;
    public static final int IsHttpRead = 1;
    public static final int IsInValidStep = -1;
    public static final int IsReponseHeader = 0;
    public static final int IsResponseComplete = 3;
    public static final int IsResponseData = 1;
    public static final int IsResponseDownloadInterruptEnd = 5;
    public static final int IsResponseError = 2;
    public static final int IsResponseInfo = 4;
    private static final String TAG = "AVMDLDownLoadTask";
    private File file;
    FileOutputStream fos;
    private Future mFuture;
    private long mHandle;
    private Lock mHandleLock;
    private boolean mIsRunning;
    private AVMDLRequest mRequest;
    private Lock mResonseLock;
    private AVMDLResponse mResponse;
    private int mStep;

    private static native void _notifyLoadInfo(long r100, int r101, long r102, long r103, String r104);

    private static native int _onRecvData(long r100, byte[] r101, int r102);

    public static /* synthetic */ String a(int r100) {
        return lambda$httOpen$3(r100);
    }

    public static /* synthetic */ String b(long r100) {
        return lambda$cancelResponse$1(r100);
    }

    public static /* synthetic */ String c(long r100) {
        return lambda$setHandle$0(r100);
    }

    public static /* synthetic */ String d(int r100, int r101, int r102, int r103, String r104) {
        return lambda$httOpen$2(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ String e(int r100, long r101, long r102) {
        return lambda$notifyToNative$4(r100, r101, r102);
    }

    private void cancelResponse() {
        this.mResonseLock.lock();     // Catch: Throwable -> L8
        if (this.mResponse == null) goto L6;
        AVMDLLog.d(TAG, "start cancel response");     // Catch: Throwable -> L8
        final long r100 = System.currentTimeMillis();     // Catch: Throwable -> L8
        this.mResponse.cancel();     // Catch: Throwable -> L8
        AVMDLLog.d(TAG, new c(r100));     // Catch: Throwable -> L8
    L6:
        this.mResonseLock.unlock();
        return;
    L8:
        th = move-exception;
        this.mResonseLock.unlock();
        throw th;
    }

    public void close() {
        setHandle(0);
        this.mIsRunning = false;
        cancelResponse();
    }

    public AVMDLDownLoadTask() {
        this.mHandle = 0;
        this.mIsRunning = false;
        this.mStep = -1;
        this.mHandleLock = new ReentrantLock();
        this.mResonseLock = new ReentrantLock();
    }

    public static /* synthetic */ AVMDLRequest access$000(AVMDLDownLoadTask r100) {
        return r100.mRequest;
    }

    public static /* synthetic */ boolean access$100(AVMDLDownLoadTask r100) {
        return r100.mIsRunning;
    }

    public static /* synthetic */ int access$200(AVMDLDownLoadTask r100) {
        return r100.mStep;
    }

    private AVMDLResponse httOpen(AVMDLRequest r110) {
        AVMDLLog.d(TAG, "start http open, url:" + r110.urls[r110.mCurlUrlIndex] + "object:" + this + "handle:" + this.mHandle);
        int r100 = r110.mCurlUrlIndex;
        setResponse(null);
        final int r101 = r100;
    L4:
        if (AVMDLLog.isLogLevelEnabled(1) == false) goto L7;
        final int r102 = r110.mUrlState[r101];
        final int r103 = r110.mUrlErrCount[r101];
        final int r104 = r110.mMaxTryCout;
        final String r105 = r110.urls[r101];
        final int r106 = r101;
        AVMDLLog.d(TAG, new a(r106, r102, r103, r104, r105));
    L7:
        if (r110.mUrlState[r101] != 0) goto L28;
        int r107 = r110.mMaxTryCout;
        if (r107 > 0) goto L11;
    L32:
        AVMDLResponse r108 = AVMDLHttpExcutor.excute(r110, r101);     // Catch: IOException -> L14
    L16:
        if (r108 != null) goto L18;
    L21:
        int[] r109 = r110.mUrlErrCount;
        r109[r101] = r109[r101] + 1;
        if (r108 == null) goto L28;
        int r111 = r108.statusCode;
        if (r111 < 400) goto L28;
        if (r111 >= 600) goto L28;
        r110.mUrlState[r101] = 1;
        AVMDLLog.d(TAG, new b(r101));
        goto L28
    L18:
        if (r108.isOpenSuccessful() == false) goto L21;
        AVMDLLog.d(TAG, "http open suc");
        setResponse(r108);
        notifyToNative(0, r108.statusCode, r108.contentlength, null);
        AVMDLLog.d(TAG, "end http open");
        r108.request = r110;
        return r108;
    L14:
        e = move-exception;
        AVMDLLog.d(TAG, "io exception:" + e.getLocalizedMessage() + "for url:" + r110.urls[r101]);
        r108 = null;
        goto L16
    L11:
        if (r110.mUrlErrCount[r101] < r107) goto L32;
    L28:
        r101 = (r101 + 1) % r110.urls.length;
        if (r101 != r100) goto L4;
        AVMDLLog.d(TAG, "end http open");
        return null;
    }

    private static /* synthetic */ String lambda$cancelResponse$1(long r100) {
        return String.format(Locale.US, "end cancel cost time:%d", new Object[]{Long.valueOf(System.currentTimeMillis() - r100)});
    }

    private static /* synthetic */ String lambda$httOpen$3(int r100) {
        return String.format(Locale.US, "set url state forbidden index:%d", new Object[]{Integer.valueOf(r100)});
    }

    private static /* synthetic */ String lambda$setHandle$0(long r100) {
        return String.format(Locale.US, "set handle:%d", new Object[]{Long.valueOf(r100)});
    }

    private void setHandle(final long r100) {
        this.mHandleLock.lock();     // Catch: Throwable -> L5
        this.mHandle = r100;     // Catch: Throwable -> L5
        AVMDLLog.d(TAG, new d(r100));     // Catch: Throwable -> L5
        this.mHandleLock.unlock();
        return;
    L5:
        th = move-exception;
        this.mHandleLock.unlock();
        throw th;
    }

    private void setResponse(AVMDLResponse r100) {
        this.mResonseLock.lock();
        this.mResponse = r100;
        this.mResonseLock.unlock();
    }

    public static /* synthetic */ int access$202(AVMDLDownLoadTask r100, int r101) {
        r100.mStep = r101;
        return r101;
    }

    public static /* synthetic */ AVMDLResponse access$300(AVMDLDownLoadTask r100, AVMDLRequest r101) {
        return r100.httOpen(r101);
    }

    private AVMDLResponse httpRead(AVMDLResponse r100, byte[] r101) {
        int r102 = r100.readData(r101);
        if (r102 > 0) goto L12;
    L11:
        return r100;
    L12:
        this.mHandleLock.lock();     // Catch: Throwable -> L8
        long r103 = this.mHandle;     // Catch: Throwable -> L8
        if (r103 == 0) goto L7;
        _onRecvData(r103, r101, r102);     // Catch: Throwable -> L8
    L7:
        this.mHandleLock.unlock();
    L8:
        th = move-exception;
        this.mHandleLock.unlock();
        throw th;
    }

    public static /* synthetic */ AVMDLResponse access$400(AVMDLDownLoadTask r100, AVMDLResponse r101, byte[] r102) {
        return r100.httpRead(r101, r102);
    }

    private static /* synthetic */ String lambda$notifyToNative$4(int r100, long r101, long r102) {
        return String.format(Locale.US, "notify type:%d code:%d param:%d ", new Object[]{Integer.valueOf(r100), Long.valueOf(r101), Long.valueOf(r102)});
    }

    public void notifyToNative(final int r110, final long r111, final long r112, String r113) {
        AVMDLLog.d(TAG, new e(r110, r111, r112));
        this.mHandleLock.lock();     // Catch: Throwable -> L8
        long r100 = this.mHandle;     // Catch: Throwable -> L8
        if (r100 == 0) goto L6;
        _notifyLoadInfo(r100, r110, r111, r112, r113);     // Catch: Throwable -> L8
    L6:
        this.mHandleLock.unlock();
        return;
    L8:
        th = move-exception;
        this.mHandleLock.unlock();
        throw th;
    }

    private static /* synthetic */ String lambda$httOpen$2(int r100, int r101, int r102, int r103, String r104) {
        return String.format(Locale.US, "http open index:%d state:%d trycount:%d maxTry:%d", new Object[]{Integer.valueOf(r100), Integer.valueOf(r101), Integer.valueOf(r102), Integer.valueOf(r103)}) + " url:" + r104;
    }

    public int open(long r100, Object r101, Object r102, int r103, int r104, int r105) {
        if (r100 == 0) goto L15;
        if (r101 == null) goto L15;
        AVMDLRequest r106 = (AVMDLRequest) r101;
        String[] r107 = r106.urls;
        if (r107 != null) goto L9;
    L13:
        AVMDLLog.e(TAG, "no url err");
        return -2;
    L9:
        if (r107.length == 0) goto L13;
        this.mRequest = r106;
        setHandle(r100);
        this.mStep = 0;
        this.mIsRunning = true;
        this.mFuture = AVMDLThreadPool.addExecuteTask(new AnonymousClass1(this));
        return 0;
    L15:
        AVMDLLog.e(TAG, "handle zero err");
        return -1;
    }
}
