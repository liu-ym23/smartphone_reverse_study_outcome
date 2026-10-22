package com.sun.jna;

/* JADX INFO: loaded from: classes40.dex */
public interface TypeMapper {
    FromNativeConverter getFromNativeConverter(Class<?> r100);

    ToNativeConverter getToNativeConverter(Class<?> r100);
}
