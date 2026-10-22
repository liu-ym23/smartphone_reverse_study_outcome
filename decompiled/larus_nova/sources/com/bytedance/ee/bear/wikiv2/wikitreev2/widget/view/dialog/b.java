package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog;

import android.view.View;
import com.bytedance.ee.bear.contract.route.parcelable.WikNodePerm;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiDeleteConfirmDialog f242450a;

    public b(WikiDeleteConfirmDialog r100) {
        this.f242450a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        WikiDeleteConfirmDialog r101 = this.f242450a;
        int r102 = WikiDeleteConfirmDialog.f242439o;
        WikiDeleteConfirmDialog.ParamsViewModel r103 = r101.ca0();
        boolean r104 = false;
        if (r103 == null) goto L9;
        WikNodePerm r105 = r103.getNodePerm();
        if (r105 == null) goto L9;
        if (r105.show_single_delete == true) goto L9;
        r104 = true;
    L9:
        if (r104 == false) goto L11;
        Toast.showText(this.f242450a.getContext(), R.string.LarkCCM_CM_RemoveOrDeleteSubpageFirst_Tooltip);
        return;
    L11:
        this.f242450a.da0(R.id.deleteCurrentOnly);
    }
}
