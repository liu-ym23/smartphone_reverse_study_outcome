package com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class ImageHeaderParser {
    public static final byte[] b = null;
    public static final int[] c = null;
    public final a a;

    public static final enum ImageType extends Enum<ImageType> {
        public static final ImageType GIF = null;
        public static final ImageType JPEG = null;
        public static final ImageType PNG = null;
        public static final ImageType PNG_A = null;
        public static final ImageType UNKNOWN = null;
        public static final /* synthetic */ ImageType[] a = null;
        private final boolean hasAlpha;

        static {
            ImageType r0 = new ImageType("GIF", 0, true);
            GIF = r0;
            ImageType r1 = new ImageType("JPEG", 1, false);
            JPEG = r1;
            ImageType r4 = new ImageType("PNG_A", 2, true);
            PNG_A = r4;
            ImageType r5 = new ImageType("PNG", 3, false);
            PNG = r5;
            ImageType r7 = new ImageType("UNKNOWN", 4, false);
            UNKNOWN = r7;
            a = new ImageType[]{r0, r1, r4, r5, r7};
        }

        public static ImageType[] values() {
            return (ImageType[]) a.clone();
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }

        public static ImageType valueOf(String r1) {
            return (ImageType) r27.a.a(ImageType.class, r1);
        }

        public ImageType(String r1, int r2, boolean r3) {
            super(r1, r2);
            this.hasAlpha = r3;
        }
    }

    public static class a {
        public final InputStream a;

        public final int a() throws IOException {
            return ((this.a.read() << 8) & 65280) | (this.a.read() & 255);
        }

        public a(InputStream r1) {
            this.a = r1;
        }

        public final long b(long r8) throws IOException {
            if (r8 >= 0) goto L5;
            return 0;
        L5:
            long r2 = r8;
        L7:
            if (r2 <= 0) goto L16;
            long r4 = this.a.skip(r2);
            if (r4 > 0) goto L10;
            if (this.a.read() == (-1)) goto L16;
            r4 = 1;
        L10:
            r2 = r2 - r4;
        L16:
            return r8 - r2;
        }
    }

    static {
        c = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
        byte[] r0 = new byte[0];
        r0 = "Exif\u0000\u0000".getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L6
    L4:
        b = r0;
    }

    public final int a() throws IOException {
        int r0 = this.a.a();
        int r5 = 0;
        if ((r0 & 65496) == 65496) goto L8;
        if (r0 == 19789) goto L8;
        if (r0 == 18761) goto L8;
        boolean r1 = false;
    L10:
        if (r1 == true) goto L12;
        return -1;
    L12:
        short r2 = (short) (this.a.a.read() & 255);
        if (r2 != 255) goto L14;
        short r3 = (short) (this.a.a.read() & 255);
        if (r3 == 218) goto L34;
        if (r3 == 217) goto L20;
        int r4 = this.a.a() - 2;
        if (r3 == 225) goto L26;
        long r9 = r4;
        long r11 = this.a.b(r9);
        if (r11 == r9) goto L12;
        tt5.a.b("ImageHeaderParser", "Unable to skip enough data, type: " + r3 + ", wanted to skip: " + r4 + ", but actually skipped: " + r11);
        goto L34
    L26:
        byte[] r8 = new byte[r4];
        a r10 = this.a;
        r10.getClass();
        int r12 = r4;
    L27:
        if (r12 <= 0) goto L31;
        int r13 = r10.a.read(r8, r4 - r12, r12);
        if (r13 == (-1)) goto L31;
        r12 = r12 - r13;
    L31:
        int r14 = r4 - r12;
        if (r14 == r4) goto L35;
        tt5.a.b("ImageHeaderParser", "Unable to read segment data, type: " + r3 + ", length: " + r4 + ", actually read: " + r14);
    L35:
        if (r8 != null) goto L37;
    L39:
        boolean r6 = false;
    L40:
        if (r6 == false) goto L48;
        int r7 = 0;
    L42:
        byte[] r16 = b;
        if (r7 >= r16.length) goto L48;
        if (r8[r7] != r16[r7]) goto L46;
        r7 = r7 + 1;
        goto L42
    L46:
        r6 = false;
    L48:
        if (r6 == false) goto L85;
        ByteBuffer r17 = ByteBuffer.wrap(r8);
        ByteOrder r18 = ByteOrder.BIG_ENDIAN;
        r17.order(r18);
        short r19 = r17.getShort(6);
        if (r19 == 19789) goto L55;
        if (r19 != 18761) goto L54;
        r18 = ByteOrder.LITTLE_ENDIAN;
        goto L55
    L54:
        tt5.a.b("ImageHeaderParser", "Unknown endianness = " + r19);
    L55:
        r17.order(r18);
        int r20 = r17.getInt(10) + 6;
        short r21 = r17.getShort(r20);
    L56:
        if (r5 >= r21) goto L105;
        int r22 = (r20 + 2) + (r5 * 12);
        short r23 = r17.getShort(r22);
        if (r23 != 274) goto L84;
        short r24 = r17.getShort(r22 + 2);
        if (r24 >= 1) goto L63;
    L83:
        tt5.a.b("ImageHeaderParser", "Got invalid format code=" + r24);
        goto L84
    L63:
        if (r24 > 12) goto L83;
        int r110 = r17.getInt(r22 + 4);
        if (r110 >= 0) goto L68;
        tt5.a.b("ImageHeaderParser", "Negative tiff component count");
        goto L84
    L68:
        tt5.a.b("ImageHeaderParser", "Got tagIndex=" + r5 + " tagType=" + r23 + " formatCode=" + r24 + " componentCount=" + r110);
        int r111 = r110 + c[r24];
        if (r111 <= 4) goto L71;
        tt5.a.b("ImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + r24);
        goto L84
    L71:
        int r26 = r22 + 8;
        if (r26 >= 0) goto L74;
    L82:
        tt5.a.b("ImageHeaderParser", "Illegal tagValueOffset=" + r26 + " tagType=" + r23);
        goto L84
    L74:
        if (r26 > r17.array().length) goto L82;
        if (r111 >= 0) goto L78;
    L81:
        tt5.a.b("ImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + r23);
        goto L84
    L78:
        if ((r111 + r26) > r17.array().length) goto L81;
        return r17.getShort(r26);
    L84:
        r5 = r5 + 1;
        goto L56
    L105:
        return -1;
    L85:
        return -1;
    L37:
        if (r8.length <= b.length) goto L39;
        r6 = true;
        goto L40
    L20:
        tt5.a.b("ImageHeaderParser", "Found MARKER_EOI in exif segment");
    L34:
        r8 = null;
        goto L35
    L14:
        tt5.a.b("ImageHeaderParser", "Unknown segmentId=" + r2);
    L8:
        r1 = true;
        goto L10
    }

    public ImageType getType() throws IOException {
        int r0 = this.a.a();
        if (r0 == 65496) goto L5;
        int r1 = ((r0 << 16) & (-65536)) | (this.a.a() & 65535);
        if (r1 != (-1991225785)) goto L14;
        this.a.b(21);
        if (this.a.a.read() < 3) goto L12;
        return ImageType.PNG_A;
    L12:
        return ImageType.PNG;
    L14:
        if ((r1 >> 8) != 4671814) goto L18;
        return ImageType.GIF;
    L18:
        return ImageType.UNKNOWN;
    L5:
        return ImageType.JPEG;
    }

    public ImageHeaderParser(InputStream r2) {
        this.a = new a(r2);
    }
}
