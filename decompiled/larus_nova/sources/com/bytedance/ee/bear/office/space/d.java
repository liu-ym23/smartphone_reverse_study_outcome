package com.bytedance.ee.bear.office.space;

import android.view.View;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderAction;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.office.list.adapter.i0;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeSpaceFragment f236103a;

    public d(OfficeSpaceFragment r100) {
        this.f236103a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        OfficeSpaceFragment r101 = this.f236103a;
        int r102 = OfficeSpaceFragment.f236036v;
        OfficeSpaceTab r103 = r101.W90();
        if (r103 == null) goto L5;
        i0.f235779a.g(r103, "search", null);
    L5:
        OfficeSpaceFragment.S90(this.f236103a, OfficeSpaceHeaderAction.SEARCH);
    }
}
