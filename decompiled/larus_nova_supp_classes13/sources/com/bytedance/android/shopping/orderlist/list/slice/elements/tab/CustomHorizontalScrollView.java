package com.bytedance.android.shopping.orderlist.list.slice.elements.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.HorizontalScrollView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u000eB'\b\u0007\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¨\u0006\u000f"}, d2 = {"Lcom/bytedance/android/shopping/orderlist/list/slice/elements/tab/CustomHorizontalScrollView;", "Landroid/widget/HorizontalScrollView;", "Lcom/bytedance/android/shopping/orderlist/list/slice/elements/tab/CustomHorizontalScrollView$a;", "listener", "", "setScrollListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CustomHorizontalScrollView extends HorizontalScrollView {
    public a a;

    public interface a {
        void a();
    }

    public CustomHorizontalScrollView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CustomHorizontalScrollView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void setScrollListener(a r1) {
        this.a = r1;
    }

    public CustomHorizontalScrollView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ CustomHorizontalScrollView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    @Override // android.view.View
    public final void onScrollChanged(int r1, int r2, int r3, int r4) {
        super.onScrollChanged(r1, r2, r3, r4);
        a r5 = this.a;
        if (r5 == null) goto L6;
        r5.a();
        return;
    }
}
