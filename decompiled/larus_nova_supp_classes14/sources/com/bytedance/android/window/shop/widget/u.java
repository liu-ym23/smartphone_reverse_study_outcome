package com.bytedance.android.window.shop.widget;

import android.content.Context;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.android.window.shop.home.adapter.WindowAutoScrollViewAdapter;
import com.bytedance.android.window.shop.home.presenter.ECWindowInfoLinearManager;
import com.bytedance.android.window.shop.home.presenter.ECWindowInfoLinearManager$smoothScrollToPositionWithOffset$scroller$1;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class u implements Runnable {
    public final /* synthetic */ WindowEveryoneTalkCard a;
    public final /* synthetic */ List b;

    public u(WindowEveryoneTalkCard r1, List r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        RecyclerView r0 = this.a.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("recycleView");
    L5:
        RecyclerView.LayoutManager r1 = r0.getLayoutManager();
        ECWindowInfoLinearManager r3 = null;
        if ((r1 instanceof StaggeredGridLayoutManager) == true) goto L8;
        r1 = null;
    L8:
        StaggeredGridLayoutManager r2 = (StaggeredGridLayoutManager) r1;
        if (r2 == null) goto L11;
        int[] r4 = r2.findLastCompletelyVisibleItemPositions(null);
    L12:
        if (r4 == null) goto L19;
        int r5 = r4.length;
        int r6 = 0;
    L14:
        if (r6 >= r5) goto L19;
        if (r4[r6] == (this.b.size() - 1)) goto L17;
        r6 = r6 + 1;
        goto L14
    L17:
        return;
    L19:
        RecyclerView r7 = this.a.b;
        if (r7 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("recycleView");
    L22:
        RecyclerView.Adapter r8 = r7.getAdapter();
        if ((r8 instanceof WindowAutoScrollViewAdapter) == true) goto L25;
        r8 = null;
    L25:
        WindowAutoScrollViewAdapter r9 = (WindowAutoScrollViewAdapter) r8;
        if (r9 == null) goto L28;
        List<uq3.p> r10 = r9.a;
        ((ArrayList) r10).addAll(r10);
        r9.notifyDataSetChanged();
    L28:
        RecyclerView r11 = this.a.b;
        if (r11 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("recycleView");
    L31:
        ECWindowInfoLinearManager r12 = r11.getLayoutManager();
        if ((r12 instanceof ECWindowInfoLinearManager) == false) goto L35;
        r3 = r12;
    L35:
        final ECWindowInfoLinearManager r13 = r3;
        if (r13 == null) goto L44;
        RecyclerView r14 = this.a.b;
        if (r14 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("recycleView");
    L40:
        int r15 = this.b.size();
        final int r16 = com.bytedance.android.shopping.extensions.b.b(6);
        Intrinsics.checkNotNullParameter(r14, "recyclerView");
        final Context r17 = r14.getContext();
        LinearSmoothScroller r18 = new ECWindowInfoLinearManager$smoothScrollToPositionWithOffset$scroller$1(r13, r16, r17);
        r18.setTargetPosition(r15);
        r13.startSmoothScroll(r18);
        return;
    L44:
        return;
    L11:
        r4 = null;
        goto L12
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
