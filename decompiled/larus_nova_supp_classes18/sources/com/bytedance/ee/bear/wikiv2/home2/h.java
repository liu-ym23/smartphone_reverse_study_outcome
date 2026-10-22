package com.bytedance.ee.bear.wikiv2.home2;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h<T> implements Observer {
    public final /* synthetic */ WikiHomeFragment2 a;

    public h(WikiHomeFragment2 r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        ConnectionService.NetworkState r4 = (ConnectionService.NetworkState) r3;
        this.a.Y90().d.notifyDataSetChanged();
        this.a.X90().setMenuEnable(r4.a());
        WikiHomeRecentSpaceView r0 = this.a.X90();
        r0.f.notifyDataSetChanged();
        r0.a();
        this.a.W90().setEnabled(r4.a());
        if (this.a.p != null) goto L5;
    L9:
        this.a.p = r4;
        return;
    L5:
        if (r4.a() == false) goto L9;
        if (this.a.Z90().isOriginCache() == false) goto L9;
        this.a.Z90().refresh();
        goto L9
    }
}
