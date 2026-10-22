package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class StatementCreateTable extends Statement {
    private static native void configAs(long r100, long r101);

    private static native void configColumn(long r100, long r101);

    private static native void configColumns(long r100, long[] r101);

    private static native void configConstraints(long r100, long[] r101);

    private static native void configIfNotExist(long r100);

    private static native void configSchema(long r100, int r101, long r102, String r103);

    private static native void configTableName(long r100, String r101);

    private static native void configTemp(long r100);

    private static native void configWithoutRowid(long r100);

    private static native long createCppObj();

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 40;
    }

    public StatementCreateTable ifNotExist() {
        configIfNotExist(this.cppObj);
        return this;
    }

    public StatementCreateTable withoutRowid() {
        configWithoutRowid(this.cppObj);
        return this;
    }

    public StatementCreateTable() {
        this.cppObj = createCppObj();
    }

    public StatementCreateTable as(StatementSelect r100) {
        configAs(this.cppObj, CppObject.get(r100));
        return this;
    }

    public StatementCreateTable constraint(TableConstraint... r100) {
        if (r100 != null) goto L4;
    L11:
        return this;
    L4:
        if (r100.length == 0) goto L11;
        long[] r101 = new long[r100.length];
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L10;
        r101[r102] = CppObject.get(r100[r102]);
        r102 = r102 + 1;
        goto L8
    L10:
        configConstraints(this.cppObj, r101);
        goto L11
    }

    public StatementCreateTable createTable(String r100) {
        configTableName(this.cppObj, r100);
        return this;
    }

    public StatementCreateTable createTempTable(String r100) {
        configTableName(this.cppObj, r100);
        configTemp(this.cppObj);
        return this;
    }

    public StatementCreateTable define(ColumnDef... r100) {
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
        configColumns(this.cppObj, r101);
        return this;
    }

    public StatementCreateTable of(Schema r100) {
        configSchema(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public StatementCreateTable constraint(TableConstraint r100) {
        configConstraints(this.cppObj, new long[]{CppObject.get(r100)});
        return this;
    }

    public StatementCreateTable define(ColumnDef r100) {
        configColumn(this.cppObj, CppObject.get(r100));
        return this;
    }

    public StatementCreateTable of(String r100) {
        configSchema(this.cppObj, 6, 0, r100);
        return this;
    }
}
