package com.bytedance.interaction.game.base.monitor;

import android.net.Uri;
import com.bytedance.forest.utils.s;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class InteractiveMonitorReport {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final InteractiveMonitorReport f250880c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f250881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f250882b;

    public static final class a {
    }

    static {
        f250880c = new InteractiveMonitorReport("interactive_sdk");
    }

    public InteractiveMonitorReport(String r100) {
        this.f250881a = new b(r100);
        new ArrayList();
        this.f250882b = LazyKt.lazy(InteractiveMonitorReport$vidInfo$2.INSTANCE);
    }

    public static /* synthetic */ void b(InteractiveMonitorReport r100, String r110, long r111, boolean r112, String r113, Uri r114) {
        r100.a(r110, r111, true, r112, r113, r114, "");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v12, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.String] */
    public final void a(String r100, long r101, boolean r102, boolean r110, String r111, Uri r112, String r113) {
        Object r103 = s.b(r112, "group");
        c r104 = new c();
        String r105 = s.b(r112, "group");
        c r106 = new c();
        r106.a("group", r105);
        r106.a("url", r112.toString());
        r104.a("matchRule", r100);
        r104.a("duration", Long.valueOf(r101));
        r104.a("useOffline", Boolean.valueOf(r110));
        r104.a("loadSuccess", Boolean.valueOf(r102));
        r104.a("error", r113);
        r104.a("group", r103);
        r104.a("from", r111);
        com.bytedance.interaction.game.base.settings.model.c r107 = (com.bytedance.interaction.game.base.settings.model.c) this.f250882b.getValue();
        if (r107 == null) goto L8;
        Object r108 = new ArrayList();
        Iterator<String> r109 = r107.f250885a.keys();
    L6:
        if (r109.hasNext() == false) goto L9;
        r108.add(Long.valueOf(r107.f250885a.optLong(r109.next())));
    L9:
        r104.a("vid", r108);
        b r114 = this.f250881a;
        r114.getClass();
        r104.a("bid", r114.f250883a);
        int r115 = f96.a.f475971a;
        f96.a.d("interactive_monitor", "interactive report", MapsKt.mapOf(new Pair[]{TuplesKt.to("eventName", "bdi_js_file_load"), TuplesKt.to("param", r104.f250884a)}));
        AppLogNewUtils.onEventV3("bdi_js_file_load", r104.f250884a);
        return;
    L8:
        r108 = "";
        goto L9
    }
}
