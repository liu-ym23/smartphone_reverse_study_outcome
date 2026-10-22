package com.bytedance.android.shopping.buynow.container;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/buynow/container/BuyNowRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BuyNowRecyclerView extends RecyclerView {
    public float a;
    public boolean b;
    public final com.bytedance.android.shopping.buynow.controller.m c;

    public BuyNowRecyclerView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = new com.bytedance.android.shopping.buynow.controller.m(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "ev");
        if (r5.getAction() != 1) goto L5;
    L10:
        this.b = false;
    L11:
        float r0 = this.a;
        if (r0 == 0.0f) goto L15;
        r5.offsetLocation(0.0f, r0);
    L15:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r5);
    L5:
        if (r5.getAction() == 3) goto L10;
        if (r5.getAction() != 0) goto L11;
        this.a = 0.0f;
        this.b = true;
        goto L11
    }

    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "e");
        com.bytedance.android.shopping.buynow.controller.m r0 = this.c;
        if (r0 == null) goto L9;
        Boolean r1 = r0.b(r2);
        if (r1 == null) goto L9;
        return r1.booleanValue();
    L9:
        return super.onInterceptTouchEvent(r2);
    }

    public BuyNowRecyclerView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.c = new com.bytedance.android.shopping.buynow.controller.m(this);
    }

    public BuyNowRecyclerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = new com.bytedance.android.shopping.buynow.controller.m(this);
    }

    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super.onSizeChanged(r1, r2, r3, r4);
        if (this.b == false) goto L7;
        if (r4 == r2) goto L8;
        this.a = r4 - r2;
        return;
    L8:
        return;
    }
}
