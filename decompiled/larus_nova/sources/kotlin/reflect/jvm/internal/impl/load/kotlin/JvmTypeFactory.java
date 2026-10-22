package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;

/* JADX INFO: loaded from: classes42.dex */
public interface JvmTypeFactory<T> {
    T boxType(T r100);

    T createFromString(String r100);

    T createObjectType(String r100);

    T createPrimitiveType(PrimitiveType r100);

    T getJavaLangClassType();

    String toString(T r100);
}
