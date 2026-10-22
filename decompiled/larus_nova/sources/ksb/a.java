package ksb;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f505991a;

    public final float a() {
        return this.f505991a.getFloat();
    }

    public final int b() {
        return this.f505991a.getShort() & 65535;
    }

    public a(ByteBuffer r100) {
        Intrinsics.checkNotNullParameter(r100, "buf");
        this.f505991a = r100;
        r100.order(ByteOrder.LITTLE_ENDIAN);
    }
}
