package kotlin.time;

import com.bytedance.crash.dumper.Scraps;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\bH$R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", Scraps.INNER_UNIT, "Lkotlin/time/DurationUnit;", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "zero", "", "getZero", "()J", "zero$delegate", "Lkotlin/Lazy;", "adjustedRead", "markNow", "Lkotlin/time/ComparableTimeMark;", "read", "LongTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class AbstractLongTimeSource implements TimeSource.WithComparableMarks {
    private final DurationUnit unit;
    private final Lazy zero$delegate;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\n\u001a\u00020\u0007H\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001b\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0001H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0013\u0010\u0006\u001a\u00020\u0007X\u0082\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b!¨\u0006\u001c"}, d2 = {"Lkotlin/time/AbstractLongTimeSource$LongTimeMark;", "Lkotlin/time/ComparableTimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractLongTimeSource;", "offset", "Lkotlin/time/Duration;", "(JLkotlin/time/AbstractLongTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "equals", "", "other", "", "hashCode", "", "minus", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "toString", "", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class LongTimeMark implements ComparableTimeMark {
        private final long offset;
        private final long startedAt;
        private final AbstractLongTimeSource timeSource;

        public /* synthetic */ LongTimeMark(long r100, AbstractLongTimeSource r101, long r102, DefaultConstructorMarker r103) {
            this(r100, r101, r102);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: elapsedNow-UwyO8pc */
        public long mo10783elapsedNowUwyO8pc() {
            return Duration.m10828minusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(AbstractLongTimeSource.access$adjustedRead(this.timeSource), this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override // kotlin.time.ComparableTimeMark
        public int hashCode() {
            int r100 = Duration.m10821hashCodeimpl(this.offset) * 37;
            long r101 = this.startedAt;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public String toString() {
            return "LongTimeMark(" + this.startedAt + DurationUnitKt__DurationUnitKt.shortName(this.timeSource.getUnit()) + " + " + Duration.m10842toStringimpl(this.offset) + ", " + this.timeSource + ')';
        }

        @Override // kotlin.time.TimeMark
        public boolean hasNotPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasNotPassedNow(this);
        }

        @Override // kotlin.time.TimeMark
        public boolean hasPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasPassedNow(this);
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ComparableTimeMark r100) {
            return compareTo2(r100);
        }

        @Override // kotlin.time.ComparableTimeMark
        public boolean equals(Object r100) {
            if ((r100 instanceof LongTimeMark) == true) goto L5;
        L9:
            return false;
        L5:
            if (Intrinsics.areEqual(this.timeSource, ((LongTimeMark) r100).timeSource) == false) goto L9;
            if (Duration.m10798equalsimpl0(mo10785minusUwyO8pc((ComparableTimeMark) r100), Duration.Companion.m10896getZEROUwyO8pc()) == false) goto L9;
            return true;
        }

        @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
        /* JADX INFO: renamed from: minus-LRDsOJo */
        public ComparableTimeMark mo10784minusLRDsOJo(long r100) {
            return ComparableTimeMark.DefaultImpls.m10788minusLRDsOJo(this, r100);
        }

        @Override // kotlin.time.ComparableTimeMark
        /* JADX INFO: renamed from: minus-UwyO8pc */
        public long mo10785minusUwyO8pc(ComparableTimeMark r100) {
            Intrinsics.checkNotNullParameter(r100, "other");
            if ((r100 instanceof LongTimeMark) == false) goto L9;
            LongTimeMark r101 = (LongTimeMark) r100;
            if (Intrinsics.areEqual(this.timeSource, r101.timeSource) == false) goto L9;
            return Duration.m10829plusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(this.startedAt, r101.startedAt, this.timeSource.getUnit()), Duration.m10828minusLRDsOJo(this.offset, r101.offset));
        L9:
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + r100);
        }

        @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
        /* JADX INFO: renamed from: plus-LRDsOJo */
        public ComparableTimeMark mo10786plusLRDsOJo(long r110) {
            DurationUnit r100 = this.timeSource.getUnit();
            if (Duration.m10825isInfiniteimpl(r110) == true) goto L5;
            long r101 = Duration.m10845truncateToUwyO8pc$kotlin_stdlib(r110, r100);
            long r111 = Duration.m10829plusLRDsOJo(Duration.m10828minusLRDsOJo(r110, r101), this.offset);
            long r102 = LongSaturatedMathKt.m10922saturatingAddNuflL3o(this.startedAt, r100, r101);
            long r103 = Duration.m10845truncateToUwyO8pc$kotlin_stdlib(r111, r100);
            long r104 = LongSaturatedMathKt.m10922saturatingAddNuflL3o(r102, r100, r103);
            long r112 = Duration.m10828minusLRDsOJo(r111, r103);
            long r105 = Duration.m10813getInWholeNanosecondsimpl(r112);
            if (r104 == 0) goto L14;
            if (r105 == 0) goto L14;
            if ((r104 ^ r105) >= 0) goto L14;
            long r106 = DurationKt.toDuration(MathKt.getSign(r105), r100);
            r104 = LongSaturatedMathKt.m10922saturatingAddNuflL3o(r104, r100, r106);
            r112 = Duration.m10828minusLRDsOJo(r112, r106);
        L14:
            if ((1 | (r104 - 1)) != Long.MAX_VALUE) goto L16;
            boolean r107 = true;
        L17:
            if (r107 == false) goto L19;
            r112 = Duration.Companion.m10896getZEROUwyO8pc();
        L19:
            AbstractLongTimeSource r108 = this.timeSource;
            return new LongTimeMark(r104, r108, r112, null);
        L16:
            r107 = false;
            goto L17
        L5:
            return new LongTimeMark(LongSaturatedMathKt.m10922saturatingAddNuflL3o(this.startedAt, r100, r110), this.timeSource, Duration.Companion.m10896getZEROUwyO8pc(), null);
        }

        @Override // kotlin.time.ComparableTimeMark
        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ComparableTimeMark r100) {
            return ComparableTimeMark.DefaultImpls.compareTo(this, r100);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: minus-LRDsOJo */
        public /* bridge */ /* synthetic */ TimeMark mo10784minusLRDsOJo(long r100) {
            return mo10784minusLRDsOJo(r100);
        }

        @Override // kotlin.time.TimeMark
        /* JADX INFO: renamed from: plus-LRDsOJo */
        public /* bridge */ /* synthetic */ TimeMark mo10786plusLRDsOJo(long r100) {
            return mo10786plusLRDsOJo(r100);
        }

        private LongTimeMark(long r100, AbstractLongTimeSource r101, long r102) {
            Intrinsics.checkNotNullParameter(r101, "timeSource");
            this.startedAt = r100;
            this.timeSource = r101;
            this.offset = r102;
        }
    }

    public abstract long read();

    private final long getZero() {
        return ((Number) this.zero$delegate.getValue()).longValue();
    }

    @Override // kotlin.time.TimeSource.WithComparableMarks, kotlin.time.TimeSource
    public ComparableTimeMark markNow() {
        return new LongTimeMark(adjustedRead(), this, Duration.Companion.m10896getZEROUwyO8pc(), null);
    }

    private final long adjustedRead() {
        return read() - getZero();
    }

    public final DurationUnit getUnit() {
        return this.unit;
    }

    @Override // kotlin.time.TimeSource
    public /* bridge */ /* synthetic */ TimeMark markNow() {
        return markNow();
    }

    public AbstractLongTimeSource(DurationUnit r100) {
        Intrinsics.checkNotNullParameter(r100, Scraps.INNER_UNIT);
        this.unit = r100;
        this.zero$delegate = LazyKt.lazy(new AbstractLongTimeSource$zero$2(this));
    }

    public static final /* synthetic */ long access$adjustedRead(AbstractLongTimeSource r100) {
        return r100.adjustedRead();
    }
}
