package com.larus.home.impl.sdk;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.provider.CalendarContract;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.calendar.CalendarManager;
import com.larus.calendar.ErrorCode;
import com.larus.platform.api.a5;
import com.larus.platform.api.b5;
import com.larus.utils.logger.FLogger;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class k implements com.larus.platform.api.v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f346192a = null;

    static {
        f346192a = new k();
    }

    public k() {
    }

    @Override // com.larus.platform.api.v1
    public final b5 a(a5 r110) {
        Intrinsics.checkNotNullParameter(r110, "event");
        Context r100 = CalendarManager.f321312a;
        com.larus.calendar.b r101 = new com.larus.calendar.b();
        r101.f321326a = r110.f364861a;
        r101.f321327b = r110.f364862b;
        r101.f321328c = r110.f364863c;
        r101.f321329d = r110.f364864d;
        r101.f321330e = r110.f364865e;
        r101.f321331f = r110.f364866f;
        r101.f321332g = r110.f364867g;
        r101.f321333h = r110.f364868h;
        r101.f321334i = r110.f364869i;
        Intrinsics.checkNotNullParameter(r101, "event");
        String r102 = r101.f321326a;     // Catch: Throwable -> L86
        if (r102 != null) goto L6;
        com.larus.calendar.a r103 = new com.larus.calendar.a("传入的eventid为空", ErrorCode.ArgumentError);     // Catch: Throwable -> L86
    L92:
        return l.a(r103);
    L6:
        boolean r111 = false;
        if (r102.length() != 0) goto L9;
        boolean r112 = true;
    L10:
        long r113 = 0;
        if (r112 == true) goto L27;
        String r114 = r101.f321327b;     // Catch: Throwable -> L86
        if (r114 != null) goto L15;
    L18:
        boolean r115 = true;
    L19:
        if (r115 == true) goto L27;
        Long r116 = r101.f321329d;     // Catch: Throwable -> L86
        if (r116 == null) goto L23;
        long r117 = r116.longValue();     // Catch: Throwable -> L86
    L25:
        if (r117 <= 0) goto L27;
        boolean r118 = true;
    L28:
        if (r118 == true) goto L30;
        FLogger.f375446a.e("CalendarManager", "add invalid event params: " + r101);     // Catch: Throwable -> L86
        r103 = new com.larus.calendar.a("invalid event params", ErrorCode.ArgumentError);     // Catch: Throwable -> L86
        goto L92
    L30:
        Context r104 = CalendarManager.f321312a;     // Catch: Throwable -> L86
        if (ContextCompat.checkSelfPermission(r104, "android.permission.READ_CALENDAR") != 0) goto L33;
        boolean r119 = true;
    L35:
        if (r119 == true) goto L37;
    L42:
        boolean r120 = false;
    L43:
        if (r120 == true) goto L53;
        FLogger r105 = FLogger.f375446a;     // Catch: Throwable -> L86
        StringBuilder r106 = new StringBuilder("add no calendar permission: read=");     // Catch: Throwable -> L86
        if (ContextCompat.checkSelfPermission(r104, "android.permission.READ_CALENDAR") != 0) goto L47;
        boolean r107 = true;
    L48:
        r106.append(r107);     // Catch: Throwable -> L86
        r106.append(" write=");     // Catch: Throwable -> L86
        if (ContextCompat.checkSelfPermission(r104, "android.permission.WRITE_CALENDAR") != 0) goto L51;
        r111 = true;
    L51:
        r106.append(r111);     // Catch: Throwable -> L86
        r105.e("CalendarManager", r106.toString());     // Catch: Throwable -> L86
        r103 = new com.larus.calendar.a(" calendar permission", ErrorCode.NoPermission);     // Catch: Throwable -> L86
        goto L92
    L47:
        r107 = false;
        goto L48
    L53:
        if (CalendarManager.h(r102) == false) goto L55;
        FLogger.f375446a.i("CalendarManager", "add eventId already exists: " + r101);     // Catch: Throwable -> L86
        r103 = new com.larus.calendar.a("eventId already exists", ErrorCode.AlreadyExists);     // Catch: Throwable -> L86
        goto L92
    L55:
        CalendarManager.a r108 = CalendarManager.g();     // Catch: Throwable -> L86
        if (r108 != null) goto L58;
        FLogger.f375446a.e("CalendarManager", "add no available local calendar: " + r101);     // Catch: Throwable -> L86
        r103 = new com.larus.calendar.a("no available local calendar", ErrorCode.NoAccount);     // Catch: Throwable -> L86
        goto L92
    L58:
        ContentValues r109 = new ContentValues();     // Catch: Throwable -> L86
        r109.put("calendar_id", Long.valueOf(r108.f321315a));     // Catch: Throwable -> L86
        r109.put("eventTimezone", TimeZone.getDefault().getID());     // Catch: Throwable -> L86
        Long r121 = r101.f321329d;     // Catch: Throwable -> L86
        if (r121 == null) goto L61;
        long r122 = r121.longValue();     // Catch: Throwable -> L86
    L62:
        r109.put("dtstart", Long.valueOf(r122));     // Catch: Throwable -> L86
        Long r123 = r101.f321329d;     // Catch: Throwable -> L86
        if (r123 == null) goto L65;
        long r124 = r123.longValue();     // Catch: Throwable -> L86
    L66:
        Long r125 = r101.f321330e;     // Catch: Throwable -> L86
        if (r125 == null) goto L69;
        r113 = r125.longValue();     // Catch: Throwable -> L86
    L69:
        r109.put("dtend", Long.valueOf(r124 + r113));     // Catch: Throwable -> L86
        String r126 = r101.f321328c;     // Catch: Throwable -> L86
        if (r126 != null) goto L72;
    L73:
        r111 = true;
    L74:
        if (r111 == true) goto L76;
        r109.put("description", r101.f321328c);     // Catch: Throwable -> L86
    L76:
        r109.put("title", r101.f321327b);     // Catch: Throwable -> L86
        r109.put("eventLocation", r101.f321331f);     // Catch: Throwable -> L86
        r109.put("hasAlarm", Boolean.valueOf(r101.f321332g));     // Catch: Throwable -> L86
        r109.put("rrule", r101.f321334i);     // Catch: Throwable -> L86
        r109.put("sync_data1", r101.f321326a);     // Catch: Throwable -> L86
        Uri r127 = CalendarManager.c(CalendarManager.f(), CalendarManager.a(CalendarContract.Events.CONTENT_URI, CalendarManager.f321314c), r109);     // Catch: Throwable -> L86
        if (r127 == null) goto L84;
        String r128 = r127.getLastPathSegment();     // Catch: Throwable -> L86
        if (r128 == null) goto L84;
        long r129 = CastLongProtector.parseLong(r128);     // Catch: Throwable -> L86
        if (r101.f321332g == false) goto L83;
        ContentValues r130 = new ContentValues();     // Catch: Throwable -> L86
        r130.put(DocumentType.MINUTES_NAME, Long.valueOf(r101.f321333h));     // Catch: Throwable -> L86
        r130.put("event_id", Long.valueOf(r129));     // Catch: Throwable -> L86
        r130.put(com.alipay.sdk.m.p.e.f25671s, 1);     // Catch: Throwable -> L86
        Uri r131 = CalendarManager.c(CalendarManager.f(), CalendarContract.Reminders.CONTENT_URI, r130);     // Catch: Throwable -> L86
        FLogger.f375446a.e("CalendarManager", "add result success:------result：" + r131);     // Catch: Throwable -> L86
        r103 = new com.larus.calendar.a("success :" + r131, ErrorCode.Success);     // Catch: Throwable -> L86
        goto L92
    L83:
        r103 = new com.larus.calendar.a("success", ErrorCode.Success);     // Catch: Throwable -> L86
    L84:
        r103 = new com.larus.calendar.a("faile to get event id", ErrorCode.NotGetId);     // Catch: Throwable -> L86
        goto L92
    L72:
        if (r126.length() != 0) goto L74;
    L65:
        r124 = 0;
        goto L66
    L61:
        r122 = 0;
        goto L62
    L37:
        if (ContextCompat.checkSelfPermission(r104, "android.permission.WRITE_CALENDAR") != 0) goto L39;
        boolean r132 = true;
    L40:
        if (r132 == false) goto L42;
        r120 = true;
        goto L43
    L39:
        r132 = false;
        goto L40
    L33:
        r119 = false;
        goto L35
    L23:
        r117 = 0;
        goto L25
    L15:
        if (r114.length() == 0) goto L18;
        r115 = false;
    L27:
        r118 = false;
        goto L28
    L9:
        r112 = false;
    L86:
        th = move-exception;
        FLogger.f375446a.e("CalendarManager", "add exception: " + th.getMessage());
        String r133 = th.getMessage();
        if (r133 != null) goto L90;
        r133 = "crash";
    L90:
        r103 = new com.larus.calendar.a(r133, ErrorCode.Unknown);
        goto L92
    }

    @Override // com.larus.platform.api.v1
    public final b5 remove(String r100) {
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276361k);
        Context r101 = CalendarManager.f321312a;
        String r102 = "not found";
        Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276361k);
        boolean r103 = true;
        if (r100.length() != 0) goto L6;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L10;
        com.larus.calendar.a r105 = new com.larus.calendar.a("传入的eventid为空", ErrorCode.ArgumentError);     // Catch: Throwable -> L23
    L31:
    L30:
        return l.a(r105);
    L10:
        if (ContextCompat.checkSelfPermission(CalendarManager.f321312a, "android.permission.WRITE_CALENDAR") != 0) goto L12;
        boolean r106 = true;
    L13:
        if (r106 == true) goto L16;
        r105 = new com.larus.calendar.a("no permission", ErrorCode.NoPermission);     // Catch: Throwable -> L23
        goto L31
    L16:
        if (CalendarManager.b(CalendarManager.f(), CalendarContract.Events.CONTENT_URI, new String[]{r100}) > 0) goto L19;
        r103 = false;
    L19:
        if (r103 == false) goto L21;
        r105 = new com.larus.calendar.a("success", ErrorCode.Success);     // Catch: Throwable -> L23
        goto L31
    L21:
        r105 = new com.larus.calendar.a("not found", ErrorCode.NotFound);     // Catch: Throwable -> L23
        goto L31
    L12:
        r106 = false;
        goto L13
    L6:
        r104 = false;
    L23:
        th = move-exception;
        String r107 = th.getMessage();
        if (r107 == null) goto L28;
        r102 = r107;
    L28:
        r105 = new com.larus.calendar.a(r102, ErrorCode.Unknown);
        goto L30
    }
}
