package com.bytedance.ee.bear.basesdk.services.container;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes15.dex */
public final class i implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<LiveData<ConnectionService.NetworkState>> f206653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Observer<ConnectionService.NetworkState> f206654b;

    public i(Ref.ObjectRef r100, UserDomainCharacteristicServiceImpl$observerListener$networkStateObserver$1 r101) {
        this.f206653a = r100;
        this.f206654b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f206653a.element.observeForever(this.f206654b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
