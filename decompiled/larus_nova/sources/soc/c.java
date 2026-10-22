package soc;

import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<dxa.c> f542821a;

    @Override // soc.a
    public final List<dxa.c> getInterceptors() {
        Set<dxa.c> r100 = this.f542821a;
        if (r100 == null) goto L7;
        List<dxa.c> r101 = CollectionsKt.toList(r100);
        if (r101 == null) goto L7;
        return r101;
    L7:
        return CollectionsKt.emptyList();
    }

    @Inject
    public c(Set<dxa.c> r100) {
        this.f542821a = r100;
    }
}
