package f37;

import com.bytedance.badger.BadgerCore;
import com.bytedance.badger.IBadger;
import com.bytedance.news.common.service.manager.IService;
import com.bytedance.news.common.settings.SettingsConfigProvider;
import com.bytedance.sdk.account.monitor.AccountMonitorDefaultConfigServiceImpl;
import com.bytedance.sdk.account.monitor.AccountSdkMonitorServiceImpl;
import com.bytedance.sdk.account.monitor.IAccountSdkMonitorService;
import com.bytedance.sdk.account.monitor.settings.IAccountMonitorDefaultConfigService;
import com.bytedance.sdk.account.settings.ISettingsGetter;
import com.bytedance.sdk.account.settings.SettingsGetterImpl;
import com.bytedance.sdk.bridge.api.BridgeService;
import com.bytedance.services.apm.api.ILaunchTrace;
import com.ivy.ivykit.plugin.impl.jsb.auth.LegacyBridgeService;
import com.larus.apm.impl.ILaunchTraceImpl;
import com.larus.settings.SettingsConfigProviderImpl;
import com.service.middleware.applog.ApplogService;
import com.ss.android.common.applog.ApplogServiceImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class b {
    public static IService a(Class r1) {
        if (r1 != BridgeService.class) goto L7;
        return new LegacyBridgeService();
    L7:
        if (r1 != IAccountSdkMonitorService.class) goto L11;
        return new AccountSdkMonitorServiceImpl();
    L11:
        if (r1 != IAccountMonitorDefaultConfigService.class) goto L15;
        return new AccountMonitorDefaultConfigServiceImpl();
    L15:
        if (r1 != ISettingsGetter.class) goto L19;
        return new SettingsGetterImpl();
    L19:
        if (r1 != ApplogService.class) goto L23;
        return new ApplogServiceImpl();
    L23:
        if (r1 != IBadger.class) goto L27;
        return new BadgerCore();
    L27:
        if (r1 != ILaunchTrace.class) goto L31;
        return new ILaunchTraceImpl();
    L31:
        if (r1 == SettingsConfigProvider.class) goto L33;
        return null;
    L33:
        return new SettingsConfigProviderImpl();
    }

    public static IService b(Class r3) {
        int r0 = r3.getName().hashCode();
        int r1 = (r0 ^ (r0 >>> 16)) & 511;
        if (r1 == 79) goto L55;
        if (r1 == 89) goto L50;
        if (r1 == 155) goto L45;
        if (r1 == 196) goto L40;
        if (r1 == 201) goto L35;
        if (r1 == 223) goto L30;
        if (r1 == 346) goto L25;
        if (r1 == 368) goto L20;
        return null;
    L20:
        if (r3 == IBadger.class) goto L22;
        return null;
    L22:
        return new BadgerCore();
    L25:
        if (r3 == BridgeService.class) goto L27;
        return null;
    L27:
        return new LegacyBridgeService();
    L30:
        if (r3 == ApplogService.class) goto L32;
        return null;
    L32:
        return new ApplogServiceImpl();
    L35:
        if (r3 == SettingsConfigProvider.class) goto L37;
        return null;
    L37:
        return new SettingsConfigProviderImpl();
    L40:
        if (r3 == ILaunchTrace.class) goto L42;
        return null;
    L42:
        return new ILaunchTraceImpl();
    L45:
        if (r3 == IAccountSdkMonitorService.class) goto L47;
        return null;
    L47:
        return new AccountSdkMonitorServiceImpl();
    L50:
        if (r3 == IAccountMonitorDefaultConfigService.class) goto L52;
        return null;
    L52:
        return new AccountMonitorDefaultConfigServiceImpl();
    L55:
        if (r3 == ISettingsGetter.class) goto L57;
        return null;
    L57:
        return new SettingsGetterImpl();
    }
}
