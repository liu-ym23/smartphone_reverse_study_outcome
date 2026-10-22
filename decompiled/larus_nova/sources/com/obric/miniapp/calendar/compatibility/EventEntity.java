package com.obric.miniapp.calendar.compatibility;

import android.database.Cursor;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.obric.miniapp.alarm.AlarmSessionType;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import com.ttnet.org.chromium.net.impl.URLDispatch;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import vka.n;

/* JADX INFO: loaded from: classes33.dex */
public final class EventEntity {

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public static final String[] f397526w0 = null;
    public final String A;
    public final boolean B;
    public final String C;
    public final boolean D;
    public final String E;
    public final boolean F;
    public final String G;
    public final boolean H;
    public final String I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final boolean f397527J;
    public final String K;
    public final boolean L;
    public final Long M;
    public final boolean N;
    public final Long O;
    public final boolean P;
    public final Integer Q;
    public final boolean R;
    public final String S;
    public final boolean T;
    public final Integer U;
    public final boolean V;
    public final EventFreq W;
    public final boolean X;
    public final Integer Y;
    public final boolean Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f397528a;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public final Long f397529a0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f397530b;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public final boolean f397531b0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f397532c;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final Integer f397533c0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f397534d;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final boolean f397535d0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f397536e;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final Integer f397537e0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f397538f;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final boolean f397539f0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f397540g;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final Long f397541g0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f397542h;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final boolean f397543h0;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f397544i;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public final Long f397545i0;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f397546j;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public final boolean f397547j0;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Long f397548k;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public final String f397549k0;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f397550l;

    /* JADX INFO: renamed from: l0, reason: collision with root package name */
    public final boolean f397551l0;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Long f397552m;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public final String f397553m0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f397554n;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public final boolean f397555n0;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Long f397556o;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public final Boolean f397557o0;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f397558p;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public final boolean f397559p0;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Long f397560q;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public final String f397561q0;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final boolean f397562r;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public final boolean f397563r0;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Integer f397564s;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final Long f397565s0;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f397566t;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final boolean f397567t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final EventType f397568u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final String f397569u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final boolean f397570v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final boolean f397571v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f397572w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f397573x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f397574y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final boolean f397575z;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/miniapp/calendar/compatibility/EventEntity$EventFreq;", "", "<init>", "(Ljava/lang/String;I)V", "DAILY", "WEEKLY", "MONTHLY", "YEARLY", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EventFreq extends Enum<EventFreq> {
        public static final EventFreq DAILY = null;
        public static final EventFreq MONTHLY = null;
        public static final EventFreq WEEKLY = null;
        public static final EventFreq YEARLY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventFreq[] f397576a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f397577b = null;

        public static EnumEntries<EventFreq> getEntries() {
            return f397577b;
        }

        static {
            EventFreq r100 = new EventFreq("DAILY", 0);
            DAILY = r100;
            EventFreq r101 = new EventFreq("WEEKLY", 1);
            WEEKLY = r101;
            EventFreq r102 = new EventFreq("MONTHLY", 2);
            MONTHLY = r102;
            EventFreq r103 = new EventFreq("YEARLY", 3);
            YEARLY = r103;
            EventFreq[] r104 = {r100, r101, r102, r103};
            f397576a = r104;
            f397577b = EnumEntriesKt.enumEntries(r104);
        }

        public static EventFreq[] values() {
            return (EventFreq[]) f397576a.clone();
        }

        public static EventFreq valueOf(String r100) {
            return (EventFreq) r27.a.a(EventFreq.class, r100);
        }

