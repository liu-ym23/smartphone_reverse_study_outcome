package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0004\u001a\u0004\u0018\u00010\u0005*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a\u0013\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000b\u001a\u001b\u0010\n\u001a\u0004\u0018\u00010\b*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\f\u001a\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u000f\u001a\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0010\u001a\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"numberFormatError", "", "input", "", "toByteOrNull", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringNumberConversionsKt extends StringsKt__StringNumberConversionsJVMKt {
    public StringsKt__StringNumberConversionsKt() {
    }

    public static final Void numberFormatError(String r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        throw new NumberFormatException("Invalid number format: '" + r100 + '\'');
    }

    public static Byte toByteOrNull(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return toByteOrNull(r100, 10);
    }

    public static Integer toIntOrNull(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return StringsKt.toIntOrNull(r100, 10);
    }

    public static Long toLongOrNull(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return StringsKt.toLongOrNull(r100, 10);
    }

    public static Short toShortOrNull(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return toShortOrNull(r100, 10);
    }

    public static final Byte toByteOrNull(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Integer r102 = StringsKt.toIntOrNull(r100, r101);
        if (r102 == null) goto L11;
        int r103 = r102.intValue();
        if (r103 < (-128)) goto L11;
        if (r103 > 127) goto L11;
        return Byte.valueOf((byte) r103);
    L11:
        return null;
    }

    public static Integer toIntOrNull(String r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        CharsKt.checkRadix(r111);
        int r100 = r110.length();
        if (r100 != 0) goto L5;
        return null;
    L5:
        int r101 = 0;
        char r102 = r110.charAt(0);
        int r103 = -2147483647;
        if (Intrinsics.compare(r102, 48) >= 0) goto L17;
        int r104 = 1;
        if (r100 != 1) goto L11;
        return null;
    L11:
        if (r102 != '-') goto L14;
        r103 = Integer.MIN_VALUE;
        boolean r105 = true;
    L18:
        int r106 = -59652323;
    L19:
        if (r104 >= r100) goto L32;
        int r107 = CharsKt__CharJVMKt.digitOf(r110.charAt(r104), r111);
        if (r107 < 0) goto L22;
        if (r101 >= r106) goto L28;
        if (r106 != (-59652323)) goto L27;
        r106 = r103 / r111;
        if (r101 >= r106) goto L28;
    L27:
        return null;
    L28:
        int r108 = r101 * r111;
        if (r108 < (r103 + r107)) goto L30;
        r101 = r108 - r107;
        r104 = r104 + 1;
        goto L19
    L30:
        return null;
    L22:
        return null;
    L32:
        if (r105 == false) goto L35;
        return Integer.valueOf(r101);
    L35:
        return Integer.valueOf(-r101);
    L14:
        if (r102 != '+') goto L16;
        r105 = false;
        goto L18
    L16:
        return null;
    L17:
        r105 = false;
        r104 = 0;
        goto L18
    }

    public static Long toLongOrNull(String r110, int r111) {
        Intrinsics.checkNotNullParameter(r110, "<this>");
        CharsKt.checkRadix(r111);
        int r100 = r110.length();
        if (r100 != 0) goto L5;
        return null;
    L5:
        int r101 = 0;
        char r102 = r110.charAt(0);
        long r103 = -9223372036854775807L;
        if (Intrinsics.compare(r102, 48) >= 0) goto L17;
        boolean r104 = true;
        if (r100 != 1) goto L11;
        return null;
    L11:
        if (r102 != '-') goto L14;
        r103 = Long.MIN_VALUE;
        r101 = 1;
    L18:
        long r105 = -256204778801521550L;
        long r112 = 0;
        long r113 = -256204778801521550L;
    L19:
        if (r101 >= r100) goto L34;
        int r106 = CharsKt__CharJVMKt.digitOf(r110.charAt(r101), r111);
        if (r106 < 0) goto L22;
        if (r112 < r113) goto L26;
    L30:
        long r114 = r112 * ((long) r111);
        long r107 = r106;
        if (r114 < (r103 + r107)) goto L32;
        r112 = r114 - r107;
        r101 = r101 + 1;
        r105 = -256204778801521550L;
        goto L19
    L32:
        return null;
    L26:
        if (r113 != r105) goto L29;
        r113 = r103 / ((long) r111);
        if (r112 >= r113) goto L30;
    L29:
        return null;
    L22:
        return null;
    L34:
        if (r104 == false) goto L37;
        return Long.valueOf(r112);
    L37:
        return Long.valueOf(-r112);
    L14:
        if (r102 != '+') goto L16;
        r101 = 1;
        goto L17
    L16:
        return null;
    L17:
        r104 = false;
        goto L18
    }

    public static final Short toShortOrNull(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Integer r102 = StringsKt.toIntOrNull(r100, r101);
        if (r102 == null) goto L11;
        int r103 = r102.intValue();
        if (r103 < (-32768)) goto L11;
        if (r103 > 32767) goto L11;
        return Short.valueOf((short) r103);
    L11:
        return null;
    }
}
