package com.bytedance.ee.bear.drive.view.preview.image.progressloader.bitmap.decode;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes16.dex */
public final class ImageHeaderParser {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f224963b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f224964c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f224965a;

    public static final enum ImageType extends Enum<ImageType> {
        public static final ImageType GIF = null;
        public static final ImageType JPEG = null;
        public static final ImageType PNG = null;
        public static final ImageType PNG_A = null;
        public static final ImageType UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ImageType[] f224966a = null;
        private final boolean hasAlpha;

        static {
            ImageType r100 = new ImageType("GIF", 0, true);
            GIF = r100;
            ImageType r101 = new ImageType("JPEG", 1, false);
            JPEG = r101;
            ImageType r102 = new ImageType("PNG_A", 2, true);
            PNG_A = r102;
            ImageType r103 = new ImageType("PNG", 3, false);
            PNG = r103;
            ImageType r104 = new ImageType("UNKNOWN", 4, false);
            UNKNOWN = r104;
            f224966a = new ImageType[]{r100, r101, r102, r103, r104};
        }

        public static ImageType[] values() {
            return (ImageType[]) f224966a.clone();
        }

        public boolean hasAlpha() {
            return this.hasAlpha;
        }

        public static ImageType valueOf(String r100) {
            return (ImageType) r27.a.a(ImageType.class, r100);
        }

        public ImageType(String r100, int r101, boolean r102) {
            super(r100, r101);
            this.hasAlpha = r102;
        }
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputStream f224967a;

        public final int a() throws IOException {
            return ((this.f224967a.read() << 8) & 65280) | (this.f224967a.read() & 255);
        }

        public a(InputStream r100) {
            this.f224967a = r100;
        }

        public final long b(long r100) throws IOException {
            if (r100 >= 0) goto L5;
            return 0;
        L5:
            long r101 = r100;
        L7:
            if (r101 <= 0) goto L16;
            long r102 = this.f224967a.skip(r101);
            if (r102 > 0) goto L10;
            if (this.f224967a.read() == (-1)) goto L16;
            r102 = 1;
        L10:
            r101 = r101 - r102;
        L16:
            return r100 - r101;
        }
    }

    static {
        f224964c = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
        byte[] r100 = new byte[0];
        r100 = "Exif\u0000\u0000".getBytes("UTF-8");     // Catch: UnsupportedEncodingException -> L6
    L4:
        f224963b = r100;
    }

