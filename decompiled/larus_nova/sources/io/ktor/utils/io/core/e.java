package io.ktor.utils.io.core;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class e {
    public static final void a(a r100, ByteBuffer r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "source");
        int r102 = r101.remaining();
        ByteBuffer r103 = r100.f492020a;
        int r104 = r100.f492022c;
        int r105 = r100.f492024e - r104;
        if (r105 < r102) goto L7;
        jsc.d.b(r101, r103, r104);
        r100.a(r102);
        return;
    L7:
        throw new InsufficientSpaceException("buffer content", r102, r105);
    }
}
