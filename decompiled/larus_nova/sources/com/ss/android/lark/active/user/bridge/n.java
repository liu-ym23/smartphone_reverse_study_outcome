package com.ss.android.lark.active.user.bridge;

import com.ss.android.lark.log.Log;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes34.dex */
public final class n<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n<T> f408575a = null;

    static {
        f408575a = new n();
    }

    public n() {
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        b r101 = (b) r100;
        StringBuilder r102 = new StringBuilder("user scope bridge call end: success=");
        r101.getClass();
        r102.append(r101 instanceof c);
        r102.append(", message=");
        r102.append(r101.f408562b);
        Log.i("UserScopeBridgeCallImpl", r102.toString());
    }
}
