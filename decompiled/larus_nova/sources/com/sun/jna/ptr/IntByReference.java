package com.sun.jna.ptr;

import com.sun.jna.Pointer;

/* JADX INFO: loaded from: classes40.dex */
public class IntByReference extends ByReference {
    public IntByReference() {
        this(0);
    }

    @Override // com.sun.jna.ptr.ByReference, com.sun.jna.PointerType
    public String toString() {
        return String.format("int@0x%1$x=0x%2$x (%2$d)", new Object[]{Long.valueOf(Pointer.nativeValue(getPointer())), Integer.valueOf(getValue())});
    }

    public int getValue() {
        return getPointer().getInt(0);
    }

    public IntByReference(int r100) {
        super(4);
        setValue(r100);
    }

    public void setValue(int r100) {
        getPointer().setInt(0, r100);
    }
}
