package com.obric.miniapp.calendar.compatibility;

import android.database.Cursor;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import vka.n;

/* JADX INFO: loaded from: classes33.dex */
public final class CalendarEntity {
    public static final String[] E = null;
    public final String A;
    public final boolean B;
    public final Long C;
    public final boolean D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f397498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f397499b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f397500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f397501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final AccountType f397502e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f397503f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f397504g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f397505h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f397506i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f397507j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f397508k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f397509l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Integer f397510m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f397511n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Long f397512o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f397513p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Integer f397514q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f397515r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final String f397516s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f397517t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f397518u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f397519v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f397520w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f397521x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f397522y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f397523z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/obric/miniapp/calendar/compatibility/CalendarEntity$AccountType;", "", "<init>", "(Ljava/lang/String;I)V", com.obric.miniapp.alarm.AccountType.MAIN, com.obric.miniapp.alarm.AccountType.LARK, com.obric.miniapp.alarm.AccountType.LOCAL, com.obric.miniapp.alarm.AccountType.OTHERS, com.obric.miniapp.alarm.AccountType.ALL, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AccountType extends Enum<AccountType> {
        public static final AccountType ALL = null;
        public static final AccountType LARK = null;
        public static final AccountType LOCAL = null;
        public static final AccountType MAIN = null;
        public static final AccountType OTHERS = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AccountType[] f397524a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f397525b = null;

        public static EnumEntries<AccountType> getEntries() {
            return f397525b;
        }

        static {
            AccountType r100 = new AccountType(com.obric.miniapp.alarm.AccountType.MAIN, 0);
            MAIN = r100;
            AccountType r101 = new AccountType(com.obric.miniapp.alarm.AccountType.LARK, 1);
            LARK = r101;
            AccountType r102 = new AccountType(com.obric.miniapp.alarm.AccountType.LOCAL, 2);
            LOCAL = r102;
            AccountType r103 = new AccountType(com.obric.miniapp.alarm.AccountType.OTHERS, 3);
            OTHERS = r103;
            AccountType r104 = new AccountType(com.obric.miniapp.alarm.AccountType.ALL, 4);
            ALL = r104;
            AccountType[] r105 = {r100, r101, r102, r103, r104};
            f397524a = r105;
            f397525b = EnumEntriesKt.enumEntries(r105);
        }

        public static AccountType[] values() {
            return (AccountType[]) f397524a.clone();
        }

        public static AccountType valueOf(String r100) {
            return (AccountType) r27.a.a(AccountType.class, r100);
        }

