package com.bytedance.sdk.account.settings.common;

import com.bytedance.sdk.account.utils.m;
import kotlin.collections.SetsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JSONObject f269403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f269404b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f269405c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final m f269406d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final m f269407e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f269408f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static long f269409g;

    static {
        f269404b = true;
        f269405c = new m(null, SetsKt.mutableSetOf(new String[]{"x-tt-token-supplement", "session-tlb-tag", "token-tlb-tag", "bd-ticket-guard-key-sign"}), true);
        f269406d = new m(null, null, true);
        f269407e = new m(null, SetsKt.mutableSetOf(new String[]{"x-tt-token-supplement", "bd-ticket-guard-key-sign"}), true);
        f269408f = 1;
    }

    public static void a() {
        JSONObject r100 = a.b();
        JSONArray r101 = null;
        if (r100 == null) goto L5;
        JSONObject r102 = r100.optJSONObject("handle_passport_extra_header");
    L6:
        int r103 = 1;
        if (f269403a == r102) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == false) goto L34;
        f269403a = r102;
        if (r102 == null) goto L14;
        boolean r105 = r102.optBoolean("enable", true);
    L15:
        f269404b = r105;
        a();
        m r106 = f269405c;
        JSONObject r107 = f269403a;
        if (r107 == null) goto L18;
        JSONArray r108 = r107.optJSONArray("save_headers");
    L19:
        r106.c(r108);
        a();
        m r109 = f269406d;
        JSONObject r110 = f269403a;
        if (r110 == null) goto L22;
        JSONArray r111 = r110.optJSONArray("deprecate_headers");
    L23:
        r109.c(r111);
        a();
        m r112 = f269407e;
        JSONObject r113 = f269403a;
        if (r113 == null) goto L26;
        r101 = r113.optJSONArray("logout_clear_headers");
    L26:
        r112.c(r101);
        JSONObject r114 = f269403a;
        if (r114 == null) goto L29;
        r103 = r114.optInt("backup_strategy_v2", 1);
    L29:
        f269408f = r103;
        JSONObject r115 = f269403a;
        long r116 = 0;
        if (r115 == null) goto L32;
        r116 = r115.optLong("delay_check_sp_timeout", 0);
    L32:
        f269409g = r116;
        tb7.a.d("PassportExtraHeadersCon", "updateSettings, " + r102);
        return;
    L22:
        r111 = null;
        goto L23
    L18:
        r108 = null;
        goto L19
    L14:
        r105 = true;
        goto L15
    L34:
        return;
    L9:
        r104 = false;
        goto L10
    L5:
        r102 = null;
        goto L6
    }
}
