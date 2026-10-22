package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\f\u0010\u0004\u001a\u00020\u0002*\u00020\u0001H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0006\u001a\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\b\u001a\u00020\t*\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\b\b\u0002\u0010\u000b\u001a\u00020\t\u001a\n\u0010\f\u001a\u00020\t*\u00020\u0001\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00012\u0006\u0010\n\u001a\u00020\u000eH\u0087\n\u001a\f\u0010\u000f\u001a\u00020\u000e*\u00020\u0001H\u0007¨\u0006\u0010"}, d2 = {"digitToChar", "", "", "radix", "digitToInt", "digitToIntOrNull", "(C)Ljava/lang/Integer;", "(CI)Ljava/lang/Integer;", "equals", "", "other", "ignoreCase", "isSurrogate", "plus", "", "titlecase", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/CharsKt")
class CharsKt__CharKt extends CharsKt__CharJVMKt {
    public CharsKt__CharKt() {
    }

    public static boolean isSurrogate(char r100) {
        if (55296 <= r100) goto L5;
        return false;
    L5:
        if (r100 >= 57344) goto L9;
        return true;
    L9:
        return false;
    }

    public static final char digitToChar(int r100) {
        boolean r101 = false;
        if (r100 >= 0) goto L5;
    L7:
        if (r101 == false) goto L11;
        return (char) (r100 + 48);
    L11:
        throw new IllegalArgumentException("Int " + r100 + " is not a decimal digit");
    L5:
        if (r100 >= 10) goto L7;
        r101 = true;
        goto L7
    }

    public static int digitToInt(char r100) {
        int r101 = CharsKt__CharJVMKt.digitOf(r100, 10);
        if (r101 < 0) goto L6;
        return r101;
    L6:
        throw new IllegalArgumentException("Char " + r100 + " is not a decimal digit");
    }

    public static Integer digitToIntOrNull(char r100) {
        Integer r101 = Integer.valueOf(CharsKt__CharJVMKt.digitOf(r100, 10));
        if (r101.intValue() < 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L10;
        return null;
    L10:
        return r101;
    L5:
        r102 = false;
        goto L6
    }

    public static String titlecase(char r100) {
        return _OneToManyTitlecaseMappingsKt.titlecaseImpl(r100);
    }

    public static final char digitToChar(int r100, int r101) {
        boolean r102 = false;
        if (2 <= r101) goto L5;
    L7:
        if (r102 == false) goto L19;
        if (r100 < 0) goto L17;
        if (r100 >= r101) goto L17;
        if (r100 >= 10) goto L13;
        int r103 = r100 + 48;
    L15:
        return (char) r103;
    L13:
        r103 = ((char) (r100 + 65)) - '\n';
    L17:
        throw new IllegalArgumentException("Digit " + r100 + " does not represent a valid digit in radix " + r101);
    L19:
        throw new IllegalArgumentException("Invalid radix: " + r101 + ". Valid radix values are in range 2..36");
    L5:
        if (r101 >= 37) goto L7;
        r102 = true;
        goto L7
    }

    public static final int digitToInt(char r100, int r101) {
        Integer r102 = digitToIntOrNull(r100, r101);
        if (r102 == null) goto L7;
        return r102.intValue();
    L7:
        throw new IllegalArgumentException("Char " + r100 + " is not a digit in the given radix=" + r101);
    }

    public static final Integer digitToIntOrNull(char r100, int r101) {
        CharsKt.checkRadix(r101);
        Integer r102 = Integer.valueOf(CharsKt__CharJVMKt.digitOf(r100, r101));
        if (r102.intValue() < 0) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == true) goto L10;
        return null;
    L10:
        return r102;
    L5:
        r103 = false;
        goto L6
    }

    private static final String plus(char r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "other");
        return r100 + r101;
    }

    public static boolean equals(char r100, char r101, boolean r102) {
        if (r100 != r101) goto L6;
        return true;
    L6:
        if (r102 == true) goto L8;
        return false;
    L8:
        char r103 = Character.toUpperCase(r100);
        char r104 = Character.toUpperCase(r101);
        if (r103 != r104) goto L11;
        return true;
    L11:
        if (Character.toLowerCase(r103) == Character.toLowerCase(r104)) goto L16;
        return false;
    L16:
        return true;
    }

    public static /* synthetic */ boolean equals$default(char r100, char r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return CharsKt.equals(r100, r101, r102);
    }
}
