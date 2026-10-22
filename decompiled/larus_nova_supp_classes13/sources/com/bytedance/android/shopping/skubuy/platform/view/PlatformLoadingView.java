package com.bytedance.android.shopping.skubuy.platform.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import com.bytedance.android.ec.core.widget.DoubleColorBallAnimationView;
import com.bytedance.android.ui.base.widget.round.RoundConstraintLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/skubuy/platform/view/PlatformLoadingView;", "Lcom/bytedance/android/ui/base/widget/round/RoundConstraintLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlatformLoadingView extends RoundConstraintLayout {
    public final DoubleColorBallAnimationView a;
    public final PlatformBodySkeletonView b;
    public final PlatformFooterSkeletonView c;
    public final View d;
    public ObjectAnimator e;

    public PlatformLoadingView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public PlatformLoadingView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.view.ViewGroup*/.onDetachedFromWindow();
        ObjectAnimator r0 = this.e;
        if (r0 == null) goto L5;
        r0.cancel();
    L5:
        this.e = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PlatformLoadingView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        LayoutInflater.from(r2).inflate(2131564220, this, true);
        this.a = findViewById(2131379094);
        this.b = (PlatformBodySkeletonView) findViewById(2131386818);
        this.c = (PlatformFooterSkeletonView) findViewById(2131373151);
        this.d = findViewById(2131386865);
    }

    public /* synthetic */ PlatformLoadingView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
