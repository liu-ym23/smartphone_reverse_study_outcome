package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class StatementCreateTrigger extends Statement {
    private static native void configAfter(long r100);

    private static native void configBefore(long r100);

    private static native void configColumns(long r100, int r101, long[] r102, String[] r103);

    private static native void configDelete(long r100);

    private static native void configForEachRow(long r100);

    private static native void configIfNotExist(long r100);

    private static native void configInsert(long r100);

    private static native void configInsteadOf(long r100);

    private static native void configSchema(long r100, int r101, long r102, String r103);

    private static native void configTable(long r100, String r101);

    private static native void configTemp(long r100);

    private static native void configTrigger(long r100, String r101);

    private static native void configUpdate(long r100);

    private static native void configWhen(long r100, long r101);

    private static native long createCppObj();

    private static native void executeDelete(long r100, long r101);

    private static native void executeInsert(long r100, long r101);

    private static native void executeSelect(long r100, long r101);

    private static native void executeUpdate(long r100, long r101);

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 41;
    }

    public StatementCreateTrigger after() {
        configAfter(this.cppObj);
        return this;
    }

    public StatementCreateTrigger before() {
        configBefore(this.cppObj);
        return this;
    }

    public StatementCreateTrigger delete() {
        configDelete(this.cppObj);
        return this;
    }

    public StatementCreateTrigger forEachRow() {
        configForEachRow(this.cppObj);
        return this;
    }

    public StatementCreateTrigger ifNotExist() {
        configIfNotExist(this.cppObj);
        return this;
    }

    public StatementCreateTrigger insert() {
        configInsert(this.cppObj);
        return this;
    }

    public StatementCreateTrigger insteadOf() {
        configInsteadOf(this.cppObj);
        return this;
    }

    public StatementCreateTrigger update() {
        configUpdate(this.cppObj);
        return this;
    }

    public StatementCreateTrigger() {
        this.cppObj = createCppObj();
    }

    public StatementCreateTrigger createTempTrigger(String r100) {
        configTrigger(this.cppObj, r100);
        configTemp(this.cppObj);
        return this;
    }

    public StatementCreateTrigger createTrigger(String r100) {
        configTrigger(this.cppObj, r100);
        return this;
    }

    public StatementCreateTrigger execute(StatementDelete r100) {
        executeDelete(this.cppObj, CppObject.get(r100));
        return this;
    }

    public StatementCreateTrigger ofColumns(Column... r100) {
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

    public StatementCreateTrigger ofSchema(Schema r100) {
        configSchema(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public StatementCreateTrigger onTable(String r100) {
        configTable(this.cppObj, r100);
        return this;
    }

    public StatementCreateTrigger when(Expression r100) {
        configWhen(this.cppObj, CppObject.get(r100));
        return this;
    }

    public StatementCreateTrigger execute(StatementInsert r100) {
        executeInsert(this.cppObj, CppObject.get(r100));
        return this;
    }

    public StatementCreateTrigger ofColumns(String... r100) {
        if (r100.length != 0) goto L5;
        return this;
    L5:
        configColumns(this.cppObj, 6, null, r100);
        return this;
    }

    public StatementCreateTrigger ofSchema(String r100) {
        configSchema(this.cppObj, 6, 0, r100);
        return this;
    }

    public StatementCreateTrigger execute(StatementSelect r100) {
        executeSelect(this.cppObj, CppObject.get(r100));
        return this;
    }

    public StatementCreateTrigger execute(StatementUpdate r100) {
        executeUpdate(this.cppObj, CppObject.get(r100));
        return this;
    }
}
