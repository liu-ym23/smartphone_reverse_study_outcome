package tsc;

import java.util.Collection;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class z extends io.noties.markwon.html.tag.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, kw8.a> f547493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f547494b;

    @Override // tsc.a0
    public final Collection c() {
        return CollectionsKt.listOf("span");
    }

    public z(Map<String, kw8.a> r100, boolean r101) {
        this.f547493a = r100;
        this.f547494b = r101;
    }

    @Override // io.noties.markwon.html.tag.i
    public final Object e(lsc.h r100, lsc.t r101, l r102) {
        Intrinsics.checkNotNullParameter(r100, "configuration");
        Intrinsics.checkNotNullParameter(r101, "renderProps");
        Intrinsics.checkNotNullParameter(r102, "tag");
        int r103 = b.f547432a;
        return b.a(r102, this.f547493a, this.f547494b);
    }
}
