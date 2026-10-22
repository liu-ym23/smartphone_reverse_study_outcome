package d7c;

import android.content.Context;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.time.format.common.e;
import com.ss.android.lark.time.format.entity.DataRepresentation;
import com.ss.android.lark.time.format.entity.DatePreciseness;
import com.ss.android.lark.time.format.entity.DisplayPattern;
import com.ss.android.lark.time.format.entity.LengthType;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f467368a = 0;

    /* JADX INFO: renamed from: d7c.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C5644a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f467369a = null;

        static {
            int[] r100 = new int[DatePreciseness.values().length];
            r100[DatePreciseness.MONTH.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[DatePreciseness.DAY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f467369a = r100;
        }
    }

    static {
    }

    public static String a(Context r100, Date r101, c7c.a r102, TimeZone r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "date");
        Intrinsics.checkNotNullParameter(r102, "opt");
        Intrinsics.checkNotNullParameter(r103, "timezone");
        if (r102.f22679c != LengthType.SHORT) goto L12;
        DatePreciseness r104 = r102.f22680d;
        int r105 = C5644a.f467369a[r104.ordinal()];
        if (r105 == 1) goto L10;
        if (r105 != 2) goto L9;
        int r106 = com.ss.android.lark.time.format.common.b.f441322a;
        return com.ss.android.lark.time.format.common.b.b(r101, r103, UIUtils.getString(r100, R.string.Calendar_StandardTime_MonthDayCombineFormat), r102.f22686j, r102.f22688l);
    L9:
        throw new NoWhenBranchMatchedException();
    L10:
        r102.c(LengthType.LONG);
        return c7c.b.h(r100, r101, r102);
    L12:
        DatePreciseness r107 = r102.f22680d;
        int r108 = C5644a.f467369a[r107.ordinal()];
        if (r108 == 1) goto L22;
        if (r108 != 2) goto L21;
        if (r102.f22682f != DataRepresentation.ISO) goto L18;
        String r109 = "yyyy-MM-dd";
    L19:
        int r110 = com.ss.android.lark.time.format.common.b.f441322a;
        Intrinsics.checkNotNull(r109);
        return com.ss.android.lark.time.format.common.b.b(r101, r103, r109, r102.f22686j, r102.f22688l);
    L18:
        r109 = UIUtils.getString(r100, R.string.Calendar_StandardTime_YearMonthDayCombineFormat);
        goto L19
    L21:
        throw new NoWhenBranchMatchedException();
    L22:
        int r111 = com.ss.android.lark.time.format.common.b.f441322a;
        return com.ss.android.lark.time.format.common.b.b(r101, r103, UIUtils.getString(r100, R.string.Calendar_StandardTime_YearMonthCombineFormat), r102.f22686j, r102.f22688l);
    }

    public static String b(Context r100, Date r101, TimeZone r110, GregorianCalendar r111, GregorianCalendar r112, boolean r113, Locale r114) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "date");
        Intrinsics.checkNotNullParameter(r110, "timezone");
        Intrinsics.checkNotNullParameter(r111, "comparedGC");
        Intrinsics.checkNotNullParameter(r112, "currentGC");
        int r102 = e.a(r112, r111);
        if (r102 == (-1)) goto L15;
        if (r102 == 0) goto L18;
        if (r102 == 1) goto L17;
        if (e.d(r111, r112) == false) goto L10;
        LengthType r115 = LengthType.SHORT;
    L11:
        String r103 = r110.getID();
        return a(r100, r101, new c7c.a(r103, null, r115, DatePreciseness.DAY, r113, r114, 1522), r110);
    L10:
        r115 = LengthType.LONG;
        goto L11
    L17:
        return UIUtils.getString(r100, R.string.Calendar_StandardTime_RelativeDayYesterday);
    L18:
        return UIUtils.getString(r100, R.string.Calendar_StandardTime_RelativeDayToday);
    L15:
        return UIUtils.getString(r100, R.string.Calendar_StandardTime_RelativeDayTomorrow);
    }

    public static String c(Context r110, TimeZone r210, boolean r211, GregorianCalendar r212, GregorianCalendar r213, boolean r214, Locale r215) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r210, "timezone");
        Intrinsics.checkNotNullParameter(r212, "comparedGC");
        Intrinsics.checkNotNullParameter(r213, "currentGC");
        String r100 = r210.getID();
        DisplayPattern r101 = DisplayPattern.ABSOLUTE;
        if (r211 == false) goto L5;
        LengthType r102 = LengthType.LONG;
    L6:
        c7c.a r103 = new c7c.a(r100, r101, r102, DatePreciseness.DAY, r214, r215, 1520);
        HashMap r104 = new HashMap();
        r104.put("date", a(r110, new Date(r212.getTimeInMillis()), r103, r210));
        int r105 = e.a(r213, r212);
        if (r105 == (-1)) goto L14;
        if (r105 != 0) goto L10;
        String r106 = UIUtils.getString(r110, R.string.Calendar_StandardTime_RelativeDayToday);
    L15:
        r104.put("relativeDay", r106);
        return UIHelper.mustacheFormat(UIUtils.getString(r110, R.string.Calendar_StandardTime_DateRelativeDayCombineFormat), r104);
    L10:
        if (r105 == 1) goto L12;
        r106 = c7c.b.l(r110, new Date(r212.getTimeInMillis()), new c7c.a(r210.getID(), null, LengthType.SHORT, null, null, false, false, false, false, 2042));
        goto L15
    L12:
        r106 = UIUtils.getString(r110, R.string.Calendar_StandardTime_RelativeDayYesterday);
        goto L15
    L14:
        r106 = UIUtils.getString(r110, R.string.Calendar_StandardTime_RelativeDayTomorrow);
        goto L15
    L5:
        r102 = LengthType.SHORT;
        goto L6
    }
}
