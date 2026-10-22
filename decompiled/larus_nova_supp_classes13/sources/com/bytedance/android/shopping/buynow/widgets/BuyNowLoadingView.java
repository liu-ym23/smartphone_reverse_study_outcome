package com.bytedance.android.shopping.buynow.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.android.ec.core.imagex.h0;
import com.bytedance.android.shopping.buynow.components.SkeletonMode;
import com.bytedance.android.ui.base.widget.round.RoundConstraintLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/buynow/widgets/BuyNowLoadingView;", "Lcom/bytedance/android/ui/base/widget/round/RoundConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyNowLoadingView extends RoundConstraintLayout {
    public static final /* synthetic */ int g = 0;
    public final BuyNowDoubleColorBallAnimationView a;
    public final SimpleDraweeView b;
    public final SimpleDraweeView c;
    public final SimpleDraweeView d;
    public final SimpleDraweeView e;
    public final View f;

    public BuyNowLoadingView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public BuyNowLoadingView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void S5() {
        this.a.d();
        setVisibility(8);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.f.setVisibility(8);
        this.d.setVisibility(8);
        this.e.setVisibility(8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BuyNowLoadingView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131559221, this, true);
        this.a = (BuyNowDoubleColorBallAnimationView) findViewById(2131379094);
        this.b = findViewById(2131386818);
        this.c = findViewById(2131391838);
        this.d = findViewById(2131383886);
        this.e = findViewById(2131367903);
        this.f = findViewById(2131386865);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(boolean r2, boolean r3, SkeletonMode r4) {
        setVisibility(0);
        if (r3 == false) goto L5;
        this.a.c();
    L5:
        if (r2 == false) goto L17;
        if (r4 != SkeletonMode.ONLY_PAY) goto L10;
        this.d.setVisibility(0);
        h0 r5 = h0.a;
        h0.a(this.d, 2131232448);
        return;
    L10:
        if (r4 != SkeletonMode.CONTINUE_PAY) goto L13;
        this.e.setVisibility(0);
        h0 r6 = h0.a;
        h0.a(this.e, 2131233669);
        return;
    L13:
        if (r4 != SkeletonMode.ULTIMATE) goto L15;
        this.c.setVisibility(0);
        return;
    L15:
        this.b.setVisibility(0);
        h0 r7 = h0.a;
        h0.a(this.b, 2131232447);
        return;
    L17:
        if (r4 != SkeletonMode.ONLY_PAY) goto L20;
        this.d.setVisibility(8);
        return;
    L20:
        if (r4 != SkeletonMode.CONTINUE_PAY) goto L23;
        this.e.setVisibility(8);
        return;
    L23:
        if (r4 != SkeletonMode.ULTIMATE) goto L25;
        this.c.setVisibility(8);
        this.f.setVisibility(8);
        return;
    L25:
        this.b.setVisibility(8);
    }

    public /* synthetic */ BuyNowLoadingView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
