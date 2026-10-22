package com.bytedance.ee.bear.bitable.filter.condition;

import android.view.View;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f211859a;

    public d(f r100) {
        this.f211859a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        Toast.showText(this.f211859a.getContext(), R.string.Bitable_Relation_PleaseSelectFieldToast_Mobile);
    }
}
