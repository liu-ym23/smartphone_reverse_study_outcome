package com.larus.avlink.gallery.plugin;

import com.larus.common.apphost.AppHost;
import com.larus.mirabridge.api.bean.PluginLoadBuilder;
import com.larus.mirabridge.api.plugin.service.IPluginService;
import com.larus.mirabridge.api.pluginservice.IDoraPluginService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: classes25.dex */
public final class f {
    public static final Object a(Continuation r100) {
        IPluginService r101 = (IPluginService) ServiceManager.get().getService(IPluginService.class);
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L11;
        IDoraPluginService r103 = (IDoraPluginService) ServiceManager.get().getService(IDoraPluginService.class);
        b(r103);
        return r103;
    L11:
        j r104 = new j(IntrinsicsKt.intercepted(r100), 1);
        r104.C();
        AtomicBoolean r105 = new AtomicBoolean(false);
        PluginLoadBuilder r106 = new PluginLoadBuilder();
        Intrinsics.checkNotNullParameter("com.larus.mira.dora", "packageName");
        r106.f359294a = "com.larus.mira.dora";
        Intrinsics.checkNotNull(IDoraPluginService.class, "null cannot be cast to non-null type java.lang.Class<*>");
        r106.f359295b = IDoraPluginService.class;
        PluginLoadBuilder.PluginLoadType r107 = PluginLoadBuilder.PluginLoadType.ASYNC;
        Intrinsics.checkNotNullParameter(r107, "type");
        r106.f359298e = r107;
        PluginLoadBuilder.PluginLoadTime r108 = PluginLoadBuilder.PluginLoadTime.IMMEDIATE;
        Intrinsics.checkNotNullParameter(r108, com.alipay.sdk.m.p.e.f25671s);
        r106.f359297d = r108;
        r106.f359300g = 3000;
        c r109 = new c(r105, r104);
        Intrinsics.checkNotNullParameter(r109, "result");
        r106.f359299f = r109;
        PluginLoadBuilder.c r110 = r106.a();
        if (r101 == null) goto L14;
        r101.a(r110);
    L14:
        r104.i(new b(r105));
        Object r111 = r104.B();
        if (r111 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L17;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L17:
        return r111;
    L5:
        if (r101.c(IDoraPluginService.class) != true) goto L7;
        r102 = true;
        goto L8
    }

    public static final void b(IDoraPluginService r100) {
        if (r100 == null) goto L5;
        r100.ensureMorphoFiles(AppHost.f326268a.getApplication());
        return;
    }
}
