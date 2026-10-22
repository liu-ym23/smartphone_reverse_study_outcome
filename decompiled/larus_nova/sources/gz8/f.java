package gz8;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.j0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes26.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f483422a = 0;

    static {
    }

    public static String c() {
        return b("scheduledTasks_newTask_repeats_custom");
    }

    public static String d() {
        return b("scheduledTasks_newTask_repeats_daily");
    }

    public static String e() {
        return b("scheduledTasks_newTask_repeats_hourly");
    }

    public static String f() {
        return b("scheduledTasks_newTask_repeats_never");
    }

    public static String g() {
        return b("scheduledTasks_newTask_repeats_weekly");
    }

    public static String b(String r100) {
        int r101 = j0.f375426a;
        return j0.e(r100);
    }

    public static String h(List r110) {
        Intrinsics.checkNotNullParameter(r110, "weekdays");
        switch(((ArrayList) r110).size()) {
            case 1: goto L12;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            default: goto L13;
        };
    L13:
        return g();
    L14:
        return a("scheduledTasks_newTask_repeats_7day", new Pair[]{TuplesKt.to("s_day1", ListProtector.get(r110, 0)), TuplesKt.to("s_day2", ListProtector.get(r110, 1)), TuplesKt.to("s_day3", ListProtector.get(r110, 2)), TuplesKt.to("s_day4", ListProtector.get(r110, 3)), TuplesKt.to("s_day5", ListProtector.get(r110, 4)), TuplesKt.to("s_day6", ListProtector.get(r110, 5)), TuplesKt.to("s_day7", ListProtector.get(r110, 6))});
    L15:
        return a("scheduledTasks_newTask_repeats_6day", new Pair[]{TuplesKt.to("s_day1", ListProtector.get(r110, 0)), TuplesKt.to("s_day2", ListProtector.get(r110, 1)), TuplesKt.to("s_day3", ListProtector.get(r110, 2)), TuplesKt.to("s_day4", ListProtector.get(r110, 3)), TuplesKt.to("s_day5", ListProtector.get(r110, 4)), TuplesKt.to("s_day6", ListProtector.get(r110, 5))});
    L16:
        return a("scheduledTasks_newTask_repeats_5day", new Pair[]{TuplesKt.to("s_day1", ListProtector.get(r110, 0)), TuplesKt.to("s_day2", ListProtector.get(r110, 1)), TuplesKt.to("s_day3", ListProtector.get(r110, 2)), TuplesKt.to("s_day4", ListProtector.get(r110, 3)), TuplesKt.to("s_day5", ListProtector.get(r110, 4))});
    L17:
        return a("scheduledTasks_newTask_repeats_4day", new Pair[]{TuplesKt.to("s_day1", ListProtector.get(r110, 0)), TuplesKt.to("s_day2", ListProtector.get(r110, 1)), TuplesKt.to("s_day3", ListProtector.get(r110, 2)), TuplesKt.to("s_day4", ListProtector.get(r110, 3))});
    L18:
        return a("scheduledTasks_newTask_repeats_3day", new Pair[]{TuplesKt.to("s_day1", ListProtector.get(r110, 0)), TuplesKt.to("s_day2", ListProtector.get(r110, 1)), TuplesKt.to("s_day3", ListProtector.get(r110, 2))});
    L19:
        return a("scheduledTasks_newTask_repeats_2day", new Pair[]{TuplesKt.to("s_day1", ListProtector.get(r110, 0)), TuplesKt.to("s_day2", ListProtector.get(r110, 1))});
    L12:
        return a("scheduledTasks_newTask_repeats_1day", new Pair[]{TuplesKt.to("s_day", ListProtector.get(r110, 0))});
    }

    public static String a(String r110, Pair... r111) {
        String r112 = b(r110);
        int r100 = r111.length;
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= r100) goto L9;
        if (StringsKt.contains$default(r112, "{" + ((String) r111[r102].component1()) + '}', false, 2, null) == true) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        boolean r103 = true;
    L10:
        if (r103 == false) goto L14;
        int r104 = r111.length;
        String r105 = r112;
    L12:
        if (r101 >= r104) goto L23;
        Pair r113 = r111[r101];
        String r106 = (String) r113.component1();
        r105 = StringsKt.replace$default(r105, "{" + r106 + '}', (String) r113.component2(), false, 4, null);
        r101 = r101 + 1;
        goto L12
    L23:
        return r105;
    L14:
        StringCompanionObject r107 = StringCompanionObject.INSTANCE;
        ArrayList r108 = new ArrayList(r111.length);
        int r109 = r111.length;
        int r114 = 0;
    L15:
        if (r114 >= r109) goto L17;
        r108.add((String) r111[r114].getSecond());
        r114 = r114 + 1;
        goto L15
    L17:
        String[] r115 = (String[]) r108.toArray(new String[0]);
        Object[] r116 = Arrays.copyOf(r115, r115.length);
        return String.format(r112, Arrays.copyOf(r116, r116.length));
    L9:
        r103 = false;
        goto L10
    }
}
