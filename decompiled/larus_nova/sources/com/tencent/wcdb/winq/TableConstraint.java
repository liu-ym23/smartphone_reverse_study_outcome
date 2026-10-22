package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class TableConstraint extends Identifier {
    private static native void configCheckExpression(long r100, long r101);

    private static native void configConfliction(long r100, int r101);

    private static native void configForeignKey(long r100, int r101, long[] r102, String[] r103, long r104);

    private static native void configIndexedColumn(long r100, int r101, long[] r102, String[] r103);

    private static native void configPrimaryKey(long r100);

    private static native void configUnique(long r100);

    private static native long createCppObj(String r100);

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 19;
    }

    public TableConstraint primaryKey() {
        configPrimaryKey(this.cppObj);
        return this;
    }

    public TableConstraint unique() {
        configUnique(this.cppObj);
        return this;
    }

    public TableConstraint() {
        this.cppObj = createCppObj(null);
    }

    public TableConstraint(String r100) {
        this.cppObj = createCppObj(r100);
    }

    public TableConstraint check(Expression r100) {
        configCheckExpression(this.cppObj, CppObject.get(r100));
        return this;
    }

    public TableConstraint indexedBy(IndexedColumnConvertible... r100) {
        if (r100.length != 0) goto L5;
        return this;
    L5:
        long[] r101 = new long[r100.length];
        int r102 = 0;
    L7:
        if (r102 >= r100.length) goto L9;
        r101[r102] = CppObject.get(r100[r102]);
        r102 = r102 + 1;
        goto L7
    L9:
        configIndexedColumn(this.cppObj, Identifier.getCppType(r100[0]), r101, null);
        return this;
    }

    public TableConstraint onConflict(ConflictAction r100) {
        configConfliction(this.cppObj, r100.ordinal());
        return this;
    }

    public TableConstraint indexedBy(String... r100) {
        configIndexedColumn(this.cppObj, 6, null, r100);
        return this;
    }

    public TableConstraint foreignKey(ForeignKey r100, Column... r110) {
        long[] r101 = new long[r110.length];
        int r102 = 0;
    L4:
        if (r102 >= r110.length) goto L6;
        r101[r102] = CppObject.get(r110[r102]);
        r102 = r102 + 1;
        goto L4
    L6:
        configForeignKey(this.cppObj, 7, r101, null, CppObject.get(r100));
        return this;
    }

    public TableConstraint foreignKey(ForeignKey r100, String... r101) {
        configForeignKey(this.cppObj, 6, null, r101, CppObject.get(r100));
        return this;
    }
}
