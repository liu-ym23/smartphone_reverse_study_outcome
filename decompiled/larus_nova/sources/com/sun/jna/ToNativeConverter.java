package com.sun.jna;

/* JADX INFO: loaded from: classes40.dex */
public interface ToNativeConverter {
    Class<?> nativeType();

    Object toNative(Object r100, ToNativeContext r101);
}
