package com.ss.android.lark.active.user.bridge;

import com.ss.android.lark.log.Log;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes34.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o<T> f408576a = null;

    static {
        f408576a = new o();
    }

    public o() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        Log.e("UserScopeBridgeCallImpl", "user scope bridge call failed: message=" + r101.getMessage(), r101);
    }
}
