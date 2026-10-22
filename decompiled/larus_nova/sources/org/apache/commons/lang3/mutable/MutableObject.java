package org.apache.commons.lang3.mutable;

import java.io.Serializable;

/* JADX INFO: loaded from: classes42.dex */
public class MutableObject<T> implements Serializable {
    private static final long serialVersionUID = 86241875189L;
    private T value;

    public int hashCode() {
        T r100 = this.value;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        T r100 = this.value;
        if (r100 != null) goto L6;
        return "null";
    L6:
        return r100.toString();
    }

    public MutableObject() {
    }

    public T getValue() {
        return this.value;
    }

    public MutableObject(T r100) {
        this.value = r100;
    }

    public boolean equals(Object r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (this != r100) goto L9;
        return true;
    L9:
        if (getClass() == r100.getClass()) goto L11;
        return false;
    L11:
        return this.value.equals(((MutableObject) r100).value);
    }

    public void setValue(T r100) {
        this.value = r100;
    }
}
