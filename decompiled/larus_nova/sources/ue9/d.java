package ue9;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class d {
    public d() {
    }

    public void a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    public void b(ByteBuffer r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
    }

    public void c(ff9.i.u r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
    }
}
