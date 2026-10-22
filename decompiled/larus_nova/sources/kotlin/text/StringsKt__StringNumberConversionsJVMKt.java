package kotlin.text;

import androidx.exifinterface.media.ExifInterface;
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

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\u001a4\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0005H\u0082\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a\r\u0010\b\u001a\u00020\t*\u00020\u0003H\u0087\b\u001a\u0015\u0010\b\u001a\u00020\t*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0087\b\u001a\u000e\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u0003H\u0007\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\t*\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0007\u001a\r\u0010\r\u001a\u00020\u000e*\u00020\u0003H\u0087\b\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u000e\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u0003H\u0007\u001a\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0007\u001a\u000f\u0010\u0012\u001a\u00020\u0013*\u0004\u0018\u00010\u0003H\u0087\b\u001a\r\u0010\u0014\u001a\u00020\u0015*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u0014\u001a\u00020\u0015*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\r\u0010\u0016\u001a\u00020\u0017*\u00020\u0003H\u0087\b\u001a\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0017*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0019\u001a\r\u0010\u001a\u001a\u00020\u001b*\u00020\u0003H\u0087\b\u001a\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001b*\u00020\u0003H\u0007¢\u0006\u0002\u0010\u001d\u001a\r\u0010\u001e\u001a\u00020\u0010*\u00020\u0003H\u0087\b\u001a\u0015\u0010\u001e\u001a\u00020\u0010*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\r\u0010\u001f\u001a\u00020 *\u00020\u0003H\u0087\b\u001a\u0015\u0010\u001f\u001a\u00020 *\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\r\u0010!\u001a\u00020\"*\u00020\u0003H\u0087\b\u001a\u0015\u0010!\u001a\u00020\"*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010#\u001a\u00020\u0003*\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010#\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010#\u001a\u00020\u0003*\u00020 2\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b\u001a\u0015\u0010#\u001a\u00020\u0003*\u00020\"2\u0006\u0010\u000f\u001a\u00020\u0010H\u0087\b¨\u0006$"}, d2 = {"screenFloatValue", ExifInterface.GPS_DIRECTION_TRUE, "str", "", "parse", "Lkotlin/Function1;", "screenFloatValue$StringsKt__StringNumberConversionsJVMKt", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "toBigDecimal", "Ljava/math/BigDecimal;", "mathContext", "Ljava/math/MathContext;", "toBigDecimalOrNull", "toBigInteger", "Ljava/math/BigInteger;", "radix", "", "toBigIntegerOrNull", "toBoolean", "", "toByte", "", "toDouble", "", "toDoubleOrNull", "(Ljava/lang/String;)Ljava/lang/Double;", "toFloat", "", "toFloatOrNull", "(Ljava/lang/String;)Ljava/lang/Float;", "toInt", "toLong", "", "toShort", "", "toString", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/text/StringsKt")
class StringsKt__StringNumberConversionsJVMKt extends StringsKt__StringBuilderKt {
    public StringsKt__StringNumberConversionsJVMKt() {
    }

    private static final BigDecimal toBigDecimal(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new BigDecimal(r100);
    }

    public static BigDecimal toBigDecimalOrNull(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (ScreenFloatValueRegEx.value.matches(r100) == false) goto L11;
        return new BigDecimal(r100);
    L11:
        return null;
    L12:
        return null;
    }

    private static final BigInteger toBigInteger(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new BigInteger(r100);
    }

    public static final BigInteger toBigIntegerOrNull(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return toBigIntegerOrNull(r100, 10);
    }

    private static final boolean toBoolean(String r100) {
        return Boolean.parseBoolean(r100);
    }

    private static final byte toByte(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return CastByteProtector.parseByte(r100);
    }

    private static final double toDouble(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return CastDoubleProtector.parseDouble(r100);
    }

    public static Double toDoubleOrNull(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (ScreenFloatValueRegEx.value.matches(r100) == false) goto L11;
        return Double.valueOf(CastDoubleProtector.parseDouble(r100));
    L11:
        return null;
    L12:
        return null;
    }

    private static final float toFloat(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return CastFloatProtector.parseFloat(r100);
    }

    public static Float toFloatOrNull(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (ScreenFloatValueRegEx.value.matches(r100) == false) goto L11;
        return Float.valueOf(CastFloatProtector.parseFloat(r100));
    L11:
        return null;
    L12:
        return null;
    }

    private static final int toInt(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return CastIntegerProtector.parseInt(r100);
    }

    private static final long toLong(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return CastLongProtector.parseLong(r100);
    }

    private static final short toShort(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return CastShortProtector.parseShort(r100);
    }

    private static final <T> T screenFloatValue$StringsKt__StringNumberConversionsJVMKt(String r100, Function1<? super String, ? extends T> r101) {
        if (ScreenFloatValueRegEx.value.matches(r100) == false) goto L11;
        return r101.invoke(r100);
    L11:
        return null;
    L12:
        return null;
    }

    private static final BigDecimal toBigDecimal(String r100, MathContext r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "mathContext");
        return new BigDecimal(r100, r101);
    }

    public static final BigDecimal toBigDecimalOrNull(String r100, MathContext r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "mathContext");
        if (ScreenFloatValueRegEx.value.matches(r100) == false) goto L11;
        return new BigDecimal(r100, r101);
    L11:
        return null;
    L12:
        return null;
    }

    private static final BigInteger toBigInteger(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new BigInteger(r100, CharsKt.checkRadix(r101));
    }

    public static final BigInteger toBigIntegerOrNull(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        CharsKt.checkRadix(r101);
        int r102 = r100.length();
        if (r102 == 0) goto L19;
        int r103 = 0;
        if (r102 == 1) goto L15;
        if (r100.charAt(0) != '-') goto L9;
        r103 = 1;
    L9:
        if (r103 >= r102) goto L18;
        if (CharsKt__CharJVMKt.digitOf(r100.charAt(r103), r101) < 0) goto L12;
        r103 = r103 + 1;
        goto L9
    L12:
        return null;
    L18:
        return new BigInteger(r100, CharsKt.checkRadix(r101));
    L15:
        if (CharsKt__CharJVMKt.digitOf(r100.charAt(0), r101) >= 0) goto L18;
        return null;
    L19:
        return null;
    }

    private static final byte toByte(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return CastByteProtector.parseByte(r100, CharsKt.checkRadix(r101));
    }

    private static final int toInt(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return CastIntegerProtector.parseInt(r100, CharsKt.checkRadix(r101));
    }

    private static final long toLong(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return CastLongProtector.parseLong(r100, CharsKt.checkRadix(r101));
    }

    private static final short toShort(String r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return CastShortProtector.parseShort(r100, CharsKt.checkRadix(r101));
    }

    private static final String toString(byte r100, int r101) {
        return Integer.toString(r100, CharsKt.checkRadix(r101));
    }

    private static final String toString(int r100, int r101) {
        return Integer.toString(r100, CharsKt.checkRadix(r101));
    }

    private static final String toString(long r100, int r101) {
        return Long.toString(r100, CharsKt.checkRadix(r101));
    }

    private static final String toString(short r100, int r101) {
        return Integer.toString(r100, CharsKt.checkRadix(r101));
    }
}
