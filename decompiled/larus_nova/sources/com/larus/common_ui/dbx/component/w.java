package com.larus.common_ui.dbx.component;

import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: classes27.dex */
public final class w extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f327076a;

    @Override // android.view.ViewGroup
    public final void onViewAdded(View r100) {
        super.onViewAdded(r100);
        this.f327076a.a();
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View r100) {
        super.onViewRemoved(r100);
        removeCallbacks(this.f327076a.f327066n);
        post(this.f327076a.f327066n);
    }

    public w(FragmentActivity r100, v r101) {
        this.f327076a = r101;
        super(r100);
    }
}
