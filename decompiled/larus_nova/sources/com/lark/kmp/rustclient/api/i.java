package com.lark.kmp.rustclient.api;

import com.lark.kmp.pb.basic.v1.Command;
import com.lark.wire.ProtoAdapter;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class i {
    public static com.lark.kmp.rustclient.api.model.g a(final rpc.c r100, ProtoAdapter r101, com.lark.kmp.rustclient.api.model.j r102, Command r103) {
        Function0<byte[]> r104 = new RustPushKt$toRustPush$1(r100);
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "adapter");
        Intrinsics.checkNotNullParameter(r102, "scopePayload");
        Intrinsics.checkNotNullParameter(r103, "command");
        Intrinsics.checkNotNullParameter(r104, "binarySource");
        Pair r105 = com.lark.kmp.rustclient.api.model.i.c(r101, r104.invoke(), r103, null);
        Object r106 = r105.component1();
        com.lark.kmp.rustclient.api.model.f r107 = (com.lark.kmp.rustclient.api.model.f) r105.component2();
        if (r106 == null) goto L6;
        return new com.lark.kmp.rustclient.api.model.k(r106, r100, r102);
    L6:
        return new com.lark.kmp.rustclient.api.model.b(r107, r100, r102);
    }
}
