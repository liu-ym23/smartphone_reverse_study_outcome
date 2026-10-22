package com.sun.jna.ptr;

import com.sun.jna.Native;
import com.sun.jna.Pointer;

/* JADX INFO: loaded from: classes40.dex */
public class PointerByReference extends ByReference {
    public PointerByReference() {
        this(null);
    }

    public Pointer getValue() {
        return getPointer().getPointer(0);
    }

    public PointerByReference(Pointer r100) {
        super(Native.POINTER_SIZE);
        setValue(r100);
    }

    public void setValue(Pointer r100) {
        getPointer().setPointer(0, r100);
    }
}
