package com.bytedance.ee.bear.bitable.fieldedit.view.selection;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableFieldTypeExtendFieldSelectionFragment f211689a;

    public b(BitableFieldTypeExtendFieldSelectionFragment r100) {
        this.f211689a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        this.f211689a.onBackPressed();
    }
}
