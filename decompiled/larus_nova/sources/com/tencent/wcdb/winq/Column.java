package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class Column extends ExpressionOperable implements IndexedColumnConvertible, ResultColumnConvertible {
    private static native long allColumn();

    private static native long configAlias(long r100, String r101);

    private static native long createCppObj(String r100, long r101);

    private static native long rowidColumn();

    public native long copy(long r100);

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 7;
    }

    public native void inTable(long r100, String r101);

    public native void ofSchema(long r100, int r101, long r102, String r103);

    public static Column all() {
        Column r100 = new Column();
        r100.cppObj = allColumn();
        return r100;
    }

    public static Column rowId() {
        Column r100 = new Column();
        r100.cppObj = rowidColumn();
        return r100;
    }

    public Column() {
    }

    public Column(String r100) {
        this.cppObj = createCppObj(r100, 0);
    }

    public ResultColumn as(String r100) {
        return new ResultColumn(configAlias(this.cppObj, r100));
    }

    public ColumnDef asDef(ColumnType r100) {
        return new ColumnDef(this, r100);
    }

    public Column of(Schema r100) {
        ofSchema(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public void ofSchema(Schema r100) {
        ofSchema(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
    }

    public OrderingTerm order(Order r100) {
        return new OrderingTerm(this).order(r100);
    }

    public Column table(String r100) {
        inTable(this.cppObj, r100);
        return this;
    }

    public Column of(String r100) {
        ofSchema(this.cppObj, 6, 0, r100);
        return this;
    }

    public void ofSchema(String r100) {
        ofSchema(this.cppObj, 6, 0, r100);
    }

    public Column(String r100, long r101) {
        this.cppObj = createCppObj(r100, r101);
    }
}
