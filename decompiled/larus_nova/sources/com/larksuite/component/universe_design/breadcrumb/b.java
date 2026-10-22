package com.larksuite.component.universe_design.breadcrumb;

import android.view.View;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UDBreadcrumbAdapter f284565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f284566b;

    public b(UDBreadcrumbAdapter r100, int r101) {
        this.f284565a = r100;
        this.f284566b = r101;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f284565a.f284559b.onItemClick(this.f284566b);
    }
}
