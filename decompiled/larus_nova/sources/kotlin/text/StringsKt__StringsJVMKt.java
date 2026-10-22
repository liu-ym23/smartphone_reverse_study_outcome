package kotlin.text;

import com.android.ttcjpaysdk.thirdparty.verify.view.VerifyPasswordFragment;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.ec.model.response.anchorv3.SalesInfoStruct;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.ttvideoengine.model.SubInfo;
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

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000~\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\f\n\u0002\b\u0011\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0087\b\u001a\u0019\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\b\u001a)\u0010\u0007\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001a\u0011\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0087\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\b\u001a!\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0087\b\u001a\f\u0010\u0017\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0014\u0010\u0017\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\u0015\u0010\u001a\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\u0087\b\u001a\u0015\u0010\u001c\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0011H\u0087\b\u001a\u001d\u0010\u001d\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0087\b\u001a\u001c\u0010 \u001a\u00020\u0011*\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a\f\u0010$\u001a\u00020\u0002*\u00020\u0014H\u0007\u001a \u0010$\u001a\u00020\u0002*\u00020\u00142\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\u0019\u0010&\u001a\u00020#*\u0004\u0018\u00010'2\b\u0010!\u001a\u0004\u0018\u00010'H\u0087\u0004\u001a \u0010&\u001a\u00020#*\u0004\u0018\u00010'2\b\u0010!\u001a\u0004\u0018\u00010'2\u0006\u0010\"\u001a\u00020#H\u0007\u001a\u0015\u0010&\u001a\u00020#*\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0087\b\u001a\u0015\u0010&\u001a\u00020#*\u00020\u00022\u0006\u0010(\u001a\u00020'H\u0087\b\u001a\f\u0010)\u001a\u00020\u0002*\u00020\u0002H\u0007\u001a\u0014\u0010)\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0007\u001a\f\u0010*\u001a\u00020\u0002*\u00020\rH\u0007\u001a*\u0010*\u001a\u00020\u0002*\u00020\r2\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020#H\u0007\u001a\f\u0010,\u001a\u00020\r*\u00020\u0002H\u0007\u001a*\u0010,\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u00112\b\b\u0002\u0010+\u001a\u00020#H\u0007\u001a\u001c\u0010-\u001a\u00020#*\u00020\u00022\u0006\u0010.\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a \u0010/\u001a\u00020#*\u0004\u0018\u00010\u00022\b\u0010!\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a4\u00100\u001a\u00020\u0002*\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b¢\u0006\u0002\u00104\u001a*\u00100\u001a\u00020\u0002*\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b¢\u0006\u0002\u00105\u001a<\u00100\u001a\u00020\u0002*\u00020\u00042\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b¢\u0006\u0002\u00106\u001a2\u00100\u001a\u00020\u0002*\u00020\u00042\u0006\u00100\u001a\u00020\u00022\u0016\u00101\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010302\"\u0004\u0018\u000103H\u0087\b¢\u0006\u0002\u00107\u001a\r\u00108\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\r\u00109\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u00109\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\b\u001a\u001d\u0010:\u001a\u00020\u0011*\u00020\u00022\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0011H\u0081\b\u001a\u001d\u0010:\u001a\u00020\u0011*\u00020\u00022\u0006\u0010>\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0011H\u0081\b\u001a\u001d\u0010?\u001a\u00020\u0011*\u00020\u00022\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0011H\u0081\b\u001a\u001d\u0010?\u001a\u00020\u0011*\u00020\u00022\u0006\u0010>\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u0011H\u0081\b\u001a\u001d\u0010@\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010A\u001a\u00020\u0011H\u0087\b\u001a4\u0010B\u001a\u00020#*\u00020'2\u0006\u0010C\u001a\u00020\u00112\u0006\u0010!\u001a\u00020'2\u0006\u0010D\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a4\u0010B\u001a\u00020#*\u00020\u00022\u0006\u0010C\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a\u0012\u0010E\u001a\u00020\u0002*\u00020'2\u0006\u0010F\u001a\u00020\u0011\u001a$\u0010G\u001a\u00020\u0002*\u00020\u00022\u0006\u0010H\u001a\u00020<2\u0006\u0010I\u001a\u00020<2\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010G\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010H\u001a\u00020<2\u0006\u0010I\u001a\u00020<2\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010J\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a\"\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00020N*\u00020'2\u0006\u0010O\u001a\u00020P2\b\b\u0002\u0010Q\u001a\u00020\u0011\u001a\u001c\u0010R\u001a\u00020#*\u00020\u00022\u0006\u0010S\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020#\u001a$\u0010R\u001a\u00020#*\u00020\u00022\u0006\u0010S\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\"\u001a\u00020#\u001a\u0015\u0010T\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0011H\u0087\b\u001a\u001d\u0010T\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u0011H\u0087\b\u001a\u0017\u0010U\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0087\b\u001a\r\u0010V\u001a\u00020\u0014*\u00020\u0002H\u0087\b\u001a3\u0010V\u001a\u00020\u0014*\u00020\u00022\u0006\u0010W\u001a\u00020\u00142\b\b\u0002\u0010X\u001a\u00020\u00112\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0087\b\u001a \u0010V\u001a\u00020\u0014*\u00020\u00022\b\b\u0002\u0010%\u001a\u00020\u00112\b\b\u0002\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\r\u0010Y\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u0010Y\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\b\u001a\u0017\u0010Z\u001a\u00020P*\u00020\u00022\b\b\u0002\u0010[\u001a\u00020\u0011H\u0087\b\u001a\r\u0010\\\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\b\u001a\r\u0010]\u001a\u00020\u0002*\u00020\u0002H\u0087\b\u001a\u0015\u0010]\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0087\b\"%\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006^"}, d2 = {"CASE_INSENSITIVE_ORDER", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "Lkotlin/String$Companion;", "getCASE_INSENSITIVE_ORDER", "(Lkotlin/jvm/internal/StringCompanionObject;)Ljava/util/Comparator;", "String", "stringBuffer", "Ljava/lang/StringBuffer;", "stringBuilder", "Ljava/lang/StringBuilder;", HTTP.CONTENT_RANGE_BYTES, "", "charset", "Ljava/nio/charset/Charset;", "offset", "", "length", "chars", "", "codePoints", "", "capitalize", "locale", "Ljava/util/Locale;", "codePointAt", "index", "codePointBefore", "codePointCount", "beginIndex", "endIndex", "compareTo", "other", "ignoreCase", "", "concatToString", "startIndex", "contentEquals", "", "charSequence", "decapitalize", "decodeToString", "throwOnInvalidSequence", "encodeToByteArray", "endsWith", "suffix", "equals", SubInfo.KEY_FORMAT, "args", "", "", "(Ljava/lang/String;Ljava/util/Locale;[Ljava/lang/Object;)Ljava/lang/String;", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlin/jvm/internal/StringCompanionObject;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "intern", "lowercase", "nativeIndexOf", "ch", "", "fromIndex", "str", "nativeLastIndexOf", "offsetByCodePoints", "codePointOffset", "regionMatches", "thisOffset", "otherOffset", SalesInfoStruct.REPEAT, OfficeSDKRequestTag.KEY_NEW_USER, "replace", "oldChar", "newChar", "oldValue", "newValue", "replaceFirst", "split", "", "regex", "Ljava/util/regex/Pattern;", VerifyPasswordFragment.LYNX_OPEN_CREDIT_LIMIT, "startsWith", "prefix", "substring", "toByteArray", "toCharArray", a.KEY_DESTINATION, "destinationOffset", "toLowerCase", "toPattern", "flags", "toUpperCase", "uppercase", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    public StringsKt__StringsJVMKt() {
    }

    private static final String String(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        return new String(r100, Charsets.UTF_8);
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String capitalize(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return capitalize(r100, Locale.getDefault());
    }

    public static String concatToString(char[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new String(r100);
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(Locale.getDefault()) }", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String decapitalize(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r100.length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L8;
        return r100;
    L8:
        if (Character.isLowerCase(r100.charAt(0)) == true) goto L12;
        StringBuilder r102 = new StringBuilder();
        String r103 = r100.substring(0, 1);
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type java.lang.String");
        r102.append(r103.toLowerCase());
        r102.append(r100.substring(1));
        return r102.toString();
    L12:
        return r100;
    L5:
        r101 = false;
        goto L6
    }

    public static String decodeToString(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new String(r100, Charsets.UTF_8);
    }

    public static byte[] encodeToByteArray(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.getBytes(Charsets.UTF_8);
    }

    public static final Comparator<String> getCASE_INSENSITIVE_ORDER(StringCompanionObject r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return String.CASE_INSENSITIVE_ORDER;
    }

    private static final String intern(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.intern();
    }

    private static final String lowercase(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.toLowerCase(Locale.ROOT);
    }

    private static final char[] toCharArray(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.toCharArray();
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String toLowerCase(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.toLowerCase();
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(Locale.getDefault())", imports = {"java.util.Locale"}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String toUpperCase(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.toUpperCase();
    }

    private static final String uppercase(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.toUpperCase(Locale.ROOT);
    }

    private static final String String(StringBuffer r100) {
        Intrinsics.checkNotNullParameter(r100, "stringBuffer");
        return new String(r100);
    }

    private static final String String(StringBuilder r100) {
        Intrinsics.checkNotNullParameter(r100, "stringBuilder");
        return new String(r100);
    }

    private static final String String(char[] r100) {
        Intrinsics.checkNotNullParameter(r100, "chars");
        return new String(r100);
    }

    private static final String String(byte[] r100, Charset r101) {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        Intrinsics.checkNotNullParameter(r101, "charset");
        return new String(r100, r101);
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale) else it.toString() }", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String capitalize(String r100, Locale r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "locale");
        if (r100.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L15;
        char r103 = r100.charAt(0);
        if (Character.isLowerCase(r103) == false) goto L16;
        StringBuilder r104 = new StringBuilder();
        char r105 = Character.toTitleCase(r103);
        if (r105 == Character.toUpperCase(r103)) goto L12;
        r104.append(r105);
    L13:
        r104.append(r100.substring(1));
        return r104.toString();
    L12:
        String r106 = r100.substring(0, 1);
        Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type java.lang.String");
        r104.append(r106.toUpperCase(r101));
        goto L13
    L16:
        return r100;
    L15:
        return r100;
    L5:
        r102 = false;
        goto L6
    }

    private static final int codePointAt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.codePointAt(r101);
    }

    private static final int codePointBefore(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.codePointBefore(r101);
    }

    public static boolean contentEquals(CharSequence r100, CharSequence r101) {
        if ((r100 instanceof String) == false) goto L7;
        if (r101 == null) goto L7;
        return ((String) r100).contentEquals(r101);
    L7:
        return StringsKt__StringsKt.contentEqualsImpl(r100, r101);
    }

    @Deprecated(message = "Use replaceFirstChar instead.", replaceWith = @ReplaceWith(expression = "replaceFirstChar { it.lowercase(locale) }", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    public static final String decapitalize(String r100, Locale r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "locale");
        if (r100.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
        return r100;
    L8:
        if (Character.isLowerCase(r100.charAt(0)) == true) goto L12;
        StringBuilder r103 = new StringBuilder();
        String r104 = r100.substring(0, 1);
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type java.lang.String");
        r103.append(r104.toLowerCase(r101));
        r103.append(r100.substring(1));
        return r103.toString();
    L12:
        return r100;
    L5:
        r102 = false;
        goto L6
    }

    private static final String format(String r100, Object... r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "args");
        return String.format(r100, Arrays.copyOf(r101, r101.length));
    }

    private static final String lowercase(String r100, Locale r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "locale");
        return r100.toLowerCase(r101);
    }

    public static String repeat(CharSequence r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r102 = 0;
        int r103 = 1;
        if (r101 < 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L26;
        if (r101 == 0) goto L29;
        if (r101 == 1) goto L24;
        int r105 = r100.length();
        if (r105 == 0) goto L30;
        if (r105 == 1) goto L19;
        StringBuilder r106 = new StringBuilder(r100.length() * r101);
        if (1 > r101) goto L18;
    L15:
        r106.append(r100);
        if (r103 == r101) goto L18;
        r103 = r103 + 1;
    L18:
        String r107 = r106.toString();
        Intrinsics.checkNotNull(r107);
        return r107;
    L19:
        char r108 = r100.charAt(0);
        char[] r109 = new char[r101];
    L20:
        if (r102 >= r101) goto L32;
        r109[r102] = r108;
        r102 = r102 + 1;
        goto L20
    L32:
        return new String(r109);
    L30:
        return "";
    L24:
        return r100.toString();
    L29:
        return "";
    L26:
        throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + r101 + '.').toString());
    L5:
        r104 = false;
        goto L6
    }

    private static final String substring(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.substring(r101);
    }

    private static final byte[] toByteArray(String r100, Charset r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        return r100.getBytes(r101);
    }

    @Deprecated(message = "Use lowercase() instead.", replaceWith = @ReplaceWith(expression = "lowercase(locale)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String toLowerCase(String r100, Locale r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "locale");
        return r100.toLowerCase(r101);
    }

    private static final Pattern toPattern(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return PatternProtector.compile(r100, r101);
    }

    @Deprecated(message = "Use uppercase() instead.", replaceWith = @ReplaceWith(expression = "uppercase(locale)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.5")
    private static final String toUpperCase(String r100, Locale r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "locale");
        return r100.toUpperCase(r101);
    }

    private static final String uppercase(String r100, Locale r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "locale");
        return r100.toUpperCase(r101);
    }

    private static final boolean contentEquals(String r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charSequence");
        return r100.contentEquals(r101);
    }

    private static final boolean contentEquals(String r100, StringBuffer r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "stringBuilder");
        return r100.contentEquals(r101);
    }

    private static final String String(byte[] r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        return new String(r100, r101, r102, Charsets.UTF_8);
    }

    private static final int codePointCount(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.codePointCount(r101, r102);
    }

    public static int compareTo(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "other");
        if (r102 == false) goto L7;
        return r100.compareToIgnoreCase(r101);
    L7:
        return r100.compareTo(r101);
    }

    public static String concatToString(char[] r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r101, r102, r100.length);
        return new String(r100, r101, r102 - r101);
    }

    public static final boolean contentEquals(CharSequence r100, CharSequence r101, boolean r102) {
        if (r102 == false) goto L5;
        return StringsKt__StringsKt.contentEqualsIgnoreCaseImpl(r100, r101);
    L5:
        return StringsKt.contentEquals(r100, r101);
    }

    public static boolean endsWith(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "suffix");
        if (r102 == true) goto L7;
        return r100.endsWith(r101);
    L7:
        return StringsKt.regionMatches(r100, r100.length() - r101.length(), r101, 0, r101.length(), true);
    }

    public static boolean equals(String r100, String r101, boolean r102) {
        if (r100 != null) goto L7;
        if (r101 != null) goto L5;
        return true;
    L5:
        return false;
    L7:
        if (r102 == true) goto L10;
        return r100.equals(r101);
    L10:
        return r100.equalsIgnoreCase(r101);
    }

    private static final String format(StringCompanionObject r100, String r101, Object... r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        Intrinsics.checkNotNullParameter(r102, "args");
        return String.format(r101, Arrays.copyOf(r102, r102.length));
    }

    private static final int nativeIndexOf(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "str");
        return r100.indexOf(r101, r102);
    }

    private static final int nativeLastIndexOf(String r100, String r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "str");
        return r100.lastIndexOf(r101, r102);
    }

    private static final int offsetByCodePoints(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.offsetByCodePoints(r101, r102);
    }

    public static final List<String> split(CharSequence r100, Pattern r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "regex");
        StringsKt__StringsKt.requireNonNegativeLimit(r102);
        if (r102 != 0) goto L6;
        r102 = -1;
    L6:
        return ArraysKt.asList(r101.split(r100, r102));
    }

    public static boolean startsWith(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "prefix");
        if (r102 == true) goto L7;
        return r100.startsWith(r101);
    L7:
        return StringsKt.regionMatches(r100, 0, r101, 0, r101.length(), r102);
    }

    private static final String substring(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.substring(r101, r102);
    }

    public static final char[] toCharArray(String r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r101, r102, r100.length());
        char[] r103 = new char[r102 - r101];
        r100.getChars(r101, r102, r103, 0);
        return r103;
    }

    private static final String String(char[] r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "chars");
        return new String(r100, r101, r102);
    }

    private static final String format(String r100, Locale r101, Object... r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "args");
        return String.format(r101, r100, Arrays.copyOf(r102, r102.length));
    }

    private static final int nativeIndexOf(String r100, char r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.indexOf(r101, r102);
    }

    private static final int nativeLastIndexOf(String r100, char r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return r100.lastIndexOf(r101, r102);
    }

    private static final String String(int[] r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "codePoints");
        return new String(r100, r101, r102);
    }

    private static final String String(byte[] r100, int r101, int r102, Charset r103) {
        Intrinsics.checkNotNullParameter(r100, HTTP.CONTENT_RANGE_BYTES);
        Intrinsics.checkNotNullParameter(r103, "charset");
        return new String(r100, r101, r102, r103);
    }

    public static String decodeToString(byte[] r100, int r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r101, r102, r100.length);
        if (r103 == true) goto L7;
        return new String(r100, r101, r102 - r101, Charsets.UTF_8);
    L7:
        return Charsets.UTF_8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(ByteBuffer.wrap(r100, r101, r102 - r101)).toString();
    }

    public static final byte[] encodeToByteArray(String r100, int r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r101, r102, r100.length());
        if (r103 == true) goto L6;
        String r104 = r100.substring(r101, r102);
        Charset r105 = Charsets.UTF_8;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type java.lang.String");
        return r104.getBytes(r105);
    L6:
        ByteBuffer r106 = Charsets.UTF_8.newEncoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).encode(CharBuffer.wrap(r100, r101, r102));
        if (r106.hasArray() == true) goto L9;
    L13:
        byte[] r107 = new byte[r106.remaining()];
        r106.get(r107);
        return r107;
    L9:
        if (r106.arrayOffset() != 0) goto L13;
        int r108 = r106.remaining();
        byte[] r109 = r106.array();
        Intrinsics.checkNotNull(r109);
        if (r108 != r109.length) goto L13;
        byte[] r110 = r106.array();
        Intrinsics.checkNotNull(r110);
        return r110;
    }

    private static final String format(StringCompanionObject r100, Locale r101, String r102, Object... r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, SubInfo.KEY_FORMAT);
        Intrinsics.checkNotNullParameter(r103, "args");
        return String.format(r101, r102, Arrays.copyOf(r103, r103.length));
    }

    public static String replace(String r100, String r101, String r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "oldValue");
        Intrinsics.checkNotNullParameter(r102, "newValue");
        int r104 = 0;
        int r105 = StringsKt.indexOf(r100, r101, 0, r103);
        if (r105 >= 0) goto L5;
        return r100;
    L5:
        int r106 = r101.length();
        int r107 = RangesKt.coerceAtLeast(r106, 1);
        int r108 = (r100.length() - r106) + r102.length();
        if (r108 < 0) goto L15;
        StringBuilder r109 = new StringBuilder(r108);
    L8:
        r109.append(r100, r104, r105);
        r109.append(r102);
        r104 = r105 + r106;
        if (r105 >= r100.length()) goto L12;
        r105 = StringsKt.indexOf(r100, r101, r105 + r107, r103);
        if (r105 > 0) goto L8;
    L12:
        r109.append(r100, r104, r100.length());
        return r109.toString();
    L15:
        throw new OutOfMemoryError();
    }

    public static String replaceFirst(String r100, String r101, String r102, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "oldValue");
        Intrinsics.checkNotNullParameter(r102, "newValue");
        int r111 = StringsKt.indexOf$default(r100, r101, 0, r110, 2, null);
        if (r111 >= 0) goto L6;
        return r100;
    L6:
        return StringsKt.replaceRange(r100, r111, r101.length() + r111, r102).toString();
    }

    public static boolean startsWith(String r100, String r101, int r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "prefix");
        if (r103 == true) goto L7;
        return r100.startsWith(r101, r102);
    L7:
        return StringsKt.regionMatches(r100, r102, r101, 0, r101.length(), r103);
    }

    public static /* synthetic */ byte[] toByteArray$default(String r100, Charset r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = Charsets.UTF_8;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "charset");
        return r100.getBytes(r101);
    }

    public static /* synthetic */ Pattern toPattern$default(String r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L5;
        r101 = 0;
    L5:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return PatternProtector.compile(r100, r101);
    }

    public static final String replace(String r100, char r101, char r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (r103 == false) goto L5;
        StringBuilder r104 = new StringBuilder(r100.length());
        int r105 = 0;
    L8:
        if (r105 >= r100.length()) goto L14;
        char r106 = r100.charAt(r105);
        if (CharsKt.equals(r106, r101, r103) == false) goto L12;
        r106 = r102;
    L12:
        r104.append(r106);
        r105 = r105 + 1;
        goto L8
    L14:
        return r104.toString();
    L5:
        return r100.replace(r101, r102);
    }

    public static final String replaceFirst(String r100, char r101, char r102, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r103 = StringsKt.indexOf$default(r100, r101, 0, r110, 2, null);
        if (r103 >= 0) goto L6;
        return r100;
    L6:
        return StringsKt.replaceRange(r100, r103, r103 + 1, String.valueOf(r102)).toString();
    }

    public static /* synthetic */ int compareTo$default(String r100, String r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return StringsKt.compareTo(r100, r101, r102);
    }

    public static /* synthetic */ String concatToString$default(char[] r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.length;
    L9:
        return StringsKt.concatToString(r100, r101, r102);
    }

    public static /* synthetic */ boolean endsWith$default(String r100, String r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return StringsKt.endsWith(r100, r101, r102);
    }

    public static /* synthetic */ boolean equals$default(String r100, String r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return StringsKt.equals(r100, r101, r102);
    }

    public static /* synthetic */ List split$default(CharSequence r100, Pattern r101, int r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        return split(r100, r101, r102);
    }

    public static /* synthetic */ boolean startsWith$default(String r100, String r101, boolean r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L6;
        r102 = false;
    L6:
        return StringsKt.startsWith(r100, r101, r102);
    }

    private static final char[] toCharArray(String r100, char[] r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, a.KEY_DESTINATION);
        r100.getChars(r103, r104, r101, r102);
        return r101;
    }

    public static /* synthetic */ char[] toCharArray$default(String r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.length();
    L9:
        return toCharArray(r100, r101, r102);
    }

    public static /* synthetic */ String decodeToString$default(byte[] r100, int r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.length;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = false;
    L12:
        return StringsKt.decodeToString(r100, r101, r102, r103);
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(String r100, int r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.length();
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = false;
    L12:
        return encodeToByteArray(r100, r101, r102, r103);
    }

    public static final boolean regionMatches(CharSequence r100, int r101, CharSequence r102, int r110, int r111, boolean r112) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "other");
        if ((r100 instanceof String) == false) goto L9;
        if ((r102 instanceof String) == false) goto L9;
        return StringsKt.regionMatches((String) r100, r101, (String) r102, r110, r111, r112);
    L9:
        return StringsKt__StringsKt.regionMatchesImpl(r100, r101, r102, r110, r111, r112);
    }

    public static /* synthetic */ String replace$default(String r100, char r101, char r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = false;
    L6:
        return replace(r100, r101, r102, r103);
    }

    public static /* synthetic */ String replaceFirst$default(String r100, char r101, char r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = false;
    L6:
        return replaceFirst(r100, r101, r102, r103);
    }

    public static /* synthetic */ boolean startsWith$default(String r100, String r101, int r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = false;
    L6:
        return StringsKt.startsWith(r100, r101, r102, r103);
    }

    public static boolean regionMatches(String r100, int r101, String r102, int r103, int r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r102, "other");
        if (r111 == true) goto L6;
        return r100.regionMatches(r101, r102, r103, r110);
    L6:
        return r100.regionMatches(r111, r101, r102, r103, r110);
    }

    public static /* synthetic */ String replace$default(String r100, String r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = false;
    L6:
        return StringsKt.replace(r100, r101, r102, r103);
    }

    public static /* synthetic */ String replaceFirst$default(String r100, String r101, String r102, boolean r103, int r104, Object r105) {
        if ((r104 & 4) == 0) goto L6;
        r103 = false;
    L6:
        return StringsKt.replaceFirst(r100, r101, r102, r103);
    }

    public static /* synthetic */ char[] toCharArray$default(String r100, char[] r101, int r102, int r103, int r104, int r105, Object r106) {
        if ((r105 & 2) == 0) goto L6;
        r102 = 0;
    L6:
        if ((r105 & 4) == 0) goto L9;
        r103 = 0;
    L9:
        if ((r105 & 8) == 0) goto L11;
        r104 = r100.length();
    L11:
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, a.KEY_DESTINATION);
        r100.getChars(r103, r104, r101, r102);
        return r101;
    }

    public static /* synthetic */ boolean regionMatches$default(CharSequence r100, int r101, CharSequence r102, int r103, int r110, boolean r111, int r112, Object r113) {
        if ((r112 & 16) == 0) goto L5;
        boolean r104 = false;
    L7:
        return regionMatches(r100, r101, r102, r103, r110, r104);
    L5:
        r104 = r111;
        goto L7
    }

    public static /* synthetic */ boolean regionMatches$default(String r100, int r101, String r102, int r103, int r110, boolean r111, int r112, Object r113) {
        if ((r112 & 16) == 0) goto L5;
        boolean r104 = false;
    L7:
        return StringsKt.regionMatches(r100, r101, r102, r103, r110, r104);
    L5:
        r104 = r111;
        goto L7
    }
}