        public AccountType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public static CalendarEntity a(Cursor r210) {
            Intrinsics.checkNotNullParameter(r210, "c");
            long r100 = r210.getLong(0);
            Long r101 = null;
            if (r210.isNull(1) == false) goto L5;
            String r102 = null;
        L7:
            if (r210.isNull(2) == false) goto L9;
            String r103 = null;
        L11:
            if (r210.isNull(6) == false) goto L13;
            String r211 = null;
        L15:
            if (r210.isNull(3) == false) goto L17;
            Long r104 = null;
        L18:
            if (r104 == null) goto L22;
            String r105 = r104.toString();
            if (r105 == null) goto L22;
        L25:
            String r212 = r105;
        L27:
            if (r210.isNull(8) == false) goto L29;
            Integer r213 = null;
        L31:
            if (r210.isNull(7) == false) goto L33;
            Integer r214 = null;
        L35:
            if (r210.isNull(4) == false) goto L37;
            String r215 = null;
        L66:
            JsonObject r106 = JsonParser.parseString(r210.getString(9)).getAsJsonObject();     // Catch: Exception -> L64
            AccountType r107 = AccountType.valueOf(r106.get("accountType").getAsString());     // Catch: Exception -> L64
            Intrinsics.checkNotNull(r106);     // Catch: Exception -> L64
            JsonElement r108 = n.a(r106, "lastVersion");     // Catch: Exception -> L64
            if (r108 == null) goto L42;
            Long r110 = Long.valueOf(r108.getAsLong());     // Catch: Exception -> L64
        L43:
            JsonElement r109 = n.a(r106, "reminderSetting");     // Catch: Exception -> L64
            if (r109 == null) goto L46;
            String r111 = r109.getAsString();     // Catch: Exception -> L64
        L47:
            JsonElement r112 = n.a(r106, "userName");     // Catch: Exception -> L64
            if (r112 == null) goto L50;
            String r113 = r112.getAsString();     // Catch: Exception -> L64
        L51:
            JsonElement r114 = n.a(r106, "password");     // Catch: Exception -> L64
            if (r114 == null) goto L54;
            String r115 = r114.getAsString();     // Catch: Exception -> L64
        L55:
            JsonElement r116 = n.a(r106, "serverUrl");     // Catch: Exception -> L64
            if (r116 == null) goto L58;
            String r216 = r116.getAsString();     // Catch: Exception -> L64
        L59:
            JsonElement r117 = n.a(r106, "syncTime");     // Catch: Exception -> L64
            if (r117 == null) goto L62;
            r101 = Long.valueOf(r117.getAsLong());     // Catch: Exception -> L64
        L62:
            return new CalendarEntity(Long.valueOf(r100), r102, r107, r103, r211, r212, r213, r110, r214, r215, r111, r113, r115, r216, r101, 715827882);
        L58:
            r216 = null;
            goto L59
        L54:
            r115 = null;
            goto L55
        L50:
            r113 = null;
            goto L51
        L46:
            r111 = null;
            goto L47
        L42:
            r110 = null;
        L65:
            return new CalendarEntity(Long.valueOf(r100), r102, AccountType.OTHERS, r103, r211, r212, r213, null, r214, r215, null, null, null, null, null, 1073408682);
        L37:
            r215 = r210.getString(4);
            goto L66
        L33:
            r214 = Integer.valueOf(r210.getInt(7));
            goto L35
        L29:
            r213 = Integer.valueOf(r210.getInt(8));
        L22:
            if (r210.isNull(5) == false) goto L24;
            r212 = null;
            goto L27
        L24:
            r105 = r210.getString(5);
            goto L25
        L17:
            r104 = Long.valueOf(r210.getLong(3));
            goto L18
        L13:
            r211 = r210.getString(6);
            goto L15
        L9:
            r103 = r210.getString(2);
            goto L11
        L5:
            r102 = r210.getString(1);
            goto L7
        }

