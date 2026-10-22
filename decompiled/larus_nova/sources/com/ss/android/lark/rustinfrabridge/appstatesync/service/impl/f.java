package com.ss.android.lark.rustinfrabridge.appstatesync.service.impl;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.rustinfrabridge.appstatesync.service.IAppStateSyncService;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes38.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAppStateSyncService.ClientEvent f439690a;

    public f(IAppStateSyncService.ClientEvent r100) {
        this.f439690a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Log.e("GlobalAppStateService", "send notice client event: " + this.f439690a.name() + " failed");
    }
}
