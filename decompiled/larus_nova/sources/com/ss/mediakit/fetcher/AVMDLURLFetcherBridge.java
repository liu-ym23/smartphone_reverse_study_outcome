package com.ss.mediakit.fetcher;

import android.text.TextUtils;
import com.ss.mediakit.medialoader.AVMDLLog;
import java.util.Locale;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes40.dex */
public class AVMDLURLFetcherBridge implements AVMDLURLFetcherListener {
    private static final String TAG = "AVMDLURLFetcherBridge";
    private static AVMDLFetcherMakerInterface fetcherMaker = null;
    private static AVMDLNewFetcherMakerInterface newFetcherMaker = null;
    private static int sJniVersion = 2;
    public String engineId;
    private AVMDLURLFetcherInterface fetcherInstance;
    public String fileKey;
    private long handle;
    boolean isFinish;
    private Lock lock;
    String newURL;
    public String oldURL;
    public String rawKey;

    private static native void _notifyFetcherResult(long r100, String r101, String r102, String r103);

    private static native void _notifyFetcherResult(long r100, String r101, String r102, String r103, int r104);

    public static /* synthetic */ String a(Exception r100) {
        return lambda$start$0(r100);
    }

    public static /* synthetic */ String b(int r100) {
        return lambda$getNewUrl$4(r100);
    }

    public static /* synthetic */ String c(AVMDLURLFetcherBridge r100) {
        return r100.lambda$release$5();
    }

    public static /* synthetic */ String d(int r100) {
        return lambda$start$3(r100);
    }

    public static /* synthetic */ String e(AVMDLURLFetcherBridge r100) {
        return r100.lambda$release$7();
    }

    public static /* synthetic */ String f(AVMDLURLFetcherBridge r100) {
        return r100.lambda$release$6();
    }

    public static /* synthetic */ String g(int r100) {
        return lambda$start$1(r100);
    }

    public static /* synthetic */ String h(AVMDLURLFetcherBridge r100, int r101) {
        return r100.lambda$onCompletion$9(r101);
    }

    public static /* synthetic */ String i(Exception r100) {
        return lambda$start$2(r100);
    }

    public static /* synthetic */ String j(AVMDLURLFetcherBridge r100, int r101) {
        return r100.lambda$onCompletion$8(r101);
    }

    private /* synthetic */ String lambda$release$5() {
        return String.format(Locale.US, "----start release fetcher:%s", new Object[]{this});
    }

    private /* synthetic */ String lambda$release$6() {
        return String.format(Locale.US, "remove fetcher rawkey:%s, fileKey:%s", new Object[]{this.rawKey, this.fileKey});
    }

    private /* synthetic */ String lambda$release$7() {
        return String.format(Locale.US, "****end call release:%s", new Object[]{this});
    }

