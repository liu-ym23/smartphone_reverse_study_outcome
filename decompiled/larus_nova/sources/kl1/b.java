package kl1;

import kotlin.jvm.internal.Intrinsics;
import ku2.e;

/* JADX INFO: loaded from: classes7.dex */
public final class b implements a {
    public b() {
    }

    @Override // kl1.a
    public final void release() {
    }

    @Override // kl1.a
    public final boolean a(tlc.d r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        if (Intrinsics.areEqual(r100.getMessageMethod(), xq1.b.a(e.f506191c)) == false) goto L5;
        return false;
    L5:
        if (Intrinsics.areEqual(r100.getMessageMethod(), xq1.b.a(e.f506192d)) == false) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(r100.getMessageMethod(), xq1.b.a(e.f506193e)) == false) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(r100.getMessageMethod(), xq1.b.a(e.f506194f)) == true) goto L17;
        return true;
    L17:
        return false;
    }
}
