package com.bytedance.sdk.xbridge.cn.calendar.reducer;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.amap.api.services.cloud.CloudSearch;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.sdk.xbridge.cn.calendar.model.CalendarErrorCode;
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
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f269862a = 0;

    static {
    }

    public static CalendarErrorCode c(rd7.a.b r110, ContentResolver r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "contentResolver");
        Long r100 = null;
        Cursor r101 = a(r111, CalendarContract.Calendars.CONTENT_URI, new String[]{DBDefinition.ID, "name", "calendar_displayName", "account_name", "account_type", "visible", "ownerAccount"}, null, null);
        if (r101 == null) goto L14;
        Cursor r102 = r101;
        List r103 = SequencesKt.toList(SequencesKt.sequence(new CalendarUpdateReducer$getCalendars$1$1(r102, null)));     // Catch: Throwable -> L9
        CloseableKt.closeFinally(r102, null);
        if (r103 == null) goto L14;
    L15:
        List r104 = r103;
        Iterator r105 = r104.iterator();
    L17:
        if (r105.hasNext() == false) goto L21;
        Object r106 = r105.next();
        if (ArraysKt.contains(e.f269863a, ((sd7.a) r106).f541470d) == false) goto L17;
    L22:
        sd7.a r107 = (sd7.a) r106;
        if (r107 != null) goto L42;
        Iterator r108 = r104.iterator();
    L26:
        if (r108.hasNext() == false) goto L40;
        Object r109 = r108.next();
        sd7.a r112 = (sd7.a) r109;
        String r113 = r112.f541470d;
        String[] r114 = e.f269863a;
        if (Intrinsics.areEqual(r113, "com.smartisan.localcalendar") == false) goto L31;
        boolean r115 = Intrinsics.areEqual(r112.f541473g, CloudSearch.SearchBound.LOCAL_SHAPE);
    L38:
        if (r115 == false) goto L26;
    L41:
        r107 = (sd7.a) r109;
        goto L42
    L31:
        if (Intrinsics.areEqual(r113, "My calendar") == true) goto L33;
    L37:
        r115 = false;
        goto L38
    L33:
        if (Intrinsics.areEqual(r112.f541471e, "My calendar") == false) goto L37;
        if (Intrinsics.areEqual(r112.f541473g, "My calendar") == false) goto L37;
        r115 = true;
        goto L38
    L40:
        r109 = null;
    L42:
        if (r107 != null) goto L45;
        id7.c.a("updateCalendar: no available local calendar");
        return CalendarErrorCode.NoAccount;
    L45:
        ContentValues r116 = new ContentValues();
        r116.put("calendar_id", Long.valueOf(r107.f541467a));
        r116.put("eventTimezone", TimeZone.getDefault().getID());
        r116.put("dtstart", Long.valueOf(r110.getStartDate().longValue()));
        r116.put("dtend", Long.valueOf(r110.getEndDate().longValue()));
        r116.put("title", r110.getTitle());
        r116.put("description", r110.getNotes());
        r116.put("sync_data1", r110.getIdentifier());
        r116.put("allDay", r110.getAllDay());
        r116.put("eventLocation", r110.getLocation());
        r116.put("sync_data3", r110.getUrl());
        if (Intrinsics.areEqual(r110.getRepeatCount(), -1) == true) goto L51;
        if (Intrinsics.areEqual(r110.getRepeatInterval(), -1) == true) goto L51;
        r116.put("duration", "P" + ((r110.getEndDate().longValue() - r110.getStartDate().longValue()) / ((long) 60000)) + 'M');
        r116.put("rrule", "FREQ=" + r110.getRepeatFrequency() + ";COUNT=" + r110.getRepeatCount() + ";INTERVAL=" + r110.getRepeatInterval());
    L51:
        if (b(r111, td7.a.a(CalendarContract.Events.CONTENT_URI), r116, "sync_data1=?", new String[]{r110.getIdentifier()}) <= 0) goto L89;
        Number r117 = r110.getAlarmOffset();
        if (r117 == null) goto L87;
        if (r117.longValue() < 0) goto L85;
        Cursor r118 = a(r111, CalendarContract.Events.CONTENT_URI, new String[]{DBDefinition.ID}, "sync_data1=?", new String[]{r110.getIdentifier()});
        Cursor r119 = r118;     // Catch: Throwable -> L79
        if (r119 != null) goto L60;
    L62:
        boolean r120 = false;
    L63:
        if (r120 == false) goto L66;
        long r121 = r119.getLong(0);     // Catch: Throwable -> L79
    L67:
        CloseableKt.closeFinally(r118, null);
        if (r121 < 0) goto L70;
        ContentValues r122 = new ContentValues();
        r122.put("event_id", Long.valueOf(r121));
        Number r123 = r110.getAlarmOffset();
        if (r123 == null) goto L74;
        r100 = Long.valueOf(r123.longValue() / ((long) 60000));
    L74:
        r122.put(DocumentType.MINUTES_NAME, r100);
        r122.put(com.alipay.sdk.m.p.e.f25671s, 1);
        if (b(r111, CalendarContract.Reminders.CONTENT_URI, r122, "event_id=?", new String[]{String.valueOf(r121)}) <= 0) goto L78;
        return CalendarErrorCode.Success;
    L78:
        return CalendarErrorCode.Failed;
    L70:
        return CalendarErrorCode.Failed;
    L66:
        r121 = -1;
        goto L67
    L60:
        if (r119.moveToNext() != true) goto L62;
        r120 = true;
    L79:
        th = move-exception;
        throw th;     // Catch: Throwable -> L81
    L81:
        th = move-exception;
        CloseableKt.closeFinally(r118, th);
        throw th;
    L85:
        return CalendarErrorCode.InvalidParameter;
    L87:
        return CalendarErrorCode.Success;
    L89:
        return CalendarErrorCode.Failed;
    L21:
        r106 = null;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);
        throw th;
    L14:
        r103 = CollectionsKt.emptyList();
        goto L15
    }

    public static Cursor a(ContentResolver r110, Uri r111, String[] r112, String r113, String[] r114) {
        f06.c r100 = new f06.c();
        Object[] r101 = {r111, r112, r113, r114, null};
        f06.b r115 = new f06.b();
        f06.d r116 = r100.b(240004, "android/content/ContentResolver", "query", r110, r101, "android.database.Cursor", r115);
        if (r116.f474982a == false) goto L6;
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, null, r115, false);
        return (Cursor) r116.f474983b;
    L6:
        Cursor r117 = r110.query(r111, r112, r113, r114, null);
        r100.a(240004, "android/content/ContentResolver", "query", r110, r101, r117, r115, true);
        return r117;
    }

    public static int b(ContentResolver r110, Uri r111, ContentValues r210, String r211, String[] r212) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111, r210, r211, r212};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(240018);
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
        f06.d r107 = r106.preInvoke(240018, "android/content/ContentResolver", "update", r110, r101, "int", r112);     // Catch: Exception -> L22
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L22
    L17:
        if (r107.f474982a == false) goto L21;
        return ((Integer) r107.f474983b).intValue();
    L21:
        return r110.update(r111, r210, r211, r212);
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
}
