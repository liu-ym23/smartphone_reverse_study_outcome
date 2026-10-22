package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/ECShopMarqueeLogoView;", "Lcom/facebook/drawee/view/SimpleDraweeView;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECShopMarqueeLogoView extends SimpleDraweeView {
    public final Path a;
    public final Path b;

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r6) {
        Intrinsics.checkNotNullParameter(r6, "canvas");
        this.a.reset();
        this.b.reset();
        float r0 = com.bytedance.android.ec.core.utils.q.a(Float.valueOf(12.0f));
        float r1 = getWidth() / 2;
        float r2 = getWidth() / 2;
        this.a.addCircle(r1, r1, r1, Path.Direction.CW);
        this.b.addCircle(-10.0f, r2, r0, Path.Direction.CW);
        this.a.op(this.b, Path.Op.DIFFERENCE);
        r6.clipPath(this.a);
        super/*android.widget.ImageView*/.onDraw(r6);
    }

    public ECShopMarqueeLogoView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        this.a = new Path();
        this.b = new Path();
    }
}
