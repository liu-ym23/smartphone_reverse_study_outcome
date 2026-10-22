package com.bytedance.ee.bear.middleground.comment.card;

import android.view.View;
import com.larksuite.component.ui.button.LKUICheckBox2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g1 implements View.OnClickListener {
    public final /* synthetic */ HalfScreenCardComment a;

    public g1(HalfScreenCardComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        LKUICheckBox2 r3 = this.a.A;
        r3.setChecked(!r3.b);
    }
}
