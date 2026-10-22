package com.ss.android.lark.utils;

import androidx.collection.LruCache;
import com.bumptech.glide.integration.webp.WebpHeaderParser;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.android.lark.log.Log;
import java.io.Closeable;
import java.io.File;

/* JADX INFO: loaded from: classes38.dex */
public final class ImageUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<String, Boolean> f444663a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, ImageType> f444664b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LruCache<String, String> f444665c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f444666d;

    public static final enum ImageType extends Enum<ImageType> {
        public static final ImageType TYPE_BMP = null;
        public static final ImageType TYPE_GIF = null;
        public static final ImageType TYPE_HEIC = null;
        public static final ImageType TYPE_HEIF = null;
        public static final ImageType TYPE_ICO = null;
        public static final ImageType TYPE_JPG = null;
        public static final ImageType TYPE_PNG = null;
        public static final ImageType TYPE_TIFF = null;
        public static final ImageType TYPE_UNKNOWN = null;
        public static final ImageType TYPE_WEBP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ImageType[] f444667a = null;
        String value;

        static {
            ImageType r100 = new ImageType("TYPE_JPG", 0, "jpg");
            TYPE_JPG = r100;
            ImageType r101 = new ImageType("TYPE_PNG", 1, LoadParams.ImageFormat.PNG);
            TYPE_PNG = r101;
            ImageType r102 = new ImageType("TYPE_GIF", 2, "gif");
            TYPE_GIF = r102;
            ImageType r103 = new ImageType("TYPE_TIFF", 3, "tiff");
            TYPE_TIFF = r103;
            ImageType r104 = new ImageType("TYPE_BMP", 4, "bmp");
            TYPE_BMP = r104;
            ImageType r105 = new ImageType("TYPE_WEBP", 5, "webp");
            TYPE_WEBP = r105;
            ImageType r110 = new ImageType("TYPE_ICO", 6, "ico");
            TYPE_ICO = r110;
            ImageType r111 = new ImageType("TYPE_HEIC", 7, "heic");
            TYPE_HEIC = r111;
            ImageType r112 = new ImageType("TYPE_HEIF", 8, "heif");
            TYPE_HEIF = r112;
            ImageType r113 = new ImageType("TYPE_UNKNOWN", 9, "unknown");
            TYPE_UNKNOWN = r113;
            f444667a = new ImageType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        }

        public static ImageType[] values() {
            return (ImageType[]) f444667a.clone();
        }

        public String getValue() {
            return this.value;
        }

        public static ImageType valueOf(String r100) {
            return (ImageType) r27.a.a(ImageType.class, r100);
        }

        public ImageType(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        f444663a = new LruCache(100);
        f444664b = new LruCache(100);
        f444665c = new LruCache(100);
        f444666d = false;
    }

    public static String a(PolarisFileWrapper r100) {
        if (r100.canRead() == true) goto L6;
        return "";
    L6:
        String r101 = r100.getPath();
        LruCache<String, String> r102 = f444665c;
        String r103 = r102.get(r101);
        if (r103 == null) goto L9;
        return r103;
    L9:
        String r104 = com.larksuite.framework.utils.e0.a(b(r100)).toUpperCase();
        r102.put(r101, r104);
        Log.i("ImageUtils", "getFileHeader, file dir:" + r100.getParent() + ", result:" + r104);
        return r104;
    }

    public static byte[] b(File r100) {
        byte[] r101 = new byte[12];
        PolarisFileInputStreamWrapper r102 = null;
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L10 Exception -> L12
        r103.read(r101);     // Catch: Throwable -> L6 Exception -> L8
        com.larksuite.framework.utils.d.b(new Closeable[]{r103});
    L15:
        return r101;
    L8:
        e = e;
        r102 = r103;
    L13:
        Log.e("ImageUtils", "getFileHeader error:" + e.toString());     // Catch: Throwable -> L10
        com.larksuite.framework.utils.d.b(new Closeable[]{r102});
    L6:
        th = th;
    L17:
        com.larksuite.framework.utils.d.b(new Closeable[]{r103});
        throw th;
    L12:
        e = e;
    L10:
        th = th;
        r103 = r102;
        goto L17
    }

    public static ImageType c(File r110) {
        if (r110 == null) goto L71;
        if (r110.canRead() == false) goto L71;
        String r100 = r110.getPath();
        LruCache<String, ImageType> r101 = f444664b;
        ImageType r102 = r101.get(r100);
        if (r102 == null) goto L9;
        return r102;
    L9:
        byte[] r103 = b(r110);
        String r104 = com.larksuite.framework.utils.e0.a(r103).toUpperCase();
        Log.i("ImageUtils", "getBytesImageType: " + r104);
        if (r104.contains("FFD8FF") == false) goto L13;
        ImageType r105 = ImageType.TYPE_JPG;
    L68:
        r101.put(r100, r105);
        Log.i("ImageUtils", "getFileImageType, file dir:" + r110.getParent() + ", result:" + r105.toString());
        return r105;
    L13:
        if (r104.contains("89504E47") == false) goto L16;
        r105 = ImageType.TYPE_PNG;
        goto L68
    L16:
        if (r104.contains("47494638") == false) goto L19;
        r105 = ImageType.TYPE_GIF;
        goto L68
    L19:
        if (r104.contains("49492A00") == false) goto L21;
    L67:
        r105 = ImageType.TYPE_TIFF;
        goto L68
    L21:
        if (r104.contains("4D4D002A") == true) goto L67;
        if (r104.contains("424D") == false) goto L27;
        r105 = ImageType.TYPE_BMP;
        goto L68
    L27:
        if (r104.startsWith("52494646") == false) goto L32;
        if (r104.endsWith("57454250") == false) goto L32;
        r105 = ImageType.TYPE_WEBP;
    L32:
        if (r104.contains("00000100") == false) goto L34;
    L66:
        r105 = ImageType.TYPE_ICO;
        goto L68
    L34:
        if (r104.contains("00000200") == true) goto L66;
        int r106 = r103.length;
        boolean r107 = false;
        int r108 = i(r103, 0);
        if (h(r103, 4).equalsIgnoreCase("ftyp") == true) goto L40;
    L63:
        if (r107 == false) goto L65;
        r105 = ImageType.TYPE_HEIF;
        goto L68
    L65:
        r105 = ImageType.TYPE_UNKNOWN;
        goto L68
    L40:
        if (r106 >= 32) goto L43;
        r107 = d(h(r103, 8));
        goto L63
    L43:
        if (r108 == 1) goto L45;
        if (r108 < 8) goto L63;
        int r109 = 8;
    L54:
        if (r108 > r106) goto L57;
        r106 = r108;
    L57:
        int r111 = r106 - r109;
        if (r111 < 8) goto L63;
        if ((((r111 - 8) / 4) + 2) <= 0) goto L63;
        r107 = d(h(r103, r109 + 0));
        goto L63
    L45:
        if (r106 < 16) goto L63;
        int r112 = i(r103, 8);
        if (r112 < 16) goto L63;
        r108 = r112;
        r109 = 16;
    L71:
        return ImageType.TYPE_UNKNOWN;
    }

    public static boolean d(String r100) {
        String[] r101 = {"mif1", "heic", "msf1", "hevc", "avif", "avis"};
        int r102 = 0;
    L4:
        if (r102 >= 6) goto L10;
        if (r101[r102].equalsIgnoreCase(r100) == true) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    public static boolean e(File r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L22:
        return false;
    L5:
        if (r100.canRead() == false) goto L22;
        String r102 = r100.getPath();
        LruCache<String, Boolean> r103 = f444663a;
        Boolean r104 = r103.get(r102);
        if (r104 != null) goto L10;
        ImageType r105 = c(r100);
        if (r105 != ImageType.TYPE_WEBP) goto L17;
        if (f444666d == false) goto L17;
        Boolean r106 = Boolean.valueOf(WebpHeaderParser.isAnimatedWebpType(LarkContext.getApplication(), r100));
    L20:
        r103.put(r102, r106);
        Log.i("ImageUtils", "isAnimatedImage, file dir:" + r100.getParent() + ", result:" + r106);
        return r106.booleanValue();
    L17:
        if (r105 != ImageType.TYPE_GIF) goto L19;
        r101 = true;
    L19:
        r106 = Boolean.valueOf(r101);
        goto L20
    L10:
        return r104.booleanValue();
    }

    public static boolean f(ImageType r100) {
        if (r100 != ImageType.TYPE_HEIF) goto L5;
    L8:
        return true;
    L5:
        if (r100 == ImageType.TYPE_HEIC) goto L8;
        return false;
    }

    public static String h(byte[] r100, int r101) {
        int r102 = r101 + 3;
        if (r102 < r100.length) goto L6;
        return "";
    L6:
        StringBuilder r103 = new StringBuilder();
        r103.append((char) r100[r101]);     // Catch: Exception -> L9
        r103.append((char) r100[r101 + 1]);     // Catch: Exception -> L9
        r103.append((char) r100[r101 + 2]);     // Catch: Exception -> L9
        r103.append((char) r100[r102]);     // Catch: Exception -> L9
    L12:
        return r103.toString();
    L9:
        e = move-exception;
        Log.e("ImageUtils", "safeByteToString" + e);
        goto L12
    }

    public static int i(byte[] r100, int r101) {
        int r102 = r101 + 3;
        if (r102 < r100.length) goto L6;
        return 0;
    L6:
        int r103 = (r100[r101] << 24) | (r100[r101 + 1] << 16);
        int r104 = (r100[r101 + 2] << 8) | r103;
        return r100[r102] | r104;
    }

    public static int[] g(int r100, int r101, int r102, int r103, int r110, int r111) {
        if (r110 <= r102) goto L4;
        int r104 = r102;
    L5:
        if (r111 <= r103) goto L7;
        int r105 = r103;
    L8:
        if (r101 > 0) goto L10;
        r101 = r105;
    L10:
        if (r100 > 0) goto L12;
        r100 = r104;
    L12:
        int[] r112 = new int[2];
        if (r101 < r105) goto L19;
        if (r100 < r104) goto L19;
        if (r101 > r103) goto L19;
        if (r100 > r102) goto L19;
        r112[0] = r100;
        r112[1] = r101;
        return r112;
    L19:
        if (r101 <= r103) goto L25;
        int r106 = (int) (((r100 * r103) * 1.0f) / r101);
        if (r106 >= r104) goto L23;
        int r107 = r104;
    L45:
        return g(r107, r103, r102, r103, r104, r105);
    L23:
        r107 = r106;
        goto L45
    L25:
        if (r100 <= r102) goto L31;
        int r108 = (int) (((r101 * r102) * 1.0f) / r100);
        if (r108 >= r105) goto L29;
        int r109 = r105;
    L46:
        return g(r102, r109, r102, r103, r104, r105);
    L29:
        r109 = r108;
        goto L46
    L31:
        if (r101 >= r105) goto L37;
        int r113 = (int) (((r100 * r105) * 1.0f) / r101);
        if (r113 >= r102) goto L35;
        int r114 = r113;
    L47:
        return g(r114, r105, r102, r103, r104, r105);
    L35:
        r114 = r102;
        goto L47
    L37:
        if (r100 >= r104) goto L48;
        int r115 = (int) (((r101 * r104) * 1.0f) / r100);
        if (r115 >= r103) goto L41;
        int r116 = r115;
    L43:
        return g(r104, r116, r102, r103, r104, r105);
    L41:
        r116 = r103;
        goto L43
    L48:
        return r112;
    L7:
        r105 = r111;
        goto L8
    L4:
        r104 = r110;
        goto L5
    }
}
