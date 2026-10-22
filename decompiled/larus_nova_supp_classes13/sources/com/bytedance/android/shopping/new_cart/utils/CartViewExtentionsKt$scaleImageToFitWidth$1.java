package com.bytedance.android.shopping.new_cart.utils;

import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"applyMatrix", "", "invoke"}, k = 3, mv = {1, 4, 3})
public final class CartViewExtentionsKt$scaleImageToFitWidth$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ImageView $this_scaleImageToFitWidth;

    public CartViewExtentionsKt$scaleImageToFitWidth$1(ImageView r1) {
        this.$this_scaleImageToFitWidth = r1;
        super(0);
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1775invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1775invoke() {
        Drawable r0 = this.$this_scaleImageToFitWidth.getDrawable();
        if (r0 != null) goto L5;
        return;
    L5:
        float r1 = (this.$this_scaleImageToFitWidth.getWidth() - this.$this_scaleImageToFitWidth.getPaddingLeft()) - this.$this_scaleImageToFitWidth.getPaddingRight();
        float r2 = r0.getIntrinsicWidth();
        if (r2 > 0.0f) goto L8;
        return;
    L8:
        if (r1 <= 0.0f) goto L16;
        float r3 = r1 / r2;
        Matrix r4 = this.$this_scaleImageToFitWidth.getImageMatrix();
        if (r4 != null) goto L13;
        r4 = new Matrix();
    L13:
        r4.reset();
        r4.setScale(r3, r3);
        r4.postTranslate(0.0f, 0.0f);
        this.$this_scaleImageToFitWidth.setImageMatrix(r4);
        return;
    }
}
