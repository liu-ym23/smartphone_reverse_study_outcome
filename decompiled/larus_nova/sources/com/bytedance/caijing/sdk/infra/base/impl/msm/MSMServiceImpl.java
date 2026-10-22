package com.bytedance.caijing.sdk.infra.base.impl.msm;

import com.android.ttcjpaysdk.base.serverevent.mssdk.CJPayMSSDKConstant;
import com.bytedance.caijing.sdk.infra.base.api.msm.MSMService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mobsec.metasec.ml.MSManager;
import com.bytedance.mobsec.metasec.ml.MSManagerUtils;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\f\u001a\u00020\u0007H\u0016R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/caijing/sdk/infra/base/impl/msm/MSMServiceImpl;", "Lcom/bytedance/caijing/sdk/infra/base/api/msm/MSMService;", "", "sceneName", "aid", "", "report", "", "var0", "Lcom/bytedance/caijing/sdk/infra/base/api/msm/MSMService$a;", "callback", "registerScenePageNameCallback", "checkMSSDKInstalled", "Lcom/bytedance/mobsec/metasec/ml/MSManager;", "msManager", "Lcom/bytedance/mobsec/metasec/ml/MSManager;", "<init>", "()V", "cj-host-service-impl-msm_release"}, k = 1, mv = {1, 6, 0})
public final class MSMServiceImpl implements MSMService {
    private MSManager msManager;

    /* JADX INFO: loaded from: classes15.dex */
    public static final class a implements MSManagerUtils.ScenePageNameCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MSMService.a f202708a;

        public a(MSMService.a r100) {
            this.f202708a = r100;
        }

        @Override // com.bytedance.mobsec.metasec.ml.MSManagerUtils.ScenePageNameCallback
        public final int getScenePageName() {
            MSMService.a r100 = this.f202708a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.getScenePageName();
        }
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.msm.MSMService
    public int checkMSSDKInstalled() {
        INVOKESTATIC_com_bytedance_caijing_sdk_infra_base_impl_msm_MSMServiceImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(CJPayMSSDKConstant.TT_CJ_PAY_MSSDK_INSTALL_FLAG);     // Catch: Exception -> L5
        return 1;
    L5:
        return 0;
    }

    public MSMServiceImpl() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_caijing_sdk_infra_base_impl_msm_MSMServiceImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
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

    @Override // com.bytedance.caijing.sdk.infra.base.api.msm.MSMService
    public int registerScenePageNameCallback(int r100, MSMService.a r101) {
        return MSManagerUtils.registerScenePageNameCallback(r100, new a(r101));
    }

    @Override // com.bytedance.caijing.sdk.infra.base.api.msm.MSMService
    public void report(String r100, String r101) {
        if (this.msManager != null) goto L5;
        this.msManager = MSManagerUtils.get(r101);
    L5:
        MSManager r102 = this.msManager;
        if (r102 == null) goto L9;
        r102.report(r100);
        return;
    }
}
