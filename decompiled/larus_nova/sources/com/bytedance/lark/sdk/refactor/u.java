package com.bytedance.lark.sdk.refactor;

import com.ss.android.lark.log.Log;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes20.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f254352a;

    public u(String r100) {
        this.f254352a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Log.e("RustSDK", "make user " + this.f254352a + " offline failed + " + ((Throwable) r100).getMessage());
    }
}
