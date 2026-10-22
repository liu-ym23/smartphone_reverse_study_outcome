package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view.dialog;

import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes18.dex */
public final class c implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiDeleteConfirmDialog f242451a;

    public c(WikiDeleteConfirmDialog r100) {
        this.f242451a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        WikiDeleteConfirmDialog r101 = this.f242451a;
        int r102 = WikiDeleteConfirmDialog.f242439o;
        r101.da0(R.id.deleteWithSub);
    }
}
