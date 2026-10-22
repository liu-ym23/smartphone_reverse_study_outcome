package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0001\u001a \u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0001\u001a \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0001\u001a\f\u0010\b\u001a\u00020\u0004*\u00020\tH\u0007\u001a\f\u0010\n\u001a\u00020\t*\u00020\u0004H\u0007¨\u0006\u000b"}, d2 = {"convertDurationUnit", "", "value", "sourceUnit", "Lkotlin/time/DurationUnit;", "targetUnit", "", "convertDurationUnitOverflow", "toDurationUnit", "Ljava/util/concurrent/TimeUnit;", "toTimeUnit", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/time/DurationUnitKt")
class DurationUnitKt__DurationUnitJvmKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[TimeUnit.values().length];
            r100[TimeUnit.NANOSECONDS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[TimeUnit.MICROSECONDS.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[TimeUnit.MILLISECONDS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[TimeUnit.SECONDS.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[TimeUnit.MINUTES.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[TimeUnit.HOURS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[TimeUnit.DAYS.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public DurationUnitKt__DurationUnitJvmKt() {
    }

    public static final DurationUnit toDurationUnit(TimeUnit r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        switch(WhenMappings.$EnumSwitchMapping$0[r100.ordinal()]) {
            case 1: goto L13;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L14:
        return DurationUnit.DAYS;
    L15:
        return DurationUnit.HOURS;
    L16:
        return DurationUnit.MINUTES;
    L17:
        return DurationUnit.SECONDS;
    L18:
        return DurationUnit.MILLISECONDS;
    L19:
        return DurationUnit.MICROSECONDS;
    L13:
        return DurationUnit.NANOSECONDS;
    }

    public static final TimeUnit toTimeUnit(DurationUnit r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.getTimeUnit$kotlin_stdlib();
    }

    public static final double convertDurationUnit(double r100, DurationUnit r101, DurationUnit r110) {
        Intrinsics.checkNotNullParameter(r101, "sourceUnit");
        Intrinsics.checkNotNullParameter(r110, "targetUnit");
        long r102 = r110.getTimeUnit$kotlin_stdlib().convert(1, r101.getTimeUnit$kotlin_stdlib());
        if (r102 <= 0) goto L7;
        return r100 * r102;
    L7:
        return r100 / r101.getTimeUnit$kotlin_stdlib().convert(1, r110.getTimeUnit$kotlin_stdlib());
    }

    public static final long convertDurationUnitOverflow(long r100, DurationUnit r101, DurationUnit r102) {
        Intrinsics.checkNotNullParameter(r101, "sourceUnit");
        Intrinsics.checkNotNullParameter(r102, "targetUnit");
        return r102.getTimeUnit$kotlin_stdlib().convert(r100, r101.getTimeUnit$kotlin_stdlib());
    }

    public static final long convertDurationUnit(long r100, DurationUnit r101, DurationUnit r102) {
        Intrinsics.checkNotNullParameter(r101, "sourceUnit");
        Intrinsics.checkNotNullParameter(r102, "targetUnit");
        return r102.getTimeUnit$kotlin_stdlib().convert(r100, r101.getTimeUnit$kotlin_stdlib());
    }
}
