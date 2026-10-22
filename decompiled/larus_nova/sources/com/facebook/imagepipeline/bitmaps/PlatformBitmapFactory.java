package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.DisplayMetrics;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public abstract class PlatformBitmapFactory {

    /* JADX INFO: renamed from: com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes23.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$graphics$Bitmap$Config = null;

        static {
            int[] r100 = new int[Bitmap.Config.values().length];
            $SwitchMap$android$graphics$Bitmap$Config = r100;
            r100[Bitmap.Config.RGB_565.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ALPHA_8.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.HARDWARE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_4444.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            $SwitchMap$android$graphics$Bitmap$Config[Bitmap.Config.ARGB_8888.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public PlatformBitmapFactory() {
    }

    public abstract CloseableReference<Bitmap> createBitmapInternal(int r100, int r101, Bitmap.Config r102);

    private static Bitmap.Config getSuitableBitmapConfig(Bitmap r100) {
        Bitmap.Config r101 = Bitmap.Config.ARGB_8888;
        Bitmap.Config r102 = r100.getConfig();
        if (r102 == null) goto L17;
        int r103 = AnonymousClass1.$SwitchMap$android$graphics$Bitmap$Config[r102.ordinal()];
        if (r103 == 1) goto L16;
        if (r103 == 2) goto L21;
        if (r103 == 3) goto L12;
        return Bitmap.Config.ARGB_8888;
    L12:
        if (Build.VERSION.SDK_INT >= 26) goto L20;
        return r101;
    L20:
        return Bitmap.Config.HARDWARE;
    L21:
        return Bitmap.Config.ALPHA_8;
    L16:
        return Bitmap.Config.RGB_565;
    L17:
        return r101;
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap r100) {
        return createBitmap(r100, null);
    }

    private static void checkWidthHeight(int r100, int r101) {
        boolean r102 = true;
        if (r100 <= 0) goto L5;
        boolean r103 = true;
    L6:
        Preconditions.checkArgument(r103, "width must be > 0");
        if (r101 > 0) goto L10;
        r102 = false;
    L10:
        Preconditions.checkArgument(r102, "height must be > 0");
        return;
    L5:
        r103 = false;
        goto L6
    }

    private static void checkXYSign(int r100, int r101) {
        boolean r102 = true;
        if (r100 < 0) goto L5;
        boolean r103 = true;
    L6:
        Preconditions.checkArgument(r103, "x must be >= 0");
        if (r101 >= 0) goto L10;
        r102 = false;
    L10:
        Preconditions.checkArgument(r102, "y must be >= 0");
        return;
    L5:
        r103 = false;
        goto L6
    }

    private static void setPropertyFromSourceBitmap(Bitmap r100, Bitmap r101) {
        r101.setDensity(r100.getDensity());
        r101.setHasAlpha(r100.hasAlpha());
        r101.setPremultiplied(r100.isPremultiplied());
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap r100, @Nullable Object r101) {
        return createBitmap(r100, 0, 0, r100.getWidth(), r100.getHeight(), r101);
    }

    public CloseableReference<Bitmap> createBitmap(int r100, int r101) {
        return createBitmap(r100, r101, Bitmap.Config.ARGB_8888);
    }

    public CloseableReference<Bitmap> createBitmap(int r100, int r101, @Nullable Object r102) {
        return createBitmap(r100, r101, Bitmap.Config.ARGB_8888, r102);
    }

    public CloseableReference<Bitmap> createBitmap(int r100, int r101, Bitmap.Config r102) {
        return createBitmap(r100, r101, r102, null);
    }

    private CloseableReference<Bitmap> createBitmap(int r100, int r101, Bitmap.Config r102, boolean r110) {
        return createBitmap(r100, r101, r102, r110, null);
    }

    public CloseableReference<Bitmap> createScaledBitmap(Bitmap r100, int r101, int r102, boolean r110) {
        return createScaledBitmap(r100, r101, r102, r110, null);
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics r100, int r101, int r102, Bitmap.Config r110) {
        return createBitmap(r100, r101, r102, r110, null);
    }

    public CloseableReference<Bitmap> createBitmap(int[] r100, int r101, int r102, Bitmap.Config r110) {
        return createBitmap(r100, r101, r102, r110, null);
    }

    public CloseableReference<Bitmap> createBitmap(int r100, int r101, Bitmap.Config r102, @Nullable Object r103) {
        return createBitmapInternal(r100, r101, r102);
    }

    private static void checkFinalImageBounds(Bitmap r100, int r101, int r102, int r103, int r104) {
        boolean r105 = true;
        if ((r101 + r103) > r100.getWidth()) goto L5;
        boolean r106 = true;
    L6:
        Preconditions.checkArgument(r106, "x + width must be <= bitmap.width()");
        if ((r102 + r104) <= r100.getHeight()) goto L10;
        r105 = false;
    L10:
        Preconditions.checkArgument(r105, "y + height must be <= bitmap.height()");
        return;
    L5:
        r106 = false;
        goto L6
    }

    public CloseableReference<Bitmap> createBitmap(int[] r100, int r110, int r111, Bitmap.Config r112, @Nullable Object r113) {
        CloseableReference<Bitmap> r114 = createBitmapInternal(r110, r111, r112);
        r114.get().setPixels(r100, 0, r110, 0, 0, r110, r111);
        return r114;
    }

    public CloseableReference<Bitmap> createScaledBitmap(Bitmap r110, int r111, int r112, boolean r113, @Nullable Object r114) {
        checkWidthHeight(r111, r112);
        Matrix r100 = new Matrix();
        int r101 = r110.getWidth();
        int r102 = r110.getHeight();
        r100.setScale(r111 / r101, r112 / r102);
        return createBitmap(r110, 0, 0, r101, r102, r100, r113, r114);
    }

    private CloseableReference<Bitmap> createBitmap(int r100, int r101, Bitmap.Config r110, boolean r111, @Nullable Object r112) {
        return createBitmap(null, r100, r101, r110, r111, r112);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap r100, int r101, int r110, int r111, int r112) {
        return createBitmap(r100, r101, r110, r111, r112, null);
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics r100, int r101, int r110, Bitmap.Config r111, @Nullable Object r112) {
        return createBitmap(r100, r101, r110, r111, true, r112);
    }

    private CloseableReference<Bitmap> createBitmap(DisplayMetrics r100, int r101, int r110, Bitmap.Config r111, boolean r112) {
        return createBitmap(r100, r101, r110, r111, r112, null);
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics r100, int[] r101, int r110, int r111, Bitmap.Config r112) {
        return createBitmap(r100, r101, r110, r111, r112, null);
    }

    private CloseableReference<Bitmap> createBitmap(DisplayMetrics r100, int r101, int r102, Bitmap.Config r103, boolean r104, @Nullable Object r105) {
        checkWidthHeight(r101, r102);
        CloseableReference<Bitmap> r106 = createBitmapInternal(r101, r102, r103);
        Bitmap r107 = r106.get();
        if (r100 == null) goto L5;
        r107.setDensity(r100.densityDpi);
    L5:
        r107.setHasAlpha(r104);
        if (r103 != Bitmap.Config.ARGB_8888) goto L9;
        if (r104 == true) goto L9;
        r107.eraseColor(-16777216);
    L9:
        return r106;
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap r110, int r111, int r112, int r113, int r114, @Nullable Object r115) {
        return createBitmap(r110, r111, r112, r113, r114, null, false, r115);
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics r110, int[] r111, int r112, int r113, Bitmap.Config r114, @Nullable Object r115) {
        return createBitmap(r110, r111, 0, r112, r112, r113, r114, r115);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap r110, int r111, int r112, int r113, int r114, @Nullable Matrix r115, boolean r116) {
        return createBitmap(r110, r111, r112, r113, r114, r115, r116, null);
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics r110, int[] r111, int r112, int r113, int r114, int r115, Bitmap.Config r116) {
        return createBitmap(r110, r111, r112, r113, r114, r115, r116, null);
    }

    public CloseableReference<Bitmap> createBitmap(Bitmap r110, int r111, int r112, int r210, int r211, @Nullable Matrix r212, boolean r213, @Nullable Object r214) {
        Preconditions.checkNotNull(r110, "Source bitmap cannot be null");
        checkXYSign(r111, r112);
        checkWidthHeight(r210, r211);
        checkFinalImageBounds(r110, r111, r112, r210, r211);
        Rect r100 = new Rect(r111, r112, r111 + r210, r112 + r211);
        RectF r101 = new RectF(0.0f, 0.0f, r210, r211);
        Bitmap.Config r102 = getSuitableBitmapConfig(r110);
        if (r212 != null) goto L5;
    L20:
        CloseableReference<Bitmap> r103 = createBitmap(r210, r211, r102, r110.hasAlpha(), r214);
        setPropertyFromSourceBitmap(r110, r103.get());
        Canvas r104 = new Canvas(r103.get());
        Paint r105 = null;
    L21:
        r104.drawBitmap(r110, r100, r101, r105);
        r104.setBitmap(null);
        return r103;
    L5:
        if (r212.isIdentity() == true) goto L20;
        boolean r106 = !r212.rectStaysRect();
        RectF r107 = new RectF();
        r212.mapRect(r107, r101);
        int r113 = Math.round(r107.width());
        int r114 = Math.round(r107.height());
        if (r106 == false) goto L10;
        r102 = Bitmap.Config.ARGB_8888;
    L10:
        Bitmap.Config r115 = r102;
        if (r106 == false) goto L13;
    L16:
        boolean r116 = true;
    L17:
        r103 = createBitmap(r113, r114, r115, r116, r214);
        setPropertyFromSourceBitmap(r110, r103.get());
        r104 = new Canvas(r103.get());
        r104.translate(-r107.left, -r107.top);
        r104.concat(r212);
        r105 = new Paint();
        r105.setFilterBitmap(r213);
        if (r106 == false) goto L21;
        r105.setAntiAlias(true);
        goto L21
    L13:
        if (r110.hasAlpha() == true) goto L16;
        r116 = false;
        goto L17
    }

    public CloseableReference<Bitmap> createBitmap(DisplayMetrics r110, int[] r111, int r112, int r113, int r114, int r115, Bitmap.Config r116, @Nullable Object r117) {
        CloseableReference<Bitmap> r100 = createBitmap(r110, r114, r115, r116, r117);
        r100.get().setPixels(r111, r112, r113, 0, 0, r114, r115);
        return r100;
    }
}
