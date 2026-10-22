package io2;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Triple;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes11.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f495193a = 0;

    static {
    }

    @JvmStatic
    public static final long a(Date r100) {
        Intrinsics.checkNotNullParameter(r100, "date");
        Calendar r101 = Calendar.getInstance();
        Calendar r102 = Calendar.getInstance();
        r102.setTime(r100);
        r102.set(1, r101.get(1));
        r102.set(2, r101.get(2));
        r102.set(5, r101.get(5));
        return r102.getTimeInMillis();
    }

    @JvmStatic
    public static final String b(long r100) {
        if (r100 < 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L20;
        TimeUnit r102 = TimeUnit.MILLISECONDS;
        long r103 = r102.toHours(r100);
        long r104 = r102.toMinutes(r100) % ((long) 60);
        if (r103 > 0) goto L10;
    L12:
        if (r103 <= 0) goto L15;
        return r103 + "小时";
    L15:
        if (r104 > 0) goto L23;
        return "0分钟";
    L23:
        return r104 + "分钟";
    L10:
        if (r104 <= 0) goto L12;
        return r103 + "小时" + r104 + "分钟";
    L20:
        throw new IllegalArgumentException("Invalid timestamp".toString());
    L5:
        r101 = false;
        goto L6
    }

    public static Date c(String r100) {
        Triple r101 = d(r100);
        int r102 = ((Number) r101.component1()).intValue();
        int r103 = ((Number) r101.component2()).intValue();
        int r104 = ((Number) r101.component3()).intValue();
        Calendar r105 = Calendar.getInstance();
        r105.setTimeInMillis(System.currentTimeMillis());
        r105.set(11, r102);
        r105.set(12, r103);
        r105.set(13, r104);
        r105.set(14, 0);
        return r105.getTime();
    }

    public static Triple d(String r100) {
        if (new Regex("\\d{2}:\\d{2}:\\d{2}").matches(r100) == false) goto L7;
        List r101 = StringsKt.split$default(r100, new String[]{":"}, false, 0, 6, null);
        String r102 = (String) ListProtector.get(r101, 0);
        String r103 = (String) ListProtector.get(r101, 1);
        String r104 = (String) ListProtector.get(r101, 2);
        return new Triple(Integer.valueOf(CastIntegerProtector.parseInt(r102)), Integer.valueOf(CastIntegerProtector.parseInt(r103)), Integer.valueOf(CastIntegerProtector.parseInt(r104)));
    L7:
        throw new IllegalArgumentException("Invalid time format".toString());
    }
}
