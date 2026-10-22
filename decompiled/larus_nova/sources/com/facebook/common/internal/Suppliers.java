package com.facebook.common.internal;

/* JADX INFO: loaded from: classes3.dex */
public class Suppliers {
    public static final Supplier<Boolean> BOOLEAN_FALSE = null;
    public static final Supplier<Boolean> BOOLEAN_TRUE = null;

    public Suppliers() {
    }

    static {
        BOOLEAN_TRUE = new AnonymousClass2();
        BOOLEAN_FALSE = new AnonymousClass3();
    }

    public static <T> Supplier<T> of(final T r100) {
        return new AnonymousClass1(r100);
    }
}
