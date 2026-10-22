package com.ss.android.lark.todo.impl.utils;

import com.bytedance.lark.pb.todo.v1.Todo;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class p {
    public static final boolean a(Todo r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Long r101 = r100.due_time;
        if (r101 != null) goto L6;
    L8:
        long r102 = r100.due_time.longValue() * ((long) 1000);
        if (r100.is_all_day.booleanValue() == false) goto L11;
        TimeZone r103 = TimeZone.getTimeZone("UTC");
    L12:
        GregorianCalendar r104 = new GregorianCalendar(r103);
        GregorianCalendar r105 = new GregorianCalendar();
        r104.setTimeInMillis(r102);
        int r106 = c.a(r104, r105);
        if (1 <= r106) goto L15;
        return false;
    L15:
        if (r106 >= 8) goto L19;
        return true;
    L19:
        return false;
    L11:
        r103 = TimeZone.getDefault();
        goto L12
    L6:
        if (r101.longValue() != 0) goto L8;
        return false;
    }

    public static final boolean b(Todo r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Long r101 = r100.start_milli_time;
        if (r101 != null) goto L6;
    L8:
        Long r102 = r100.start_milli_time;
        if (r100.is_all_day.booleanValue() == false) goto L11;
        TimeZone r103 = TimeZone.getTimeZone("UTC");
    L12:
        GregorianCalendar r104 = new GregorianCalendar(r103);
        GregorianCalendar r105 = new GregorianCalendar();
        Intrinsics.checkNotNull(r102);
        r104.setTimeInMillis(r102.longValue());
        int r106 = c.a(r104, r105);
        if (1 <= r106) goto L15;
        return false;
    L15:
        if (r106 >= 8) goto L19;
        return true;
    L19:
        return false;
    L11:
        r103 = TimeZone.getDefault();
        goto L12
    L6:
        if (r101.longValue() != 0) goto L8;
        return false;
    }

    public static final boolean c(Todo r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Long r101 = r100.due_time;
        if (r101 != null) goto L6;
    L8:
        long r102 = r100.due_time.longValue() * ((long) 1000);
        if (r100.is_all_day.booleanValue() == false) goto L11;
        TimeZone r103 = TimeZone.getTimeZone("UTC");
    L12:
        GregorianCalendar r104 = new GregorianCalendar(r103);
        GregorianCalendar r105 = new GregorianCalendar();
        r104.setTimeInMillis(r102);
        if (r100.is_all_day.booleanValue() == true) goto L17;
        if (r104.getTimeInMillis() >= r105.getTimeInMillis()) goto L17;
    L20:
        return true;
    L17:
        if (r100.is_all_day.booleanValue() == true) goto L19;
        return false;
    L19:
        if (c.a(r104, r105) < 0) goto L20;
        return false;
    L11:
        r103 = TimeZone.getDefault();
        goto L12
    L6:
        if (r101.longValue() != 0) goto L8;
        return false;
    }

    public static final boolean d(Todo r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Long r101 = r100.start_milli_time;
        if (r101 != null) goto L6;
    L8:
        Long r102 = r100.start_milli_time;
        if (r100.is_all_day.booleanValue() == false) goto L11;
        TimeZone r103 = TimeZone.getTimeZone("UTC");
    L12:
        GregorianCalendar r104 = new GregorianCalendar(r103);
        GregorianCalendar r105 = new GregorianCalendar();
        Intrinsics.checkNotNull(r102);
        r104.setTimeInMillis(r102.longValue());
        if (r100.is_all_day.booleanValue() == true) goto L17;
        if (r104.getTimeInMillis() >= r105.getTimeInMillis()) goto L17;
    L20:
        return true;
    L17:
        if (r100.is_all_day.booleanValue() == true) goto L19;
        return false;
    L19:
        if (c.a(r104, r105) < 0) goto L20;
        return false;
    L11:
        r103 = TimeZone.getDefault();
        goto L12
    L6:
        if (r101.longValue() != 0) goto L8;
        return false;
    }

    public static final boolean e(Todo r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Long r101 = r100.due_time;
        if (r101 != null) goto L6;
    L8:
        long r102 = r100.due_time.longValue() * ((long) 1000);
        if (r100.is_all_day.booleanValue() == false) goto L11;
        TimeZone r103 = TimeZone.getTimeZone("UTC");
    L12:
        GregorianCalendar r104 = new GregorianCalendar(r103);
        GregorianCalendar r105 = new GregorianCalendar();
        r104.setTimeInMillis(r102);
        if (c.a(r104, r105) != 0) goto L16;
        return true;
    L16:
        return false;
    L11:
        r103 = TimeZone.getDefault();
        goto L12
    L6:
        if (r101.longValue() != 0) goto L8;
        return false;
    }

    public static final boolean f(Todo r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Long r101 = r100.start_milli_time;
        if (r101 != null) goto L6;
    L8:
        Long r102 = r100.start_milli_time;
        if (r100.is_all_day.booleanValue() == false) goto L11;
        TimeZone r103 = TimeZone.getTimeZone("UTC");
    L12:
        GregorianCalendar r104 = new GregorianCalendar(r103);
        GregorianCalendar r105 = new GregorianCalendar();
        Intrinsics.checkNotNull(r102);
        r104.setTimeInMillis(r102.longValue());
        if (c.a(r104, r105) != 0) goto L16;
        return true;
    L16:
        return false;
    L11:
        r103 = TimeZone.getDefault();
        goto L12
    L6:
        if (r101.longValue() != 0) goto L8;
        return false;
    }

    public static final boolean g(Todo r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Long r101 = r100.due_time;
        if (r101 != null) goto L6;
    L8:
        long r102 = r100.due_time.longValue() * ((long) 1000);
        if (r100.is_all_day.booleanValue() == false) goto L11;
        TimeZone r103 = TimeZone.getTimeZone("UTC");
    L12:
        GregorianCalendar r104 = new GregorianCalendar(r103);
        GregorianCalendar r105 = new GregorianCalendar();
        r104.setTimeInMillis(r102);
        if (c.a(r104, r105) != 1) goto L16;
        return true;
    L16:
        return false;
    L11:
        r103 = TimeZone.getDefault();
        goto L12
    L6:
        if (r101.longValue() != 0) goto L8;
        return false;
    }

    public static final boolean h(Todo r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Long r101 = r100.start_milli_time;
        if (r101 != null) goto L6;
    L8:
        Long r102 = r100.start_milli_time;
        if (r100.is_all_day.booleanValue() == false) goto L11;
        TimeZone r103 = TimeZone.getTimeZone("UTC");
    L12:
        GregorianCalendar r104 = new GregorianCalendar(r103);
        GregorianCalendar r105 = new GregorianCalendar();
        Intrinsics.checkNotNull(r102);
        r104.setTimeInMillis(r102.longValue());
        if (c.a(r104, r105) != 1) goto L16;
        return true;
    L16:
        return false;
    L11:
        r103 = TimeZone.getDefault();
        goto L12
    L6:
        if (r101.longValue() != 0) goto L8;
        return false;
    }
}
