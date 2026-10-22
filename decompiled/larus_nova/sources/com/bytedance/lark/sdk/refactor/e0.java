package com.bytedance.lark.sdk.refactor;

import com.ss.android.lark.log.Log;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes20.dex */
public final class e0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f254265a;

    public e0(String r100) {
        this.f254265a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Log.e("RustSDK", "switch user " + this.f254265a + " online failed + " + ((Throwable) r100).getMessage());
    }
}
