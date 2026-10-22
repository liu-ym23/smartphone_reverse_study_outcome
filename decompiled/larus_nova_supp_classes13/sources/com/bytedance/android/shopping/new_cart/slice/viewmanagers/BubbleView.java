package com.bytedance.android.shopping.new_cart.slice.viewmanagers;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.render.elements.BaseSlcViewManager;
import com.bytedance.android.ecom.arch.slice.render.util.SlcViewExtensionsKt;
import com.bytedance.android.shopping.extensions.ViewExtensionsKt;
import com.bytedance.android.shopping.new_cart.widgets.CartRootFrameLayoutContainer;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/slice/viewmanagers/BubbleView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/android/shopping/new_cart/widgets/CartRootFrameLayoutContainer$a;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BubbleView extends ConstraintLayout implements CartRootFrameLayoutContainer.a {
    /* JADX WARN: Multi-variable type inference failed */
    public final void R5() {
        BaseSlcViewManager r0 = SlcViewExtensionsKt.g(this);
        if (r0 == null) goto L6;
        SlcCommonAction r2 = new SlcCommonAction("quitBubbleIconDidClick", MapsKt.emptyMap());
        r0.getTemplateContext().d(r2, this, r0.l(), null, null);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BubbleView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4);
        setBackgroundColor(-1);
        ViewExtensionsKt.g(this, 8.0f, 8.0f, 8.0f, 8.0f);
        setPadding(com.bytedance.android.shopping.extensions.b.a(12), com.bytedance.android.shopping.extensions.b.a(12), com.bytedance.android.shopping.extensions.b.a(12), com.bytedance.android.shopping.extensions.b.a(12));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.shopping.new_cart.widgets.CartRootFrameLayoutContainer.a
    public final void c(MotionEvent r11) {
        Intrinsics.checkNotNullParameter(r11, "ev");
        if (getVisibility() != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 != true) goto L17;
        int r1 = (int) r11.getRawX();
        int r12 = (int) r11.getRawY();
        int[] r3 = new int[2];
        getLocationOnScreen(r3);
        int r5 = r3[0];
        if (new Rect(r5, r3[1], getWidth() + r5, r3[1] + getHeight()).contains(r1, r12) == true) goto L11;
        R5();
        return;
    L11:
        int r4 = com.bytedance.android.shopping.extensions.b.a(40);
        if (new Rect((r3[0] + getWidth()) - r4, r3[1], r3[0] + getWidth(), r3[1] + r4).contains(r1, r12) == false) goto L16;
        R5();
        return;
    L16:
        return;
    L17:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
