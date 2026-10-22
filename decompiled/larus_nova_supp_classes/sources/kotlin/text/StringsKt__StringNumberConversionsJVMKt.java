package kotlin.text;

import android.util.EventsUtils;
import com.bytedance.mt.protector.impl.string2number.CastByteProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.mt.protector.impl.string2number.CastShortProtector;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0005H\u0082\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\r\u0010\b\u001a\u00020\t*\u00020\u0003H\u0087\b\u001a\u0015\u0010\b\u001a\u00020\t*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0087\b\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u0003H\u0007\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\r\u0010\r\u001a\u00020\u000e*\u00020\u0003H\u0087\b\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u000e\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007\u001a\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u000f\u0010\u0012\u001a\u00020\u0013*\u0004\u0018\u00010\u0003H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u0015*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\r\u0010\u0016\u001a\u00020\u0017*\u00020\u0003H\u0087\b\u001a\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0017*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0019\u001a\r\u0010\u001a\u001a\u00020\u001b*\u00020\u0003H\u0087\b\u001a\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001b*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u001d\u001a\r\u0010\u001e\u001a\u00020\u0010*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u001e\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\r\u0010\u001f\u001a\u00020 *\u00020\u0003H\u0087\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\r\u0010!\u001a\u00020\"*\u00020\u0003H\u0087\b\u001a\u0015\u0010!\u001a\u00020\"*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010#\u001a\u00020\u0003*\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010#\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010#\u001a\u00020\u0003*\u00020 2\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010#\u001a\u00020\u0003*\u00020\"2\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b¨\u0006$"}, d2 = {"screenFloatValue", "T", "str", XmlPullParser.NO_NAMESPACE, "parse", "Lkotlin/Function1;", "screenFloatValue$StringsKt__StringNumberConversionsJVMKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toBigDecimal", "Ljava/math/BigDecimal;", "mathContext", "Ljava/math/MathContext;", "toBigDecimalOrNull", "toBigInteger", "Ljava/math/BigInteger;", "radix", XmlPullParser.NO_NAMESPACE, "toBigIntegerOrNull", "toBoolean", XmlPullParser.NO_NAMESPACE, "toByte", XmlPullParser.NO_NAMESPACE, "toDouble", XmlPullParser.NO_NAMESPACE, "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "toFloat", XmlPullParser.NO_NAMESPACE, "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toInt", "toLong", XmlPullParser.NO_NAMESPACE, "toShort", XmlPullParser.NO_NAMESPACE, "toString", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = EventsUtils.FEAT_TYPE_IOPRELOAD_DATA, xs = "kotlin/text/StringsKt")
class StringsKt__StringNumberConversionsJVMKt extends StringsKt__StringBuilderKt {
    public StringsKt__StringNumberConversionsJVMKt() {
    }

    private static final BigDecimal toBigDecimal(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new BigDecimal(r1);
    }

    public static BigDecimal toBigDecimalOrNull(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (ScreenFloatValueRegEx.value.matches(r2) == false) goto L11;
        return new BigDecimal(r2);
    L11:
        return null;
    L12:
        return null;
    }

    private static final BigInteger toBigInteger(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new BigInteger(r1);
    }

    public static final BigInteger toBigIntegerOrNull(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return toBigIntegerOrNull(r1, 10);
    }

    private static final boolean toBoolean(String r0) {
        return Boolean.parseBoolean(r0);
    }

    private static final byte toByte(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return CastByteProtector.parseByte(r1);
    }

    private static final double toDouble(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return CastDoubleProtector.parseDouble(r2);
    }

    public static Double toDoubleOrNull(String r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (ScreenFloatValueRegEx.value.matches(r3) == false) goto L11;
        return Double.valueOf(CastDoubleProtector.parseDouble(r3));
    L11:
        return null;
    L12:
        return null;
    }

    private static final float toFloat(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return CastFloatProtector.parseFloat(r1);
    }

    public static Float toFloatOrNull(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        if (ScreenFloatValueRegEx.value.matches(r2) == false) goto L11;
        return Float.valueOf(CastFloatProtector.parseFloat(r2));
    L11:
        return null;
    L12:
        return null;
    }

    private static final int toInt(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return CastIntegerProtector.parseInt(r1);
    }

    private static final long toLong(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return CastLongProtector.parseLong(r2);
    }

    private static final short toShort(String r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return CastShortProtector.parseShort(r1);
    }

    private static final <T> T screenFloatValue$StringsKt__StringNumberConversionsJVMKt(String r2, Function1<? super String, ? extends T> r3) {
        if (ScreenFloatValueRegEx.value.matches(r2) == false) goto L11;
        return r3.invoke(r2);
    L11:
        return null;
    L12:
        return null;
    }

    private static final BigDecimal toBigDecimal(String r1, MathContext r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "mathContext");
        return new BigDecimal(r1, r2);
    }

    public static final BigDecimal toBigDecimalOrNull(String r2, MathContext r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "mathContext");
        if (ScreenFloatValueRegEx.value.matches(r2) == false) goto L11;
        return new BigDecimal(r2, r3);
    L11:
        return null;
    L12:
        return null;
    }

    private static final BigInteger toBigInteger(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new BigInteger(r1, CharsKt.checkRadix(r2));
    }

    public static final BigInteger toBigIntegerOrNull(String r6, int r7) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        CharsKt.checkRadix(r7);
        int r0 = r6.length();
        if (r0 == 0) goto L19;
        int r2 = 0;
        if (r0 == 1) goto L15;
        if (r6.charAt(0) != '-') goto L9;
        r2 = 1;
    L9:
        if (r2 >= r0) goto L18;
        if (CharsKt__CharJVMKt.digitOf(r6.charAt(r2), r7) < 0) goto L12;
        r2 = r2 + 1;
        goto L9
    L12:
        return null;
    L18:
        return new BigInteger(r6, CharsKt.checkRadix(r7));
    L15:
        if (CharsKt__CharJVMKt.digitOf(r6.charAt(0), r7) >= 0) goto L18;
        return null;
    L19:
        return null;
    }

    private static final byte toByte(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return CastByteProtector.parseByte(r1, CharsKt.checkRadix(r2));
    }

    private static final int toInt(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return CastIntegerProtector.parseInt(r1, CharsKt.checkRadix(r2));
    }

    private static final long toLong(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return CastLongProtector.parseLong(r1, CharsKt.checkRadix(r2));
    }

    private static final short toShort(String r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return CastShortProtector.parseShort(r1, CharsKt.checkRadix(r2));
    }

    private static final String toString(byte r0, int r1) {
        return Integer.toString(r0, CharsKt.checkRadix(r1));
    }

    private static final String toString(int r0, int r1) {
        return Integer.toString(r0, CharsKt.checkRadix(r1));
    }

    private static final String toString(long r0, int r2) {
        return Long.toString(r0, CharsKt.checkRadix(r2));
    }

    private static final String toString(short r0, int r1) {
        return Integer.toString(r0, CharsKt.checkRadix(r1));
    }
}
