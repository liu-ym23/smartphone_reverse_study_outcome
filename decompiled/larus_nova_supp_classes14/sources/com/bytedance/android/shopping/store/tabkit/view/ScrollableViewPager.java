package com.bytedance.android.shopping.store.tabkit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.services.apm.api.EnsureManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0011\u0010\u0012R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0004\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/shopping/store/tabkit/view/ScrollableViewPager;", "Landroidx/viewpager/widget/ViewPager;", "", "a", "Z", "getScrollable", "()Z", "setScrollable", "(Z)V", "scrollable", "b", "isSlidingByDrag", "setSlidingByDrag", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ScrollableViewPager extends ViewPager {
    public boolean a;
    public boolean b;

    public final boolean getScrollable() {
        return this.a;
    }

    public ScrollableViewPager(Context r2) {
        this(r2, null);
    }

    public final boolean onInterceptTouchEvent(MotionEvent r3) {
        if (this.a == false) goto L12;
        if (super.onInterceptTouchEvent(r3) == false) goto L13;
        return true;
    L13:
        return false;
    L12:
        return false;
    L14:
        return false;
    }

    public final boolean onTouchEvent(MotionEvent r1) {
        return super.onTouchEvent(r1);
    L4:
        e = move-exception;
        EnsureManager.ensureNotNull(e);
        return false;
    }

    public final void setScrollable(boolean r1) {
        this.a = r1;
    }

    public final void setSlidingByDrag(boolean r1) {
        this.b = r1;
    }

    public ScrollableViewPager(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = true;
        addOnPageChangeListener(new AnonymousClass1(this));
    }
}
