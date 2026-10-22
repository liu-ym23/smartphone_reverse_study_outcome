package com.bytedance.android.livesdk.ktvimpl.base.util;

import am2.x;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.logger.PanelType;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class q {
    public static final Map<String, cm2.a> a = null;

    static {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put(PanelType.ORDER_SONG_PANEL, new cm2.a());
        a = r0;
    }

    public static boolean a() {
        Intrinsics.checkNotNullParameter(PanelType.ORDER_SONG_PANEL, "panelType");
        cm2.a r0 = (cm2.a) ((LinkedHashMap) a).get(PanelType.ORDER_SONG_PANEL);
        if (r0 != null) goto L5;
    L12:
        return true;
    L5:
        if (r0.b == true) goto L12;
        if (r0.h == 0) goto L12;
        if (r0.a == false) goto L12;
        return false;
    }

    public static cm2.a b() {
        return (cm2.a) ((LinkedHashMap) a).get(PanelType.ORDER_SONG_PANEL);
    }

    public static void c() {
        Intrinsics.checkNotNullParameter(PanelType.ORDER_SONG_PANEL, "panelType");
        if (a() == true) goto L15;
        cm2.a r0 = (cm2.a) ((LinkedHashMap) a).get(PanelType.ORDER_SONG_PANEL);
        if (r0 == null) goto L16;
        r0.b = true;
        long r3 = System.currentTimeMillis();
        long r5 = r0.d;
        r0.f = r3 - r5;
        r0.i = r5 - r0.e;
        r0.j = System.currentTimeMillis() - r0.c;
        ALogger.i("panel_first_frame_opt_tag", "order_song_panel first frame monitor ;; createDialogDuration == " + r0.g + " ;; fetchListDuration == " + r0.h + " ;; handleListDuration == " + r0.i + " ;; renderDialogDuration == " + r0.f + " ;; totalDuration == " + r0.j);
        Map<String, String> r4 = MapsKt.mapOf(new Pair[]{TuplesKt.to("create_panel_duration", String.valueOf(r0.g)), TuplesKt.to("fetch_list_duration", String.valueOf(r0.h)), TuplesKt.to("handle_list_duration", String.valueOf(r0.i)), TuplesKt.to("render_panel_duration", String.valueOf(r0.f)), TuplesKt.to("duration", String.valueOf(r0.j)), TuplesKt.to("panel_type", PanelType.ORDER_SONG_PANEL)});
        com.bytedance.android.live.liveinteract.linkpanel.util.m.p(r4);
        pd2.d.n.i("order_music", r0.j, r4);
        pd2.d.H(MapsKt.mapOf(new Pair[]{TuplesKt.to("panel_type", PanelType.ORDER_SONG_PANEL), TuplesKt.to("panel_status", "show_panel")}));
        int r6 = mb0.f.a;
        mb0.f.j("show_panel", MapsKt.mapOf(TuplesKt.to("panel_type", PanelType.ORDER_SONG_PANEL)), null, 28);
        Long r1 = KtvLoggerHelper.a;
        String r2 = String.valueOf(r0.j);
        Intrinsics.checkNotNullParameter(r2, "duration");
        LinkedHashMap r7 = new LinkedHashMap();
        r7.put("duration", r2);
        KtvLoggerHelper.A(r7);
        r7.put("user_type", KtvLoggerHelper.I());
        r7.put("live_type", KtvLoggerHelper.F());
        IMiddlewareUserService r8 = jc1.k.f(IMiddlewareUserService.class);
        if (r8 == null) goto L12;
        com.bytedance.android.livesdk.user.e r9 = r8.user();
        if (r9 == null) goto L12;
        String r10 = r9.n();
        if (r10 == null) goto L12;
    L13:
        r7.put("user_id", r10);
        j0.l().sendLog("livesdk_ksong_music_list_first_frame_duration", r7, new Object[]{IRoom.class, x.class});
        r0.h = 0;
        return;
    L12:
        r10 = "-1";
        goto L13
    L16:
        return;
    }

    public static void e() {
        Intrinsics.checkNotNullParameter(PanelType.ORDER_SONG_PANEL, "panelType");
        cm2.a r0 = b();
        if (r0 == null) goto L6;
        pd2.d r2 = pd2.d.n;
        Map r3 = MapsKt.mapOf(new Pair[]{TuplesKt.to("panel_type", PanelType.ORDER_SONG_PANEL), TuplesKt.to("panel_status", "create_panel")});
        r2.getClass();
        pd2.d.H(r3);
        int r4 = mb0.f.a;
        mb0.f.j("create_panel", MapsKt.mapOf(TuplesKt.to("panel_type", PanelType.ORDER_SONG_PANEL)), null, 28);
        r0.b = false;
        r0.c = System.currentTimeMillis();
        return;
    }

    public static void d(Throwable r3) {
        Intrinsics.checkNotNullParameter(PanelType.ORDER_SONG_PANEL, "panelType");
        cm2.a r0 = b();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.b == true) goto L9;
        int r1 = mb0.f.a;
        mb0.f.j("loading_panel", MapsKt.mapOf(TuplesKt.to("panel_type", PanelType.ORDER_SONG_PANEL)), r3, 24);
        return;
    }
}
