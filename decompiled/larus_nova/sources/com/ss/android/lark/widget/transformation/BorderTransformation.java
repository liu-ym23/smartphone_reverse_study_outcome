package com.ss.android.lark.widget.transformation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.security.MessageDigest;
import java.util.Objects;
import jp.wasabeef.glide.transformations.BitmapTransformation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005¢\u0006\u0004\b\u000e\u0010\u000fJ0\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020,2\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u0005H\u0014J\u0018\u00104\u001a\u0002052\u0006\u00106\u001a\u0002072\u0006\u00101\u001a\u00020,H\u0002J\u0010\u00108\u001a\u0002052\u0006\u00106\u001a\u000207H\u0002J\u0013\u00109\u001a\u00020\u000b2\b\u0010:\u001a\u0004\u0018\u00010;H\u0096\u0002J\b\u0010<\u001a\u00020\u0005H\u0016J\b\u0010=\u001a\u00020\u0003H\u0016J\b\u0010>\u001a\u00020*H\u0002J\u0010\u0010?\u001a\u0002052\u0006\u0010@\u001a\u00020AH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0013R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\"¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/ss/android/lark/widget/transformation/BorderTransformation;", "Ljp/wasabeef/glide/transformations/BitmapTransformation;", "resUrl", "", "imageWidth", "", "imageHeight", "viewWidth", "viewHeight", "radius", "drawBg", "", "bgColor", "borderColor", "<init>", "(Ljava/lang/String;IIIIIZII)V", "getResUrl", "()Ljava/lang/String;", "getImageWidth", "()I", "getImageHeight", "getViewWidth", "getViewHeight", "getRadius", "getDrawBg", "()Z", "getBgColor", "getBorderColor", "borderWidth", "getBorderWidth", "setBorderWidth", "(I)V", "IMAGE_MIN_SIZE_NEW_IN_DIP", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "path", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "cacheKeyBytes", "", "transform", "Landroid/graphics/Bitmap;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bitmapPool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "toTransform", "outWidth", "outHeight", "drawBitmap", "", "canvas", "Landroid/graphics/Canvas;", "drawBorder", "equals", MapBundleKey.MapObjKey.OBJ_SL_OBJ, "", "hashCode", "toString", "getCacheKeyBytes", "updateDiskCacheKey", "messageDigest", "Ljava/security/MessageDigest;", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BorderTransformation extends BitmapTransformation {
    private final int IMAGE_MIN_SIZE_NEW_IN_DIP;
    private final int bgColor;
    private final int borderColor;
    private int borderWidth;
    private byte[] cacheKeyBytes;
    private final boolean drawBg;
    private final int imageHeight;
    private final int imageWidth;
    private final Paint paint;
    private final Path path;
    private final int radius;
    private final String resUrl;
    private final int viewHeight;
    private final int viewWidth;

    private final byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes != null) goto L5;
        this.cacheKeyBytes = toString().getBytes(Key.CHARSET);
    L5:
        byte[] r100 = this.cacheKeyBytes;
        Intrinsics.checkNotNull(r100);
        return r100;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public int hashCode() {
        return Objects.hash(new Object[]{this.resUrl, Integer.valueOf(this.imageWidth), Integer.valueOf(this.imageHeight), Integer.valueOf(this.viewWidth), Integer.valueOf(this.viewHeight), Integer.valueOf(this.radius), Boolean.valueOf(this.drawBg), Integer.valueOf(this.bgColor), Integer.valueOf(this.borderColor)});
    }

    public String toString() {
        return this.resUrl + '_' + this.imageWidth + '_' + this.imageHeight + '_' + this.bgColor + '_' + this.borderColor;
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public final int getBorderColor() {
        return this.borderColor;
    }

    public final int getBorderWidth() {
        return this.borderWidth;
    }

    public final boolean getDrawBg() {
        return this.drawBg;
    }

    public final int getImageHeight() {
        return this.imageHeight;
    }

    public final int getImageWidth() {
        return this.imageWidth;
    }

    public final Paint getPaint() {
        return this.paint;
    }

    public final Path getPath() {
        return this.path;
    }

    public final int getRadius() {
        return this.radius;
    }

    public final String getResUrl() {
        return this.resUrl;
    }

    public final int getViewHeight() {
        return this.viewHeight;
    }

    public final int getViewWidth() {
        return this.viewWidth;
    }

    private final void drawBorder(Canvas r100) {
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setColor(this.borderColor);
        this.paint.setStrokeWidth(this.borderWidth);
        RectF r101 = new RectF(0.0f, 0.0f, this.viewWidth, this.viewHeight);
        float r102 = (this.borderWidth * 1.0f) / 2;
        r101.inset(r102, r102);
        this.path.reset();
        Path r103 = this.path;
        int r104 = this.radius;
        r103.addRoundRect(r101, r104, r104, Path.Direction.CW);
        r100.drawPath(this.path, this.paint);
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if ((r100 instanceof BorderTransformation) == true) goto L5;
        return false;
    L5:
        BorderTransformation r101 = (BorderTransformation) r100;
        if (Intrinsics.areEqual(this.resUrl, r101.resUrl) == true) goto L8;
        return false;
    L8:
        if (this.imageWidth == r101.imageWidth) goto L10;
        return false;
    L10:
        if (this.imageHeight == r101.imageHeight) goto L12;
        return false;
    L12:
        if (this.viewWidth == r101.viewWidth) goto L14;
        return false;
    L14:
        if (this.viewHeight == r101.viewHeight) goto L16;
        return false;
    L16:
        if (this.drawBg == r101.drawBg) goto L18;
        return false;
    L18:
        if (this.bgColor == r101.bgColor) goto L20;
        return false;
    L20:
        if (this.borderColor != r101.borderColor) goto L30;
        return true;
    L30:
        return false;
    }

    public final void setBorderWidth(int r100) {
        this.borderWidth = r100;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        Intrinsics.checkNotNullParameter(r100, "messageDigest");
        r100.update(getCacheKeyBytes());
    }

    private final void drawBitmap(Canvas r100, Bitmap r110) {
        float r101 = 2;
        float r102 = ((this.viewWidth - this.imageWidth) * 1.0f) / r101;
        float r103 = ((this.viewHeight - this.imageHeight) * 1.0f) / r101;
        int r104 = r100.getSaveCount();
        r100.save();
        if (r102 > 0.0f) goto L7;
        if (r103 > 0.0f) goto L7;
    L10:
        RectF r105 = new RectF(0.0f, 0.0f, this.viewWidth, this.viewHeight);
        int r106 = this.borderWidth;
        r105.inset(r106, r106);
        this.path.reset();
        int r107 = this.radius;
        boolean r108 = false;
        if (r102 <= 0.0f) goto L13;
    L14:
        r107 = 0;
    L15:
        float r109 = r107;
        this.path.addRoundRect(r105, r109, r109, Path.Direction.CW);
        r100.clipPath(this.path);
        if (r110.getWidth() == this.imageWidth) goto L18;
    L21:
        boolean r111 = true;
    L23:
        if (this.viewWidth != UIHelper.dp2px(this.IMAGE_MIN_SIZE_NEW_IN_DIP)) goto L25;
    L26:
        r108 = true;
    L27:
        if (r111 == false) goto L30;
        if (r108 == true) goto L30;
        r100.drawBitmap(r110, null, r105, this.paint);
    L31:
        r100.restoreToCount(r104);
        return;
    L30:
        r100.drawBitmap(r110, 0.0f, 0.0f, this.paint);
        goto L31
    L25:
        if (this.viewHeight != UIHelper.dp2px(this.IMAGE_MIN_SIZE_NEW_IN_DIP)) goto L27;
    L18:
        if (r110.getHeight() != this.imageHeight) goto L21;
        r111 = false;
        goto L23
    L13:
        if (r103 <= 0.0f) goto L15;
    L7:
        if (this.drawBg == false) goto L9;
        r100.drawColor(this.bgColor);
    L9:
        r100.translate(r102, r103);
        goto L10
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public Bitmap transform(Context r100, BitmapPool r101, Bitmap r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bitmapPool");
        Intrinsics.checkNotNullParameter(r102, "toTransform");
        if (r102.getConfig() == null) goto L5;
        Bitmap.Config r105 = r102.getConfig();
    L6:
        Bitmap r106 = r101.get(this.viewWidth, this.viewHeight, r105);
        r106.setHasAlpha(true);
        Canvas r107 = new Canvas(r106);
        drawBitmap(r107, r102);
        drawBorder(r107);
        return r106;
    L5:
        r105 = Bitmap.Config.ARGB_8888;
        goto L6
    }

    public BorderTransformation(String r100, int r101, int r102, int r103, int r104, int r105, boolean r106, int r107, int r110) {
        Intrinsics.checkNotNullParameter(r100, "resUrl");
        this.resUrl = r100;
        this.imageWidth = r101;
        this.imageHeight = r102;
        this.viewWidth = r103;
        this.viewHeight = r104;
        this.radius = r105;
        this.drawBg = r106;
        this.bgColor = r107;
        this.borderColor = r110;
        this.borderWidth = UIHelper.dp2px(0.5f);
        this.IMAGE_MIN_SIZE_NEW_IN_DIP = 40;
        this.paint = new Paint();
        this.path = new Path();
    }
}
