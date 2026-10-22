package com.bytedance.locallife.dito.view;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DitoViewPagerView f258781a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
    }

    public c(DitoViewPagerView r100) {
        this.f258781a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        if ((this.f258781a.getParent() instanceof View) == false) goto L9;
        Object r101 = this.f258781a.getParent();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.View");
        View r102 = (View) r101;
        if (r102.getLayoutParams() == null) goto L7;
        r102.getLayoutParams().width = -1;
        r102.getLayoutParams().height = -1;
        r102.setLayoutParams(r102.getLayoutParams());
        return;
    L7:
        r102.setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
        return;
    }
}
