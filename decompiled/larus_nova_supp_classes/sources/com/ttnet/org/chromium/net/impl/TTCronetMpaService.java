package com.ttnet.org.chromium.net.impl;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.TTMpaService;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@JNINamespace("cronet")
public final class TTCronetMpaService extends TTMpaService {
    private static final String TAG = null;
    private TTMpaService.ICallback mAccAddressCallback;
    private TTMpaService.ICallback mInitCallback;
    private long mMpaServiceAdapter;
    private final Object mMpaServiceAdapterLock;
    private CronetUrlRequestContext mRequestContext;

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeCommand(long r1, String r3, String r4);

    private native long nativeCreateMpaServiceAdapter(long r1);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeInit(long r1);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeSetAccAddress(long r1, String[] r3);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeStart(long r1);

    @NativeClassQualifiedName("TTCronetMpaServiceAdapter")
    private native void nativeStop(long r1);

    static {
        TAG = "TTCronetMpaService";
    }

    public void start() {
        Object r0 = this.mMpaServiceAdapterLock;
        monitor-enter(r0);
        long r1 = this.mMpaServiceAdapter;     // Catch: Throwable -> L11
        if (r1 != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        nativeStart(r1);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void stop() {
        Object r0 = this.mMpaServiceAdapterLock;
        monitor-enter(r0);
        long r1 = this.mMpaServiceAdapter;     // Catch: Throwable -> L11
        if (r1 != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        nativeStop(r1);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public TTCronetMpaService(CronetUrlRequestContext r2) {
        this.mMpaServiceAdapterLock = new Object();
        this.mRequestContext = r2;
    }

    public static /* synthetic */ TTMpaService.ICallback access$000(TTCronetMpaService r0) {
        return r0.mInitCallback;
    }

    public static /* synthetic */ TTMpaService.ICallback access$200(TTCronetMpaService r0) {
        return r0.mAccAddressCallback;
    }

    private void postToSubThread(Runnable r3) {
        PthreadThreadV2 r0 = new PthreadThreadV2(r3, "TTCronetMpaService");
        ThreadMethodProxy.setName(r0, "TTCronetMpaService_Thread");
        ThreadMethodProxy.start(r0);
    }

    public void init(TTMpaService.ICallback r7) {
        Object r0 = this.mMpaServiceAdapterLock;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mMpaServiceAdapter != 0) goto L7;
        this.mMpaServiceAdapter = nativeCreateMpaServiceAdapter(this.mRequestContext.getUrlRequestContextAdapter());     // Catch: Throwable -> L10
    L7:
        this.mInitCallback = r7;     // Catch: Throwable -> L10
        nativeInit(this.mMpaServiceAdapter);     // Catch: Throwable -> L10
        monitor-exit(r0);     // Catch: Throwable -> L10
    }

    private void onInitFinish(boolean r2, String r3) {
        postToSubThread(new 1(this, r2, r3));
    }

    private void onSetAccAddressFinish(boolean r2, String r3) {
        postToSubThread(new 2(this, r2, r3));
    }

    public void command(String r7, String r8) {
        Object r0 = this.mMpaServiceAdapterLock;
        monitor-enter(r0);
        long r1 = this.mMpaServiceAdapter;     // Catch: Throwable -> L11
        if (r1 != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        nativeCommand(r1, r7, r8);     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void setAccAddress(List<String> r7, TTMpaService.ICallback r8) {
        Object r0 = this.mMpaServiceAdapterLock;
        monitor-enter(r0);
        long r1 = this.mMpaServiceAdapter;     // Catch: Throwable -> L11
        if (r1 != 0) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L8:
        this.mAccAddressCallback = r8;     // Catch: Throwable -> L11
        nativeSetAccAddress(r1, (String[]) r7.toArray(new String[r7.size()]));     // Catch: Throwable -> L11
        monitor-exit(r0);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }
}
