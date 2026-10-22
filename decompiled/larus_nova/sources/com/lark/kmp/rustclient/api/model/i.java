package com.lark.kmp.rustclient.api.model;

import com.lark.kmp.pb.basic.v1.Command;
import com.lark.kmp.pb.basic.v1.LarkError;
import com.lark.wire.ProtoAdapter;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: loaded from: classes24.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f282481a = null;

    static {
        f282481a = new f(null, null, Command.UNKNOWN_COMMAND, null);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.lark.kmp.rustclient.api.model.RustOutputKt$errorAsException$$inlined$map$1] */
    public static final RustOutputKt$errorAsException$$inlined$map$1 a(final Flow r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return new RustOutputKt$errorAsException$$inlined$map$1(r100);
    }

    public static final f b(Command r100, com.lark.kmp.server.pb.improto.Command r101, byte[] r102, Exception r103) {
        Intrinsics.checkNotNullParameter(r100, "command");
        LarkError r104 = null;
        if (r102 == null) goto L10;
        r104 = LarkError.ADAPTER.e(r102);     // Catch: Exception -> L6
    L6:
        e = move-exception;
        if (r103 != null) goto L10;
        r103 = e;
    L10:
        return new f(r103, r104, r100, r101);
    }

    public static final <T> Pair<T, f> c(ProtoAdapter<T> r100, byte[] r101, Command r102, com.lark.kmp.server.pb.improto.Command r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "command");
        return TuplesKt.to(r100.e(r101), f282481a);
    L5:
        e = move-exception;
        return TuplesKt.to(null, b(r102, r103, r101, e));
    }
}
