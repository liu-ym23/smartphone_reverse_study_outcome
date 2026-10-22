package com.tencent.wcdb.orm;

import com.tencent.wcdb.winq.Column;
import com.tencent.wcdb.winq.Schema;

/* JADX INFO: loaded from: classes35.dex */
public class Field<T> extends Column {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected TableBinding<T> binding;
    private int fieldId;
    private boolean isAutoIncrement;
    private boolean isPrimaryKey;
    private String name;

    public Field<T> copySelf() {
        Field<T> r100 = new Field();
        r100.cppObj = copy(this.cppObj);
        r100.name = this.name;
        r100.fieldId = this.fieldId;
        r100.isAutoIncrement = this.isAutoIncrement;
        r100.isPrimaryKey = this.isPrimaryKey;
        r100.binding = this.binding;
        return r100;
    }

    public Field() {
        this.binding = null;
        this.fieldId = 0;
        this.isAutoIncrement = false;
        this.isPrimaryKey = false;
    }

    static {
    }

    public int getFieldId() {
        return this.fieldId;
    }

    public String getName() {
        return this.name;
    }

    public TableBinding<T> getTableBinding() {
        return this.binding;
    }

    public boolean isAutoIncrement() {
        return this.isAutoIncrement;
    }

    public boolean isPrimaryKey() {
        return this.isPrimaryKey;
    }

    @SafeVarargs
    public static <T> Class<T> getBindClass(Field<T>... r100) {
        return r100[0].binding.bindingType();
    }

    @SafeVarargs
    public static <T> TableBinding<T> getBinding(Field<T>... r100) {
        return getBinding(r100[0]);
    }

    @Override // com.tencent.wcdb.winq.Column
    public Field<T> of(Schema r100) {
        Field<T> r101 = copySelf();
        r101.ofSchema(r100);
        return r101;
    }

    @Override // com.tencent.wcdb.winq.Column
    public Field<T> table(String r100) {
        Field<T> r101 = copySelf();
        r101.inTable(r101.cppObj, r100);
        return r101;
    }

    public static <T> TableBinding<T> getBinding(Field<T> r100) {
        return r100.getTableBinding();
    }

    @Override // com.tencent.wcdb.winq.Column
    public Field<T> of(String r100) {
        Field<T> r101 = copySelf();
        r101.ofSchema(r100);
        return r101;
    }

    @Override // com.tencent.wcdb.winq.Column
    public /* bridge */ /* synthetic */ Column table(String r100) {
        return table(r100);
    }

    @Override // com.tencent.wcdb.winq.Column
    public /* bridge */ /* synthetic */ Column of(Schema r100) {
        return of(r100);
    }

    @Override // com.tencent.wcdb.winq.Column
    public /* bridge */ /* synthetic */ Column of(String r100) {
        return of(r100);
    }

    public Field(String r100, TableBinding<T> r101, int r102, boolean r103, boolean r104) {
        super(r100, r101.baseBinding().getBaseBinding());
        this.name = r100;
        this.binding = r101;
        this.fieldId = r102;
        this.isAutoIncrement = r103;
        this.isPrimaryKey = r104;
    }
}
