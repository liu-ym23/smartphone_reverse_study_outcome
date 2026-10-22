package com.ss.android.cert.manager;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.cert.manager.api.ICertInitTask;
import el9.a;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes5.dex */
public class BytedCertSdk {
    private static final String ADAPTER_NAME = "com.ss.android.bytedcert.adapter.CertInitTaskAdapter";

    public BytedCertSdk() {
    }

    public static /* synthetic */ void a(BytedCertSdkInitParam.PluginParams r100, BytedCertSdkInitParam.PluginParams.PluginPreloadCallback r101, Map r102, BytedCertSdkInitParam.PluginParams.PluginType r103, BytedCertSdkInitParam.PluginParams.Status r104, String r105) {
        lambda$checkPluginReady$0(r100, r101, r102, r103, r104, r105);
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ss_android_cert_manager_BytedCertSdk_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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

    public static void init(BytedCertSdkInitParam r100) {
        BytedCertSdkManager.getInstance().init(r100);
    }

    public static void checkPluginReady(final Map<String, String> r100, final BytedCertSdkInitParam.PluginParams.PluginPreloadCallback r101) {
        if (CertManager.getInstance().isBytedCertReady() == false) goto L5;
        r101.onFinish(BytedCertSdkInitParam.PluginParams.PluginType.CERT, BytedCertSdkInitParam.PluginParams.Status.SUCCESS, null);
        return;
    L5:
        final BytedCertSdkInitParam.PluginParams r102 = BytedCertSdkManager.getInstance().getPluginParams();
        if (r102 == null) goto L17;
        BytedCertSdkInitParam.PluginParams.PluginPreloadCallback r103 = new dta.a(r102, r101, r100);
        BytedCertSdkInitParam.PluginParams.PluginType r104 = BytedCertSdkInitParam.PluginParams.PluginType.CERT;
        if (r102.isPluginLoaded(r104) == false) goto L10;
        r103.onFinish(r104, BytedCertSdkInitParam.PluginParams.Status.SUCCESS, "preload cert plugin success");
        return;
    L10:
        r102.tryPreloadPlugin(r100, r104, r103);
        return;
    L17:
        ((ICertInitTask) INVOKESTATIC_com_ss_android_cert_manager_BytedCertSdk_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(ADAPTER_NAME).newInstance()).init();     // Catch: Throwable -> L14
        checkPluginReady(r100, r101);
        return;
    L14:
        th = move-exception;
        th.printStackTrace();
        r101.onFinish(BytedCertSdkInitParam.PluginParams.PluginType.CERT, BytedCertSdkInitParam.PluginParams.Status.FAIL, "cert sdk init error:" + th.getMessage());
    }

    private static /* synthetic */ void lambda$checkPluginReady$0(BytedCertSdkInitParam.PluginParams r100, BytedCertSdkInitParam.PluginParams.PluginPreloadCallback r101, Map r102, BytedCertSdkInitParam.PluginParams.PluginType r103, BytedCertSdkInitParam.PluginParams.Status r104, String r105) {
        BytedCertSdkInitParam.PluginParams.Status r106 = BytedCertSdkInitParam.PluginParams.Status.SUCCESS;
        if (r104 != r106) goto L8;
        BytedCertSdkInitParam.PluginParams.PluginType r107 = BytedCertSdkInitParam.PluginParams.PluginType.ALIYUN;
        if (r100.isPluginLoaded(r107) == false) goto L7;
        r101.onFinish(r107, r106, "preload aliyun plugin success");
        return;
    L7:
        BytedCertSdkManager.getInstance().getPluginParams().tryPreloadPlugin(r102, r107, r101);
        return;
    L8:
        r101.onFinish(BytedCertSdkInitParam.PluginParams.PluginType.CERT, r104, r105);
    }
}
