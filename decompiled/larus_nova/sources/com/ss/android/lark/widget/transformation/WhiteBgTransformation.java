package com.ss.android.lark.widget.transformation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.larus.nova.R;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.security.MessageDigest;
import jp.wasabeef.glide.transformations.BitmapTransformation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J0\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rH\u0014R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/widget/transformation/WhiteBgTransformation;", "Ljp/wasabeef/glide/transformations/BitmapTransformation;", "<init>", "()V", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "equals", "", "other", "", "hashCode", "", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "transform", "Landroid/graphics/Bitmap;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bitmapPool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "toTransform", "outWidth", "outHeight", "Companion", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WhiteBgTransformation extends BitmapTransformation {
    public static final a Companion = null;
    private static final String ID = "AlphaTransformation";
    private static final byte[] ID_BYTES = null;
    private final Paint paint;

    public static final class a {
        public a() {
        }
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public int hashCode() {
        return -2144298009;
    }

    static {
        Companion = new a();
        ID_BYTES = ID.getBytes(Key.CHARSET);
    }

    public WhiteBgTransformation() {
        this.paint = new Paint();
    }

    public final Paint getPaint() {
        return this.paint;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        return r100 instanceof WhiteBgTransformation;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        Intrinsics.checkNotNullParameter(r100, "messageDigest");
        r100.update(ID_BYTES);
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public Bitmap transform(Context r100, BitmapPool r101, Bitmap r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bitmapPool");
        Intrinsics.checkNotNullParameter(r102, "toTransform");
        int r105 = r102.getWidth();
        int r106 = r102.getHeight();
        if (r102.getConfig() == null) goto L5;
        Bitmap.Config r107 = r102.getConfig();
    L6:
        Bitmap r108 = r101.get(r105, r106, r107);
        r108.setHasAlpha(true);
        Canvas r109 = new Canvas(r108);
        r109.drawColor(UIHelper.getColor(R.color.static_white));
        r109.drawBitmap(r102, 0.0f, 0.0f, this.paint);
        return r108;
    L5:
        r107 = Bitmap.Config.ARGB_8888;
        goto L6
    }
}
