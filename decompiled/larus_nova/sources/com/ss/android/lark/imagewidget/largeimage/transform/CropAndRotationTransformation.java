package com.ss.android.lark.imagewidget.largeimage.transform;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import com.alibaba.gaiax.template.GXMode;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.ss.android.lark.log.Log;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 +2\u00020\u0001:\u0001+B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J(\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0014J \u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0002J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0096\u0002J \u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010*\u001a\u00020\u001cH\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/ss/android/lark/imagewidget/largeimage/transform/CropAndRotationTransformation;", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", GXMode.MODE_TYPE_CROP, "", "mRotation", "", "<init>", "([FF)V", "getCrop", "()[F", "getMRotation", "()F", "DEFAULT_PAINT", "Landroid/graphics/Paint;", "ID", "", "ID_BYTES", "", "updateDiskCacheKey", "", "p0", "Ljava/security/MessageDigest;", "transform", "Landroid/graphics/Bitmap;", "pool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "inBitmap", "width", "", "height", "applyMatrix", "targetBitmap", "matrix", "Landroid/graphics/Matrix;", "equals", "", "other", "", "getBitmapRect", "Landroid/graphics/Rect;", "sourceWidth", "sourceHeight", "hashCode", "Companion", "imagewidget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CropAndRotationTransformation extends BitmapTransformation {
    public static final a Companion = null;
    private static final String TAG = null;
    private final Paint DEFAULT_PAINT;
    private final String ID;
    private final byte[] ID_BYTES;
    private final float[] crop;
    private final float mRotation;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        TAG = "CropAndRotationTransformation";
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        float[] r100 = this.crop;
        if (r100 == null) goto L5;
        int r101 = Arrays.hashCode(r100);
    L7:
        return (r101 * 31) + Float.floatToIntBits(this.mRotation);
    L5:
        r101 = 0;
        goto L7
    }

    public static final /* synthetic */ String access$getTAG$cp() {
        return TAG;
    }

    public final float[] getCrop() {
        return this.crop;
    }

    public final float getMRotation() {
        return this.mRotation;
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if ((r100 instanceof CropAndRotationTransformation) == true) goto L5;
        return false;
    L5:
        CropAndRotationTransformation r101 = (CropAndRotationTransformation) r100;
        if (this.mRotation != r101.mRotation) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L12;
        return false;
    L12:
        if (Arrays.equals(this.crop, r101.crop) == true) goto L14;
        return false;
    L14:
        return true;
    L8:
        r102 = false;
        goto L9
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        Intrinsics.checkNotNullParameter(r100, "p0");
        r100.update(this.ID_BYTES);
    }

    public CropAndRotationTransformation(float[] r100, float r101) {
        this.crop = r100;
        this.mRotation = r101;
        this.DEFAULT_PAINT = new Paint(6);
        this.ID = "com.bytedance.ee.bear.thumbnail.CropAndRotationTransformation";
        this.ID_BYTES = "com.bytedance.ee.bear.thumbnail.CropAndRotationTransformation".getBytes(Key.CHARSET);
    }

    private final synchronized void applyMatrix(Bitmap r100, Bitmap r101, Matrix r102) {
        monitor-enter(this);
        Canvas r103 = new Canvas(r101);     // Catch: Throwable -> L6
        r103.drawBitmap(r100, r102, this.DEFAULT_PAINT);     // Catch: Throwable -> L6
        r103.setBitmap(null);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    private final Rect getBitmapRect(int r100, int r101, float[] r102) {
        float r103 = r100;
        float r104 = r101;
        return new Rect((int) (r102[0] * r103), (int) (r102[1] * r104), (int) (r103 * r102[2]), (int) (r104 * r102[3]));
    }

    public /* synthetic */ CropAndRotationTransformation(float[] r100, float r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = 0.0f;
    L5:
        this(r100, r101);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool r100, Bitmap r101, int r102, int r110) {
        Intrinsics.checkNotNullParameter(r100, "pool");
        Intrinsics.checkNotNullParameter(r101, "inBitmap");
        int r103 = 0;
        if (this.mRotation != 0.0f) goto L5;
        boolean r104 = true;
    L7:
        if (r104 == false) goto L14;
        float[] r105 = this.crop;
        if (r105 != null) goto L11;
    L12:
        Log.i(TAG, "return the inBitmap");
        return r101;
    L11:
        if (r105.length != 4) goto L12;
    L14:
        Log.i(TAG, "crop and rotation");
        Matrix r106 = new Matrix();
        float[] r107 = this.crop;
        if (r107 != null) goto L17;
    L19:
        Rect r108 = null;
    L20:
        if (r108 != null) goto L22;
        int r109 = 0;
    L31:
        r106.postTranslate(-r103, -r109);
        r106.postRotate(this.mRotation);
        if (r101.getConfig() == null) goto L34;
        Bitmap.Config r111 = r101.getConfig();
    L35:
        Bitmap r112 = r100.get(r102, r110, r111);
        r112.setHasAlpha(r101.hasAlpha());
        applyMatrix(r101, r112, r106);
        return r112;
    L34:
        r111 = Bitmap.Config.ARGB_8888;
        goto L35
    L22:
        if (r108.left <= r101.getWidth()) goto L24;
        int r113 = r101.getWidth();
    L25:
        r103 = r113;
        if (r108.top <= r101.getHeight()) goto L28;
        int r114 = r101.getHeight();
    L29:
        int r115 = Math.min(r108.width(), r101.getWidth());
        int r116 = Math.min(r108.height(), r101.getHeight());
        r109 = r114;
        r102 = r115;
        r110 = r116;
        goto L31
    L28:
        r114 = r108.top;
        goto L29
    L24:
        r113 = r108.left;
        goto L25
    L17:
        if (r107.length != 4) goto L19;
        r108 = getBitmapRect(r101.getWidth(), r101.getHeight(), this.crop);
        goto L20
    L5:
        r104 = false;
        goto L7
    }
}
