package pnb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tnb.a f530003a;

    public f(tnb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "jsRuntime");
        this.f530003a = r100;
    }

    @Override // pnb.e
    public final void a(String r100) {
        if (r100 == null) goto L5;
        this.f530003a.a("requestFromNative", r100);
        return;
    }

    @Override // pnb.e
    public final void b(String r100) {
        if (r100 == null) goto L5;
        this.f530003a.a("requestFromDocs", r100);
        return;
    }
}
