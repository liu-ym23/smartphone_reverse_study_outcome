package gz8;

import android.text.format.DateFormat;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.vivo.libra.CallBack;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f483418a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Regex f483419b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Regex f483420c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Regex f483421d = null;

    public d() {
    }

    static {
        f483418a = new d();
        f483419b = new Regex("[+-]\\d{2}:\\d{2}$");
        f483420c = new Regex("[+-]\\d{4}$");
        f483421d = new Regex("\\.(\\d+)([+-]\\d{4})$");
    }

    public static List b(Locale r100) {
        Intrinsics.checkNotNullParameter(r100, "locale");
        String[] r101 = new DateFormatSymbols(r100).getAmPmStrings();
        String[] r102 = new String[2];
        Intrinsics.checkNotNull(r101);
        boolean r103 = false;
        Object r104 = ArraysKt.getOrNull(r101, 0);
        String r105 = (String) r104;
        if (r105 != null) goto L5;
    L8:
        boolean r106 = true;
    L9:
        Object r107 = null;
        if (r106 == false) goto L13;
        r104 = null;
    L13:
        String r108 = (String) r104;
        if (r108 != null) goto L16;
        r108 = "AM";
    L16:
        r102[0] = r108;
        Object r109 = ArraysKt.getOrNull(r101, 1);
        String r110 = (String) r109;
        if (r110 != null) goto L19;
    L20:
        r103 = true;
    L21:
        if (r103 == true) goto L23;
        r107 = r109;
    L23:
        String r111 = (String) r107;
        if (r111 != null) goto L26;
        r111 = CallBack.EVENT_POWER_MODE;
    L26:
        r102[1] = r111;
        return CollectionsKt.listOf(r102);
    L19:
        if (StringsKt.isBlank(r110) == false) goto L21;
    L5:
        if (StringsKt.isBlank(r105) == true) goto L8;
        r106 = false;
        goto L9
    }

    public static String d(int r100) {
        return f.e() + f.a("scheduledTasks_newTask_repeats_hour_minuteNum", new Pair[]{TuplesKt.to("s_number", String.valueOf(RangesKt.coerceIn(RangesKt.coerceIn(r100, 0, 59), 0, 59)))});
    }

    public static Integer e(int r100) {
        switch(r100) {
            case 0: goto L6;
            case 1: goto L8;
            case 2: goto L8;
            case 3: goto L8;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L8:
        return Integer.valueOf(r100);
    L6:
        return 7;
    }

    public static Long f(String r100) {
        Intrinsics.checkNotNullParameter(r100, TemplateNodeType.RAW);
        String r101 = StringsKt.trim(r100).toString();
        if (r101.length() != 0) goto L5;
        boolean r102 = true;
    L6:
        Object r103 = null;
        if (r102 == false) goto L9;
        return null;
    L9:
        Long r104 = StringsKt.toLongOrNull(r101);
        if (r104 == null) goto L19;
        long r105 = r104.longValue();
        if (r105 >= 10000000000L) goto L18;
        if (r105 <= (-10000000000L)) goto L18;
        return Long.valueOf(r105 * ((long) 1000));
    L18:
        return Long.valueOf(r105);
    L19:
        String r106 = StringsKt.trim(r101).toString();
        if (StringsKt.endsWith(r106, Matrix.MATRIX_TYPE_ZERO, true) == false) goto L23;
        r106 = StringsKt.dropLast(r106, 1) + "+0000";
    L27:
        MatchResult r107 = Regex.find$default(f483421d, r106, 0, 2, null);
        if (r107 == null) goto L32;
        String r108 = StringsKt.padEnd(StringsKt.take((String) ListProtector.get(r107.getGroupValues(), 1), 3), 3, '0');
        r106 = StringsKt.replaceRange(r106, r107.getRange(), "." + r108 + ((String) ListProtector.get(r107.getGroupValues(), 2))).toString();
    L32:
        if (r106 != null) goto L35;
        return null;
    L35:
        if (StringsKt.contains$default(r106, '.', false, 2, null) == false) goto L37;
        String r109 = "yyyy-MM-dd'T'HH:mm:ss.SSSZ";
    L52:
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L44
        SimpleDateFormat r111 = new SimpleDateFormat(r109, Locale.US);     // Catch: Throwable -> L44
        r111.setLenient(false);     // Catch: Throwable -> L44
        Date r112 = r111.parse(r106);     // Catch: Throwable -> L44
        if (r112 == null) goto L41;
        Long r113 = Long.valueOf(r112.getTime());     // Catch: Throwable -> L44
    L42:
        Object r114 = Result.m9449constructorimpl(r113);     // Catch: Throwable -> L44
    L47:
        if (Result.m9455isFailureimpl(r114) == true) goto L51;
        r103 = r114;
    L51:
        return (Long) r103;
    L41:
        r113 = null;
    L44:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L47
    L37:
        r109 = "yyyy-MM-dd'T'HH:mm:ssZ";
        goto L52
    L23:
        if (f483419b.containsMatchIn(r106) == false) goto L26;
        r106 = StringsKt.dropLast(r106, 3) + StringsKt.takeLast(r106, 2);
        goto L27
    L26:
        if (f483420c.containsMatchIn(r106) == true) goto L27;
        r106 = null;
        goto L32
    L5:
        r102 = false;
        goto L6
    }

    public static boolean a(String r100, String... r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L16;
        String r104 = r101[r103];
        if ((!StringsKt.isBlank(r104)) == true) goto L7;
    L9:
        boolean r105 = false;
    L10:
        if (r105 == true) goto L11;
        r103 = r103 + 1;
        goto L3
    L11:
        return true;
    L7:
        if (StringsKt.contains$default(r100, r104, false, 2, null) == false) goto L9;
        r105 = true;
        goto L10
    L16:
        return false;
    }

    public static String c(int r110, int r210) {
        Locale r100 = Locale.getDefault();
        Calendar r101 = Calendar.getInstance(r100);
        int r102 = 0;
        r101.set(11, RangesKt.coerceIn(r110, 0, 23));
        r101.set(12, RangesKt.coerceIn(r210, 0, 59));
        r101.set(13, 0);
        r101.set(14, 0);
        Date r103 = r101.getTime();
        String r104 = DateFormat.getBestDateTimePattern(r100, "ahmm");
        Intrinsics.checkNotNull(r104);
        StringBuilder r105 = new StringBuilder();
        boolean r106 = false;
    L4:
        if (r102 >= r104.length()) goto L22;
        char r107 = r104.charAt(r102);
        if (r107 == '\'') goto L7;
        if (r106 == true) goto L19;
        if (r107 == 'h') goto L13;
        if (r107 != 'K') goto L19;
    L13:
        r105.append(r107);
        r105.append(r107);
    L15:
        if (r102 >= r104.length()) goto L4;
        if (r104.charAt(r102) != r107) goto L4;
        r102 = r102 + 1;
    L19:
        r105.append(r107);
    L20:
        r102 = r102 + 1;
        goto L4
    L7:
        r106 = !r106;
        r105.append(r107);
        goto L20
    L22:
        return new SimpleDateFormat(StringsKt.replace$default(StringsKt.replace$default(r105.toString(), "ah", "a h", false, 4, null), "aK", "a K", false, 4, null), r100).format(r103);
    }
}
