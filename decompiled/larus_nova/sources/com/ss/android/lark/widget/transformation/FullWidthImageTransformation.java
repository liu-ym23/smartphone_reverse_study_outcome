package com.ss.android.lark.widget.transformation;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.security.MessageDigest;
import jp.wasabeef.glide.transformations.BitmapTransformation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J0\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0014¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/widget/transformation/FullWidthImageTransformation;", "Ljp/wasabeef/glide/transformations/BitmapTransformation;", "<init>", "()V", "equals", "", "other", "", "hashCode", "", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "transform", "Landroid/graphics/Bitmap;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "bitmapPool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "toTransform", "outWidth", "outHeight", "Companion", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FullWidthImageTransformation extends BitmapTransformation {
    public static final a Companion = null;
    private static final String ID = "FullWidthImageTransformation";
    private static final byte[] ID_BYTES = null;
    private static final String TAG = "FullWidthImageTransformation";

    public static final class a {
        public a() {
        }
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public int hashCode() {
        return -2090060947;
    }

    static {
        Companion = new a();
        ID_BYTES = "FullWidthImageTransformation".getBytes(Key.CHARSET);
    }

    public FullWidthImageTransformation() {
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public boolean equals(Object r100) {
        return r100 instanceof FullWidthImageTransformation;
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation, com.bumptech.glide.load.Key
    public void updateDiskCacheKey(MessageDigest r100) {
        Intrinsics.checkNotNullParameter(r100, "messageDigest");
        r100.update(ID_BYTES);
    }

    @Override // jp.wasabeef.glide.transformations.BitmapTransformation
    public Bitmap transform(Context r100, BitmapPool r101, Bitmap r102, int r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bitmapPool");
        Intrinsics.checkNotNullParameter(r102, "toTransform");
        String r103 = UIHelper.getString(R.string.Lark_Groups_PostPhotostrip);
        Paint r112 = new Paint();
        r112.setTextSize(UIUtils.sp2px(r100, 10.0f));
        r112.setColor(UIUtils.getColor(r100, R.color.static_white));
        Rect r113 = new Rect();
        r112.getTextBounds(r103, 0, r103.length(), r113);
        Paint r104 = new Paint();
        r104.setColor(UIUtils.getColor(r100, R.color.static_black_50));
        Rect r105 = new Rect();
        r105.left = 0;
        r105.top = r102.getHeight() - UIUtils.dp2px(r100, 16.0f);
        r105.right = r102.getWidth();
        r105.bottom = r102.getHeight();
        if (r102.getWidth() <= 60) goto L5;
        Canvas r106 = new Canvas(r102);
        r106.drawRect(r105, r104);
        float r107 = ((r105.bottom - (r105.height() / 2.0f)) + (r113.height() / 2)) - r112.descent();
        Log.d("FullWidthImageTransformation", "text y  " + r105.bottom + ' ' + r113.height() + ' ');
        r106.drawText(r103, ((float) (r105.width() - r113.width())) / 2.0f, r107, r112);
    L5:
        return r102;
    }
}
