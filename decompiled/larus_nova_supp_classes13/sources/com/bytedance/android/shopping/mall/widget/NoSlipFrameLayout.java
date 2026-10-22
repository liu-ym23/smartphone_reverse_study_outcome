package com.bytedance.android.shopping.mall.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/mall/widget/NoSlipFrameLayout;", "Landroid/widget/FrameLayout;", "", "enableSlip", "", "setEnableControlSlip", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attributeSet", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class NoSlipFrameLayout extends FrameLayout {
    public boolean a;

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "ev");
        if (this.a == true) goto L7;
        return super.dispatchTouchEvent(r3);
    L7:
        if (r3.getAction() != 0) goto L11;
        getParent().requestDisallowInterceptTouchEvent(true);
    L11:
        return super.dispatchTouchEvent(r3);
    }

    public final void setEnableControlSlip(boolean r1) {
        this.a = r1;
    }

    public NoSlipFrameLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attributeSet");
        super(r2, r3);
    }
}
