package com.sun.jna.ptr;

import com.sun.jna.Pointer;

/* JADX INFO: loaded from: classes40.dex */
public class ByteByReference extends ByReference {
    public ByteByReference() {
        this((byte) 0);
    }

    @Override // com.sun.jna.ptr.ByReference, com.sun.jna.PointerType
    public String toString() {
        return String.format("byte@0x%1$x=0x%2$x (%2$d)", new Object[]{Long.valueOf(Pointer.nativeValue(getPointer())), Byte.valueOf(getValue())});
    }

    public byte getValue() {
        return getPointer().getByte(0);
    }

    public ByteByReference(byte r100) {
        super(1);
        setValue(r100);
    }

    public void setValue(byte r100) {
        getPointer().setByte(0, r100);
    }
}
