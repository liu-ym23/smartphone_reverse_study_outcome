package com.larus.chat.job.impl.page.edit;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f325232a = 0;

    static {
    }

    public static h b(int r100) {
        Calendar r101 = Calendar.getInstance(Locale.getDefault());
        r101.add(5, r100);
        return a(r101.get(1), r101.get(2) + 1, r101.get(5));
    }

    public static String c(h r100, e0 r101) {
        Intrinsics.checkNotNullParameter(r100, "date");
        Intrinsics.checkNotNullParameter(r101, "time");
        Calendar r102 = Calendar.getInstance(Locale.getDefault());
        r102.set(r100.f325275a, r100.f325276b - 1, r100.f325277c, r101.f325245a, r101.f325246b, 0);
        r102.set(14, 0);
        String r103 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US).format(new Date(r102.getTimeInMillis()));
        StringBuilder r104 = new StringBuilder();
        Intrinsics.checkNotNull(r103);
        r104.append(StringsKt.dropLast(r103, 2));
        r104.append(':');
        r104.append(StringsKt.takeLast(r103, 2));
        return r104.toString();
    }

    public static h a(int r100, int r101, int r102) {
        Calendar r103 = Calendar.getInstance(Locale.getDefault());
        r103.set(r100, r101 - 1, r102);
        switch(r103.get(7)) {
            case 1: goto L10;
            case 2: goto L9;
            case 3: goto L8;
            case 4: goto L7;
            case 5: goto L6;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        String r104 = ChatJobEditWeekday.SATURDAY.getLabel();
    L12:
        return new h(r100, r101, r102, r104);
    L5:
        r104 = ChatJobEditWeekday.FRIDAY.getLabel();
        goto L12
    L6:
        r104 = ChatJobEditWeekday.THURSDAY.getLabel();
        goto L12
    L7:
        r104 = ChatJobEditWeekday.WEDNESDAY.getLabel();
        goto L12
    L8:
        r104 = ChatJobEditWeekday.TUESDAY.getLabel();
        goto L12
    L9:
        r104 = ChatJobEditWeekday.MONDAY.getLabel();
        goto L12
    L10:
        r104 = ChatJobEditWeekday.SUNDAY.getLabel();
        goto L12
    }
}
