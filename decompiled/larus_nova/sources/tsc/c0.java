package tsc;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class c0 extends io.noties.markwon.html.tag.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, kw8.a> f547439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f547440b;

    public c0(Map<String, kw8.a> r100, boolean r101) {
        this.f547439a = r100;
        this.f547440b = r101;
    }

    @Override // io.noties.markwon.html.tag.n, tsc.a0
    public final void a(lsc.m r100, v r101, l r102) {
        Intrinsics.checkNotNullParameter(r100, "visitor");
        Intrinsics.checkNotNullParameter(r101, "renderer");
        Intrinsics.checkNotNullParameter(r102, "tag");
        super.a(r100, r101, r102);
        int r103 = b.f547432a;
        Object[] r104 = b.a(r102, this.f547439a, this.f547440b);
        lsc.y.f(r100.builder(), r104, r102.start(), r102.end());
    }
}
