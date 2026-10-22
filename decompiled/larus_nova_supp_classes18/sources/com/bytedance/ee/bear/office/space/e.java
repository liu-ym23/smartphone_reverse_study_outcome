package com.bytedance.ee.bear.office.space;

import android.view.View;
import com.bytedance.ee.bear.office.export.space.OfficeSpaceTab;
import com.bytedance.ee.bear.office.list.adapter.i0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ OfficeSpaceFragment a;

    public e(OfficeSpaceFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        OfficeSpaceFragment r0 = this.a;
        int r1 = OfficeSpaceFragment.v;
        OfficeSpaceTab r2 = r0.W90();
        if (r2 == null) goto L5;
        i0.a.g(r2, "more", null);
    L5:
        OfficeSpaceFragment r3 = this.a;
        Intrinsics.checkNotNull(r9);
        OfficeSpaceTab r4 = r3.W90();
        if (r4 != null) goto L8;
        tt5.a.h("OfficeSpaceFragment", "skip header more menu, current tab missing, runtime=" + r3.da0(r3.Z90()) + ", hostAdded=" + r3.isAdded() + ", hostState=" + r3.getLifecycle().getCurrentState() + ", anchor=" + OfficeSpaceFragment.aa0(r9));
        return;
    L8:
        tt5.a.h("OfficeSpaceFragment", "click header more menu, runtime=" + r3.da0(r3.Z90()) + ", tab=" + r4 + ", hostAdded=" + r3.isAdded() + ", hostState=" + r3.getLifecycle().getCurrentState() + ", anchor=" + OfficeSpaceFragment.aa0(r9));
        if (r3.X90(r9, r4) == false) goto L12;
        return;
    L12:
        if (r3.n == false) goto L14;
        tt5.a.h("OfficeSpaceFragment", "skip header more retry, retry already pending, runtime=" + r3.da0(r3.Z90()) + ", tab=" + r4 + ", anchor=" + OfficeSpaceFragment.aa0(r9));
        return;
    L14:
        r3.n = true;
        r9.post(new i(r3, r4, r9));
    }
}
