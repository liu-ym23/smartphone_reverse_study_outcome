package eab;

import kotlin.jvm.internal.Intrinsics;
import v7b.f0;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends s {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f471738j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f471739k;

    @Override // v7b.s
    public final s h() {
        return new c(this.f471738j, this.f471739k);
    }

    @Override // v7b.s
    public final void c(f0 r100) {
        if (r100 == null) goto L5;
        r100.a(this);
        return;
    }

    public c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r101, "key");
        this.f471738j = r100;
        this.f471739k = r101;
    }
}
