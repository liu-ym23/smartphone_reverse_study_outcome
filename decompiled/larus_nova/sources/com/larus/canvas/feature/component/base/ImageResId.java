package com.larus.canvas.feature.component.base;

import android.widget.ImageView;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000bJ\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/larus/canvas/feature/component/base/ImageResId;", "Lcom/larus/canvas/feature/component/base/ImageRes;", "resId", "", "<init>", "(I)V", "loadImage", "", "imageView", "Landroid/widget/ImageView;", "setActualImageResource", "Lcom/facebook/drawee/view/SimpleDraweeView;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ImageResId implements ImageRes {
    public final int resId;

    public static /* synthetic */ ImageResId copy$default(ImageResId r100, int r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.resId;
    L6:
        return r100.copy(r101);
    }

    public final int component1() {
        return this.resId;
    }

    public final ImageResId copy(int r100) {
        return new ImageResId(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ImageResId) == true) goto L9;
        return false;
    L9:
        if (this.resId == ((ImageResId) r100).resId) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.resId;
    }

    public String toString() {
        return "ImageResId(resId=" + this.resId + ')';
    }

    public ImageResId(int r100) {
        this.resId = r100;
    }

    public final void loadImage(ImageView r100) {
        Intrinsics.checkNotNullParameter(r100, "imageView");
        r100.setImageResource(this.resId);
    }

    public final void setActualImageResource(SimpleDraweeView r100) {
        Intrinsics.checkNotNullParameter(r100, "imageView");
        r100.setActualImageResource(this.resId);
    }
}
