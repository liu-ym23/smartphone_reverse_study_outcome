package com.bytedance.ee.bear.lark.space;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.list.create.x0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a<T> implements Observer {
    public final /* synthetic */ BasePadHomeFragment a;

    public a(BasePadHomeFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        Integer r4 = (Integer) r3;
        tt5.a.h("BasePadHomeFragment", "on select creation type = " + r4);
        if (r4 == null) goto L7;
        BasePadHomeFragment r5 = this.a;
        r5.getClass();
        tt5.a.h("BasePadHomeFragment", "closePopupMenu()...");
        ((x0) r5.v.getValue()).a(r5.requireActivity());
        return;
    }
}
