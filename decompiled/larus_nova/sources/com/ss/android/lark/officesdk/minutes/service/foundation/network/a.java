package com.ss.android.lark.officesdk.minutes.service.foundation.network;

import com.ss.android.lark.pb.improto.Command;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: classes37.dex */
public interface a {
    <R> d1<R> a(Command r100, Class<R> r101);

    <R> d1<R> b(com.bytedance.lark.pb.basic.v1.Command r100, Class<R> r101);

    void c(Command r100);

    void d(com.bytedance.lark.pb.basic.v1.Command r100);
}
