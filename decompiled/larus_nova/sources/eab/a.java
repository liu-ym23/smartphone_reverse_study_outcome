package eab;

import kotlin.jvm.internal.Intrinsics;
import v7b.f0;
import v7b.s;

/* JADX INFO: loaded from: classes35.dex */
public final class a extends s {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f471733j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f471734k;

    @Override // v7b.s
    public final s h() {
        return new a(this.f471733j, this.f471734k);
    }

    @Override // v7b.s
    public final void c(f0 r100) {
        if (r100 == null) goto L5;
        r100.a(this);
        return;
    }

    public a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "userName");
        Intrinsics.checkNotNullParameter(r101, "userId");
        this.f471733j = r100;
        this.f471734k = r101;
    }
}
