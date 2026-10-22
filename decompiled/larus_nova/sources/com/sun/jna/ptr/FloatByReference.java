package com.sun.jna.ptr;

import com.sun.jna.Pointer;

/* JADX INFO: loaded from: classes40.dex */
public class FloatByReference extends ByReference {
    public FloatByReference() {
        this(0.0f);
    }

    @Override // com.sun.jna.ptr.ByReference, com.sun.jna.PointerType
    public String toString() {
        return String.format("float@0x%x=%s", new Object[]{Long.valueOf(Pointer.nativeValue(getPointer())), Float.valueOf(getValue())});
    }

    public float getValue() {
        return getPointer().getFloat(0);
    }

    public FloatByReference(float r100) {
        super(4);
        setValue(r100);
    }

    public void setValue(float r100) {
        getPointer().setFloat(0, r100);
    }
}
