package com.google.common.base;

import java.io.Serializable;
import java.lang.Enum;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: classes23.dex */
final class Enums$StringConverter<T extends Enum<T>> extends Converter<String, T> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Class<T> enumClass;

    public int hashCode() {
        return this.enumClass.hashCode();
    }

    public String toString() {
        return "Enums.stringConverter(" + this.enumClass.getName() + ".class)";
    }

    public Enums$StringConverter(Class<T> r100) {
        r100.getClass();
        this.enumClass = r100;
    }

    @Override // com.google.common.base.Converter
    public /* bridge */ /* synthetic */ String doBackward(Object r100) {
        return doBackward((Enum) r100);
    }

    /* JADX INFO: renamed from: doForward, reason: avoid collision after fix types in other method */
    public T doForward2(String r100) {
        return (T) r27.a.a(this.enumClass, r100);
    }

    @Override // com.google.common.base.Converter, com.google.common.base.g
    public boolean equals(@CheckForNull Object r100) {
        if ((r100 instanceof Enums$StringConverter) == true) goto L5;
        return false;
    L5:
        return this.enumClass.equals(((Enums$StringConverter) r100).enumClass);
    }

    public String doBackward(T r100) {
        return r100.name();
    }

    @Override // com.google.common.base.Converter
    public /* bridge */ /* synthetic */ Object doForward(String r100) {
        return doForward2(r100);
    }
}
