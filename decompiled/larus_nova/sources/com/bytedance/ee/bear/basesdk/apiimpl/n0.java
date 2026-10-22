package com.bytedance.ee.bear.basesdk.apiimpl;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: classes15.dex */
public final class n0<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n0<T> f206522a = null;

    static {
        f206522a = new n0();
    }

    public n0() {
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        iu5.f.a(new m0((ConnectionService.NetworkState) r100));
    }
}
