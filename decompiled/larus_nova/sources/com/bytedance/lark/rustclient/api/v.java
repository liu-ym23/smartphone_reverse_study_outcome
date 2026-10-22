package com.bytedance.lark.rustclient.api;

import com.bytedance.lark.pb.basic.v1.Command;
import com.squareup.wire.ProtoAdapter;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class v {
    public static /* synthetic */ s b(final com.bytedance.lark.sdk.refactor.q r100, ProtoAdapter r101, w r102, Command r103) {
        return a(r100, r101, r102, r103, null, new RustPushKt$toRustPush$1(r100));
    }

    public static final <T> s<com.bytedance.lark.sdk.refactor.q, T> a(com.bytedance.lark.sdk.refactor.q r100, ProtoAdapter<T> r101, w r102, Command r103, com.ss.android.lark.pb.improto.Command r104, Function0<byte[]> r105) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "adapter");
        Intrinsics.checkNotNullParameter(r102, "scopePayload");
        Intrinsics.checkNotNullParameter(r103, "command");
        Intrinsics.checkNotNullParameter(r105, "binarySource");
        Pair r106 = t.i(r101, r105.invoke(), r103, r104);
        Object r107 = r106.component1();
        p r108 = (p) r106.component2();
        if (r107 == null) goto L6;
        return new x(r107, r100, r102);
    L6:
        return new c(r108, r100, r102);
    }
}
