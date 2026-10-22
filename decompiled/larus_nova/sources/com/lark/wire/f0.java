package com.lark.wire;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class f0 {
    public static final void a(ProtoAdapter r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        Intrinsics.checkNotNullParameter(r101, "typeUrl");
        new d0(r101, r100, FieldEncoding.LENGTH_DELIMITED, r100.getType(), Syntax.PROTO_3, r100.f282737e);
    }
}
