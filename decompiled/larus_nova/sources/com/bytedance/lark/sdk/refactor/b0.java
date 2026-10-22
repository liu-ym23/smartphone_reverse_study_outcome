package com.bytedance.lark.sdk.refactor;

import com.bytedance.lark.pb.tool.v1.MakeUserOnlineV2Response;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class b0<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0<T, R> f254251a = null;

    static {
        f254251a = new b0();
    }

    public b0() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        com.bytedance.lark.rustclient.api.x r101 = (com.bytedance.lark.rustclient.api.x) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        MakeUserOnlineV2Response r102 = (MakeUserOnlineV2Response) r101.f253935c;
        return new com.bytedance.lark.sdk.refactor.state.h(true, r102.destination_container_id, r102.user_container_id);
    }
}
