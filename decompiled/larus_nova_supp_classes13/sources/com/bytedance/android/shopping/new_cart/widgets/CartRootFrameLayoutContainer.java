package com.bytedance.android.shopping.new_cart.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.bytedance.android.shopping.anchorv4.widgets.TopRoundFrameLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/shopping/new_cart/widgets/CartRootFrameLayoutContainer;", "Lcom/bytedance/android/shopping/anchorv4/widgets/TopRoundFrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CartRootFrameLayoutContainer extends TopRoundFrameLayout {
    public final List<a> e;

    public interface a {
        void c(MotionEvent r1);
    }

    public CartRootFrameLayoutContainer(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CartRootFrameLayoutContainer(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void b(a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (((ArrayList) this.e).contains(r2) == true) goto L6;
        ((ArrayList) this.e).add(r2);
        return;
    }

    public final boolean dispatchTouchEvent(MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "ev");
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        ((a) r0.next()).c(r3);
        goto L4
    L7:
        return super.dispatchTouchEvent(r3);
    }

    public CartRootFrameLayoutContainer(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.e = new ArrayList();
    }

    public /* synthetic */ CartRootFrameLayoutContainer(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
