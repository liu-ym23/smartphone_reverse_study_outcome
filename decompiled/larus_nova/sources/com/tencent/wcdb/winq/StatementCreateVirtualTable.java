package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class StatementCreateVirtualTable extends Statement {
    private static native void configArguments(long r100, String[] r101);

    private static native void configIfNotExist(long r100);

    private static native void configModule(long r100, String r101);

    private static native void configSchema(long r100, int r101, long r102, String r103);

    private static native void configTable(long r100, String r101);

    private static native long createCppObj();

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 47;
    }

    public StatementCreateVirtualTable ifNotExist() {
        configIfNotExist(this.cppObj);
        return this;
    }

    public StatementCreateVirtualTable() {
        this.cppObj = createCppObj();
    }

    public StatementCreateVirtualTable arguments(String... r100) {
        configArguments(this.cppObj, r100);
        return this;
    }

    public StatementCreateVirtualTable createVirtualTable(String r100) {
        configTable(this.cppObj, r100);
        return this;
    }

    public StatementCreateVirtualTable of(Schema r100) {
        configSchema(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public StatementCreateVirtualTable usingModule(String r100) {
        configModule(this.cppObj, r100);
        return this;
    }

    public StatementCreateVirtualTable of(String r100) {
        configSchema(this.cppObj, 6, 0, r100);
        return this;
    }
}
