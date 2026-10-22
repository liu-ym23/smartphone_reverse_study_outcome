package com.bytedance.ee.bear.lark.sidebar;

import android.view.View;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: classes16.dex */
public final class h<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SidebarDocTabFragment f227528a;

    public h(SidebarDocTabFragment r100) {
        this.f227528a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ConnectionService.NetworkState r101 = (ConnectionService.NetworkState) r100;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.a() == false) goto L10;
        View r102 = this.f227528a.f227517J;
        if (r102 == null) goto L14;
        r102.setVisibility(8);
        return;
    L14:
        return;
    L10:
        View r103 = this.f227528a.f227517J;
        if (r103 == null) goto L16;
        r103.setVisibility(0);
        return;
    }
}
