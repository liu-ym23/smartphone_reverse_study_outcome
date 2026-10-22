package com.bytedance.android.shopping.store.mall.follows;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import hj3.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/shopping/store/mall/follows/ECLoadingShadowView;", "Landroid/widget/FrameLayout;", "Landroid/util/AttributeSet;", "b", "Landroid/util/AttributeSet;", "getAttrs", "()Landroid/util/AttributeSet;", "attrs", "Landroid/content/Context;", "context", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECLoadingShadowView extends FrameLayout {
    public ObjectAnimator a;
    public final AttributeSet b;

    public ECLoadingShadowView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECLoadingShadowView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final AttributeSet getAttrs() {
        return this.b;
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "changedView");
        super.onVisibilityChanged(r2, r3);
        if (r3 != 0) goto L5;
        View r4 = findViewById(2131386044);
        r4.post(new a(this, r4));
        return;
    L5:
        ObjectAnimator r5 = this.a;
        if (r5 != null) goto L8;
        return;
    L8:
        if (r5.isRunning() != true) goto L15;
        ObjectAnimator r6 = this.a;
        if (r6 == null) goto L16;
        r6.cancel();
        return;
    L16:
        return;
    }

    public ECLoadingShadowView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.b = r3;
        LayoutInflater.from(getContext()).inflate(2131560895, this);
    }

    public /* synthetic */ ECLoadingShadowView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
