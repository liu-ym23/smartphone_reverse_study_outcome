package com.bytedance.ee.bear.middleground.permission.apply;

import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e1<T> implements Observer {
    public final /* synthetic */ PermApplyFragment a;

    public e1(PermApplyFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        PermApplyViewModel.PermType r5 = (PermApplyViewModel.PermType) r4;
        PermApplyFragment r0 = this.a;
        View r1 = r0.g;
        if (r1 != null) goto L9;
        View r2 = r0.getView();
        if (r2 == null) goto L7;
        r1 = r2.findViewById(2131382177);
    L8:
        r0.g = (TextView) r1;
        goto L9
    L7:
        r1 = null;
    L9:
        ((TextView) r1).setText(r5.getText());
    }
}
