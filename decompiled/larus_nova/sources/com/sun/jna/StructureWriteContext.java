package com.sun.jna;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes40.dex */
public class StructureWriteContext extends ToNativeContext {
    private Field field;
    private Structure struct;

    public Field getField() {
        return this.field;
    }

    public Structure getStructure() {
        return this.struct;
    }

    public StructureWriteContext(Structure r100, Field r101) {
        this.struct = r100;
        this.field = r101;
    }
}
