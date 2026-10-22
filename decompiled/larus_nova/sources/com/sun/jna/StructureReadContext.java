package com.sun.jna;

import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes40.dex */
public class StructureReadContext extends FromNativeContext {
    private Field field;
    private Structure structure;

    public Field getField() {
        return this.field;
    }

    public Structure getStructure() {
        return this.structure;
    }

    public StructureReadContext(Structure r100, Field r101) {
        super(r101.getType());
        this.structure = r100;
        this.field = r101;
    }
}
