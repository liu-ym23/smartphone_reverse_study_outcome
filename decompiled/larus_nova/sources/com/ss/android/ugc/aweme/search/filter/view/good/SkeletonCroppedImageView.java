package com.ss.android.ugc.aweme.search.filter.view.good;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/good/SkeletonCroppedImageView;", "Landroid/widget/ImageView;", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SkeletonCroppedImageView extends ImageView {
    public SkeletonCroppedImageView(Context r100) {
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public SkeletonCroppedImageView(Context r100, AttributeSet r101) {
        this(r100, r101, 4, 0);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDraw(Canvas r100) {
        Intrinsics.checkNotNullParameter(r100, "canvas");
        Drawable r101 = getDrawable();
        if (r101 != null) goto L17;
        return;
    L17:
        if ((r101 instanceof BitmapDrawable) == true) goto L8;
        r101 = null;
    L8:
        BitmapDrawable r102 = (BitmapDrawable) r101;     // Catch: Exception -> L16
        if (r102 == null) goto L11;
        Bitmap r103 = r102.getBitmap();     // Catch: Exception -> L16
    L12:
        r100.clipRect(0, 0, getWidth(), getHeight());     // Catch: Exception -> L16
        if (r103 == null) goto L19;
        r100.drawBitmap(r103, 0.0f, 0.0f, null);     // Catch: Exception -> L16
        getWidth();     // Catch: Exception -> L16
        return;
    L19:
        return;
    L11:
        r103 = null;
    }

    public SkeletonCroppedImageView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }

    public /* synthetic */ SkeletonCroppedImageView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
