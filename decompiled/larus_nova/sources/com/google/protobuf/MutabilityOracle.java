package com.google.protobuf;

/* JADX INFO: loaded from: classes23.dex */
interface MutabilityOracle {
    public static final MutabilityOracle IMMUTABLE = null;

    void ensureMutable();

    static {
        IMMUTABLE = new AnonymousClass1();
    }
}