    public String getResult() {
        this.lock.lock();
        String r100 = this.newURL;     // Catch: Throwable -> L6
        this.lock.unlock();
        AVMDLLog.d(TAG, "****get result:" + r100);
        return r100;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public void release() {
        AVMDLLog.d(TAG, new c(this));
        this.lock.lock();
        this.handle = 0;     // Catch: Throwable -> L6
        this.lock.unlock();
        AVMDLLog.d(TAG, new d(this));
        AVMDLLog.d(TAG, new e(this));
        return;
    L6:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public AVMDLURLFetcherBridge() {
        this.rawKey = null;
        this.fileKey = null;
        this.oldURL = null;
        this.newURL = null;
        this.engineId = null;
        this.isFinish = false;
        this.lock = new ReentrantLock();
        this.handle = 0;
    }

    public boolean isFinish() {
        return this.isFinish;
    }

    private static /* synthetic */ String lambda$getNewUrl$4(int r100) {
        return String.format(Locale.US, "****end fail start ret:%d, but getURLs null", new Object[]{Integer.valueOf(r100)});
    }

    private /* synthetic */ String lambda$onCompletion$8(int r100) {
        return String.format(Locale.US, "receive completion code:%d result:%s", new Object[]{Integer.valueOf(r100), this.newURL});
    }

    private /* synthetic */ String lambda$onCompletion$9(int r100) {
        return String.format(Locale.US, "has fetch finished not need cur completion code:%d result:%s", new Object[]{Integer.valueOf(r100), this.newURL});
    }

    private static /* synthetic */ String lambda$start$0(Exception r100) {
        return String.format(Locale.US, "****call start failed, get exception: %s", new Object[]{r100.toString()});
    }

    private static /* synthetic */ String lambda$start$1(int r100) {
        return String.format(Locale.US, "****call start end, result:%d", new Object[]{Integer.valueOf(r100)});
    }

    private static /* synthetic */ String lambda$start$2(Exception r100) {
        return String.format(Locale.US, "****call start failed, get exception: %s", new Object[]{r100.toString()});
    }

    private static /* synthetic */ String lambda$start$3(int r100) {
        return String.format(Locale.US, "****call start end, result:%d", new Object[]{Integer.valueOf(r100)});
    }

    public static void setFetcherMaker(AVMDLFetcherMakerInterface r100) {
        if (r100 == null) goto L5;
        fetcherMaker = r100;
        return;
    }

    public static void setNewFetcherMaker(AVMDLNewFetcherMakerInterface r100) {
        if (r100 == null) goto L5;
        newFetcherMaker = r100;
        return;
    }

    public int getNewUrl(AVMDLURLFetcherInterface r110, String r111, String r112, String r113) {
        this.rawKey = r111;
        this.fileKey = r112;
        this.oldURL = r113;
        final int r114 = r110.start(r111, r112, r113, this);
        if (r114 <= 0) goto L22;
        String[] r115 = r110.getURLs();
        if (r115 != null) goto L7;
    L20:
        AVMDLLog.d(TAG, new h(r114));
        return -2;
    L7:
        if (r115.length == 0) goto L20;
        if (this.handle == 0) goto L25;
        this.newURL = r115[0];
        AVMDLLog.d(TAG, "start notify result");
        if (sJniVersion != 2) goto L17;
        _notifyFetcherResult(this.handle, r111, r112, r115[0], 1);     // Catch: UnsatisfiedLinkError -> L15
    L15:
        sJniVersion = 1;
    L17:
        if (sJniVersion != 1) goto L19;
        _notifyFetcherResult(this.handle, r111, r112, r115[0]);
    L19:
        AVMDLLog.d(TAG, "end notify result");
        return 1;
    L25:
        return 0;
    L22:
        return 0;
    }

    @Override // com.ss.mediakit.fetcher.AVMDLURLFetcherListener
    public void onCompletion(final int r110, String r111, String r112, String[] r113) {
        this.lock.lock();
    L25:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L5:
        if (this.isFinish == true) goto L22;
        if (r113 != null) goto L8;
    L10:
        AVMDLLog.d(TAG, new i(this, r110));     // Catch: Throwable -> L25
        this.isFinish = true;     // Catch: Throwable -> L25
        if (this.handle == 0) goto L23;
        AVMDLLog.d(TAG, "start notify result");     // Catch: Throwable -> L25
        if (sJniVersion != 2) goto L19;
        _notifyFetcherResult(this.handle, r111, r112, this.newURL, r110);     // Catch: UnsatisfiedLinkError -> L17 Throwable -> L25
    L17:
        sJniVersion = 1;     // Catch: Throwable -> L25
    L19:
        if (sJniVersion != 1) goto L21;
        _notifyFetcherResult(this.handle, r111, r112, this.newURL);     // Catch: Throwable -> L25
    L21:
        AVMDLLog.d(TAG, "end notify result");     // Catch: Throwable -> L25
    L23:
        this.lock.unlock();
        return;
    L8:
        if (r113.length <= 0) goto L10;
        this.newURL = r113[0];     // Catch: Throwable -> L25
        goto L10
    L22:
        AVMDLLog.d(TAG, new j(this, r110));     // Catch: Throwable -> L25
        goto L23
    }

    public int start(long r100, String r101, String r102, String r103) {
        AVMDLLog.d(TAG, "----old api fallback retry Jni");
        AVMDLLog.d(TAG, "----start fetch rawkey:" + r101);
        if (fetcherMaker != null) goto L5;
    L28:
        AVMDLLog.d(TAG, "****end fetch fail,fetcherMaker is null or rawky or filekey or originurl is null");
        return -1;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L28;
        if (TextUtils.isEmpty(r102) == true) goto L28;
        if (TextUtils.isEmpty(r103) == true) goto L28;
        AVMDLLog.d(TAG, "----old api fallback retry engine");
        this.lock.lock();
        this.handle = r100;
        AVMDLURLFetcherInterface r104 = fetcherMaker.getFetcher(r101, r102, r103);     // Catch: Throwable -> L19 Exception -> L21
        this.fetcherInstance = r104;     // Catch: Throwable -> L19 Exception -> L21
        if (r104 != null) goto L17;
        AVMDLLog.d(TAG, "****fail, get fetcher is null");     // Catch: Throwable -> L19 Exception -> L21
        this.lock.unlock();
        return -1;
    L17:
        final int r105 = getNewUrl(r104, r101, r102, r103);     // Catch: Throwable -> L19 Exception -> L21
        this.lock.unlock();
    L24:
        AVMDLLog.d(TAG, new b(r105));
        return r105;
    L21:
        e = move-exception;
        AVMDLLog.d(TAG, new a(e));     // Catch: Throwable -> L19
        this.lock.unlock();
        r105 = -999;
    L19:
        th = move-exception;
        this.lock.unlock();
        throw th;
    }

    public int start(long r100, String r101, String r102, String r103, String r104) {
        AVMDLLog.d(TAG, "----new api fallback retry Jni");
        AVMDLLog.d(TAG, "----start fetch rawkey:" + r101);
        AVMDLLog.d(TAG, "----start fetch engineID is:" + r104);
        if (newFetcherMaker == null) goto L31;
        AVMDLLog.d(TAG, "----new api fallback retry engine");
        if (TextUtils.isEmpty(r101) == false) goto L7;
    L29:
        AVMDLLog.d(TAG, "****end fetch fail,fetcherMaker is null or rawky or filekey or originurl or engineId is null");
        return -1;
    L7:
        if (TextUtils.isEmpty(r102) == true) goto L29;
        if (TextUtils.isEmpty(r103) == true) goto L29;
        if (TextUtils.isEmpty(r104) == true) goto L29;
        this.lock.lock();
        this.handle = r100;
        this.engineId = r104;     // Catch: Throwable -> L21 Exception -> L23
        AVMDLURLFetcherInterface r105 = newFetcherMaker.getFetcher(r101, r102, r103, r104);     // Catch: Throwable -> L21 Exception -> L23
        this.fetcherInstance = r105;     // Catch: Throwable -> L21 Exception -> L23
        if (r105 != null) goto L19;
        AVMDLLog.d(TAG, "****fail, get fetcher is null");     // Catch: Throwable -> L21 Exception -> L23
        this.lock.unlock();
        return -1;
    L19:
        final int r106 = getNewUrl(r105, r101, r102, r103);     // Catch: Throwable -> L21 Exception -> L23
        this.lock.unlock();
    L26:
        AVMDLLog.d(TAG, new g(r106));
        return r106;
    L21:
        th = move-exception;
        this.lock.unlock();
        throw th;
    L23:
        e = move-exception;
        AVMDLLog.d(TAG, new f(e));     // Catch: Throwable -> L21
        this.lock.unlock();
        r106 = -999;
        goto L26
    L31:
        AVMDLLog.d(TAG, "----old api fallback retry engine");
        return start(r100, r101, r102, r103);
    }
}
