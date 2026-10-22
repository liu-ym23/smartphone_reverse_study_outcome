package n4a;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.zip.GZIPInputStream;
import kotlin.UByte;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: classes32.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f517274a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f517275b = null;

    static {
        f517274a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        f517275b = new byte[]{-9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, Base64.padSymbol, -9, -9, -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, HTTP.CR, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9};
    }

    public f() {
    }

    public static String a(byte[] r100, int r110) throws IOException {
        if (r100 == null) goto L27;
        if (r110 < 0) goto L25;
        if ((r110 + 0) > r100.length) goto L23;
        int r101 = 4;
        int r102 = (r110 / 3) * 4;
        if ((r110 % 3) > 0) goto L10;
        r101 = 0;
    L10:
        int r103 = r102 + r101;
        byte[] r104 = new byte[r103];
        int r105 = r110 - 2;
        int r106 = 0;
        int r107 = 0;
    L11:
        if (r106 >= r105) goto L13;
        b(r100, r106 + 0, 3, r104, r107);
        r106 = r106 + 3;
        r107 = r107 + 4;
        goto L11
    L13:
        if (r106 >= r110) goto L16;
        b(r100, r106 + 0, r110 - r106, r104, r107);
        r107 = r107 + 4;
    L16:
        if (r107 > (r103 - 1)) goto L28;
        byte[] r108 = new byte[r107];
        System.arraycopy(r104, 0, r108, 0, r107);
        r104 = r108;
    L28:
        return new String(r104, "US-ASCII");
    L21:
        return new String(r104);
    L23:
        throw new IllegalArgumentException(String.format("Cannot have offset of %d and length of %d with array of length %d", new Object[]{0, Integer.valueOf(r110), Integer.valueOf(r100.length)}));
    L25:
        throw new IllegalArgumentException("Cannot have length offset: ".concat(String.valueOf(r110)));
    L27:
        throw new NullPointerException("Cannot serialize a null array.");
    }

    public static void b(byte[] r100, int r101, int r102, byte[] r103, int r104) {
        byte[] r105 = f517274a;
        int r106 = 0;
        if (r102 <= 0) goto L5;
        int r107 = (r100[r101] << 24) >>> 8;
    L7:
        if (r102 <= 1) goto L9;
        int r108 = (r100[r101 + 1] << 24) >>> 16;
    L10:
        int r109 = r107 | r108;
        if (r102 <= 2) goto L13;
        r106 = (r100[r101 + 2] << 24) >>> 24;
    L13:
        int r110 = r109 | r106;
        if (r102 == 1) goto L22;
        if (r102 == 2) goto L20;
        if (r102 == 3) goto L18;
        return;
    L18:
        r103[r104] = r105[r110 >>> 18];
        r103[r104 + 1] = r105[(r110 >>> 12) & 63];
        r103[r104 + 2] = r105[(r110 >>> 6) & 63];
        r103[r104 + 3] = r105[r110 & 63];
        return;
    L20:
        r103[r104] = r105[r110 >>> 18];
        r103[r104 + 1] = r105[(r110 >>> 12) & 63];
        r103[r104 + 2] = r105[(r110 >>> 6) & 63];
        r103[r104 + 3] = Base64.padSymbol;
        return;
    L22:
        r103[r104] = r105[r110 >>> 18];
        r103[r104 + 1] = r105[(r110 >>> 12) & 63];
        r103[r104 + 2] = Base64.padSymbol;
        r103[r104 + 3] = Base64.padSymbol;
        return;
    L9:
        r108 = 0;
        goto L10
    L5:
        r107 = 0;
        goto L7
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static byte[] c(String r110) throws IOException {
        if (r110 == null) goto L94;
        byte[] r100 = r110.getBytes("US-ASCII");     // Catch: UnsupportedEncodingException -> L6
    L7:
        int r101 = r100.length;
        int r102 = r101 + 0;
        int r103 = 3;
        int r104 = 1;
        if (r102 > r100.length) goto L92;
        if (r101 != 0) goto L13;
        byte[] r105 = new byte[0];
    L12:
        byte[] r106 = r105;
        if (r106.length >= 4) goto L46;
    L88:
        return r106;
    L46:
        if (35615 != ((r106[0] & UByte.MAX_VALUE) | ((r106[1] << 8) & 65280))) goto L88;
        byte[] r107 = new byte[2048];
        ByteArrayOutputStream r108 = null;
        ByteArrayInputStream r109 = null;
        ByteArrayInputStream r111 = null;
        r108 = null;
        ByteArrayOutputStream r112 = new ByteArrayOutputStream();     // Catch: Throwable -> L73 IOException -> L75
    L126:
        ByteArrayInputStream r113 = new ByteArrayInputStream(r106);     // Catch: Throwable -> L67 IOException -> L70
        GZIPInputStream r114 = new GZIPInputStream(r113);     // Catch: Throwable -> L61 IOException -> L64
    L124:
        int r115 = r114.read(r107);     // Catch: Throwable -> L57 IOException -> L59
        if (r115 < 0) goto L54;
        r112.write(r107, 0, r115);     // Catch: Throwable -> L57 IOException -> L59
        goto L124
    L54:
        byte[] r116 = r112.toByteArray();     // Catch: Throwable -> L57 IOException -> L59
        r112.close();     // Catch: Exception -> L95
    L56:
        r106 = r116;
    L108:
        r114.close();     // Catch: Exception -> L96
    L110:
        r113.close();     // Catch: Exception -> L101
        goto L88
    L59:
        e = e;
    L66:
        r109 = r113;
    L72:
        ByteArrayInputStream r117 = r109;
        r108 = r112;
    L116:
        e.printStackTrace();     // Catch: Throwable -> L83
        r108.close();     // Catch: Exception -> L100
    L79:
        r113 = r117;
    L83:
        th = th;
    L118:
        r108.close();     // Catch: Exception -> L97
    L114:
        r114.close();     // Catch: Exception -> L98
    L112:
        r117.close();     // Catch: Exception -> L99
        throw th;
    L137:
        throw th;
    L57:
        th = th;
    L63:
        r111 = r113;
    L69:
        r117 = r111;
        r108 = r112;
    L64:
        e = e;
        r114 = null;
    L61:
        th = th;
        r114 = null;
        goto L63
    L70:
        e = e;
        r114 = null;
    L67:
        th = th;
        r114 = null;
    L75:
        e = e;
        r117 = null;
        r114 = null;
    L73:
        th = th;
        r117 = null;
        r114 = null;
        goto L118
    L13:
        if (r101 < 4) goto L90;
        byte[] r118 = f517275b;
        int r119 = (r101 * 3) / 4;
        byte[] r120 = new byte[r119];
        byte[] r121 = new byte[4];
        int r122 = 0;
        int r123 = 0;
        int r124 = 0;
    L15:
        if (r122 >= r102) goto L42;
        byte r125 = r100[r122];
        byte r126 = r118[r125 & UByte.MAX_VALUE ? 1 : 0];
        if (r126 < (-5)) goto L41;
        if (r126 < (-1)) goto L39;
        int r127 = r123 + 1;
        r121[r123] = r125;
        if (r127 <= r103) goto L38;
        if (r124 < 0) goto L37;
        int r128 = r124 + 2;
        if (r128 >= r119) goto L37;
        byte r129 = r121[2];
        if (r129 != 61) goto L28;
        r120[r124] = (byte) ((((r118[r121[0]] & UByte.MAX_VALUE) << 18) | ((r118[r121[r104]] & UByte.MAX_VALUE) << 12)) >>> 16);
    L32:
        r124 = r124 + r104;
        if (r100[r122] == 61) goto L42;
        r123 = 0;
        goto L39
    L28:
        byte r130 = r121[r103];
        if (r130 != 61) goto L31;
        int r131 = (((r118[r121[0]] & UByte.MAX_VALUE) << 18) | ((r118[r121[r104]] & UByte.MAX_VALUE) << 12)) | ((r118[r129] & UByte.MAX_VALUE) << 6);
        r120[r124] = (byte) (r131 >>> 16);
        r120[r124 + 1] = (byte) (r131 >>> 8);
        r104 = 2;
        goto L32
    L31:
        int r132 = ((((r118[r121[0]] & UByte.MAX_VALUE) << 18) | ((r118[r121[r104]] & UByte.MAX_VALUE) << 12)) | ((r118[r129] & UByte.MAX_VALUE) << 6)) | (r118[r130] & UByte.MAX_VALUE);
        r120[r124] = (byte) (r132 >> 16);
        r120[r124 + 1] = (byte) (r132 >> 8);
        r120[r128] = (byte) r132;
        r104 = 3;
    L37:
        throw new IllegalArgumentException(String.format("Destination array with length %d cannot have offset of %d and still store three bytes.", new Object[]{Integer.valueOf(r119), Integer.valueOf(r124)}));
    L38:
        r123 = r127;
    L39:
        r122 = r122 + 1;
        r103 = 3;
        r104 = 1;
        goto L15
    L41:
        throw new IOException(String.format("Bad Base64Util input character decimal %d in array position %d", new Object[]{Integer.valueOf(r100[r122] & UByte.MAX_VALUE), Integer.valueOf(r122)}));
    L42:
        r105 = new byte[r124];
        System.arraycopy(r120, 0, r105, 0, r124);
        goto L12
    L90:
        throw new IllegalArgumentException("Base64Util-encoded string must have at least four characters, but length specified was ".concat(String.valueOf(r101)));
    L92:
        throw new IllegalArgumentException(String.format("Source array with length %d cannot have offset of %d and process %d bytes.", new Object[]{Integer.valueOf(r100.length), 0, Integer.valueOf(r101)}));
    L6:
        r100 = r110.getBytes();
        goto L7
    L94:
        throw new NullPointerException("Input string was null.");
    }
}
