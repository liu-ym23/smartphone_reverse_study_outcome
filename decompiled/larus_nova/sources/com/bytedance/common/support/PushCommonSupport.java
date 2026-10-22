package com.bytedance.common.support;

import com.bytedance.common.push.interfaze.IPushCommonConfiguration;
import com.bytedance.common.support.impl.PushCommonParamService;
import com.bytedance.common.support.impl.PushConfigurationService;
import com.bytedance.common.support.impl.SecurityService;
import com.bytedance.common.support.service.IPushCommonParamService;
import com.bytedance.common.support.service.IPushConfigurationService;
import com.bytedance.common.support.service.ISecurityService;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.push.utils.f;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import z67.a;
import z67.b;

/* JADX INFO: loaded from: classes3.dex */
public class PushCommonSupport implements IPushCommonSupport {
    private static volatile IPushCommonParamService pushCommonParamService;
    private static IPushCommonSupport pushCommonSupport;
    private static volatile IPushConfigurationService pushConfigurationService;
    private static volatile ISecurityService securityService;
    private volatile b pushSdkMonitorService;

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    public static IPushCommonSupport getInstance() {
        if (pushCommonSupport != null) goto L15;
        monitor-enter(PushCommonSupport.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (pushCommonSupport != null) goto L9;
        pushCommonSupport = new PushCommonSupport();     // Catch: Throwable -> L11
    L9:
        monitor-exit(PushCommonSupport.class);     // Catch: Throwable -> L11
    L15:
        return pushCommonSupport;
    }

    @Override // com.bytedance.common.support.IPushCommonSupport
    public b getICommonPushSdkMonitorService() {
        if (this.pushSdkMonitorService != null) goto L17;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L6:
        if (this.pushSdkMonitorService == null) goto L18;
    L11:
        monitor-exit(this);     // Catch: Throwable -> L13
        goto L17
    L18:
        Object r100 = INVOKESTATIC_com_bytedance_common_support_PushCommonSupport_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.android.service.manager.PushServiceManager").getMethod(MonitorConstants.CONNECT_TYPE_GET, new Class[0]).invoke(null, new Object[0]);     // Catch: Throwable -> L9
        Object r101 = r100.getClass().getMethod("getPushExternalService", new Class[0]).invoke(r100, new Object[0]);     // Catch: Throwable -> L9
        this.pushSdkMonitorService = (b) r101.getClass().getMethod("getPushSdkMonitorService", new Class[0]).invoke(r101, new Object[0]);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L13
        f.e("PushCommonSupport", "error when getPushSdkMonitorService,use default");     // Catch: Throwable -> L13
        this.pushSdkMonitorService = new a();     // Catch: Throwable -> L13
    L17:
        return this.pushSdkMonitorService;
    }

    @Override // com.bytedance.common.support.IPushCommonSupport
    public IPushCommonParamService getPushCommonParamService() {
        if (pushCommonParamService != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (pushCommonParamService != null) goto L8;
        pushCommonParamService = new PushCommonParamService();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return pushCommonParamService;
    }

    @Override // com.bytedance.common.support.IPushCommonSupport
    public IPushConfigurationService getPushConfigurationService() {
        if (pushConfigurationService != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (pushConfigurationService != null) goto L8;
        pushConfigurationService = new PushConfigurationService();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return pushConfigurationService;
    }

    @Override // com.bytedance.common.support.IPushCommonSupport
    public ISecurityService getSecurityService() {
        if (securityService != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (securityService != null) goto L8;
        securityService = new SecurityService();     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return securityService;
    }

    @Override // com.bytedance.common.support.IPushCommonSupport
    public IPushCommonConfiguration getIPushCommonConfiguration() {
        return getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration;
    }

    private PushCommonSupport() {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_common_support_PushCommonSupport_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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
