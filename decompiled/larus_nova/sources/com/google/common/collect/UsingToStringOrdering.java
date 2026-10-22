package com.google.common.collect;

import java.io.Serializable;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
final class UsingToStringOrdering extends Ordering<Object> implements Serializable {
    static final UsingToStringOrdering INSTANCE = null;
    private static final long serialVersionUID = 0;

    public String toString() {
        return "Ordering.usingToString()";
    }

    static {
        INSTANCE = new UsingToStringOrdering();
    }

    private UsingToStringOrdering() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object r100, Object r101) {
        return r100.toString().compareTo(r101.toString());
    }
}
