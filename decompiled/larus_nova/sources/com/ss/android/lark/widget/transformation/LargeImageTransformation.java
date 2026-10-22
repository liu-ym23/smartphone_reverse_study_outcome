package com.ss.android.lark.widget.transformation;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
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
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J0\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0014¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/widget/transformation/LargeImageTransformation;", "Ljp/wasabeef/glide/transformations/BitmapTransformation;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "transform", "Landroid/graphics/Bitmap;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bitmapPool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "toTransform", "outWidth", "outHeight", "Companion", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LargeImageTransformation extends BitmapTransformation {
    public static final a Companion = null;
    private static final String ID = "LargeImageTransformation";
    private static final byte[] ID_BYTES = null;

    public static final class a {
        public a() {
        }
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public int hashCode() {
        return -953137623;
    }

    static {
        Companion = new a();
        ID_BYTES = ID.getBytes(Key.CHARSET);
    }

    public LargeImageTransformation() {
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        return r100 instanceof LargeImageTransformation;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        Intrinsics.checkNotNullParameter(r100, "messageDigest");
        r100.update(ID_BYTES);
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public Bitmap transform(Context r100, BitmapPool r110, Bitmap r111, int r112, int r113) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r110, "bitmapPool");
        Intrinsics.checkNotNullParameter(r111, "toTransform");
        Application r101 = scc.a.f541411a;
        Intrinsics.checkNotNullParameter(r111, "srcBitmap");
        return scc.a.c(r111, scc.a.d(null, null, UIHelper.getString(R.string.Lark_Groups_PostPhotostrip), 0, 0, false, false, 120), 2);
    }
}
