package com.bytedance.ee.bear.bitable.pro;

import android.view.View;
import com.larksuite.component.universe_design.toast.UDToast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends com.bytedance.ee.bear.widgets.t {
    public final /* synthetic */ Role c;
    public final /* synthetic */ BitableProAdapter d;

    public final void a(View r3) {
        if (this.c.disableAddMembers() == true) goto L5;
        i0 r4 = this.d.a;
        if (r4 == null) goto L11;
        r4.I00(this.c);
    L11:
        int r5 = d.a;
        d.d(this.c.getRoleId(), Boolean.TRUE);
        return;
    L5:
        if (this.c.isPro() == true) goto L7;
        UDToast.show(BitableProAdapter.y2(this.d), 2131886099, 2131256189);
        return;
    L7:
        UDToast.show(BitableProAdapter.y2(this.d), 2131886190, 2131256189);
        int r6 = d.a;
        d.d(this.c.getRoleId(), Boolean.FALSE);
    }

    public c(Role r1, BitableProAdapter r2) {
        this.c = r1;
        this.d = r2;
    }
}
