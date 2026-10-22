package com.ss.android.lark.active.user.bridge;

import com.ss.android.lark.log.Log;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes34.dex */
public final class m<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p<Object, Object> f408574a;

    public m(p<Object, Object> r100) {
        this.f408574a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Disposable r101 = (Disposable) r100;
        Log.i("UserScopeBridgeCallImpl", "user scope bridge call start: " + this.f408574a.f408577a.a());
    }
}
