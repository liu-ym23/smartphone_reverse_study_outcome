package jsc;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class b implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f500278a = null;

    static {
        f500278a = new b();
    }

    public b() {
    }

    @Override // jsc.a
    public final void a(ByteBuffer r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
    }

    @Override // jsc.a
    public final ByteBuffer b(int r100) {
        ByteBuffer r101 = ByteBuffer.allocate(r100);
        ByteBuffer r102 = c.f500279b;
        Intrinsics.checkNotNullParameter(r101, "buffer");
        return r101;
    }
}
