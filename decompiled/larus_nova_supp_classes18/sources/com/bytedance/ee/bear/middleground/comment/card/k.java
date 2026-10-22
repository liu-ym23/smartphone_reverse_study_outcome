package com.bytedance.ee.bear.middleground.comment.card;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.widgets.viewpager.VerticalViewPager;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements Runnable {
    public final /* synthetic */ FloatCardComment a;

    public k(FloatCardComment r1) {
        this.a = r1;
    }

    public final void a() {
        FloatCardComment r0 = this.a;
        int r1 = r0.p0;
        CommentPagerAdapter2 r2 = r0.o;
        LinearLayoutManager r3 = null;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("pagerAdapter");
        r2 = null;
    L5:
        int r4 = Math.max(0, Math.min(r1, r2.getItemCount() - 1));
        VerticalViewPager r5 = this.a.m;
        if (r5 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r5 = null;
    L8:
        RecyclerView r6 = r5.mRecyclerView;
        if (r6 == null) goto L11;
        RecyclerView.LayoutManager r7 = r6.getLayoutManager();
    L13:
        if ((r7 instanceof LinearLayoutManager) == false) goto L15;
        r3 = (LinearLayoutManager) r7;
    L15:
        if (r3 == null) goto L18;
        r3.scrollToPositionWithOffset(Math.max(0, r4), 0);
        return;
    L18:
        return;
    L11:
        r7 = null;
        goto L13
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
