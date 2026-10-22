package kotlin.time;

import com.ss.android.lark.passport.signinsdk_api.entity.EnvConst$GEO;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0001\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0001\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\u0001H\u0001¨\u0006\t"}, d2 = {"durationUnitByIsoChar", "Lkotlin/time/DurationUnit;", "isoChar", "", "isTimeComponent", "", "durationUnitByShortName", "shortName", "", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/time/DurationUnitKt")
class DurationUnitKt__DurationUnitKt extends DurationUnitKt__DurationUnitJvmKt {

    /* JADX INFO: loaded from: classes42.dex */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[DurationUnit.values().length];
            r100[DurationUnit.NANOSECONDS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[DurationUnit.MICROSECONDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[DurationUnit.MILLISECONDS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[DurationUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[DurationUnit.MINUTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[DurationUnit.HOURS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[DurationUnit.DAYS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public DurationUnitKt__DurationUnitKt() {
    }

    public static final DurationUnit durationUnitByShortName(String r100) {
        Intrinsics.checkNotNullParameter(r100, "shortName");
        int r101 = r100.hashCode();
        if (r101 == 100) goto L35;
        if (r101 == 104) goto L32;
        if (r101 == 109) goto L29;
        if (r101 == 115) goto L26;
        if (r101 == 3494) goto L23;
        if (r101 == 3525) goto L20;
        if (r101 != 3742) goto L39;
        if (r100.equals(EnvConst$GEO.US) == false) goto L39;
        return DurationUnit.MICROSECONDS;
    L39:
        throw new IllegalArgumentException("Unknown duration unit short name: ".concat(r100));
    L20:
        if (r100.equals("ns") == false) goto L39;
        return DurationUnit.NANOSECONDS;
    L23:
        if (r100.equals("ms") == false) goto L39;
        return DurationUnit.MILLISECONDS;
    L26:
        if (r100.equals("s") == false) goto L39;
        return DurationUnit.SECONDS;
    L29:
        if (r100.equals("m") == false) goto L39;
        return DurationUnit.MINUTES;
    L32:
        if (r100.equals("h") == false) goto L39;
        return DurationUnit.HOURS;
    L35:
        if (r100.equals("d") == false) goto L39;
        return DurationUnit.DAYS;
    }

    public static final String shortName(DurationUnit r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        switch(WhenMappings.$EnumSwitchMapping$0[r100.ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        return "d";
    L7:
        return "h";
    L8:
        return "m";
    L9:
        return "s";
    L10:
        return "ms";
    L11:
        return EnvConst$GEO.US;
    L12:
        return "ns";
    L5:
        throw new IllegalStateException(("Unknown unit: " + r100).toString());
    }

    public static final DurationUnit durationUnitByIsoChar(char r100, boolean r101) {
        if (r101 == true) goto L9;
        if (r100 != 'D') goto L7;
        return DurationUnit.DAYS;
    L7:
        throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + r100);
    L9:
        if (r100 != 'H') goto L12;
        return DurationUnit.HOURS;
    L12:
        if (r100 != 'M') goto L15;
        return DurationUnit.MINUTES;
    L15:
        if (r100 != 'S') goto L19;
        return DurationUnit.SECONDS;
    L19:
        throw new IllegalArgumentException("Invalid duration ISO time unit: " + r100);
    }
}
