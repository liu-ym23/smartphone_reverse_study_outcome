package com.bytedance.android.shopping.store.home.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0003B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/ECStoreHeaderFrameLayout;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/android/shopping/store/home/view/ECStoreHeaderFrameLayout$a;", "a", "Lcom/bytedance/android/shopping/store/home/view/ECStoreHeaderFrameLayout$a;", "getOnClickContentListener", "()Lcom/bytedance/android/shopping/store/home/view/ECStoreHeaderFrameLayout$a;", "setOnClickContentListener", "(Lcom/bytedance/android/shopping/store/home/view/ECStoreHeaderFrameLayout$a;)V", "onClickContentListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECStoreHeaderFrameLayout extends FrameLayout {
    public a a;

    public interface a {
        void onClick();
    }

    public ECStoreHeaderFrameLayout(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ECStoreHeaderFrameLayout(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final a getOnClickContentListener() {
        return this.a;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        boolean r3 = super.onInterceptTouchEvent(r2);
        a r0 = this.a;
        if (r0 == null) goto L5;
        r0.onClick();
    L5:
        return r3;
    }

    public final void setOnClickContentListener(a r1) {
        this.a = r1;
    }

    public ECStoreHeaderFrameLayout(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
    }

    public /* synthetic */ ECStoreHeaderFrameLayout(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
