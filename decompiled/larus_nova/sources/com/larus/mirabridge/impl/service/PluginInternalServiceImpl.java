package com.larus.mirabridge.impl.service;

import android.app.Application;
import androidx.core.app.NotificationCompat;
import cl9.g;
import com.bytedance.mira.Mira;
import com.bytedance.mira.helper.ProcessHelperOpt;
import com.larus.mirabridge.api.plugin.service.IPluginInternalService;
import com.larus.utils.logger.FLogger;
import com.monitor.cloudmessage.consts.CloudControlInf;
import hl9.a;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0015H\u0017J \u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0012H\u0016¨\u0006\u001f"}, d2 = {"Lcom/larus/mirabridge/impl/service/PluginInternalServiceImpl;", "Lcom/larus/mirabridge/api/plugin/service/IPluginInternalService;", "<init>", "()V", "initMira", "", "app", "Landroid/app/Application;", "fixWebView", "initMorpheus", "registerMiraInitCallback", "callback", "Lkotlin/Function0;", "unregisterMiraInitCallback", "ensureFrameworkReady", "timeout", "", "isFrameworkInited", "", "isNotPlugin", "packageName", "", "getDefaultPluginLoadUIFactory", "Lcom/larus/mirabridge/api/plugin/abs/IPluginLoadUIFactory;", "afterReady", CloudControlInf.PLUGIN, "applyLoadStyle", "pluginPackageName", "task", "Lcom/larus/mirabridge/api/plugin/IPluginLoadTask;", NotificationCompat.GROUP_KEY_SILENT, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PluginInternalServiceImpl implements IPluginInternalService {
    public PluginInternalServiceImpl() {
    }

    @Override // com.larus.mirabridge.api.plugin.service.IPluginInternalService
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.PLUGIN);
    }

    @Override // com.larus.mirabridge.api.plugin.service.IPluginInternalService
    public final void b(final Application r100) {
        Intrinsics.checkNotNullParameter(r100, "app");
        boolean r101 = ProcessHelperOpt.isMainProcess(r100);
        FLogger r102 = FLogger.f375446a;
        r102.i("mira/start", "  isMainProcess: " + r101);
        if (r101 == true) goto L5;
        r102.i("mira/start", "[sync] start isMainProcess: " + r101);
        g.f24138a.getClass();
        g.f();
        return;
    L5:
        a.f485700a.execute(new fl9.a(r100));
    }

    @Override // com.larus.mirabridge.api.plugin.service.IPluginInternalService
    public final void c(long r100) {
        g.f24138a.getClass();
        if (g.e() == false) goto L6;
        return;
    L6:
        if (r100 <= 0) goto L8;
        g.f24141d.await(r100, TimeUnit.MILLISECONDS);
        return;
    L8:
        g.f24141d.await();
    }

    @Override // com.larus.mirabridge.api.plugin.service.IPluginInternalService
    public final void d(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "app");
        g r101 = g.f24138a;
        r101.getClass();
        Mira.setAppContext(r100);
        r101.getClass();
        g.c(r100);
    }
}
