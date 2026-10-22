package com.sun.jna;

/* JADX INFO: loaded from: classes40.dex */
public abstract class PointerType implements NativeMapped {
    private Pointer pointer;

    public int hashCode() {
        Pointer r100 = this.pointer;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        if (this.pointer != null) goto L6;
        return "NULL";
    L6:
        return this.pointer.toString() + " (" + super.toString() + ")";
    }

    public PointerType() {
        this.pointer = Pointer.NULL;
    }

    @Override // com.sun.jna.NativeMapped
    public Object toNative() {
        return getPointer();
    }

    public Pointer getPointer() {
        return this.pointer;
    }

    @Override // com.sun.jna.NativeMapped
    public Class<?> nativeType() {
        return Pointer.class;
    }

    public PointerType(Pointer r100) {
        this.pointer = r100;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof PointerType) == false) goto L15;
        Pointer r101 = ((PointerType) r100).getPointer();
        Pointer r102 = this.pointer;
        if (r102 != null) goto L14;
        if (r101 == null) goto L16;
        return false;
    L16:
        return true;
    L14:
        return r102.equals(r101);
    L15:
        return false;
    }

    public void setPointer(Pointer r100) {
        this.pointer = r100;
    }

    @Override // com.sun.jna.NativeMapped
    public Object fromNative(Object r100, FromNativeContext r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        PointerType r102 = (PointerType) Klass.newInstance(getClass());
        r102.pointer = (Pointer) r100;
        return r102;
    }
}
