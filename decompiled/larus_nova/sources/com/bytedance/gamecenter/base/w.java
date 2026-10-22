package com.bytedance.gamecenter.base;

import java.util.Map;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class w {
    public static int a() {
        Map<String, Object> r100 = q.l().f245052e;
        JSONObject r101 = null;
        if (r100 != null) goto L21;
    L10:
        boolean r102 = r.f245056a;
        Intrinsics.checkNotNullParameter("GameCP_WebSocket", "tag");
    L12:
        if (r101 != null) goto L19;
    L17:
        boolean r103 = r.f245056a;
        Intrinsics.checkNotNullParameter("GameCP_WebSocket", "tag");
        return 2;
    L19:
        int r104 = r101.optInt("download_trigger_type", 2);     // Catch: Exception -> L15
        boolean r105 = r.f245056a;     // Catch: Exception -> L15
        Intrinsics.checkNotNullParameter("GameCP_WebSocket", "tag");     // Catch: Exception -> L15
        return r104;
    L15:
        e = move-exception;
        e.toString();
        boolean r106 = r.f245056a;
        Intrinsics.checkNotNullParameter("GameCP_WebSocket", "tag");
        goto L17
    L21:
        Object r107 = r100.get("live_gamecp_order_download_im_or_timer_abtest");     // Catch: Exception -> L8
        if (r107 == null) goto L12;
        r101 = (JSONObject) r107;     // Catch: Exception -> L8
    L8:
        e = move-exception;
        e.toString();
        boolean r108 = r.f245056a;
        Intrinsics.checkNotNullParameter("GameCP_WebSocket", "tag");
        goto L10
    }

    public static JSONObject b() {
        Map<String, Object> r100 = q.l().f245052e;
        if (r100 != null) goto L13;
    L11:
        boolean r101 = r.f245056a;
        Intrinsics.checkNotNullParameter("MultiCdn", "tag");
        return null;
    L13:
        Object r102 = r100.get("live_gamecp_download_sup_multi_cdn_abtest");     // Catch: Exception -> L9
        if (r102 == null) goto L15;
        return (JSONObject) r102;
    L15:
        return null;
    L9:
        e = move-exception;
        e.toString();
        boolean r103 = r.f245056a;
        Intrinsics.checkNotNullParameter("MultiCdn", "tag");
        goto L11
    }

    public static int c() {
        Map<String, Object> r100 = q.l().f245052e;
        if (r100 != null) goto L12;
    L10:
        boolean r101 = r.f245056a;
        Intrinsics.checkNotNullParameter("MultiCdn", "tag");
        return 0;
    L12:
        Object r102 = r100.get("live_gamecp_multi_cdn_download_sup_all_game_abtest");     // Catch: Exception -> L8
        Objects.toString(r102);     // Catch: Exception -> L8
        boolean r103 = r.f245056a;     // Catch: Exception -> L8
        Intrinsics.checkNotNullParameter("MultiCdn", "tag");     // Catch: Exception -> L8
        if (r102 == null) goto L14;
        return ((Integer) r102).intValue();
    L14:
        return 0;
    L8:
        e = move-exception;
        e.toString();
        boolean r104 = r.f245056a;
        Intrinsics.checkNotNullParameter("MultiCdn", "tag");
        goto L10
    }

    public static boolean d() {
        if (a() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean e() {
        JSONObject r100 = q.l().h();
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = r.f245056a;
        Intrinsics.checkNotNullParameter("GameCP_ContextOpt", "tag");
        return r101;
    L5:
        if (r100.optInt("game_order_download_context_opt", 1) == 1) goto L8;
        r101 = false;
        goto L8
    }

    public static boolean f() {
        JSONObject r100 = q.l().h();
        boolean r101 = true;
        if (r100 != null) goto L5;
    L8:
        boolean r102 = r.f245056a;
        Intrinsics.checkNotNullParameter(OrderDownloadInfoTrigger.TAG, "tag");
        return r101;
    L5:
        if (r100.optInt("game_order_download_opt_switch", 1) == 1) goto L8;
        r101 = false;
        goto L8
    }

    public static boolean g() {
        Map<String, Object> r100 = q.l().f245052e;
        if (r100 != null) goto L16;
    L11:
        boolean r101 = r.f245056a;
        Intrinsics.checkNotNullParameter("GPreDownloadRes", "tag");
    L8:
        int r102 = 0;
    L13:
        if (r102 != 1) goto L18;
        return true;
    L18:
        return false;
    L16:
        Object r103 = r100.get("live_gamecp_res_pre_download_abtest");     // Catch: Exception -> L9
        Objects.toString(r103);     // Catch: Exception -> L9
        boolean r104 = r.f245056a;     // Catch: Exception -> L9
        Intrinsics.checkNotNullParameter("GPreDownloadRes", "tag");     // Catch: Exception -> L9
        if (r103 == null) goto L8;
        r102 = ((Integer) r103).intValue();     // Catch: Exception -> L9
    L9:
        e = move-exception;
        e.toString();
        boolean r105 = r.f245056a;
        Intrinsics.checkNotNullParameter("GPreDownloadRes", "tag");
        goto L11
    }
}
