package com.google.gson;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class FieldAttributes {
    private final Field field;

    public Collection<Annotation> getAnnotations() {
        return Arrays.asList(this.field.getAnnotations());
    }

    public Class<?> getDeclaredClass() {
        return this.field.getType();
    }

    public Type getDeclaredType() {
        return this.field.getGenericType();
    }

    public Class<?> getDeclaringClass() {
        return this.field.getDeclaringClass();
    }

    public String getName() {
        return this.field.getName();
    }

    public String toString() {
        return this.field.toString();
    }

    public FieldAttributes(Field r100) {
        Objects.requireNonNull(r100);
        this.field = r100;
    }

    public <T extends Annotation> T getAnnotation(Class<T> r100) {
        return (T) this.field.getAnnotation(r100);
    }

    public boolean hasModifier(int r100) {
        if ((r100 & this.field.getModifiers()) == 0) goto L5;
        return true;
    L5:
        return false;
    }
}
