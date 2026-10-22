package kotlin.text;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.UnsignedKt;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0011\u0010\u0010\u001a\u00020\u0002*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0011\u001a\u0019\u0010\u0010\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0012\u001a\u000e\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007\u001a\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0011\u0010\u0014\u001a\u00020\u0007*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0015\u001a\u0019\u0010\u0014\u001a\u00020\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0016\u001a\u000e\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u0001H\u0007\u001a\u0016\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0011\u0010\u0018\u001a\u00020\n*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0019\u001a\u0019\u0010\u0018\u001a\u00020\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u001a\u001a\u000e\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u0001H\u0007\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\n*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0011\u0010\u001c\u001a\u00020\r*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u001d\u001a\u0019\u0010\u001c\u001a\u00020\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\u001e\u001a\u000e\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u0001H\u0007\u001a\u0016\u0010\u001f\u001a\u0004\u0018\u00010\r*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006 "}, d2 = {"toString", "", "Lkotlin/UByte;", "radix", "", "toString-LxnNnR4", "(BI)Ljava/lang/String;", "Lkotlin/UInt;", "toString-V7xB4Y4", "(II)Ljava/lang/String;", "Lkotlin/ULong;", "toString-JSWoG40", "(JI)Ljava/lang/String;", "Lkotlin/UShort;", "toString-olVBNx4", "(SI)Ljava/lang/String;", "toUByte", "(Ljava/lang/String;)B", "(Ljava/lang/String;I)B", "toUByteOrNull", "toUInt", "(Ljava/lang/String;)I", "(Ljava/lang/String;I)I", "toUIntOrNull", "toULong", "(Ljava/lang/String;)J", "(Ljava/lang/String;I)J", "toULongOrNull", "toUShort", "(Ljava/lang/String;)S", "(Ljava/lang/String;I)S", "toUShortOrNull", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class UStringsKt {
    public static final byte toUByte(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        UByte r101 = toUByteOrNull(r100);
        if (r101 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r100);
        throw new KotlinNothingValueException();
    L5:
        return r101.m9517unboximpl();
    }

    public static final UByte toUByteOrNull(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return toUByteOrNull(r100, 10);
    }

    public static final int toUInt(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        UInt r101 = toUIntOrNull(r100);
        if (r101 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r100);
        throw new KotlinNothingValueException();
    L5:
        return r101.m9596unboximpl();
    }

    public static final UInt toUIntOrNull(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return toUIntOrNull(r100, 10);
    }

    public static final long toULong(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ULong r101 = toULongOrNull(r100);
        if (r101 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r100);
        throw new KotlinNothingValueException();
    L5:
        return r101.m9675unboximpl();
    }

    public static final ULong toULongOrNull(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return toULongOrNull(r100, 10);
    }

    public static final short toUShort(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        UShort r101 = toUShortOrNull(r100);
        if (r101 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r100);
        throw new KotlinNothingValueException();
    L5:
        return r101.m9780unboximpl();
    }

    public static final UShort toUShortOrNull(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return toUShortOrNull(r100, 10);
    }

    /* JADX INFO: renamed from: toString-JSWoG40, reason: not valid java name */
    public static final String m10779toStringJSWoG40(long r100, int r101) {
        return UnsignedKt.ulongToString(r100, CharsKt.checkRadix(r101));
    }

    /* JADX INFO: renamed from: toString-LxnNnR4, reason: not valid java name */
    public static final String m10780toStringLxnNnR4(byte r100, int r101) {
        return Integer.toString(r100 & UByte.MAX_VALUE, CharsKt.checkRadix(r101));
    }

    /* JADX INFO: renamed from: toString-V7xB4Y4, reason: not valid java name */
    public static final String m10781toStringV7xB4Y4(int r100, int r101) {
        int r102 = CharsKt.checkRadix(r101);
        return UnsignedKt.ulongToString(((long) r100) & BodyPartID.bodyIdMax, r102);
    }

    /* JADX INFO: renamed from: toString-olVBNx4, reason: not valid java name */
    public static final String m10782toStringolVBNx4(short r100, int r101) {
        return Integer.toString(r100 & 65535, CharsKt.checkRadix(r101));
    }

    public static final byte toUByte(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        UByte r102 = toUByteOrNull(r100, r101);
        if (r102 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r100);
        throw new KotlinNothingValueException();
    L5:
        return r102.m9517unboximpl();
    }

    public static final UByte toUByteOrNull(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        UInt r102 = toUIntOrNull(r100, r101);
        if (r102 == null) goto L9;
        int r103 = r102.m9596unboximpl();
        if (Integer.compare(r103 ^ Integer.MIN_VALUE, UInt.m9544constructorimpl(255) ^ Integer.MIN_VALUE) <= 0) goto L8;
        return null;
    L8:
        return UByte.m9461boximpl(UByte.m9467constructorimpl((byte) r103));
    L9:
        return null;
    }

    public static final int toUInt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        UInt r102 = toUIntOrNull(r100, r101);
        if (r102 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r100);
        throw new KotlinNothingValueException();
    L5:
        return r102.m9596unboximpl();
    }

    public static final UInt toUIntOrNull(String r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        CharsKt.checkRadix(r111);
        int r100 = r110.length();
        if (r100 != 0) goto L5;
        return null;
    L5:
        int r101 = 0;
        char r102 = r110.charAt(0);
        if (Intrinsics.compare(r102, 48) >= 0) goto L12;
        int r103 = 1;
        if (r100 != 1) goto L10;
    L11:
        return null;
    L10:
        if (r102 != '+') goto L11;
    L13:
        int r104 = UInt.m9544constructorimpl(r111);
        int r105 = 119304647;
        int r106 = 119304647;
    L14:
        if (r103 >= r100) goto L29;
        int r107 = CharsKt__CharJVMKt.digitOf(r110.charAt(r103), r111);
        if (r107 < 0) goto L17;
        int r112 = r101 ^ Integer.MIN_VALUE;
        if (Integer.compare(r112, r106 ^ Integer.MIN_VALUE) <= 0) goto L24;
        if (r106 != r105) goto L23;
        r106 = (int) ((((long) (-1)) & BodyPartID.bodyIdMax) / (((long) r104) & BodyPartID.bodyIdMax));
        if (Integer.compare(r112, r106 ^ Integer.MIN_VALUE) <= 0) goto L24;
    L23:
        return null;
    L24:
        int r108 = UInt.m9544constructorimpl(r101 * r104);
        int r109 = UInt.m9544constructorimpl(UInt.m9544constructorimpl(r107) + r108);
        if (Integer.compare(r109 ^ Integer.MIN_VALUE, r108 ^ Integer.MIN_VALUE) < 0) goto L26;
        r103 = r103 + 1;
        r101 = r109;
        r105 = 119304647;
        goto L14
    L26:
        return null;
    L17:
        return null;
    L29:
        return UInt.m9538boximpl(r101);
    L12:
        r103 = 0;
        goto L13
    }

    public static final long toULong(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        ULong r102 = toULongOrNull(r100, r101);
        if (r102 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r100);
        throw new KotlinNothingValueException();
    L5:
        return r102.m9675unboximpl();
    }

    public static final ULong toULongOrNull(String r210, int r211) {
        Intrinsics.checkNotNullParameter(r210, "<this>");
        CharsKt.checkRadix(r211);
        int r100 = r210.length();
        if (r100 != 0) goto L5;
        return null;
    L5:
        char r101 = r210.charAt(0);
        if (Intrinsics.compare(r101, 48) >= 0) goto L13;
        if (r100 != 1) goto L9;
    L12:
        return null;
    L9:
        if (r101 != '+') goto L12;
        int r102 = 1;
    L14:
        long r103 = ULong.m9623constructorimpl(r211);
        long r110 = 0;
        long r111 = 0;
        long r112 = 512409557603043100L;
    L15:
        if (r102 >= r100) goto L43;
        int r104 = CharsKt__CharJVMKt.digitOf(r210.charAt(r102), r211);
        if (r104 < 0) goto L18;
        int r212 = r102;
        long r105 = r111 ^ Long.MIN_VALUE;
        long r213 = r103;
        if (Long.compare(r105, r112 ^ Long.MIN_VALUE) > 0) goto L22;
    L38:
        long r106 = ULong.m9623constructorimpl(r111 * r213);
        r111 = ULong.m9623constructorimpl(ULong.m9623constructorimpl(((long) UInt.m9544constructorimpl(r104)) & BodyPartID.bodyIdMax) + r106);
        if (Long.compare(r111 ^ Long.MIN_VALUE, r106 ^ Long.MIN_VALUE) < 0) goto L40;
        r102 = r212 + 1;
        r103 = r213;
        r110 = 0;
        goto L15
    L40:
        return null;
    L22:
        if (r112 != 512409557603043100L) goto L37;
        if (r213 < r110) goto L26;
        int r107 = 1;
        long r108 = (Long.MAX_VALUE / r213) << 1;
        if ((((-1) - (r108 * r213)) ^ Long.MIN_VALUE) >= (r213 ^ Long.MIN_VALUE)) goto L34;
        r107 = 0;
    L34:
        long r109 = r108 + ((long) r107);
    L29:
        r112 = r109;
    L36:
        if (Long.compare(r105, r112 ^ Long.MIN_VALUE) <= 0) goto L38;
    L26:
        if (Long.MAX_VALUE >= (r213 ^ Long.MIN_VALUE)) goto L28;
        r112 = r110;
        goto L36
    L28:
        r109 = 1;
    L37:
        return null;
    L18:
        return null;
    L43:
        return ULong.m9617boximpl(r111);
    L13:
        r102 = 0;
        goto L14
    }

    public static final short toUShort(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        UShort r102 = toUShortOrNull(r100, r101);
        if (r102 != null) goto L5;
        StringsKt__StringNumberConversionsKt.numberFormatError(r100);
        throw new KotlinNothingValueException();
    L5:
        return r102.m9780unboximpl();
    }

    public static final UShort toUShortOrNull(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        UInt r102 = toUIntOrNull(r100, r101);
        if (r102 == null) goto L9;
        int r103 = r102.m9596unboximpl();
        if (Integer.compare(r103 ^ Integer.MIN_VALUE, UInt.m9544constructorimpl(65535) ^ Integer.MIN_VALUE) <= 0) goto L8;
        return null;
    L8:
        return UShort.m9724boximpl(UShort.m9730constructorimpl((short) r103));
    L9:
        return null;
    }
}
