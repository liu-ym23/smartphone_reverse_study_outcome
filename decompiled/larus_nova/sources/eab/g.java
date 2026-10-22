package eab;

import kotlin.jvm.internal.Intrinsics;
import v7b.f0;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class g extends s {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f471751j;

    @Override // v7b.s
    public final s h() {
        return new g(this.f471751j);
    }

    public g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "numberDetail");
        this.f471751j = r100;
    }

    @Override // v7b.s
    public final void c(f0 r100) {
        if (r100 == null) goto L5;
        r100.a(this);
        return;
    }
}
