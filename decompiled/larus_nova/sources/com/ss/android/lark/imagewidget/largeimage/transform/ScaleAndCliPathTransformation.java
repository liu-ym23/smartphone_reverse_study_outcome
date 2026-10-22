package com.ss.android.lark.imagewidget.largeimage.transform;

import android.graphics.Bitmap;
import android.graphics.Path;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Permission;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.lark.log.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0014J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0096\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/imagewidget/largeimage/transform/ScaleAndCliPathTransformation;", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", LiveDegradeFpsAnimator.SCALE_X, "", LiveDegradeFpsAnimator.SCALE_Y, SVGRenderEngine.CLIP_PATH, "", "path", "Landroid/graphics/Path;", "<init>", "(FFLjava/lang/String;Landroid/graphics/Path;)V", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "transform", "Landroid/graphics/Bitmap;", "pool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "inBitmap", "width", "", "height", "equals", "", "other", "", "hashCode", "Companion", "imagewidget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ScaleAndCliPathTransformation extends BitmapTransformation {
    public static final a Companion = null;
    private static final String ID = "com.bytedance.ee.bear.thumbnail.ScaleAndCliPathTransformation";
    private static final byte[] ID_BYTES = null;
    private static final String TAG = "ScaleAndCliPathTransformation";
    private final String clipPath;
    private final Path path;
    private final float scaleX;
    private final float scaleY;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
        ID_BYTES = ID.getBytes(Key.CHARSET);
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        int r100 = ((Float.floatToIntBits(this.scaleX) * 31) + Float.floatToIntBits(this.scaleY)) * 31;
        String r101 = this.clipPath;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        if ((r100 instanceof ScaleAndCliPathTransformation) == true) goto L5;
        return false;
    L5:
        ScaleAndCliPathTransformation r101 = (ScaleAndCliPathTransformation) r100;
        if (this.scaleX != r101.scaleX) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == true) goto L12;
        return false;
    L12:
        if (this.scaleY != r101.scaleY) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.clipPath, r101.clipPath) == true) goto L20;
        return false;
    L20:
        return true;
    L14:
        r103 = false;
        goto L15
    L8:
        r102 = false;
        goto L9
    }

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        Intrinsics.checkNotNullParameter(r100, "messageDigest");
        r100.update(ID_BYTES);
        ByteBuffer r101 = ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
        r101.putInt(Float.floatToIntBits(this.scaleX));
        r101.putInt(Float.floatToIntBits(this.scaleY));
        r100.update(r101.array());
        String r102 = this.clipPath;
        if (r102 == null) goto L6;
        byte[] r103 = r102.getBytes(Charsets.UTF_8);
        if (r103 == null) goto L6;
    L7:
        r100.update(r103);
        return;
    L6:
        r103 = new byte[0];
        goto L7
    }

    public ScaleAndCliPathTransformation(float r100, float r101, String r102, Path r103) {
        this.scaleX = r100;
        this.scaleY = r101;
        this.clipPath = r102;
        this.path = r103;
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(final BitmapPool r100, Bitmap r101, int r102, int r110) {
        Intrinsics.checkNotNullParameter(r100, "pool");
        Intrinsics.checkNotNullParameter(r101, "inBitmap");
        int r103 = com.ss.android.lark.imagewidget.largeimage.transform.a.f426681a;
        float r104 = this.scaleX;
        float r105 = this.scaleY;
        Path r106 = this.path;
        String r107 = this.clipPath;
        if (r107 != null) goto L5;
    L8:
        boolean r108 = true;
    L9:
        Bitmap r109 = com.ss.android.lark.imagewidget.largeimage.transform.a.a(r101, r104, r105, r106, !r108, new ScaleAndCliPathTransformation$transform$outBitmap$1(r100));
        Log.d(TAG, "transform result=" + r109.getWidth() + Permission.EXECUTE + r109.getHeight());
        return r109;
    L5:
        if (r107.length() == 0) goto L8;
        r108 = false;
        goto L9
    }
}
