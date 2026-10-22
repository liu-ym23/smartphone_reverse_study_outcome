package com.bytedance.lark.rustclient.api;

import com.bytedance.lark.pb.basic.v1.Command;
import com.squareup.wire.ProtoAdapter;
import io.reactivex.Observable;

/* JADX INFO: loaded from: classes20.dex */
public interface l {
    Observable<com.bytedance.lark.sdk.refactor.q> a(Command r100);

    <T> Observable<s<com.bytedance.lark.sdk.refactor.q, T>> c(com.ss.android.lark.pb.improto.Command r100, ProtoAdapter<T> r101);

    <Resp> k<Resp> h(d<Resp> r100);

    <T> Observable<s<com.bytedance.lark.sdk.refactor.q, T>> i(Command r100, ProtoAdapter<T> r101);

    void k(long r100);
}
