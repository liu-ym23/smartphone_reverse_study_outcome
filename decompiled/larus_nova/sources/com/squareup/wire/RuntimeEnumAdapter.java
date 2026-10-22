package com.squareup.wire;

import com.squareup.wire.WireEnum;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes34.dex */
final class RuntimeEnumAdapter<E extends WireEnum> extends EnumAdapter<E> {
    private Method fromValueMethod;
    private final Class<E> type;

    private Method getFromValueMethod() {
        Method r100 = this.fromValueMethod;
        if (r100 == null) goto L10;
        return r100;
    L10:
        Method r101 = this.type.getMethod("fromValue", new Class[]{Integer.TYPE});     // Catch: NoSuchMethodException -> L7
        this.fromValueMethod = r101;     // Catch: NoSuchMethodException -> L7
        return r101;
    L7:
        e = move-exception;
        throw new AssertionError(e);
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    public RuntimeEnumAdapter(Class<E> r100) {
        super(r100);
        this.type = r100;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof RuntimeEnumAdapter) == true) goto L5;
    L7:
        return false;
    L5:
        if (((RuntimeEnumAdapter) r100).type != this.type) goto L7;
        return true;
    }

    @Override // com.squareup.wire.EnumAdapter
    public E fromValue(int r100) {
        return (E) getFromValueMethod().invoke(null, new Object[]{Integer.valueOf(r100)});
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }
}
