package org.bouncycastle.util;

/* JADX INFO: loaded from: classes42.dex */
public interface Selector<T> extends Cloneable {
    Object clone();

    boolean match(T r100);
}
