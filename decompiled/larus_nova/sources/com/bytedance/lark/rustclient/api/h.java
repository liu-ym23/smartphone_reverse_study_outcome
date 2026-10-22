package com.bytedance.lark.rustclient.api;

import com.bytedance.lark.pb.basic.v1.Command;
import com.squareup.wire.ProtoAdapter;
import io.reactivex.Observable;
import kotlin.Pair;

/* JADX INFO: loaded from: classes20.dex */
public interface h extends i {
    Observable<Pair<com.bytedance.lark.sdk.refactor.q, w>> a(Command r100);

    com.bytedance.lark.rustclient.internal.r b(String r100, com.ss.android.lark.pb.improto.Command r101, d r102);

    com.bytedance.lark.rustclient.internal.r f(String r100, z r101);

    <T> Observable<s<com.bytedance.lark.sdk.refactor.q, T>> g(String r100, Command r101, we6.c<T> r102);

    <T> Observable<s<com.bytedance.lark.sdk.refactor.q, T>> j(String r100, com.ss.android.lark.pb.improto.Command r101, ProtoAdapter<T> r102);
}
