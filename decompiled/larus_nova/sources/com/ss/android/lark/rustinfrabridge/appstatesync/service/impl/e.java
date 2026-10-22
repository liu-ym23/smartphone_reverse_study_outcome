package com.ss.android.lark.rustinfrabridge.appstatesync.service.impl;

import com.bytedance.lark.rustclient.api.x;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.rustinfrabridge.appstatesync.service.IAppStateSyncService;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes38.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAppStateSyncService.ClientEvent f439688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback<Boolean> f439689b;

    public e(IAppStateSyncService.ClientEvent r100) {
        this.f439688a = r100;
        this.f439689b = null;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        x r101 = (x) r100;
        Log.i("GlobalAppStateService", "send notice client event: " + this.f439688a.name() + " success");
        IGetDataCallback<Boolean> r102 = this.f439689b;
        if (r102 == null) goto L6;
        r102.onSuccess(Boolean.TRUE);
        return;
    }
}
