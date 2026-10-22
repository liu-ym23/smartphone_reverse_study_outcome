package com.bytedance.sdk.xbridge.cn.calendar.reducer;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.amap.api.services.cloud.CloudSearch;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.sdk.xbridge.cn.calendar.model.CalendarErrorCode;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes22.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f269859a = 0;

    static {
    }

    public static CalendarErrorCode c(rd7.a.b r110, ContentResolver r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "contentResolver");
        String r100 = r110.getCalendarName();
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        Long r102 = null;
        if (r101 == true) goto L35;
        Cursor r103 = b(r111, CalendarContract.Calendars.CONTENT_URI, new String[]{DBDefinition.ID, "name"});
        Cursor r112 = r103;     // Catch: Throwable -> L29
        if (r112 != null) goto L16;
        CloseableKt.closeFinally(r103, null);
    L22:
        long r113 = -1;
    L24:
        if (r113 != (-1)) goto L81;
        TimeZone r104 = TimeZone.getDefault();
        ContentValues r105 = new ContentValues();
        r105.put("name", r100);
        r105.put("account_name", r100);
        r105.put("account_type", AccountType.LOCAL);
        r105.put("calendar_displayName", r100);
        r105.put("visible", 1);
        r105.put("calendar_color", Integer.valueOf(FakePickerAvatarCreator.BLUE));
        r105.put("calendar_access_level", 700);
        r105.put("sync_events", 1);
        r105.put("calendar_timezone", r104.getID());
        r105.put("ownerAccount", r100);
        r105.put("canOrganizerRespond", 0);
        Uri r106 = a(r111, CalendarContract.Calendars.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").appendQueryParameter("account_name", r100).appendQueryParameter("account_type", AccountType.LOCAL).build(), r105);
        if (r106 != null) goto L28;
        r113 = -1;
        goto L81
    L28:
        r113 = ContentUris.parseId(r106);
    L81:
        if (r113 == (-1)) goto L83;
        ContentValues r107 = new ContentValues();
        r107.put("calendar_id", Long.valueOf(r113));
        r107.put("eventTimezone", TimeZone.getDefault().getID());
        r107.put("dtstart", Long.valueOf(r110.getStartDate().longValue()));
        r107.put("dtend", Long.valueOf(r110.getEndDate().longValue()));
        r107.put("title", r110.getTitle());
        r107.put("description", r110.getNotes());
        r107.put("sync_data1", r110.getIdentifier());
        r107.put("allDay", r110.getAllDay());
        r107.put("eventLocation", r110.getLocation());
        r107.put("sync_data3", r110.getUrl());
        if (Intrinsics.areEqual(r110.getRepeatCount(), -1) == false) goto L87;
    L89:
        Uri r108 = a(r111, td7.a.a(CalendarContract.Events.CONTENT_URI), r107);
        id7.c.a("create calendar " + r113 + " insert, uri:" + r108);
        if (r108 == null) goto L112;
        Number r109 = r110.getAlarmOffset();
        if (r109 == null) goto L111;
        if (r109.longValue() < 0) goto L109;
        ContentValues r114 = new ContentValues();
        String r115 = r108.getLastPathSegment();
        if (r115 == null) goto L98;
        Long r116 = Long.valueOf(CastLongProtector.parseLong(r115));
    L99:
        r114.put("event_id", r116);
        Number r117 = r110.getAlarmOffset();
        if (r117 == null) goto L102;
        r102 = Long.valueOf(r117.longValue() / ((long) 60000));
    L102:
        r114.put(DocumentType.MINUTES_NAME, r102);
        r114.put(com.alipay.sdk.m.p.e.f25671s, 1);
        if (a(r111, CalendarContract.Reminders.CONTENT_URI, r114) != null) goto L107;
        id7.c.a("insert the reminders res == null");
        return CalendarErrorCode.Unknown;
    L107:
        return CalendarErrorCode.Success;
    L98:
        r116 = null;
        goto L99
    L109:
        return CalendarErrorCode.InvalidParameter;
    L111:
        return CalendarErrorCode.Success;
    L112:
        id7.c.a("createCalendar: insert ret = null");
        return CalendarErrorCode.Unknown;
    L87:
        if (Intrinsics.areEqual(r110.getRepeatInterval(), -1) == true) goto L89;
        r107.put("rrule", "FREQ=" + r110.getRepeatFrequency() + ";COUNT=" + r110.getRepeatCount() + ";INTERVAL=" + r110.getRepeatInterval());
        long r118 = (r110.getEndDate().longValue() - r110.getStartDate().longValue()) / ((long) 60000);
        StringBuilder r119 = new StringBuilder("P");
        r119.append(r118);
        r119.append('M');
        r107.put("duration", r119.toString());
        goto L89
    L83:
        return CalendarErrorCode.NoAccount;
    L16:
        if (r112.moveToNext() == false) goto L21;
        if (Intrinsics.areEqual(r112.getString(1), r100) == false) goto L16;
        r113 = r112.getLong(0);     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r103, null);
        goto L24
    L21:
        CloseableKt.closeFinally(r103, null);
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        CloseableKt.closeFinally(r103, th);
        throw th;
    L35:
        Cursor r120 = b(r111, CalendarContract.Calendars.CONTENT_URI, new String[]{DBDefinition.ID, "name", "calendar_displayName", "account_name", "account_type", "visible", "ownerAccount", "calendar_access_level"});
        if (r120 == null) goto L48;
        Cursor r121 = r120;
        List r122 = SequencesKt.toList(SequencesKt.sequence(new CalendarCreateReducer$getCalendars$1$1(r121, null)));     // Catch: Throwable -> L42
        CloseableKt.closeFinally(r121, null);
        if (r122 == null) goto L48;
    L49:
        List r123 = r122;
        Iterator r124 = r123.iterator();
    L51:
        if (r124.hasNext() == false) goto L55;
        Object r125 = r124.next();
        if (ArraysKt.contains(e.f269863a, ((sd7.a) r125).f541470d) == false) goto L51;
    L56:
        sd7.a r126 = (sd7.a) r125;
        if (r126 != null) goto L76;
        Iterator r127 = r123.iterator();
    L60:
        if (r127.hasNext() == false) goto L74;
        Object r128 = r127.next();
        sd7.a r129 = (sd7.a) r128;
        String r130 = r129.f541470d;
        String[] r131 = e.f269863a;
        if (Intrinsics.areEqual(r130, "com.smartisan.localcalendar") == false) goto L65;
        boolean r132 = Intrinsics.areEqual(r129.f541473g, CloudSearch.SearchBound.LOCAL_SHAPE);
    L72:
        if (r132 == false) goto L60;
    L75:
        r126 = (sd7.a) r128;
        goto L76
    L65:
        if (Intrinsics.areEqual(r130, "My calendar") == true) goto L67;
    L71:
        r132 = false;
        goto L72
    L67:
        if (Intrinsics.areEqual(r129.f541471e, "My calendar") == false) goto L71;
        if (Intrinsics.areEqual(r129.f541473g, "My calendar") == false) goto L71;
        r132 = true;
        goto L72
    L74:
        r128 = null;
    L76:
        if (r126 != null) goto L79;
        id7.c.a("createCalendar: no available local calendar");
        return CalendarErrorCode.NoAccount;
    L79:
        r113 = r126.f541467a;
        goto L81
    L55:
        r125 = null;
    L42:
        th = move-exception;
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        CloseableKt.closeFinally(r121, th);
        throw th;
    L48:
        r122 = CollectionsKt.emptyList();
        goto L49
    L5:
        if (r100.length() == 0) goto L8;
        r101 = false;
        goto L9
    }

    public static Uri a(ContentResolver r110, Uri r111, ContentValues r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240017);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(240017, "android/content/ContentResolver", "insert", r110, r101, "android.net.Uri", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return (Uri) r107.f474983b;
    L21:
        return r110.insert(r111, r210);
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public static Cursor b(ContentResolver r110, Uri r111, String[] r112) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, null, null, null};
        f06.b r113 = new f06.b();
        f06.d r114 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r113);
        if (r114.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r113, false);
        return (Cursor) r114.f474983b;
    L6:
        Cursor r115 = r110.query(r111, r112, null, null, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r115, r113, true);
        return r115;
    }
}
