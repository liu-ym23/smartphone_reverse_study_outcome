package com.sun.jna;

/* JADX INFO: loaded from: classes40.dex */
abstract class Klass {
    private Klass() {
    }

    public static <T> T newInstance(Class<T> r100) {
        return r100.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
    L20:
        e = e;
    L22:
        throw new IllegalArgumentException("Can't create an instance of " + r100 + ", requires a public no-arg constructor: " + e, e);
    L18:
        e = e;
    L16:
        e = e;
    L14:
        e = e;
    L12:
        e = e;
    L5:
        e = move-exception;
        if ((e.getCause() instanceof RuntimeException) == false) goto L11;
        throw ((RuntimeException) e.getCause());
    L11:
        throw new IllegalArgumentException("Can't create an instance of " + r100 + ", requires a public no-arg constructor: " + e, e);
    }
}
