package com.bytedance.ee.bear.office.space;

import android.view.View;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceHeaderAction;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ OfficeSpaceFragment a;

    public c(OfficeSpaceFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        OfficeSpaceFragment.S90(this.a, OfficeSpaceHeaderAction.OPEN_MENU);
    }
}
