package com.google.common.collect;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public abstract class o0 {
    public o0() {
    }

    public abstract Object delegate();

    public String toString() {
        return delegate().toString();
    }
}
