package org.bouncycastle.util;

import java.util.Collection;

/* JADX INFO: loaded from: classes42.dex */
public interface Store<T> {
    Collection<T> getMatches(Selector<T> r100) throws StoreException;
}
