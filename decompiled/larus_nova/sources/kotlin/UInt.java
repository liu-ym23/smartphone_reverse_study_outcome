package kotlin;

import com.ss.ttvideoengine.superresolution.SRStrategy;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087@\u0018\u0000 {2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001{B\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\b\u0010\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0005J\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b\u001a\u0010\u000fJ\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u001b\u0010\u000bJ\u0018\u0010\u0019\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0019\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\b\u001e\u0010\u0016J\u001a\u0010\u001f\u001a\u00020 2\b\u0010\t\u001a\u0004\u0018\u00010!HÖ\u0003¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\b¢\u0006\u0004\b%\u0010\u000fJ\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b&\u0010\u000bJ\u0018\u0010$\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b'\u0010\u001dJ\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\b¢\u0006\u0004\b(\u0010\u0016J\u0010\u0010)\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b*\u0010\u0005J\u0013\u0010+\u001a\u00020\u0000H\u0087\nø\u0001\u0000¢\u0006\u0004\b,\u0010\u0005J\u0013\u0010-\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\b.\u0010\u0005J\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b0\u0010\u000fJ\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b1\u0010\u000bJ\u0018\u0010/\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b2\u0010\u001dJ\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\b3\u0010\u0016J\u0018\u00104\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\rH\u0087\b¢\u0006\u0004\b5\u00106J\u0018\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b7\u0010\u000bJ\u0018\u00104\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b8\u0010\u001dJ\u0018\u00104\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0014H\u0087\b¢\u0006\u0004\b9\u0010:J\u0018\u0010;\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\b<\u0010\u000bJ\u0018\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b>\u0010\u000fJ\u0018\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b?\u0010\u000bJ\u0018\u0010=\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b@\u0010\u001dJ\u0018\u0010=\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\bA\u0010\u0016J\u0018\u0010B\u001a\u00020C2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bD\u0010EJ\u0018\u0010F\u001a\u00020C2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bG\u0010EJ\u0018\u0010H\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\bI\u0010\u000fJ\u0018\u0010H\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bJ\u0010\u000bJ\u0018\u0010H\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bK\u0010\u001dJ\u0018\u0010H\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\bL\u0010\u0016J\u001b\u0010M\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0003H\u0087\fø\u0001\u0000¢\u0006\u0004\bO\u0010\u000bJ\u001b\u0010P\u001a\u00020\u00002\u0006\u0010N\u001a\u00020\u0003H\u0087\fø\u0001\u0000¢\u0006\u0004\bQ\u0010\u000bJ\u0018\u0010R\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\bS\u0010\u000fJ\u0018\u0010R\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bT\u0010\u000bJ\u0018\u0010R\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\bU\u0010\u001dJ\u0018\u0010R\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0014H\u0087\n¢\u0006\u0004\bV\u0010\u0016J\u0010\u0010W\u001a\u00020XH\u0087\b¢\u0006\u0004\bY\u0010ZJ\u0010\u0010[\u001a\u00020\\H\u0087\b¢\u0006\u0004\b]\u0010^J\u0010\u0010_\u001a\u00020`H\u0087\b¢\u0006\u0004\ba\u0010bJ\u0010\u0010c\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bd\u0010\u0005J\u0010\u0010e\u001a\u00020fH\u0087\b¢\u0006\u0004\bg\u0010hJ\u0010\u0010i\u001a\u00020jH\u0087\b¢\u0006\u0004\bk\u0010lJ\u000f\u0010m\u001a\u00020nH\u0016¢\u0006\u0004\bo\u0010pJ\u0013\u0010q\u001a\u00020\rH\u0087\bø\u0001\u0000¢\u0006\u0004\br\u0010ZJ\u0013\u0010s\u001a\u00020\u0000H\u0087\bø\u0001\u0000¢\u0006\u0004\bt\u0010\u0005J\u0013\u0010u\u001a\u00020\u0011H\u0087\bø\u0001\u0000¢\u0006\u0004\bv\u0010hJ\u0013\u0010w\u001a\u00020\u0014H\u0087\bø\u0001\u0000¢\u0006\u0004\bx\u0010lJ\u0018\u0010y\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bz\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0004\n\u0002\b!¨\u0006|"}, d2 = {"Lkotlin/UInt;", "", "data", "", "constructor-impl", "(I)I", "getData$annotations", "()V", "and", "other", "and-WZ4Q5Ns", "(II)I", "compareTo", "Lkotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "compareTo-WZ4Q5Ns", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "dec", "dec-pVg5ArA", "div", "div-7apg3OU", "div-WZ4Q5Ns", "div-VKZWuLQ", "(IJ)J", "div-xj2QHRw", "equals", "", "", "equals-impl", "(ILjava/lang/Object;)Z", "floorDiv", "floorDiv-7apg3OU", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "floorDiv-xj2QHRw", "hashCode", "hashCode-impl", "inc", "inc-pVg5ArA", "inv", "inv-pVg5ArA", "minus", "minus-7apg3OU", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "minus-xj2QHRw", "mod", "mod-7apg3OU", "(IB)B", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "mod-xj2QHRw", "(IS)S", SRStrategy.KEY_ORIGIN_RESOLUTION, "or-WZ4Q5Ns", "plus", "plus-7apg3OU", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "plus-xj2QHRw", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-WZ4Q5Ns", "rem", "rem-7apg3OU", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "rem-xj2QHRw", "shl", "bitCount", "shl-pVg5ArA", "shr", "shr-pVg5ArA", "times", "times-7apg3OU", "times-WZ4Q5Ns", "times-VKZWuLQ", "times-xj2QHRw", "toByte", "", "toByte-impl", "(I)B", "toDouble", "", "toDouble-impl", "(I)D", "toFloat", "", "toFloat-impl", "(I)F", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(I)J", "toShort", "", "toShort-impl", "(I)S", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "toUByte", "toUByte-w2LRezQ", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toUShort", "toUShort-Mh2AYeg", "xor", "xor-WZ4Q5Ns", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
@JvmInline
public final class UInt implements Comparable<UInt> {
    public static final Companion Companion = null;
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;
    private final int data;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u0004X\u0086Tø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u0013\u0010\u0006\u001a\u00020\u0004X\u0086Tø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b!¨\u0006\n"}, d2 = {"Lkotlin/UInt$Companion;", "", "()V", "MAX_VALUE", "Lkotlin/UInt;", "I", "MIN_VALUE", "SIZE_BITS", "", "SIZE_BYTES", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
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
    public static final /* synthetic */ UInt m9538boximpl(int r100) {
        return new UInt(r100);
    }

    /* JADX INFO: renamed from: constructor-impl, reason: not valid java name */
    public static int m9544constructorimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: equals-impl, reason: not valid java name */
    public static boolean m9550equalsimpl(int r100, Object r101) {
        if ((r101 instanceof UInt) == true) goto L6;
        return false;
    L6:
        if (r100 == ((UInt) r101).m9596unboximpl()) goto L8;
        return false;
    L8:
        return true;
    }

    /* JADX INFO: renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m9551equalsimpl0(int r100, int r101) {
        if (r100 != r101) goto L4;
        return true;
    L4:
        return false;
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* JADX INFO: renamed from: hashCode-impl, reason: not valid java name */
    public static int m9556hashCodeimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: toByte-impl, reason: not valid java name */
    private static final byte m9584toByteimpl(int r100) {
        return (byte) r100;
    }

    /* JADX INFO: renamed from: toInt-impl, reason: not valid java name */
    private static final int m9587toIntimpl(int r100) {
        return r100;
    }

    /* JADX INFO: renamed from: toLong-impl, reason: not valid java name */
    private static final long m9588toLongimpl(int r100) {
        return ((long) r100) & BodyPartID.bodyIdMax;
    }

    /* JADX INFO: renamed from: toShort-impl, reason: not valid java name */
    private static final short m9589toShortimpl(int r100) {
        return (short) r100;
    }

    /* JADX INFO: renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m9592toUIntpVg5ArA(int r100) {
        return r100;
    }

    public boolean equals(Object r100) {
        return m9550equalsimpl(this.data, r100);
    }

    public int hashCode() {
        return m9556hashCodeimpl(this.data);
    }

    /* JADX INFO: renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m9596unboximpl() {
        return this.data;
    }

    public String toString() {
        return m9590toStringimpl(this.data);
    }

    private /* synthetic */ UInt(int r100) {
        this.data = r100;
    }

    /* JADX INFO: renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private int m9541compareToWZ4Q5Ns(int r100) {
        return UnsignedKt.uintCompare(m9596unboximpl(), r100);
    }

    /* JADX INFO: renamed from: dec-pVg5ArA, reason: not valid java name */
    private static final int m9545decpVg5ArA(int r100) {
        return m9544constructorimpl(r100 - 1);
    }

    /* JADX INFO: renamed from: inc-pVg5ArA, reason: not valid java name */
    private static final int m9557incpVg5ArA(int r100) {
        return m9544constructorimpl(r100 + 1);
    }

    /* JADX INFO: renamed from: inv-pVg5ArA, reason: not valid java name */
    private static final int m9558invpVg5ArA(int r100) {
        return m9544constructorimpl(~r100);
    }

    /* JADX INFO: renamed from: toDouble-impl, reason: not valid java name */
    private static final double m9585toDoubleimpl(int r100) {
        return UnsignedKt.uintToDouble(r100);
    }

    /* JADX INFO: renamed from: toFloat-impl, reason: not valid java name */
    private static final float m9586toFloatimpl(int r100) {
        return (float) UnsignedKt.uintToDouble(r100);
    }

    /* JADX INFO: renamed from: toString-impl, reason: not valid java name */
    public static String m9590toStringimpl(int r100) {
        return String.valueOf(((long) r100) & BodyPartID.bodyIdMax);
    }

    /* JADX INFO: renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m9591toUBytew2LRezQ(int r100) {
        return UByte.m9467constructorimpl((byte) r100);
    }

    /* JADX INFO: renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m9593toULongsVKNKU(int r100) {
        return ULong.m9623constructorimpl(((long) r100) & BodyPartID.bodyIdMax);
    }

    /* JADX INFO: renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m9594toUShortMh2AYeg(int r100) {
        return UShort.m9730constructorimpl((short) r100);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UInt r100) {
        int r101 = r100.m9596unboximpl();
        return UnsignedKt.uintCompare(m9596unboximpl(), r101);
    }

    /* JADX INFO: renamed from: and-WZ4Q5Ns, reason: not valid java name */
    private static final int m9537andWZ4Q5Ns(int r100, int r101) {
        return m9544constructorimpl(r100 & r101);
    }

    /* JADX INFO: renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m9539compareTo7apg3OU(int r100, byte r101) {
        return Integer.compare(r100 ^ Integer.MIN_VALUE, m9544constructorimpl(r101 & UByte.MAX_VALUE) ^ Integer.MIN_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m9540compareToVKZWuLQ(int r100, long r101) {
        return Long.compare(ULong.m9623constructorimpl(((long) r100) & BodyPartID.bodyIdMax) ^ Long.MIN_VALUE, r101 ^ Long.MIN_VALUE);
    }

    /* JADX INFO: renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static int m9542compareToWZ4Q5Ns(int r100, int r101) {
        return UnsignedKt.uintCompare(r100, r101);
    }

    /* JADX INFO: renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m9543compareToxj2QHRw(int r100, short r101) {
        return Integer.compare(r100 ^ Integer.MIN_VALUE, m9544constructorimpl(r101 & 65535) ^ Integer.MIN_VALUE);
    }

    /* JADX INFO: renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m9546div7apg3OU(int r100, byte r101) {
        int r102 = m9544constructorimpl(r101 & UByte.MAX_VALUE);
        return (int) ((((long) r100) & BodyPartID.bodyIdMax) / (((long) r102) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m9547divVKZWuLQ(int r100, long r101) {
        long r102 = ULong.m9623constructorimpl(((long) r100) & BodyPartID.bodyIdMax);
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
    private static final int m9548divWZ4Q5Ns(int r100, int r101) {
        return UnsignedKt.m9800uintDivideJ1ME1BU(r100, r101);
    }

    /* JADX INFO: renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m9549divxj2QHRw(int r100, short r101) {
        int r102 = m9544constructorimpl(r101 & 65535);
        return (int) ((((long) r100) & BodyPartID.bodyIdMax) / (((long) r102) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m9552floorDiv7apg3OU(int r100, byte r101) {
        int r102 = m9544constructorimpl(r101 & UByte.MAX_VALUE);
        return (int) ((((long) r100) & BodyPartID.bodyIdMax) / (((long) r102) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m9553floorDivVKZWuLQ(int r100, long r101) {
        long r102 = ULong.m9623constructorimpl(((long) r100) & BodyPartID.bodyIdMax);
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
    private static final int m9554floorDivWZ4Q5Ns(int r100, int r101) {
        return (int) ((((long) r100) & BodyPartID.bodyIdMax) / (((long) r101) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m9555floorDivxj2QHRw(int r100, short r101) {
        int r102 = m9544constructorimpl(r101 & 65535);
        return (int) ((((long) r100) & BodyPartID.bodyIdMax) / (((long) r102) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m9559minus7apg3OU(int r100, byte r101) {
        return m9544constructorimpl(r100 - m9544constructorimpl(r101 & UByte.MAX_VALUE));
    }

    /* JADX INFO: renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m9560minusVKZWuLQ(int r100, long r101) {
        return ULong.m9623constructorimpl(ULong.m9623constructorimpl(((long) r100) & BodyPartID.bodyIdMax) - r101);
    }

    /* JADX INFO: renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m9561minusWZ4Q5Ns(int r100, int r101) {
        return m9544constructorimpl(r100 - r101);
    }

    /* JADX INFO: renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m9562minusxj2QHRw(int r100, short r101) {
        return m9544constructorimpl(r100 - m9544constructorimpl(r101 & 65535));
    }

    /* JADX INFO: renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m9563mod7apg3OU(int r100, byte r101) {
        return UByte.m9467constructorimpl((byte) ((((long) r100) & BodyPartID.bodyIdMax) % (((long) m9544constructorimpl(r101 & UByte.MAX_VALUE)) & BodyPartID.bodyIdMax)));
    }

    /* JADX INFO: renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m9564modVKZWuLQ(int r100, long r101) {
        long r102 = ULong.m9623constructorimpl(((long) r100) & BodyPartID.bodyIdMax);
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
    private static final int m9565modWZ4Q5Ns(int r100, int r101) {
        return (int) ((((long) r100) & BodyPartID.bodyIdMax) % (((long) r101) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m9566modxj2QHRw(int r100, short r101) {
        return UShort.m9730constructorimpl((short) ((((long) r100) & BodyPartID.bodyIdMax) % (((long) m9544constructorimpl(r101 & 65535)) & BodyPartID.bodyIdMax)));
    }

    /* JADX INFO: renamed from: or-WZ4Q5Ns, reason: not valid java name */
    private static final int m9567orWZ4Q5Ns(int r100, int r101) {
        return m9544constructorimpl(r100 | r101);
    }

    /* JADX INFO: renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m9568plus7apg3OU(int r100, byte r101) {
        return m9544constructorimpl(r100 + m9544constructorimpl(r101 & UByte.MAX_VALUE));
    }

    /* JADX INFO: renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m9569plusVKZWuLQ(int r100, long r101) {
        return ULong.m9623constructorimpl(ULong.m9623constructorimpl(((long) r100) & BodyPartID.bodyIdMax) + r101);
    }

    /* JADX INFO: renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m9570plusWZ4Q5Ns(int r100, int r101) {
        return m9544constructorimpl(r100 + r101);
    }

    /* JADX INFO: renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m9571plusxj2QHRw(int r100, short r101) {
        return m9544constructorimpl(r100 + m9544constructorimpl(r101 & 65535));
    }

    /* JADX INFO: renamed from: rangeTo-WZ4Q5Ns, reason: not valid java name */
    private static final UIntRange m9572rangeToWZ4Q5Ns(int r100, int r101) {
        return new UIntRange(r100, r101, null);
    }

    /* JADX INFO: renamed from: rangeUntil-WZ4Q5Ns, reason: not valid java name */
    private static final UIntRange m9573rangeUntilWZ4Q5Ns(int r100, int r101) {
        return URangesKt.m10721untilJ1ME1BU(r100, r101);
    }

    /* JADX INFO: renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m9574rem7apg3OU(int r100, byte r101) {
        int r102 = m9544constructorimpl(r101 & UByte.MAX_VALUE);
        return (int) ((((long) r100) & BodyPartID.bodyIdMax) % (((long) r102) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m9575remVKZWuLQ(int r100, long r101) {
        long r102 = ULong.m9623constructorimpl(((long) r100) & BodyPartID.bodyIdMax);
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
    private static final int m9576remWZ4Q5Ns(int r100, int r101) {
        return UnsignedKt.m9801uintRemainderJ1ME1BU(r100, r101);
    }

    /* JADX INFO: renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m9577remxj2QHRw(int r100, short r101) {
        int r102 = m9544constructorimpl(r101 & 65535);
        return (int) ((((long) r100) & BodyPartID.bodyIdMax) % (((long) r102) & BodyPartID.bodyIdMax));
    }

    /* JADX INFO: renamed from: shl-pVg5ArA, reason: not valid java name */
    private static final int m9578shlpVg5ArA(int r100, int r101) {
        return m9544constructorimpl(r100 << r101);
    }

    /* JADX INFO: renamed from: shr-pVg5ArA, reason: not valid java name */
    private static final int m9579shrpVg5ArA(int r100, int r101) {
        return m9544constructorimpl(r100 >>> r101);
    }

    /* JADX INFO: renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m9580times7apg3OU(int r100, byte r101) {
        return m9544constructorimpl(r100 * m9544constructorimpl(r101 & UByte.MAX_VALUE));
    }

    /* JADX INFO: renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m9581timesVKZWuLQ(int r100, long r101) {
        return ULong.m9623constructorimpl(ULong.m9623constructorimpl(((long) r100) & BodyPartID.bodyIdMax) * r101);
    }

    /* JADX INFO: renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m9582timesWZ4Q5Ns(int r100, int r101) {
        return m9544constructorimpl(r100 * r101);
    }

    /* JADX INFO: renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m9583timesxj2QHRw(int r100, short r101) {
        return m9544constructorimpl(r100 * m9544constructorimpl(r101 & 65535));
    }

    /* JADX INFO: renamed from: xor-WZ4Q5Ns, reason: not valid java name */
    private static final int m9595xorWZ4Q5Ns(int r100, int r101) {
        return m9544constructorimpl(r100 ^ r101);
    }
}
