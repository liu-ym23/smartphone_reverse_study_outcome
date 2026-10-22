package com.bytedance.scene.navigation;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<Record> f268820a;

    public final Record a() {
        if (this.f268820a.size() <= 0) goto L5;
        List<Record> r100 = this.f268820a;
        return (Record) ListProtector.get(r100, r100.size() - 1);
    L5:
        return null;
    }

    public final List<Record> b() {
        return new ArrayList(this.f268820a);
    }

    public k() {
        this.f268820a = new ArrayList();
    }
}
