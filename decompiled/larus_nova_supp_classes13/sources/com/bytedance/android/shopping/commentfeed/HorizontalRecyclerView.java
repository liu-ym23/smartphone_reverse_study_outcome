package com.bytedance.android.shopping.commentfeed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.commentfeed.widget.VerticalViewPager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/HorizontalRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/bytedance/android/shopping/commentfeed/widget/VerticalViewPager;", "c", "Lcom/bytedance/android/shopping/commentfeed/widget/VerticalViewPager;", "getViewPager", "()Lcom/bytedance/android/shopping/commentfeed/widget/VerticalViewPager;", "setViewPager", "(Lcom/bytedance/android/shopping/commentfeed/widget/VerticalViewPager;)V", "viewPager", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class HorizontalRecyclerView extends RecyclerView {
    public float a;
    public float b;
    public VerticalViewPager c;

    public HorizontalRecyclerView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public HorizontalRecyclerView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final VerticalViewPager getViewPager() {
        return this.c;
    }

    public static RecyclerView r(View r2) {
        RecyclerView r3 = r2.getParent();
        if ((r3 instanceof RecyclerView) == false) goto L7;
        return r3;
    L7:
        if ((r3 instanceof View) == true) goto L9;
        RecyclerView r0 = null;
    L11:
        if (((View) r0) != null) goto L13;
        return null;
    L13:
        return r((View) r3);
    L9:
        r0 = r3;
        goto L11
    }

    public static VerticalViewPager t(View r2) {
        Object r3 = r2.getParent();
        if ((r3 instanceof VerticalViewPager) == false) goto L7;
        return (VerticalViewPager) r3;
    L7:
        if ((r3 instanceof View) == true) goto L9;
        Object r0 = null;
    L11:
        if (((View) r0) != null) goto L13;
        return null;
    L13:
        return t((View) r3);
    L9:
        r0 = r3;
        goto L11
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean dispatchTouchEvent(MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r5, "event");
        int r0 = r5.getAction();
        if (r0 == 0) goto L19;
        if (r0 != 1) goto L6;
    L18:
        this.b = 0.0f;
        this.a = 0.0f;
    L26:
        return super/*android.view.ViewGroup*/.dispatchTouchEvent(r5);
    L6:
        if (r0 != 2) goto L8;
        float r1 = r5.getX();
        float r2 = r5.getY();
        if (Math.abs(r1 - this.a) >= Math.abs(r2 - this.b)) goto L26;
        VerticalViewPager r3 = t(this);
        if (r3 == null) goto L15;
        r3.requestDisallowInterceptTouchEvent(false);
    L15:
        RecyclerView r4 = r(this);
        if (r4 == null) goto L26;
        r4.requestDisallowInterceptTouchEvent(true);
        goto L26
    L8:
        if (r0 == 3) goto L18;
    L19:
        this.a = r5.getX();
        this.b = r5.getY();
        VerticalViewPager r6 = t(this);
        if (r6 == null) goto L22;
        r6.requestDisallowInterceptTouchEvent(true);
    L22:
        RecyclerView r7 = r(this);
        if (r7 == null) goto L26;
        r7.requestDisallowInterceptTouchEvent(true);
        goto L26
    }

    public final void setViewPager(VerticalViewPager r1) {
        this.c = r1;
    }

    public HorizontalRecyclerView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        setLayoutManager(new LinearLayoutManager(r2, 0, false));
    }

    public /* synthetic */ HorizontalRecyclerView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
