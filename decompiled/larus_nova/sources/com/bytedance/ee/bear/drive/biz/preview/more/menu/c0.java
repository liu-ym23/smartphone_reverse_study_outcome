package com.bytedance.ee.bear.drive.biz.preview.more.menu;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: classes16.dex */
public final class c0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DriveMoreProvider f223575a;

    public c0(DriveMoreProvider r100) {
        this.f223575a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        ConnectionService.NetworkState r101 = (ConnectionService.NetworkState) r100;
        this.f223575a.g();
    }
}
