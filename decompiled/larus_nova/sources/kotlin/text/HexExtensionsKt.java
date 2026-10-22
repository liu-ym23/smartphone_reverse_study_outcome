package kotlin.text;

import androidx.collection.SieveCacheKt;
import com.bytedance.android.ec.core.event.a;
import com.ss.ttvideoengine.model.SubInfo;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.ULong;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes42.dex */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002\u001a\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\nH\u0002\u001a(\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0002\u001a@\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0000\u001a@\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0000\u001a \u0010\u001b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002\u001a5\u0010\u001c\u001a\u00020\r*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0007H\u0082\b\u001a$\u0010#\u001a\u00020$*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010&\u001a\u00020\rH\u0002\u001a\u001c\u0010'\u001a\u00020\r*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rH\u0002\u001a<\u0010(\u001a\u00020$*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u00072\u0006\u0010 \u001a\u00020!2\u0006\u0010&\u001a\u00020\rH\u0002\u001a\u0015\u0010+\u001a\u00020\r*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\rH\u0082\b\u001a,\u0010,\u001a\u00020\r*\u00020-2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\rH\u0002\u001a<\u0010,\u001a\u00020\r*\u00020-2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00012\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\rH\u0002\u001a*\u00104\u001a\u000205*\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0003\u001a\u0016\u00104\u001a\u000205*\u00020\u00072\b\b\u0002\u00106\u001a\u000207H\u0007\u001a*\u00108\u001a\u00020-*\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0003\u001a\u0016\u00108\u001a\u00020-*\u00020\u00072\b\b\u0002\u00106\u001a\u000207H\u0007\u001a&\u00109\u001a\u0004\u0018\u00010-*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;H\u0003\u001a&\u0010<\u001a\u0004\u0018\u00010-*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;H\u0003\u001a&\u0010=\u001a\u0004\u0018\u00010-*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;H\u0003\u001a$\u0010>\u001a\u00020-*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;H\u0003\u001a*\u0010?\u001a\u00020\r*\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0003\u001a\u0016\u0010?\u001a\u00020\r*\u00020\u00072\b\b\u0002\u00106\u001a\u000207H\u0007\u001a,\u0010@\u001a\u00020\r*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u00106\u001a\u0002072\u0006\u0010&\u001a\u00020\rH\u0003\u001a*\u0010A\u001a\u00020\n*\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0003\u001a\u0016\u0010A\u001a\u00020\n*\u00020\u00072\b\b\u0002\u00106\u001a\u000207H\u0007\u001a,\u0010B\u001a\u00020\n*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u00106\u001a\u0002072\u0006\u0010&\u001a\u00020\rH\u0003\u001a*\u0010C\u001a\u00020D*\u00020\u00072\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0003\u001a\u0016\u0010C\u001a\u00020D*\u00020\u00072\b\b\u0002\u00106\u001a\u000207H\u0007\u001a\u0015\u0010E\u001a\u00020\n*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\rH\u0082\b\u001a\u0014\u0010F\u001a\u000205*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\rH\u0002\u001a\u001c\u0010G\u001a\u00020\r*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rH\u0002\u001a\u001c\u0010H\u001a\u00020\n*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\rH\u0002\u001a\u0014\u0010I\u001a\u00020J*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\rH\u0002\u001a,\u0010K\u001a\u00020$*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010&\u001a\u00020\r2\u0006\u0010L\u001a\u00020!H\u0002\u001a,\u0010M\u001a\u00020$*\u00020\u00072\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0002\u001a,\u0010N\u001a\u00020$*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u0007H\u0002\u001a\u001c\u0010O\u001a\u00020\r*\u00020\u00072\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\rH\u0002\u001a\u0016\u0010P\u001a\u00020\u0007*\u0002052\b\b\u0002\u00106\u001a\u000207H\u0007\u001a*\u0010P\u001a\u00020\u0007*\u00020-2\b\b\u0002\u0010%\u001a\u00020\r2\b\b\u0002\u0010\u001e\u001a\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0007\u001a\u0016\u0010P\u001a\u00020\u0007*\u00020-2\b\b\u0002\u00106\u001a\u000207H\u0007\u001a\u0016\u0010P\u001a\u00020\u0007*\u00020\r2\b\b\u0002\u00106\u001a\u000207H\u0007\u001a\u0016\u0010P\u001a\u00020\u0007*\u00020\n2\b\b\u0002\u00106\u001a\u000207H\u0007\u001a\u0016\u0010P\u001a\u00020\u0007*\u00020D2\b\b\u0002\u00106\u001a\u000207H\u0007\u001a$\u0010Q\u001a\u00020\u0007*\u00020\n2\u0006\u0010R\u001a\u00020S2\u0006\u0010T\u001a\u00020\u00072\u0006\u0010U\u001a\u00020\rH\u0003\u001a,\u0010V\u001a\u00020\u0007*\u00020-2\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;2\u0006\u0010.\u001a\u00020\u0001H\u0003\u001a,\u0010W\u001a\u00020\u0007*\u00020-2\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;2\u0006\u0010.\u001a\u00020\u0001H\u0003\u001a,\u0010X\u001a\u00020\u0007*\u00020-2\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;2\u0006\u0010.\u001a\u00020\u0001H\u0003\u001a,\u0010Y\u001a\u00020\u0007*\u00020-2\u0006\u0010%\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010:\u001a\u00020;2\u0006\u0010.\u001a\u00020\u0001H\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"BYTE_TO_LOWER_CASE_HEX_DIGITS", "", "BYTE_TO_UPPER_CASE_HEX_DIGITS", "HEX_DIGITS_TO_DECIMAL", "HEX_DIGITS_TO_LONG_DECIMAL", "", "LOWER_CASE_HEX_DIGITS", "", "UPPER_CASE_HEX_DIGITS", "charsPerSet", "", "charsPerElement", "elementsPerSet", "", "elementSeparatorLength", "checkFormatLength", "formatLength", "formattedStringLength", "numberOfBytes", "byteSeparatorLength", "bytePrefixLength", "byteSuffixLength", "bytesPerLine", "bytesPerGroup", "groupSeparatorLength", "parsedByteArrayMaxSize", "stringLength", "wholeElementsPerSet", "checkContainsAt", "index", "endIndex", "part", "ignoreCase", "", "partName", "checkMaxDigits", "", "startIndex", "maxDigits", "checkNewLineAt", "checkPrefixSuffixMaxDigits", "prefix", "suffix", "decimalFromHexDigitAt", "formatByteAt", "", "byteToDigits", a.KEY_DESTINATION, "", "destinationOffset", "bytePrefix", "byteSuffix", "hexToByte", "", SubInfo.KEY_FORMAT, "Lkotlin/text/HexFormat;", "hexToByteArray", "hexToByteArrayNoLineAndGroupSeparator", "bytesFormat", "Lkotlin/text/HexFormat$BytesHexFormat;", "hexToByteArrayNoLineAndGroupSeparatorSlowPath", "hexToByteArrayShortByteSeparatorNoPrefixAndSuffix", "hexToByteArraySlowPath", "hexToInt", "hexToIntImpl", "hexToLong", "hexToLongImpl", "hexToShort", "", "longDecimalFromHexDigitAt", "parseByteAt", "parseInt", "parseLong", "throwInvalidDigitAt", "", "throwInvalidNumberOfDigits", "requireMaxLength", "throwInvalidPrefixSuffix", "throwNotContainedAt", "toCharArrayIfNotEmpty", "toHexString", "toHexStringImpl", "numberFormat", "Lkotlin/text/HexFormat$NumberHexFormat;", "digits", "bits", "toHexStringNoLineAndGroupSeparator", "toHexStringNoLineAndGroupSeparatorSlowPath", "toHexStringShortByteSeparatorNoPrefixAndSuffix", "toHexStringSlowPath", "kotlin-stdlib"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class HexExtensionsKt {
    private static final int[] BYTE_TO_LOWER_CASE_HEX_DIGITS = null;
    private static final int[] BYTE_TO_UPPER_CASE_HEX_DIGITS = null;
    private static final int[] HEX_DIGITS_TO_DECIMAL = null;
    private static final long[] HEX_DIGITS_TO_LONG_DECIMAL = null;
    private static final String LOWER_CASE_HEX_DIGITS = "0123456789abcdef";
    private static final String UPPER_CASE_HEX_DIGITS = "0123456789ABCDEF";

    static {
        int[] r100 = new int[256];
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r102 >= 256) goto L6;
        r100[r102] = LOWER_CASE_HEX_DIGITS.charAt(r102 & 15) | (LOWER_CASE_HEX_DIGITS.charAt(r102 >> 4) << '\b');
        r102 = r102 + 1;
        goto L4
    L6:
        BYTE_TO_LOWER_CASE_HEX_DIGITS = r100;
        int[] r103 = new int[256];
        int r104 = 0;
    L8:
        if (r104 >= 256) goto L10;
        r103[r104] = UPPER_CASE_HEX_DIGITS.charAt(r104 & 15) | (UPPER_CASE_HEX_DIGITS.charAt(r104 >> 4) << '\b');
        r104 = r104 + 1;
        goto L8
    L10:
        BYTE_TO_UPPER_CASE_HEX_DIGITS = r103;
        int[] r105 = new int[256];
        int r106 = 0;
    L11:
        if (r106 >= 256) goto L13;
        r105[r106] = -1;
        r106 = r106 + 1;
        goto L11
    L13:
        int r107 = 0;
        int r108 = 0;
    L15:
        if (r107 >= LOWER_CASE_HEX_DIGITS.length()) goto L17;
        r105[LOWER_CASE_HEX_DIGITS.charAt(r107)] = r108;
        r107 = r107 + 1;
        r108 = r108 + 1;
        goto L15
    L17:
        int r109 = 0;
        int r110 = 0;
    L19:
        if (r109 >= UPPER_CASE_HEX_DIGITS.length()) goto L21;
        r105[UPPER_CASE_HEX_DIGITS.charAt(r109)] = r110;
        r109 = r109 + 1;
        r110 = r110 + 1;
        goto L19
    L21:
        HEX_DIGITS_TO_DECIMAL = r105;
        long[] r111 = new long[256];
        int r112 = 0;
    L22:
        if (r112 >= 256) goto L24;
        r111[r112] = -1;
        r112 = r112 + 1;
        goto L22
    L24:
        int r113 = 0;
        int r114 = 0;
    L26:
        if (r113 >= LOWER_CASE_HEX_DIGITS.length()) goto L28;
        r111[LOWER_CASE_HEX_DIGITS.charAt(r113)] = r114;
        r113 = r113 + 1;
        r114 = r114 + 1;
        goto L26
    L28:
        int r115 = 0;
    L30:
        if (r101 >= UPPER_CASE_HEX_DIGITS.length()) goto L32;
        r111[UPPER_CASE_HEX_DIGITS.charAt(r101)] = r115;
        r101 = r101 + 1;
        r115 = r115 + 1;
        goto L30
    L32:
        HEX_DIGITS_TO_LONG_DECIMAL = r111;
    }

    private static final int checkFormatLength(long r100) {
        boolean r101 = false;
        if (0 <= r100) goto L5;
    L7:
        if (r101 == false) goto L11;
        return (int) r100;
    L11:
        throw new IllegalArgumentException("The resulting string length is too big: " + ULong.m9669toStringimpl(ULong.m9623constructorimpl(r100)));
    L5:
        if (r100 > SieveCacheKt.NodeLinkMask) goto L7;
        r101 = true;
        goto L7
    }

    private static final int decimalFromHexDigitAt(String r100, int r101) {
        char r102 = r100.charAt(r101);
        if ((r102 >>> '\b') != 0) goto L7;
        int r103 = HEX_DIGITS_TO_DECIMAL[r102];
        if (r103 < 0) goto L7;
        return r103;
    L7:
        throwInvalidDigitAt(r100, r101);
        throw new KotlinNothingValueException();
    }

    public static final byte hexToByte(String r100, HexFormat r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return hexToByte(r100, 0, r100.length(), r101);
    }

    public static final byte[] hexToByteArray(String r100, HexFormat r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return hexToByteArray(r100, 0, r100.length(), r101);
    }

    public static final int hexToInt(String r100, HexFormat r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return hexToInt(r100, 0, r100.length(), r101);
    }

    public static final long hexToLong(String r100, HexFormat r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return hexToLong(r100, 0, r100.length(), r101);
    }

    public static final short hexToShort(String r100, HexFormat r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return hexToShort(r100, 0, r100.length(), r101);
    }

    private static final long longDecimalFromHexDigitAt(String r100, int r101) {
        char r102 = r100.charAt(r101);
        if ((r102 >>> '\b') != 0) goto L7;
        long r103 = HEX_DIGITS_TO_LONG_DECIMAL[r102];
        if (r103 < 0) goto L7;
        return r103;
    L7:
        throwInvalidDigitAt(r100, r101);
        throw new KotlinNothingValueException();
    }

    private static final byte parseByteAt(String r100, int r101) {
        char r102 = r100.charAt(r101);
        if ((r102 >>> '\b') != 0) goto L14;
        int[] r103 = HEX_DIGITS_TO_DECIMAL;
        int r104 = r103[r102];
        if (r104 < 0) goto L14;
        int r105 = r101 + 1;
        char r106 = r100.charAt(r105);
        if ((r106 >>> '\b') != 0) goto L12;
        int r107 = r103[r106];
        if (r107 < 0) goto L12;
        return (byte) ((r104 << 4) | r107);
    L12:
        throwInvalidDigitAt(r100, r105);
        throw new KotlinNothingValueException();
    L14:
        throwInvalidDigitAt(r100, r101);
        throw new KotlinNothingValueException();
    }

    private static final Void throwInvalidDigitAt(String r100, int r101) {
        throw new NumberFormatException("Expected a hexadecimal digit at index " + r101 + ", but was " + r100.charAt(r101));
    }

    public static final String toHexString(long r110, HexFormat r111) {
        Intrinsics.checkNotNullParameter(r111, SubInfo.KEY_FORMAT);
        if (r111.getUpperCase() == false) goto L5;
        String r100 = UPPER_CASE_HEX_DIGITS;
    L6:
        HexFormat.NumberHexFormat r112 = r111.getNumber();
        if (r112.isDigitsOnly$kotlin_stdlib() == false) goto L14;
        char[] r101 = {r100.charAt((int) ((r110 >> 60) & 15)), r100.charAt((int) ((r110 >> 56) & 15)), r100.charAt((int) ((r110 >> 52) & 15)), r100.charAt((int) ((r110 >> 48) & 15)), r100.charAt((int) ((r110 >> 44) & 15)), r100.charAt((int) ((r110 >> 40) & 15)), r100.charAt((int) ((r110 >> 36) & 15)), r100.charAt((int) ((r110 >> 32) & 15)), r100.charAt((int) ((r110 >> 28) & 15)), r100.charAt((int) ((r110 >> 24) & 15)), r100.charAt((int) ((r110 >> 20) & 15)), r100.charAt((int) ((r110 >> 16) & 15)), r100.charAt((int) ((r110 >> 12) & 15)), r100.charAt((int) ((r110 >> 8) & 15)), r100.charAt((int) ((r110 >> 4) & 15)), r100.charAt((int) (15 & r110))};
        if (r112.getRemoveLeadingZeros() == false) goto L12;
        return StringsKt__StringsJVMKt.concatToString$default(r101, RangesKt.coerceAtMost(Long.numberOfLeadingZeros(r110) >> 2, 15), 0, 2, null);
    L12:
        return StringsKt.concatToString(r101);
    L14:
        return toHexStringImpl(r110, r112, r100, 64);
    L5:
        r100 = LOWER_CASE_HEX_DIGITS;
        goto L6
    }

    public static final String toHexString(int r100, HexFormat r101) {
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        if (r101.getUpperCase() == false) goto L5;
        String r102 = UPPER_CASE_HEX_DIGITS;
    L6:
        HexFormat.NumberHexFormat r103 = r101.getNumber();
        if (r103.isDigitsOnly$kotlin_stdlib() == false) goto L14;
        char[] r104 = {r102.charAt((r100 >> 28) & 15), r102.charAt((r100 >> 24) & 15), r102.charAt((r100 >> 20) & 15), r102.charAt((r100 >> 16) & 15), r102.charAt((r100 >> 12) & 15), r102.charAt((r100 >> 8) & 15), r102.charAt((r100 >> 4) & 15), r102.charAt(r100 & 15)};
        if (r103.getRemoveLeadingZeros() == false) goto L12;
        return StringsKt__StringsJVMKt.concatToString$default(r104, RangesKt.coerceAtMost(Integer.numberOfLeadingZeros(r100) >> 2, 7), 0, 2, null);
    L12:
        return StringsKt.concatToString(r104);
    L14:
        return toHexStringImpl(r100, r103, r102, 32);
    L5:
        r102 = LOWER_CASE_HEX_DIGITS;
        goto L6
    }

    public static final String toHexString(short r100, HexFormat r101) {
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        if (r101.getUpperCase() == false) goto L5;
        String r102 = UPPER_CASE_HEX_DIGITS;
    L6:
        HexFormat.NumberHexFormat r103 = r101.getNumber();
        if (r103.isDigitsOnly$kotlin_stdlib() == false) goto L14;
        char[] r104 = {r102.charAt((r100 >> 12) & 15), r102.charAt((r100 >> 8) & 15), r102.charAt((r100 >> 4) & 15), r102.charAt(r100 & 15)};
        if (r103.getRemoveLeadingZeros() == false) goto L12;
        return StringsKt__StringsJVMKt.concatToString$default(r104, RangesKt.coerceAtMost((Integer.numberOfLeadingZeros(r100 & 65535) - 16) >> 2, 3), 0, 2, null);
    L12:
        return StringsKt.concatToString(r104);
    L14:
        return toHexStringImpl(r100, r103, r102, 16);
    L5:
        r102 = LOWER_CASE_HEX_DIGITS;
        goto L6
    }

    public static final String toHexString(byte r100, HexFormat r101) {
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        if (r101.getUpperCase() == false) goto L5;
        String r102 = UPPER_CASE_HEX_DIGITS;
    L6:
        HexFormat.NumberHexFormat r103 = r101.getNumber();
        if (r103.isDigitsOnly$kotlin_stdlib() == false) goto L14;
        char[] r104 = {r102.charAt((r100 >> 4) & 15), r102.charAt(r100 & 15)};
        if (r103.getRemoveLeadingZeros() == false) goto L12;
        return StringsKt__StringsJVMKt.concatToString$default(r104, RangesKt.coerceAtMost((Integer.numberOfLeadingZeros(r100 & UByte.MAX_VALUE) - 24) >> 2, 1), 0, 2, null);
    L12:
        return StringsKt.concatToString(r104);
    L14:
        return toHexStringImpl(r100, r103, r102, 8);
    L5:
        r102 = LOWER_CASE_HEX_DIGITS;
        goto L6
    }

    public static final String toHexString(byte[] r100, HexFormat r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, SubInfo.KEY_FORMAT);
        return toHexString(r100, 0, r100.length, r101);
    }

    private static final long charsPerSet(long r100, int r101, int r102) {
        if (r101 <= 0) goto L4;
        boolean r103 = true;
    L5:
        if (r103 == false) goto L9;
        long r104 = r101;
        return (r100 * r104) + (((long) r102) * (r104 - 1));
    L9:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L4:
        r103 = false;
        goto L5
    }

    private static final int checkNewLineAt(String r100, int r101, int r102) {
        if (r100.charAt(r101) != '\r') goto L10;
        int r103 = r101 + 1;
        if (r103 < r102) goto L7;
        return r103;
    L7:
        if (r100.charAt(r103) == '\n') goto L17;
        return r103;
    L17:
        return r101 + 2;
    L10:
        if (r100.charAt(r101) != '\n') goto L14;
        return r101 + 1;
    L14:
        throw new NumberFormatException("Expected a new line at index " + r101 + ", but was " + r100.charAt(r101));
    }

    private static final int parseInt(String r100, int r101, int r102) {
        int r103 = 0;
    L3:
        if (r101 >= r102) goto L11;
        int r104 = r103 << 4;
        char r105 = r100.charAt(r101);
        if ((r105 >>> '\b') != 0) goto L9;
        int r106 = HEX_DIGITS_TO_DECIMAL[r105];
        if (r106 < 0) goto L9;
        r103 = r104 | r106;
        r101 = r101 + 1;
    L9:
        throwInvalidDigitAt(r100, r101);
        throw new KotlinNothingValueException();
    L11:
        return r103;
    }

    private static final long parseLong(String r100, int r101, int r102) {
        long r103 = 0;
    L3:
        if (r101 >= r102) goto L11;
        long r104 = r103 << 4;
        char r105 = r100.charAt(r101);
        if ((r105 >>> '\b') != 0) goto L9;
        long r106 = HEX_DIGITS_TO_LONG_DECIMAL[r105];
        if (r106 < 0) goto L9;
        r103 = r104 | r106;
        r101 = r101 + 1;
    L9:
        throwInvalidDigitAt(r100, r101);
        throw new KotlinNothingValueException();
    L11:
        return r103;
    }

    private static final int toCharArrayIfNotEmpty(String r100, char[] r101, int r102) {
        int r103 = r100.length();
        if (r103 == 0) goto L9;
        if (r103 == 1) goto L7;
        int r104 = r100.length();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type java.lang.String");
        r100.getChars(0, r104, r101, r102);
        goto L9
    L7:
        r101[r102] = r100.charAt(0);
    L9:
        return r102 + r100.length();
    }

    private static final long wholeElementsPerSet(long r100, long r101, int r102) {
        if (r100 > 0) goto L5;
        return 0;
    L5:
        if (r101 <= 0) goto L10;
        long r103 = r102;
        return (r100 + r103) / (r101 + r103);
    L10:
        return 0;
    }

    private static final void checkMaxDigits(String r100, int r101, int r102, int r103) {
        if (r101 < r102) goto L4;
    L5:
        throwInvalidNumberOfDigits(r100, r101, r102, r103, false);
        return;
    L4:
        if ((r102 - r101) > r103) goto L5;
    }

    private static final int formattedStringLength(int r100, int r101, int r102, int r103) {
        if (r100 <= 0) goto L4;
        boolean r104 = true;
    L5:
        if (r104 == false) goto L9;
        long r105 = r101;
        return checkFormatLength((r100 * (((((long) r102) + 2) + ((long) r103)) + r105)) - r105);
    L9:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L4:
        r104 = false;
        goto L5
    }

    private static final byte hexToByte(String r100, int r101, int r102, HexFormat r103) {
        return (byte) hexToIntImpl(r100, r101, r102, r103, 2);
    }

    public static /* synthetic */ byte hexToByte$default(String r100, HexFormat r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = HexFormat.Companion.getDefault();
    L6:
        return hexToByte(r100, r101);
    }

    private static final byte[] hexToByteArray(String r100, int r101, int r102, HexFormat r103) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r101, r102, r100.length());
        if (r101 == r102) goto L5;
        HexFormat.BytesHexFormat r104 = r103.getBytes();
        if (r104.getNoLineAndGroupSeparator$kotlin_stdlib() == false) goto L12;
        byte[] r105 = hexToByteArrayNoLineAndGroupSeparator(r100, r101, r102, r104);
        if (r105 == null) goto L12;
        return r105;
    L12:
        return hexToByteArraySlowPath(r100, r101, r102, r104);
    L5:
        return new byte[0];
    }

    public static /* synthetic */ byte[] hexToByteArray$default(String r100, HexFormat r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = HexFormat.Companion.getDefault();
    L6:
        return hexToByteArray(r100, r101);
    }

    private static final byte[] hexToByteArrayNoLineAndGroupSeparator(String r100, int r101, int r102, HexFormat.BytesHexFormat r103) {
        if (r103.getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib() == false) goto L7;
        return hexToByteArrayShortByteSeparatorNoPrefixAndSuffix(r100, r101, r102, r103);
    L7:
        return hexToByteArrayNoLineAndGroupSeparatorSlowPath(r100, r101, r102, r103);
    }

    private static final byte[] hexToByteArrayNoLineAndGroupSeparatorSlowPath(String r110, int r111, int r112, HexFormat.BytesHexFormat r113) {
        String r100 = r113.getBytePrefix();
        String r101 = r113.getByteSuffix();
        String r102 = r113.getByteSeparator();
        int r103 = r102.length();
        long r104 = r103;
        long r105 = ((((long) r100.length()) + 2) + ((long) r101.length())) + r104;
        long r106 = r112 - r111;
        int r107 = (int) ((r106 + r104) / r105);
        if (((((long) r107) * r105) - r104) == r106) goto L6;
        return null;
    L6:
        boolean r114 = r113.getIgnoreCase$kotlin_stdlib();
        byte[] r108 = new byte[r107];
        int r109 = 0;
        boolean r115 = true;
        if (r100.length() != 0) goto L9;
        boolean r116 = true;
    L10:
        if (r116 == true) goto L19;
        int r117 = r100.length();
        int r118 = 0;
    L13:
        if (r118 >= r117) goto L18;
        if (CharsKt.equals(r100.charAt(r118), r110.charAt(r111 + r118), r114) == true) goto L17;
        throwNotContainedAt(r110, r111, r112, r100, "byte prefix");
    L17:
        r118 = r118 + 1;
        goto L13
    L18:
        r111 = r111 + r100.length();
    L19:
        String r119 = r101 + r102 + r100;
        int r120 = r107 - 1;
        int r121 = 0;
    L20:
        if (r121 >= r120) goto L35;
        r108[r121] = parseByteAt(r110, r111);
        r111 = r111 + 2;
        if (r119.length() != 0) goto L24;
        boolean r122 = true;
    L25:
        if (r122 == true) goto L34;
        int r123 = r119.length();
        int r124 = 0;
    L28:
        if (r124 >= r123) goto L33;
        if (CharsKt.equals(r119.charAt(r124), r110.charAt(r111 + r124), r114) == true) goto L32;
        throwNotContainedAt(r110, r111, r112, r119, "byte suffix + byte separator + byte prefix");
    L32:
        r124 = r124 + 1;
        goto L28
    L33:
        r111 = r111 + r119.length();
    L34:
        r121 = r121 + 1;
        goto L20
    L24:
        r122 = false;
        goto L25
    L35:
        r108[r120] = parseByteAt(r110, r111);
        int r125 = r111 + 2;
        if (r101.length() == 0) goto L39;
        r115 = false;
    L39:
        if (r115 == true) goto L46;
        int r126 = r101.length();
    L41:
        if (r109 >= r126) goto L46;
        if (CharsKt.equals(r101.charAt(r109), r110.charAt(r125 + r109), r114) == true) goto L45;
        throwNotContainedAt(r110, r125, r112, r101, "byte suffix");
    L45:
        r109 = r109 + 1;
    L46:
        return r108;
    L9:
        r116 = false;
        goto L10
    }

    private static final byte[] hexToByteArrayShortByteSeparatorNoPrefixAndSuffix(String r110, int r111, int r112, HexFormat.BytesHexFormat r113) {
        int r100 = r113.getByteSeparator().length();
        int r101 = 0;
        if (r100 > 1) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == false) goto L38;
        int r114 = r112 - r111;
        int r103 = 2;
        if (r100 != 0) goto L17;
        if ((r114 & 1) == 0) goto L12;
        return null;
    L12:
        int r115 = r114 >> 1;
        byte[] r116 = new byte[r115];
        int r117 = 0;
    L13:
        if (r101 >= r115) goto L15;
        r116[r101] = parseByteAt(r110, r117);
        r117 = r117 + 2;
        r101 = r101 + 1;
        goto L13
    L15:
        return r116;
    L17:
        if ((r114 % 3) == 2) goto L19;
        return null;
    L19:
        int r118 = (r114 / 3) + 1;
        byte[] r104 = new byte[r118];
        char r105 = r113.getByteSeparator().charAt(0);
        r104[0] = parseByteAt(r110, 0);
        int r106 = 1;
    L20:
        if (r106 >= r118) goto L36;
        if (r110.charAt(r103) == r105) goto L35;
        String r107 = r113.getByteSeparator();
        boolean r108 = r113.getIgnoreCase$kotlin_stdlib();
        if (r107.length() != 0) goto L26;
        boolean r109 = true;
    L27:
        if (r109 == true) goto L35;
        int r119 = r107.length();
        int r120 = 0;
    L29:
        if (r120 >= r119) goto L34;
        if (CharsKt.equals(r107.charAt(r120), r110.charAt(r103 + r120), r108) == true) goto L33;
        throwNotContainedAt(r110, r103, r112, r107, "byte separator");
    L33:
        r120 = r120 + 1;
        goto L29
    L34:
        r107.length();
        goto L35
    L26:
        r109 = false;
    L35:
        r104[r106] = parseByteAt(r110, r103 + 1);
        r103 = r103 + 3;
        r106 = r106 + 1;
        goto L20
    L36:
        return r104;
    L38:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r102 = false;
        goto L6
    }

    private static final byte[] hexToByteArraySlowPath(String r110, int r210, int r211, HexFormat.BytesHexFormat r212) {
        int r100 = r212.getBytesPerLine();
        int r111 = r212.getBytesPerGroup();
        String r112 = r212.getBytePrefix();
        String r113 = r212.getByteSuffix();
        String r114 = r212.getByteSeparator();
        String r115 = r212.getGroupSeparator();
        boolean r116 = r212.getIgnoreCase$kotlin_stdlib();
        int r101 = parsedByteArrayMaxSize(r211 - r210, r100, r111, r115.length(), r114.length(), r112.length(), r113.length());
        byte[] r102 = new byte[r101];
        int r103 = r210;
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r103 >= r211) goto L71;
        if (r105 != r100) goto L7;
        r103 = checkNewLineAt(r110, r103, r211);
        int r107 = 1;
        int r117 = 0;
    L6:
        r106 = 0;
    L40:
        int r108 = r117 + r107;
        int r109 = r106 + r107;
        if (r112.length() != 0) goto L43;
        boolean r118 = true;
    L44:
        if (r118 == false) goto L46;
        int r119 = r109;
    L54:
        if ((r211 - 2) >= r103) goto L56;
        boolean r120 = true;
        throwInvalidNumberOfDigits(r110, r103, r211, 2, true);
    L57:
        int r121 = r104 + 1;
        r102[r104] = parseByteAt(r110, r103);
        r103 = r103 + 2;
        if (r113.length() == 0) goto L61;
        r120 = false;
    L61:
        if (r120 == false) goto L63;
        int r213 = r121;
    L70:
        r104 = r213;
        r105 = r108;
        r106 = r119;
        goto L3
    L63:
        int r122 = r113.length();
        int r123 = 0;
    L64:
        if (r123 >= r122) goto L69;
        int r214 = r121;
        if (CharsKt.equals(r113.charAt(r123), r110.charAt(r103 + r123), r116) == true) goto L68;
        throwNotContainedAt(r110, r103, r211, r113, "byte suffix");
    L68:
        r123 = r123 + 1;
        r121 = r214;
        goto L64
    L69:
        r213 = r121;
        r103 = r103 + r113.length();
        goto L70
    L56:
        r120 = true;
        goto L57
    L46:
        int r124 = r112.length();
        int r125 = 0;
    L47:
        if (r125 >= r124) goto L52;
        int r126 = r124;
        int r127 = r109;
        if (CharsKt.equals(r112.charAt(r125), r110.charAt(r103 + r125), r116) == true) goto L51;
        throwNotContainedAt(r110, r103, r211, r112, "byte prefix");
    L51:
        r125 = r125 + 1;
        r124 = r126;
        r109 = r127;
        goto L47
    L52:
        r119 = r109;
        r103 = r103 + r112.length();
        goto L54
    L43:
        r118 = false;
        goto L44
    L7:
        if (r106 == r111) goto L9;
        r117 = r105;
        if (r106 == 0) goto L39;
        if (r114.length() != 0) goto L27;
        boolean r128 = true;
    L28:
        if (r128 == false) goto L30;
        int r129 = r106;
    L37:
        r106 = r129;
        goto L39
    L30:
        int r130 = r114.length();
        int r131 = 0;
    L31:
        if (r131 >= r130) goto L36;
        int r132 = r130;
        int r133 = r106;
        if (CharsKt.equals(r114.charAt(r131), r110.charAt(r103 + r131), r116) == true) goto L35;
        throwNotContainedAt(r110, r103, r211, r114, "byte separator");
    L35:
        r131 = r131 + 1;
        r130 = r132;
        r106 = r133;
        goto L31
    L36:
        r129 = r106;
        r103 = r103 + r114.length();
        goto L37
    L27:
        r128 = false;
    L39:
        r107 = 1;
        goto L40
    L9:
        if (r115.length() != 0) goto L11;
        boolean r134 = true;
    L12:
        if (r134 == false) goto L14;
        int r135 = r105;
    L21:
        r117 = r135;
        r107 = 1;
        goto L6
    L14:
        int r136 = r115.length();
        int r137 = 0;
    L15:
        if (r137 >= r136) goto L20;
        int r138 = r105;
        int r139 = r136;
        if (CharsKt.equals(r115.charAt(r137), r110.charAt(r103 + r137), r116) == true) goto L19;
        throwNotContainedAt(r110, r103, r211, r115, "group separator");
    L19:
        r137 = r137 + 1;
        r105 = r138;
        r136 = r139;
        goto L15
    L20:
        r135 = r105;
        r103 = r103 + r115.length();
        goto L21
    L11:
        r134 = false;
        goto L12
    L71:
        if (r104 != r101) goto L74;
        return r102;
    L74:
        return Arrays.copyOf(r102, r104);
    }

    private static final int hexToInt(String r100, int r101, int r102, HexFormat r103) {
        return hexToIntImpl(r100, r101, r102, r103, 8);
    }

    public static /* synthetic */ int hexToInt$default(String r100, HexFormat r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = HexFormat.Companion.getDefault();
    L6:
        return hexToInt(r100, r101);
    }

    private static final long hexToLong(String r100, int r101, int r102, HexFormat r103) {
        return hexToLongImpl(r100, r101, r102, r103, 16);
    }

    public static /* synthetic */ long hexToLong$default(String r100, HexFormat r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = HexFormat.Companion.getDefault();
    L6:
        return hexToLong(r100, r101);
    }

    private static final short hexToShort(String r100, int r101, int r102, HexFormat r103) {
        return (short) hexToIntImpl(r100, r101, r102, r103, 4);
    }

    public static /* synthetic */ short hexToShort$default(String r100, HexFormat r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = HexFormat.Companion.getDefault();
    L6:
        return hexToShort(r100, r101);
    }

    public static final String toHexString(byte[] r100, int r101, int r102, HexFormat r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r103, SubInfo.KEY_FORMAT);
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r101, r102, r100.length);
        if (r101 != r102) goto L7;
        return "";
    L7:
        if (r103.getUpperCase() == false) goto L9;
        int[] r104 = BYTE_TO_UPPER_CASE_HEX_DIGITS;
    L10:
        HexFormat.BytesHexFormat r105 = r103.getBytes();
        if (r105.getNoLineAndGroupSeparator$kotlin_stdlib() == false) goto L15;
        return toHexStringNoLineAndGroupSeparator(r100, r101, r102, r105, r104);
    L15:
        return toHexStringSlowPath(r100, r101, r102, r105, r104);
    L9:
        r104 = BYTE_TO_LOWER_CASE_HEX_DIGITS;
        goto L10
    }

    public static /* synthetic */ String toHexString$default(byte r100, HexFormat r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r100, r101);
    }

    private static final String toHexStringImpl(long r110, HexFormat.NumberHexFormat r111, String r112, int r113) {
        if ((r113 & 3) != 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L25;
        int r101 = r113 >> 2;
        String r102 = r111.getPrefix();
        String r103 = r111.getSuffix();
        boolean r104 = r111.getRemoveLeadingZeros();
        int r105 = checkFormatLength((((long) r102.length()) + ((long) r101)) + ((long) r103.length()));
        char[] r106 = new char[r105];
        boolean r107 = r104;
        int r108 = 0;
        int r109 = toCharArrayIfNotEmpty(r102, r106, 0);
        int r114 = r113;
    L8:
        if (r108 >= r101) goto L19;
        r114 = r114 - 4;
        int r115 = (int) ((r110 >> r114) & 15);
        if (r107 == false) goto L14;
        if (r115 != 0) goto L14;
        if (r114 <= 0) goto L14;
        r107 = true;
    L15:
        if (r107 == true) goto L18;
        r106[r109] = r112.charAt(r115);
        r109 = r109 + 1;
    L18:
        r108 = r108 + 1;
    L14:
        r107 = false;
        goto L15
    L19:
        int r116 = toCharArrayIfNotEmpty(r103, r106, r109);
        if (r116 != r105) goto L23;
        return StringsKt.concatToString(r106);
    L23:
        return StringsKt__StringsJVMKt.concatToString$default(r106, 0, r116, 1, null);
    L25:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r100 = false;
        goto L6
    }

    public static /* synthetic */ String toHexString$default(int r100, HexFormat r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r100, r101);
    }

    public static /* synthetic */ String toHexString$default(long r100, HexFormat r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r100, r101);
    }

    public static /* synthetic */ String toHexString$default(short r100, HexFormat r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r100, r101);
    }

    public static /* synthetic */ String toHexString$default(byte[] r100, HexFormat r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = HexFormat.Companion.getDefault();
    L6:
        return toHexString(r100, r101);
    }

    private static final int formatByteAt(byte[] r100, int r101, int[] r102, char[] r103, int r104) {
        int r105 = r102[r100[r101] & UByte.MAX_VALUE];
        r103[r104] = (char) (r105 >> 8);
        r103[r104 + 1] = (char) (r105 & 255);
        return r104 + 2;
    }

    private static final int hexToIntImpl(String r100, int r110, int r111, HexFormat r112, int r113) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r110, r111, r100.length());
        HexFormat.NumberHexFormat r114 = r112.getNumber();
        if (r114.isDigitsOnly$kotlin_stdlib() == false) goto L6;
        checkMaxDigits(r100, r110, r111, r113);
        return parseInt(r100, r110, r111);
    L6:
        String r101 = r114.getPrefix();
        String r102 = r114.getSuffix();
        checkPrefixSuffixMaxDigits(r100, r110, r111, r101, r102, r114.getIgnoreCase$kotlin_stdlib(), r113);
        return parseInt(r100, r110 + r101.length(), r111 - r102.length());
    }

    private static final long hexToLongImpl(String r100, int r110, int r111, HexFormat r112, int r113) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r110, r111, r100.length());
        HexFormat.NumberHexFormat r114 = r112.getNumber();
        if (r114.isDigitsOnly$kotlin_stdlib() == false) goto L6;
        checkMaxDigits(r100, r110, r111, r113);
        return parseLong(r100, r110, r111);
    L6:
        String r101 = r114.getPrefix();
        String r102 = r114.getSuffix();
        checkPrefixSuffixMaxDigits(r100, r110, r111, r101, r102, r114.getIgnoreCase$kotlin_stdlib(), r113);
        return parseLong(r100, r110 + r101.length(), r111 - r102.length());
    }

    private static final void throwInvalidNumberOfDigits(String r100, int r101, int r102, int r103, boolean r104) {
        if (r104 == false) goto L4;
        String r105 = "exactly";
    L5:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type java.lang.String");
        throw new NumberFormatException("Expected " + r105 + ' ' + r103 + " hexadecimal digits at index " + r101 + ", but was " + r100.substring(r101, r102) + " of length " + (r102 - r101));
    L4:
        r105 = "at most";
        goto L5
    }

    private static final void throwInvalidPrefixSuffix(String r100, int r101, int r102, String r103, String r104) {
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type java.lang.String");
        throw new NumberFormatException("Expected a hexadecimal number with prefix \"" + r103 + "\" and suffix \"" + r104 + "\", but was " + r100.substring(r101, r102));
    }

    private static final void throwNotContainedAt(String r100, int r101, int r102, String r103, String r104) {
        int r105 = RangesKt.coerceAtMost(r103.length() + r101, r102);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type java.lang.String");
        throw new NumberFormatException("Expected " + r104 + " \"" + r103 + "\" at index " + r101 + ", but was " + r100.substring(r101, r105));
    }

    private static final String toHexStringNoLineAndGroupSeparator(byte[] r100, int r101, int r102, HexFormat.BytesHexFormat r103, int[] r104) {
        if (r103.getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib() == false) goto L7;
        return toHexStringShortByteSeparatorNoPrefixAndSuffix(r100, r101, r102, r103, r104);
    L7:
        return toHexStringNoLineAndGroupSeparatorSlowPath(r100, r101, r102, r103, r104);
    }

    private static final String toHexStringNoLineAndGroupSeparatorSlowPath(byte[] r110, int r111, int r112, HexFormat.BytesHexFormat r113, int[] r114) {
        String r100 = r113.getBytePrefix();
        String r101 = r113.getByteSuffix();
        String r115 = r113.getByteSeparator();
        char[] r102 = new char[formattedStringLength(r112 - r111, r115.length(), r100.length(), r101.length())];
        int r103 = formatByteAt(r110, r111, r100, r101, r114, r102, 0);
    L3:
        r111 = r111 + 1;
        if (r111 >= r112) goto L7;
        r103 = formatByteAt(r110, r111, r100, r101, r114, r102, toCharArrayIfNotEmpty(r115, r102, r103));
        goto L3
    L7:
        return StringsKt.concatToString(r102);
    }

    private static final String toHexStringShortByteSeparatorNoPrefixAndSuffix(byte[] r100, int r101, int r110, HexFormat.BytesHexFormat r111, int[] r112) {
        int r102 = r111.getByteSeparator().length();
        int r103 = 0;
        if (r102 > 1) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L20;
        int r105 = r110 - r101;
        if (r102 != 0) goto L14;
        char[] r113 = new char[checkFormatLength(((long) r105) * 2)];
    L10:
        if (r101 >= r110) goto L13;
        r103 = formatByteAt(r100, r101, r112, r113, r103);
        r101 = r101 + 1;
        goto L10
    L13:
        return StringsKt.concatToString(r113);
    L14:
        char[] r106 = new char[checkFormatLength((((long) r105) * 3) - 1)];
        char r114 = r111.getByteSeparator().charAt(0);
        int r107 = formatByteAt(r100, r101, r112, r106, 0);
        int r108 = r101 + 1;
    L15:
        if (r108 >= r110) goto L18;
        r106[r107] = r114;
        r107 = formatByteAt(r100, r108, r112, r106, r107 + 1);
        r108 = r108 + 1;
        goto L15
    L18:
        return StringsKt.concatToString(r106);
    L20:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r104 = false;
        goto L6
    }

    private static final String toHexStringSlowPath(byte[] r210, int r211, int r212, HexFormat.BytesHexFormat r213, int[] r214) {
        int r100 = r213.getBytesPerLine();
        int r101 = r213.getBytesPerGroup();
        String r110 = r213.getBytePrefix();
        String r111 = r213.getByteSuffix();
        String r112 = r213.getByteSeparator();
        String r113 = r213.getGroupSeparator();
        int r114 = formattedStringLength(r212 - r211, r100, r101, r113.length(), r112.length(), r110.length(), r111.length());
        char[] r115 = new char[r114];
        boolean r116 = false;
        int r102 = r211;
        int r103 = 0;
        int r104 = 0;
        int r105 = 0;
    L4:
        if (r102 >= r212) goto L14;
        if (r104 != r100) goto L8;
        r115[r103] = '\n';
        r103 = r103 + 1;
        int r117 = 0;
    L7:
        int r118 = 0;
    L11:
        if (r118 == 0) goto L13;
        r103 = toCharArrayIfNotEmpty(r112, r115, r103);
    L13:
        int r106 = r102;
        r103 = formatByteAt(r210, r106, r110, r111, r214, r115, r103);
        r105 = r118 + 1;
        r104 = r117 + 1;
        r102 = r102 + 1;
        goto L4
    L8:
        if (r105 != r101) goto L10;
        r103 = toCharArrayIfNotEmpty(r113, r115, r103);
        r117 = r104;
        goto L7
    L10:
        r117 = r104;
        r118 = r105;
        goto L11
    L14:
        if (r103 != r114) goto L16;
        r116 = true;
    L16:
        if (r116 == false) goto L20;
        return StringsKt.concatToString(r115);
    L20:
        throw new IllegalStateException("Check failed.".toString());
    }

    private static final int checkContainsAt(String r100, int r101, int r102, String r103, boolean r104, String r105) {
        int r106 = 0;
        if (r103.length() != 0) goto L5;
        boolean r107 = true;
    L6:
        if (r107 == false) goto L8;
        return r101;
    L8:
        int r108 = r103.length();
    L9:
        if (r106 >= r108) goto L15;
        if (CharsKt.equals(r103.charAt(r106), r100.charAt(r101 + r106), r104) == true) goto L13;
        throwNotContainedAt(r100, r101, r102, r103, r105);
    L13:
        r106 = r106 + 1;
        goto L9
    L15:
        return r101 + r103.length();
    L5:
        r107 = false;
        goto L6
    }

    public static /* synthetic */ byte hexToByte$default(String r100, int r101, int r102, HexFormat r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.length();
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = HexFormat.Companion.getDefault();
    L12:
        return hexToByte(r100, r101, r102, r103);
    }

    public static /* synthetic */ byte[] hexToByteArray$default(String r100, int r101, int r102, HexFormat r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.length();
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = HexFormat.Companion.getDefault();
    L12:
        return hexToByteArray(r100, r101, r102, r103);
    }

    public static /* synthetic */ int hexToInt$default(String r100, int r101, int r102, HexFormat r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.length();
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = HexFormat.Companion.getDefault();
    L12:
        return hexToInt(r100, r101, r102, r103);
    }

    public static /* synthetic */ long hexToLong$default(String r100, int r101, int r102, HexFormat r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.length();
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = HexFormat.Companion.getDefault();
    L12:
        return hexToLong(r100, r101, r102, r103);
    }

    public static /* synthetic */ short hexToShort$default(String r100, int r101, int r102, HexFormat r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.length();
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = HexFormat.Companion.getDefault();
    L12:
        return hexToShort(r100, r101, r102, r103);
    }

    public static /* synthetic */ String toHexString$default(byte[] r100, int r101, int r102, HexFormat r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = 0;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.length;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = HexFormat.Companion.getDefault();
    L12:
        return toHexString(r100, r101, r102, r103);
    }

    private static final void checkPrefixSuffixMaxDigits(String r100, int r101, int r102, String r103, String r110, boolean r111, int r112) {
        if (((r102 - r101) - r103.length()) > r110.length()) goto L5;
        throwInvalidPrefixSuffix(r100, r101, r102, r103, r110);
    L5:
        boolean r104 = true;
        int r105 = 0;
        if (r103.length() != 0) goto L8;
        boolean r106 = true;
    L9:
        if (r106 == true) goto L18;
        int r107 = r103.length();
        int r108 = 0;
    L12:
        if (r108 >= r107) goto L17;
        if (CharsKt.equals(r103.charAt(r108), r100.charAt(r101 + r108), r111) == true) goto L16;
        throwNotContainedAt(r100, r101, r102, r103, "prefix");
    L16:
        r108 = r108 + 1;
        goto L12
    L17:
        r101 = r101 + r103.length();
    L18:
        int r109 = r102 - r110.length();
        if (r110.length() == 0) goto L22;
        r104 = false;
    L22:
        if (r104 == true) goto L29;
        int r113 = r110.length();
    L24:
        if (r105 >= r113) goto L29;
        if (CharsKt.equals(r110.charAt(r105), r100.charAt(r109 + r105), r111) == true) goto L28;
        throwNotContainedAt(r100, r109, r102, r110, "suffix");
    L28:
        r105 = r105 + 1;
    L29:
        checkMaxDigits(r100, r101, r109, r112);
        return;
    L8:
        r106 = false;
        goto L9
    }

    private static final int formatByteAt(byte[] r100, int r101, String r102, String r103, int[] r104, char[] r105, int r106) {
        return toCharArrayIfNotEmpty(r103, r105, formatByteAt(r100, r101, r104, r105, toCharArrayIfNotEmpty(r102, r105, r106)));
    }

    public static final int formattedStringLength(int r100, int r101, int r102, int r103, int r110, int r111, int r112) {
        if (r100 <= 0) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L14;
        int r105 = r100 - 1;
        int r106 = r105 / r101;
        int r107 = (r101 - 1) / r102;
        int r108 = r100 % r101;
        if (r108 == 0) goto L11;
        r101 = r108;
    L11:
        int r109 = (r107 * r106) + ((r101 - 1) / r102);
        return checkFormatLength(((((long) r106) + (((long) r109) * ((long) r103))) + (((long) ((r105 - r106) - r109)) * ((long) r110))) + (((long) r100) * ((((long) r111) + 2) + ((long) r112))));
    L14:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r104 = false;
        goto L6
    }

    public static final int parsedByteArrayMaxSize(int r110, int r210, int r211, int r212, int r213, int r214, int r215) {
        if (r110 <= 0) goto L5;
        boolean r100 = true;
    L6:
        if (r100 == false) goto L20;
        long r101 = (((long) r214) + 2) + ((long) r215);
        long r102 = charsPerSet(r101, r211, r213);
        if (r210 > r211) goto L10;
        long r111 = charsPerSet(r101, r210, r213);
    L13:
        long r112 = r110;
        long r113 = wholeElementsPerSet(r112, r111, 1);
        long r114 = r112 - ((r111 + 1) * r113);
        long r115 = wholeElementsPerSet(r114, r102, r212);
        long r116 = r114 - ((r102 + ((long) r212)) * r115);
        long r103 = wholeElementsPerSet(r116, r101, r213);
        if ((r116 - ((r101 + ((long) r213)) * r103)) <= 0) goto L16;
        int r104 = 1;
    L18:
        return (int) (r104 + (((r113 * ((long) r210)) + (r115 * ((long) r211))) + r103));
    L16:
        r104 = 0;
        goto L18
    L10:
        r111 = charsPerSet(r102, r210 / r211, r212);
        int r117 = r210 % r211;
        if (r117 == 0) goto L13;
        r111 = (r111 + ((long) r212)) + charsPerSet(r101, r117, r213);
        goto L13
    L20:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r100 = false;
        goto L6
    }
}
