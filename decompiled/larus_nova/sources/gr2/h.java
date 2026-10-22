package gr2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class h implements fr2.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final li6.c f482311a;

    public final String getInteractId() {
        li6.b r100 = this.f482311a.f509384c;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f509378e;
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f482311a;
    }

    public h(li6.c r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f482311a = r100;
    }
}
