package com.bytedance.ee.bear.bitable.core.infoarch;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableInfoArchManagerNew f210277a;

    public b(BitableInfoArchManagerNew r100) {
        this.f210277a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f210277a.q();
    }
}
