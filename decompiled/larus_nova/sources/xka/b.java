package xka;

import android.content.ContentValues;
import com.bytedance.ee.bear.document.bitable.TimeZoneItemV2;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ss.android.dypay.api.DyPayConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class b implements vka.b<Object> {
    public static final /* synthetic */ int E = 0;
    public final String A;
    public final String B;
    public final String C;
    public final boolean D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f564256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Long f564257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f564258c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f564259d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f564260e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f564261f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f564262g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Long f564263h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f564264i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f564265j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f564266k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final String f564267l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Boolean f564268m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final String f564269n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f564270o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final String f564271p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f564272q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f564273r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f564274s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Long f564275t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Boolean f564276u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Integer f564277v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Integer f564278w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Boolean f564279x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Boolean f564280y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Boolean f564281z;

    public static final class a {
        public static b a(JsonObject r310, boolean r311) {
            Intrinsics.checkNotNullParameter(r310, "json");
            JsonElement r100 = r310.get("id");
            String r101 = null;
            if (r100 == null) goto L5;
            Long r102 = Long.valueOf(r100.getAsLong());
        L6:
            if (r311 == false) goto L11;
            if (r102 == null) goto L11;
            throw new IllegalArgumentException("add event with non-null id");
        L11:
            JsonElement r103 = r310.get("isException");
            if (r103 == null) goto L14;
            Boolean r104 = Boolean.valueOf(r103.getAsBoolean());
        L15:
            JsonElement r105 = r310.get("calendarId");
            if (r105 == null) goto L18;
            Long r106 = Long.valueOf(r105.getAsLong());
        L19:
            JsonElement r107 = r310.get("title");
            if (r107 == null) goto L22;
            String r108 = r107.getAsString();
        L23:
            JsonElement r109 = r310.get("organizer");
            if (r109 == null) goto L26;
            String r110 = r109.getAsString();
        L27:
            JsonElement r111 = r310.get("location");
            if (r111 == null) goto L30;
            String r112 = r111.getAsString();
        L31:
            JsonElement r113 = r310.get("description");
            if (r113 == null) goto L34;
            String r114 = r113.getAsString();
        L35:
            JsonElement r115 = r310.get("color");
            if (r115 == null) goto L38;
            Integer r116 = Integer.valueOf(r115.getAsInt());
        L39:
            JsonElement r117 = r310.get(DyPayConstant.KEY_START_TIME);
            if (r117 == null) goto L42;
            Long r118 = Long.valueOf(r117.getAsLong());
        L43:
            JsonElement r119 = r310.get("endTime");
            if (r119 == null) goto L46;
            Long r120 = Long.valueOf(r119.getAsLong());
        L47:
            JsonElement r121 = r310.get(TimeZoneItemV2.TIME_ZONE);
            if (r121 == null) goto L50;
            String r122 = r121.getAsString();
        L51:
            JsonElement r123 = r310.get("endTimeZone");
            if (r123 == null) goto L54;
            String r124 = r123.getAsString();
        L55:
            JsonElement r125 = r310.get("duration");
            if (r125 == null) goto L58;
            String r126 = r125.getAsString();
        L59:
            JsonElement r127 = r310.get("allDay");
            if (r127 == null) goto L62;
            Boolean r128 = Boolean.valueOf(r127.getAsBoolean());
        L63:
            JsonElement r129 = r310.get("rRule");
            if (r129 == null) goto L66;
            String r130 = r129.getAsString();
        L67:
            JsonElement r131 = r310.get("rDate");
            if (r131 == null) goto L70;
            String r132 = r131.getAsString();
        L71:
            JsonElement r133 = r310.get("exRule");
            if (r133 == null) goto L74;
            String r210 = r133.getAsString();
        L75:
            JsonElement r134 = r310.get("exDate");
            if (r134 == null) goto L78;
            String r211 = r134.getAsString();
        L79:
            JsonElement r135 = r310.get("originalId");
            if (r135 == null) goto L82;
            String r212 = r135.getAsString();
        L83:
            JsonElement r136 = r310.get("originalSyncId");
            if (r136 == null) goto L86;
            String r213 = r136.getAsString();
        L87:
            JsonElement r137 = r310.get("originalInstanceTime");
            if (r137 == null) goto L90;
            Long r214 = Long.valueOf(r137.getAsLong());
        L91:
            JsonElement r138 = r310.get("originalAllDay");
            if (r138 == null) goto L94;
            Boolean r215 = Boolean.valueOf(r138.getAsBoolean());
        L95:
            JsonElement r139 = r310.get("accessLevel");
            if (r139 == null) goto L98;
            Integer r216 = Integer.valueOf(r139.getAsInt());
        L99:
            JsonElement r140 = r310.get("availability");
            if (r140 == null) goto L102;
            Integer r217 = Integer.valueOf(r140.getAsInt());
        L103:
            JsonElement r141 = r310.get("guestsCanModify");
            if (r141 == null) goto L106;
            Boolean r218 = Boolean.valueOf(r141.getAsBoolean());
        L107:
            JsonElement r142 = r310.get("guestsCanInviteOthers");
            if (r142 == null) goto L110;
            Boolean r219 = Boolean.valueOf(r142.getAsBoolean());
        L111:
            JsonElement r143 = r310.get("guestsCanSeeGuests");
            if (r143 == null) goto L114;
            Boolean r312 = Boolean.valueOf(r143.getAsBoolean());
        L115:
            JsonElement r144 = r310.get("customAppPackage");
            if (r144 == null) goto L118;
            String r313 = r144.getAsString();
        L119:
            JsonElement r145 = r310.get("customAppUri");
            if (r145 == null) goto L122;
            String r314 = r145.getAsString();
        L123:
            JsonElement r146 = r310.get("uid2445");
            if (r146 == null) goto L127;
            r101 = r146.getAsString();
        L127:
            return new b(r104, r102, r106, r108, r110, r112, r114, r116, r118, r120, r122, r124, r126, r128, r130, r132, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r312, r313, r314, r101);
        L122:
            r314 = null;
            goto L123
        L118:
            r313 = null;
            goto L119
        L114:
            r312 = null;
            goto L115
        L110:
            r219 = null;
            goto L111
        L106:
            r218 = null;
            goto L107
        L102:
            r217 = null;
            goto L103
        L98:
            r216 = null;
            goto L99
        L94:
            r215 = null;
            goto L95
        L90:
            r214 = null;
            goto L91
        L86:
            r213 = null;
            goto L87
        L82:
            r212 = null;
            goto L83
        L78:
            r211 = null;
            goto L79
        L74:
            r210 = null;
            goto L75
        L70:
            r132 = null;
            goto L71
        L66:
            r130 = null;
            goto L67
        L62:
            r128 = null;
            goto L63
        L58:
            r126 = null;
            goto L59
        L54:
            r124 = null;
            goto L55
        L50:
            r122 = null;
            goto L51
        L46:
            r120 = null;
            goto L47
        L42:
            r118 = null;
            goto L43
        L38:
            r116 = null;
            goto L39
        L34:
            r114 = null;
            goto L35
        L30:
            r112 = null;
            goto L31
        L26:
            r110 = null;
            goto L27
        L22:
            r108 = null;
            goto L23
        L18:
            r106 = null;
            goto L19
        L14:
            r104 = null;
            goto L15
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
        if (this.D == false) goto L5;
        String r101 = this.f564273r;
        Intrinsics.checkNotNull(r101);
        ala.e r102 = new ala.c(CastLongProtector.parseLong(r101), null);
    L6:
        ContentValues r103 = new ContentValues();
        r103.put("calendar_id", this.f564257b);
        r103.put("title", this.f564258c);
        r103.put("organizer", this.f564259d);
        r103.put("eventLocation", this.f564260e);
        r103.put("description", this.f564261f);
        r103.put("eventColor", this.f564262g);
        r103.put("dtstart", this.f564263h);
        r103.put("dtend", this.f564264i);
        r103.put("eventTimezone", this.f564265j);
        r103.put("eventEndTimezone", this.f564266k);
        r103.put("duration", this.f564267l);
        r103.put("allDay", this.f564268m);
        r103.put("rrule", this.f564269n);
        r103.put("rdate", this.f564270o);
        r103.put("exrule", this.f564271p);
        r103.put("exdate", this.f564272q);
        r103.put("original_id", this.f564273r);
        r103.put("original_sync_id", this.f564274s);
        r103.put("originalInstanceTime", this.f564275t);
        r103.put("originalAllDay", this.f564276u);
        r103.put("accessLevel", this.f564277v);
        r103.put("availability", this.f564278w);
        r103.put("guestsCanModify", this.f564279x);
        r103.put("guestsCanInviteOthers", this.f564280y);
        r103.put("guestsCanSeeGuests", this.f564281z);
        r103.put("customAppPackage", this.A);
        r103.put("customAppUri", this.B);
        r103.put("uid2445", this.C);
        if (this.f564256a == null) goto L14;
        if (r100.update(r102, r103, null, null) <= 0) goto L11;
        boolean r104 = true;
    L15:
        return Boolean.valueOf(r104);
    L11:
        r104 = false;
        goto L15
    L14:
        return r100.insert(r102, r103);
    L5:
        r102 = new ala.b(this.f564256a, 2);
        goto L6
    }

    public b(Boolean r100, Long r101, Long r102, String r103, String r104, String r105, String r106, Integer r110, Long r111, Long r112, String r113, String r114, String r115, Boolean r116, String r117, String r118, String r119, String r210, String r211, String r212, Long r213, Boolean r214, Integer r215, Integer r216, Boolean r217, Boolean r218, Boolean r219, String r310, String r311, String r312) {
        this.f564256a = r101;
        this.f564257b = r102;
        this.f564258c = r103;
        this.f564259d = r104;
        this.f564260e = r105;
        this.f564261f = r106;
        this.f564262g = r110;
        this.f564263h = r111;
        this.f564264i = r112;
        this.f564265j = r113;
        this.f564266k = r114;
        this.f564267l = r115;
        this.f564268m = r116;
        this.f564269n = r117;
        this.f564270o = r118;
        this.f564271p = r119;
        this.f564272q = r210;
        this.f564273r = r211;
        this.f564274s = r212;
        this.f564275t = r213;
        this.f564276u = r214;
        this.f564277v = r215;
        this.f564278w = r216;
        this.f564279x = r217;
        this.f564280y = r218;
        this.f564281z = r219;
        this.A = r310;
        this.B = r311;
        this.C = r312;
        if (r100 == null) goto L5;
        boolean r107 = r100.booleanValue();
    L6:
        this.D = r107;
        return;
    L5:
        r107 = false;
        goto L6
    }
}
