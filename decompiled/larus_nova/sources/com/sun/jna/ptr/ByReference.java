package com.sun.jna.ptr;

import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.PointerType;

/* JADX INFO: loaded from: classes40.dex */
public abstract class ByReference extends PointerType {
    @Override // com.sun.jna.PointerType
    public String toString() {
        Object r100 = getClass().getMethod("getValue", new Class[0]).invoke(this, new Object[0]);     // Catch: Exception -> L9
        if (r100 != null) goto L8;
        return String.format("null@0x%x", new Object[]{Long.valueOf(Pointer.nativeValue(getPointer()))});
    L8:
        return String.format("%s@0x%x=%s", new Object[]{r100.getClass().getSimpleName(), Long.valueOf(Pointer.nativeValue(getPointer())), r100});
    L9:
        e = move-exception;
        return String.format("ByReference Contract violated - %s#getValue raised exception: %s", new Object[]{getClass().getName(), e.getMessage()});
    }

    public ByReference(int r100) {
        setPointer(new Memory(r100));
    }
}