        public EventFreq(String r100, int r101) {
            super(r100, r101);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/miniapp/calendar/compatibility/EventEntity$EventType;", "", "<init>", "(Ljava/lang/String;I)V", AlarmSessionType.EVENT, AlarmSessionType.TODO, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum EventType extends Enum<EventType> {
        public static final EventType EVENT = null;
        public static final EventType TODO = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ EventType[] f397578a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f397579b = null;

        public static EnumEntries<EventType> getEntries() {
            return f397579b;
        }

        static {
            EventType r100 = new EventType(AlarmSessionType.EVENT, 0);
            EVENT = r100;
            EventType r101 = new EventType(AlarmSessionType.TODO, 1);
            TODO = r101;
            EventType[] r102 = {r100, r101};
            f397578a = r102;
            f397579b = EnumEntriesKt.enumEntries(r102);
        }

        public static EventType[] values() {
            return (EventType[]) f397578a.clone();
        }

        public static EventType valueOf(String r100) {
            return (EventType) r27.a.a(EventType.class, r100);
        }

        public EventType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public static EventEntity a(Cursor r610) {
            Intrinsics.checkNotNullParameter(r610, "c");
            long r100 = r610.getLong(0);
            Long r101 = null;
            if (r610.isNull(1) == false) goto L5;
            String r102 = null;
        L6:
            if (r102 == null) goto L8;
            Long r103 = StringsKt.toLongOrNull(r102);
        L9:
            long r410 = r610.getLong(2);
            if (r610.isNull(3) == false) goto L12;
            String r104 = null;
        L13:
            if (r104 != null) goto L16;
            r104 = "";
        L16:
            if (r610.isNull(4) == false) goto L18;
            String r411 = null;
        L20:
            if (r610.isNull(5) == false) goto L22;
            String r510 = null;
        L24:
            if (r610.isNull(6) == false) goto L26;
            Integer r105 = null;
        L27:
            if (r105 == null) goto L29;
            String r511 = r105.toString();
        L30:
            long r512 = r610.getLong(7);
            if (r610.isNull(8) == false) goto L33;
            Long r513 = null;
        L35:
            if (r610.isNull(9) == false) goto L37;
            String r514 = null;
        L39:
            if (r610.isNull(10) == false) goto L41;
            Integer r515 = null;
        L43:
            if (r610.isNull(11) == false) goto L45;
            String r516 = null;
        L47:
            if (r610.isNull(12) == false) goto L49;
            String r517 = null;
        L51:
            if (r610.isNull(13) == false) goto L53;
            String r518 = null;
        L55:
            if (r610.isNull(14) == false) goto L57;
            String r611 = null;
        L59:
            if (r610.isNull(15) == false) goto L61;
            String r106 = null;
        L62:
            if (r106 == null) goto L64;
            Long r612 = StringsKt.toLongOrNull(r106);
        L66:
            if (r610.isNull(16) == false) goto L68;
            Long r613 = null;
        L70:
            if (r610.isNull(17) == false) goto L72;
            Integer r614 = null;
        L74:
            if (r610.isNull(18) == false) goto L76;
            String r615 = null;
        L78:
            if (r610.isNull(19) == false) goto L80;
            String r616 = null;
        L82:
            if (r610.isNull(21) == false) goto L84;
            String r617 = null;
        L151:
            JsonObject r107 = JsonParser.parseString(r610.getString(20)).getAsJsonObject();     // Catch: Exception -> L149
            Intrinsics.checkNotNull(r107);     // Catch: Exception -> L149
            JsonElement r108 = n.a(r107, "originalDtStart");     // Catch: Exception -> L149
            if (r108 == null) goto L89;
            Long r109 = Long.valueOf(r108.getAsLong());     // Catch: Exception -> L149
        L90:
            JsonElement r110 = n.a(r107, DBDefinition.ETAG);     // Catch: Exception -> L149
            if (r110 == null) goto L93;
            Long r111 = Long.valueOf(r110.getAsLong());     // Catch: Exception -> L149
        L94:
            long r112 = r107.get("dtStamp").getAsLong();     // Catch: Exception -> L149
            long r113 = r107.get("createTime").getAsLong();     // Catch: Exception -> L149
            EventType r114 = EventType.valueOf(r107.get("eventType").getAsString());     // Catch: Exception -> L149
            JsonElement r115 = n.a(r107, "iCalStr");     // Catch: Exception -> L149
            if (r115 == null) goto L97;
            String r210 = r115.getAsString();     // Catch: Exception -> L149
        L98:
            JsonElement r116 = n.a(r107, "isCompleted");     // Catch: Exception -> L149
            if (r116 == null) goto L101;
            Integer r310 = Integer.valueOf(r116.getAsInt());     // Catch: Exception -> L149
        L102:
            JsonElement r117 = n.a(r107, "freq");     // Catch: Exception -> L149
            if (r117 == null) goto L107;
            String r118 = r117.getAsString();     // Catch: Exception -> L149
            if (r118 == null) goto L107;
            EventFreq r311 = EventFreq.valueOf(r118);     // Catch: Exception -> L149
        L108:
            JsonElement r119 = n.a(r107, VideoThumbInfo.KEY_INTERVAL);     // Catch: Exception -> L149
            if (r119 == null) goto L111;
            Integer r312 = Integer.valueOf(r119.getAsInt());     // Catch: Exception -> L149
        L112:
            JsonElement r120 = n.a(r107, "until");     // Catch: Exception -> L149
            if (r120 == null) goto L115;
            Long r313 = Long.valueOf(r120.getAsLong());     // Catch: Exception -> L149
        L116:
            JsonElement r121 = n.a(r107, "exStatus");     // Catch: Exception -> L149
            if (r121 == null) goto L119;
            Integer r314 = Integer.valueOf(r121.getAsInt());     // Catch: Exception -> L149
        L120:
            JsonElement r122 = n.a(r107, "index");     // Catch: Exception -> L149
            if (r122 == null) goto L123;
            Integer r315 = Integer.valueOf(r122.getAsInt());     // Catch: Exception -> L149
        L124:
            JsonElement r123 = n.a(r107, "exDtStart");     // Catch: Exception -> L149
            if (r123 == null) goto L127;
            Long r316 = Long.valueOf(r123.getAsLong());     // Catch: Exception -> L149
        L128:
            JsonElement r124 = n.a(r107, "exDtEnd");     // Catch: Exception -> L149
            if (r124 == null) goto L131;
            Long r317 = Long.valueOf(r124.getAsLong());     // Catch: Exception -> L149
        L132:
            JsonElement r125 = n.a(r107, "syncStatus");     // Catch: Exception -> L149
            if (r125 == null) goto L135;
            String r318 = r125.getAsString();     // Catch: Exception -> L149
        L136:
            JsonElement r126 = n.a(r107, "isNoTimeTodo");     // Catch: Exception -> L149
            if (r126 == null) goto L139;
            Boolean r412 = Boolean.valueOf(r126.getAsBoolean());     // Catch: Exception -> L149
        L140:
            JsonElement r127 = n.a(r107, "completeTime");     // Catch: Exception -> L149
            if (r127 == null) goto L143;
            r101 = Long.valueOf(r127.getAsLong());     // Catch: Exception -> L149
        L143:
            Long r413 = r101;
            if (r109 == null) goto L146;
            long r128 = r109.longValue();     // Catch: Exception -> L149
        L147:
            return new EventEntity(Long.valueOf(r100), r103, Long.valueOf(r410), r104, Long.valueOf(r128), r111, r513, Long.valueOf(r112), Long.valueOf(r113), r515, r114, r510, r411, r511, r514, r516, r517, r518, r611, r612, r613, r614, r210, r310, r311, r312, r313, r314, r315, r316, r317, r318, r617, r412, r615, r413, r616, -1431655766, -1431655766, 682);
        L146:
            r128 = r512;
            goto L147
        L139:
            r412 = null;
            goto L140
        L135:
            r318 = null;
            goto L136
        L131:
            r317 = null;
            goto L132
        L127:
            r316 = null;
            goto L128
        L123:
            r315 = null;
            goto L124
        L119:
            r314 = null;
            goto L120
        L115:
            r313 = null;
            goto L116
        L111:
            r312 = null;
        L107:
            r311 = null;
            goto L108
        L101:
            r310 = null;
            goto L102
        L97:
            r210 = null;
            goto L98
        L93:
            r111 = null;
            goto L94
        L89:
            r109 = null;
        L150:
            return new EventEntity(Long.valueOf(r100), r103, Long.valueOf(r410), r104, Long.valueOf(r512), null, r513, 0L, 0L, r515, EventType.EVENT, r510, r411, r511, r514, r516, r517, r518, r611, r612, r613, r614, null, null, null, null, null, null, null, null, null, null, r617, null, r615, null, r616, -1431654742, -1366, 750);
        L84:
            r617 = r610.getString(21);
            goto L151
        L80:
            r616 = r610.getString(19);
            goto L82
        L76:
            r615 = r610.getString(18);
            goto L78
        L72:
            r614 = Integer.valueOf(r610.getInt(17));
            goto L74
        L68:
            r613 = Long.valueOf(r610.getLong(16));
            goto L70
        L64:
            r612 = null;
            goto L66
        L61:
            r106 = r610.getString(15);
            goto L62
        L57:
            r611 = r610.getString(14);
            goto L59
        L53:
            r518 = r610.getString(13);
            goto L55
        L49:
            r517 = r610.getString(12);
            goto L51
        L45:
            r516 = r610.getString(11);
            goto L47
        L41:
            r515 = Integer.valueOf(r610.getInt(10));
            goto L43
        L37:
            r514 = r610.getString(9);
            goto L39
        L33:
            r513 = Long.valueOf(r610.getLong(8));
            goto L35
        L29:
            r511 = null;
            goto L30
        L26:
            r105 = Integer.valueOf(r610.getInt(6));
            goto L27
        L22:
            r510 = r610.getString(5);
            goto L24
        L18:
            r411 = r610.getString(4);
            goto L20
        L12:
            r104 = r610.getString(3);
            goto L13
        L8:
            r103 = null;
            goto L9
        L5:
            r102 = r610.getString(1);
            goto L6
        }

        public static EventEntity b(JsonObject r114) {
            Intrinsics.checkNotNullParameter(r114, "json");
            boolean r410 = r114.has("id");     // Catch: Exception -> L158
            JsonElement r100 = n.a(r114, "id");     // Catch: Exception -> L158
            if (r100 == null) goto L6;
            Long r411 = Long.valueOf(r100.getAsLong());     // Catch: Exception -> L158
        L7:
            boolean r412 = r114.has(ST.UUID_DEVICE);     // Catch: Exception -> L158
            JsonElement r101 = n.a(r114, ST.UUID_DEVICE);     // Catch: Exception -> L158
            if (r101 == null) goto L10;
            Long r413 = Long.valueOf(r101.getAsLong());     // Catch: Exception -> L158
        L11:
            boolean r414 = r114.has("calendar_id");     // Catch: Exception -> L158
            JsonElement r102 = n.a(r114, "calendar_id");     // Catch: Exception -> L158
            if (r102 == null) goto L14;
            Long r415 = Long.valueOf(r102.getAsLong());     // Catch: Exception -> L158
        L15:
            boolean r416 = r114.has("title");     // Catch: Exception -> L158
            JsonElement r103 = n.a(r114, "title");     // Catch: Exception -> L158
            if (r103 == null) goto L18;
            String r417 = r103.getAsString();     // Catch: Exception -> L158
        L19:
            boolean r418 = r114.has("dtstart");     // Catch: Exception -> L158
            JsonElement r104 = n.a(r114, "dtstart");     // Catch: Exception -> L158
            if (r104 == null) goto L22;
            Long r419 = Long.valueOf(r104.getAsLong());     // Catch: Exception -> L158
        L23:
            boolean r510 = r114.has(URLDispatch.KEY_ETAG);     // Catch: Exception -> L158
            JsonElement r105 = n.a(r114, URLDispatch.KEY_ETAG);     // Catch: Exception -> L158
            if (r105 == null) goto L26;
            Long r511 = Long.valueOf(r105.getAsLong());     // Catch: Exception -> L158
        L27:
            boolean r512 = r114.has("dtend");     // Catch: Exception -> L158
            JsonElement r106 = n.a(r114, "dtend");     // Catch: Exception -> L158
            if (r106 == null) goto L30;
            Long r513 = Long.valueOf(r106.getAsLong());     // Catch: Exception -> L158
        L31:
            boolean r514 = r114.has("dtstamp");     // Catch: Exception -> L158
            JsonElement r107 = n.a(r114, "dtstamp");     // Catch: Exception -> L158
            if (r107 == null) goto L34;
            Long r515 = Long.valueOf(r107.getAsLong());     // Catch: Exception -> L158
        L35:
            boolean r516 = r114.has("create_time");     // Catch: Exception -> L158
            JsonElement r108 = n.a(r114, "create_time");     // Catch: Exception -> L158
            if (r108 == null) goto L38;
            Long r517 = Long.valueOf(r108.getAsLong());     // Catch: Exception -> L158
        L39:
            boolean r518 = r114.has("all_day");     // Catch: Exception -> L158
            JsonElement r109 = n.a(r114, "all_day");     // Catch: Exception -> L158
            if (r109 == null) goto L42;
            Integer r519 = Integer.valueOf(r109.getAsInt());     // Catch: Exception -> L158
        L43:
            boolean r610 = r114.has("event_type");     // Catch: Exception -> L158
            JsonElement r110 = n.a(r114, "event_type");     // Catch: Exception -> L158
            if (r110 == null) goto L48;
            String r111 = r110.getAsString();     // Catch: Exception -> L158
            if (r111 == null) goto L48;
            EventType r611 = EventType.valueOf(r111);     // Catch: Exception -> L158
        L49:
            boolean r612 = r114.has("description");     // Catch: Exception -> L158
            JsonElement r112 = n.a(r114, "description");     // Catch: Exception -> L158
            if (r112 == null) goto L52;
            String r613 = r112.getAsString();     // Catch: Exception -> L158
        L53:
            boolean r614 = r114.has("event_location");     // Catch: Exception -> L158
            JsonElement r113 = n.a(r114, "event_location");     // Catch: Exception -> L158
            if (r113 == null) goto L56;
            String r615 = r113.getAsString();     // Catch: Exception -> L158
        L57:
            boolean r616 = r114.has("event_color");     // Catch: Exception -> L158
            JsonElement r115 = n.a(r114, "event_color");     // Catch: Exception -> L158
            if (r115 == null) goto L60;
            String r617 = r115.getAsString();     // Catch: Exception -> L158
        L61:
            boolean r618 = r114.has("duration");     // Catch: Exception -> L158
            JsonElement r116 = n.a(r114, "duration");     // Catch: Exception -> L158
            if (r116 == null) goto L64;
            String r619 = r116.getAsString();     // Catch: Exception -> L158
        L65:
            boolean r710 = r114.has("rrule");     // Catch: Exception -> L158
            JsonElement r117 = n.a(r114, "rrule");     // Catch: Exception -> L158
            if (r117 == null) goto L68;
            String r711 = r117.getAsString();     // Catch: Exception -> L158
        L69:
            boolean r712 = r114.has("rdate");     // Catch: Exception -> L158
            JsonElement r118 = n.a(r114, "rdate");     // Catch: Exception -> L158
            if (r118 == null) goto L72;
            String r713 = r118.getAsString();     // Catch: Exception -> L158
        L73:
            boolean r714 = r114.has("exrule");     // Catch: Exception -> L158
            JsonElement r119 = n.a(r114, "exrule");     // Catch: Exception -> L158
            if (r119 == null) goto L76;
            String r715 = r119.getAsString();     // Catch: Exception -> L158
        L77:
            boolean r716 = r114.has("exdate");     // Catch: Exception -> L158
            JsonElement r120 = n.a(r114, "exdate");     // Catch: Exception -> L158
            if (r120 == null) goto L80;
            String r717 = r120.getAsString();     // Catch: Exception -> L158
        L81:
            boolean r718 = r114.has("original_id");     // Catch: Exception -> L158
            JsonElement r121 = n.a(r114, "original_id");     // Catch: Exception -> L158
            if (r121 == null) goto L84;
            Long r719 = Long.valueOf(r121.getAsLong());     // Catch: Exception -> L158
        L85:
            boolean r810 = r114.has("original_instance_time");     // Catch: Exception -> L158
            JsonElement r122 = n.a(r114, "original_instance_time");     // Catch: Exception -> L158
            if (r122 == null) goto L88;
            Long r811 = Long.valueOf(r122.getAsLong());     // Catch: Exception -> L158
        L89:
            boolean r812 = r114.has("original_all_day");     // Catch: Exception -> L158
            JsonElement r123 = n.a(r114, "original_all_day");     // Catch: Exception -> L158
            if (r123 == null) goto L92;
            Integer r813 = Integer.valueOf(r123.getAsInt());     // Catch: Exception -> L158
        L93:
            boolean r814 = r114.has("ical_str");     // Catch: Exception -> L158
            JsonElement r124 = n.a(r114, "ical_str");     // Catch: Exception -> L158
            if (r124 == null) goto L96;
            String r815 = r124.getAsString();     // Catch: Exception -> L158
        L97:
            boolean r816 = r114.has("is_completed");     // Catch: Exception -> L158
            JsonElement r125 = n.a(r114, "is_completed");     // Catch: Exception -> L158
            if (r125 == null) goto L100;
            Integer r817 = Integer.valueOf(r125.getAsInt());     // Catch: Exception -> L158
        L101:
            boolean r818 = r114.has("freq");     // Catch: Exception -> L158
            JsonElement r126 = n.a(r114, "freq");     // Catch: Exception -> L158
            if (r126 == null) goto L106;
            String r127 = r126.getAsString();     // Catch: Exception -> L158
            if (r127 == null) goto L106;
            EventFreq r819 = EventFreq.valueOf(r127);     // Catch: Exception -> L158
        L107:
            boolean r910 = r114.has(VideoThumbInfo.KEY_INTERVAL);     // Catch: Exception -> L158
            JsonElement r128 = n.a(r114, VideoThumbInfo.KEY_INTERVAL);     // Catch: Exception -> L158
            if (r128 == null) goto L110;
            Integer r911 = Integer.valueOf(r128.getAsInt());     // Catch: Exception -> L158
        L111:
            boolean r912 = r114.has("until");     // Catch: Exception -> L158
            JsonElement r129 = n.a(r114, "until");     // Catch: Exception -> L158
            if (r129 == null) goto L114;
            Long r913 = Long.valueOf(r129.getAsLong());     // Catch: Exception -> L158
        L115:
            boolean r914 = r114.has("exstatus");     // Catch: Exception -> L158
            JsonElement r130 = n.a(r114, "exstatus");     // Catch: Exception -> L158
            if (r130 == null) goto L118;
            Integer r915 = Integer.valueOf(r130.getAsInt());     // Catch: Exception -> L158
        L119:
            boolean r916 = r114.has("index");     // Catch: Exception -> L158
            JsonElement r131 = n.a(r114, "index");     // Catch: Exception -> L158
            if (r131 == null) goto L122;
            Integer r917 = Integer.valueOf(r131.getAsInt());     // Catch: Exception -> L158
        L123:
            boolean r918 = r114.has("exdtstart");     // Catch: Exception -> L158
            JsonElement r132 = n.a(r114, "exdtstart");     // Catch: Exception -> L158
            if (r132 == null) goto L126;
            Long r919 = Long.valueOf(r132.getAsLong());     // Catch: Exception -> L158
        L127:
            boolean r1010 = r114.has("exdtend");     // Catch: Exception -> L158
            JsonElement r133 = n.a(r114, "exdtend");     // Catch: Exception -> L158
            if (r133 == null) goto L130;
            Long r1011 = Long.valueOf(r133.getAsLong());     // Catch: Exception -> L158
        L131:
            boolean r1012 = r114.has("lark_uuid");     // Catch: Exception -> L158
            JsonElement r134 = n.a(r114, "lark_uuid");     // Catch: Exception -> L158
            if (r134 == null) goto L134;
            String r1013 = r134.getAsString();     // Catch: Exception -> L158
        L135:
            boolean r1014 = r114.has("sync_status");     // Catch: Exception -> L158
            JsonElement r135 = n.a(r114, "sync_status");     // Catch: Exception -> L158
            if (r135 == null) goto L138;
            String r1015 = r135.getAsString();     // Catch: Exception -> L158
        L139:
            boolean r1016 = r114.has("is_no_time_todo");     // Catch: Exception -> L158
            JsonElement r136 = n.a(r114, "is_no_time_todo");     // Catch: Exception -> L158
            if (r136 == null) goto L142;
            Boolean r1017 = Boolean.valueOf(r136.getAsBoolean());     // Catch: Exception -> L158
        L143:
            boolean r1018 = r114.has("memory_extra");     // Catch: Exception -> L158
            JsonElement r137 = n.a(r114, "memory_extra");     // Catch: Exception -> L158
            if (r137 == null) goto L146;
            String r1019 = r137.getAsString();     // Catch: Exception -> L158
        L147:
            boolean r1110 = r114.has("completed_time");     // Catch: Exception -> L158
            JsonElement r138 = n.a(r114, "completed_time");     // Catch: Exception -> L158
            if (r138 == null) goto L150;
            Long r1111 = Long.valueOf(r138.getAsLong());     // Catch: Exception -> L158
        L151:
            boolean r1112 = r114.has("extra_location_info");     // Catch: Exception -> L158
            JsonElement r139 = n.a(r114, "extra_location_info");     // Catch: Exception -> L158
            if (r139 == null) goto L154;
            String r1113 = r139.getAsString();     // Catch: Exception -> L158
        L155:
            return new EventEntity(r411, r410, r413, r412, r415, r414, r417, r416, r419, r418, r511, r510, r513, r512, r515, r514, r517, r516, r519, r518, r611, r610, r613, r612, r615, r614, r617, r616, r619, r618, r711, r710, r713, r712, r715, r714, r717, r716, r719, r718, r811, r810, r813, r812, r815, r814, r817, r816, r819, r818, r911, r910, r913, r912, r915, r914, r917, r916, r919, r918, r1011, r1010, r1015, r1014, r1013, r1012, r1017, r1016, r1019, r1018, r1111, r1110, r1113, r1112);
        L154:
            r1113 = null;
            goto L155
        L150:
            r1111 = null;
            goto L151
        L146:
            r1019 = null;
            goto L147
        L142:
            r1017 = null;
            goto L143
        L138:
            r1015 = null;
            goto L139
        L134:
            r1013 = null;
            goto L135
        L130:
            r1011 = null;
            goto L131
        L126:
            r919 = null;
            goto L127
        L122:
            r917 = null;
            goto L123
        L118:
            r915 = null;
            goto L119
        L114:
            r913 = null;
            goto L115
        L110:
            r911 = null;
        L106:
            r819 = null;
            goto L107
        L100:
            r817 = null;
            goto L101
        L96:
            r815 = null;
            goto L97
        L92:
            r813 = null;
            goto L93
        L88:
            r811 = null;
            goto L89
        L84:
            r719 = null;
            goto L85
        L80:
            r717 = null;
            goto L81
        L76:
            r715 = null;
            goto L77
        L72:
            r713 = null;
            goto L73
        L68:
            r711 = null;
            goto L69
        L64:
            r619 = null;
            goto L65
        L60:
            r617 = null;
            goto L61
        L56:
            r615 = null;
            goto L57
        L52:
            r613 = null;
        L48:
            r611 = null;
            goto L49
        L42:
            r519 = null;
            goto L43
        L38:
            r517 = null;
            goto L39
        L34:
            r515 = null;
            goto L35
        L30:
            r513 = null;
            goto L31
        L26:
            r511 = null;
            goto L27
        L22:
            r419 = null;
            goto L23
        L18:
            r417 = null;
            goto L19
        L14:
            r415 = null;
            goto L15
        L10:
            r413 = null;
            goto L11
        L6:
            r411 = null;
        L161:
            return null;
        }
    }

