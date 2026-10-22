package com.ss.android.lark.im.sdk.utils;

import com.larksuite.framework.callback.IGetDataCallback;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes36.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback<T> f426209a;

    public a(IGetDataCallback<T> r100) {
        this.f426209a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(T r100) {
        IGetDataCallback<T> r101 = this.f426209a;
        if (r101 == null) goto L6;
        r101.onSuccess(r100);
        return;
    }
}
