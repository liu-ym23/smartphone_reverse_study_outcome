package kotlin;

import androidx.exifinterface.media.ExifInterface;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\n\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 v2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001vB\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b\u001c\u0010\u0010J\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\u001d\u0010\u0013J\u0018\u0010\u001b\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u001b\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b'\u0010\u0010J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b(\u0010\u0013J\u0018\u0010&\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\b¢\u0006\u0004\b)\u0010\u001fJ\u0018\u0010&\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b,\u0010-J\u0013\u0010.\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b/\u0010\u0005J\u0013\u00100\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b1\u0010\u0005J\u0018\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b3\u0010\u0010J\u0018\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b4\u0010\u0013J\u0018\u00102\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\b5\u0010\u001fJ\u0018\u00102\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b6\u0010\u0018J\u0018\u00107\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b8\u00109J\u0018\u00107\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b:\u0010\u0013J\u0018\u00107\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\b¢\u0006\u0004\b;\u0010\u001fJ\u0018\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b<\u0010\u000bJ\u0018\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b>\u0010\u000bJ\u0018\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b@\u0010\u0010J\u0018\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bA\u0010\u0013J\u0018\u0010?\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\bB\u0010\u001fJ\u0018\u0010?\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bC\u0010\u0018J\u0018\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bF\u0010GJ\u0018\u0010H\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bI\u0010GJ\u0018\u0010J\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\bK\u0010\u0010J\u0018\u0010J\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bL\u0010\u0013J\u0018\u0010J\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\bM\u0010\u001fJ\u0018\u0010J\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bN\u0010\u0018J\u0018\u0010O\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\bP\u0010\u0010J\u0018\u0010O\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bQ\u0010\u0013J\u0018\u0010O\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\bR\u0010\u001fJ\u0018\u0010O\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bS\u0010\u0018J\u0010\u0010T\u001a\u00020UH\u0087\b¢\u0006\u0004\bV\u0010WJ\u0010\u0010X\u001a\u00020YH\u0087\b¢\u0006\u0004\bZ\u0010[J\u0010\u0010\\\u001a\u00020]H\u0087\b¢\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020\rH\u0087\b¢\u0006\u0004\ba\u0010-J\u0010\u0010b\u001a\u00020cH\u0087\b¢\u0006\u0004\bd\u0010eJ\u0010\u0010f\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bg\u0010\u0005J\u000f\u0010h\u001a\u00020iH\u0016¢\u0006\u0004\bj\u0010kJ\u0013\u0010l\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\bm\u0010WJ\u0013\u0010n\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\bo\u0010-J\u0013\u0010p\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\bq\u0010eJ\u0013\u0010r\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\bs\u0010\u0005J\u0018\u0010t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bu\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0004\n\u0002\b!¨\u0006w"}, d2 = {"Lkotlin/UShort;", "", "data", "", "constructor-impl", "(S)S", "getData$annotations", "()V", "and", "other", "and-xj2QHRw", "(SS)S", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(SB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(SI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(SJ)I", "compareTo-xj2QHRw", "(SS)I", "dec", "dec-Mh2AYeg", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(SJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(SLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(S)I", "inc", "inc-Mh2AYeg", "inv", "inv-Mh2AYeg", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(SB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", SRStrategy.KEY_ORIGIN_RESOLUTION, "or-xj2QHRw", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-xj2QHRw", "(SS)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-xj2QHRw", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(S)B", "toDouble", "", "toDouble-impl", "(S)D", "toFloat", "", "toFloat-impl", "(S)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(S)J", "toShort", "toShort-impl", "toString", "", "toString-impl", "(S)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-xj2QHRw", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class UShort implements Comparable<UShort> {
    public static final Companion Companion = null;
    public static final short MAX_VALUE = -1;
    public static final short MIN_VALUE = 0;
    public static final int SIZE_BITS = 16;
    public static final int SIZE_BYTES = 2;
    private final short data;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u0004X\u0086Tø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u0013\u0010\u0006\u001a\u00020\u0004X\u0086Tø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/UShort$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UShort;", ExifInterface.LATITUDE_SOUTH, "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX INFO: renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UShort m9724boximpl(short r100) {
        return new UShort(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static short m9730constructorimpl(short r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m9736equalsimpl(short r100, Object r101) {
        if ((r101 instanceof UShort) == true) goto L6;
        return false;
    L6:
        if (r100 == ((UShort) r101).m9780unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m9737equalsimpl0(short r100, short r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m9742hashCodeimpl(short r100) {
        return r100;
    }

    /* JADX INFO: renamed from: toByte-impl, reason: not valid java name */
    private static final byte m9768toByteimpl(short r100) {
        return (byte) r100;
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    private static final int m9771toIntimpl(short r100) {
        return r100 & 65535;
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    private static final long m9772toLongimpl(short r100) {
        return ((long) r100) & 65535;
    }

    /* JADX INFO: renamed from: toShort-impl, reason: not valid java name */
    private static final short m9773toShortimpl(short r100) {
        return r100;
    }

    /* JADX INFO: renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m9778toUShortMh2AYeg(short r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m9736equalsimpl(this.data, r100);
    }

    public int hashCode() {
        return m9742hashCodeimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ short m9780unboximpl() {
        return this.data;
    }

    public String toString() {
        return m9774toStringimpl(this.data);
    }

    private /* synthetic */ UShort(short r100) {
        this.data = r100;
    }

    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private int m9728compareToxj2QHRw(short r100) {
        return Intrinsics.compare(m9780unboximpl() & 65535, r100 & 65535);
    }

    /* JADX INFO: renamed from: dec-Mh2AYeg, reason: not valid java name */
    private static final short m9731decMh2AYeg(short r100) {
        return m9730constructorimpl((short) (r100 - 1));
    }

    /* JADX INFO: renamed from: inc-Mh2AYeg, reason: not valid java name */
    private static final short m9743incMh2AYeg(short r100) {
        return m9730constructorimpl((short) (r100 + 1));
    }

    /* JADX INFO: renamed from: inv-Mh2AYeg, reason: not valid java name */
    private static final short m9744invMh2AYeg(short r100) {
        return m9730constructorimpl((short) (~r100));
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    private static final double m9769toDoubleimpl(short r100) {
        return UnsignedKt.uintToDouble(r100 & 65535);
    }

    /* JADX INFO: renamed from: toFloat-impl, reason: not valid java name */
    private static final float m9770toFloatimpl(short r100) {
        return (float) UnsignedKt.uintToDouble(r100 & 65535);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m9774toStringimpl(short r100) {
        return String.valueOf(r100 & 65535);
    }

    /* JADX INFO: renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m9775toUBytew2LRezQ(short r100) {
        return UByte.m9467constructorimpl((byte) r100);
    }

    /* JADX INFO: renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m9776toUIntpVg5ArA(short r100) {
        return UInt.m9544constructorimpl(r100 & 65535);
    }

    /* JADX INFO: renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m9777toULongsVKNKU(short r100) {
        return ULong.m9623constructorimpl(((long) r100) & 65535);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UShort r100) {
        short r101 = r100.m9780unboximpl();
        return Intrinsics.compare(m9780unboximpl() & 65535, r101 & 65535);
    }

    /* JADX INFO: renamed from: and-xj2QHRw, reason: not valid java name */
    private static final short m9723andxj2QHRw(short r100, short r101) {
        return m9730constructorimpl((short) (r100 & r101));
    }

    /* JADX INFO: renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m9725compareTo7apg3OU(short r100, byte r101) {
        return Intrinsics.compare(r100 & 65535, r101 & UByte.MAX_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m9726compareToVKZWuLQ(short r100, long r101) {
        return Long.compare(ULong.m9623constructorimpl(((long) r100) & 65535) ^ Long.MIN_VALUE, r101 ^ Long.MIN_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m9727compareToWZ4Q5Ns(short r100, int r101) {
        return Integer.compare(UInt.m9544constructorimpl(r100 & 65535) ^ Integer.MIN_VALUE, r101 ^ Integer.MIN_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static int m9729compareToxj2QHRw(short r100, short r101) {
        return Intrinsics.compare(r100 & 65535, r101 & 65535);
    }

    /* JADX INFO: renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m9732div7apg3OU(short r100, byte r101) {
        int r102 = UInt.m9544constructorimpl(r100 & 65535);
        int r103 = UInt.m9544constructorimpl(r101 & UByte.MAX_VALUE);
        return (int) ((((long) r102) & BodyPartID.bodyIdMax) / (((long) r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m9733divVKZWuLQ(short r100, long r101) {
        long r102 = ULong.m9623constructorimpl(((long) r100) & 65535);
        if (r101 >= 0) goto L9;
        if ((r102 ^ Long.MIN_VALUE) < (r101 ^ Long.MIN_VALUE)) goto L19;
        return 1;
    L19:
        return 0;
    L9:
        if (r102 >= 0) goto L18;
        int r103 = 1;
        long r104 = ((r102 >>> 1) / r101) << 1;
        if (((r102 - (r104 * r101)) ^ Long.MIN_VALUE) >= (r101 ^ Long.MIN_VALUE)) goto L16;
        r103 = 0;
    L16:
        return r104 + ((long) r103);
    L18:
        return r102 / r101;
    }

    /* JADX INFO: renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m9734divWZ4Q5Ns(short r100, int r101) {
        return (int) ((((long) UInt.m9544constructorimpl(r100 & 65535)) & BodyPartID.bodyIdMax) / (((long) r101) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m9735divxj2QHRw(short r100, short r101) {
        int r102 = UInt.m9544constructorimpl(r100 & 65535);
        int r103 = UInt.m9544constructorimpl(r101 & 65535);
        return (int) ((((long) r102) & BodyPartID.bodyIdMax) / (((long) r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m9738floorDiv7apg3OU(short r100, byte r101) {
        int r102 = UInt.m9544constructorimpl(r100 & 65535);
        int r103 = UInt.m9544constructorimpl(r101 & UByte.MAX_VALUE);
        return (int) ((((long) r102) & BodyPartID.bodyIdMax) / (((long) r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m9739floorDivVKZWuLQ(short r100, long r101) {
        long r102 = ULong.m9623constructorimpl(((long) r100) & 65535);
        if (r101 >= 0) goto L9;
        if ((r102 ^ Long.MIN_VALUE) < (r101 ^ Long.MIN_VALUE)) goto L19;
        return 1;
    L19:
        return 0;
    L9:
        if (r102 >= 0) goto L18;
        int r103 = 1;
        long r104 = ((r102 >>> 1) / r101) << 1;
        if (((r102 - (r104 * r101)) ^ Long.MIN_VALUE) >= (r101 ^ Long.MIN_VALUE)) goto L16;
        r103 = 0;
    L16:
        return r104 + ((long) r103);
    L18:
        return r102 / r101;
    }

    /* JADX INFO: renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m9740floorDivWZ4Q5Ns(short r100, int r101) {
        return (int) ((((long) UInt.m9544constructorimpl(r100 & 65535)) & BodyPartID.bodyIdMax) / (((long) r101) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m9741floorDivxj2QHRw(short r100, short r101) {
        int r102 = UInt.m9544constructorimpl(r100 & 65535);
        int r103 = UInt.m9544constructorimpl(r101 & 65535);
        return (int) ((((long) r102) & BodyPartID.bodyIdMax) / (((long) r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m9745minus7apg3OU(short r100, byte r101) {
        return UInt.m9544constructorimpl(UInt.m9544constructorimpl(r100 & 65535) - UInt.m9544constructorimpl(r101 & UByte.MAX_VALUE));
    }

    /* JADX INFO: renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m9746minusVKZWuLQ(short r100, long r101) {
        return ULong.m9623constructorimpl(ULong.m9623constructorimpl(((long) r100) & 65535) - r101);
    }

    /* JADX INFO: renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m9747minusWZ4Q5Ns(short r100, int r101) {
        return UInt.m9544constructorimpl(UInt.m9544constructorimpl(r100 & 65535) - r101);
    }

    /* JADX INFO: renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m9748minusxj2QHRw(short r100, short r101) {
        return UInt.m9544constructorimpl(UInt.m9544constructorimpl(r100 & 65535) - UInt.m9544constructorimpl(r101 & 65535));
    }

    /* JADX INFO: renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m9749mod7apg3OU(short r100, byte r101) {
        return UByte.m9467constructorimpl((byte) ((((long) UInt.m9544constructorimpl(r100 & 65535)) & BodyPartID.bodyIdMax) % (((long) UInt.m9544constructorimpl(r101 & UByte.MAX_VALUE)) & BodyPartID.bodyIdMax)));
    }

    /* JADX INFO: renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m9750modVKZWuLQ(short r100, long r101) {
        long r102 = ULong.m9623constructorimpl(((long) r100) & 65535);
        if (r101 >= 0) goto L9;
        if ((r102 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r101)) goto L15;
        return r102;
    L15:
        return r102 - r101;
    L9:
        if (r102 >= 0) goto L16;
        r102 = r102 - ((((r102 >>> 1) / r101) << 1) * r101);
        if ((r102 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r101)) goto L15;
        r101 = 0;
        goto L15
    L16:
        return r102 % r101;
    }

    /* JADX INFO: renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m9751modWZ4Q5Ns(short r100, int r101) {
        return (int) ((((long) UInt.m9544constructorimpl(r100 & 65535)) & BodyPartID.bodyIdMax) % (((long) r101) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m9752modxj2QHRw(short r100, short r101) {
        return m9730constructorimpl((short) ((((long) UInt.m9544constructorimpl(r100 & 65535)) & BodyPartID.bodyIdMax) % (((long) UInt.m9544constructorimpl(r101 & 65535)) & BodyPartID.bodyIdMax)));
    }

    /* JADX INFO: renamed from: or-xj2QHRw, reason: not valid java name */
    private static final short m9753orxj2QHRw(short r100, short r101) {
        return m9730constructorimpl((short) (r100 | r101));
    }

    /* JADX INFO: renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m9754plus7apg3OU(short r100, byte r101) {
        return UInt.m9544constructorimpl(UInt.m9544constructorimpl(r100 & 65535) + UInt.m9544constructorimpl(r101 & UByte.MAX_VALUE));
    }

    /* JADX INFO: renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m9755plusVKZWuLQ(short r100, long r101) {
        return ULong.m9623constructorimpl(ULong.m9623constructorimpl(((long) r100) & 65535) + r101);
    }

    /* JADX INFO: renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m9756plusWZ4Q5Ns(short r100, int r101) {
        return UInt.m9544constructorimpl(UInt.m9544constructorimpl(r100 & 65535) + r101);
    }

    /* JADX INFO: renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m9757plusxj2QHRw(short r100, short r101) {
        return UInt.m9544constructorimpl(UInt.m9544constructorimpl(r100 & 65535) + UInt.m9544constructorimpl(r101 & 65535));
    }

    /* JADX INFO: renamed from: rangeTo-xj2QHRw, reason: not valid java name */
    private static final UIntRange m9758rangeToxj2QHRw(short r100, short r101) {
        return new UIntRange(UInt.m9544constructorimpl(r100 & 65535), UInt.m9544constructorimpl(r101 & 65535), null);
    }

    /* JADX INFO: renamed from: rangeUntil-xj2QHRw, reason: not valid java name */
    private static final UIntRange m9759rangeUntilxj2QHRw(short r100, short r101) {
        return URangesKt.m10721untilJ1ME1BU(UInt.m9544constructorimpl(r100 & 65535), UInt.m9544constructorimpl(r101 & 65535));
    }

    /* JADX INFO: renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m9760rem7apg3OU(short r100, byte r101) {
        int r102 = UInt.m9544constructorimpl(r100 & 65535);
        int r103 = UInt.m9544constructorimpl(r101 & UByte.MAX_VALUE);
        return (int) ((((long) r102) & BodyPartID.bodyIdMax) % (((long) r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m9761remVKZWuLQ(short r100, long r101) {
        long r102 = ULong.m9623constructorimpl(((long) r100) & 65535);
        if (r101 >= 0) goto L9;
        if ((r102 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r101)) goto L15;
        return r102;
    L15:
        return r102 - r101;
    L9:
        if (r102 >= 0) goto L16;
        r102 = r102 - ((((r102 >>> 1) / r101) << 1) * r101);
        if ((r102 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r101)) goto L15;
        r101 = 0;
        goto L15
    L16:
        return r102 % r101;
    }

    /* JADX INFO: renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m9762remWZ4Q5Ns(short r100, int r101) {
        return (int) ((((long) UInt.m9544constructorimpl(r100 & 65535)) & BodyPartID.bodyIdMax) % (((long) r101) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m9763remxj2QHRw(short r100, short r101) {
        int r102 = UInt.m9544constructorimpl(r100 & 65535);
        int r103 = UInt.m9544constructorimpl(r101 & 65535);
        return (int) ((((long) r102) & BodyPartID.bodyIdMax) % (((long) r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m9764times7apg3OU(short r100, byte r101) {
        return UInt.m9544constructorimpl(UInt.m9544constructorimpl(r100 & 65535) * UInt.m9544constructorimpl(r101 & UByte.MAX_VALUE));
    }

    /* JADX INFO: renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m9765timesVKZWuLQ(short r100, long r101) {
        return ULong.m9623constructorimpl(ULong.m9623constructorimpl(((long) r100) & 65535) * r101);
    }

    /* JADX INFO: renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m9766timesWZ4Q5Ns(short r100, int r101) {
        return UInt.m9544constructorimpl(UInt.m9544constructorimpl(r100 & 65535) * r101);
    }

    /* JADX INFO: renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m9767timesxj2QHRw(short r100, short r101) {
        return UInt.m9544constructorimpl(UInt.m9544constructorimpl(r100 & 65535) * UInt.m9544constructorimpl(r101 & 65535));
    }

    /* JADX INFO: renamed from: xor-xj2QHRw, reason: not valid java name */
    private static final short m9779xorxj2QHRw(short r100, short r101) {
        return m9730constructorimpl((short) (r100 ^ r101));
    }
}
