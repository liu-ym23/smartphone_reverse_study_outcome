package n3;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import com.bytedance.ai.bridge.calendar.AbsGetCalendarObjectsMethodIDL;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes43.dex */
public final class h {
    public static String b(Cursor r100, int r101) {
        if (r100.isNull(r101) == false) goto L6;
        return null;
    L6:
        return r100.getString(r101);
    }

    public static List c(Context r100, long r101) {
        ArrayList r102 = new ArrayList();
        Cursor r103 = a(r100.getContentResolver(), CalendarContract.Reminders.CONTENT_URI, new String[]{DocumentType.MINUTES_NAME, com.alipay.sdk.m.p.e.f25671s}, "event_id = ?", new String[]{String.valueOf(r101)}, null);
        if (r103 == null) goto L16;
        Cursor r104 = r103;
        Cursor r105 = r104;     // Catch: Throwable -> L11
    L7:
        if (r105.moveToNext() == false) goto L9;
        r102.add(new i.c(r105.getInt(0), r105.getInt(1)));     // Catch: Throwable -> L11
        goto L7
    L9:
        Unit r106 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r104, null);
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);
        throw th;
    L16:
        return r102;
    }

    public static i.b e(Cursor r310, Context r410) {
        long r100 = r310.getLong(r310.getColumnIndexOrThrow(DBDefinition.ID));
        String r101 = r310.getString(r310.getColumnIndexOrThrow("title"));
        String r110 = b(r310, r310.getColumnIndexOrThrow("rrule"));
        long r102 = r310.getLong(r310.getColumnIndexOrThrow("dtstart"));
        long r111 = r310.getLong(r310.getColumnIndexOrThrow("dtend"));
        int r112 = r310.getInt(r310.getColumnIndexOrThrow("eventStatus"));
        int r103 = r310.getColumnIndexOrThrow("original_id");
        String r113 = DBDefinition.ID;
        long r104 = r310.getLong(r103);
        String r114 = "eventStatus";
        String r115 = "originalInstanceTime";
        String r116 = "dtend";
        long r105 = r310.getLong(r310.getColumnIndexOrThrow("originalInstanceTime"));
        com.bytedance.ai.utils.g.f37637a.d("LocalCalendarAdapter", r101 + " eventId: " + r100 + ", rrule: " + r110 + ", start: " + r102 + ", end: " + r111 + ", status: " + r112 + ", originalID: " + r104 + ", originalTime: " + r105);
        if (r110 != null) goto L5;
    L8:
        boolean r106 = true;
    L10:
        if (r106 == true) goto L32;
        ArrayList r107 = new ArrayList();
        Cursor r117 = a(r410.getContentResolver(), CalendarContract.Events.CONTENT_URI, new String[]{DBDefinition.ID, "originalInstanceTime", "title", "description", "dtstart", "dtend", "duration", "eventStatus", "eventLocation", "eventTimezone", "allDay"}, "original_id=?", new String[]{String.valueOf(r100)}, null);
        if (r117 == null) goto L30;
        Cursor r118 = r117;
        Cursor r119 = r118;     // Catch: Throwable -> L24
    L16:
        if (r119.moveToNext() == false) goto L22;
        String r108 = r113;
        long r109 = r119.getLong(r119.getColumnIndexOrThrow(r108));     // Catch: Throwable -> L24
        String r210 = r110;
        long r211 = r119.getLong(r119.getColumnIndexOrThrow(r115));     // Catch: Throwable -> L24
        String r212 = r119.getString(r119.getColumnIndexOrThrow("title"));     // Catch: Throwable -> L24
        String r213 = b(r119, r119.getColumnIndexOrThrow("description"));     // Catch: Throwable -> L24
        String r214 = b(r119, r119.getColumnIndexOrThrow("eventLocation"));     // Catch: Throwable -> L24
        long r311 = r119.getLong(r119.getColumnIndexOrThrow("dtstart"));     // Catch: Throwable -> L24
        String r120 = r116;
        String r121 = r115;
        long r312 = r119.getLong(r119.getColumnIndexOrThrow(r120));     // Catch: Throwable -> L24
        long r313 = r100;
        if (r119.getInt(r119.getColumnIndexOrThrow("allDay")) != 1) goto L20;
        boolean r215 = true;
    L21:
        String r122 = r114;
        r107.add(new i.a(r211, r212, r213, r214, r119.getString(r119.getColumnIndexOrThrow("eventTimezone")), r215, r311, r312, r119.getInt(r119.getColumnIndexOrThrow(r122)), b(r119, r119.getColumnIndexOrThrow("duration")), c(r410, r109)));     // Catch: Throwable -> L24
        r114 = r122;
        r115 = r121;
        r113 = r108;
        r100 = r313;
        r116 = r120;
        r110 = r210;
        goto L16
    L20:
        r215 = false;
        goto L21
    L22:
        long r314 = r100;
        String r216 = r110;
        String r123 = r116;
        Unit r124 = Unit.INSTANCE;     // Catch: Throwable -> L24
        CloseableKt.closeFinally(r118, null);
    L31:
        List r217 = r107;
    L33:
        String r125 = r310.getString(r310.getColumnIndexOrThrow("title"));
        String r126 = b(r310, r310.getColumnIndexOrThrow("description"));
        String r127 = b(r310, r310.getColumnIndexOrThrow("eventLocation"));
        long r128 = r310.getLong(r310.getColumnIndexOrThrow("dtstart"));
        long r129 = r310.getLong(r310.getColumnIndexOrThrow(r123));
        if (r310.getInt(r310.getColumnIndexOrThrow("allDay")) != 1) goto L36;
        boolean r130 = true;
    L37:
        long r131 = r314;
        return new i.b(r131, r125, r126, r128, r129, r127, r310.getString(r310.getColumnIndexOrThrow("eventTimezone")), c(r410, r131), r130, r216, b(r310, r310.getColumnIndexOrThrow("rdate")), b(r310, r310.getColumnIndexOrThrow("duration")), r217);
    L36:
        r130 = false;
    L24:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r118, th);
        throw th;
    L30:
        r314 = r100;
        r216 = r110;
        r123 = r116;
        goto L31
    L32:
        r314 = r100;
        r216 = r110;
        r123 = r116;
        r410 = r410;
        r217 = CollectionsKt.emptyList();
        goto L33
    L5:
        if (r110.length() == 0) goto L8;
        r106 = false;
        goto L10
    }

    public static ArrayList d(Context r310, Long r410, Long r411) {
        Intrinsics.checkNotNullParameter(r310, PerfLog.PARAM_KEY_CONTEXT_ID);
        ArrayList r100 = new ArrayList();
        ArrayList r101 = new ArrayList();
        Uri r102 = CalendarContract.Events.CONTENT_URI;
        String[] r103 = {DBDefinition.ID, "title", "description", "dtstart", "dtend", "duration", "eventLocation", "eventTimezone", "allDay", "rrule", "rdate", "duration", "eventStatus", "originalInstanceTime", "original_id"};
        StringBuilder r104 = new StringBuilder("(original_id IS NULL)");
        if (r410 == null) goto L6;
        if (r411 == null) goto L6;
        r104.append(" AND ((dtstart >= ? AND dtend <= ?) OR (dtstart >= ? AND rrule IS NOT NULL))");
        String[] r105 = {r410.toString(), r411.toString(), r410.toString()};
    L10:
        String[] r106 = r105;
    L12:
        Cursor r107 = a(r310.getContentResolver(), r102, r103, r104.toString(), r106, "dtstart ASC");
        if (r107 == null) goto L27;
        Cursor r108 = r107;
        Cursor r109 = r108;     // Catch: Throwable -> L21
    L17:
        if (r109.moveToNext() == false) goto L19;
        r101.add(e(r109, r310));     // Catch: Throwable -> L21
        goto L17
    L19:
        Unit r110 = Unit.INSTANCE;     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r108, null);
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        CloseableKt.closeFinally(r108, th);
        throw th;
    L27:
        Iterator r111 = r101.iterator();
    L29:
        if (r111.hasNext() == false) goto L163;
        i.b r112 = (i.b) r111.next();
        SimpleDateFormat r113 = i.f516867a;
        Intrinsics.checkNotNullParameter(r112, "event");
        StringBuilder r114 = new StringBuilder("BEGIN:VCALENDAR\r\nVERSION:2.0\r\nPRODID:-//Android Calendar Export//EN\r\nBEGIN:VEVENT\r\n");
        String r115 = "UID:";
        StringBuilder r116 = new StringBuilder("UID:");
        r116.append(r112.f516881a);
        String r117 = "@android.local\r\n";
        r116.append("@android.local\r\n");
        r114.append(r116.toString());
        r114.append("DTSTAMP:" + i.f516867a.format(new Date()) + "\r\n");
        long r118 = i.b(r112.f516889i, r112.f516884d, r112.f516885e, r112.f516892l);
        String r119 = "DTEND";
        String r120 = "DTSTART";
        if (r112.f516889i == false) goto L33;
        SimpleDateFormat r121 = i.f516868b;
        String r122 = r121.format(new Date(r112.f516884d));
        String r123 = r121.format(new Date(r118));
        r114.append("DTSTART;VALUE=DATE:" + r122 + "\r\n");
        r114.append("DTEND;VALUE=DATE:" + r123 + "\r\n");
    L34:
        String r124 = "SUMMARY:";
        r114.append("SUMMARY:" + i.a(r112.f516882b) + "\r\n");
        String r125 = r112.f516883c;
        if (r125 != null) goto L37;
    L40:
        boolean r126 = true;
    L41:
        String r127 = "DESCRIPTION:";
        if (r126 == true) goto L44;
        r114.append("DESCRIPTION:" + i.a(r112.f516883c) + "\r\n");
    L44:
        String r128 = r112.f516886f;
        if (r128 != null) goto L47;
    L50:
        boolean r129 = true;
    L51:
        String r130 = "LOCATION:";
        if (r129 == true) goto L54;
        r114.append("LOCATION:" + i.a(r112.f516886f) + "\r\n");
    L54:
        String r131 = r112.f516892l;
        if (r131 != null) goto L57;
    L60:
        boolean r132 = true;
    L61:
        String r133 = "DURATION:";
        if (r132 == true) goto L64;
        r114.append("DURATION:" + i.a(r112.f516892l) + "\r\n");
    L64:
        String r134 = r112.f516890j;
        if (r134 != null) goto L67;
    L70:
        boolean r135 = true;
    L71:
        if (r135 == true) goto L73;
        r114.append("RRULE:" + r112.f516890j + "\r\n");
    L73:
        String r136 = r112.f516891k;
        if (r136 != null) goto L76;
    L79:
        boolean r137 = true;
    L80:
        if (r137 == true) goto L82;
        r114.append("RDATE" + r112.f516891k + "\r\n");
    L82:
        List<i.a> r138 = r112.f516893m;
        ArrayList r139 = new ArrayList();
        Iterator r140 = r138.iterator();
    L84:
        if (r140.hasNext() == false) goto L92;
        ArrayList r141 = r100;
        Object r142 = r140.next();
        Iterator r143 = r140;
        String r210 = r130;
        if (((i.a) r142).f516878i != 2) goto L88;
        boolean r144 = true;
    L89:
        if (r144 == false) goto L91;
        r139.add(r142);
    L91:
        r100 = r141;
        r140 = r143;
        r130 = r210;
        goto L84
    L88:
        r144 = false;
        goto L89
    L92:
        ArrayList r145 = r100;
        String r211 = r130;
        Iterator r146 = r139.iterator();
    L94:
        if (r146.hasNext() == false) goto L96;
        r114.append("EXDATE:" + i.f516867a.format(new Date(((i.a) r146.next()).f516870a)) + "\r\n");
        r146 = r146;
        r120 = r120;
        r127 = r127;
        goto L94
    L96:
        String r212 = r120;
        String r213 = r127;
        Iterator r147 = r112.f516888h.iterator();
    L97:
        String r148 = "END:VALARM\r\n";
        String r149 = "M\r\n";
        String r150 = r133;
        if (r147.hasNext() == false) goto L107;
        i.c r151 = (i.c) r147.next();
        Iterator r214 = r147;
        int r152 = r151.f516895b;
        String r215 = r119;
        if (r152 != 2) goto L102;
        String r153 = CommonConstant.RETKEY.EMAIL;
    L106:
        r114.append("BEGIN:VALARM\r\n");
        r114.append("ACTION:" + r153 + "\r\n");
        r114.append("DESCRIPTION:Reminder\r\n");
        r114.append("TRIGGER:-PT" + Math.abs(r151.f516894a) + "M\r\n");
        r114.append("END:VALARM\r\n");
        r133 = r150;
        r147 = r214;
        r119 = r215;
        goto L97
    L102:
        if (r152 == 3) goto L104;
        r153 = "DISPLAY";
        goto L106
    L104:
        r153 = CancelRetainContactInfoFunctions.SMS;
        goto L106
    L107:
        String r216 = r119;
        String r154 = "END:VEVENT\r\n";
        r114.append("END:VEVENT\r\n");
        if ((!r112.f516893m.isEmpty()) == false) goto L162;
        Iterator r155 = r112.f516893m.iterator();
    L111:
        if (r155.hasNext() == false) goto L162;
        i.a r156 = (i.a) r155.next();
        SimpleDateFormat r217 = i.f516867a;
        Iterator r218 = r155;
        String r219 = r154;
        if (r156.f516878i == 2) goto L160;
        r114.append("BEGIN:VEVENT\r\n");
        StringBuilder r157 = new StringBuilder(r115);
        String r158 = r148;
        String r220 = r149;
        r157.append(r112.f516881a);
        r157.append(r117);
        r114.append(r157.toString());
        r114.append("RECURRENCE-ID" + i.d(r156.f516870a, r112.f516887g) + "\r\n");
        r114.append(r124 + i.a(r156.f516871b) + "\r\n");
        long r159 = i.b(r156.f516875f, r156.f516876g, r156.f516877h, r156.f516879j);
        if (r156.f516875f == false) goto L117;
        SimpleDateFormat r160 = i.f516868b;
        String r161 = r160.format(new Date(r156.f516876g));
        String r162 = r160.format(new Date(r159));
        r114.append("DTSTART;VALUE=DATE:" + r161 + "\r\n");
        r114.append("DTEND;VALUE=DATE:" + r162 + "\r\n");
        String r163 = r216;
    L118:
        String r164 = r156.f516879j;
        if (r164 != null) goto L121;
    L124:
        boolean r165 = true;
    L125:
        if (r165 == true) goto L127;
        String r166 = r150;
        r114.append(r166 + r156.f516879j + "\r\n");
    L128:
        String r167 = r156.f516872c;
        if (r167 != null) goto L131;
    L134:
        boolean r168 = true;
    L135:
        if (r168 == true) goto L137;
        String r169 = r213;
        r114.append(r169 + i.a(r156.f516872c) + "\r\n");
    L138:
        String r170 = r156.f516873d;
        if (r170 != null) goto L141;
    L144:
        boolean r171 = true;
    L145:
        if (r171 == true) goto L147;
        String r172 = r211;
        r114.append(r172 + i.a(r156.f516873d) + "\r\n");
    L148:
        Iterator r173 = r156.f516880k.iterator();
    L150:
        if (r173.hasNext() == false) goto L159;
        i.c r174 = (i.c) r173.next();
        r114.append("BEGIN:VALARM\r\n");
        int r175 = r174.f516895b;
        Iterator r176 = r173;
        if (r175 != 2) goto L154;
        String r177 = CommonConstant.RETKEY.EMAIL;
    L158:
        r114.append("ACTION:" + r177 + "\r\n");
        r114.append("TRIGGER:-PT" + Math.abs(r174.f516894a) + r220);
        r114.append(r158);
        r173 = r176;
        goto L150
    L154:
        if (r175 == 3) goto L156;
        r177 = "DISPLAY";
        goto L158
    L156:
        r177 = CancelRetainContactInfoFunctions.SMS;
        goto L158
    L159:
        r154 = r219;
        r149 = r220;
        r114.append(r154);
    L161:
        r150 = r166;
        r213 = r169;
        r216 = r163;
        r211 = r172;
        r115 = r115;
        r124 = r124;
        r117 = r117;
        r148 = r158;
        r155 = r218;
        goto L111
    L147:
        r172 = r211;
        goto L148
    L141:
        if (StringsKt.isBlank(r170) == true) goto L144;
        r171 = false;
        goto L145
    L137:
        r169 = r213;
        goto L138
    L131:
        if (StringsKt.isBlank(r167) == true) goto L134;
        r168 = false;
        goto L135
    L127:
        r166 = r150;
        goto L128
    L121:
        if (StringsKt.isBlank(r164) == true) goto L124;
        r165 = false;
        goto L125
    L117:
        r114.append(r212 + i.d(r156.f516876g, r112.f516887g) + "\r\n");
        r163 = r216;
        r114.append(r163 + i.d(r159, r112.f516887g) + "\r\n");
        goto L118
    L160:
        r158 = r148;
        r166 = r150;
        r172 = r211;
        r169 = r213;
        r163 = r216;
        r154 = r219;
    L162:
        r114.append("END:VCALENDAR\r\n");
        String r178 = r114.toString();
        r100 = r145;
        r100.add(new AbsGetCalendarObjectsMethodIDL.CalendarEvent(String.valueOf(r112.f516881a), "local://event/" + r112.f516881a, r178, null, 8, null));
        r111 = r111;
        goto L29
    L76:
        if (StringsKt.isBlank(r136) == true) goto L79;
        r137 = false;
        goto L80
    L67:
        if (StringsKt.isBlank(r134) == true) goto L70;
        r135 = false;
        goto L71
    L57:
        if (StringsKt.isBlank(r131) == true) goto L60;
        r132 = false;
        goto L61
    L47:
        if (StringsKt.isBlank(r128) == true) goto L50;
        r129 = false;
        goto L51
    L37:
        if (StringsKt.isBlank(r125) == true) goto L40;
        r126 = false;
        goto L41
    L33:
        r114.append("DTSTART" + i.d(r112.f516884d, r112.f516887g) + "\r\n");
        r114.append("DTEND" + i.d(r118, r112.f516887g) + "\r\n");
        goto L34
    L163:
        return r100;
    L6:
        if (r410 == null) goto L8;
        r104.append(" AND ((dtstart >= ?))");
        r105 = new String[]{r410.toString()};
        goto L10
    L8:
        if (r411 == null) goto L11;
        r104.append(" AND ((dtstart >= ? AND dtend <= ?) OR (dtstart >= ? AND rrule IS NOT NULL))");
        r105 = new String[]{r411.toString(), r411.toString(), r411.toString()};
        goto L10
    L11:
        r106 = null;
        goto L12
    }

    public static Cursor a(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114, String r115) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, r115};
        f06.b r116 = new f06.b();
        f06.d r117 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r116);
        if (r117.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r116, false);
        return (Cursor) r117.f474983b;
    L6:
        Cursor r118 = r110.query(r111, r112, r113, r114, r115);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r118, r116, true);
        return r118;
    }
}
