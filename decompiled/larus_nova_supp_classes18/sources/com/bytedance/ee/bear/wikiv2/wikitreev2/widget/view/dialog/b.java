package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog;

import android.view.View;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.facade.common.widget.Toast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements View.OnClickListener {
    public final /* synthetic */ WikiDeleteConfirmDialog a;

    public b(WikiDeleteConfirmDialog r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        WikiDeleteConfirmDialog r3 = this.a;
        int r0 = WikiDeleteConfirmDialog.o;
        WikiDeleteConfirmDialog.ParamsViewModel r4 = r3.ca0();
        boolean r1 = false;
        if (r4 == null) goto L9;
        WikNodePerm r5 = r4.getNodePerm();
        if (r5 == null) goto L9;
        if (r5.show_single_delete == true) goto L9;
        r1 = true;
    L9:
        if (r1 == false) goto L11;
        Toast.showText(this.a.getContext(), 2131888804);
        return;
    L11:
        this.a.da0(2131368778);
    }
}
