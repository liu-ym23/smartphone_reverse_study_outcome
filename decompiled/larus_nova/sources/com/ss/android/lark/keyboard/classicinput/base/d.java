package com.ss.android.lark.keyboard.classicinput.base;

import android.view.View;
import com.ss.android.lark.widget.slidingup.SlidingUpPanelLayout;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SlidingUpPanelLayout f428694a;

    public d(SlidingUpPanelLayout r100) {
        this.f428694a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f428694a.setPanelState(SlidingUpPanelLayout.PanelState.COLLAPSED);
    }
}
