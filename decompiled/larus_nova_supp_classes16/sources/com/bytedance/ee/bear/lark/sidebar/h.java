package com.bytedance.ee.bear.lark.sidebar;

import android.view.View;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ SidebarDocTabFragment a;

    public h(SidebarDocTabFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        ConnectionService.NetworkState r3 = (ConnectionService.NetworkState) r2;
        if (r3 != null) goto L6;
        return;
    L6:
        if (r3.a() == false) goto L10;
        View r4 = this.a.J;
        if (r4 == null) goto L14;
        r4.setVisibility(8);
        return;
    L14:
        return;
    L10:
        View r5 = this.a.J;
        if (r5 == null) goto L16;
        r5.setVisibility(0);
        return;
    }
}