    public final int a() throws IOException {
        int r100 = this.f224965a.a();
        int r101 = 0;
        if ((r100 & 65496) == 65496) goto L8;
        if (r100 == 19789) goto L8;
        if (r100 == 18761) goto L8;
        boolean r102 = false;
    L10:
        if (r102 == true) goto L12;
        return -1;
    L12:
        short r103 = (short) (this.f224965a.f224967a.read() & 255);
        if (r103 != 255) goto L14;
        short r104 = (short) (this.f224965a.f224967a.read() & 255);
        if (r104 == 218) goto L34;
        if (r104 == 217) goto L20;
        int r105 = this.f224965a.a() - 2;
        if (r104 == 225) goto L26;
        long r106 = r105;
        long r110 = this.f224965a.b(r106);
        if (r110 == r106) goto L12;
        tt5.a.b("ImageHeaderParser", "Unable to skip enough data, type: " + r104 + ", wanted to skip: " + r105 + ", but actually skipped: " + r110);
        goto L34
    L26:
        byte[] r107 = new byte[r105];
        a r108 = this.f224965a;
        r108.getClass();
        int r111 = r105;
    L27:
        if (r111 <= 0) goto L31;
        int r112 = r108.f224967a.read(r107, r105 - r111, r111);
        if (r112 == (-1)) goto L31;
        r111 = r111 - r112;
    L31:
        int r109 = r105 - r111;
        if (r109 == r105) goto L35;
        tt5.a.b("ImageHeaderParser", "Unable to read segment data, type: " + r104 + ", length: " + r105 + ", actually read: " + r109);
    L35:
        if (r107 != null) goto L37;
    L39:
        boolean r113 = false;
    L40:
        if (r113 == false) goto L48;
        int r114 = 0;
    L42:
        byte[] r115 = f224963b;
        if (r114 >= r115.length) goto L48;
        if (r107[r114] != r115[r114]) goto L46;
        r114 = r114 + 1;
        goto L42
    L46:
        r113 = false;
    L48:
        if (r113 == false) goto L85;
        ByteBuffer r116 = ByteBuffer.wrap(r107);
        ByteOrder r117 = ByteOrder.BIG_ENDIAN;
        r116.order(r117);
        short r118 = r116.getShort(6);
        if (r118 == 19789) goto L55;
        if (r118 != 18761) goto L54;
        r117 = ByteOrder.LITTLE_ENDIAN;
        goto L55
    L54:
        tt5.a.b("ImageHeaderParser", "Unknown endianness = " + r118);
    L55:
        r116.order(r117);
        int r119 = r116.getInt(10) + 6;
        short r120 = r116.getShort(r119);
    L56:
        if (r101 >= r120) goto L105;
        int r121 = (r119 + 2) + (r101 * 12);
        short r122 = r116.getShort(r121);
        if (r122 != 274) goto L84;
        short r123 = r116.getShort(r121 + 2);
        if (r123 >= 1) goto L63;
    L83:
        tt5.a.b("ImageHeaderParser", "Got invalid format code=" + r123);
        goto L84
    L63:
        if (r123 > 12) goto L83;
        int r124 = r116.getInt(r121 + 4);
        if (r124 >= 0) goto L68;
        tt5.a.b("ImageHeaderParser", "Negative tiff component count");
        goto L84
    L68:
        tt5.a.b("ImageHeaderParser", "Got tagIndex=" + r101 + " tagType=" + r122 + " formatCode=" + r123 + " componentCount=" + r124);
        int r125 = r124 + f224964c[r123];
        if (r125 <= 4) goto L71;
        tt5.a.b("ImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + r123);
        goto L84
    L71:
        int r126 = r121 + 8;
        if (r126 >= 0) goto L74;
    L82:
        tt5.a.b("ImageHeaderParser", "Illegal tagValueOffset=" + r126 + " tagType=" + r122);
        goto L84
    L74:
        if (r126 > r116.array().length) goto L82;
        if (r125 >= 0) goto L78;
    L81:
        tt5.a.b("ImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + r122);
        goto L84
    L78:
        if ((r125 + r126) > r116.array().length) goto L81;
        return r116.getShort(r126);
    L84:
        r101 = r101 + 1;
        goto L56
    L105:
        return -1;
    L85:
        return -1;
    L37:
        if (r107.length <= f224963b.length) goto L39;
        r113 = true;
        goto L40
    L20:
        tt5.a.b("ImageHeaderParser", "Found MARKER_EOI in exif segment");
    L34:
        r107 = null;
        goto L35
    L14:
        tt5.a.b("ImageHeaderParser", "Unknown segmentId=" + r103);
    L8:
        r102 = true;
        goto L10
    }

    public ImageType getType() throws IOException {
        int r100 = this.f224965a.a();
        if (r100 == 65496) goto L5;
        int r101 = ((r100 << 16) & (-65536)) | (this.f224965a.a() & 65535);
        if (r101 != (-1991225785)) goto L14;
        this.f224965a.b(21);
        if (this.f224965a.f224967a.read() < 3) goto L12;
        return ImageType.PNG_A;
    L12:
        return ImageType.PNG;
    L14:
        if ((r101 >> 8) != 4671814) goto L18;
        return ImageType.GIF;
    L18:
        return ImageType.UNKNOWN;
    L5:
        return ImageType.JPEG;
    }

    public ImageHeaderParser(InputStream r100) {
        this.f224965a = new a(r100);
    }
}
