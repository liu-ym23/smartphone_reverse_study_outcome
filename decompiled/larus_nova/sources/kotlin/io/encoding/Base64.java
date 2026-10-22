package kotlin.io.encoding;

import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.ec.core.event.a;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0017\u0018\u0000 22\u00020\u0001:\u00012B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0015\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000¢\u0006\u0002\b\rJ%\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u0013J \u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0011H\u0002J%\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0002\b\u001bJ\"\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J\"\u0010\u001c\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J0\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J4\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J4\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J \u0010 \u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\"\u0010!\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J4\u0010\"\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J5\u0010#\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0002\b$J\u0010\u0010%\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J=\u0010&\u001a\u0002H'\"\f\b\u0000\u0010'*\u00060(j\u0002`)2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u001e\u001a\u0002H'2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011¢\u0006\u0002\u0010*J\"\u0010+\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0011J%\u0010,\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0000¢\u0006\u0002\b-J(\u0010.\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010/\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u0011H\u0002J \u00101\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002R\u0014\u0010\u0004\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u00063"}, d2 = {"Lkotlin/io/encoding/Base64;", "", "isUrlSafe", "", "isMimeScheme", "(ZZ)V", "isMimeScheme$kotlin_stdlib", "()Z", "isUrlSafe$kotlin_stdlib", "bytesToStringImpl", "", "source", "", "bytesToStringImpl$kotlin_stdlib", "charsToBytesImpl", "", "startIndex", "", "endIndex", "charsToBytesImpl$kotlin_stdlib", "checkDestinationBounds", "", "destinationSize", "destinationOffset", "capacityNeeded", "checkSourceBounds", "sourceSize", "checkSourceBounds$kotlin_stdlib", "decode", "decodeImpl", a.KEY_DESTINATION, "decodeIntoByteArray", "decodeSize", "encode", "encodeIntoByteArray", "encodeIntoByteArrayImpl", "encodeIntoByteArrayImpl$kotlin_stdlib", "encodeSize", "encodeToAppendable", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/lang/Appendable;", "Lkotlin/text/Appendable;", "([BLjava/lang/Appendable;II)Ljava/lang/Appendable;", "encodeToByteArray", "encodeToByteArrayImpl", "encodeToByteArrayImpl$kotlin_stdlib", "handlePaddingSymbol", "padIndex", "byteStart", "skipIllegalSymbolsIfMime", "Default", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
public class Base64 {
    public static final Default Default = null;
    private static final Base64 Mime = null;
    private static final Base64 UrlSafe = null;
    private static final int bitsPerByte = 8;
    private static final int bitsPerSymbol = 6;
    public static final int bytesPerGroup = 3;
    private static final int mimeGroupsPerLine = 19;
    public static final int mimeLineLength = 76;
    private static final byte[] mimeLineSeparatorSymbols = null;
    public static final byte padSymbol = 61;
    public static final int symbolsPerGroup = 4;
    private final boolean isMimeScheme;
    private final boolean isUrlSafe;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u000fX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lkotlin/io/encoding/Base64$Default;", "Lkotlin/io/encoding/Base64;", "()V", "Mime", "getMime", "()Lkotlin/io/encoding/Base64;", "UrlSafe", "getUrlSafe", "bitsPerByte", "", "bitsPerSymbol", "bytesPerGroup", "mimeGroupsPerLine", "mimeLineLength", "mimeLineSeparatorSymbols", "", "getMimeLineSeparatorSymbols$kotlin_stdlib", "()[B", "padSymbol", "", "symbolsPerGroup", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Default extends Base64 {
        private Default() {
            boolean r100 = false;
            super(r100, r100, null);
        }

        public /* synthetic */ Default(DefaultConstructorMarker r100) {
            this();
        }

        public final Base64 getMime() {
            return Base64.access$getMime$cp();
        }

        public final byte[] getMimeLineSeparatorSymbols$kotlin_stdlib() {
            return Base64.access$getMimeLineSeparatorSymbols$cp();
        }

        public final Base64 getUrlSafe() {
            return Base64.access$getUrlSafe$cp();
        }
    }

    public /* synthetic */ Base64(boolean r100, boolean r101, DefaultConstructorMarker r102) {
        this(r100, r101);
    }

    static {
        Default = new Default(null);
        mimeLineSeparatorSymbols = new byte[]{HTTP.CR, 10};
        UrlSafe = new Base64(true, false);
        Mime = new Base64(false, true);
    }

    public static final /* synthetic */ Base64 access$getMime$cp() {
        return Mime;
    }

    public static final /* synthetic */ byte[] access$getMimeLineSeparatorSymbols$cp() {
        return mimeLineSeparatorSymbols;
    }

    public static final /* synthetic */ Base64 access$getUrlSafe$cp() {
        return UrlSafe;
    }

    public final boolean isMimeScheme$kotlin_stdlib() {
        return this.isMimeScheme;
    }

    public final boolean isUrlSafe$kotlin_stdlib() {
        return this.isUrlSafe;
    }

    private final int encodeSize(int r100) {
        int r101 = ((r100 + 3) - 1) / 3;
        if (this.isMimeScheme == false) goto L5;
        int r102 = (r101 - 1) / 19;
    L6:
        int r103 = (r101 * 4) + (r102 * 2);
        if (r103 < 0) goto L10;
        return r103;
    L10:
        throw new IllegalArgumentException("Input is too big");
    L5:
        r102 = 0;
        goto L6
    }

    public final String bytesToStringImpl$kotlin_stdlib(byte[] r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
        StringBuilder r101 = new StringBuilder(r100.length);
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        r101.append((char) r100[r103]);
        r103 = r103 + 1;
        goto L3
    L6:
        return r101.toString();
    }

    private Base64(boolean r100, boolean r101) {
        this.isUrlSafe = r100;
        this.isMimeScheme = r101;
        if (r100 == false) goto L7;
        if (r101 == false) goto L7;
        boolean r102 = false;
    L8:
        if (r102 == false) goto L11;
        return;
    L11:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L7:
        r102 = true;
        goto L8
    }

    private final void checkDestinationBounds(int r100, int r101, int r102) {
        if (r101 < 0) goto L12;
        if (r101 > r100) goto L12;
        int r103 = r101 + r102;
        if (r103 < 0) goto L10;
        if (r103 > r100) goto L10;
        return;
    L10:
        throw new IndexOutOfBoundsException("The destination array does not have enough capacity, destination offset: " + r101 + ", destination size: " + r100 + ", capacity needed: " + r102);
    L12:
        throw new IndexOutOfBoundsException("destination offset: " + r101 + ", destination size: " + r100);
    }

    private final int decodeSize(byte[] r100, int r101, int r102) {
        int r103 = r102 - r101;
        if (r103 != 0) goto L7;
        return 0;
    L7:
        if (r103 == 1) goto L26;
        if (this.isMimeScheme == false) goto L19;
    L10:
        if (r101 >= r102) goto L24;
        int r104 = Base64Kt.access$getBase64DecodeMap$p()[r100[r101] & UByte.MAX_VALUE];
        if (r104 >= 0) goto L17;
        if (r104 == (-2)) goto L15;
        r103 = r103 - 1;
        goto L17
    L15:
        r103 = r103 - (r102 - r101);
    L17:
        r101 = r101 + 1;
    L24:
        return (int) ((((long) r103) * ((long) 6)) / ((long) 8));
    L19:
        if (r100[r102 - 1] != 61) goto L24;
        r103 = r103 - 1;
        if (r100[r102 - 2] != 61) goto L24;
        r103 = r103 - 1;
        goto L24
    L26:
        throw new IllegalArgumentException("Input should have at list 2 symbols for Base64 decoding, startIndex: " + r101 + ", endIndex: " + r102);
    }

    private final int skipIllegalSymbolsIfMime(byte[] r100, int r101, int r102) {
        if (this.isMimeScheme == true) goto L5;
        return r101;
    L5:
        if (r101 >= r102) goto L10;
        int r103 = r100[r101] & UByte.MAX_VALUE;
        if (Base64Kt.access$getBase64DecodeMap$p()[r103] != (-1)) goto L8;
        r101 = r101 + 1;
        goto L5
    L8:
        return r101;
    L10:
        return r101;
    }

    public final byte[] charsToBytesImpl$kotlin_stdlib(CharSequence r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "source");
        checkSourceBounds$kotlin_stdlib(r100.length(), r101, r102);
        byte[] r103 = new byte[r102 - r101];
        int r104 = 0;
    L3:
        if (r101 >= r102) goto L9;
        char r105 = r100.charAt(r101);
        if (r105 > 255) goto L7;
        r103[r104] = (byte) r105;
        r104 = r104 + 1;
    L8:
        r101 = r101 + 1;
        goto L3
    L7:
        r103[r104] = 63;
        r104 = r104 + 1;
        goto L8
    L9:
        return r103;
    }

    public final void checkSourceBounds$kotlin_stdlib(int r100, int r101, int r102) {
        AbstractList.Companion.checkBoundsIndexes$kotlin_stdlib(r101, r102, r100);
    }

    public final byte[] decode(CharSequence r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "source");
        if ((r100 instanceof String) == false) goto L5;
        checkSourceBounds$kotlin_stdlib(r100.length(), r101, r102);
        String r103 = ((String) r100).substring(r101, r102);
        Charset r104 = Charsets.ISO_8859_1;
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type java.lang.String");
        byte[] r105 = r103.getBytes(r104);
    L7:
        return decode$default(this, r105, 0, 0, 6, null);
    L5:
        r105 = charsToBytesImpl$kotlin_stdlib(r100, r101, r102);
        goto L7
    }

    public final String encode(byte[] r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "source");
        return new String(encodeToByteArrayImpl$kotlin_stdlib(r100, r101, r102), Charsets.ISO_8859_1);
    }

    public final byte[] encodeToByteArray(byte[] r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "source");
        return encodeToByteArrayImpl$kotlin_stdlib(r100, r101, r102);
    }

    public final byte[] encodeToByteArrayImpl$kotlin_stdlib(byte[] r100, int r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, "source");
        checkSourceBounds$kotlin_stdlib(r100.length, r101, r110);
        byte[] r102 = new byte[encodeSize(r110 - r101)];
        encodeIntoByteArrayImpl$kotlin_stdlib(r100, r102, 0, r101, r110);
        return r102;
    }

    public final byte[] decode(byte[] r100, int r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "source");
        checkSourceBounds$kotlin_stdlib(r100.length, r110, r111);
        int r101 = decodeSize(r100, r110, r111);
        byte[] r102 = new byte[r101];
        if (decodeImpl(r100, r102, 0, r110, r111) != r101) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        return r102;
    L9:
        throw new IllegalStateException("Check failed.".toString());
    L5:
        r103 = false;
        goto L6
    }

    private final int handlePaddingSymbol(byte[] r100, int r101, int r102, int r103) {
        if (r103 == (-8)) goto L23;
        if (r103 == (-6)) goto L21;
        if (r103 != (-4)) goto L9;
        r101 = skipIllegalSymbolsIfMime(r100, r101 + 1, r102);
        if (r101 == r102) goto L19;
        if (r100[r101] == 61) goto L21;
    L19:
        throw new IllegalArgumentException("Missing one pad character at index " + r101);
    L9:
        if (r103 == (-2)) goto L21;
        throw new IllegalStateException("Unreachable".toString());
    L21:
        return r101 + 1;
    L23:
        throw new IllegalArgumentException("Redundant pad character at index " + r101);
    }

    public final <A extends Appendable> A encodeToAppendable(byte[] r100, A r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, a.KEY_DESTINATION);
        r101.append(new String(encodeToByteArrayImpl$kotlin_stdlib(r100, r102, r103), Charsets.ISO_8859_1));
        return r101;
    }

    private final int decodeImpl(byte[] r110, byte[] r210, int r211, int r212, int r213) {
        if (this.isUrlSafe == false) goto L5;
        int[] r100 = Base64Kt.access$getBase64UrlDecodeMap$p();
    L6:
        int r101 = -8;
        int r102 = r211;
        int r103 = r212;
        int r104 = 0;
        int r105 = -8;
    L8:
        if (r103 >= r213) goto L29;
        if (r105 == r101) goto L11;
    L16:
        int r106 = r110[r103] & UByte.MAX_VALUE;
        int r111 = r100[r106];
        if (r111 >= 0) goto L25;
        if (r111 == (-2)) goto L19;
        if (this.isMimeScheme == false) goto L24;
        r103 = r103 + 1;
    L28:
        r101 = -8;
        goto L8
    L24:
        throw new IllegalArgumentException("Invalid symbol '" + ((char) r106) + "'(" + Integer.toString(r106, CharsKt.checkRadix(8)) + ") at index " + r103);
    L19:
        r103 = handlePaddingSymbol(r110, r103, r213, r105);
        goto L29
    L25:
        r103 = r103 + 1;
        r104 = (r104 << 6) | r111;
        r105 = r105 + 6;
        if (r105 < 0) goto L28;
        r210[r102] = (byte) (r104 >>> r105);
        r104 = r104 & ((1 << r105) - 1);
        r105 = r105 - 8;
        r102 = r102 + 1;
        goto L28
    L11:
        if ((r103 + 3) >= r213) goto L16;
        int r112 = r103 + 1;
        int r113 = r112 + 1;
        int r114 = r113 + 1;
        int r115 = r114 + 1;
        int r107 = r100[r110[r114] & UByte.MAX_VALUE] | (((r100[r110[r103] & UByte.MAX_VALUE] << 18) | (r100[r110[r112] & UByte.MAX_VALUE] << 12)) | (r100[r110[r113] & UByte.MAX_VALUE] << 6));
        if (r107 < 0) goto L15;
        int r108 = r102 + 1;
        r210[r102] = (byte) (r107 >> 16);
        int r109 = r108 + 1;
        r210[r108] = (byte) (r107 >> 8);
        r210[r109] = (byte) r107;
        r102 = r109 + 1;
        r103 = r115;
        goto L28
    L15:
        r103 = r115 - 4;
    L29:
        if (r105 == (-2)) goto L37;
        int r116 = skipIllegalSymbolsIfMime(r110, r103, r213);
        if (r116 >= r213) goto L33;
        int r117 = r110[r116] & UByte.MAX_VALUE;
        throw new IllegalArgumentException("Symbol '" + ((char) r117) + "'(" + Integer.toString(r117, CharsKt.checkRadix(8)) + ") at index " + (r116 - 1) + " is prohibited after the pad character");
    L33:
        return r102 - r211;
    L37:
        throw new IllegalArgumentException("The last unit of input does not have enough bits");
    L5:
        r100 = Base64Kt.access$getBase64DecodeMap$p();
        goto L6
    }

    public final int decodeIntoByteArray(CharSequence r100, byte[] r110, int r111, int r112, int r113) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r110, a.KEY_DESTINATION);
        if ((r100 instanceof String) == false) goto L5;
        checkSourceBounds$kotlin_stdlib(r100.length(), r112, r113);
        String r101 = ((String) r100).substring(r112, r113);
        Charset r114 = Charsets.ISO_8859_1;
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type java.lang.String");
        byte[] r102 = r101.getBytes(r114);
    L7:
        return decodeIntoByteArray$default(this, r102, r110, r111, 0, 0, 24, null);
    L5:
        r102 = charsToBytesImpl$kotlin_stdlib(r100, r112, r113);
        goto L7
    }

    public final int encodeIntoByteArray(byte[] r100, byte[] r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, a.KEY_DESTINATION);
        return encodeIntoByteArrayImpl$kotlin_stdlib(r100, r101, r102, r103, r104);
    }

    public final int encodeIntoByteArrayImpl$kotlin_stdlib(byte[] r110, byte[] r111, int r112, int r113, int r114) {
        Intrinsics.checkNotNullParameter(r110, "source");
        Intrinsics.checkNotNullParameter(r111, a.KEY_DESTINATION);
        checkSourceBounds$kotlin_stdlib(r110.length, r113, r114);
        checkDestinationBounds(r111.length, r112, encodeSize(r114 - r113));
        if (this.isUrlSafe == false) goto L5;
        byte[] r100 = Base64Kt.access$getBase64UrlEncodeMap$p();
    L7:
        if (this.isMimeScheme == false) goto L9;
        int r101 = 19;
    L10:
        int r102 = r112;
    L11:
        boolean r103 = false;
        if ((r113 + 2) >= r114) goto L19;
        int r104 = Math.min((r114 - r113) / 3, r101);
        int r105 = 0;
    L14:
        if (r105 >= r104) goto L16;
        int r106 = r113 + 1;
        int r115 = r110[r113] & UByte.MAX_VALUE;
        int r107 = r106 + 1;
        int r108 = r110[r106] & UByte.MAX_VALUE;
        int r109 = r107 + 1;
        int r116 = (r115 << 16) | (r108 << 8);
        int r117 = r116 | (r110[r107] & UByte.MAX_VALUE);
        int r118 = r102 + 1;
        r111[r102] = r100[r117 >>> 18];
        int r119 = r118 + 1;
        r111[r118] = r100[(r117 >>> 12) & 63];
        int r120 = r119 + 1;
        r111[r119] = r100[(r117 >>> 6) & 63];
        r102 = r120 + 1;
        r111[r120] = r100[r117 & 63];
        r105 = r105 + 1;
        r113 = r109;
        goto L14
    L16:
        if (r104 != r101) goto L11;
        if (r113 == r114) goto L11;
        int r121 = r102 + 1;
        byte[] r122 = mimeLineSeparatorSymbols;
        r111[r102] = r122[0];
        r102 = r121 + 1;
        r111[r121] = r122[1];
        goto L11
    L19:
        int r123 = r114 - r113;
        if (r123 != 1) goto L22;
        int r124 = r113 + 1;
        int r125 = (r110[r113] & UByte.MAX_VALUE) << 4;
        int r126 = r102 + 1;
        r111[r102] = r100[r125 >>> 6];
        int r127 = r126 + 1;
        r111[r126] = r100[r125 & 63];
        int r128 = r127 + 1;
        r111[r127] = padSymbol;
        r102 = r128 + 1;
        r111[r128] = padSymbol;
        r113 = r124;
    L26:
        if (r113 != r114) goto L28;
        r103 = true;
    L28:
        if (r103 == false) goto L32;
        return r102 - r112;
    L32:
        throw new IllegalStateException("Check failed.".toString());
    L22:
        if (r123 != 2) goto L26;
        int r129 = r113 + 1;
        int r130 = r110[r113] & UByte.MAX_VALUE;
        int r131 = r129 + 1;
        int r132 = (r110[r129] & UByte.MAX_VALUE) << 2;
        int r133 = r132 | (r130 << 10);
        int r134 = r102 + 1;
        r111[r102] = r100[r133 >>> 12];
        int r135 = r134 + 1;
        r111[r134] = r100[(r133 >>> 6) & 63];
        int r136 = r135 + 1;
        r111[r135] = r100[r133 & 63];
        r102 = r136 + 1;
        r111[r136] = padSymbol;
        r113 = r131;
        goto L26
    L9:
        r101 = Integer.MAX_VALUE;
        goto L10
    L5:
        r100 = Base64Kt.access$getBase64EncodeMap$p();
        goto L7
    }

    public final int decodeIntoByteArray(byte[] r100, byte[] r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, a.KEY_DESTINATION);
        checkSourceBounds$kotlin_stdlib(r100.length, r103, r104);
        checkDestinationBounds(r101.length, r102, decodeSize(r100, r103, r104));
        return decodeImpl(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ byte[] decode$default(Base64 r100, CharSequence r101, int r102, int r103, int r104, Object r105) {
        if (r105 != null) goto L12;
        if ((r104 & 2) == 0) goto L7;
        r102 = 0;
    L7:
        if ((r104 & 4) == 0) goto L10;
        r103 = r101.length();
    L10:
        return r100.decode(r101, r102, r103);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
    }

    public static /* synthetic */ String encode$default(Base64 r100, byte[] r101, int r102, int r103, int r104, Object r105) {
        if (r105 != null) goto L12;
        if ((r104 & 2) == 0) goto L7;
        r102 = 0;
    L7:
        if ((r104 & 4) == 0) goto L10;
        r103 = r101.length;
    L10:
        return r100.encode(r101, r102, r103);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encode");
    }

    public static /* synthetic */ byte[] encodeToByteArray$default(Base64 r100, byte[] r101, int r102, int r103, int r104, Object r105) {
        if (r105 != null) goto L12;
        if ((r104 & 2) == 0) goto L7;
        r102 = 0;
    L7:
        if ((r104 & 4) == 0) goto L10;
        r103 = r101.length;
    L10:
        return r100.encodeToByteArray(r101, r102, r103);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToByteArray");
    }

    public static /* synthetic */ byte[] decode$default(Base64 r100, byte[] r101, int r102, int r103, int r104, Object r105) {
        if (r105 != null) goto L12;
        if ((r104 & 2) == 0) goto L7;
        r102 = 0;
    L7:
        if ((r104 & 4) == 0) goto L10;
        r103 = r101.length;
    L10:
        return r100.decode(r101, r102, r103);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decode");
    }

    public static /* synthetic */ Appendable encodeToAppendable$default(Base64 r100, byte[] r101, Appendable r102, int r103, int r104, int r105, Object r106) {
        if (r106 != null) goto L12;
        if ((r105 & 4) == 0) goto L7;
        r103 = 0;
    L7:
        if ((r105 & 8) == 0) goto L10;
        r104 = r101.length;
    L10:
        return r100.encodeToAppendable(r101, r102, r103, r104);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeToAppendable");
    }

    public static /* synthetic */ int decodeIntoByteArray$default(Base64 r100, CharSequence r101, byte[] r102, int r110, int r111, int r112, int r113, Object r114) {
        if (r114 != null) goto L17;
        if ((r113 & 4) == 0) goto L6;
        int r103 = 0;
    L8:
        if ((r113 & 8) == 0) goto L10;
        int r104 = 0;
    L12:
        if ((r113 & 16) == 0) goto L15;
        r112 = r101.length();
    L15:
        return r100.decodeIntoByteArray(r101, r102, r103, r104, r112);
    L10:
        r104 = r111;
        goto L12
    L6:
        r103 = r110;
        goto L8
    L17:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
    }

    public static /* synthetic */ int encodeIntoByteArray$default(Base64 r100, byte[] r101, byte[] r102, int r110, int r111, int r112, int r113, Object r114) {
        if (r114 != null) goto L17;
        if ((r113 & 4) == 0) goto L6;
        int r103 = 0;
    L8:
        if ((r113 & 8) == 0) goto L10;
        int r104 = 0;
    L12:
        if ((r113 & 16) == 0) goto L15;
        r112 = r101.length;
    L15:
        return r100.encodeIntoByteArray(r101, r102, r103, r104, r112);
    L10:
        r104 = r111;
        goto L12
    L6:
        r103 = r110;
        goto L8
    L17:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: encodeIntoByteArray");
    }

    public static /* synthetic */ int decodeIntoByteArray$default(Base64 r100, byte[] r101, byte[] r102, int r110, int r111, int r112, int r113, Object r114) {
        if (r114 != null) goto L17;
        if ((r113 & 4) == 0) goto L6;
        int r103 = 0;
    L8:
        if ((r113 & 8) == 0) goto L10;
        int r104 = 0;
    L12:
        if ((r113 & 16) == 0) goto L15;
        r112 = r101.length;
    L15:
        return r100.decodeIntoByteArray(r101, r102, r103, r104, r112);
    L10:
        r104 = r111;
        goto L12
    L6:
        r103 = r110;
        goto L8
    L17:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: decodeIntoByteArray");
    }
}
