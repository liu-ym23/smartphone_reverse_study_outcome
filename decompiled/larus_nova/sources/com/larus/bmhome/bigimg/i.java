package com.larus.bmhome.bigimg;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;

/* JADX INFO: loaded from: classes25.dex */
public final class i implements k1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<l> f295995a;

    public i(List<l> r100) {
        this.f295995a = r100;
    }

    @Override // com.larus.bmhome.bigimg.k1
    public final l a(int r100) {
        if (r100 >= 0) goto L4;
        return null;
    L4:
        if (r100 < this.f295995a.size()) goto L7;
        return null;
    L7:
        return (l) ListProtector.get(this.f295995a, r100);
    }
}
