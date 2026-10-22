package com.bytedance.ee.bear.bitable.sort;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.bitable.common.fragment.BaseActionPanelFragment;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class g implements Runnable {
    public final /* synthetic */ BitableSortPanelFragment a;

    public g(BitableSortPanelFragment r1) {
        this.a = r1;
    }

    public final void a() {
        BaseActionPanelFragment r0 = this.a.getParentFragment();
        LinearLayout r2 = null;
        if ((r0 instanceof BaseActionPanelFragment) == false) goto L5;
        BaseActionPanelFragment r1 = r0;
    L6:
        if (r1 == null) goto L8;
        View r3 = r1.fa0();
    L9:
        int[] r4 = new int[2];
        FrameLayout r5 = this.a.e;
        if (r5 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("mSortPanel");
        r5 = null;
    L12:
        r5.getLocationInWindow(r4);
        int[] r6 = new int[2];
        if (r3 == null) goto L15;
        r3.getLocationInWindow(r6);
    L15:
        int r7 = r6[1] - r4[1];
        LinearLayout r8 = this.a.l;
        if (r8 != null) goto L18;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
        r8 = null;
    L18:
        ViewGroup.LayoutParams r9 = r8.getLayoutParams();
        if (r9 == null) goto L28;
        BitableSortPanelFragment r10 = this.a;
        if ((r9 instanceof ViewGroup.MarginLayoutParams) == false) goto L29;
        r9.height = r7;
        LinearLayout r11 = r10.l;
        if (r11 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("mEmptyState");
    L26:
        r2.setLayoutParams(r9);
        return;
    L25:
        r2 = r11;
        goto L26
    L29:
        return;
    L28:
        return;
    L8:
        r3 = null;
        goto L9
    L5:
        r1 = null;
        goto L6
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
