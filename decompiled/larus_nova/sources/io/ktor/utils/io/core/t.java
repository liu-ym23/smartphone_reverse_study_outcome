package io.ktor.utils.io.core;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class t {
    public static final void a(j r100, short r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        int r102 = r100.f492048e;
        if ((r100.f492049f - r102) <= 2) goto L5;
        r100.f492048e = r102 + 2;
        r100.f492047d.putShort(r102, r101);
        boolean r103 = true;
    L6:
        if (r103 == true) goto L12;
        io.ktor.utils.io.core.internal.a r104 = r100.j(2);
        Intrinsics.checkNotNullParameter(r104, "<this>");
        ByteBuffer r105 = r104.f492020a;
        int r106 = r104.f492022c;
        int r107 = r104.f492024e - r106;
        if (r107 < 2) goto L11;
        r105.putShort(r106, r101);
        r104.a(2);
        r100.a();
        return;
    L11:
        throw new InsufficientSpaceException("short integer", 2, r107);
    L12:
        return;
    L5:
        r103 = false;
        goto L6
    }
}
