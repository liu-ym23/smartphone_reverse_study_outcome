package pj6;

import ji6.b;
import ji6.c;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f529502a;

    public a(c r100) {
        this.f529502a = r100;
    }

    public final void a(cj6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        c r101 = this.f529502a;
        if (r101 == null) goto L6;
        b.a(r101, null, r100.f23983a, 1, false, 32);
        return;
    }
}
