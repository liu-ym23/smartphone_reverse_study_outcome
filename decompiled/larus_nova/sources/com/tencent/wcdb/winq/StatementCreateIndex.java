package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class StatementCreateIndex extends Statement {
    private static native void configCondition(long r100, long r101);

    private static native void configIfNotExist(long r100);

    private static native void configIndexedColumns(long r100, int r101, long[] r102, String[] r103);

    private static native void configSchema(long r100, int r101, long r102, String r103);

    private static native void configTableName(long r100, String r101);

    private static native void configUnique(long r100);

    private static native long createCppObj();

    private static native void createIndex(long r100, String r101);

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 39;
    }

    public StatementCreateIndex ifNotExist() {
        configIfNotExist(this.cppObj);
        return this;
    }

    public StatementCreateIndex unique() {
        configUnique(this.cppObj);
        return this;
    }

    public StatementCreateIndex() {
        this.cppObj = createCppObj();
    }

    public StatementCreateIndex createIndex(String r100) {
        createIndex(this.cppObj, r100);
        return this;
    }

    public StatementCreateIndex indexedBy(IndexedColumnConvertible... r100) {
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
        configIndexedColumns(this.cppObj, Identifier.getCppType(r100[0]), r101, null);
        return this;
    }

    public StatementCreateIndex of(Schema r100) {
        configSchema(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public StatementCreateIndex on(String r100) {
        configTableName(this.cppObj, r100);
        return this;
    }

    public StatementCreateIndex where(Expression r100) {
        configCondition(this.cppObj, CppObject.get(r100));
        return this;
    }

    public StatementCreateIndex indexedBy(String... r100) {
        configIndexedColumns(this.cppObj, 6, null, r100);
        return this;
    }

    public StatementCreateIndex of(String r100) {
        configSchema(this.cppObj, 6, 0, r100);
        return this;
    }
}
