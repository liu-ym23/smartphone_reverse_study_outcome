package com.sun.jna;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public abstract class Union extends Structure {
    private Structure.StructField activeField;

    @Override // com.sun.jna.Structure
    public List<String> getFieldOrder() {
        List<Field> r100 = getFieldList();
        ArrayList r101 = new ArrayList(r100.size());
        Iterator<Field> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r101.add(r102.next().getName());
        goto L4
    L6:
        return r101;
    }

    public Union() {
    }

    public Union(Pointer r100) {
        super(r100);
    }

    private Structure.StructField findField(Class<?> r100) {
        ensureAllocated();
        Iterator<Structure.StructField> r101 = fields().values().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Structure.StructField r102 = r101.next();
        if (r102.type.isAssignableFrom(r100) == false) goto L4;
        return r102;
    L8:
        return null;
    }

    public Object getTypedValue(Class<?> r100) {
        ensureAllocated();
        Iterator<Structure.StructField> r101 = fields().values().iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        Structure.StructField r102 = r101.next();
        if (r102.type != r100) goto L4;
        this.activeField = r102;
        read();
        return getFieldValue(this.activeField.field);
    L10:
        throw new IllegalArgumentException("No field of type " + r100 + " in " + this);
    }

    @Override // com.sun.jna.Structure
    public Object readField(Structure.StructField r100) {
        if (r100 == this.activeField) goto L14;
        if (Structure.class.isAssignableFrom(r100.type) == false) goto L7;
        return null;
    L7:
        if (String.class.isAssignableFrom(r100.type) == false) goto L9;
        return null;
    L9:
        if (WString.class.isAssignableFrom(r100.type) == false) goto L14;
        return null;
    L14:
        return super.readField(r100);
    }

    public void setType(Class<?> r100) {
        ensureAllocated();
        Iterator<Structure.StructField> r101 = fields().values().iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        Structure.StructField r102 = r101.next();
        if (r102.type != r100) goto L4;
        this.activeField = r102;
        return;
    L10:
        throw new IllegalArgumentException("No field of type " + r100 + " in " + this);
    }

    public Object setTypedValue(Object r100) {
        Structure.StructField r101 = findField(r100.getClass());
        if (r101 == null) goto L7;
        this.activeField = r101;
        setFieldValue(r101.field, r100);
        return this;
    L7:
        throw new IllegalArgumentException("No field of type " + r100.getClass() + " in " + this);
    }

    @Override // com.sun.jna.Structure
    public void writeField(String r100) {
        ensureAllocated();
        setType(r100);
        super.writeField(r100);
    }

    public Union(TypeMapper r100) {
        super(r100);
    }

    @Override // com.sun.jna.Structure
    public Object readField(String r100) {
        ensureAllocated();
        setType(r100);
        return super.readField(r100);
    }

    public void setType(String r100) {
        ensureAllocated();
        Structure.StructField r101 = fields().get(r100);
        if (r101 == null) goto L7;
        this.activeField = r101;
        return;
    L7:
        throw new IllegalArgumentException("No field named " + r100 + " in " + this);
    }

    @Override // com.sun.jna.Structure
    public void writeField(Structure.StructField r100) {
        if (r100 != this.activeField) goto L6;
        super.writeField(r100);
        return;
    }

    public Union(Pointer r100, int r101) {
        super(r100, r101);
    }

    @Override // com.sun.jna.Structure
    public void writeField(String r100, Object r101) {
        ensureAllocated();
        setType(r100);
        super.writeField(r100, r101);
    }

    public Union(Pointer r100, int r101, TypeMapper r102) {
        super(r100, r101, r102);
    }

    @Override // com.sun.jna.Structure
    public int getNativeAlignment(Class<?> r100, Object r101, boolean r102) {
        return super.getNativeAlignment(r100, r101, true);
    }
}
