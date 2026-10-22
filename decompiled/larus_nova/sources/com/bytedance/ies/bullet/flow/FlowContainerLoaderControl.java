package com.bytedance.ies.bullet.flow;

import android.app.Application;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.net.Uri;
import android.os.Bundle;
import androidx.appcompat.view.ContextThemeWrapper;
import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.core.d0;
import com.bytedance.ies.bullet.service.base.utils.KitType;
import com.larus.nova.R;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import v26.h;
import w26.g;
import y36.p;

/* JADX INFO: loaded from: classes19.dex */
public final class FlowContainerLoaderControl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final FlowContainerLoaderControl$flowContainerLoader$1 f246607a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final FlowContainerLoaderControl$flowContextMap$1 f246608b = null;

    static {
        f246607a = new FlowContainerLoaderControl$flowContainerLoader$1(3);
        f246608b = new FlowContainerLoaderControl$flowContextMap$1(3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(String r100, BulletContext r101, q26.a r102) {
        if (Intrinsics.areEqual(r100, "default_bid") == false) goto L12;
        String r103 = (String) new p(r101.f246439g.f544443a, "subres_prefix", null).f565862b;
        if (r103 == null) goto L12;
        if (r103.length() <= 0) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L12;
        h r105 = new h();
        List<String> r106 = CollectionsKt.toList(StringsKt.split$default(r103, new String[]{","}, false, 0, 6, null));
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r105.f552679a = r106;
        r102.putDependency(h.class, r105);
        goto L12
    L9:
        r104 = false;
    L12:
        r102.putDependency(a36.c.class, r101.f246449q);
        r102.putDependency(BulletContext.class, r101);
    }

    public static void b(String r100, BulletContext r110, Uri r111, String r112, Bundle r113, m16.b r114, com.bytedance.android.annie.business.container.e r115) {
        Intrinsics.checkNotNullParameter(r100, "sessionId");
        Intrinsics.checkNotNullParameter(r110, "bulletContext");
        Intrinsics.checkNotNullParameter(r111, "uri");
        Intrinsics.checkNotNullParameter(r112, "bid");
        ExecutorService r101 = com.bytedance.ies.bullet.service.monitor.a.f247969a;
        com.bytedance.ies.bullet.service.monitor.a.c(r100, "container_init_start", Long.valueOf(System.currentTimeMillis()));
        a36.a r102 = r110.f246449q;
        if (r102 == null) goto L5;
        KitType r103 = r102.c();
    L6:
        String r104 = r110.f246439g.f544443a.c().get("enable_flow_loader");
        if (Intrinsics.areEqual(r104, "0") == false) goto L9;
        return;
    L9:
        if (Intrinsics.areEqual(r104, "false") == false) goto L12;
        return;
    L12:
        if (FlowContainerLoaderSwitch.INSTANCE.enableAnnieXFlowLoader(String.valueOf(r110.f246438f), r111.toString(), r103) == true) goto L14;
        return;
    L14:
        HybridLogger r105 = HybridLogger.f246343a;
        HybridLogger.m("FlowContainerLoader", "doFlowPreload uri:" + r111, null, null, 12);
        Map<String, Map<Class<?>, Object>> r106 = x26.a.f562251a;     // Catch: Exception -> L41
        g r107 = (g) x26.a.a(g.class);     // Catch: Exception -> L41
        if (r107 == null) goto L22;
        w26.e r108 = (w26.e) r107.n0(w26.e.class);     // Catch: Exception -> L41
        if (r108 == null) goto L22;
        Boolean r109 = r108.Y0();     // Catch: Exception -> L41
        if (r109 == null) goto L22;
        boolean r116 = r109.booleanValue();     // Catch: Exception -> L41
    L23:
        if (r116 == false) goto L25;
        Context r117 = new ContextThemeWrapper(com.bytedance.ies.bullet.core.h.f246501h.f246503b, R.style.PlaceholderTheme);     // Catch: Exception -> L41
    L26:
        MutableContextWrapper r118 = new MutableContextWrapper(r117);     // Catch: Exception -> L41
        com.bytedance.ies.bullet.core.h r119 = com.bytedance.ies.bullet.core.h.f246501h;     // Catch: Exception -> L41
        b r120 = new b(new q26.a(r118, r119.f246502a), r112, r100, r115);     // Catch: Exception -> L41
        if (r110.getContext() != null) goto L29;
        r110.b(r118);     // Catch: Exception -> L41
    L29:
        r110.F = Boolean.FALSE;     // Catch: Exception -> L41
        r110.G = true;     // Catch: Exception -> L41
        Map<String, m16.b> r121 = c36.a.f22277a;     // Catch: Exception -> L41
        if (r114 != null) goto L35;
        m16.b r122 = new m16.b();     // Catch: Exception -> L41
        r122.d(p16.a.class, new p16.a(r100));     // Catch: Exception -> L41
        r122.d(BulletContext.class, r110);     // Catch: Exception -> L41
        Application r123 = r119.f246503b;     // Catch: Exception -> L41
        if (r123 == null) goto L34;
        r122.d(Context.class, new MutableContextWrapper(r123));     // Catch: Exception -> L41
    L34:
        Unit r124 = Unit.INSTANCE;     // Catch: Exception -> L41
    L36:
        c36.a.b(r100, r122);     // Catch: Exception -> L41
        if (r114 == null) goto L39;
        d0 r125 = (d0) r114.c(d0.class);     // Catch: Exception -> L41
    L39:
        ai7.a.c(r111);     // Catch: Exception -> L41
        q26.h r126 = r120.f246613d;     // Catch: Exception -> L41
        Intrinsics.checkNotNull(r126, "null cannot be cast to non-null type com.bytedance.ies.bullet.service.base.api.BaseServiceContext");     // Catch: Exception -> L41
        a(r112, r110, (q26.a) r126);     // Catch: Exception -> L41
        com.bytedance.ies.bullet.service.monitor.a.c(r100, "container_init_end", Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L41
        r120.j(r110, r111, r113);     // Catch: Exception -> L41
        f246607a.put(r100, r120);     // Catch: Exception -> L41
        return;
    L35:
        r122 = r114;
        goto L36
    L25:
        r117 = com.bytedance.ies.bullet.core.h.f246501h.f246503b;     // Catch: Exception -> L41
    L22:
        r116 = true;
    L41:
        e = move-exception;
        HybridLogger r127 = HybridLogger.f246343a;
        HybridLogger.i("FlowContainerLoader", "do flow preload error:" + e.getMessage(), null, 12);
        return;
    L5:
        r103 = null;
        goto L6
    }
}
