package xka;

import android.content.ContentValues;
import com.bytedance.ee.bear.document.bitable.TimeZoneItemV2;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.obric.capabilitykit.entity.app.ExtraEntity;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class p implements vka.b<Long> {
    public static final /* synthetic */ int S = 0;
    public final Boolean A;
    public final String B;
    public final String C;
    public final String D;
    public final Long E;
    public final String F;
    public final String G;
    public final String H;
    public final String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final String f564360J;
    public final String K;
    public final String L;
    public final String M;
    public final String N;
    public final String O;
    public final String P;
    public final String Q;
    public final boolean R;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f564361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f564362b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f564363c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f564364d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f564365e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f564366f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f564367g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f564368h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f564369i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Long f564370j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f564371k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f564372l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f564373m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Boolean f564374n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f564375o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f564376p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f564377q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f564378r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f564379s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final String f564380t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Long f564381u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Boolean f564382v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Integer f564383w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Integer f564384x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Boolean f564385y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Boolean f564386z;

    public static final class a {
        public static p a(JsonObject r410) {
            Intrinsics.checkNotNullParameter(r410, "json");
            JsonElement r100 = r410.get("isException");
            String r101 = null;
            if (r100 == null) goto L5;
            Boolean r102 = Boolean.valueOf(r100.getAsBoolean());
        L6:
            String r103 = r410.get("accountName").getAsString();
            String r104 = r410.get("accountType").getAsString();
            JsonElement r105 = r410.get("id");
            if (r105 == null) goto L9;
            Long r106 = Long.valueOf(r105.getAsLong());
        L10:
            JsonElement r107 = r410.get("calendarId");
            if (r107 == null) goto L13;
            Long r108 = Long.valueOf(r107.getAsLong());
        L14:
            JsonElement r109 = r410.get("title");
            if (r109 == null) goto L17;
            String r110 = r109.getAsString();
        L18:
            JsonElement r111 = r410.get("organizer");
            if (r111 == null) goto L21;
            String r112 = r111.getAsString();
        L22:
            JsonElement r113 = r410.get("location");
            if (r113 == null) goto L25;
            String r114 = r113.getAsString();
        L26:
            JsonElement r115 = r410.get("description");
            if (r115 == null) goto L29;
            String r116 = r115.getAsString();
        L30:
            JsonElement r117 = r410.get("color");
            if (r117 == null) goto L33;
            Integer r118 = Integer.valueOf(r117.getAsInt());
        L34:
            JsonElement r119 = r410.get(DyPayConstant.KEY_START_TIME);
            if (r119 == null) goto L37;
            Long r120 = Long.valueOf(r119.getAsLong());
        L38:
            JsonElement r121 = r410.get("endTime");
            if (r121 == null) goto L41;
            Long r122 = Long.valueOf(r121.getAsLong());
        L42:
            JsonElement r123 = r410.get(TimeZoneItemV2.TIME_ZONE);
            if (r123 == null) goto L45;
            String r124 = r123.getAsString();
        L46:
            JsonElement r125 = r410.get("endTimeZone");
            if (r125 == null) goto L49;
            String r126 = r125.getAsString();
        L50:
            JsonElement r127 = r410.get("duration");
            if (r127 == null) goto L53;
            String r128 = r127.getAsString();
        L54:
            JsonElement r129 = r410.get("allDay");
            if (r129 == null) goto L57;
            Boolean r130 = Boolean.valueOf(r129.getAsBoolean());
        L58:
            JsonElement r131 = r410.get("rRule");
            if (r131 == null) goto L61;
            String r210 = r131.getAsString();
        L62:
            JsonElement r132 = r410.get("rDate");
            if (r132 == null) goto L65;
            String r211 = r132.getAsString();
        L66:
            JsonElement r133 = r410.get("exRule");
            if (r133 == null) goto L69;
            String r212 = r133.getAsString();
        L70:
            JsonElement r134 = r410.get("exDate");
            if (r134 == null) goto L73;
            String r213 = r134.getAsString();
        L74:
            JsonElement r135 = r410.get("originalId");
            if (r135 == null) goto L77;
            String r214 = r135.getAsString();
        L78:
            JsonElement r136 = r410.get("originalSyncId");
            if (r136 == null) goto L81;
            String r215 = r136.getAsString();
        L82:
            JsonElement r137 = r410.get("originalInstanceTime");
            if (r137 == null) goto L85;
            Long r216 = Long.valueOf(r137.getAsLong());
        L86:
            JsonElement r138 = r410.get("originalAllDay");
            if (r138 == null) goto L89;
            Boolean r217 = Boolean.valueOf(r138.getAsBoolean());
        L90:
            JsonElement r139 = r410.get("accessLevel");
            if (r139 == null) goto L93;
            Integer r218 = Integer.valueOf(r139.getAsInt());
        L94:
            JsonElement r140 = r410.get("availability");
            if (r140 == null) goto L97;
            Integer r219 = Integer.valueOf(r140.getAsInt());
        L98:
            JsonElement r141 = r410.get("guestsCanModify");
            if (r141 == null) goto L101;
            Boolean r310 = Boolean.valueOf(r141.getAsBoolean());
        L102:
            JsonElement r142 = r410.get("guestsCanInviteOthers");
            if (r142 == null) goto L105;
            Boolean r311 = Boolean.valueOf(r142.getAsBoolean());
        L106:
            JsonElement r143 = r410.get("guestsCanSeeGuests");
            if (r143 == null) goto L109;
            Boolean r312 = Boolean.valueOf(r143.getAsBoolean());
        L110:
            JsonElement r144 = r410.get("customAppPackage");
            if (r144 == null) goto L113;
            String r313 = r144.getAsString();
        L114:
            JsonElement r145 = r410.get("customAppUri");
            if (r145 == null) goto L117;
            String r314 = r145.getAsString();
        L118:
            JsonElement r146 = r410.get("uid2445");
            if (r146 == null) goto L121;
            String r315 = r146.getAsString();
        L122:
            JsonElement r147 = r410.get("dirty");
            if (r147 == null) goto L125;
            Long r316 = Long.valueOf(r147.getAsLong());
        L126:
            JsonElement r148 = r410.get("mutators");
            if (r148 == null) goto L129;
            String r317 = r148.getAsString();
        L130:
            JsonElement r149 = r410.get("syncId");
            if (r149 == null) goto L133;
            String r318 = r149.getAsString();
        L134:
            JsonElement r150 = r410.get(ExtraEntity.KEY_EXTRA_1);
            if (r150 == null) goto L137;
            String r319 = r150.getAsString();
        L138:
            JsonElement r151 = r410.get(ExtraEntity.KEY_EXTRA_2);
            if (r151 == null) goto L141;
            String r411 = r151.getAsString();
        L142:
            JsonElement r152 = r410.get(ExtraEntity.KEY_EXTRA_3);
            if (r152 == null) goto L145;
            String r412 = r152.getAsString();
        L146:
            JsonElement r153 = r410.get(ExtraEntity.KEY_EXTRA_4);
            if (r153 == null) goto L149;
            String r413 = r153.getAsString();
        L150:
            JsonElement r154 = r410.get(ExtraEntity.KEY_EXTRA_5);
            if (r154 == null) goto L153;
            String r414 = r154.getAsString();
        L154:
            JsonElement r155 = r410.get(ExtraEntity.KEY_EXTRA_6);
            if (r155 == null) goto L157;
            String r415 = r155.getAsString();
        L158:
            JsonElement r156 = r410.get(ExtraEntity.KEY_EXTRA_7);
            if (r156 == null) goto L161;
            String r416 = r156.getAsString();
        L162:
            JsonElement r157 = r410.get(ExtraEntity.KEY_EXTRA_8);
            if (r157 == null) goto L165;
            String r417 = r157.getAsString();
        L166:
            JsonElement r158 = r410.get(ExtraEntity.KEY_EXTRA_9);
            if (r158 == null) goto L169;
            String r418 = r158.getAsString();
        L170:
            JsonElement r159 = r410.get(ExtraEntity.KEY_EXTRA_10);
            if (r159 == null) goto L174;
            r101 = r159.getAsString();
        L174:
            return new p(r102, r104, r103, r106, r108, r110, r112, r114, r116, r118, r120, r122, r124, r126, r128, r130, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r310, r311, r312, r313, r314, r315, r316, r317, r318, r319, r411, r412, r413, r414, r415, r416, r417, r418, r101);
        L169:
            r418 = null;
            goto L170
        L165:
            r417 = null;
            goto L166
        L161:
            r416 = null;
            goto L162
        L157:
            r415 = null;
            goto L158
        L153:
            r414 = null;
            goto L154
        L149:
            r413 = null;
            goto L150
        L145:
            r412 = null;
            goto L146
        L141:
            r411 = null;
            goto L142
        L137:
            r319 = null;
            goto L138
        L133:
            r318 = null;
            goto L134
        L129:
            r317 = null;
            goto L130
        L125:
            r316 = null;
            goto L126
        L121:
            r315 = null;
            goto L122
        L117:
            r314 = null;
            goto L118
        L113:
            r313 = null;
            goto L114
        L109:
            r312 = null;
            goto L110
        L105:
            r311 = null;
            goto L106
        L101:
            r310 = null;
            goto L102
        L97:
            r219 = null;
            goto L98
        L93:
            r218 = null;
            goto L94
        L89:
            r217 = null;
            goto L90
        L85:
            r216 = null;
            goto L86
        L81:
            r215 = null;
            goto L82
        L77:
            r214 = null;
            goto L78
        L73:
            r213 = null;
            goto L74
        L69:
            r212 = null;
            goto L70
        L65:
            r211 = null;
            goto L66
        L61:
            r210 = null;
            goto L62
        L57:
            r130 = null;
            goto L58
        L53:
            r128 = null;
            goto L54
        L49:
            r126 = null;
            goto L50
        L45:
            r124 = null;
            goto L46
        L41:
            r122 = null;
            goto L42
        L37:
            r120 = null;
            goto L38
        L33:
            r118 = null;
            goto L34
        L29:
            r116 = null;
            goto L30
        L25:
            r114 = null;
            goto L26
        L21:
            r112 = null;
            goto L22
        L17:
            r110 = null;
            goto L18
        L13:
            r108 = null;
            goto L14
        L9:
            r106 = null;
            goto L10
        L5:
            r102 = null;
            goto L6
        }
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        vka.f r100 = vka.f.f555548a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        ContentValues r101 = new ContentValues();
        r101.put("calendar_id", this.f564363c);
        r101.put("title", this.f564364d);
        r101.put("organizer", this.f564365e);
        r101.put("eventLocation", this.f564366f);
        r101.put("description", this.f564367g);
        r101.put("eventColor", this.f564368h);
        r101.put("dtstart", this.f564369i);
        r101.put("dtend", this.f564370j);
        r101.put("eventTimezone", this.f564371k);
        r101.put("eventEndTimezone", this.f564372l);
        r101.put("duration", this.f564373m);
        r101.put("allDay", this.f564374n);
        r101.put("rrule", this.f564375o);
        r101.put("rdate", this.f564376p);
        r101.put("exrule", this.f564377q);
        r101.put("exdate", this.f564378r);
        r101.put("original_id", this.f564379s);
        r101.put("original_sync_id", this.f564380t);
        r101.put("originalInstanceTime", this.f564381u);
        r101.put("originalAllDay", this.f564382v);
        r101.put("accessLevel", this.f564383w);
        r101.put("availability", this.f564384x);
        r101.put("guestsCanModify", this.f564385y);
        r101.put("guestsCanInviteOthers", this.f564386z);
        r101.put("guestsCanSeeGuests", this.A);
        r101.put("customAppPackage", this.B);
        r101.put("customAppUri", this.C);
        r101.put("uid2445", this.D);
        r101.put("dirty", this.E);
        r101.put("mutators", this.F);
        r101.put("_sync_id", this.G);
        r101.put("sync_data1", this.H);
        r101.put("sync_data2", this.I);
        r101.put("sync_data3", this.f564360J);
        r101.put("sync_data4", this.K);
        r101.put("sync_data5", this.L);
        r101.put("sync_data6", this.M);
        r101.put("sync_data7", this.N);
        r101.put("sync_data8", this.O);
        r101.put("sync_data9", this.P);
        r101.put("sync_data10", this.Q);
        if (this.f564362b == null) goto L8;
        if (r100.update(new ala.b(this.f564362b, this.f564361a), r101, null, null) > 0) goto L14;
        return null;
    L14:
        return this.f564362b;
    L8:
        if (this.R == false) goto L10;
        r101.remove("original_id");
        String r102 = this.f564379s;
        Intrinsics.checkNotNull(r102);
        ala.e r103 = new ala.c(CastLongProtector.parseLong(r102), this.f564361a);
    L12:
        return r100.insert(r103, r101);
    L10:
        r103 = new ala.b(null, this.f564361a);
        goto L12
    }

    public p(Boolean r100, String r101, String r102, Long r103, Long r104, String r110, String r111, String r112, String r113, Integer r114, Long r115, Long r116, String r117, String r118, String r119, Boolean r210, String r211, String r212, String r213, String r214, String r215, String r216, Long r217, Boolean r218, Integer r219, Integer r310, Boolean r311, Boolean r312, Boolean r313, String r314, String r315, String r316, Long r317, String r318, String r319, String r410, String r411, String r412, String r413, String r414, String r415, String r416, String r417, String r418, String r419) {
        Intrinsics.checkNotNullParameter(r101, "accountType");
        Intrinsics.checkNotNullParameter(r102, "accountName");
        this.f564361a = r102;
        this.f564362b = r103;
        this.f564363c = r104;
        this.f564364d = r110;
        this.f564365e = r111;
        this.f564366f = r112;
        this.f564367g = r113;
        this.f564368h = r114;
        this.f564369i = r115;
        this.f564370j = r116;
        this.f564371k = r117;
        this.f564372l = r118;
        this.f564373m = r119;
        this.f564374n = r210;
        this.f564375o = r211;
        this.f564376p = r212;
        this.f564377q = r213;
        this.f564378r = r214;
        this.f564379s = r215;
        this.f564380t = r216;
        this.f564381u = r217;
        this.f564382v = r218;
        this.f564383w = r219;
        this.f564384x = r310;
        this.f564385y = r311;
        this.f564386z = r312;
        this.A = r313;
        this.B = r314;
        this.C = r315;
        this.D = r316;
        this.E = r317;
        this.F = r318;
        this.G = r319;
        this.H = r410;
        this.I = r411;
        this.f564360J = r412;
        this.K = r413;
        this.L = r414;
        this.M = r415;
        this.N = r416;
        this.O = r417;
        this.P = r418;
        this.Q = r419;
        if (r100 == null) goto L5;
        boolean r105 = r100.booleanValue();
    L6:
        this.R = r105;
        return;
    L5:
        r105 = false;
        goto L6
    }
}
