package com.sun.jna.ptr;

import com.sun.jna.Pointer;

/* JADX INFO: loaded from: classes40.dex */
public class ShortByReference extends ByReference {
    public ShortByReference() {
        this(0);
    }

    @Override // com.sun.jna.ptr.ByReference, com.sun.jna.PointerType
    public String toString() {
        return String.format("short@0x%1$x=0x%2$x (%2$d)", new Object[]{Long.valueOf(Pointer.nativeValue(getPointer())), Short.valueOf(getValue())});
    }

    public short getValue() {
        return getPointer().getShort(0);
    }

    public ShortByReference(short r100) {
        super(2);
        setValue(r100);
    }

    public void setValue(short r100) {
        getPointer().setShort(0, r100);
    }
}
