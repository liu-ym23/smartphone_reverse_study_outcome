package com.obric.miniapp.calendar.compatibility;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CalendarContract;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {
    public static final EventEntity b(EventEntity r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r101.getPackageManager().checkPermission("android.permission.READ_CALENDAR", r101.getPackageName()) == 0) goto L5;
        return r100;
    L5:
        Long r102 = r100.f397528a;
        EventEntity r103 = null;
        if (r102 == null) goto L25;
        Cursor r104 = a(r101.getContentResolver(), ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, r102.longValue()), EventEntity.f397526w0, null, null);
        if (r104 == null) goto L21;
        Cursor r105 = r104;
        Cursor r106 = r105;     // Catch: Throwable -> L16
        if (r106.moveToFirst() == false) goto L14;
        EventEntity r107 = EventEntity.a.a(r106);     // Catch: Throwable -> L16
    L15:
        CloseableKt.closeFinally(r105, null);
    L22:
        if (r107 == null) goto L25;
        return r107;
    L14:
        r107 = null;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r105, th);
        throw th;
    L21:
        r107 = null;
    L25:
        Long r108 = r100.f397532c;
        if (r108 == null) goto L41;
        Cursor r109 = a(r101.getContentResolver(), CalendarContract.Events.CONTENT_URI, EventEntity.f397526w0, "_sync_id = ?", new String[]{String.valueOf(r108.longValue())});
        if (r109 == null) goto L41;
        Cursor r110 = r109;
        Cursor r111 = r110;     // Catch: Throwable -> L36
        if (r111.moveToFirst() == false) goto L34;
        EventEntity r112 = EventEntity.a.a(r111);     // Catch: Throwable -> L36
    L35:
        CloseableKt.closeFinally(r110, null);
        r103 = r112;
        goto L41
    L34:
        r112 = null;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        CloseableKt.closeFinally(r110, th);
        throw th;
    L41:
        if (r103 != null) goto L44;
        return r100;
    L44:
        return r103;
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
}
