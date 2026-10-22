package com.ss.android.socialbase.appdownloader.util.parser.zip;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes38.dex */
public abstract class ZipEncodingHelper {
    private static final byte[] HEX_DIGITS = null;
    static final String UTF8 = "UTF8";
    static final ZipEncoding UTF8_ZIP_ENCODING = null;
    private static final String UTF_DASH_8 = "utf-8";
    private static final Map<String, SimpleEncodingHolder> simpleEncodings = null;

    public static class SimpleEncodingHolder {
        private Simple8BitZipEncoding encoding;
        private final char[] highChars;

        public synchronized Simple8BitZipEncoding getEncoding() {
            monitor-enter(this);
        L9:
            th = move-exception;
            throw th;
        L4:
            if (this.encoding != null) goto L6;
            this.encoding = new Simple8BitZipEncoding(this.highChars);     // Catch: Throwable -> L9
        L6:
            Simple8BitZipEncoding r100 = this.encoding;     // Catch: Throwable -> L9
            monitor-exit(this);
            return r100;
        }

        public SimpleEncodingHolder(char[] r100) {
            this.highChars = r100;
        }
    }

    public ZipEncodingHelper() {
    }

    static {
        HashMap r100 = new HashMap();
        SimpleEncodingHolder r101 = new SimpleEncodingHolder(new char[]{199, 252, 233, 226, 228, 224, 229, 231, 234, 235, 232, 239, 238, 236, 196, 197, 201, 230, 198, 244, 246, 242, 251, 249, 255, 214, 220, Typography.cent, Typography.pound, 165, 8359, 402, 225, 237, 243, 250, 241, 209, 170, 186, 191, 8976, 172, Typography.half, 188, 161, 171, 187, 9617, 9618, 9619, 9474, 9508, 9569, 9570, 9558, 9557, 9571, 9553, 9559, 9565, 9564, 9563, 9488, 9492, 9524, 9516, 9500, 9472, 9532, 9566, 9567, 9562, 9556, 9577, 9574, 9568, 9552, 9580, 9575, 9576, 9572, 9573, 9561, 9560, 9554, 9555, 9579, 9578, 9496, 9484, 9608, 9604, 9612, 9616, 9600, 945, 223, 915, 960, 931, 963, 181, 964, 934, 920, 937, 948, 8734, 966, 949, 8745, 8801, Typography.plusMinus, Typography.greaterOrEqual, Typography.lessOrEqual, 8992, 8993, 247, Typography.almostEqual, Typography.degree, 8729, Typography.middleDot, 8730, 8319, 178, 9632, Typography.nbsp});
        r100.put("CP437", r101);
        r100.put("Cp437", r101);
        r100.put("cp437", r101);
        r100.put("IBM437", r101);
        r100.put("ibm437", r101);
        SimpleEncodingHolder r102 = new SimpleEncodingHolder(new char[]{199, 252, 233, 226, 228, 224, 229, 231, 234, 235, 232, 239, 238, 236, 196, 197, 201, 230, 198, 244, 246, 242, 251, 249, 255, 214, 220, 248, Typography.pound, 216, Typography.times, 402, 225, 237, 243, 250, 241, 209, 170, 186, 191, Typography.registered, 172, Typography.half, 188, 161, 171, 187, 9617, 9618, 9619, 9474, 9508, 193, 194, 192, Typography.copyright, 9571, 9553, 9559, 9565, Typography.cent, 165, 9488, 9492, 9524, 9516, 9500, 9472, 9532, 227, 195, 9562, 9556, 9577, 9574, 9568, 9552, 9580, 164, 240, 208, 202, 203, 200, 305, 205, 206, 207, 9496, 9484, 9608, 9604, 166, 204, 9600, 211, 223, 212, 210, 245, 213, 181, 254, 222, 218, 219, 217, 253, 221, 175, 180, 173, Typography.plusMinus, 8215, 190, Typography.paragraph, Typography.section, 247, 184, Typography.degree, 168, Typography.middleDot, 185, 179, 178, 9632, Typography.nbsp});
        r100.put("CP850", r102);
        r100.put("Cp850", r102);
        r100.put("cp850", r102);
        r100.put("IBM850", r102);
        r100.put("ibm850", r102);
        simpleEncodings = Collections.unmodifiableMap(r100);
        HEX_DIGITS = new byte[]{48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        UTF8_ZIP_ENCODING = new FallbackZipEncoding(UTF8);
    }

    public static ZipEncoding getZipEncoding(String r100) {
        if (isUTF8(r100) == true) goto L5;
        if (r100 == null) goto L8;
        SimpleEncodingHolder r101 = simpleEncodings.get(r100);
        if (r101 != null) goto L12;
        return new NioZipEncoding(Charset.forName(r100));
    L16:
        return new FallbackZipEncoding(r100);
    L12:
        return r101.getEncoding();
    L8:
        return new FallbackZipEncoding();
    L5:
        return UTF8_ZIP_ENCODING;
    }

    public static boolean isUTF8(String r100) {
        if (r100 != null) goto L5;
        r100 = System.getProperty("file.encoding");
    L5:
        if (UTF8.equalsIgnoreCase(r100) == false) goto L7;
    L10:
        return true;
    L7:
        if ("utf-8".equalsIgnoreCase(r100) == true) goto L10;
        return false;
    }

    public static void prepareBufferForRead(Buffer r100) {
        r100.limit(r100.position());
        r100.rewind();
    }

    public static void appendSurrogate(ByteBuffer r100, char r101) {
        r100.put((byte) 37);
        r100.put((byte) 85);
        byte[] r102 = HEX_DIGITS;
        r100.put(r102[(r101 >> '\f') & 15]);
        r100.put(r102[(r101 >> '\b') & 15]);
        r100.put(r102[(r101 >> 4) & 15]);
        r100.put(r102[r101 & 15]);
    }

    public static ByteBuffer growBuffer(ByteBuffer r100, int r101) {
        prepareBufferForRead(r100);
        int r102 = r100.capacity() * 2;
        if (r102 < r101) goto L6;
        r101 = r102;
    L6:
        ByteBuffer r103 = ByteBuffer.allocate(r101);
        r103.put(r100);
        return r103;
    }
}
