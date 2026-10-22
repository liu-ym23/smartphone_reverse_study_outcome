package com.bytedance.ee.bear.bitable.toolbox.view;

import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes16.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableToolboxFragment f216035a;

    public a(BitableToolboxFragment r100) {
        this.f216035a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        BitableToolboxFragment r102 = this.f216035a;
        Intrinsics.checkNotNull(r101);
        int r103 = r101.intValue();
        if (r102.f216009f != null) goto L5;
        tt5.a.k("BitableToolbarFragment", "updateToolboxBottomPadding skipped, fab container is not initialized");
        return;
    L5:
        int r104 = RangesKt.coerceAtLeast(RangesKt.coerceAtLeast(r103, 0), r102.f216016m);
        LinearLayout r105 = r102.f216009f;
        LinearLayout r106 = null;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mFabContainer");
        r105 = null;
    L8:
        ViewGroup.LayoutParams r107 = r105.getLayoutParams();
        if ((r107 instanceof ViewGroup.MarginLayoutParams) == false) goto L11;
        ViewGroup.MarginLayoutParams r108 = (ViewGroup.MarginLayoutParams) r107;
    L12:
        if (r108 != null) goto L15;
        tt5.a.k("BitableToolbarFragment", "updateToolboxBottomPadding skipped, layoutParams is not MarginLayoutParams");
        return;
    L15:
        if (r108.bottomMargin == r104) goto L25;
        tt5.a.h("BitableToolbarFragment", "updateToolboxBottomPadding height=" + r103 + ", marginBottom=" + r104);
        r108.bottomMargin = r104;
        LinearLayout r109 = r102.f216009f;
        if (r109 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mFabContainer");
    L21:
        r106.setLayoutParams(r108);
        return;
    L20:
        r106 = r109;
        goto L21
    L25:
        return;
    L11:
        r108 = null;
        goto L12
    }
}
