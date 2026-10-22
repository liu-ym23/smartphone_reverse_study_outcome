package com.bytedance.ee.bear.bitable.share.sharepanel;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.TransformationUtils;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/share/sharepanel/FourRoundedCorners;", "Lcom/bumptech/glide/load/resource/bitmap/BitmapTransformation;", "topLeft", "", "topRight", "bottomRight", "bottomLeft", "<init>", "(FFFF)V", "id", "", "idBytes", "", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "transform", "Landroid/graphics/Bitmap;", "pool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "toTransform", "outWidth", "", "outHeight", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FourRoundedCorners extends BitmapTransformation {
    private final float bottomLeft;
    private final float bottomRight;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f215430id;
    private final byte[] idBytes;
    private final float topLeft;
    private final float topRight;

    @Override // com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        Intrinsics.checkNotNullParameter(r100, "messageDigest");
        r100.update(this.idBytes);
        r100.update(ByteBuffer.allocate(16).putFloat(this.topLeft).putFloat(this.topRight).putFloat(this.bottomRight).putFloat(this.bottomLeft).array());
    }

    public FourRoundedCorners(float r100, float r101, float r102, float r103) {
        this.topLeft = r100;
        this.topRight = r101;
        this.bottomRight = r102;
        this.bottomLeft = r103;
        this.f215430id = "com.bytedance.ee.bear.bitable.share.sharepanel.FourRoundedCorners";
        this.idBytes = "com.bytedance.ee.bear.bitable.share.sharepanel.FourRoundedCorners".getBytes(Key.CHARSET);
    }

    @Override // com.bumptech.glide.load.resource.bitmap.BitmapTransformation
    public Bitmap transform(BitmapPool r100, Bitmap r101, int r102, int r110) {
        Intrinsics.checkNotNullParameter(r100, "pool");
        Intrinsics.checkNotNullParameter(r101, "toTransform");
        return TransformationUtils.roundedCorners(r100, r101, this.topLeft, this.topRight, this.bottomRight, this.bottomLeft);
    }
}
