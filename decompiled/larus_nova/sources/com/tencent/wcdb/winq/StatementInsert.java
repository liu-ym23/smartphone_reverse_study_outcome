package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class StatementInsert extends Statement {
    private static native void configAlias(long r100, String r101);

    private static native void configColumns(long r100, int r101, long[] r102, String[] r103);

    private static native void configConflictAction(long r100, int r101);

    private static native void configDefaultValues(long r100);

    private static native void configRecursive(long r100);

    private static native void configSchema(long r100, int r101, long r102, String r103);

    private static native void configTableName(long r100, String r101);

    private static native void configUpsert(long r100, long r101);

    private static native void configValues(long r100, long r101);

    private static native void configValues(long r100, int[] r101, long[] r102, double[] r103, String[] r104);

    private static native void configValuesWithBindParameters(long r100, int r101);

    private static native void configWith(long r100, long[] r101);

    private static native long createCppObj();

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 43;
    }

    public StatementInsert defaultValues() {
        configDefaultValues(this.cppObj);
        return this;
    }

    public StatementInsert orAbort() {
        configConflictAction(this.cppObj, ConflictAction.Abort.ordinal());
        return this;
    }

    public StatementInsert orFail() {
        configConflictAction(this.cppObj, ConflictAction.Fail.ordinal());
        return this;
    }

    public StatementInsert orIgnore() {
        configConflictAction(this.cppObj, ConflictAction.Ignore.ordinal());
        return this;
    }

    public StatementInsert orReplace() {
        configConflictAction(this.cppObj, ConflictAction.Replace.ordinal());
        return this;
    }

    public StatementInsert orRollback() {
        configConflictAction(this.cppObj, ConflictAction.Rollback.ordinal());
        return this;
    }

    public StatementInsert() {
        this.cppObj = createCppObj();
    }

    public StatementInsert as(String r100) {
        configAlias(this.cppObj, r100);
        return this;
    }

    public StatementInsert columns(Column... r100) {
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
        configColumns(this.cppObj, 7, r101, null);
        return this;
    }

    public StatementInsert insertInto(String r100) {
        configTableName(this.cppObj, r100);
        return this;
    }

    public StatementInsert of(Schema r100) {
        configSchema(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public StatementInsert upsert(Upsert r100) {
        configUpsert(this.cppObj, CppObject.get(r100));
        return this;
    }

    public StatementInsert values(Object... r100) {
        if (r100 != null) goto L4;
    L7:
        return this;
    L4:
        if (r100.length == 0) goto L7;
        MultiTypeArray r101 = new MultiTypeArray(r100);
        configValues(this.cppObj, r101.types, r101.longValues, r101.doubleValues, r101.stringValues);
        goto L7
    }

    public StatementInsert valuesWithBindParameters(int r100) {
        configValuesWithBindParameters(this.cppObj, r100);
        return this;
    }

    public StatementInsert with(CommonTableExpression... r100) {
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
        configWith(this.cppObj, r101);
        goto L11
    }

    public StatementInsert withRecursive(CommonTableExpression... r100) {
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
        configWith(this.cppObj, r101);
        configRecursive(this.cppObj);
        goto L11
    }

    public StatementInsert columns(String... r100) {
        if (r100.length != 0) goto L5;
        return this;
    L5:
        configColumns(this.cppObj, 6, null, r100);
        return this;
    }

    public StatementInsert of(String r100) {
        configSchema(this.cppObj, 6, 0, r100);
        return this;
    }

    public StatementInsert values(StatementSelect r100) {
        configValues(this.cppObj, CppObject.get(r100));
        return this;
    }
}
