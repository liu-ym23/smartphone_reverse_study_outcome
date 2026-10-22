package com.bytedance.lark.sdk.refactor;

import com.ss.android.lark.log.Log;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes20.dex */
public final class t<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f254351a;

    public t(String r100) {
        this.f254351a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.lark.rustclient.api.x r101 = (com.bytedance.lark.rustclient.api.x) r100;
        Log.i("RustSDK", "async make user " + this.f254351a + " offline success");
    }
}