    public EventEntity() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, -1, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof EventEntity) == true) goto L8;
        return false;
    L8:
        EventEntity r101 = (EventEntity) r100;
        if (Intrinsics.areEqual(this.f397528a, r101.f397528a) == true) goto L12;
        return false;
    L12:
        if (this.f397530b == r101.f397530b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f397532c, r101.f397532c) == true) goto L18;
        return false;
    L18:
        if (this.f397534d == r101.f397534d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f397536e, r101.f397536e) == true) goto L24;
        return false;
    L24:
        if (this.f397538f == r101.f397538f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f397540g, r101.f397540g) == true) goto L30;
        return false;
    L30:
        if (this.f397542h == r101.f397542h) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f397544i, r101.f397544i) == true) goto L36;
        return false;
    L36:
        if (this.f397546j == r101.f397546j) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.f397548k, r101.f397548k) == true) goto L42;
        return false;
    L42:
        if (this.f397550l == r101.f397550l) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.f397552m, r101.f397552m) == true) goto L48;
        return false;
    L48:
        if (this.f397554n == r101.f397554n) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.f397556o, r101.f397556o) == true) goto L54;
        return false;
    L54:
        if (this.f397558p == r101.f397558p) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.f397560q, r101.f397560q) == true) goto L60;
        return false;
    L60:
        if (this.f397562r == r101.f397562r) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.f397564s, r101.f397564s) == true) goto L66;
        return false;
    L66:
        if (this.f397566t == r101.f397566t) goto L69;
        return false;
    L69:
        if (this.f397568u == r101.f397568u) goto L72;
        return false;
    L72:
        if (this.f397570v == r101.f397570v) goto L75;
        return false;
    L75:
        if (Intrinsics.areEqual(this.f397572w, r101.f397572w) == true) goto L78;
        return false;
    L78:
        if (this.f397573x == r101.f397573x) goto L81;
        return false;
    L81:
        if (Intrinsics.areEqual(this.f397574y, r101.f397574y) == true) goto L84;
        return false;
    L84:
        if (this.f397575z == r101.f397575z) goto L87;
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
        if (this.D == r101.D) goto L99;
        return false;
    L99:
        if (Intrinsics.areEqual(this.E, r101.E) == true) goto L102;
        return false;
    L102:
        if (this.F == r101.F) goto L105;
        return false;
    L105:
        if (Intrinsics.areEqual(this.G, r101.G) == true) goto L108;
        return false;
    L108:
        if (this.H == r101.H) goto L111;
        return false;
    L111:
        if (Intrinsics.areEqual(this.I, r101.I) == true) goto L114;
        return false;
    L114:
        if (this.f397527J == r101.f397527J) goto L117;
        return false;
    L117:
        if (Intrinsics.areEqual(this.K, r101.K) == true) goto L120;
        return false;
    L120:
        if (this.L == r101.L) goto L123;
        return false;
    L123:
        if (Intrinsics.areEqual(this.M, r101.M) == true) goto L126;
        return false;
    L126:
        if (this.N == r101.N) goto L129;
        return false;
    L129:
        if (Intrinsics.areEqual(this.O, r101.O) == true) goto L132;
        return false;
    L132:
        if (this.P == r101.P) goto L135;
        return false;
    L135:
        if (Intrinsics.areEqual(this.Q, r101.Q) == true) goto L138;
        return false;
    L138:
        if (this.R == r101.R) goto L141;
        return false;
    L141:
        if (Intrinsics.areEqual(this.S, r101.S) == true) goto L144;
        return false;
    L144:
        if (this.T == r101.T) goto L147;
        return false;
    L147:
        if (Intrinsics.areEqual(this.U, r101.U) == true) goto L150;
        return false;
    L150:
        if (this.V == r101.V) goto L153;
        return false;
    L153:
        if (this.W == r101.W) goto L156;
        return false;
    L156:
        if (this.X == r101.X) goto L159;
        return false;
    L159:
        if (Intrinsics.areEqual(this.Y, r101.Y) == true) goto L162;
        return false;
    L162:
        if (this.Z == r101.Z) goto L165;
        return false;
    L165:
        if (Intrinsics.areEqual(this.f397529a0, r101.f397529a0) == true) goto L168;
        return false;
    L168:
        if (this.f397531b0 == r101.f397531b0) goto L171;
        return false;
    L171:
        if (Intrinsics.areEqual(this.f397533c0, r101.f397533c0) == true) goto L174;
        return false;
    L174:
        if (this.f397535d0 == r101.f397535d0) goto L177;
        return false;
    L177:
        if (Intrinsics.areEqual(this.f397537e0, r101.f397537e0) == true) goto L180;
        return false;
    L180:
        if (this.f397539f0 == r101.f397539f0) goto L183;
        return false;
    L183:
        if (Intrinsics.areEqual(this.f397541g0, r101.f397541g0) == true) goto L186;
        return false;
    L186:
        if (this.f397543h0 == r101.f397543h0) goto L189;
        return false;
    L189:
        if (Intrinsics.areEqual(this.f397545i0, r101.f397545i0) == true) goto L192;
        return false;
    L192:
        if (this.f397547j0 == r101.f397547j0) goto L195;
        return false;
    L195:
        if (Intrinsics.areEqual(this.f397549k0, r101.f397549k0) == true) goto L198;
        return false;
    L198:
        if (this.f397551l0 == r101.f397551l0) goto L201;
        return false;
    L201:
        if (Intrinsics.areEqual(this.f397553m0, r101.f397553m0) == true) goto L204;
        return false;
    L204:
        if (this.f397555n0 == r101.f397555n0) goto L207;
        return false;
    L207:
        if (Intrinsics.areEqual(this.f397557o0, r101.f397557o0) == true) goto L210;
        return false;
    L210:
        if (this.f397559p0 == r101.f397559p0) goto L213;
        return false;
    L213:
        if (Intrinsics.areEqual(this.f397561q0, r101.f397561q0) == true) goto L216;
        return false;
    L216:
        if (this.f397563r0 == r101.f397563r0) goto L219;
        return false;
    L219:
        if (Intrinsics.areEqual(this.f397565s0, r101.f397565s0) == true) goto L222;
        return false;
    L222:
        if (this.f397567t0 == r101.f397567t0) goto L225;
        return false;
    L225:
        if (Intrinsics.areEqual(this.f397569u0, r101.f397569u0) == true) goto L228;
        return false;
    L228:
        if (this.f397571v0 == r101.f397571v0) goto L230;
        return false;
    L230:
        return true;
    }

    public final int hashCode() {
        Long r100 = this.f397528a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        int r104 = 1231;
        if (this.f397530b == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        Long r107 = this.f397532c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        if (this.f397534d == false) goto L17;
        int r110 = 1231;
    L18:
        int r111 = (r109 + r110) * 31;
        Long r112 = this.f397536e;
        if (r112 != null) goto L21;
        int r113 = 0;
    L22:
        int r114 = (r111 + r113) * 31;
        if (this.f397538f == false) goto L25;
        int r115 = 1231;
    L26:
        int r116 = (r114 + r115) * 31;
        String r117 = this.f397540g;
        if (r117 != null) goto L29;
        int r118 = 0;
    L30:
        int r119 = (r116 + r118) * 31;
        if (this.f397542h == false) goto L33;
        int r120 = 1231;
    L34:
        int r121 = (r119 + r120) * 31;
        Long r122 = this.f397544i;
        if (r122 != null) goto L37;
        int r123 = 0;
    L38:
        int r124 = (r121 + r123) * 31;
        if (this.f397546j == false) goto L41;
        int r125 = 1231;
    L42:
        int r126 = (r124 + r125) * 31;
        Long r127 = this.f397548k;
        if (r127 != null) goto L45;
        int r128 = 0;
    L46:
        int r129 = (r126 + r128) * 31;
        if (this.f397550l == false) goto L49;
        int r130 = 1231;
    L50:
        int r131 = (r129 + r130) * 31;
        Long r132 = this.f397552m;
        if (r132 != null) goto L53;
        int r133 = 0;
    L54:
        int r134 = (r131 + r133) * 31;
        if (this.f397554n == false) goto L57;
        int r135 = 1231;
    L58:
        int r136 = (r134 + r135) * 31;
        Long r137 = this.f397556o;
        if (r137 != null) goto L61;
        int r138 = 0;
    L62:
        int r139 = (r136 + r138) * 31;
        if (this.f397558p == false) goto L65;
        int r140 = 1231;
    L66:
        int r141 = (r139 + r140) * 31;
        Long r142 = this.f397560q;
        if (r142 != null) goto L69;
        int r143 = 0;
    L70:
        int r144 = (r141 + r143) * 31;
        if (this.f397562r == false) goto L73;
        int r145 = 1231;
    L74:
        int r146 = (r144 + r145) * 31;
        Integer r147 = this.f397564s;
        if (r147 != null) goto L77;
        int r148 = 0;
    L78:
        int r149 = (r146 + r148) * 31;
        if (this.f397566t == false) goto L81;
        int r150 = 1231;
    L82:
        int r151 = (r149 + r150) * 31;
        EventType r152 = this.f397568u;
        if (r152 != null) goto L85;
        int r153 = 0;
    L86:
        int r154 = (r151 + r153) * 31;
        if (this.f397570v == false) goto L89;
        int r155 = 1231;
    L90:
        int r156 = (r154 + r155) * 31;
        String r157 = this.f397572w;
        if (r157 != null) goto L93;
        int r158 = 0;
    L94:
        int r159 = (r156 + r158) * 31;
        if (this.f397573x == false) goto L97;
        int r160 = 1231;
    L98:
        int r161 = (r159 + r160) * 31;
        String r162 = this.f397574y;
        if (r162 != null) goto L101;
        int r163 = 0;
    L102:
        int r164 = (r161 + r163) * 31;
        if (this.f397575z == false) goto L105;
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
        String r172 = this.C;
        if (r172 != null) goto L117;
        int r173 = 0;
    L118:
        int r174 = (r171 + r173) * 31;
        if (this.D == false) goto L121;
        int r175 = 1231;
    L122:
        int r176 = (r174 + r175) * 31;
        String r177 = this.E;
        if (r177 != null) goto L125;
        int r178 = 0;
    L126:
        int r179 = (r176 + r178) * 31;
        if (this.F == false) goto L129;
        int r180 = 1231;
    L130:
        int r181 = (r179 + r180) * 31;
        String r182 = this.G;
        if (r182 != null) goto L133;
        int r183 = 0;
    L134:
        int r184 = (r181 + r183) * 31;
        if (this.H == false) goto L137;
        int r185 = 1231;
    L138:
        int r186 = (r184 + r185) * 31;
        String r187 = this.I;
        if (r187 != null) goto L141;
        int r188 = 0;
    L142:
        int r189 = (r186 + r188) * 31;
        if (this.f397527J == false) goto L145;
        int r190 = 1231;
    L146:
        int r191 = (r189 + r190) * 31;
        String r192 = this.K;
        if (r192 != null) goto L149;
        int r193 = 0;
    L150:
        int r194 = (r191 + r193) * 31;
        if (this.L == false) goto L153;
        int r195 = 1231;
    L154:
        int r196 = (r194 + r195) * 31;
        Long r197 = this.M;
        if (r197 != null) goto L157;
        int r198 = 0;
    L158:
        int r199 = (r196 + r198) * 31;
        if (this.N == false) goto L161;
        int r200 = 1231;
    L162:
        int r201 = (r199 + r200) * 31;
        Long r202 = this.O;
        if (r202 != null) goto L165;
        int r203 = 0;
    L166:
        int r204 = (r201 + r203) * 31;
        if (this.P == false) goto L169;
        int r205 = 1231;
    L170:
        int r206 = (r204 + r205) * 31;
        Integer r207 = this.Q;
        if (r207 != null) goto L173;
        int r208 = 0;
    L174:
        int r209 = (r206 + r208) * 31;
        if (this.R == false) goto L177;
        int r210 = 1231;
    L178:
        int r211 = (r209 + r210) * 31;
        String r212 = this.S;
        if (r212 != null) goto L181;
        int r213 = 0;
    L182:
        int r214 = (r211 + r213) * 31;
        if (this.T == false) goto L185;
        int r215 = 1231;
    L186:
        int r216 = (r214 + r215) * 31;
        Integer r217 = this.U;
        if (r217 != null) goto L189;
        int r218 = 0;
    L190:
        int r219 = (r216 + r218) * 31;
        if (this.V == false) goto L193;
        int r220 = 1231;
    L194:
        int r221 = (r219 + r220) * 31;
        EventFreq r222 = this.W;
        if (r222 != null) goto L197;
        int r223 = 0;
    L198:
        int r224 = (r221 + r223) * 31;
        if (this.X == false) goto L201;
        int r225 = 1231;
    L202:
        int r226 = (r224 + r225) * 31;
        Integer r227 = this.Y;
        if (r227 != null) goto L205;
        int r228 = 0;
    L206:
        int r229 = (r226 + r228) * 31;
        if (this.Z == false) goto L209;
        int r230 = 1231;
    L210:
        int r231 = (r229 + r230) * 31;
        Long r232 = this.f397529a0;
        if (r232 != null) goto L213;
        int r233 = 0;
    L214:
        int r234 = (r231 + r233) * 31;
        if (this.f397531b0 == false) goto L217;
        int r235 = 1231;
    L218:
        int r236 = (r234 + r235) * 31;
        Integer r237 = this.f397533c0;
        if (r237 != null) goto L221;
        int r238 = 0;
    L222:
        int r239 = (r236 + r238) * 31;
        if (this.f397535d0 == false) goto L225;
        int r240 = 1231;
    L226:
        int r241 = (r239 + r240) * 31;
        Integer r242 = this.f397537e0;
        if (r242 != null) goto L229;
        int r243 = 0;
    L230:
        int r244 = (r241 + r243) * 31;
        if (this.f397539f0 == false) goto L233;
        int r245 = 1231;
    L234:
        int r246 = (r244 + r245) * 31;
        Long r247 = this.f397541g0;
        if (r247 != null) goto L237;
        int r248 = 0;
    L238:
        int r249 = (r246 + r248) * 31;
        if (this.f397543h0 == false) goto L241;
        int r250 = 1231;
    L242:
        int r251 = (r249 + r250) * 31;
        Long r252 = this.f397545i0;
        if (r252 != null) goto L245;
        int r253 = 0;
    L246:
        int r254 = (r251 + r253) * 31;
        if (this.f397547j0 == false) goto L249;
        int r255 = 1231;
    L250:
        int r256 = (r254 + r255) * 31;
        String r257 = this.f397549k0;
        if (r257 != null) goto L253;
        int r258 = 0;
    L254:
        int r259 = (r256 + r258) * 31;
        if (this.f397551l0 == false) goto L257;
        int r260 = 1231;
    L258:
        int r261 = (r259 + r260) * 31;
        String r262 = this.f397553m0;
        if (r262 != null) goto L261;
        int r263 = 0;
    L262:
        int r264 = (r261 + r263) * 31;
        if (this.f397555n0 == false) goto L265;
        int r265 = 1231;
    L266:
        int r266 = (r264 + r265) * 31;
        Boolean r267 = this.f397557o0;
        if (r267 != null) goto L269;
        int r268 = 0;
    L270:
        int r269 = (r266 + r268) * 31;
        if (this.f397559p0 == false) goto L273;
        int r270 = 1231;
    L274:
        int r271 = (r269 + r270) * 31;
        String r272 = this.f397561q0;
        if (r272 != null) goto L277;
        int r273 = 0;
    L278:
        int r274 = (r271 + r273) * 31;
        if (this.f397563r0 == false) goto L281;
        int r275 = 1231;
    L282:
        int r276 = (r274 + r275) * 31;
        Long r277 = this.f397565s0;
        if (r277 != null) goto L285;
        int r278 = 0;
    L286:
        int r279 = (r276 + r278) * 31;
        if (this.f397567t0 == false) goto L289;
        int r280 = 1231;
    L290:
        int r281 = (r279 + r280) * 31;
        String r282 = this.f397569u0;
        if (r282 == null) goto L294;
        r101 = r282.hashCode();
    L294:
        int r283 = (r281 + r101) * 31;
        if (this.f397571v0 == true) goto L299;
        r104 = 1237;
    L299:
        return r283 + r104;
    L289:
        r280 = 1237;
        goto L290
    L285:
        r278 = r277.hashCode();
        goto L286
    L281:
        r275 = 1237;
        goto L282
    L277:
        r273 = r272.hashCode();
        goto L278
    L273:
        r270 = 1237;
        goto L274
    L269:
        r268 = r267.hashCode();
        goto L270
    L265:
        r265 = 1237;
        goto L266
    L261:
        r263 = r262.hashCode();
        goto L262
    L257:
        r260 = 1237;
        goto L258
    L253:
        r258 = r257.hashCode();
        goto L254
    L249:
        r255 = 1237;
        goto L250
    L245:
        r253 = r252.hashCode();
        goto L246
    L241:
        r250 = 1237;
        goto L242
    L237:
        r248 = r247.hashCode();
        goto L238
    L233:
        r245 = 1237;
        goto L234
    L229:
        r243 = r242.hashCode();
        goto L230
    L225:
        r240 = 1237;
        goto L226
    L221:
        r238 = r237.hashCode();
        goto L222
    L217:
        r235 = 1237;
        goto L218
    L213:
        r233 = r232.hashCode();
        goto L214
    L209:
        r230 = 1237;
        goto L210
    L205:
        r228 = r227.hashCode();
        goto L206
    L201:
        r225 = 1237;
        goto L202
    L197:
        r223 = r222.hashCode();
        goto L198
    L193:
        r220 = 1237;
        goto L194
    L189:
        r218 = r217.hashCode();
        goto L190
    L185:
        r215 = 1237;
        goto L186
    L181:
        r213 = r212.hashCode();
        goto L182
    L177:
        r210 = 1237;
        goto L178
    L173:
        r208 = r207.hashCode();
        goto L174
    L169:
        r205 = 1237;
        goto L170
    L165:
        r203 = r202.hashCode();
        goto L166
    L161:
        r200 = 1237;
        goto L162
    L157:
        r198 = r197.hashCode();
        goto L158
    L153:
        r195 = 1237;
        goto L154
    L149:
        r193 = r192.hashCode();
        goto L150
    L145:
        r190 = 1237;
        goto L146
    L141:
        r188 = r187.hashCode();
        goto L142
    L137:
        r185 = 1237;
        goto L138
    L133:
        r183 = r182.hashCode();
        goto L134
    L129:
        r180 = 1237;
        goto L130
    L125:
        r178 = r177.hashCode();
        goto L126
    L121:
        r175 = 1237;
        goto L122
    L117:
        r173 = r172.hashCode();
        goto L118
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
        return "EventEntity(id=" + this.f397528a + ", hasId=" + this.f397530b + ", uuid=" + this.f397532c + ", hasUuid=" + this.f397534d + ", calendarId=" + this.f397536e + ", hasCalendarId=" + this.f397538f + ", title=" + this.f397540g + ", hasTitle=" + this.f397542h + ", dtStart=" + this.f397544i + ", hasDtStart=" + this.f397546j + ", eTag=" + this.f397548k + ", hasETag=" + this.f397550l + ", dtEnd=" + this.f397552m + ", hasDtEnd=" + this.f397554n + ", dtStamp=" + this.f397556o + ", hasDtStamp=" + this.f397558p + ", createTime=" + this.f397560q + ", hasCreateTime=" + this.f397562r + ", allDay=" + this.f397564s + ", hasAllDay=" + this.f397566t + ", eventType=" + this.f397568u + ", hasEventType=" + this.f397570v + ", description=" + this.f397572w + ", hasDescription=" + this.f397573x + ", eventLocation=" + this.f397574y + ", hasEventLocation=" + this.f397575z + ", eventColor=" + this.A + ", hasEventColor=" + this.B + ", duration=" + this.C + ", hasDuration=" + this.D + ", rRule=" + this.E + ", hasRRule=" + this.F + ", rDate=" + this.G + ", hasRDate=" + this.H + ", exRule=" + this.I + ", hasExRule=" + this.f397527J + ", exDate=" + this.K + ", hasExDate=" + this.L + ", originalId=" + this.M + ", hasOriginalId=" + this.N + ", originalInstanceTime=" + this.O + ", hasOriginalInstanceTime=" + this.P + ", originalAllDay=" + this.Q + ", hasOriginalAllDay=" + this.R + ", iCalStr=" + this.S + ", hasICalStr=" + this.T + ", isCompleted=" + this.U + ", hasIsCompleted=" + this.V + ", freq=" + this.W + ", hasFreq=" + this.X + ", interval=" + this.Y + ", hasInterval=" + this.Z + ", until=" + this.f397529a0 + ", hasUntil=" + this.f397531b0 + ", exStatus=" + this.f397533c0 + ", hasExStatus=" + this.f397535d0 + ", index=" + this.f397537e0 + ", hasIndex=" + this.f397539f0 + ", exDtStart=" + this.f397541g0 + ", hasExDtStart=" + this.f397543h0 + ", exDtEnd=" + this.f397545i0 + ", hasExDtEnd=" + this.f397547j0 + ", syncStatus=" + this.f397549k0 + ", hasSyncStatus=" + this.f397551l0 + ", larkUuid=" + this.f397553m0 + ", hasLarkUuid=" + this.f397555n0 + ", isNoTimeTodo=" + this.f397557o0 + ", hasIsNoTimeTodo=" + this.f397559p0 + ", memoryExtra=" + this.f397561q0 + ", hasMemoryExtra=" + this.f397563r0 + ", completeTime=" + this.f397565s0 + ", hasCompleteTime=" + this.f397567t0 + ", extraLocationInfo=" + this.f397569u0 + ", hasExtraLocationInfo=" + this.f397571v0 + ')';
    }

    static {
        f397526w0 = new String[]{DBDefinition.ID, "_sync_id", "calendar_id", "title", "eventLocation", "description", "eventColor", "dtstart", "dtend", "duration", "allDay", "rrule", "rdate", "exrule", "exdate", "original_id", "originalInstanceTime", "originalAllDay", "customAppUri", "customAppPackage", "sync_data1", "sync_data2"};
    }

    public final JsonObject a() {
        JsonObject r100 = new JsonObject();
        if (this.f397530b == false) goto L6;
        r100.addProperty("id", this.f397528a);
    L6:
        if (this.f397534d == false) goto L9;
        r100.addProperty(ST.UUID_DEVICE, this.f397532c);
    L9:
        if (this.f397538f == false) goto L12;
        r100.addProperty("calendar_id", this.f397536e);
    L12:
        if (this.f397542h == false) goto L15;
        r100.addProperty("title", this.f397540g);
    L15:
        if (this.f397546j == false) goto L18;
        r100.addProperty("dtstart", this.f397544i);
    L18:
        if (this.f397550l == false) goto L21;
        r100.addProperty(URLDispatch.KEY_ETAG, this.f397548k);
    L21:
        if (this.f397554n == false) goto L24;
        r100.addProperty("dtend", this.f397552m);
    L24:
        if (this.f397558p == false) goto L27;
        r100.addProperty("dtstamp", this.f397556o);
    L27:
        if (this.f397562r == false) goto L30;
        r100.addProperty("create_time", this.f397560q);
    L30:
        if (this.f397566t == false) goto L32;
        r100.addProperty("all_day", this.f397564s);
    L32:
        String r101 = null;
        if (this.f397570v == false) goto L40;
        EventType r102 = this.f397568u;
        if (r102 == null) goto L37;
        String r103 = r102.name();
    L38:
        r100.addProperty("event_type", r103);
        goto L40
    L37:
        r103 = null;
    L40:
        if (this.f397573x == false) goto L43;
        r100.addProperty("description", this.f397572w);
    L43:
        if (this.f397575z == false) goto L46;
        r100.addProperty("event_location", this.f397574y);
    L46:
        if (this.B == false) goto L49;
        r100.addProperty("event_color", this.A);
    L49:
        if (this.D == false) goto L52;
        r100.addProperty("duration", this.C);
    L52:
        if (this.F == false) goto L55;
        r100.addProperty("rrule", this.E);
    L55:
        if (this.H == false) goto L58;
        r100.addProperty("rdate", this.G);
    L58:
        if (this.f397527J == false) goto L61;
        r100.addProperty("exrule", this.I);
    L61:
        if (this.L == false) goto L64;
        r100.addProperty("exdate", this.K);
    L64:
        if (this.N == false) goto L67;
        r100.addProperty("original_id", this.M);
    L67:
        if (this.P == false) goto L70;
        r100.addProperty("original_instance_time", this.O);
    L70:
        if (this.R == false) goto L73;
        r100.addProperty("original_all_day", this.Q);
    L73:
        if (this.T == false) goto L76;
        r100.addProperty("ical_str", this.S);
    L76:
        if (this.V == false) goto L79;
        r100.addProperty("is_completed", this.U);
    L79:
        if (this.X == false) goto L85;
        EventFreq r104 = this.W;
        if (r104 == null) goto L83;
        r101 = r104.name();
    L83:
        r100.addProperty("freq", r101);
    L85:
        if (this.Z == false) goto L88;
        r100.addProperty(VideoThumbInfo.KEY_INTERVAL, this.Y);
    L88:
        if (this.f397531b0 == false) goto L91;
        r100.addProperty("until", this.f397529a0);
    L91:
        if (this.f397535d0 == false) goto L94;
        r100.addProperty("exstatus", this.f397533c0);
    L94:
        if (this.f397539f0 == false) goto L97;
        r100.addProperty("index", this.f397537e0);
    L97:
        if (this.f397543h0 == false) goto L100;
        r100.addProperty("exdtstart", this.f397541g0);
    L100:
        if (this.f397547j0 == false) goto L103;
        r100.addProperty("exdtend", this.f397545i0);
    L103:
        if (this.f397551l0 == false) goto L106;
        r100.addProperty("sync_status", this.f397549k0);
    L106:
        if (this.f397555n0 == false) goto L109;
        r100.addProperty("lark_uuid", this.f397553m0);
    L109:
        if (this.f397559p0 == false) goto L112;
        r100.addProperty("is_no_time_todo", this.f397557o0);
    L112:
        if (this.f397563r0 == false) goto L115;
        r100.addProperty("memory_extra", this.f397561q0);
    L115:
        if (this.f397567t0 == false) goto L118;
        r100.addProperty("completed_time", this.f397565s0);
    L118:
        if (this.f397571v0 == false) goto L120;
        r100.addProperty("extra_location_info", this.f397569u0);
    L120:
        return r100;
    }

    public /* synthetic */ EventEntity(Long r810, Long r811, Long r910, String r911, Long r912, Long r913, Long r914, Long r915, Long r916, Integer r917, EventType r918, String r919, String r100, String r101, String r102, String r103, String r104, String r105, String r106, Long r107, Long r108, Integer r109, String r110, Integer r111, EventFreq r112, Integer r113, Long r114, Integer r115, Integer r116, Long r117, Long r118, String r119, String r120, Boolean r121, String r122, Long r123, String r124, int r125, int r126, int r127) {
        if ((r125 & 1) == 0) goto L5;
        Long r128 = null;
    L7:
        if ((r125 & 2) == 0) goto L10;
        if (r128 == null) goto L10;
        boolean r129 = true;
    L12:
        if ((r125 & 4) == 0) goto L14;
        Long r130 = null;
    L16:
        if ((r125 & 8) == 0) goto L19;
        if (r130 == null) goto L19;
        boolean r131 = true;
    L21:
        if ((r125 & 16) == 0) goto L23;
        Long r132 = null;
    L25:
        if ((r125 & 32) == 0) goto L28;
        if (r132 == null) goto L28;
        boolean r133 = true;
    L30:
        if ((r125 & 64) == 0) goto L32;
        String r134 = null;
    L34:
        if ((r125 & 128) == 0) goto L37;
        if (r134 == null) goto L37;
        boolean r135 = true;
    L39:
        if ((r125 & 256) == 0) goto L41;
        Long r136 = null;
    L43:
        if ((r125 & 512) == 0) goto L46;
        if (r136 == null) goto L46;
        boolean r137 = true;
    L48:
        if ((r125 & 1024) == 0) goto L50;
        Long r138 = null;
    L52:
        if ((r125 & 2048) == 0) goto L55;
        if (r138 == null) goto L55;
        boolean r139 = true;
    L57:
        if ((r125 & 4096) == 0) goto L59;
        Long r140 = null;
    L61:
        if ((r125 & 8192) == 0) goto L64;
        if (r140 == null) goto L64;
        boolean r141 = true;
    L66:
        if ((r125 & 16384) == 0) goto L68;
        Long r210 = null;
    L70:
        if ((r125 & 32768) == 0) goto L73;
        if (r210 == null) goto L73;
        boolean r211 = true;
    L75:
        if ((r125 & 65536) == 0) goto L77;
        Long r212 = null;
    L79:
        if ((r125 & 131072) == 0) goto L82;
        if (r212 == null) goto L82;
        boolean r213 = true;
    L84:
        if ((r125 & 262144) == 0) goto L86;
        Integer r214 = null;
    L88:
        if ((r125 & 524288) == 0) goto L91;
        if (r214 == null) goto L91;
        boolean r215 = true;
    L93:
        if ((r125 & 1048576) == 0) goto L95;
        EventType r310 = null;
    L97:
        if ((r125 & 2097152) == 0) goto L100;
        if (r310 == null) goto L100;
        boolean r311 = true;
    L102:
        if ((r125 & 4194304) == 0) goto L104;
        String r312 = null;
    L106:
        if ((r125 & 8388608) == 0) goto L109;
        if (r312 == null) goto L109;
        boolean r313 = true;
    L111:
        if ((r125 & 16777216) == 0) goto L113;
        String r314 = null;
    L115:
        if ((r125 & 33554432) == 0) goto L118;
        if (r314 == null) goto L118;
        boolean r410 = true;
    L120:
        if ((r125 & 67108864) == 0) goto L122;
        String r411 = null;
    L124:
        if ((r125 & AMapEngineUtils.HALF_MAX_P20_WIDTH) == 0) goto L127;
        if (r411 == null) goto L127;
        boolean r412 = true;
    L129:
        if ((r125 & 268435456) == 0) goto L131;
        String r413 = null;
    L133:
        if ((r125 & 536870912) == 0) goto L136;
        if (r413 == null) goto L136;
        boolean r414 = true;
    L138:
        if ((r125 & 1073741824) == 0) goto L140;
        String r415 = null;
    L142:
        if ((r125 & Integer.MIN_VALUE) == 0) goto L145;
        if (r415 == null) goto L145;
        boolean r142 = true;
    L147:
        if ((r126 & 1) == 0) goto L149;
        String r416 = null;
    L151:
        if ((r126 & 2) == 0) goto L154;
        if (r416 == null) goto L154;
        boolean r417 = true;
    L156:
        if ((r126 & 4) == 0) goto L158;
        String r418 = null;
    L160:
        if ((r126 & 8) == 0) goto L163;
        if (r418 == null) goto L163;
        boolean r419 = true;
    L165:
        if ((r126 & 16) == 0) goto L167;
        String r510 = null;
    L169:
        if ((r126 & 32) == 0) goto L172;
        if (r510 == null) goto L172;
        boolean r511 = true;
    L174:
        if ((r126 & 64) == 0) goto L176;
        Long r512 = null;
    L178:
        if ((r126 & 128) == 0) goto L181;
        if (r512 == null) goto L181;
        boolean r513 = true;
    L183:
        if ((r126 & 256) == 0) goto L185;
        Long r514 = null;
    L187:
        if ((r126 & 512) == 0) goto L190;
        if (r514 == null) goto L190;
        boolean r515 = true;
    L192:
        if ((r126 & 1024) == 0) goto L194;
        Integer r516 = null;
    L196:
        if ((r126 & 2048) == 0) goto L199;
        if (r516 == null) goto L199;
        boolean r517 = true;
    L201:
        if ((r126 & 4096) == 0) goto L203;
        String r518 = null;
    L205:
        if ((r126 & 8192) == 0) goto L208;
        if (r518 == null) goto L208;
        boolean r610 = true;
    L210:
        if ((r126 & 16384) == 0) goto L212;
        Integer r611 = null;
    L214:
        if ((32768 & r126) == 0) goto L217;
        if (r611 == null) goto L217;
        boolean r612 = true;
    L219:
        if ((r126 & 65536) == 0) goto L221;
        EventFreq r613 = null;
    L223:
        if ((r126 & 131072) == 0) goto L226;
        if (r613 == null) goto L226;
        boolean r614 = true;
    L228:
        if ((r126 & 262144) == 0) goto L230;
        Integer r615 = null;
    L232:
        if ((r126 & 524288) == 0) goto L235;
        if (r615 == null) goto L235;
        boolean r616 = true;
    L237:
        if ((r126 & 1048576) == 0) goto L239;
        Long r617 = null;
    L241:
        if ((r126 & 2097152) == 0) goto L244;
        if (r617 == null) goto L244;
        boolean r618 = true;
    L246:
        if ((r126 & 4194304) == 0) goto L248;
        Integer r619 = null;
    L250:
        if ((r126 & 8388608) == 0) goto L253;
        if (r619 == null) goto L253;
        boolean r710 = true;
    L255:
        if ((r126 & 16777216) == 0) goto L257;
        Integer r711 = null;
    L259:
        if ((33554432 & r126) == 0) goto L262;
        if (r711 == null) goto L262;
        boolean r712 = true;
    L264:
        if ((67108864 & r126) == 0) goto L266;
        Long r713 = null;
    L268:
        if ((134217728 & r126) == 0) goto L271;
        if (r713 == null) goto L271;
        boolean r714 = true;
    L273:
        if ((268435456 & r126) == 0) goto L275;
        Long r715 = null;
    L277:
        if ((536870912 & r126) == 0) goto L280;
        if (r715 == null) goto L280;
        boolean r716 = true;
    L282:
        if ((1073741824 & r126) == 0) goto L284;
        String r717 = null;
    L286:
        if ((r126 & Integer.MIN_VALUE) == 0) goto L289;
        if (r717 == null) goto L289;
        boolean r143 = true;
    L291:
        if ((r127 & 1) == 0) goto L293;
        String r718 = null;
    L295:
        if ((r127 & 2) == 0) goto L298;
        if (r718 == null) goto L298;
        boolean r719 = true;
    L300:
        if ((r127 & 4) == 0) goto L302;
        Boolean r812 = null;
    L304:
        if ((r127 & 8) == 0) goto L307;
        if (r812 == null) goto L307;
        boolean r813 = true;
    L309:
        if ((r127 & 16) == 0) goto L311;
        String r814 = null;
    L313:
        if ((r127 & 32) == 0) goto L316;
        if (r814 == null) goto L316;
        boolean r815 = true;
    L318:
        if ((r127 & 64) == 0) goto L320;
        Long r816 = null;
    L322:
        if ((r127 & 128) == 0) goto L325;
        if (r816 == null) goto L325;
        boolean r817 = true;
    L327:
        if ((r127 & 256) == 0) goto L329;
        String r818 = null;
    L331:
        if ((r127 & 512) == 0) goto L334;
        if (r818 == null) goto L334;
        boolean r144 = true;
    L335:
        this(r128, r129, r130, r131, r132, r133, r134, r135, r136, r137, r138, r139, r140, r141, r210, r211, r212, r213, r214, r215, r310, r311, r312, r313, r314, r410, r411, r412, r413, r414, r415, r142, r416, r417, r418, r419, r510, r511, r512, r513, r514, r515, r516, r517, r518, r610, r611, r612, r613, r614, r615, r616, r617, r618, r619, r710, r711, r712, r713, r714, r715, r716, r717, r143, r718, r719, r812, r813, r814, r815, r816, r817, r818, r144);
        return;
    L334:
        r144 = false;
        goto L335
    L329:
        r818 = r124;
    L325:
        r817 = false;
        goto L327
    L320:
        r816 = r123;
    L316:
        r815 = false;
        goto L318
    L311:
        r814 = r122;
    L307:
        r813 = false;
        goto L309
    L302:
        r812 = r121;
    L298:
        r719 = false;
        goto L300
    L293:
        r718 = r120;
    L289:
        r143 = false;
        goto L291
    L284:
        r717 = r119;
    L280:
        r716 = false;
        goto L282
    L275:
        r715 = r118;
    L271:
        r714 = false;
        goto L273
    L266:
        r713 = r117;
    L262:
        r712 = false;
        goto L264
    L257:
        r711 = r116;
    L253:
        r710 = false;
        goto L255
    L248:
        r619 = r115;
    L244:
        r618 = false;
        goto L246
    L239:
        r617 = r114;
    L235:
        r616 = false;
        goto L237
    L230:
        r615 = r113;
    L226:
        r614 = false;
        goto L228
    L221:
        r613 = r112;
    L217:
        r612 = false;
        goto L219
    L212:
        r611 = r111;
    L208:
        r610 = false;
        goto L210
    L203:
        r518 = r110;
    L199:
        r517 = false;
        goto L201
    L194:
        r516 = r109;
    L190:
        r515 = false;
        goto L192
    L185:
        r514 = r108;
    L181:
        r513 = false;
        goto L183
    L176:
        r512 = r107;
    L172:
        r511 = false;
        goto L174
    L167:
        r510 = r106;
    L163:
        r419 = false;
        goto L165
    L158:
        r418 = r105;
    L154:
        r417 = false;
        goto L156
    L149:
        r416 = r104;
    L145:
        r142 = false;
        goto L147
    L140:
        r415 = r103;
    L136:
        r414 = false;
        goto L138
    L131:
        r413 = r102;
    L127:
        r412 = false;
        goto L129
    L122:
        r411 = r101;
    L118:
        r410 = false;
        goto L120
    L113:
        r314 = r100;
    L109:
        r313 = false;
        goto L111
    L104:
        r312 = r919;
    L100:
        r311 = false;
        goto L102
    L95:
        r310 = r918;
    L91:
        r215 = false;
        goto L93
    L86:
        r214 = r917;
    L82:
        r213 = false;
        goto L84
    L77:
        r212 = r916;
    L73:
        r211 = false;
        goto L75
    L68:
        r210 = r915;
    L64:
        r141 = false;
        goto L66
    L59:
        r140 = r914;
    L55:
        r139 = false;
        goto L57
    L50:
        r138 = r913;
    L46:
        r137 = false;
        goto L48
    L41:
        r136 = r912;
    L37:
        r135 = false;
        goto L39
    L32:
        r134 = r911;
    L28:
        r133 = false;
        goto L30
    L23:
        r132 = r910;
    L19:
        r131 = false;
        goto L21
    L14:
        r130 = r811;
    L10:
        r129 = false;
        goto L12
    L5:
        r128 = r810;
        goto L7
    }

    public EventEntity(Long r100, boolean r101, Long r102, boolean r103, Long r104, boolean r105, String r106, boolean r110, Long r111, boolean r112, Long r113, boolean r114, Long r115, boolean r116, Long r117, boolean r118, Long r119, boolean r210, Integer r211, boolean r212, EventType r213, boolean r214, String r215, boolean r216, String r217, boolean r218, String r219, boolean r310, String r311, boolean r312, String r313, boolean r314, String r315, boolean r316, String r317, boolean r318, String r319, boolean r410, Long r411, boolean r412, Long r413, boolean r414, Integer r415, boolean r416, String r417, boolean r418, Integer r419, boolean r510, EventFreq r511, boolean r512, Integer r513, boolean r514, Long r515, boolean r516, Integer r517, boolean r518, Integer r519, boolean r610, Long r611, boolean r612, Long r613, boolean r614, String r615, boolean r616, String r617, boolean r618, Boolean r619, boolean r710, String r711, boolean r712, Long r713, boolean r714, String r715, boolean r716) {
        this.f397528a = r100;
        this.f397530b = r101;
        this.f397532c = r102;
        this.f397534d = r103;
        this.f397536e = r104;
        this.f397538f = r105;
        this.f397540g = r106;
        this.f397542h = r110;
        this.f397544i = r111;
        this.f397546j = r112;
        this.f397548k = r113;
        this.f397550l = r114;
        this.f397552m = r115;
        this.f397554n = r116;
        this.f397556o = r117;
        this.f397558p = r118;
        this.f397560q = r119;
        this.f397562r = r210;
        this.f397564s = r211;
        this.f397566t = r212;
        this.f397568u = r213;
        this.f397570v = r214;
        this.f397572w = r215;
        this.f397573x = r216;
        this.f397574y = r217;
        this.f397575z = r218;
        this.A = r219;
        this.B = r310;
        this.C = r311;
        this.D = r312;
        this.E = r313;
        this.F = r314;
        this.G = r315;
        this.H = r316;
        this.I = r317;
        this.f397527J = r318;
        this.K = r319;
        this.L = r410;
        this.M = r411;
        this.N = r412;
        this.O = r413;
        this.P = r414;
        this.Q = r415;
        this.R = r416;
        this.S = r417;
        this.T = r418;
        this.U = r419;
        this.V = r510;
        this.W = r511;
        this.X = r512;
        this.Y = r513;
        this.Z = r514;
        this.f397529a0 = r515;
        this.f397531b0 = r516;
        this.f397533c0 = r517;
        this.f397535d0 = r518;
        this.f397537e0 = r519;
        this.f397539f0 = r610;
        this.f397541g0 = r611;
        this.f397543h0 = r612;
        this.f397545i0 = r613;
        this.f397547j0 = r614;
        this.f397549k0 = r615;
        this.f397551l0 = r616;
        this.f397553m0 = r617;
        this.f397555n0 = r618;
        this.f397557o0 = r619;
        this.f397559p0 = r710;
        this.f397561q0 = r711;
        this.f397563r0 = r712;
        this.f397565s0 = r713;
        this.f397567t0 = r714;
        this.f397569u0 = r715;
        this.f397571v0 = r716;
    }
}
