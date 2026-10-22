package com.bytedance.ies.tools.prefetch;

import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public abstract class b implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f248791a;

    public final void c(String r100) {
        this.f248791a.prefetch(r100);
    }

    @Override // com.bytedance.ies.tools.prefetch.l
    public final List<PrefetchProcess> getCacheByScheme(String r100) {
        return this.f248791a.getCacheByScheme(r100);
    }

    @Override // com.bytedance.ies.tools.prefetch.l
    public final PrefetchProcess a(PrefetchRequest r100, x r101) {
        return this.f248791a.b(r100);
    }

    @Override // com.bytedance.ies.tools.prefetch.l
    public final PrefetchProcess b(PrefetchRequest r100, x r101) {
        return this.f248791a.c(r100);
    }

    public b(String r100, v r101, c r102) {
        this.f248791a = r101;
    }
}
