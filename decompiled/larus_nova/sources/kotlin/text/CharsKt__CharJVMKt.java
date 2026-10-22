package kotlin.text;

import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0001\u001a\u0018\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0000\u001a\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0010\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0011\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0012\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0013\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0015\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0016\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0018\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u0019\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u001a\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\r\u0010\u001b\u001a\u00020\u000f*\u00020\u0002H\u0087\b\u001a\n\u0010\u001c\u001a\u00020\u000f*\u00020\u0002\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u0002H\u0087\b\u001a\u0014\u0010\u001d\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\r\u0010!\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0014\u0010\"\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\r\u0010#\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010$\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010%\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010&\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u0010'\u001a\u00020\u001e*\u00020\u0002H\u0087\b\u001a\u0014\u0010'\u001a\u00020\u001e*\u00020\u00022\u0006\u0010\u001f\u001a\u00020 H\u0007\u001a\r\u0010(\u001a\u00020\u0002*\u00020\u0002H\u0087\b\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006)"}, d2 = {"category", "Lkotlin/text/CharCategory;", "", "getCategory", "(C)Lkotlin/text/CharCategory;", "directionality", "Lkotlin/text/CharDirectionality;", "getDirectionality", "(C)Lkotlin/text/CharDirectionality;", "checkRadix", "", "radix", "digitOf", "char", "isDefined", "", "isDigit", "isHighSurrogate", "isISOControl", "isIdentifierIgnorable", "isJavaIdentifierPart", "isJavaIdentifierStart", "isLetter", "isLetterOrDigit", "isLowSurrogate", "isLowerCase", "isTitleCase", "isUpperCase", "isWhitespace", "lowercase", "", "locale", "Ljava/util/Locale;", "lowercaseChar", "titlecase", "titlecaseChar", "toLowerCase", "toTitleCase", "toUpperCase", "uppercase", "uppercaseChar", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/CharsKt")
class CharsKt__CharJVMKt {
    public CharsKt__CharJVMKt() {
    }

    public static int checkRadix(int r100) {
        boolean r101 = false;
        if (2 <= r100) goto L5;
    L7:
        if (r101 == false) goto L10;
        return r100;
    L10:
        throw new IllegalArgumentException("radix " + r100 + " was not in valid range " + new IntRange(2, 36));
    L5:
        if (r100 >= 37) goto L7;
        r101 = true;
        goto L7
    }

    public static CharCategory getCategory(char r100) {
        return CharCategory.Companion.valueOf(Character.getType(r100));
    }

    public static final CharDirectionality getDirectionality(char r100) {
        return CharDirectionality.Companion.valueOf(Character.getDirectionality(r100));
    }

    private static final boolean isDefined(char r100) {
        return Character.isDefined(r100);
    }

    private static final boolean isDigit(char r100) {
        return Character.isDigit(r100);
    }

    private static final boolean isHighSurrogate(char r100) {
        return Character.isHighSurrogate(r100);
    }

    private static final boolean isISOControl(char r100) {
        return Character.isISOControl(r100);
    }

    private static final boolean isIdentifierIgnorable(char r100) {
        return Character.isIdentifierIgnorable(r100);
    }

    private static final boolean isJavaIdentifierPart(char r100) {
        return Character.isJavaIdentifierPart(r100);
    }

    private static final boolean isJavaIdentifierStart(char r100) {
        return Character.isJavaIdentifierStart(r100);
    }

    private static final boolean isLetter(char r100) {
        return Character.isLetter(r100);
    }

    private static final boolean isLetterOrDigit(char r100) {
        return Character.isLetterOrDigit(r100);
    }

    private static final boolean isLowSurrogate(char r100) {
        return Character.isLowSurrogate(r100);
    }

    private static final boolean isLowerCase(char r100) {
        return Character.isLowerCase(r100);
    }

    private static final boolean isTitleCase(char r100) {
        return Character.isTitleCase(r100);
    }

    private static final boolean isUpperCase(char r100) {
        return Character.isUpperCase(r100);
    }

    public static boolean isWhitespace(char r100) {
        if (Character.isWhitespace(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (Character.isSpaceChar(r100) == true) goto L8;
        return false;
    }

    private static final String lowercase(char r100) {
        String r101 = String.valueOf(r100);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.lang.String");
        return r101.toLowerCase(Locale.ROOT);
    }

    private static final char lowercaseChar(char r100) {
        return Character.toLowerCase(r100);
    }

    private static final char titlecaseChar(char r100) {
        return Character.toTitleCase(r100);
    }

    @Deprecated(message = "Use lowercaseChar() instead.", replaceWith = @ReplaceWith(expression = "lowercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final char toLowerCase(char r100) {
        return Character.toLowerCase(r100);
    }

    @Deprecated(message = "Use titlecaseChar() instead.", replaceWith = @ReplaceWith(expression = "titlecaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final char toTitleCase(char r100) {
        return Character.toTitleCase(r100);
    }

    @Deprecated(message = "Use uppercaseChar() instead.", replaceWith = @ReplaceWith(expression = "uppercaseChar()", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final char toUpperCase(char r100) {
        return Character.toUpperCase(r100);
    }

    private static final String uppercase(char r100) {
        String r101 = String.valueOf(r100);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.lang.String");
        return r101.toUpperCase(Locale.ROOT);
    }

    private static final char uppercaseChar(char r100) {
        return Character.toUpperCase(r100);
    }

    public static final int digitOf(char r100, int r101) {
        return Character.digit(r100, r101);
    }

    public static String lowercase(char r100, Locale r101) {
        Intrinsics.checkNotNullParameter(r101, "locale");
        String r102 = String.valueOf(r100);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type java.lang.String");
        return r102.toLowerCase(r101);
    }

    public static String titlecase(char r100, Locale r101) {
        Intrinsics.checkNotNullParameter(r101, "locale");
        String r102 = uppercase(r100, r101);
        if (r102.length() > 1) goto L5;
        String r103 = String.valueOf(r100);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type java.lang.String");
        if (Intrinsics.areEqual(r102, r103.toUpperCase(Locale.ROOT)) == true) goto L13;
        return r102;
    L13:
        return String.valueOf(Character.toTitleCase(r100));
    L5:
        if (r100 == 329) goto L14;
        char r104 = r102.charAt(0);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type java.lang.String");
        String r105 = r102.substring(1);
        Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type java.lang.String");
        return r104 + r105.toLowerCase(Locale.ROOT);
    L14:
        return r102;
    }

    public static final String uppercase(char r100, Locale r101) {
        Intrinsics.checkNotNullParameter(r101, "locale");
        String r102 = String.valueOf(r100);
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type java.lang.String");
        return r102.toUpperCase(r101);
    }
}
