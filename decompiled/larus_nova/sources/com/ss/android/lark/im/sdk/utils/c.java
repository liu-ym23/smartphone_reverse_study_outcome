package com.ss.android.lark.im.sdk.utils;

import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes36.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback<Void> f426211a;

    public c(IGetDataCallback<Void> r100) {
        this.f426211a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(T r100) {
        IGetDataCallback<Void> r101 = this.f426211a;
        if (r101 == null) goto L6;
        r101.onSuccess(null);
        return;
    }
}
