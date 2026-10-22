package com.sun.jna.ptr;

import com.sun.jna.Pointer;

/* JADX INFO: loaded from: classes40.dex */
public class LongByReference extends ByReference {
    @Override // com.sun.jna.ptr.ByReference, com.sun.jna.PointerType
    public String toString() {
        return String.format("long@0x%1$x=0x%2$x (%2$d)", new Object[]{Long.valueOf(Pointer.nativeValue(getPointer())), Long.valueOf(getValue())});
    }

    public LongByReference() {
        this(0);
    }

    public long getValue() {
        return getPointer().getLong(0);
    }

    public LongByReference(long r100) {
        super(8);
        setValue(r100);
    }

    public void setValue(long r100) {
        getPointer().setLong(0, r100);
    }
}
