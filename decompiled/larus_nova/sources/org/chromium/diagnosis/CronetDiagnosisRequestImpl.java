package org.chromium.diagnosis;

import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.reflect.Reflect;
import com.bytedance.frameworks.baselib.network.http.cronet.diagnosis.ICronetDiagnosisRequest;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ttnet.org.chromium.net.CronetEngine;
import com.ttnet.org.chromium.net.TTNetDiagnosisRequest;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.chromium.CronetClient;

/* JADX INFO: loaded from: classes42.dex */
public class CronetDiagnosisRequestImpl implements ICronetDiagnosisRequest {
    private static final String TAG = null;
    private static final String TTNET_INIT_CLASS = "com.bytedance.ttnet.TTNetInit";
    private static CronetEngine sCronetEngine;
    private ICronetDiagnosisRequest.Callback mCallback;
    private a mCronetCallback;
    private TTNetDiagnosisRequest mRequest;

    public class a implements TTNetDiagnosisRequest.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CronetDiagnosisRequestImpl f525639a;

        public a(CronetDiagnosisRequestImpl r100) {
            this.f525639a = r100;
        }

        @Override // com.ttnet.org.chromium.net.TTNetDiagnosisRequest.Callback
        public final void onNetDiagnosisRequestComplete(TTNetDiagnosisRequest r100, String r101) {
            CronetDiagnosisRequestImpl.access$000(this.f525639a).onNetDiagnosisRequestComplete(r101);
        }
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        TAG = "CronetDiagnosisRequestImpl";
    }

    private static void loadCronetKernel() throws Exception {
        Reflect.on(INVOKESTATIC_org_chromium_diagnosis_CronetDiagnosisRequestImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(TTNET_INIT_CLASS).newInstance()).call("preInitCronetKernel");
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.diagnosis.ICronetDiagnosisRequest
    public void cancel() {
        TTNetDiagnosisRequest r100 = this.mRequest;
        if (r100 == null) goto L6;
        r100.cancel();
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.diagnosis.ICronetDiagnosisRequest
    public void start() {
        TTNetDiagnosisRequest r100 = this.mRequest;
        if (r100 == null) goto L6;
        r100.start();
        return;
    }

    private CronetEngine getCronetEngine() {
        if (Logger.debug() == false) goto L13;
        Logger.d(TAG, "Init cronet engine");
    L13:
        loadCronetKernel();     // Catch: Throwable -> L7
    L12:
        return CronetClient.getCronetEngine();
    L7:
        th = move-exception;
        th.printStackTrace();
        if (Logger.debug() == false) goto L12;
        Logger.d(TAG, "TTNet init failed, cronet engine is null.");
        goto L12
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_org_chromium_diagnosis_CronetDiagnosisRequestImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static /* synthetic */ ICronetDiagnosisRequest.Callback access$000(CronetDiagnosisRequestImpl r100) {
        return r100.mCallback;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.cronet.diagnosis.ICronetDiagnosisRequest
    public void doExtraCommand(String r100, String r101) {
        TTNetDiagnosisRequest r102 = this.mRequest;
        if (r102 == null) goto L6;
        r102.doExtraCommand(r100, r101);
        return;
    }

    public CronetDiagnosisRequestImpl(ICronetDiagnosisRequest.Callback r100, int r101, List<String> r102, int r103, int r104, int r105) throws Exception {
        this.mRequest = null;
        this.mCronetCallback = new a(this);
        this.mCallback = r100;
        if (sCronetEngine != null) goto L5;
        sCronetEngine = getCronetEngine();
    L5:
        CronetEngine r106 = sCronetEngine;
        if (r106 == null) goto L10;
        TTNetDiagnosisRequest.Builder r107 = r106.newNetDiagnosisRequestBuilder(this.mCronetCallback, null);
        r107.setRequestType(r101).setTargets(r102).setNetDetectType(r103).setMultiNetAction(r104).setTimeout(r105);
        this.mRequest = r107.build();
        return;
    L10:
        throw new UnsupportedOperationException("Can not get cronet engine.");
    }
}
