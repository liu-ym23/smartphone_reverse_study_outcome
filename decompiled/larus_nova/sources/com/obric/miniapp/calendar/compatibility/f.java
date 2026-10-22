package com.obric.miniapp.calendar.compatibility;

import android.content.ContentValues;
import android.database.Cursor;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes33.dex */
public final class f implements vka.b<Long> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f397595d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f397596a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f397597b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CalendarEntity f397598c;

    public static final class a {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v11 */
    /* JADX WARN: Type inference failed for: r3v18 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v5 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [java.lang.Long, java.lang.String, java.lang.String[]] */
    /* JADX WARN: Type inference failed for: r5v0, types: [com.google.gson.JsonObject] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.google.gson.JsonElement, com.google.gson.JsonObject] */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v19 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v5, types: [vka.f] */
    /* JADX WARN: Type inference failed for: r9v5, types: [java.lang.Object] */
    @Override // vka.b
    public final Object execute() {
        vka.f r100 = vka.f.f555548a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        CalendarEntity r101 = this.f397598c;
        boolean r102 = r101.f397499b;
        Long r103 = r101.f397498a;
        boolean r110 = r101.f397501d;
        String r111 = r101.f397500c;
        String r112 = r101.f397504g;
        boolean r113 = r101.f397515r;
        Integer r114 = r101.f397514q;
        boolean r115 = r101.f397507j;
        String r104 = r101.f397506i;
        boolean r105 = r101.f397509l;
        String r106 = r101.f397508k;
        if (r106 == null) goto L5;
        Integer r107 = StringsKt.toIntOrNull(r106);
    L6:
        Pair r108 = TuplesKt.to(r107, this.f397598c.f397508k);
        Integer r109 = (Integer) r108.component1();
        String r116 = (String) r108.component2();
        CalendarEntity r117 = this.f397598c;
        boolean r118 = r117.f397511n;
        Integer r119 = r117.f397510m;
        boolean r120 = r117.f397517t;
        String r121 = r117.f397516s;
        if (r103 == null) goto L32;
        r103.longValue();
        String r210 = r121;
        String r211 = r116;
        Integer r212 = r109;
        boolean r213 = r105;
        vka.f r214 = r100;
        String r215 = "cal_sync1";
        String r122 = r104;
        boolean r123 = r118;
        Long r124 = r103;
        Integer r125 = r119;
        boolean r126 = r120;
        Cursor r127 = r100.query(new ala.a(r103, 2), new String[]{"cal_sync1"}, null, null, null);
        if (r127 == null) goto L28;
        Cursor r128 = r127;
        Cursor r129 = r128;     // Catch: Throwable -> L22
        if (r129.moveToNext() == true) goto L14;
    L18:
        Throwable r130 = null;
        String r131 = null;
    L19:
        CloseableKt.closeFinally(r128, r130);
        Throwable r132 = r130;
        if (r131 == null) goto L29;
        ?? r133 = r130;
        ?? r134 = JsonParser.parseString(r131).getAsJsonObject();
    L30:
        if (r134 == 0) goto L33;
    L34:
        CalendarEntity r135 = this.f397598c;
        if (r135.f397503f == false) goto L42;
        CalendarEntity.AccountType r136 = r135.f397502e;
        if (r136 == null) goto L41;
        String r137 = r136.toString();
        if (r137 == null) goto L41;
        r134.addProperty("accountType", r137);
    L41:
        r134.remove("accountType");
    L42:
        CalendarEntity r138 = this.f397598c;
        if (r138.f397513p == false) goto L48;
        Long r139 = r138.f397512o;
        if (r139 == null) goto L47;
        r134.addProperty("lastVersion", Long.valueOf(r139.longValue()));
        goto L48
    L47:
        r134.remove("lastVersion");
    L48:
        CalendarEntity r140 = this.f397598c;
        if (r140.f397519v == false) goto L54;
        String r141 = r140.f397518u;
        if (r141 == null) goto L53;
        r134.addProperty("reminderSetting", r141);
        goto L54
    L53:
        r134.remove("reminderSetting");
    L54:
        CalendarEntity r142 = this.f397598c;
        if (r142.f397521x == false) goto L60;
        String r143 = r142.f397520w;
        if (r143 == null) goto L59;
        r134.addProperty("userName", r143);
        goto L60
    L59:
        r134.remove("userName");
    L60:
        CalendarEntity r144 = this.f397598c;
        if (r144.f397523z == false) goto L66;
        String r145 = r144.f397522y;
        if (r145 == null) goto L65;
        r134.addProperty("password", r145);
        goto L66
    L65:
        r134.remove("password");
    L66:
        CalendarEntity r146 = this.f397598c;
        if (r146.B == false) goto L72;
        String r147 = r146.A;
        if (r147 == null) goto L71;
        r134.addProperty("serverUrl", r147);
        goto L72
    L71:
        r134.remove("serverUrl");
    L72:
        CalendarEntity r148 = this.f397598c;
        if (r148.f397517t == false) goto L78;
        String r149 = r148.f397516s;
        if (r149 == null) goto L77;
        r134.addProperty("syncToken", r149);
        goto L78
    L77:
        r134.remove("syncToken");
    L78:
        String r150 = r134.toString();
        ContentValues r151 = new ContentValues();
        if (r110 == false) goto L81;
        r151.put("name", r111);
    L81:
        r151.put("account_type", AccountType.LOCAL);
        r151.put("account_name", r112);
        if (r213 == false) goto L84;
        r151.put("calendar_color", r212);
        r151.put("calendar_color_index", r211);
    L84:
        if (r126 == false) goto L86;
        r151.put("_sync_id", r210);
    L86:
        if (r115 == false) goto L88;
        r151.put("calendar_displayName", r122);
    L88:
        if (r102 == true) goto L90;
        r151.put("calendar_access_level", 800);
    L90:
        if (r113 == false) goto L92;
        r151.put("visible", r114);
    L92:
        r151.put("ownerAccount", r112);
        if (r123 == false) goto L95;
        r151.put("sync_events", r125);
    L95:
        r151.put(r215, r150);
        if (this.f397596a == false) goto L102;
        Long r152 = this.f397597b;
        if (r152 == null) goto L100;
        long r153 = r152.longValue();
    L101:
        r151.put("dirty", Long.valueOf(r153));
        goto L102
    L100:
        r153 = 0;
    L102:
        if (r102 == false) goto L108;
        Long r154 = r124;
        ?? r155 = r214;
        if (r155.update(new ala.a(r154, r112), r151, r133, r133) <= 0) goto L114;
        return r154;
    L114:
        return r133;
    L108:
        return r214.insert(new ala.a(r133, r112), r151);
    L33:
        r134 = new JsonObject();
    L29:
        r134 = r132;
        r133 = r132;
        goto L30
    L14:
        if (r129.isNull(0) == true) goto L18;
        r131 = r129.getString(0);     // Catch: Throwable -> L22
        r130 = null;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        CloseableKt.closeFinally(r128, th);
        throw th;
    L28:
        r132 = null;
        goto L29
    L32:
        r214 = r100;
        r210 = r121;
        r211 = r116;
        r212 = r109;
        r213 = r105;
        r215 = "cal_sync1";
        r122 = r104;
        r123 = r118;
        r133 = 0;
        r124 = r103;
        r125 = r119;
        r126 = r120;
        goto L33
    L5:
        r107 = null;
        goto L6
    }

    public f(boolean r100, Long r101, CalendarEntity r102) {
        Intrinsics.checkNotNullParameter(r102, "entity");
        this.f397596a = r100;
        this.f397597b = r101;
        this.f397598c = r102;
    }
}
