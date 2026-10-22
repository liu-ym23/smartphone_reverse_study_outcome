package com.larus.mirabridge.impl.service;

import android.app.Application;
import android.util.EventsUtils;
import cl9.g;
import com.bytedance.mira.Mira;
import com.bytedance.mira.helper.ProcessHelperOpt;
import com.larus.mirabridge.api.plugin.service.IPluginInternalService;
import com.larus.utils.logger.FLogger;
import hl9.a;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0016\u0010\n\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016J\u0016\u0010\r\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0015H\u0017J \u0010\u001a\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0012H\u0016¨\u0006\u001f"}, d2 = {"Lcom/larus/mirabridge/impl/service/PluginInternalServiceImpl;", "Lcom/larus/mirabridge/api/plugin/service/IPluginInternalService;", "<init>", "()V", "initMira", XmlPullParser.NO_NAMESPACE, "app", "Landroid/app/Application;", "fixWebView", "initMorpheus", "registerMiraInitCallback", "callback", "Lkotlin/Function0;", "unregisterMiraInitCallback", "ensureFrameworkReady", "timeout", XmlPullParser.NO_NAMESPACE, "isFrameworkInited", XmlPullParser.NO_NAMESPACE, "isNotPlugin", "packageName", XmlPullParser.NO_NAMESPACE, "getDefaultPluginLoadUIFactory", "Lcom/larus/mirabridge/api/plugin/abs/IPluginLoadUIFactory;", "afterReady", "plugin", "applyLoadStyle", "pluginPackageName", "task", "Lcom/larus/mirabridge/api/plugin/IPluginLoadTask;", "silent", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class PluginInternalServiceImpl implements IPluginInternalService {
    public PluginInternalServiceImpl() {
    }

    @Override // com.larus.mirabridge.api.plugin.service.IPluginInternalService
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "plugin");
    }

    @Override // com.larus.mirabridge.api.plugin.service.IPluginInternalService
    public final void b(Application r5) {
        Intrinsics.checkNotNullParameter(r5, "app");
        boolean r0 = ProcessHelperOpt.isMainProcess(r5);
        FLogger r1 = FLogger.a;
        r1.i("mira/start", "  isMainProcess: " + r0);
        if (r0 == true) goto L5;
        r1.i("mira/start", "[sync] start isMainProcess: " + r0);
        g.a.getClass();
        g.f();
        return;
    L5:
        a.a.execute(new fl9.a(r5));
    }

    @Override // com.larus.mirabridge.api.plugin.service.IPluginInternalService
    public final void c(long r4) {
        g.a.getClass();
        if (g.e() == false) goto L6;
        return;
    L6:
        if (r4 <= 0) goto L8;
        g.d.await(r4, TimeUnit.MILLISECONDS);
        return;
    L8:
        g.d.await();
    }

    @Override // com.larus.mirabridge.api.plugin.service.IPluginInternalService
    public final void d(Application r2) {
        Intrinsics.checkNotNullParameter(r2, "app");
        g r0 = g.a;
        r0.getClass();
        Mira.setAppContext(r2);
        r0.getClass();
        g.c(r2);
    }
}
