package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow.pannel.utils;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/room/widgets/floatwindow/pannel/utils/PagerSnapScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PagerSnapScrollListener extends RecyclerView.OnScrollListener {
    public int a;
    public int b;
    public final PagerSnapHelper c;
    public final a d;

    public interface a {
        void a(int r1, float r2);

        void onPageScrollStateChanged(int r1);

        void onPageSelected(int r1);
    }

    public PagerSnapScrollListener(PagerSnapHelper r2, a r3) {
        Intrinsics.checkNotNullParameter(r2, "snapHelper");
        Intrinsics.checkNotNullParameter(r3, "callback");
        this.c = r2;
        this.d = r3;
        this.b = -1;
    }

    public final void onScrollStateChanged(RecyclerView r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "recyclerView");
        super.onScrollStateChanged(r2, r3);
        this.a = r3;
        this.d.onPageScrollStateChanged(r3);
        if (r3 != 0) goto L14;
        RecyclerView.LayoutManager r4 = r2.getLayoutManager();
        if (r4 != null) goto L7;
        return;
    L7:
        View r5 = this.c.findSnapView(r4);
        if (r5 != null) goto L10;
        return;
    L10:
        int r6 = r4.getPosition(r5);
        if (this.b == r6) goto L15;
        this.b = r6;
        this.d.onPageSelected(r6);
        return;
    L15:
        return;
    }

    public final void onScrolled(RecyclerView r4, int r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "recyclerView");
        super.onScrolled(r4, r5, r6);
        if (this.a != 0) goto L5;
        return;
    L5:
        RecyclerView.LayoutManager r7 = r4.getLayoutManager();
        ViewGroup.LayoutParams r0 = null;
        if ((r7 instanceof LinearLayoutManager) == true) goto L8;
        r7 = null;
    L8:
        LinearLayoutManager r8 = (LinearLayoutManager) r7;
        if (r8 != null) goto L11;
        return;
    L11:
        int r9 = r8.findFirstVisibleItemPosition();
        View r1 = r8.findViewByPosition(r9);
        if (r1 != null) goto L14;
        return;
    L14:
        int r2 = r8.getDecoratedLeft(r1);
        if (r8.canScrollHorizontally() == false) goto L23;
        ViewGroup.LayoutParams r10 = r4.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L20;
        r0 = r10;
    L20:
        ViewGroup.MarginLayoutParams r3 = (ViewGroup.MarginLayoutParams) r0;
        if (r3 == null) goto L30;
        int r11 = r3.leftMargin;
    L31:
        int r12 = Math.abs(r2 - r11);
        int r13 = r1.getWidth();
        if (r13 <= 0) goto L34;
        float r14 = r12 / r13;
    L36:
        if (r14 >= 0.0f) goto L38;
        return;
    L38:
        if (r14 > 1.0f) goto L42;
        this.d.a(r9, r14);
        return;
    L42:
        return;
    L34:
        r14 = 0.0f;
    L30:
        r11 = 0;
        goto L31
    L23:
        ViewGroup.LayoutParams r15 = r4.getLayoutParams();
        if ((r15 instanceof ViewGroup.MarginLayoutParams) == false) goto L27;
        r0 = r15;
    L27:
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r0;
        if (r16 == null) goto L30;
        r11 = r16.topMargin;
        goto L31
    }
}