        public static CalendarEntity b(JsonObject r410, boolean r411) {
            Intrinsics.checkNotNullParameter(r410, "json");
            boolean r110 = r410.has("id");     // Catch: Exception -> L94
            JsonElement r111 = n.a(r410, "id");     // Catch: Exception -> L94
            if (r111 == null) goto L6;
            Long r112 = Long.valueOf(r111.getAsLong());     // Catch: Exception -> L94
        L7:
            boolean r210 = r410.has("calendar_id");     // Catch: Exception -> L94
            if (r411 == false) goto L13;
            if (r210 == true) goto L13;
            throw new NullPointerException("calendar_id is null");     // Catch: Exception -> L94
        L13:
            JsonElement r113 = n.a(r410, "calendar_id");     // Catch: Exception -> L94
            if (r113 == null) goto L16;
            String r211 = r113.getAsString();     // Catch: Exception -> L94
        L17:
            boolean r212 = r410.has("account_type");     // Catch: Exception -> L94
            if (r411 == false) goto L23;
            if (r212 == true) goto L23;
            throw new NullPointerException("account_type is null");     // Catch: Exception -> L94
        L23:
            JsonElement r114 = n.a(r410, "account_type");     // Catch: Exception -> L94
            if (r114 == null) goto L30;
            String r115 = r114.getAsString();     // Catch: Exception -> L94
            if (r115 == null) goto L30;
            String r116 = r115.toUpperCase(Locale.ROOT);     // Catch: Exception -> L94
            if (r116 == null) goto L30;
            AccountType r213 = AccountType.valueOf(r116);     // Catch: Exception -> L94
        L31:
            boolean r214 = r410.has("calendar_account");     // Catch: Exception -> L94
            if (r411 == false) goto L37;
            if (r214 == true) goto L37;
            throw new NullPointerException("calendar_account is null");     // Catch: Exception -> L94
        L37:
            JsonElement r117 = n.a(r410, "calendar_account");     // Catch: Exception -> L94
            if (r117 == null) goto L40;
            String r215 = r117.getAsString();     // Catch: Exception -> L94
        L41:
            boolean r216 = r410.has("calendar_name");     // Catch: Exception -> L94
            if (r411 == false) goto L47;
            if (r216 == true) goto L47;
            throw new NullPointerException("calendar_name is null");     // Catch: Exception -> L94
        L47:
            JsonElement r118 = n.a(r410, "calendar_name");     // Catch: Exception -> L94
            if (r118 == null) goto L50;
            String r217 = r118.getAsString();     // Catch: Exception -> L94
        L51:
            boolean r218 = r410.has("calendar_color");     // Catch: Exception -> L94
            JsonElement r119 = n.a(r410, "calendar_color");     // Catch: Exception -> L94
            if (r119 == null) goto L54;
            String r219 = r119.getAsString();     // Catch: Exception -> L94
        L55:
            boolean r310 = r410.has("sync_events");     // Catch: Exception -> L94
            JsonElement r100 = n.a(r410, "sync_events");     // Catch: Exception -> L94
            if (r100 == null) goto L58;
            Integer r311 = Integer.valueOf(r100.getAsInt());     // Catch: Exception -> L94
        L59:
            boolean r312 = r410.has("last_version");     // Catch: Exception -> L94
            JsonElement r101 = n.a(r410, "last_version");     // Catch: Exception -> L94
            if (r101 == null) goto L62;
            Long r313 = Long.valueOf(r101.getAsLong());     // Catch: Exception -> L94
        L63:
            boolean r314 = r410.has("enable");     // Catch: Exception -> L94
            JsonElement r102 = n.a(r410, "enable");     // Catch: Exception -> L94
            if (r102 == null) goto L66;
            Integer r315 = Integer.valueOf(r102.getAsInt());     // Catch: Exception -> L94
        L67:
            boolean r316 = r410.has("sync_token");     // Catch: Exception -> L94
            JsonElement r103 = n.a(r410, "sync_token");     // Catch: Exception -> L94
            if (r103 == null) goto L70;
            String r317 = r103.getAsString();     // Catch: Exception -> L94
        L71:
            boolean r318 = r410.has("reminder_setting");     // Catch: Exception -> L94
            JsonElement r104 = n.a(r410, "reminder_setting");     // Catch: Exception -> L94
            if (r104 == null) goto L74;
            String r319 = r104.getAsString();     // Catch: Exception -> L94
        L75:
            boolean r412 = r410.has("userName");     // Catch: Exception -> L94
            JsonElement r105 = n.a(r410, "userName");     // Catch: Exception -> L94
            if (r105 == null) goto L78;
            String r413 = r105.getAsString();     // Catch: Exception -> L94
        L79:
            boolean r414 = r410.has("password");     // Catch: Exception -> L94
            JsonElement r106 = n.a(r410, "password");     // Catch: Exception -> L94
            if (r106 == null) goto L82;
            String r415 = r106.getAsString();     // Catch: Exception -> L94
        L83:
            boolean r416 = r410.has("server_url");     // Catch: Exception -> L94
            JsonElement r107 = n.a(r410, "server_url");     // Catch: Exception -> L94
            if (r107 == null) goto L86;
            String r417 = r107.getAsString();     // Catch: Exception -> L94
        L87:
            boolean r418 = r410.has("sync_time");     // Catch: Exception -> L94
            JsonElement r108 = n.a(r410, "sync_time");     // Catch: Exception -> L94
            if (r108 == null) goto L90;
            Long r419 = Long.valueOf(r108.getAsLong());     // Catch: Exception -> L94
        L93:
            return new CalendarEntity(r112, r110, r211, r210, r213, r212, r215, r214, r217, r216, r219, r218, r311, r310, r313, r312, r315, r314, r317, r316, r319, r318, r413, r412, r415, r414, r417, r416, r419, r418);
        L90:
            r419 = null;
            goto L93
        L86:
            r417 = null;
            goto L87
        L82:
            r415 = null;
            goto L83
        L78:
            r413 = null;
            goto L79
        L74:
            r319 = null;
            goto L75
        L70:
            r317 = null;
            goto L71
        L66:
            r315 = null;
            goto L67
        L62:
            r313 = null;
            goto L63
        L58:
            r311 = null;
            goto L59
        L54:
            r219 = null;
            goto L55
        L50:
            r217 = null;
            goto L51
        L40:
            r215 = null;
        L30:
            r213 = null;
            goto L31
        L16:
            r211 = null;
            goto L17
        L6:
            r112 = null;
            goto L7
        L96:
            return null;
        }
    }

    public CalendarEntity() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 1073741823);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CalendarEntity) == true) goto L8;
        return false;
    L8:
        CalendarEntity r101 = (CalendarEntity) r100;
        if (Intrinsics.areEqual(this.f397498a, r101.f397498a) == true) goto L12;
        return false;
    L12:
        if (this.f397499b == r101.f397499b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397500c, r101.f397500c) == true) goto L18;
        return false;
    L18:
        if (this.f397501d == r101.f397501d) goto L21;
        return false;
    L21:
        if (this.f397502e == r101.f397502e) goto L24;
        return false;
    L24:
        if (this.f397503f == r101.f397503f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f397504g, r101.f397504g) == true) goto L30;
        return false;
    L30:
        if (this.f397505h == r101.f397505h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f397506i, r101.f397506i) == true) goto L36;
        return false;
    L36:
        if (this.f397507j == r101.f397507j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f397508k, r101.f397508k) == true) goto L42;
        return false;
    L42:
        if (this.f397509l == r101.f397509l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f397510m, r101.f397510m) == true) goto L48;
        return false;
    L48:
        if (this.f397511n == r101.f397511n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f397512o, r101.f397512o) == true) goto L54;
        return false;
    L54:
        if (this.f397513p == r101.f397513p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f397514q, r101.f397514q) == true) goto L60;
        return false;
    L60:
        if (this.f397515r == r101.f397515r) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f397516s, r101.f397516s) == true) goto L66;
        return false;
    L66:
        if (this.f397517t == r101.f397517t) goto L69;
        return false;
    L69:
        if (Intrinsics.areEqual(this.f397518u, r101.f397518u) == true) goto L72;
        return false;
    L72:
        if (this.f397519v == r101.f397519v) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.f397520w, r101.f397520w) == true) goto L78;
        return false;
    L78:
        if (this.f397521x == r101.f397521x) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.f397522y, r101.f397522y) == true) goto L84;
        return false;
    L84:
        if (this.f397523z == r101.f397523z) goto L87;
        return false;
    L87:
        if (Intrinsics.areEqual(this.A, r101.A) == true) goto L90;
        return false;
    L90:
        if (this.B == r101.B) goto L93;
        return false;
    L93:
        if (Intrinsics.areEqual(this.C, r101.C) == true) goto L96;
        return false;
    L96:
        if (this.D == r101.D) goto L98;
        return false;
    L98:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f397498a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        int r104 = 1231;
        if (this.f397499b == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f397500c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f397501d == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        AccountType r112 = this.f397502e;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        if (this.f397503f == false) goto L25;
        int r115 = 1231;
    L26:
        int r116 = (r114 + r115) * 31;
        String r117 = this.f397504g;
        if (r117 != null) goto L29;
        int r118 = 0;
    L30:
        int r119 = (r116 + r118) * 31;
        if (this.f397505h == false) goto L33;
        int r120 = 1231;
    L34:
        int r121 = (r119 + r120) * 31;
        String r122 = this.f397506i;
        if (r122 != null) goto L37;
        int r123 = 0;
    L38:
        int r124 = (r121 + r123) * 31;
        if (this.f397507j == false) goto L41;
        int r125 = 1231;
    L42:
        int r126 = (r124 + r125) * 31;
        String r127 = this.f397508k;
        if (r127 != null) goto L45;
        int r128 = 0;
    L46:
        int r129 = (r126 + r128) * 31;
        if (this.f397509l == false) goto L49;
        int r130 = 1231;
    L50:
        int r131 = (r129 + r130) * 31;
        Integer r132 = this.f397510m;
        if (r132 != null) goto L53;
        int r133 = 0;
    L54:
        int r134 = (r131 + r133) * 31;
        if (this.f397511n == false) goto L57;
        int r135 = 1231;
    L58:
        int r136 = (r134 + r135) * 31;
        Long r137 = this.f397512o;
        if (r137 != null) goto L61;
        int r138 = 0;
    L62:
        int r139 = (r136 + r138) * 31;
        if (this.f397513p == false) goto L65;
        int r140 = 1231;
    L66:
        int r141 = (r139 + r140) * 31;
        Integer r142 = this.f397514q;
        if (r142 != null) goto L69;
        int r143 = 0;
    L70:
        int r144 = (r141 + r143) * 31;
        if (this.f397515r == false) goto L73;
        int r145 = 1231;
    L74:
        int r146 = (r144 + r145) * 31;
        String r147 = this.f397516s;
        if (r147 != null) goto L77;
        int r148 = 0;
    L78:
        int r149 = (r146 + r148) * 31;
        if (this.f397517t == false) goto L81;
        int r150 = 1231;
    L82:
        int r151 = (r149 + r150) * 31;
        String r152 = this.f397518u;
        if (r152 != null) goto L85;
        int r153 = 0;
    L86:
        int r154 = (r151 + r153) * 31;
        if (this.f397519v == false) goto L89;
        int r155 = 1231;
    L90:
        int r156 = (r154 + r155) * 31;
        String r157 = this.f397520w;
        if (r157 != null) goto L93;
        int r158 = 0;
    L94:
        int r159 = (r156 + r158) * 31;
        if (this.f397521x == false) goto L97;
        int r160 = 1231;
    L98:
        int r161 = (r159 + r160) * 31;
        String r162 = this.f397522y;
        if (r162 != null) goto L101;
        int r163 = 0;
    L102:
        int r164 = (r161 + r163) * 31;
        if (this.f397523z == false) goto L105;
        int r165 = 1231;
    L106:
        int r166 = (r164 + r165) * 31;
        String r167 = this.A;
        if (r167 != null) goto L109;
        int r168 = 0;
    L110:
        int r169 = (r166 + r168) * 31;
        if (this.B == false) goto L113;
        int r170 = 1231;
    L114:
        int r171 = (r169 + r170) * 31;
        Long r172 = this.C;
        if (r172 == null) goto L118;
        r101 = r172.hashCode();
    L118:
        int r173 = (r171 + r101) * 31;
        if (this.D == true) goto L123;
        r104 = 1237;
    L123:
        return r173 + r104;
    L113:
        r170 = 1237;
        goto L114
    L109:
        r168 = r167.hashCode();
        goto L110
    L105:
        r165 = 1237;
        goto L106
    L101:
        r163 = r162.hashCode();
        goto L102
    L97:
        r160 = 1237;
        goto L98
    L93:
        r158 = r157.hashCode();
        goto L94
    L89:
        r155 = 1237;
        goto L90
    L85:
        r153 = r152.hashCode();
        goto L86
    L81:
        r150 = 1237;
        goto L82
    L77:
        r148 = r147.hashCode();
        goto L78
    L73:
        r145 = 1237;
        goto L74
    L69:
        r143 = r142.hashCode();
        goto L70
    L65:
        r140 = 1237;
        goto L66
    L61:
        r138 = r137.hashCode();
        goto L62
    L57:
        r135 = 1237;
        goto L58
    L53:
        r133 = r132.hashCode();
        goto L54
    L49:
        r130 = 1237;
        goto L50
    L45:
        r128 = r127.hashCode();
        goto L46
    L41:
        r125 = 1237;
        goto L42
    L37:
        r123 = r122.hashCode();
        goto L38
    L33:
        r120 = 1237;
        goto L34
    L29:
        r118 = r117.hashCode();
        goto L30
    L25:
        r115 = 1237;
        goto L26
    L21:
        r113 = r112.hashCode();
        goto L22
    L17:
        r110 = 1237;
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CalendarEntity(id=" + this.f397498a + ", hasId=" + this.f397499b + ", calendarId=" + this.f397500c + ", hasCalendarId=" + this.f397501d + ", accountType=" + this.f397502e + ", hasAccountType=" + this.f397503f + ", calendarAccount=" + this.f397504g + ", hasCalendarAccount=" + this.f397505h + ", calendarName=" + this.f397506i + ", hasCalendarName=" + this.f397507j + ", calendarColor=" + this.f397508k + ", hasCalendarColor=" + this.f397509l + ", syncEvents=" + this.f397510m + ", hasSyncEvents=" + this.f397511n + ", lastVersion=" + this.f397512o + ", hasLastVersion=" + this.f397513p + ", enable=" + this.f397514q + ", hasEnable=" + this.f397515r + ", syncToken=" + this.f397516s + ", hasSyncToken=" + this.f397517t + ", reminderSetting=" + this.f397518u + ", hasReminderSetting=" + this.f397519v + ", userName=" + this.f397520w + ", hasUserName=" + this.f397521x + ", password=" + this.f397522y + ", hasPassword=" + this.f397523z + ", serverUrl=" + this.A + ", hasServerUrl=" + this.B + ", syncTime=" + this.C + ", hasSyncTime=" + this.D + ')';
    }

    static {
        E = new String[]{DBDefinition.ID, "name", "account_name", "calendar_color", "_sync_id", "calendar_color_index", "calendar_displayName", "visible", "sync_events", "cal_sync1"};
    }

    public final JsonObject a() {
        JsonObject r100 = new JsonObject();
        if (this.f397499b == false) goto L6;
        r100.addProperty("id", this.f397498a);
    L6:
        if (this.f397501d == false) goto L9;
        r100.addProperty("calendar_id", this.f397500c);
    L9:
        if (this.f397503f == false) goto L16;
        AccountType r101 = this.f397502e;
        if (r101 == null) goto L13;
        String r102 = r101.name();
    L14:
        r100.addProperty("account_type", r102);
        goto L16
    L13:
        r102 = null;
    L16:
        if (this.f397505h == false) goto L19;
        r100.addProperty("calendar_account", this.f397504g);
    L19:
        if (this.f397507j == false) goto L22;
        r100.addProperty("calendar_name", this.f397506i);
    L22:
        if (this.f397509l == false) goto L25;
        r100.addProperty("calendar_color", this.f397508k);
    L25:
        if (this.f397511n == false) goto L28;
        r100.addProperty("sync_events", this.f397510m);
    L28:
        if (this.f397513p == false) goto L31;
        r100.addProperty("last_version", this.f397512o);
    L31:
        if (this.f397515r == false) goto L34;
        r100.addProperty("enable", this.f397514q);
    L34:
        if (this.f397517t == false) goto L37;
        r100.addProperty("sync_token", this.f397516s);
    L37:
        if (this.f397519v == false) goto L40;
        r100.addProperty("reminder_setting", this.f397518u);
    L40:
        if (this.f397521x == false) goto L43;
        r100.addProperty("userName", this.f397520w);
    L43:
        if (this.f397523z == false) goto L46;
        r100.addProperty("password", this.f397522y);
    L46:
        if (this.B == false) goto L49;
        r100.addProperty("server_url", this.A);
    L49:
        if (this.D == false) goto L51;
        r100.addProperty("sync_time", this.C);
    L51:
        return r100;
    }

    public /* synthetic */ CalendarEntity(Long r310, String r311, AccountType r312, String r313, String r314, String r410, Integer r411, Long r412, Integer r413, String r414, String r415, String r416, String r417, String r418, Long r419, int r510) {
        if ((r510 & 1) == 0) goto L5;
        Long r100 = null;
    L7:
        if ((r510 & 2) == 0) goto L10;
        if (r100 == null) goto L10;
        boolean r101 = true;
    L12:
        if ((r510 & 4) == 0) goto L14;
        String r102 = null;
    L16:
        if ((r510 & 8) == 0) goto L19;
        if (r102 == null) goto L19;
        boolean r103 = true;
    L21:
        if ((r510 & 16) == 0) goto L23;
        AccountType r104 = null;
    L25:
        if ((r510 & 32) == 0) goto L28;
        if (r104 == null) goto L28;
        boolean r105 = true;
    L30:
        if ((r510 & 64) == 0) goto L32;
        String r110 = null;
    L34:
        if ((r510 & 128) == 0) goto L37;
        if (r110 == null) goto L37;
        boolean r111 = true;
    L39:
        if ((r510 & 256) == 0) goto L41;
        String r112 = null;
    L43:
        if ((r510 & 512) == 0) goto L46;
        if (r112 == null) goto L46;
        boolean r113 = true;
    L48:
        if ((r510 & 1024) == 0) goto L50;
        String r114 = null;
    L52:
        if ((r510 & 2048) == 0) goto L55;
        if (r114 == null) goto L55;
        boolean r115 = true;
    L57:
        if ((r510 & 4096) == 0) goto L59;
        Integer r106 = null;
    L61:
        if ((r510 & 8192) == 0) goto L64;
        if (r106 == null) goto L64;
        boolean r116 = true;
    L66:
        if ((r510 & 16384) == 0) goto L68;
        Long r117 = null;
    L70:
        if ((32768 & r510) == 0) goto L73;
        if (r117 == null) goto L73;
        boolean r118 = true;
    L75:
        if ((65536 & r510) == 0) goto L77;
        Integer r210 = null;
    L79:
        if ((131072 & r510) == 0) goto L82;
        if (r210 == null) goto L82;
        boolean r211 = true;
    L84:
        if ((262144 & r510) == 0) goto L86;
        String r212 = null;
    L88:
        if ((524288 & r510) == 0) goto L91;
        if (r212 == null) goto L91;
        boolean r213 = true;
    L93:
        if ((1048576 & r510) == 0) goto L95;
        String r214 = null;
    L97:
        if ((2097152 & r510) == 0) goto L100;
        if (r214 == null) goto L100;
        boolean r215 = true;
    L102:
        if ((4194304 & r510) == 0) goto L104;
        String r216 = null;
    L106:
        if ((8388608 & r510) == 0) goto L109;
        if (r216 == null) goto L109;
        boolean r217 = true;
    L111:
        if ((16777216 & r510) == 0) goto L113;
        String r218 = null;
    L115:
        if ((33554432 & r510) == 0) goto L118;
        if (r218 == null) goto L118;
        boolean r219 = true;
    L120:
        if ((67108864 & r510) == 0) goto L122;
        String r315 = null;
    L124:
        if ((134217728 & r510) == 0) goto L127;
        if (r315 == null) goto L127;
        boolean r316 = true;
    L129:
        if ((268435456 & r510) == 0) goto L131;
        Long r317 = null;
    L133:
        if ((r510 & 536870912) == 0) goto L136;
        if (r317 == null) goto L136;
        boolean r318 = true;
    L137:
        this(r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r116, r117, r118, r210, r211, r212, r213, r214, r215, r216, r217, r218, r219, r315, r316, r317, r318);
        return;
    L136:
        r318 = false;
        goto L137
    L131:
        r317 = r419;
    L127:
        r316 = false;
        goto L129
    L122:
        r315 = r418;
    L118:
        r219 = false;
        goto L120
    L113:
        r218 = r417;
    L109:
        r217 = false;
        goto L111
    L104:
        r216 = r416;
    L100:
        r215 = false;
        goto L102
    L95:
        r214 = r415;
    L91:
        r213 = false;
        goto L93
    L86:
        r212 = r414;
    L82:
        r211 = false;
        goto L84
    L77:
        r210 = r413;
    L73:
        r118 = false;
        goto L75
    L68:
        r117 = r412;
    L64:
        r116 = false;
        goto L66
    L59:
        r106 = r411;
    L55:
        r115 = false;
        goto L57
    L50:
        r114 = r410;
    L46:
        r113 = false;
        goto L48
    L41:
        r112 = r314;
    L37:
        r111 = false;
        goto L39
    L32:
        r110 = r313;
    L28:
        r105 = false;
        goto L30
    L23:
        r104 = r312;
    L19:
        r103 = false;
        goto L21
    L14:
        r102 = r311;
    L10:
        r101 = false;
        goto L12
    L5:
        r100 = r310;
        goto L7
    }

    public CalendarEntity(Long r100, boolean r101, String r102, boolean r103, AccountType r104, boolean r105, String r106, boolean r110, String r111, boolean r112, String r113, boolean r114, Integer r115, boolean r116, Long r117, boolean r118, Integer r119, boolean r210, String r211, boolean r212, String r213, boolean r214, String r215, boolean r216, String r217, boolean r218, String r219, boolean r310, Long r311, boolean r312) {
        this.f397498a = r100;
        this.f397499b = r101;
        this.f397500c = r102;
        this.f397501d = r103;
        this.f397502e = r104;
        this.f397503f = r105;
        this.f397504g = r106;
        this.f397505h = r110;
        this.f397506i = r111;
        this.f397507j = r112;
        this.f397508k = r113;
        this.f397509l = r114;
        this.f397510m = r115;
        this.f397511n = r116;
        this.f397512o = r117;
        this.f397513p = r118;
        this.f397514q = r119;
        this.f397515r = r210;
        this.f397516s = r211;
        this.f397517t = r212;
        this.f397518u = r213;
        this.f397519v = r214;
        this.f397520w = r215;
        this.f397521x = r216;
        this.f397522y = r217;
        this.f397523z = r218;
        this.A = r219;
        this.B = r310;
        this.C = r311;
        this.D = r312;
    }
}
