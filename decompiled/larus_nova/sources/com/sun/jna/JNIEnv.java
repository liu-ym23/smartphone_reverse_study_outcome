package com.sun.jna;

/* JADX INFO: loaded from: classes40.dex */
public final class JNIEnv {
    public static final JNIEnv CURRENT = null;

    private JNIEnv() {
    }

    static {
        CURRENT = new JNIEnv();
    }
}
