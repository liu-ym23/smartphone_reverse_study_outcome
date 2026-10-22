package com.bytedance.jedi.ext.adapter.internal;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<Boolean> f251030a;

    public b() {
        this.f251030a = new ArrayList();
    }

    private final void insert(int r100) {
        ListProtector.add(this.f251030a, r100, Boolean.FALSE);
    }

    private final void update(int r100) {
        if (r100 >= ((ArrayList) this.f251030a).size()) goto L5;
        ListProtector.set(this.f251030a, r100, Boolean.TRUE);
        return;
    L5:
        ListProtector.add(this.f251030a, r100, Boolean.TRUE);
    }

    public final void a(int r100, boolean r101) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 > ((ArrayList) this.f251030a).size()) goto L12;
        if (r101 == false) goto L8;
        update(r100);
        return;
    L8:
        insert(r100);
        return;
    }
}
