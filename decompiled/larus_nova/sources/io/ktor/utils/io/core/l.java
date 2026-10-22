package io.ktor.utils.io.core;

import java.nio.ByteBuffer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class l {
    public static final k a(ByteBuffer r100, Function1<? super ByteBuffer, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "bb");
        Intrinsics.checkNotNullParameter(r101, "release");
        u r102 = new u(r100, r101);
        io.ktor.utils.io.core.internal.a r103 = r102.Q5();
        r103.f492023d = 0;
        r103.f492021b = 0;
        r103.f492022c = r103.f492025f;
        Intrinsics.checkNotNullParameter(r103, "head");
        Intrinsics.checkNotNullParameter(r102, "pool");
        return new k(r103, h.c(r103), r102);
    }
}
