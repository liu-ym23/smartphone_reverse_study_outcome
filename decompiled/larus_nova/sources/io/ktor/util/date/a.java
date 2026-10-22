package io.ktor.util.date;

import com.byted.mgl.merge.service.api.ui.BdpGameHostBaseUIService;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TimeZone f491954a = null;

    static {
        f491954a = TimeZone.getTimeZone("GMT");
    }

    public static final hsc.a b(Long r100) {
        Calendar r101 = Calendar.getInstance(f491954a, Locale.ROOT);
        Intrinsics.checkNotNull(r101);
        return c(r101, r100);
    }

    public static final hsc.a c(Calendar r110, Long r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        if (r111 == null) goto L5;
        r110.setTimeInMillis(r111.longValue());
    L5:
        int r112 = r110.get(15) + r110.get(16);
        int r100 = r110.get(13);
        int r101 = r110.get(12);
        int r102 = r110.get(11);
        int r103 = ((r110.get(7) + 7) - 2) % 7;
        WeekDay.Companion.getClass();
        WeekDay r104 = WeekDay.values()[r103];
        int r105 = r110.get(5);
        int r106 = r110.get(6);
        Month.a r107 = Month.Companion;
        int r108 = r110.get(2);
        r107.getClass();
        return new hsc.a(r100, r101, r102, r104, r105, r106, Month.values()[r108], r110.get(1), r110.getTimeInMillis() + ((long) r112));
    }

    public static final hsc.a a(int r100, int r101, int r102, int r103, Month r104, int r105) {
        Intrinsics.checkNotNullParameter(r104, BdpGameHostBaseUIService.DATE_PICKER_TYPE_MONTH);
        Calendar r106 = Calendar.getInstance(f491954a, Locale.ROOT);
        Intrinsics.checkNotNull(r106);
        r106.set(1, r105);
        r106.set(2, r104.ordinal());
        r106.set(5, r103);
        r106.set(11, r102);
        r106.set(12, r101);
        r106.set(13, r100);
        r106.set(14, 0);
        return c(r106, null);
    }
}
