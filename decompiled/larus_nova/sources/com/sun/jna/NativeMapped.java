package com.sun.jna;

/* JADX INFO: loaded from: classes40.dex */
public interface NativeMapped {
    Object fromNative(Object r100, FromNativeContext r101);

    Class<?> nativeType();

    Object toNative();
}
