package com.bytedance.ee.bear.bitable.homepage.chart.container.loader;

import com.bytedance.geckox.GeckoConfig;
import com.ss.android.lark.lynxkit.templateloader.loaderimpl.GeckoStrategy;
import com.ss.android.lark.lynxkit.templateloader.loaderimpl.g;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class b extends g {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<uqb.a> f212443f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f212444g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicInteger f212445h;

    public static final class a {
    }

    static {
    }

    public b(GeckoConfig r100, GeckoStrategy r101) {
        Intrinsics.checkNotNullParameter("bitable_lynx_chart", "channel");
        Intrinsics.checkNotNullParameter(r100, "geckoConfig");
        Intrinsics.checkNotNullParameter(r101, "geckoStrategy");
        super("bitable_lynx_chart", r100, r101);
        this.f212443f = new ArrayList();
        this.f212444g = new c(this);
        this.f212445h = new AtomicInteger(0);
    }

    @Override // com.ss.android.lark.lynxkit.templateloader.loaderimpl.g
    public final void b(String r100, uqb.a r101) {
        Intrinsics.checkNotNullParameter(r100, "templatePath");
        if (r101 == null) goto L5;
        monitor-enter(this);
    L20:
        th = move-exception;
        throw th;
    L10:
        if (((ArrayList) this.f212443f).contains(r101) == true) goto L13;
        tt5.a.h("GeckoTemplateLoader", "receive update request, save it");     // Catch: Throwable -> L20
        ((ArrayList) this.f212443f).add(r101);     // Catch: Throwable -> L20
    L13:
        if (((ArrayList) this.f212443f).size() <= 1) goto L17;
        tt5.a.h("GeckoTemplateLoader", "cached callbacks more than 1, return");     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L17:
        tt5.a.h("GeckoTemplateLoader", "do checkUpdate");     // Catch: Throwable -> L20
        super.b(r100, this.f212444g);     // Catch: Throwable -> L20
        Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L20
        monitor-exit(this);
        return;
    L5:
        if (this.f212445h.incrementAndGet() > 1) goto L24;
        tt5.a.h("GeckoTemplateLoader", "checkUpdate silently");
        super.b(r100, null);
        return;
    }
}
