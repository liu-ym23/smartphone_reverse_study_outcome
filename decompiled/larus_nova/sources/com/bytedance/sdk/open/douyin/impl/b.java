package com.bytedance.sdk.open.douyin.impl;

import android.content.Context;
import android.widget.Toast;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sdk.open.aweme.core.OpenEventService;
import com.bytedance.sdk.open.aweme.core.OpenHostInfoService;
import com.bytedance.sdk.open.aweme.core.OpenHostSettingService;
import com.bytedance.sdk.open.aweme.core.OpenHostTicketService;
import com.bytedance.sdk.open.aweme.core.OpenImageService;
import com.bytedance.sdk.open.aweme.core.OpenLogService;
import com.bytedance.sdk.open.aweme.core.OpenNetworkService;
import com.bytedance.sdk.open.aweme.core.OpenOptionService;
import com.bytedance.sdk.open.aweme.core.OpenSdkTicketService;
import com.bytedance.sdk.open.aweme.core.OpenServiceManager;
import com.bytedance.sdk.open.aweme.core.impl.SystemOpenLogServiceImpl;
import com.bytedance.sdk.open.aweme.init.DouYinOpenSDKConfig;
import com.bytedance.sdk.open.aweme.init.DouYinSdkContext;
import com.bytedance.sdk.open.aweme.utils.LogUtils;
import com.bytedance.sdk.open.douyin.DouYinOpenConfig;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f269654a = "DouYinOpenSDKInit";

    public b() {
    }

    public static void a() {
        OpenSdkTicketService r100 = (OpenSdkTicketService) OpenServiceManager.getInst().getService(OpenSdkTicketService.class);
        if (r100 != null) goto L6;
        LogUtils.e(f269654a, new Object[]{"please implement OpenTicketService"});
        return;
    L6:
        r100.enableDefaultTicketGuard();
    }

    public static void a(DouYinOpenSDKConfig r100) {
        if (r100 == null) goto L35;
        Context r101 = r100.getContext().getApplicationContext();
        DouYinSdkContext.inst().setContext(r101);
        com.bytedance.sdk.open.douyin.a.init(new DouYinOpenConfig(r100.getClientKey()));
        DouYinSdkContext.inst().setClientKey(r100.getClientKey());
        DouYinSdkContext.inst().setUseClientTicket(r100.isUseClientTicket());
        if (r100.getLogService() == null) goto L6;
        OpenServiceManager r102 = OpenServiceManager.getInst();
        OpenLogService r103 = r100.getLogService();
    L7:
        r102.registerService(OpenLogService.class, r103);
        if (r100.getHostInfoService() == null) goto L11;
        OpenServiceManager.getInst().registerService(OpenHostInfoService.class, r100.getHostInfoService());
    L11:
        if (r100.getNetworkService() == null) goto L14;
        OpenServiceManager.getInst().registerService(OpenNetworkService.class, r100.getNetworkService());
    L14:
        if (r100.getEventService() == null) goto L17;
        OpenServiceManager.getInst().registerService(OpenEventService.class, r100.getEventService());
    L17:
        if (r100.getImageService() == null) goto L20;
        OpenServiceManager.getInst().registerService(OpenImageService.class, r100.getImageService());
    L20:
        if (r100.getOpenOptionService() == null) goto L22;
        OpenServiceManager.getInst().registerService(OpenOptionService.class, r100.getOpenOptionService());
    L22:
        b();
        if (r100.getHostTicketService() == null) goto L26;
        OpenServiceManager.getInst().registerService(OpenHostTicketService.class, r100.getHostTicketService());
    L31:
        if (r100.getHostSettingService() == null) goto L36;
        OpenServiceManager.getInst().registerService(OpenHostSettingService.class, r100.getHostSettingService());
        return;
    L36:
        return;
    L26:
        if (LogUtils.sDebuggable == false) goto L31;
        if (r100.isUseClientTicket() == false) goto L31;
        Toast.makeText(r101, "please implement OpenHostTicketService", 1).show();
        goto L31
    L6:
        r102 = OpenServiceManager.getInst();
        r103 = new SystemOpenLogServiceImpl();
        goto L7
    L35:
        throw new IllegalArgumentException("config不能为空");
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static void b() {
        OpenServiceManager.getInst().registerService(OpenSdkTicketService.class, (OpenSdkTicketService) INVOKESTATIC_com_bytedance_sdk_open_douyin_impl_b_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.sdk.open.aweme.openticket.OpenSdkTicketServiceImpl").newInstance());     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        LogUtils.e(f269654a, new Object[]{e});
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_sdk_open_douyin_impl_b_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
}
