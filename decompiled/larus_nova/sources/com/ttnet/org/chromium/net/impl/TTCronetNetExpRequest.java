package com.ttnet.org.chromium.net.impl;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import com.ttnet.org.chromium.base.Log;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes6.dex */
@JNINamespace("cronet")
public final class TTCronetNetExpRequest extends TTNetDiagnosisRequest {
    private static final String TAG = null;
    private final TTNetDiagnosisRequest.Callback mCallback;
    private Executor mExecutor;
    private int mMultiNetAction;
    private int mNetDetectActions;
    private long mNetDiagnosisRequestAdapter;
    private final Object mNetDiagnosisRequestAdapterLock;
    private CronetUrlRequestContext mRequestContext;
    private int mRequestType;
    private boolean mStarted;
    private List<String> mTargets;
    private int mTimeoutMs;

    /* JADX INFO: loaded from: classes41.dex */
    public interface Natives {
        long createRequestAdapter(TTCronetNetExpRequest r100, long r101, int r102, String[] r103, int r104, int r105, int r106);

        @NativeClassQualifiedName("TTCronetNetExpRequestAdapter")
        void destroy(long r100, TTCronetNetExpRequest r101);

        @NativeClassQualifiedName("TTCronetNetExpRequestAdapter")
        void doExtraCommand(long r100, TTCronetNetExpRequest r101, String r102, String r103);

        @NativeClassQualifiedName("TTCronetNetExpRequestAdapter")
        void start(long r100, TTCronetNetExpRequest r101);
    }

    static {
        TAG = "TTCronetNetExpRequest";
    }

    private void destroyRequestAdapterLocked() {
        if (this.mNetDiagnosisRequestAdapter != 0) goto L5;
        return;
    L5:
        TTCronetNetExpRequestJni.get().destroy(this.mNetDiagnosisRequestAdapter, this);
        this.mNetDiagnosisRequestAdapter = 0;
    }

    private boolean isDoneLocked() {
        if (this.mStarted == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mNetDiagnosisRequestAdapter != 0) goto L7;
        return true;
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest
    public void cancel() {
        Object r100 = this.mNetDiagnosisRequestAdapterLock;
        monitor-enter(r100);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L7;
    L12:
        monitor-exit(r100);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.mStarted == false) goto L12;
        destroyRequestAdapterLocked();     // Catch: Throwable -> L14
        monitor-exit(r100);     // Catch: Throwable -> L14
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest
    public void start() {
        Object r100 = this.mNetDiagnosisRequestAdapterLock;
        monitor-enter(r100);
    L15:
        th = move-exception;
        throw th;
    L5:
        if (this.mStarted == false) goto L8;
        monitor-exit(r100);     // Catch: Throwable -> L15
        return;
    L8:
        Natives r101 = TTCronetNetExpRequestJni.get();     // Catch: Throwable -> L15
        long r102 = this.mRequestContext.getUrlRequestContextAdapter();     // Catch: Throwable -> L15
        int r103 = this.mRequestType;     // Catch: Throwable -> L15
        List<String> r104 = this.mTargets;     // Catch: Throwable -> L15
        long r105 = r101.createRequestAdapter(this, r102, r103, (String[]) r104.toArray(new String[r104.size()]), this.mNetDetectActions, this.mMultiNetAction, this.mTimeoutMs);     // Catch: Throwable -> L15
        this.mNetDiagnosisRequestAdapter = r105;     // Catch: Throwable -> L15
        if (r105 == 0) goto L14;
        this.mStarted = true;     // Catch: Throwable -> L15
        TTCronetNetExpRequestJni.get().start(this.mNetDiagnosisRequestAdapter, this);     // Catch: Throwable -> L15
        monitor-exit(r100);     // Catch: Throwable -> L15
        return;
    L14:
        throw new NullPointerException("Create native net exp request adapter failed.");     // Catch: Throwable -> L15
    }

    public static /* synthetic */ String access$400() {
        return TAG;
    }

    public static /* synthetic */ Object access$000(TTCronetNetExpRequest r100) {
        return r100.mNetDiagnosisRequestAdapterLock;
    }

    public static /* synthetic */ boolean access$100(TTCronetNetExpRequest r100) {
        return r100.isDoneLocked();
    }

    public static /* synthetic */ void access$200(TTCronetNetExpRequest r100) {
        r100.destroyRequestAdapterLocked();
    }

    public static /* synthetic */ TTNetDiagnosisRequest.Callback access$300(TTCronetNetExpRequest r100) {
        return r100.mCallback;
    }

    private void postTaskToExecutor(Runnable r100) {
        Executor r101 = this.mExecutor;     // Catch: RejectedExecutionException -> L7
        if (r101 == null) goto L5;
        r101.execute(r100);     // Catch: RejectedExecutionException -> L7
    L10:
        return;
    L5:
        ThreadMethodProxy.start(new PthreadThreadV2(r100, "NetExpCallback"));     // Catch: RejectedExecutionException -> L7
    L7:
        e = move-exception;
        Log.e(TAG, "Exception posting task to executor", new Object[]{e});
    }

    private void onNetExpRequestComplete(final String r100, final boolean r101) {
        postTaskToExecutor(new AnonymousClass1(this, r101, r100));
    }

    @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest
    public void doExtraCommand(String r100, String r110) {
        Object r101 = this.mNetDiagnosisRequestAdapterLock;
        monitor-enter(r101);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (isDoneLocked() == false) goto L7;
    L12:
        monitor-exit(r101);     // Catch: Throwable -> L14
        return;
    L7:
        if (this.mStarted == false) goto L12;
        TTCronetNetExpRequestJni.get().doExtraCommand(this.mNetDiagnosisRequestAdapter, this, r100, r110);     // Catch: Throwable -> L14
        monitor-exit(r101);     // Catch: Throwable -> L14
    }

    public TTCronetNetExpRequest(CronetUrlRequestContext r100, TTNetDiagnosisRequest.Callback r101, Executor r102, int r103, List<String> r104, int r105, int r106, int r107) {
        this.mNetDiagnosisRequestAdapterLock = new Object();
        this.mRequestContext = r100;
        this.mCallback = r101;
        this.mExecutor = r102;
        this.mRequestType = r103;
        this.mTargets = r104;
        this.mNetDetectActions = r105;
        this.mMultiNetAction = r106;
        this.mTimeoutMs = r107;
    }
}
