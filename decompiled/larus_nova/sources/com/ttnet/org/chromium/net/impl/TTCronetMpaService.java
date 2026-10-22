package com.ttnet.org.chromium.net.impl;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.TTMpaService;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@JNINamespace("cronet")
public final class TTCronetMpaService extends TTMpaService {
    private static final String TAG = null;
    private TTMpaService.ICallback mAccAddressCallback;
    private TTMpaService.ICallback mInitCallback;
    private long mMpaServiceAdapter;
    private final Object mMpaServiceAdapterLock;
    private CronetUrlRequestContext mRequestContext;

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeCommand(long r100, String r101, String r102);

    private native long nativeCreateMpaServiceAdapter(long r100);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeInit(long r100);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeSetAccAddress(long r100, String[] r101);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeStart(long r100);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeStop(long r100);

    static {
        TAG = "TTCronetMpaService";
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void start() {
        Object r100 = this.mMpaServiceAdapterLock;
        monitor-enter(r100);
        long r101 = this.mMpaServiceAdapter;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L8:
        nativeStart(r101);     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void stop() {
        Object r100 = this.mMpaServiceAdapterLock;
        monitor-enter(r100);
        long r101 = this.mMpaServiceAdapter;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L8:
        nativeStop(r101);     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public TTCronetMpaService(CronetUrlRequestContext r100) {
        this.mMpaServiceAdapterLock = new Object();
        this.mRequestContext = r100;
    }

    public static /* synthetic */ TTMpaService.ICallback access$000(TTCronetMpaService r100) {
        return r100.mInitCallback;
    }

    public static /* synthetic */ TTMpaService.ICallback access$200(TTCronetMpaService r100) {
        return r100.mAccAddressCallback;
    }

    private void postToSubThread(Runnable r100) {
        PthreadThreadV2 r101 = new PthreadThreadV2(r100, "TTCronetMpaService");
        ThreadMethodProxy.setName(r101, "TTCronetMpaService_Thread");
        ThreadMethodProxy.start(r101);
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void init(TTMpaService.ICallback r100) {
        Object r101 = this.mMpaServiceAdapterLock;
        monitor-enter(r101);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mMpaServiceAdapter != 0) goto L7;
        this.mMpaServiceAdapter = nativeCreateMpaServiceAdapter(this.mRequestContext.getUrlRequestContextAdapter());     // Catch: Throwable -> L10
    L7:
        this.mInitCallback = r100;     // Catch: Throwable -> L10
        nativeInit(this.mMpaServiceAdapter);     // Catch: Throwable -> L10
        monitor-exit(r101);     // Catch: Throwable -> L10
    }

    private void onInitFinish(final boolean r100, final String r101) {
        postToSubThread(new AnonymousClass1(this, r100, r101));
    }

    private void onSetAccAddressFinish(final boolean r100, final String r101) {
        postToSubThread(new AnonymousClass2(this, r100, r101));
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void command(String r100, String r101) {
        Object r102 = this.mMpaServiceAdapterLock;
        monitor-enter(r102);
        long r103 = this.mMpaServiceAdapter;     // Catch: Throwable -> L11
        if (r103 != 0) goto L8;
        monitor-exit(r102);     // Catch: Throwable -> L11
        return;
    L8:
        nativeCommand(r103, r100, r101);     // Catch: Throwable -> L11
        monitor-exit(r102);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ttnet.org.chromium.net.TTMpaService
    public void setAccAddress(List<String> r100, TTMpaService.ICallback r101) {
        Object r102 = this.mMpaServiceAdapterLock;
        monitor-enter(r102);
        long r103 = this.mMpaServiceAdapter;     // Catch: Throwable -> L11
        if (r103 != 0) goto L8;
        monitor-exit(r102);     // Catch: Throwable -> L11
        return;
    L8:
        this.mAccAddressCallback = r101;     // Catch: Throwable -> L11
        nativeSetAccAddress(r103, (String[]) r100.toArray(new String[r100.size()]));     // Catch: Throwable -> L11
        monitor-exit(r102);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
