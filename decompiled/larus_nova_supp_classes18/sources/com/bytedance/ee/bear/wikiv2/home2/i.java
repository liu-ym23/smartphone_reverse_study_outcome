package com.bytedance.ee.bear.wikiv2.home2;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.widgets.button.CommonCreateButton;
import com.ss.android.lark.api.bean.ForsetiViewMode;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ WikiHomeFragment2 a;

    public i(WikiHomeFragment2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        boolean r4 = ((ForsetiViewMode) r3).isExpand();
        tt5.a.h("WikiHomeFragment2", "observeForsetiMode: isPadMode = " + r4);
        CommonCreateButton r0 = this.a.W90();
        if (r0 == null) goto L12;
        if (r4 == false) goto L6;
    L9:
        int r5 = 8;
    L10:
        r0.setVisibility(r5);
        return;
    L6:
        if (this.a.aa0() == true) goto L9;
        r5 = 0;
        goto L10
    }
}
