package org.bouncycastle.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes42.dex */
public class CollectionStore<T> implements Store<T>, Iterable<T> {
    private Collection<T> _local;

    public CollectionStore(Collection<T> r100) {
        this._local = new ArrayList(r100);
    }

    @Override // org.bouncycastle.util.Store
    public Collection<T> getMatches(Selector<T> r100) {
        if (r100 == null) goto L4;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = this._local.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        T r103 = r102.next();
        if (r100.match(r103) == false) goto L7;
        r101.add(r103);
        goto L7
    L11:
        return r101;
    L4:
        return new ArrayList(this._local);
    }

    @Override // org.bouncycastle.util.Iterable, java.lang.Iterable
    public Iterator<T> iterator() {
        return getMatches(null).iterator();
    }
}
