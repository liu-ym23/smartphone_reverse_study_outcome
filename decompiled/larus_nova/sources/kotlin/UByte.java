package kotlin;

import com.ss.ttvideoengine.superresolution.SRStrategy;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 v2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001vB\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u0005J\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u001c\u0010\u000fJ\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b\u001d\u0010\u0012J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b\u001e\u0010\u001fJ\u0018\u0010\u001b\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\b \u0010\u0018J\u001a\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b$\u0010%J\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b'\u0010\u000fJ\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b(\u0010\u0012J\u0018\u0010&\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b)\u0010\u001fJ\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\b¢\u0006\u0004\b*\u0010\u0018J\u0010\u0010+\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b,\u0010-J\u0013\u0010.\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b/\u0010\u0005J\u0013\u00100\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b1\u0010\u0005J\u0018\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b3\u0010\u000fJ\u0018\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\b4\u0010\u0012J\u0018\u00102\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\b5\u0010\u001fJ\u0018\u00102\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\b6\u0010\u0018J\u0018\u00107\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b8\u0010\u000bJ\u0018\u00107\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\b¢\u0006\u0004\b9\u0010\u0012J\u0018\u00107\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\b¢\u0006\u0004\b:\u0010\u001fJ\u0018\u00107\u001a\u00020\u00162\u0006\u0010\t\u001a\u00020\u0016H\u0087\b¢\u0006\u0004\b;\u0010<J\u0018\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b>\u0010\u000bJ\u0018\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b@\u0010\u000fJ\u0018\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\bA\u0010\u0012J\u0018\u0010?\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\bB\u0010\u001fJ\u0018\u0010?\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\bC\u0010\u0018J\u0018\u0010D\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bF\u0010GJ\u0018\u0010H\u001a\u00020E2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bI\u0010GJ\u0018\u0010J\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bK\u0010\u000fJ\u0018\u0010J\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\bL\u0010\u0012J\u0018\u0010J\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\bM\u0010\u001fJ\u0018\u0010J\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\bN\u0010\u0018J\u0018\u0010O\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bP\u0010\u000fJ\u0018\u0010O\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0010H\u0087\n¢\u0006\u0004\bQ\u0010\u0012J\u0018\u0010O\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u0013H\u0087\n¢\u0006\u0004\bR\u0010\u001fJ\u0018\u0010O\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u0016H\u0087\n¢\u0006\u0004\bS\u0010\u0018J\u0010\u0010T\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bU\u0010\u0005J\u0010\u0010V\u001a\u00020WH\u0087\b¢\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020[H\u0087\b¢\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020\rH\u0087\b¢\u0006\u0004\b_\u0010-J\u0010\u0010`\u001a\u00020aH\u0087\b¢\u0006\u0004\bb\u0010cJ\u0010\u0010d\u001a\u00020eH\u0087\b¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020iH\u0016¢\u0006\u0004\bj\u0010kJ\u0013\u0010l\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\bm\u0010\u0005J\u0013\u0010n\u001a\u00020\u0010H\u0087\bø\u0001\u0000¢\u0006\u0004\bo\u0010-J\u0013\u0010p\u001a\u00020\u0013H\u0087\bø\u0001\u0000¢\u0006\u0004\bq\u0010cJ\u0013\u0010r\u001a\u00020\u0016H\u0087\bø\u0001\u0000¢\u0006\u0004\bs\u0010gJ\u0018\u0010t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bu\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0004\n\u0002\b!¨\u0006w"}, d2 = {"Lkotlin/UByte;", "", "data", "", "constructor-impl", "(B)B", "getData$annotations", "()V", "and", "other", "and-7apg3OU", "(BB)B", "compareTo", "", "compareTo-7apg3OU", "(BB)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(BI)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(BJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(BS)I", "dec", "dec-w2LRezQ", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(BJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(BLjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "(B)I", "inc", "inc-w2LRezQ", "inv", "inv-w2LRezQ", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(BS)S", SRStrategy.KEY_ORIGIN_RESOLUTION, "or-7apg3OU", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-7apg3OU", "(BB)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-7apg3OU", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "toByte-impl", "toDouble", "", "toDouble-impl", "(B)D", "toFloat", "", "toFloat-impl", "(B)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(B)J", "toShort", "", "toShort-impl", "(B)S", "toString", "", "toString-impl", "(B)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-7apg3OU", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class UByte implements Comparable<UByte> {
    public static final Companion Companion = null;
    public static final byte MAX_VALUE = -1;
    public static final byte MIN_VALUE = 0;
    public static final int SIZE_BITS = 8;
    public static final int SIZE_BYTES = 1;
    private final byte data;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u0004X\u0086Tø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u0013\u0010\u0006\u001a\u00020\u0004X\u0086Tø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/UByte$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UByte;", "B", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
    public static final /* synthetic */ UByte m9461boximpl(byte r100) {
        return new UByte(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static byte m9467constructorimpl(byte r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m9473equalsimpl(byte r100, Object r101) {
        if ((r101 instanceof UByte) == true) goto L6;
        return false;
    L6:
        if (r100 == ((UByte) r101).m9517unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m9474equalsimpl0(byte r100, byte r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m9479hashCodeimpl(byte r100) {
        return r100;
    }

    /* JADX INFO: renamed from: toByte-impl, reason: not valid java name */
    private static final byte m9505toByteimpl(byte r100) {
        return r100;
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    private static final int m9508toIntimpl(byte r100) {
        return r100 & MAX_VALUE;
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    private static final long m9509toLongimpl(byte r100) {
        return ((long) r100) & 255;
    }

    /* JADX INFO: renamed from: toShort-impl, reason: not valid java name */
    private static final short m9510toShortimpl(byte r100) {
        return (short) (r100 & 255);
    }

    /* JADX INFO: renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m9512toUBytew2LRezQ(byte r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m9473equalsimpl(this.data, r100);
    }

    public int hashCode() {
        return m9479hashCodeimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ byte m9517unboximpl() {
        return this.data;
    }

    public String toString() {
        return m9511toStringimpl(this.data);
    }

    private /* synthetic */ UByte(byte r100) {
        this.data = r100;
    }

    /* JADX INFO: renamed from: compareTo-7apg3OU, reason: not valid java name */
    private int m9462compareTo7apg3OU(byte r100) {
        return Intrinsics.compare(m9517unboximpl() & MAX_VALUE, r100 & MAX_VALUE);
    }

    /* JADX INFO: renamed from: dec-w2LRezQ, reason: not valid java name */
    private static final byte m9468decw2LRezQ(byte r100) {
        return m9467constructorimpl((byte) (r100 - 1));
    }

    /* JADX INFO: renamed from: inc-w2LRezQ, reason: not valid java name */
    private static final byte m9480incw2LRezQ(byte r100) {
        return m9467constructorimpl((byte) (r100 + 1));
    }

    /* JADX INFO: renamed from: inv-w2LRezQ, reason: not valid java name */
    private static final byte m9481invw2LRezQ(byte r100) {
        return m9467constructorimpl((byte) (~r100));
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    private static final double m9506toDoubleimpl(byte r100) {
        return UnsignedKt.uintToDouble(r100 & MAX_VALUE);
    }

    /* JADX INFO: renamed from: toFloat-impl, reason: not valid java name */
    private static final float m9507toFloatimpl(byte r100) {
        return (float) UnsignedKt.uintToDouble(r100 & MAX_VALUE);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m9511toStringimpl(byte r100) {
        return String.valueOf(r100 & MAX_VALUE);
    }

    /* JADX INFO: renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m9513toUIntpVg5ArA(byte r100) {
        return UInt.m9544constructorimpl(r100 & MAX_VALUE);
    }

    /* JADX INFO: renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m9514toULongsVKNKU(byte r100) {
        return ULong.m9623constructorimpl(((long) r100) & 255);
    }

    /* JADX INFO: renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m9515toUShortMh2AYeg(byte r100) {
        return UShort.m9730constructorimpl((short) (r100 & 255));
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UByte r100) {
        byte r101 = r100.m9517unboximpl();
        return Intrinsics.compare(m9517unboximpl() & MAX_VALUE, r101 & MAX_VALUE);
    }

    /* JADX INFO: renamed from: and-7apg3OU, reason: not valid java name */
    private static final byte m9460and7apg3OU(byte r100, byte r101) {
        return m9467constructorimpl((byte) (r100 & r101));
    }

    /* JADX INFO: renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static int m9463compareTo7apg3OU(byte r100, byte r101) {
        return Intrinsics.compare(r100 & MAX_VALUE, r101 & MAX_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m9464compareToVKZWuLQ(byte r100, long r101) {
        return Long.compare(ULong.m9623constructorimpl(((long) r100) & 255) ^ Long.MIN_VALUE, r101 ^ Long.MIN_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m9465compareToWZ4Q5Ns(byte r100, int r101) {
        return Integer.compare(UInt.m9544constructorimpl(r100 & MAX_VALUE) ^ Integer.MIN_VALUE, r101 ^ Integer.MIN_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m9466compareToxj2QHRw(byte r100, short r101) {
        return Intrinsics.compare(r100 & MAX_VALUE, r101 & 65535);
    }

    /* JADX INFO: renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m9469div7apg3OU(byte r100, byte r101) {
        int r102 = UInt.m9544constructorimpl(r100 & MAX_VALUE);
        int r103 = UInt.m9544constructorimpl(r101 & MAX_VALUE);
        return (int) ((((long) r102) & BodyPartID.bodyIdMax) / (((long) r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m9470divVKZWuLQ(byte r100, long r101) {
        long r102 = ULong.m9623constructorimpl(((long) r100) & 255);
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
    private static final int m9471divWZ4Q5Ns(byte r100, int r101) {
        return (int) ((((long) UInt.m9544constructorimpl(r100 & MAX_VALUE)) & BodyPartID.bodyIdMax) / (((long) r101) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m9472divxj2QHRw(byte r100, short r101) {
        int r102 = UInt.m9544constructorimpl(r100 & MAX_VALUE);
        int r103 = UInt.m9544constructorimpl(r101 & 65535);
        return (int) ((((long) r102) & BodyPartID.bodyIdMax) / (((long) r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m9475floorDiv7apg3OU(byte r100, byte r101) {
        int r102 = UInt.m9544constructorimpl(r100 & MAX_VALUE);
        int r103 = UInt.m9544constructorimpl(r101 & MAX_VALUE);
        return (int) ((((long) r102) & BodyPartID.bodyIdMax) / (((long) r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m9476floorDivVKZWuLQ(byte r100, long r101) {
        long r102 = ULong.m9623constructorimpl(((long) r100) & 255);
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
    private static final int m9477floorDivWZ4Q5Ns(byte r100, int r101) {
        return (int) ((((long) UInt.m9544constructorimpl(r100 & MAX_VALUE)) & BodyPartID.bodyIdMax) / (((long) r101) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m9478floorDivxj2QHRw(byte r100, short r101) {
        int r102 = UInt.m9544constructorimpl(r100 & MAX_VALUE);
        int r103 = UInt.m9544constructorimpl(r101 & 65535);
        return (int) ((((long) r102) & BodyPartID.bodyIdMax) / (((long) r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m9482minus7apg3OU(byte r100, byte r101) {
        return UInt.m9544constructorimpl(UInt.m9544constructorimpl(r100 & MAX_VALUE) - UInt.m9544constructorimpl(r101 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m9483minusVKZWuLQ(byte r100, long r101) {
        return ULong.m9623constructorimpl(ULong.m9623constructorimpl(((long) r100) & 255) - r101);
    }

    /* JADX INFO: renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m9484minusWZ4Q5Ns(byte r100, int r101) {
        return UInt.m9544constructorimpl(UInt.m9544constructorimpl(r100 & MAX_VALUE) - r101);
    }

    /* JADX INFO: renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m9485minusxj2QHRw(byte r100, short r101) {
        return UInt.m9544constructorimpl(UInt.m9544constructorimpl(r100 & MAX_VALUE) - UInt.m9544constructorimpl(r101 & 65535));
    }

    /* JADX INFO: renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m9486mod7apg3OU(byte r100, byte r101) {
        return m9467constructorimpl((byte) ((((long) UInt.m9544constructorimpl(r100 & MAX_VALUE)) & BodyPartID.bodyIdMax) % (((long) UInt.m9544constructorimpl(r101 & MAX_VALUE)) & BodyPartID.bodyIdMax)));
    }

    /* JADX INFO: renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m9487modVKZWuLQ(byte r100, long r101) {
        long r102 = ULong.m9623constructorimpl(((long) r100) & 255);
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
    private static final int m9488modWZ4Q5Ns(byte r100, int r101) {
        return (int) ((((long) UInt.m9544constructorimpl(r100 & MAX_VALUE)) & BodyPartID.bodyIdMax) % (((long) r101) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m9489modxj2QHRw(byte r100, short r101) {
        return UShort.m9730constructorimpl((short) ((((long) UInt.m9544constructorimpl(r100 & MAX_VALUE)) & BodyPartID.bodyIdMax) % (((long) UInt.m9544constructorimpl(r101 & 65535)) & BodyPartID.bodyIdMax)));
    }

    /* JADX INFO: renamed from: or-7apg3OU, reason: not valid java name */
    private static final byte m9490or7apg3OU(byte r100, byte r101) {
        return m9467constructorimpl((byte) (r100 | r101));
    }

    /* JADX INFO: renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m9491plus7apg3OU(byte r100, byte r101) {
        return UInt.m9544constructorimpl(UInt.m9544constructorimpl(r100 & MAX_VALUE) + UInt.m9544constructorimpl(r101 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m9492plusVKZWuLQ(byte r100, long r101) {
        return ULong.m9623constructorimpl(ULong.m9623constructorimpl(((long) r100) & 255) + r101);
    }

    /* JADX INFO: renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m9493plusWZ4Q5Ns(byte r100, int r101) {
        return UInt.m9544constructorimpl(UInt.m9544constructorimpl(r100 & MAX_VALUE) + r101);
    }

    /* JADX INFO: renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m9494plusxj2QHRw(byte r100, short r101) {
        return UInt.m9544constructorimpl(UInt.m9544constructorimpl(r100 & MAX_VALUE) + UInt.m9544constructorimpl(r101 & 65535));
    }

    /* JADX INFO: renamed from: rangeTo-7apg3OU, reason: not valid java name */
    private static final UIntRange m9495rangeTo7apg3OU(byte r100, byte r101) {
        return new UIntRange(UInt.m9544constructorimpl(r100 & MAX_VALUE), UInt.m9544constructorimpl(r101 & MAX_VALUE), null);
    }

    /* JADX INFO: renamed from: rangeUntil-7apg3OU, reason: not valid java name */
    private static final UIntRange m9496rangeUntil7apg3OU(byte r100, byte r101) {
        return URangesKt.m10721untilJ1ME1BU(UInt.m9544constructorimpl(r100 & MAX_VALUE), UInt.m9544constructorimpl(r101 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m9497rem7apg3OU(byte r100, byte r101) {
        int r102 = UInt.m9544constructorimpl(r100 & MAX_VALUE);
        int r103 = UInt.m9544constructorimpl(r101 & MAX_VALUE);
        return (int) ((((long) r102) & BodyPartID.bodyIdMax) % (((long) r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m9498remVKZWuLQ(byte r100, long r101) {
        long r102 = ULong.m9623constructorimpl(((long) r100) & 255);
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
    private static final int m9499remWZ4Q5Ns(byte r100, int r101) {
        return (int) ((((long) UInt.m9544constructorimpl(r100 & MAX_VALUE)) & BodyPartID.bodyIdMax) % (((long) r101) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m9500remxj2QHRw(byte r100, short r101) {
        int r102 = UInt.m9544constructorimpl(r100 & MAX_VALUE);
        int r103 = UInt.m9544constructorimpl(r101 & 65535);
        return (int) ((((long) r102) & BodyPartID.bodyIdMax) % (((long) r103) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m9501times7apg3OU(byte r100, byte r101) {
        return UInt.m9544constructorimpl(UInt.m9544constructorimpl(r100 & MAX_VALUE) * UInt.m9544constructorimpl(r101 & MAX_VALUE));
    }

    /* JADX INFO: renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m9502timesVKZWuLQ(byte r100, long r101) {
        return ULong.m9623constructorimpl(ULong.m9623constructorimpl(((long) r100) & 255) * r101);
    }

    /* JADX INFO: renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m9503timesWZ4Q5Ns(byte r100, int r101) {
        return UInt.m9544constructorimpl(UInt.m9544constructorimpl(r100 & MAX_VALUE) * r101);
    }

    /* JADX INFO: renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m9504timesxj2QHRw(byte r100, short r101) {
        return UInt.m9544constructorimpl(UInt.m9544constructorimpl(r100 & MAX_VALUE) * UInt.m9544constructorimpl(r101 & 65535));
    }

    /* JADX INFO: renamed from: xor-7apg3OU, reason: not valid java name */
    private static final byte m9516xor7apg3OU(byte r100, byte r101) {
        return m9467constructorimpl((byte) (r100 ^ r101));
    }
}
