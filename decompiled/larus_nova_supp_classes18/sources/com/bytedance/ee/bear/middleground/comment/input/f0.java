package com.bytedance.ee.bear.middleground.comment.input;

import android.view.View;
import com.larksuite.component.ui.button.LKUICheckBox2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class f0 implements View.OnClickListener {
    public final /* synthetic */ BaseInputComment a;

    public f0(BaseInputComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        LKUICheckBox2 r3 = this.a.E;
        r3.setChecked(!r3.b);
    }
}
