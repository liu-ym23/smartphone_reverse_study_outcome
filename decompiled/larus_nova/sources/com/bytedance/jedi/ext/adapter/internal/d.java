package com.bytedance.jedi.ext.adapter.internal;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<JediViewHolderProxy> f251032a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JediViewHolderProxyManager f251033b;

    public final void a() {
        if (((ArrayList) this.f251032a).size() != 0) goto L5;
        return;
    L5:
        Iterator r100 = ((ArrayList) this.f251032a).iterator();
    L7:
        if (r100.hasNext() == false) goto L11;
        JediViewHolderProxy r101 = (JediViewHolderProxy) r100.next();
        if (r101 == null) goto L7;
        this.f251033b.a(r101);
        goto L7
    L11:
        ((ArrayList) this.f251032a).clear();
    }

    public d(JediViewHolderProxyManager r100) {
        this.f251033b = r100;
        this.f251032a = new ArrayList();
    }

    private final void insert(int r100) {
        ListProtector.add(this.f251032a, r100, null);
    }

    private final void update(int r100, JediViewHolderProxy r101) {
        if (r100 >= ((ArrayList) this.f251032a).size()) goto L5;
        ListProtector.set(this.f251032a, r100, r101);
        return;
    L5:
        ListProtector.add(this.f251032a, r100, r101);
    }

    public final void b(int r100, JediViewHolderProxy r101) {
        if (r100 >= 0) goto L4;
        return;
    L4:
        if (r100 > ((ArrayList) this.f251032a).size()) goto L12;
        if (r101 == null) goto L8;
        update(r100, r101);
        return;
    L8:
        insert(r100);
        return;
    }
}
