package com.sun.jna.ptr;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;

/* JADX INFO: loaded from: classes40.dex */
public class NativeLongByReference extends ByReference {
    public NativeLongByReference() {
        this(new NativeLong(0));
    }

    @Override // com.sun.jna.ptr.ByReference, com.sun.jna.PointerType
    public String toString() {
        if (NativeLong.SIZE <= 4) goto L7;
        return String.format("NativeLong@0x1$%x=0x%2$x (%2$d)", new Object[]{Long.valueOf(Pointer.nativeValue(getPointer())), Long.valueOf(getValue().longValue())});
    L7:
        return String.format("NativeLong@0x1$%x=0x%2$x (%2$d)", new Object[]{Long.valueOf(Pointer.nativeValue(getPointer())), Integer.valueOf(getValue().intValue())});
    }

    public NativeLong getValue() {
        return getPointer().getNativeLong(0);
    }

    public NativeLongByReference(NativeLong r100) {
        super(NativeLong.SIZE);
        setValue(r100);
    }

    public void setValue(NativeLong r100) {
        getPointer().setNativeLong(0, r100);
    }
}
