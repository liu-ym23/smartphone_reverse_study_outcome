package com.sun.jna;

/* JADX INFO: loaded from: classes40.dex */
public interface CallbackProxy extends Callback {
    Object callback(Object[] r100);

    Class<?>[] getParameterTypes();

    Class<?> getReturnType();
}
