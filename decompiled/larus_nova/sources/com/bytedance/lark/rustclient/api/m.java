package com.bytedance.lark.rustclient.api;

import com.bytedance.lark.sdk.InvokeResponse;
import io.reactivex.Observable;

/* JADX INFO: loaded from: classes20.dex */
public interface m {
    <Resp> Observable<s<com.bytedance.lark.sdk.refactor.b, Resp>> a(n<Resp> r100);

    <Resp> s<InvokeResponse, Resp> b(n<Resp> r100);
}
