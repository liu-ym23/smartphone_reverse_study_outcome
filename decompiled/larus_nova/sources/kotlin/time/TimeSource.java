package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00042\u00020\u0001:\u0003\u0004\u0005\u0006J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lkotlin/time/TimeSource;", "", "markNow", "Lkotlin/time/TimeMark;", "Companion", "Monotonic", "WithComparableMarks", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface TimeSource {
    public static final Companion Companion = null;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lkotlin/time/TimeSource$Companion;", "", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\tB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016\u0082\u0002\u0004\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/time/TimeSource$Monotonic;", "Lkotlin/time/TimeSource$WithComparableMarks;", "()V", "markNow", "Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "markNow-z9LOYto", "()J", "toString", "", "ValueTimeMark", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Monotonic implements WithComparableMarks {
        public static final Monotonic INSTANCE = null;

        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0014\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0087@\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u00020\rH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u0006J\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0018\u0010\u0016J\u0010\u0010\u0019\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001b\u0010\u001c\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0001H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0096\u0002¢\u0006\u0004\b \u0010!J\u0018\u0010\u001c\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\"\u0010!J\u0018\u0010#\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0096\u0002¢\u0006\u0004\b$\u0010!J\u0010\u0010%\u001a\u00020&HÖ\u0001¢\u0006\u0004\b'\u0010(R\u0012\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00060\u0003j\u0002`\u0004\u0082\u0002\u0004\n\u0002\b!¨\u0006)"}, d2 = {"Lkotlin/time/TimeSource$Monotonic$ValueTimeMark;", "Lkotlin/time/ComparableTimeMark;", "reading", "", "Lkotlin/time/ValueTimeMarkReading;", "constructor-impl", "(J)J", "compareTo", "", "other", "compareTo-6eNON_k", "(JJ)I", "elapsedNow", "Lkotlin/time/Duration;", "elapsedNow-UwyO8pc", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "hasNotPassedNow", "hasNotPassedNow-impl", "(J)Z", "hasPassedNow", "hasPassedNow-impl", "hashCode", "hashCode-impl", "(J)I", "minus", "minus-UwyO8pc", "(JLkotlin/time/ComparableTimeMark;)J", "duration", "minus-LRDsOJo", "(JJ)J", "minus-6eNON_k", "plus", "plus-LRDsOJo", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
        @JvmInline
        public static final class ValueTimeMark implements ComparableTimeMark {
            private final long reading;

            /* JADX INFO: renamed from: box-impl, reason: not valid java name */
            public static final /* synthetic */ ValueTimeMark m10933boximpl(long r100) {
                return new ValueTimeMark(r100);
            }

            /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
            public static long m10936constructorimpl(long r100) {
                return r100;
            }

            /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
            public static boolean m10938equalsimpl(long r100, Object r101) {
                if ((r101 instanceof ValueTimeMark) == true) goto L6;
                return false;
            L6:
                if (r100 == ((ValueTimeMark) r101).m10950unboximpl()) goto L8;
                return false;
            L8:
                return true;
            }

            /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
            public static final boolean m10939equalsimpl0(long r100, long r101) {
                if (r100 != r101) goto L5;
                return true;
            L5:
                return false;
            }

            /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
            public static int m10942hashCodeimpl(long r100) {
                return (int) (r100 ^ (r100 >>> 32));
            }

            /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
            public static String m10947toStringimpl(long r100) {
                return "ValueTimeMark(reading=" + r100 + ')';
            }

            @Override // kotlin.time.ComparableTimeMark
            public boolean equals(Object r100) {
                return m10938equalsimpl(this.reading, r100);
            }

            @Override // kotlin.time.ComparableTimeMark
            public int hashCode() {
                return m10942hashCodeimpl(this.reading);
            }

            public String toString() {
                return m10947toStringimpl(this.reading);
            }

            /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
            public final /* synthetic */ long m10950unboximpl() {
                return this.reading;
            }

            @Override // kotlin.time.TimeMark
            /* JADX INFO: renamed from: elapsedNow-UwyO8pc */
            public long mo10783elapsedNowUwyO8pc() {
                return m10937elapsedNowUwyO8pc(this.reading);
            }

            @Override // kotlin.time.TimeMark
            public boolean hasNotPassedNow() {
                return m10940hasNotPassedNowimpl(this.reading);
            }

            @Override // kotlin.time.TimeMark
            public boolean hasPassedNow() {
                return m10941hasPassedNowimpl(this.reading);
            }

            private /* synthetic */ ValueTimeMark(long r100) {
                this.reading = r100;
            }

            /* JADX INFO: renamed from: elapsedNow-UwyO8pc, reason: not valid java name */
            public static long m10937elapsedNowUwyO8pc(long r100) {
                return MonotonicTimeSource.INSTANCE.m10926elapsedFrom6eNON_k(r100);
            }

            /* JADX INFO: renamed from: hasNotPassedNow-impl, reason: not valid java name */
            public static boolean m10940hasNotPassedNowimpl(long r100) {
                return Duration.m10826isNegativeimpl(m10937elapsedNowUwyO8pc(r100));
            }

            /* JADX INFO: renamed from: hasPassedNow-impl, reason: not valid java name */
            public static boolean m10941hasPassedNowimpl(long r100) {
                return !Duration.m10826isNegativeimpl(m10937elapsedNowUwyO8pc(r100));
            }

            @Override // java.lang.Comparable
            public /* bridge */ /* synthetic */ int compareTo(ComparableTimeMark r100) {
                return compareTo2(r100);
            }

            @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
            /* JADX INFO: renamed from: minus-LRDsOJo */
            public /* bridge */ /* synthetic */ ComparableTimeMark mo10784minusLRDsOJo(long r100) {
                return m10933boximpl(m10948minusLRDsOJo(r100));
            }

            @Override // kotlin.time.ComparableTimeMark
            /* JADX INFO: renamed from: minus-UwyO8pc */
            public long mo10785minusUwyO8pc(ComparableTimeMark r100) {
                Intrinsics.checkNotNullParameter(r100, "other");
                return m10945minusUwyO8pc(this.reading, r100);
            }

            @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
            /* JADX INFO: renamed from: plus-LRDsOJo */
            public /* bridge */ /* synthetic */ ComparableTimeMark mo10786plusLRDsOJo(long r100) {
                return m10933boximpl(m10949plusLRDsOJo(r100));
            }

            @Override // kotlin.time.ComparableTimeMark
            /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
            public int compareTo2(ComparableTimeMark r100) {
                return ComparableTimeMark.DefaultImpls.compareTo(this, r100);
            }

            @Override // kotlin.time.TimeMark
            /* JADX INFO: renamed from: minus-LRDsOJo */
            public /* bridge */ /* synthetic */ TimeMark mo10784minusLRDsOJo(long r100) {
                return m10933boximpl(m10948minusLRDsOJo(r100));
            }

            @Override // kotlin.time.TimeMark
            /* JADX INFO: renamed from: plus-LRDsOJo */
            public /* bridge */ /* synthetic */ TimeMark mo10786plusLRDsOJo(long r100) {
                return m10933boximpl(m10949plusLRDsOJo(r100));
            }

            /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
            public long m10948minusLRDsOJo(long r100) {
                return m10944minusLRDsOJo(this.reading, r100);
            }

            /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
            public long m10949plusLRDsOJo(long r100) {
                return m10946plusLRDsOJo(this.reading, r100);
            }

            /* JADX INFO: renamed from: compareTo-6eNON_k, reason: not valid java name */
            public static final int m10934compareTo6eNON_k(long r100, long r101) {
                return Duration.m10792compareToLRDsOJo(m10943minus6eNON_k(r100, r101), Duration.Companion.m10896getZEROUwyO8pc());
            }

            /* JADX INFO: renamed from: compareTo-impl, reason: not valid java name */
            public static int m10935compareToimpl(long r100, ComparableTimeMark r101) {
                Intrinsics.checkNotNullParameter(r101, "other");
                return m10933boximpl(r100).compareTo2(r101);
            }

            /* JADX INFO: renamed from: minus-6eNON_k, reason: not valid java name */
            public static final long m10943minus6eNON_k(long r100, long r101) {
                return MonotonicTimeSource.INSTANCE.m10925differenceBetweenfRLX17w(r100, r101);
            }

            /* JADX INFO: renamed from: minus-LRDsOJo, reason: not valid java name */
            public static long m10944minusLRDsOJo(long r100, long r101) {
                return MonotonicTimeSource.INSTANCE.m10924adjustReading6QKq23U(r100, Duration.m10846unaryMinusUwyO8pc(r101));
            }

            /* JADX INFO: renamed from: minus-UwyO8pc, reason: not valid java name */
            public static long m10945minusUwyO8pc(long r100, ComparableTimeMark r101) {
                Intrinsics.checkNotNullParameter(r101, "other");
                if ((r101 instanceof ValueTimeMark) == false) goto L7;
                return m10943minus6eNON_k(r100, ((ValueTimeMark) r101).m10950unboximpl());
            L7:
                throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + m10947toStringimpl(r100) + " and " + r101);
            }

            /* JADX INFO: renamed from: plus-LRDsOJo, reason: not valid java name */
            public static long m10946plusLRDsOJo(long r100, long r101) {
                return MonotonicTimeSource.INSTANCE.m10924adjustReading6QKq23U(r100, r101);
            }
        }

        static {
            INSTANCE = new Monotonic();
        }

        private Monotonic() {
        }

        /* JADX INFO: renamed from: markNow-z9LOYto, reason: not valid java name */
        public long m10932markNowz9LOYto() {
            return MonotonicTimeSource.INSTANCE.m10927markNowz9LOYto();
        }

        public String toString() {
            return MonotonicTimeSource.INSTANCE.toString();
        }

        @Override // kotlin.time.TimeSource.WithComparableMarks, kotlin.time.TimeSource
        public /* bridge */ /* synthetic */ ComparableTimeMark markNow() {
            return ValueTimeMark.m10933boximpl(m10932markNowz9LOYto());
        }

        @Override // kotlin.time.TimeSource
        public /* bridge */ /* synthetic */ TimeMark markNow() {
            return ValueTimeMark.m10933boximpl(m10932markNowz9LOYto());
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lkotlin/time/TimeSource$WithComparableMarks;", "Lkotlin/time/TimeSource;", "markNow", "Lkotlin/time/ComparableTimeMark;", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface WithComparableMarks extends TimeSource {
        @Override // kotlin.time.TimeSource
        ComparableTimeMark markNow();
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    TimeMark markNow();
}
