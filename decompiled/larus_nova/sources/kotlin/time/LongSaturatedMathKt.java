package kotlin.time;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.crash.dumper.Scraps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0015\u0010\b\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010\t\u001a'\u0010\n\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u000e\u001a%\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0002¢\u0006\u0002\u0010\u0014\u001a%\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0001H\u0080\b¨\u0006\u001d"}, d2 = {"checkInfiniteSumDefined", "", "value", "duration", "Lkotlin/time/Duration;", "durationInUnit", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "infinityOfSign", "(J)J", "saturatingAdd", Scraps.INNER_UNIT, "Lkotlin/time/DurationUnit;", "saturatingAdd-NuflL3o", "(JLkotlin/time/DurationUnit;J)J", "saturatingAddInHalves", "saturatingAddInHalves-NuflL3o", "saturatingDiff", "valueNs", PlayerResolution.SDKKEY.ORIGIN, "(JJLkotlin/time/DurationUnit;)J", "saturatingFiniteDiff", "value1", "value2", "saturatingOriginsDiff", "origin1", "origin2", "isSaturated", "", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class LongSaturatedMathKt {
    public static final boolean isSaturated(long r100) {
        if (((r100 - 1) | 1) != Long.MAX_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    private static final long infinityOfSign(long r100) {
        Duration.Companion r101 = Duration.Companion;
        if (r100 >= 0) goto L6;
        return r101.m10895getNEG_INFINITEUwyO8pc$kotlin_stdlib();
    L6:
        return r101.m10894getINFINITEUwyO8pc();
    }

    /* JADX INFO: renamed from: checkInfiniteSumDefined-PjuGub4, reason: not valid java name */
    private static final long m10921checkInfiniteSumDefinedPjuGub4(long r100, long r101, long r102) {
        if (Duration.m10825isInfiniteimpl(r101) == true) goto L5;
    L9:
        return r100;
    L5:
        if ((r100 ^ r102) >= 0) goto L9;
        throw new IllegalArgumentException("Summing infinities of different signs");
    }

    /* JADX INFO: renamed from: saturatingAdd-NuflL3o, reason: not valid java name */
    public static final long m10922saturatingAddNuflL3o(long r110, DurationUnit r111, long r112) {
        Intrinsics.checkNotNullParameter(r111, Scraps.INNER_UNIT);
        long r100 = Duration.m10839toLongimpl(r112, r111);
        boolean r101 = true;
        if (((r110 - 1) | 1) != Long.MAX_VALUE) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L10;
        return m10921checkInfiniteSumDefinedPjuGub4(r110, r112, r100);
    L10:
        if ((1 | (r100 - 1)) == Long.MAX_VALUE) goto L13;
        r101 = false;
    L13:
        if (r101 == true) goto L15;
        long r113 = r110 + r100;
        if (((r110 ^ r113) & (r100 ^ r113)) < 0) goto L19;
        return r113;
    L19:
        if (r110 >= 0) goto L23;
        return Long.MIN_VALUE;
    L23:
        return Long.MAX_VALUE;
    L15:
        return m10923saturatingAddInHalvesNuflL3o(r110, r111, r112);
    L5:
        r102 = false;
        goto L6
    }

    /* JADX INFO: renamed from: saturatingAddInHalves-NuflL3o, reason: not valid java name */
    private static final long m10923saturatingAddInHalvesNuflL3o(long r100, DurationUnit r110, long r111) {
        long r101 = Duration.m10796divUwyO8pc(r111, 2);
        long r102 = Duration.m10839toLongimpl(r101, r110);
        if ((1 | (r102 - 1)) != Long.MAX_VALUE) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        return r102;
    L9:
        return m10922saturatingAddNuflL3o(m10922saturatingAddNuflL3o(r100, r110, r101), r110, Duration.m10828minusLRDsOJo(r111, r101));
    L5:
        r103 = false;
        goto L6
    }

    public static final long saturatingDiff(long r100, long r101, DurationUnit r102) {
        Intrinsics.checkNotNullParameter(r102, Scraps.INNER_UNIT);
        if ((1 | (r101 - 1)) != Long.MAX_VALUE) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L10;
        return Duration.m10846unaryMinusUwyO8pc(infinityOfSign(r101));
    L10:
        return saturatingFiniteDiff(r100, r101, r102);
    L5:
        r103 = false;
        goto L6
    }

    private static final long saturatingFiniteDiff(long r100, long r101, DurationUnit r110) {
        long r102 = r100 - r101;
        if (((r102 ^ r100) & (~(r102 ^ r101))) >= 0) goto L11;
        DurationUnit r103 = DurationUnit.MILLISECONDS;
        if (r110.compareTo(r103) >= 0) goto L9;
        long r104 = DurationUnitKt__DurationUnitJvmKt.convertDurationUnit(1, r103, r110);
        long r105 = (r100 / r104) - (r101 / r104);
        long r106 = (r100 % r104) - (r101 % r104);
        Duration.Companion r107 = Duration.Companion;
        return Duration.m10829plusLRDsOJo(DurationKt.toDuration(r105, r103), DurationKt.toDuration(r106, r110));
    L9:
        return Duration.m10846unaryMinusUwyO8pc(infinityOfSign(r102));
    L11:
        return DurationKt.toDuration(r102, r110);
    }

    public static final long saturatingOriginsDiff(long r100, long r110, DurationUnit r111) {
        Intrinsics.checkNotNullParameter(r111, Scraps.INNER_UNIT);
        boolean r101 = true;
        if (((r110 - 1) | 1) != Long.MAX_VALUE) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L14;
        if (r100 != r110) goto L12;
        return Duration.Companion.m10896getZEROUwyO8pc();
    L12:
        return Duration.m10846unaryMinusUwyO8pc(infinityOfSign(r110));
    L14:
        if ((1 | (r100 - 1)) == Long.MAX_VALUE) goto L17;
        r101 = false;
    L17:
        if (r101 == false) goto L21;
        return infinityOfSign(r100);
    L21:
        return saturatingFiniteDiff(r100, r110, r111);
    L5:
        r102 = false;
        goto L6
    }
}
