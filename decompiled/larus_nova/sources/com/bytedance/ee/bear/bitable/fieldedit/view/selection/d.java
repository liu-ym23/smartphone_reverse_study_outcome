package com.bytedance.ee.bear.bitable.fieldedit.view.selection;

import android.view.View;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableFieldTypeSelectionFragment.b f211692a;

    public d(BitableFieldTypeSelectionFragment.b r100) {
        this.f211692a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BitableFieldTypeSelectionFragment.b r101 = this.f211692a;
        if (r101 == null) goto L6;
        r101.b();
        return;
    }
}
