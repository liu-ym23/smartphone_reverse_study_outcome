package kotlin;

import com.ss.ttvideoengine.superresolution.SRStrategy;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ULongRange;
import kotlin.ranges.URangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 ~2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001~B\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b \u0010\u000bJ\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\b!\u0010\"J\u001a\u0010#\u001a\u00020$2\b\u0010\t\u001a\u0004\u0018\u00010%HÖ\u0003¢\u0006\u0004\b&\u0010'J\u0018\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b)\u0010\u001dJ\u0018\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b*\u0010\u001fJ\u0018\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b+\u0010\u000bJ\u0018\u0010(\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\b¢\u0006\u0004\b,\u0010\"J\u0010\u0010-\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b.\u0010/J\u0013\u00100\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b1\u0010\u0005J\u0013\u00102\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b3\u0010\u0005J\u0018\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b5\u0010\u001dJ\u0018\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b6\u0010\u001fJ\u0018\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b7\u0010\u000bJ\u0018\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\b8\u0010\"J\u0018\u00109\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b:\u0010;J\u0018\u00109\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b<\u0010\u0013J\u0018\u00109\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b=\u0010\u000bJ\u0018\u00109\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\u0087\b¢\u0006\u0004\b>\u0010?J\u0018\u0010@\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bA\u0010\u000bJ\u0018\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\bC\u0010\u001dJ\u0018\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bD\u0010\u001fJ\u0018\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bE\u0010\u000bJ\u0018\u0010B\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\bF\u0010\"J\u0018\u0010G\u001a\u00020H2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bI\u0010JJ\u0018\u0010K\u001a\u00020H2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bL\u0010JJ\u0018\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\bN\u0010\u001dJ\u0018\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bO\u0010\u001fJ\u0018\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bP\u0010\u000bJ\u0018\u0010M\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\bQ\u0010\"J\u001b\u0010R\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\rH\u0087\fø\u0001\u0000¢\u0006\u0004\bT\u0010\u001fJ\u001b\u0010U\u001a\u00020\u00002\u0006\u0010S\u001a\u00020\rH\u0087\fø\u0001\u0000¢\u0006\u0004\bV\u0010\u001fJ\u0018\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\bX\u0010\u001dJ\u0018\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bY\u0010\u001fJ\u0018\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bZ\u0010\u000bJ\u0018\u0010W\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\b[\u0010\"J\u0010\u0010\\\u001a\u00020]H\u0087\b¢\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020aH\u0087\b¢\u0006\u0004\bb\u0010cJ\u0010\u0010d\u001a\u00020eH\u0087\b¢\u0006\u0004\bf\u0010gJ\u0010\u0010h\u001a\u00020\rH\u0087\b¢\u0006\u0004\bi\u0010/J\u0010\u0010j\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bk\u0010\u0005J\u0010\u0010l\u001a\u00020mH\u0087\b¢\u0006\u0004\bn\u0010oJ\u000f\u0010p\u001a\u00020qH\u0016¢\u0006\u0004\br\u0010sJ\u0013\u0010t\u001a\u00020\u000eH\u0087\bø\u0001\u0000¢\u0006\u0004\bu\u0010_J\u0013\u0010v\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\bw\u0010/J\u0013\u0010x\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\by\u0010\u0005J\u0013\u0010z\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\b{\u0010oJ\u0018\u0010|\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b}\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0004\n\u0002\b!¨\u0006\u007f"}, d2 = {"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "getData$annotations", "()V", "and", "other", "and-VKZWuLQ", "(JJ)J", "compareTo", "", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "dec", "dec-s-VKNKU", "div", "div-7apg3OU", "(JB)J", "div-WZ4Q5Ns", "(JI)J", "div-VKZWuLQ", "div-xj2QHRw", "(JS)J", "equals", "", "", "equals-impl", "(JLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(J)I", "inc", "inc-s-VKNKU", "inv", "inv-s-VKNKU", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(JB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(JS)S", SRStrategy.KEY_ORIGIN_RESOLUTION, "or-VKZWuLQ", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rangeUntil", "rangeUntil-VKZWuLQ", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(J)B", "toDouble", "", "toDouble-impl", "(J)D", "toFloat", "", "toFloat-impl", "(J)F", "toInt", "toInt-impl", "toLong", "toLong-impl", "toShort", "", "toShort-impl", "(J)S", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-VKZWuLQ", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class ULong implements Comparable<ULong> {
    public static final Companion Companion = null;
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    private final long data;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u0004X\u0086Tø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u0013\u0010\u0006\u001a\u00020\u0004X\u0086Tø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/ULong$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/ULong;", "J", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
    public static final /* synthetic */ ULong m9617boximpl(long r100) {
        return new ULong(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static long m9623constructorimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m9629equalsimpl(long r100, Object r101) {
        if ((r101 instanceof ULong) == true) goto L6;
        return false;
    L6:
        if (r100 == ((ULong) r101).m9675unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m9630equalsimpl0(long r100, long r101) {
        if (r100 != r101) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m9635hashCodeimpl(long r100) {
        return (int) (r100 ^ (r100 >>> 32));
    }

    /* JADX INFO: renamed from: toByte-impl, reason: not valid java name */
    private static final byte m9663toByteimpl(long r100) {
        return (byte) r100;
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    private static final int m9666toIntimpl(long r100) {
        return (int) r100;
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    private static final long m9667toLongimpl(long r100) {
        return r100;
    }

    /* JADX INFO: renamed from: toShort-impl, reason: not valid java name */
    private static final short m9668toShortimpl(long r100) {
        return (short) r100;
    }

    /* JADX INFO: renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m9672toULongsVKNKU(long r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m9629equalsimpl(this.data, r100);
    }

    public int hashCode() {
        return m9635hashCodeimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m9675unboximpl() {
        return this.data;
    }

    public String toString() {
        return m9669toStringimpl(this.data);
    }

    private /* synthetic */ ULong(long r100) {
        this.data = r100;
    }

    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private int m9619compareToVKZWuLQ(long r100) {
        return UnsignedKt.ulongCompare(m9675unboximpl(), r100);
    }

    /* JADX INFO: renamed from: dec-s-VKNKU, reason: not valid java name */
    private static final long m9624decsVKNKU(long r100) {
        return m9623constructorimpl(r100 - 1);
    }

    /* JADX INFO: renamed from: inc-s-VKNKU, reason: not valid java name */
    private static final long m9636incsVKNKU(long r100) {
        return m9623constructorimpl(r100 + 1);
    }

    /* JADX INFO: renamed from: inv-s-VKNKU, reason: not valid java name */
    private static final long m9637invsVKNKU(long r100) {
        return m9623constructorimpl(~r100);
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    private static final double m9664toDoubleimpl(long r100) {
        return UnsignedKt.ulongToDouble(r100);
    }

    /* JADX INFO: renamed from: toFloat-impl, reason: not valid java name */
    private static final float m9665toFloatimpl(long r100) {
        return (float) UnsignedKt.ulongToDouble(r100);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m9669toStringimpl(long r100) {
        return UnsignedKt.ulongToString(r100, 10);
    }

    /* JADX INFO: renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m9670toUBytew2LRezQ(long r100) {
        return UByte.m9467constructorimpl((byte) r100);
    }

    /* JADX INFO: renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m9671toUIntpVg5ArA(long r100) {
        return UInt.m9544constructorimpl((int) r100);
    }

    /* JADX INFO: renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m9673toUShortMh2AYeg(long r100) {
        return UShort.m9730constructorimpl((short) r100);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ULong r100) {
        long r101 = r100.m9675unboximpl();
        return UnsignedKt.ulongCompare(m9675unboximpl(), r101);
    }

    /* JADX INFO: renamed from: and-VKZWuLQ, reason: not valid java name */
    private static final long m9616andVKZWuLQ(long r100, long r101) {
        return m9623constructorimpl(r100 & r101);
    }

    /* JADX INFO: renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m9618compareTo7apg3OU(long r100, byte r101) {
        return Long.compare(r100 ^ Long.MIN_VALUE, m9623constructorimpl(((long) r101) & 255) ^ Long.MIN_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static int m9620compareToVKZWuLQ(long r100, long r101) {
        return UnsignedKt.ulongCompare(r100, r101);
    }

    /* JADX INFO: renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m9621compareToWZ4Q5Ns(long r100, int r101) {
        return Long.compare(r100 ^ Long.MIN_VALUE, m9623constructorimpl(((long) r101) & BodyPartID.bodyIdMax) ^ Long.MIN_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m9622compareToxj2QHRw(long r100, short r101) {
        return Long.compare(r100 ^ Long.MIN_VALUE, m9623constructorimpl(((long) r101) & 65535) ^ Long.MIN_VALUE);
    }

    /* JADX INFO: renamed from: div-7apg3OU, reason: not valid java name */
    private static final long m9625div7apg3OU(long r100, byte r110) {
        long r101 = m9623constructorimpl(((long) r110) & 255);
        if (r101 >= 0) goto L9;
        if ((r100 ^ Long.MIN_VALUE) < (r101 ^ Long.MIN_VALUE)) goto L19;
        return 1;
    L19:
        return 0;
    L9:
        if (r100 >= 0) goto L18;
        int r111 = 1;
        long r102 = ((r100 >>> 1) / r101) << 1;
        if (((r100 - (r102 * r101)) ^ Long.MIN_VALUE) >= (r101 ^ Long.MIN_VALUE)) goto L16;
        r111 = 0;
    L16:
        return r102 + ((long) r111);
    L18:
        return r100 / r101;
    }

    /* JADX INFO: renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m9626divVKZWuLQ(long r100, long r101) {
        return UnsignedKt.m9802ulongDivideeb3DHEI(r100, r101);
    }

    /* JADX INFO: renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final long m9627divWZ4Q5Ns(long r100, int r110) {
        long r101 = m9623constructorimpl(((long) r110) & BodyPartID.bodyIdMax);
        if (r101 >= 0) goto L9;
        if ((r100 ^ Long.MIN_VALUE) < (r101 ^ Long.MIN_VALUE)) goto L19;
        return 1;
    L19:
        return 0;
    L9:
        if (r100 >= 0) goto L18;
        int r111 = 1;
        long r102 = ((r100 >>> 1) / r101) << 1;
        if (((r100 - (r102 * r101)) ^ Long.MIN_VALUE) >= (r101 ^ Long.MIN_VALUE)) goto L16;
        r111 = 0;
    L16:
        return r102 + ((long) r111);
    L18:
        return r100 / r101;
    }

    /* JADX INFO: renamed from: div-xj2QHRw, reason: not valid java name */
    private static final long m9628divxj2QHRw(long r100, short r110) {
        long r101 = m9623constructorimpl(((long) r110) & 65535);
        if (r101 >= 0) goto L9;
        if ((r100 ^ Long.MIN_VALUE) < (r101 ^ Long.MIN_VALUE)) goto L19;
        return 1;
    L19:
        return 0;
    L9:
        if (r100 >= 0) goto L18;
        int r111 = 1;
        long r102 = ((r100 >>> 1) / r101) << 1;
        if (((r100 - (r102 * r101)) ^ Long.MIN_VALUE) >= (r101 ^ Long.MIN_VALUE)) goto L16;
        r111 = 0;
    L16:
        return r102 + ((long) r111);
    L18:
        return r100 / r101;
    }

    /* JADX INFO: renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final long m9631floorDiv7apg3OU(long r100, byte r110) {
        long r101 = m9623constructorimpl(((long) r110) & 255);
        if (r101 >= 0) goto L9;
        if ((r100 ^ Long.MIN_VALUE) < (r101 ^ Long.MIN_VALUE)) goto L19;
        return 1;
    L19:
        return 0;
    L9:
        if (r100 >= 0) goto L18;
        int r111 = 1;
        long r102 = ((r100 >>> 1) / r101) << 1;
        if (((r100 - (r102 * r101)) ^ Long.MIN_VALUE) >= (r101 ^ Long.MIN_VALUE)) goto L16;
        r111 = 0;
    L16:
        return r102 + ((long) r111);
    L18:
        return r100 / r101;
    }

    /* JADX INFO: renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m9632floorDivVKZWuLQ(long r100, long r101) {
        if (r101 >= 0) goto L9;
        if ((r100 ^ Long.MIN_VALUE) < (r101 ^ Long.MIN_VALUE)) goto L19;
        return 1;
    L19:
        return 0;
    L9:
        if (r100 >= 0) goto L18;
        int r102 = 1;
        long r103 = ((r100 >>> 1) / r101) << 1;
        if (((r100 - (r103 * r101)) ^ Long.MIN_VALUE) >= (r101 ^ Long.MIN_VALUE)) goto L16;
        r102 = 0;
    L16:
        return r103 + ((long) r102);
    L18:
        return r100 / r101;
    }

    /* JADX INFO: renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final long m9633floorDivWZ4Q5Ns(long r100, int r110) {
        long r101 = m9623constructorimpl(((long) r110) & BodyPartID.bodyIdMax);
        if (r101 >= 0) goto L9;
        if ((r100 ^ Long.MIN_VALUE) < (r101 ^ Long.MIN_VALUE)) goto L19;
        return 1;
    L19:
        return 0;
    L9:
        if (r100 >= 0) goto L18;
        int r111 = 1;
        long r102 = ((r100 >>> 1) / r101) << 1;
        if (((r100 - (r102 * r101)) ^ Long.MIN_VALUE) >= (r101 ^ Long.MIN_VALUE)) goto L16;
        r111 = 0;
    L16:
        return r102 + ((long) r111);
    L18:
        return r100 / r101;
    }

    /* JADX INFO: renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final long m9634floorDivxj2QHRw(long r100, short r110) {
        long r101 = m9623constructorimpl(((long) r110) & 65535);
        if (r101 >= 0) goto L9;
        if ((r100 ^ Long.MIN_VALUE) < (r101 ^ Long.MIN_VALUE)) goto L19;
        return 1;
    L19:
        return 0;
    L9:
        if (r100 >= 0) goto L18;
        int r111 = 1;
        long r102 = ((r100 >>> 1) / r101) << 1;
        if (((r100 - (r102 * r101)) ^ Long.MIN_VALUE) >= (r101 ^ Long.MIN_VALUE)) goto L16;
        r111 = 0;
    L16:
        return r102 + ((long) r111);
    L18:
        return r100 / r101;
    }

    /* JADX INFO: renamed from: minus-7apg3OU, reason: not valid java name */
    private static final long m9638minus7apg3OU(long r100, byte r101) {
        return m9623constructorimpl(r100 - m9623constructorimpl(((long) r101) & 255));
    }

    /* JADX INFO: renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m9639minusVKZWuLQ(long r100, long r101) {
        return m9623constructorimpl(r100 - r101);
    }

    /* JADX INFO: renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final long m9640minusWZ4Q5Ns(long r100, int r101) {
        return m9623constructorimpl(r100 - m9623constructorimpl(((long) r101) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final long m9641minusxj2QHRw(long r100, short r101) {
        return m9623constructorimpl(r100 - m9623constructorimpl(((long) r101) & 65535));
    }

    /* JADX INFO: renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m9642mod7apg3OU(long r100, byte r110) {
        long r101 = m9623constructorimpl(((long) r110) & 255);
        if (r101 >= 0) goto L9;
        if ((r100 ^ Long.MIN_VALUE) < (Long.MIN_VALUE ^ r101)) goto L16;
    L7:
        r100 = r100 - r101;
    L16:
        return UByte.m9467constructorimpl((byte) r100);
    L9:
        if (r100 < 0) goto L11;
        r100 = r100 % r101;
        goto L16
    L11:
        r100 = r100 - ((((r100 >>> 1) / r101) << 1) * r101);
        if ((r100 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r101)) goto L7;
        r101 = 0;
        goto L7
    }

    /* JADX INFO: renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m9643modVKZWuLQ(long r100, long r101) {
        if (r101 >= 0) goto L9;
        if ((r100 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r101)) goto L15;
        return r100;
    L15:
        return r100 - r101;
    L9:
        if (r100 >= 0) goto L16;
        r100 = r100 - ((((r100 >>> 1) / r101) << 1) * r101);
        if ((r100 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r101)) goto L15;
        r101 = 0;
        goto L15
    L16:
        return r100 % r101;
    }

    /* JADX INFO: renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m9644modWZ4Q5Ns(long r100, int r110) {
        long r101 = m9623constructorimpl(((long) r110) & BodyPartID.bodyIdMax);
        if (r101 >= 0) goto L9;
        if ((r100 ^ Long.MIN_VALUE) < (Long.MIN_VALUE ^ r101)) goto L16;
    L7:
        r100 = r100 - r101;
    L16:
        return UInt.m9544constructorimpl((int) r100);
    L9:
        if (r100 < 0) goto L11;
        r100 = r100 % r101;
        goto L16
    L11:
        r100 = r100 - ((((r100 >>> 1) / r101) << 1) * r101);
        if ((r100 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r101)) goto L7;
        r101 = 0;
        goto L7
    }

    /* JADX INFO: renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m9645modxj2QHRw(long r100, short r110) {
        long r101 = m9623constructorimpl(((long) r110) & 65535);
        if (r101 >= 0) goto L9;
        if ((r100 ^ Long.MIN_VALUE) < (Long.MIN_VALUE ^ r101)) goto L16;
    L7:
        r100 = r100 - r101;
    L16:
        return UShort.m9730constructorimpl((short) r100);
    L9:
        if (r100 < 0) goto L11;
        r100 = r100 % r101;
        goto L16
    L11:
        r100 = r100 - ((((r100 >>> 1) / r101) << 1) * r101);
        if ((r100 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r101)) goto L7;
        r101 = 0;
        goto L7
    }

    /* JADX INFO: renamed from: or-VKZWuLQ, reason: not valid java name */
    private static final long m9646orVKZWuLQ(long r100, long r101) {
        return m9623constructorimpl(r100 | r101);
    }

    /* JADX INFO: renamed from: plus-7apg3OU, reason: not valid java name */
    private static final long m9647plus7apg3OU(long r100, byte r101) {
        return m9623constructorimpl(r100 + m9623constructorimpl(((long) r101) & 255));
    }

    /* JADX INFO: renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m9648plusVKZWuLQ(long r100, long r101) {
        return m9623constructorimpl(r100 + r101);
    }

    /* JADX INFO: renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final long m9649plusWZ4Q5Ns(long r100, int r101) {
        return m9623constructorimpl(r100 + m9623constructorimpl(((long) r101) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final long m9650plusxj2QHRw(long r100, short r101) {
        return m9623constructorimpl(r100 + m9623constructorimpl(((long) r101) & 65535));
    }

    /* JADX INFO: renamed from: rangeTo-VKZWuLQ, reason: not valid java name */
    private static final ULongRange m9651rangeToVKZWuLQ(long r100, long r101) {
        return new ULongRange(r100, r101, null);
    }

    /* JADX INFO: renamed from: rangeUntil-VKZWuLQ, reason: not valid java name */
    private static final ULongRange m9652rangeUntilVKZWuLQ(long r100, long r101) {
        return URangesKt.m10723untileb3DHEI(r100, r101);
    }

    /* JADX INFO: renamed from: rem-7apg3OU, reason: not valid java name */
    private static final long m9653rem7apg3OU(long r100, byte r110) {
        long r101 = m9623constructorimpl(((long) r110) & 255);
        if (r101 >= 0) goto L9;
        if ((r100 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r101)) goto L15;
        return r100;
    L15:
        return r100 - r101;
    L9:
        if (r100 >= 0) goto L16;
        r100 = r100 - ((((r100 >>> 1) / r101) << 1) * r101);
        if ((r100 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r101)) goto L15;
        r101 = 0;
        goto L15
    L16:
        return r100 % r101;
    }

    /* JADX INFO: renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m9654remVKZWuLQ(long r100, long r101) {
        return UnsignedKt.m9803ulongRemaindereb3DHEI(r100, r101);
    }

    /* JADX INFO: renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final long m9655remWZ4Q5Ns(long r100, int r110) {
        long r101 = m9623constructorimpl(((long) r110) & BodyPartID.bodyIdMax);
        if (r101 >= 0) goto L9;
        if ((r100 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r101)) goto L15;
        return r100;
    L15:
        return r100 - r101;
    L9:
        if (r100 >= 0) goto L16;
        r100 = r100 - ((((r100 >>> 1) / r101) << 1) * r101);
        if ((r100 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r101)) goto L15;
        r101 = 0;
        goto L15
    L16:
        return r100 % r101;
    }

    /* JADX INFO: renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final long m9656remxj2QHRw(long r100, short r110) {
        long r101 = m9623constructorimpl(((long) r110) & 65535);
        if (r101 >= 0) goto L9;
        if ((r100 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r101)) goto L15;
        return r100;
    L15:
        return r100 - r101;
    L9:
        if (r100 >= 0) goto L16;
        r100 = r100 - ((((r100 >>> 1) / r101) << 1) * r101);
        if ((r100 ^ Long.MIN_VALUE) >= (Long.MIN_VALUE ^ r101)) goto L15;
        r101 = 0;
        goto L15
    L16:
        return r100 % r101;
    }

    /* JADX INFO: renamed from: shl-s-VKNKU, reason: not valid java name */
    private static final long m9657shlsVKNKU(long r100, int r101) {
        return m9623constructorimpl(r100 << r101);
    }

    /* JADX INFO: renamed from: shr-s-VKNKU, reason: not valid java name */
    private static final long m9658shrsVKNKU(long r100, int r101) {
        return m9623constructorimpl(r100 >>> r101);
    }

    /* JADX INFO: renamed from: times-7apg3OU, reason: not valid java name */
    private static final long m9659times7apg3OU(long r100, byte r101) {
        return m9623constructorimpl(r100 * m9623constructorimpl(((long) r101) & 255));
    }

    /* JADX INFO: renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m9660timesVKZWuLQ(long r100, long r101) {
        return m9623constructorimpl(r100 * r101);
    }

    /* JADX INFO: renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final long m9661timesWZ4Q5Ns(long r100, int r101) {
        return m9623constructorimpl(r100 * m9623constructorimpl(((long) r101) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: times-xj2QHRw, reason: not valid java name */
    private static final long m9662timesxj2QHRw(long r100, short r101) {
        return m9623constructorimpl(r100 * m9623constructorimpl(((long) r101) & 65535));
    }

    /* JADX INFO: renamed from: xor-VKZWuLQ, reason: not valid java name */
    private static final long m9674xorVKZWuLQ(long r100, long r101) {
        return m9623constructorimpl(r100 ^ r101);
    }
}
