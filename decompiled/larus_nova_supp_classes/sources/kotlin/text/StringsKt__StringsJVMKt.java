package kotlin.text;

import android.util.EventsUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\f\n\u0002\b\u0011\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0087\b\u001a\u0019\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\b\u001a)\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0087\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\b\u001a\f\u0010\u0017\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0014\u0010\u0017\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\u0015\u0010\u001a\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\u0087\b\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\u0087\b\u001a\u001d\u0010\u001d\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0087\b\u001a\u001c\u0010 \u001a\u00020\u0011*\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a\f\u0010$\u001a\u00020\u0002*\u00020\u0014H\u0007\u001a \u0010$\u001a\u00020\u0002*\u00020\u00142\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\u0019\u0010&\u001a\u00020#*\u0004\u0018\u00010'2\b\u0010!\u001a\u0004\u0018\u00010'H\u0087\u0004\u001a \u0010&\u001a\u00020#*\u0004\u0018\u00010'2\b\u0010!\u001a\u0004\u0018\u00010'2\u0006\u0010\"\u001a\u00020#H\u0007\u001a\u0015\u0010&\u001a\u00020#*\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0087\b\u001a\u0015\u0010&\u001a\u00020#*\u00020\u00022\u0006\u0010(\u001a\u00020'H\u0087\b\u001a\f\u0010)\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0014\u0010)\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\f\u0010*\u001a\u00020\u0002*\u00020\rH\u0007\u001a*\u0010*\u001a\u00020\u0002*\u00020\r2\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020#H\u0007\u001a\f\u0010,\u001a\u00020\r*\u00020\u0002H\u0007\u001a*\u0010,\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020#H\u0007\u001a\u001c\u0010-\u001a\u00020#*\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a \u0010/\u001a\u00020#*\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a4\u00100\u001a\u00020\u0002*\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b¢\u0006\u0002\u00104\u001a*\u00100\u001a\u00020\u0002*\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b¢\u0006\u0002\u00105\u001a<\u00100\u001a\u00020\u0002*\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b¢\u0006\u0002\u00106\u001a2\u00100\u001a\u00020\u0002*\u00020\u00042\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b¢\u0006\u0002\u00107\u001a\r\u00108\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u00109\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u00109\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\b\u001a\u001d\u0010:\u001a\u00020\u0011*\u00020\u00022\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0011H\u0081\b\u001a\u001d\u0010:\u001a\u00020\u0011*\u00020\u00022\u0006\u0010>\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0011H\u0081\b\u001a\u001d\u0010?\u001a\u00020\u0011*\u00020\u00022\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0011H\u0081\b\u001a\u001d\u0010?\u001a\u00020\u0011*\u00020\u00022\u0006\u0010>\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0011H\u0081\b\u001a\u001d\u0010@\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u0011H\u0087\b\u001a4\u0010B\u001a\u00020#*\u00020'2\u0006\u0010C\u001a\u00020\u00112\u0006\u0010!\u001a\u00020'2\u0006\u0010D\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a4\u0010B\u001a\u00020#*\u00020\u00022\u0006\u0010C\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a\u0012\u0010E\u001a\u00020\u0002*\u00020'2\u0006\u0010F\u001a\u00020\u0011\u001a$\u0010G\u001a\u00020\u0002*\u00020\u00022\u0006\u0010H\u001a\u00020<2\u0006\u0010I\u001a\u00020<2\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010G\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010H\u001a\u00020<2\u0006\u0010I\u001a\u00020<2\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a\"\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00020N*\u00020'2\u0006\u0010O\u001a\u00020P2\b\b\u0002\u0010Q\u001a\u00020\u0011\u001a\u001c\u0010R\u001a\u00020#*\u00020\u00022\u0006\u0010S\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010R\u001a\u00020#*\u00020\u00022\u0006\u0010S\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a\u0015\u0010T\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0011H\u0087\b\u001a\u001d\u0010T\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0087\b\u001a\u0017\u0010U\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001a\r\u0010V\u001a\u00020\u0014*\u00020\u0002H\u0087\b\u001a3\u0010V\u001a\u00020\u0014*\u00020\u00022\u0006\u0010W\u001a\u00020\u00142\b\b\u0002\u0010X\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0087\b\u001a \u0010V\u001a\u00020\u0014*\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\r\u0010Y\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u0010Y\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\b\u001a\u0017\u0010Z\u001a\u00020P*\u00020\u00022\b\b\u0002\u0010[\u001a\u00020\u0011H\u0087\b\u001a\r\u0010\\\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\b\u001a\r\u0010]\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u0010]\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\b\"%\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006^"}, d2 = {"CASE_INSENSITIVE_ORDER", "Ljava/util/Comparator;", XmlPullParser.NO_NAMESPACE, "Lkotlin/Comparator;", "Lkotlin/String$Companion;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "String", "stringBuffer", "Ljava/lang/StringBuffer;", "stringBuilder", "Ljava/lang/StringBuilder;", "bytes", XmlPullParser.NO_NAMESPACE, "charset", "Ljava/nio/charset/Charset;", "offset", XmlPullParser.NO_NAMESPACE, "length", "chars", XmlPullParser.NO_NAMESPACE, "codePoints", XmlPullParser.NO_NAMESPACE, "capitalize", "locale", "Ljava/util/Locale;", "codePointAt", "index", "codePointBefore", "codePointCount", "beginIndex", "endIndex", "compareTo", "other", "ignoreCase", XmlPullParser.NO_NAMESPACE, "concatToString", "startIndex", "contentEquals", XmlPullParser.NO_NAMESPACE, "charSequence", "decapitalize", "decodeToString", "throwOnInvalidSequence", "encodeToByteArray", "endsWith", "suffix", "equals", "format", "args", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "intern", "lowercase", "nativeIndexOf", "ch", XmlPullParser.NO_NAMESPACE, "fromIndex", "str", "nativeLastIndexOf", "offsetByCodePoints", "codePointOffset", "regionMatches", "thisOffset", "otherOffset", "repeat", "n", "replace", "oldChar", "newChar", "oldValue", "newValue", "replaceFirst", "split", XmlPullParser.NO_NAMESPACE, "regex", "Ljava/util/regex/Pattern;", "limit", "startsWith", "prefix", "substring", "toByteArray", "toCharArray", "destination", "destinationOffset", "toLowerCase", "toPattern", "flags", "toUpperCase", "uppercase", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_IOPRELOAD_DATA, xs = "kotlin/text/StringsKt")
class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    public StringsKt__StringsJVMKt() {
    }

    private static final String String(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "bytes");
        return new String(r2, Charsets.UTF_8);
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String capitalize(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return capitalize(r1, Locale.getDefault());
    }

    public static String concatToString(char[] r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new String(r1);
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(Locale.getDefault()) }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String decapitalize(String r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r4.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return r4;
    L8:
        if (Character.isLowerCase(r4.charAt(0)) == true) goto L12;
        StringBuilder r1 = new StringBuilder();
        String r2 = r4.substring(0, 1);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type java.lang.String");
        r1.append(r2.toLowerCase());
        r1.append(r4.substring(1));
        return r1.toString();
    L12:
        return r4;
    L5:
        r0 = false;
        goto L6
    }

    public static String decodeToString(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return new String(r2, Charsets.UTF_8);
    }

    public static byte[] encodeToByteArray(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.getBytes(Charsets.UTF_8);
    }

    public static final Comparator<String> getCASE_INSENSITIVE_ORDER(StringCompanionObject r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return String.CASE_INSENSITIVE_ORDER;
    }

    private static final String intern(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.intern();
    }

    private static final String lowercase(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.toLowerCase(Locale.ROOT);
    }

    private static final char[] toCharArray(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.toCharArray();
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String toLowerCase(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.toLowerCase();
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String toUpperCase(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.toUpperCase();
    }

    private static final String uppercase(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.toUpperCase(Locale.ROOT);
    }

    private static final String String(StringBuffer r1) {
        Intrinsics.checkNotNullParameter(r1, "stringBuffer");
        return new String(r1);
    }

    private static final String String(StringBuilder r1) {
        Intrinsics.checkNotNullParameter(r1, "stringBuilder");
        return new String(r1);
    }

    private static final String String(char[] r1) {
        Intrinsics.checkNotNullParameter(r1, "chars");
        return new String(r1);
    }

    private static final String String(byte[] r1, Charset r2) {
        Intrinsics.checkNotNullParameter(r1, "bytes");
        Intrinsics.checkNotNullParameter(r2, "charset");
        return new String(r1, r2);
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String capitalize(String r5, Locale r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "locale");
        if (r5.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L15;
        char r1 = r5.charAt(0);
        if (Character.isLowerCase(r1) == false) goto L16;
        StringBuilder r3 = new StringBuilder();
        char r4 = Character.toTitleCase(r1);
        if (r4 == Character.toUpperCase(r1)) goto L12;
        r3.append(r4);
    L13:
        r3.append(r5.substring(1));
        return r3.toString();
    L12:
        String r2 = r5.substring(0, 1);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type java.lang.String");
        r3.append(r2.toUpperCase(r6));
        goto L13
    L16:
        return r5;
    L15:
        return r5;
    L5:
        r0 = false;
        goto L6
    }

    private static final int codePointAt(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.codePointAt(r2);
    }

    private static final int codePointBefore(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.codePointBefore(r2);
    }

    public static boolean contentEquals(CharSequence r1, CharSequence r2) {
        if ((r1 instanceof String) == false) goto L7;
        if (r2 == null) goto L7;
        return ((String) r1).contentEquals(r2);
    L7:
        return StringsKt__StringsKt.contentEqualsImpl(r1, r2);
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(locale) }", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String decapitalize(String r4, Locale r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Intrinsics.checkNotNullParameter(r5, "locale");
        if (r4.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
        return r4;
    L8:
        if (Character.isLowerCase(r4.charAt(0)) == true) goto L12;
        StringBuilder r1 = new StringBuilder();
        String r2 = r4.substring(0, 1);
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type java.lang.String");
        r1.append(r2.toLowerCase(r5));
        r1.append(r4.substring(1));
        return r1.toString();
    L12:
        return r4;
    L5:
        r0 = false;
        goto L6
    }

    private static final String format(String r1, Object... r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "args");
        return String.format(r1, Arrays.copyOf(r2, r2.length));
    }

    private static final String lowercase(String r1, Locale r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "locale");
        return r1.toLowerCase(r2);
    }

    public static String repeat(CharSequence r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        int r0 = 0;
        int r1 = 1;
        if (r5 < 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L26;
        if (r5 == 0) goto L29;
        if (r5 == 1) goto L24;
        int r3 = r4.length();
        if (r3 == 0) goto L30;
        if (r3 == 1) goto L19;
        StringBuilder r6 = new StringBuilder(r4.length() * r5);
        if (1 > r5) goto L18;
    L15:
        r6.append(r4);
        if (r1 == r5) goto L18;
        r1 = r1 + 1;
    L18:
        String r7 = r6.toString();
        Intrinsics.checkNotNull(r7);
        return r7;
    L19:
        char r8 = r4.charAt(0);
        char[] r9 = new char[r5];
    L20:
        if (r0 >= r5) goto L32;
        r9[r0] = r8;
        r0 = r0 + 1;
        goto L20
    L32:
        return new String(r9);
    L30:
        return XmlPullParser.NO_NAMESPACE;
    L24:
        return r4.toString();
    L29:
        return XmlPullParser.NO_NAMESPACE;
    L26:
        throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + r5 + '.').toString());
    L5:
        r2 = false;
        goto L6
    }

    private static final String substring(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.substring(r2);
    }

    private static final byte[] toByteArray(String r1, Charset r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "charset");
        return r1.getBytes(r2);
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(locale)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String toLowerCase(String r1, Locale r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "locale");
        return r1.toLowerCase(r2);
    }

    private static final Pattern toPattern(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return PatternProtector.compile(r1, r2);
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(locale)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String toUpperCase(String r1, Locale r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "locale");
        return r1.toUpperCase(r2);
    }

    private static final String uppercase(String r1, Locale r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "locale");
        return r1.toUpperCase(r2);
    }

    private static final boolean contentEquals(String r1, CharSequence r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "charSequence");
        return r1.contentEquals(r2);
    }

    private static final boolean contentEquals(String r1, StringBuffer r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "stringBuilder");
        return r1.contentEquals(r2);
    }

    private static final String String(byte[] r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "bytes");
        return new String(r2, r3, r4, Charsets.UTF_8);
    }

    private static final int codePointCount(String r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.codePointCount(r2, r3);
    }

    public static int compareTo(String r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "other");
        if (r3 == false) goto L7;
        return r1.compareToIgnoreCase(r2);
    L7:
        return r1.compareTo(r2);
    }

    public static String concatToString(char[] r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r3, r4, r2.length);
        return new String(r2, r3, r4 - r3);
    }

    public static final boolean contentEquals(CharSequence r0, CharSequence r1, boolean r2) {
        if (r2 == false) goto L5;
        return StringsKt__StringsKt.contentEqualsIgnoreCaseImpl(r0, r1);
    L5:
        return StringsKt.contentEquals(r0, r1);
    }

    public static boolean endsWith(String r7, String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "suffix");
        if (r9 == true) goto L7;
        return r7.endsWith(r8);
    L7:
        return StringsKt.regionMatches(r7, r7.length() - r8.length(), r8, 0, r8.length(), true);
    }

    public static boolean equals(String r0, String r1, boolean r2) {
        if (r0 != null) goto L7;
        if (r1 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        if (r2 == true) goto L10;
        return r0.equals(r1);
    L10:
        return r0.equalsIgnoreCase(r1);
    }

    private static final String format(StringCompanionObject r1, String r2, Object... r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "format");
        Intrinsics.checkNotNullParameter(r3, "args");
        return String.format(r2, Arrays.copyOf(r3, r3.length));
    }

    private static final int nativeIndexOf(String r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "str");
        return r1.indexOf(r2, r3);
    }

    private static final int nativeLastIndexOf(String r1, String r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "str");
        return r1.lastIndexOf(r2, r3);
    }

    private static final int offsetByCodePoints(String r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.offsetByCodePoints(r2, r3);
    }

    public static final List<String> split(CharSequence r1, Pattern r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "regex");
        StringsKt__StringsKt.requireNonNegativeLimit(r3);
        if (r3 != 0) goto L6;
        r3 = -1;
    L6:
        return ArraysKt.asList(r2.split(r1, r3));
    }

    public static boolean startsWith(String r6, String r7, boolean r8) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "prefix");
        if (r8 == true) goto L7;
        return r6.startsWith(r7);
    L7:
        return StringsKt.regionMatches(r6, 0, r7, 0, r7.length(), r8);
    }

    private static final String substring(String r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.substring(r2, r3);
    }

    public static final char[] toCharArray(String r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r3, r4, r2.length());
        char[] r0 = new char[r4 - r3];
        r2.getChars(r3, r4, r0, 0);
        return r0;
    }

    private static final String String(char[] r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "chars");
        return new String(r1, r2, r3);
    }

    private static final String format(String r1, Locale r2, Object... r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "args");
        return String.format(r2, r1, Arrays.copyOf(r3, r3.length));
    }

    private static final int nativeIndexOf(String r1, char r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.indexOf(r2, r3);
    }

    private static final int nativeLastIndexOf(String r1, char r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return r1.lastIndexOf(r2, r3);
    }

    private static final String String(int[] r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "codePoints");
        return new String(r1, r2, r3);
    }

    private static final String String(byte[] r1, int r2, int r3, Charset r4) {
        Intrinsics.checkNotNullParameter(r1, "bytes");
        Intrinsics.checkNotNullParameter(r4, "charset");
        return new String(r1, r2, r3, r4);
    }

    public static String decodeToString(byte[] r2, int r3, int r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r3, r4, r2.length);
        if (r5 == true) goto L7;
        return new String(r2, r3, r4 - r3, Charsets.UTF_8);
    L7:
        return Charsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(r2, r3, r4 - r3)).toString();
    }

    public static final byte[] encodeToByteArray(String r2, int r3, int r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r3, r4, r2.length());
        if (r5 == true) goto L6;
        String r6 = r2.substring(r3, r4);
        Charset r7 = Charsets.UTF_8;
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type java.lang.String");
        return r6.getBytes(r7);
    L6:
        ByteBuffer r8 = Charsets.UTF_8.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap(r2, r3, r4));
        if (r8.hasArray() == true) goto L9;
    L13:
        byte[] r9 = new byte[r8.remaining()];
        r8.get(r9);
        return r9;
    L9:
        if (r8.arrayOffset() != 0) goto L13;
        int r10 = r8.remaining();
        byte[] r11 = r8.array();
        Intrinsics.checkNotNull(r11);
        if (r10 != r11.length) goto L13;
        byte[] r12 = r8.array();
        Intrinsics.checkNotNull(r12);
        return r12;
    }

    private static final String format(StringCompanionObject r1, Locale r2, String r3, Object... r4) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r3, "format");
        Intrinsics.checkNotNullParameter(r4, "args");
        return String.format(r2, r3, Arrays.copyOf(r4, r4.length));
    }

    public static String replace(String r6, String r7, String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "oldValue");
        Intrinsics.checkNotNullParameter(r8, "newValue");
        int r0 = 0;
        int r1 = StringsKt.indexOf(r6, r7, 0, r9);
        if (r1 >= 0) goto L5;
        return r6;
    L5:
        int r2 = r7.length();
        int r3 = RangesKt.coerceAtLeast(r2, 1);
        int r4 = (r6.length() - r2) + r8.length();
        if (r4 < 0) goto L15;
        StringBuilder r5 = new StringBuilder(r4);
    L8:
        r5.append(r6, r0, r1);
        r5.append(r8);
        r0 = r1 + r2;
        if (r1 >= r6.length()) goto L12;
        r1 = StringsKt.indexOf(r6, r7, r1 + r3, r9);
        if (r1 > 0) goto L8;
    L12:
        r5.append(r6, r0, r6.length());
        return r5.toString();
    L15:
        throw new OutOfMemoryError();
    }

    public static String replaceFirst(String r7, String r8, String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r8, "oldValue");
        Intrinsics.checkNotNullParameter(r9, "newValue");
        int r11 = StringsKt.indexOf$default(r7, r8, 0, r10, 2, null);
        if (r11 >= 0) goto L6;
        return r7;
    L6:
        return StringsKt.replaceRange(r7, r11, r8.length() + r11, r9).toString();
    }

    public static boolean startsWith(String r6, String r7, int r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, "prefix");
        if (r9 == true) goto L7;
        return r6.startsWith(r7, r8);
    L7:
        return StringsKt.regionMatches(r6, r8, r7, 0, r7.length(), r9);
    }

    public static /* synthetic */ byte[] toByteArray$default(String r0, Charset r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        Intrinsics.checkNotNullParameter(r1, "charset");
        return r0.getBytes(r1);
    }

    public static /* synthetic */ Pattern toPattern$default(String r0, int r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 0;
    L5:
        Intrinsics.checkNotNullParameter(r0, "<this>");
        return PatternProtector.compile(r0, r1);
    }

    public static final String replace(String r4, char r5, char r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        if (r7 == false) goto L5;
        StringBuilder r1 = new StringBuilder(r4.length());
        int r0 = 0;
    L8:
        if (r0 >= r4.length()) goto L14;
        char r2 = r4.charAt(r0);
        if (CharsKt.equals(r2, r5, r7) == false) goto L12;
        r2 = r6;
    L12:
        r1.append(r2);
        r0 = r0 + 1;
        goto L8
    L14:
        return r1.toString();
    L5:
        return r4.replace(r5, r6);
    }

    public static final String replaceFirst(String r7, char r8, char r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        int r11 = StringsKt.indexOf$default(r7, r8, 0, r10, 2, null);
        if (r11 >= 0) goto L6;
        return r7;
    L6:
        return StringsKt.replaceRange(r7, r11, r11 + 1, String.valueOf(r9)).toString();
    }

    public static /* synthetic */ int compareTo$default(String r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return StringsKt.compareTo(r0, r1, r2);
    }

    public static /* synthetic */ String concatToString$default(char[] r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.length;
    L9:
        return StringsKt.concatToString(r0, r1, r2);
    }

    public static /* synthetic */ boolean endsWith$default(String r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return StringsKt.endsWith(r0, r1, r2);
    }

    public static /* synthetic */ boolean equals$default(String r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return StringsKt.equals(r0, r1, r2);
    }

    public static /* synthetic */ List split$default(CharSequence r0, Pattern r1, int r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = 0;
    L6:
        return split(r0, r1, r2);
    }

    public static /* synthetic */ boolean startsWith$default(String r0, String r1, boolean r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L6;
        r2 = false;
    L6:
        return StringsKt.startsWith(r0, r1, r2);
    }

    private static final char[] toCharArray(String r1, char[] r2, int r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "destination");
        r1.getChars(r4, r5, r2, r3);
        return r2;
    }

    public static /* synthetic */ char[] toCharArray$default(String r0, int r1, int r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = 0;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.length();
    L9:
        return toCharArray(r0, r1, r2);
    }

    public static /* synthetic */ String decodeToString$default(byte[] r1, int r2, int r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.length;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = false;
    L12:
        return StringsKt.decodeToString(r1, r2, r3, r4);
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(String r1, int r2, int r3, boolean r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = 0;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r1.length();
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = false;
    L12:
        return encodeToByteArray(r1, r2, r3, r4);
    }

    public static final boolean regionMatches(CharSequence r7, int r8, CharSequence r9, int r10, int r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r7, "<this>");
        Intrinsics.checkNotNullParameter(r9, "other");
        if ((r7 instanceof String) == false) goto L9;
        if ((r9 instanceof String) == false) goto L9;
        return StringsKt.regionMatches((String) r7, r8, (String) r9, r10, r11, r12);
    L9:
        return StringsKt__StringsKt.regionMatchesImpl(r7, r8, r9, r10, r11, r12);
    }

    public static /* synthetic */ String replace$default(String r0, char r1, char r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        return replace(r0, r1, r2, r3);
    }

    public static /* synthetic */ String replaceFirst$default(String r0, char r1, char r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        return replaceFirst(r0, r1, r2, r3);
    }

    public static /* synthetic */ boolean startsWith$default(String r0, String r1, int r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        return StringsKt.startsWith(r0, r1, r2, r3);
    }

    public static boolean regionMatches(String r6, int r7, String r8, int r9, int r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r8, "other");
        if (r11 == true) goto L6;
        return r6.regionMatches(r7, r8, r9, r10);
    L6:
        return r6.regionMatches(r11, r7, r8, r9, r10);
    }

    public static /* synthetic */ String replace$default(String r0, String r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        return StringsKt.replace(r0, r1, r2, r3);
    }

    public static /* synthetic */ String replaceFirst$default(String r0, String r1, String r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = false;
    L6:
        return StringsKt.replaceFirst(r0, r1, r2, r3);
    }

    public static /* synthetic */ char[] toCharArray$default(String r1, char[] r2, int r3, int r4, int r5, int r6, Object r7) {
        if ((r6 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = r1.length();
    L11:
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "destination");
        r1.getChars(r4, r5, r2, r3);
        return r2;
    }

    public static /* synthetic */ boolean regionMatches$default(CharSequence r6, int r7, CharSequence r8, int r9, int r10, boolean r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L5;
        boolean r5 = false;
    L7:
        return regionMatches(r6, r7, r8, r9, r10, r5);
    L5:
        r5 = r11;
        goto L7
    }

    public static /* synthetic */ boolean regionMatches$default(String r6, int r7, String r8, int r9, int r10, boolean r11, int r12, Object r13) {
        if ((r12 & 16) == 0) goto L5;
        boolean r5 = false;
    L7:
        return StringsKt.regionMatches(r6, r7, r8, r9, r10, r5);
    L5:
        r5 = r11;
        goto L7
    }
}
