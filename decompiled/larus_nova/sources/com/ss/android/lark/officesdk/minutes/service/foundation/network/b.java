package com.ss.android.lark.officesdk.minutes.service.foundation.network;

import com.squareup.wire.Message;
import com.ss.android.lark.pb.improto.Command;
import kotlin.Result;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: classes37.dex */
public interface b {
    <R> Object a(Command r100, Class<R> r101, Message<?, ?> r102, Continuation<? super Result<? extends R>> r103);

    <R> Object b(com.bytedance.lark.pb.basic.v1.Command r100, Class<R> r101, Message<?, ?> r102, Continuation<? super Result<? extends R>> r103);

    <R> Object c(Class<R> r100, gvb.a r101, Continuation<? super Result<? extends R>> r102);
}
