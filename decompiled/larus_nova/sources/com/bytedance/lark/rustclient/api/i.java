package com.bytedance.lark.rustclient.api;

import com.bytedance.lark.pb.basic.v1.Command;
import io.reactivex.Observable;

/* JADX INFO: loaded from: classes20.dex */
public interface i {
    <Resp, Req> k<Resp> d(f<Resp, Req> r100);

    <T> Observable<s<com.bytedance.lark.sdk.refactor.q, T>> e(Command r100, we6.a<T> r101);
}
