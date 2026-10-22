package com.bytedance.ttnet.diagnosis;

import com.bytedance.frameworks.baselib.network.http.cronet.diagnosis.ICronetDiagnosisRequest;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
class TTNetDiagnosisRequest implements IDiagnosisRequest {
    private static final String CRONET_DIAGNOSIS_REQUEST_IMPL_CLASS = "org.chromium.diagnosis.CronetDiagnosisRequestImpl";
    private static final String TAG = null;
    private IDiagnosisCallback mCallback;
    private boolean mCanceled;
    private ICronetDiagnosisRequest mCronetDiagnosisRequest;
    private ICronetDiagnosisRequest.Callback mCronetDiagnosisRequestCallback;
    private String mExtraInfo;
    private int mMultiNetAction;
    private int mNetDetectType;
    private int mReqType;
    private boolean mStarted;
    private List<String> mTargets;
    private int mTimeoutMs;

    public class CallbackImpl implements ICronetDiagnosisRequest.Callback {
        final /* synthetic */ TTNetDiagnosisRequest this$0;

        public CallbackImpl(TTNetDiagnosisRequest r100) {
            this.this$0 = r100;
        }

        @Override // com.bytedance.frameworks.baselib.network.http.cronet.diagnosis.ICronetDiagnosisRequest.Callback
        public void onNetDiagnosisRequestComplete(String r100) {
            if (TTNetDiagnosisRequest.access$000(this.this$0) == null) goto L6;
            TTNetDiagnosisRequest.access$000(this.this$0).onDiagnosisComplete(r100);
            return;
        }
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void cancel() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.mStarted == true) goto L6;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L6:
        if (this.mCanceled == true) goto L11;
        this.mCronetDiagnosisRequest.cancel();     // Catch: Throwable -> L13
        this.mCanceled = true;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
    }

    static {
        TAG = "TTNetDiagnosisRequest";
    }

    private void tryResolveCronetDiagnosisRequest() throws Exception {
        if (this.mCronetDiagnosisRequest != null) goto L11;
        Class<?> r100 = checkClass(CRONET_DIAGNOSIS_REQUEST_IMPL_CLASS);
        if (r100 == null) goto L10;
        Class<?> r101 = Integer.TYPE;
        Object r102 = r100.getDeclaredConstructor(new Class[]{ICronetDiagnosisRequest.Callback.class, r101, List.class, r101, r101, r101}).newInstance(new Object[]{this.mCronetDiagnosisRequestCallback, Integer.valueOf(this.mReqType), this.mTargets, Integer.valueOf(this.mNetDetectType), Integer.valueOf(this.mMultiNetAction), Integer.valueOf(this.mTimeoutMs)});
        if ((r102 instanceof ICronetDiagnosisRequest) == false) goto L12;
        this.mCronetDiagnosisRequest = (ICronetDiagnosisRequest) r102;
        return;
    L12:
        return;
    L10:
        throw new ClassNotFoundException("org.chromium.diagnosis.CronetDiagnosisRequestImpl class not found");
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_ttnet_diagnosis_TTNetDiagnosisRequest_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static /* synthetic */ IDiagnosisCallback access$000(TTNetDiagnosisRequest r100) {
        return r100.mCallback;
    }

    private Class<?> checkClass(String r100) {
        return INVOKESTATIC_com_bytedance_ttnet_diagnosis_TTNetDiagnosisRequest_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r100);
    L4:
        return null;
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void setUserExtraInfo(String r100) {
        monitor-enter(this);
        this.mExtraInfo = r100;     // Catch: Throwable -> L6
        doExtraCommand("extra_info", r100);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void start(IDiagnosisCallback r100) {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mStarted == false) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L7:
        this.mCallback = r100;     // Catch: Throwable -> L14
        this.mCronetDiagnosisRequest.start();     // Catch: Throwable -> L14
        this.mStarted = true;     // Catch: Throwable -> L14
        String r101 = this.mExtraInfo;     // Catch: Throwable -> L14
        if (r101 != null) goto L10;
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L10:
        if (r101.isEmpty() == true) goto L12;
        doExtraCommand("extra_info", this.mExtraInfo);     // Catch: Throwable -> L14
        goto L12
    }

    @Override // com.bytedance.ttnet.diagnosis.IDiagnosisRequest
    public void doExtraCommand(String r100, String r101) {
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L4:
        if (this.mStarted == true) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L7:
        this.mCronetDiagnosisRequest.doExtraCommand(r100, r101);     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
    }

    public TTNetDiagnosisRequest(int r100, List<String> r101, int r102, int r103, int r104) throws Exception {
        this.mCronetDiagnosisRequestCallback = new CallbackImpl(this);
        this.mStarted = false;
        this.mCanceled = false;
        this.mReqType = r100;
        this.mTargets = r101;
        this.mNetDetectType = r102;
        this.mMultiNetAction = r103;
        this.mTimeoutMs = r104;
        tryResolveCronetDiagnosisRequest();
    }
}
