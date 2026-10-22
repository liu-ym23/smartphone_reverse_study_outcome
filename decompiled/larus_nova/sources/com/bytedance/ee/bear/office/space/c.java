package com.bytedance.ee.bear.office.space;

import android.view.View;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderAction;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeSpaceFragment f236102a;

    public c(OfficeSpaceFragment r100) {
        this.f236102a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        OfficeSpaceFragment.S90(this.f236102a, OfficeSpaceHeaderAction.OPEN_MENU);
    }
}
