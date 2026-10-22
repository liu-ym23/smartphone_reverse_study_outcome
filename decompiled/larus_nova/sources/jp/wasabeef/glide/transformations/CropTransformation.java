package jp.wasabeef.glide.transformations;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes41.dex */
public class CropTransformation extends BitmapTransformation {
    private static final String ID = "jp.wasabeef.glide.transformations.CropTransformation.1";
    private static final byte[] ID_BYTES = null;
    private static final int VERSION = 1;
    private CropType cropType;
    private int height;
    private int width;

    public static final enum CropType extends Enum<CropType> {
        public static final CropType BOTTOM = null;
        public static final CropType CENTER = null;
        public static final CropType TOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CropType[] f499931a = null;

        static {
            CropType r100 = new CropType("TOP", 0);
            TOP = r100;
            CropType r101 = new CropType("CENTER", 1);
            CENTER = r101;
            CropType r102 = new CropType("BOTTOM", 2);
            BOTTOM = r102;
            f499931a = new CropType[]{r100, r101, r102};
        }

        public static CropType[] values() {
            return (CropType[]) f499931a.clone();
        }

        public static CropType valueOf(String r100) {
            return (CropType) r27.a.a(CropType.class, r100);
        }

        public CropType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f499932a = null;

        static {
            int[] r100 = new int[CropType.values().length];
            f499932a = r100;
            r100[CropType.TOP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            f499932a[CropType.CENTER.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            f499932a[CropType.BOTTOM.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public int hashCode() {
        return -1462327117;
    }

    static {
        ID_BYTES = ID.getBytes(Key.CHARSET);
    }

    public String toString() {
        return "CropTransformation(width=" + this.width + ", height=" + this.height + ", cropType=" + this.cropType + ")";
    }

    private float getTop(float r100) {
        int r101 = a.f499932a[this.cropType.ordinal()];
        if (r101 == 2) goto L11;
        if (r101 == 3) goto L9;
        return 0.0f;
    L9:
        return this.height - r100;
    L11:
        return (this.height - r100) / 2.0f;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        return r100 instanceof CropTransformation;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        r100.update(ID_BYTES);
    }

    public CropTransformation(int r100, int r101) {
        this(r100, r101, CropType.CENTER);
    }

    public CropTransformation(int r100, int r101, CropType r102) {
        CropType r103 = CropType.TOP;
        this.width = r100;
        this.height = r101;
        this.cropType = r102;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public Bitmap transform(Context r100, BitmapPool r101, Bitmap r102, int r103, int r104) {
        int r105 = this.width;
        if (r105 != 0) goto L5;
        r105 = r102.getWidth();
    L5:
        this.width = r105;
        int r106 = this.height;
        if (r106 != 0) goto L8;
        r106 = r102.getHeight();
    L8:
        this.height = r106;
        if (r102.getConfig() == null) goto L11;
        Bitmap.Config r107 = r102.getConfig();
    L12:
        Bitmap r108 = r101.get(this.width, this.height, r107);
        r108.setHasAlpha(true);
        float r109 = Math.max(this.width / r102.getWidth(), this.height / r102.getHeight());
        float r110 = r102.getWidth() * r109;
        float r111 = r109 * r102.getHeight();
        float r112 = (this.width - r110) / 2.0f;
        float r113 = getTop(r111);
        new Canvas(r108).drawBitmap(r102, null, new RectF(r112, r113, r110 + r112, r111 + r113), null);
        return r108;
    L11:
        r107 = Bitmap.Config.ARGB_8888;
        goto L12
    }
}
