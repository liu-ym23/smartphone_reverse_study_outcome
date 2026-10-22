package com.bytedance.android.shopping.commentfeed.widget;

import android.view.View;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/widget/RecyclerViewPageChangeListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class RecyclerViewPageChangeListener extends RecyclerView.OnScrollListener {
    public int a;
    public int b;
    public final SnapHelper c;
    public final a d;

    public interface a {
        void a(int r1);

        void c();

        void onPageSelected(int r1);
    }

    public RecyclerViewPageChangeListener(PagerSnapHelper r2, com.bytedance.android.shopping.commentfeed.view.c r3) {
        Intrinsics.checkNotNullParameter(r2, "snapHelper");
        this.c = r2;
        this.d = r3;
        this.a = -1;
        this.b = -1;
    }

    public final void onScrollStateChanged(RecyclerView r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onScrollStateChanged(r2, r3);
        RecyclerView.LayoutManager r4 = r2.getLayoutManager();
        if (r4 == null) goto L7;
        View r0 = this.c.findSnapView(r4);
        if (r0 == null) goto L7;
        int r5 = r4.getPosition(r0);
    L8:
        a r1 = this.d;
        if (r1 == null) goto L11;
        r1.c();
    L11:
        if (r3 == 0) goto L13;
        return;
    L13:
        if (this.a == r5) goto L19;
        this.a = r5;
        a r6 = this.d;
        if (r6 == null) goto L20;
        r6.onPageSelected(r5);
        return;
    L20:
        return;
    L19:
        return;
    L7:
        r5 = 0;
        goto L8
    }

    public final void onScrolled(RecyclerView r2, int r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onScrolled(r2, r3, r4);
        RecyclerView.LayoutManager r5 = r2.getLayoutManager();
        if (r5 == null) goto L7;
        View r6 = this.c.findSnapView(r5);
        if (r6 == null) goto L7;
        int r7 = r5.getPosition(r6);
    L9:
        if (this.b == r7) goto L14;
        this.b = r7;
        a r8 = this.d;
        if (r8 == null) goto L15;
        r8.a(r7);
        return;
    L15:
        return;
    L14:
        return;
    L7:
        r7 = 0;
        goto L9
    }
}
