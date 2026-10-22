package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class StatementDropTable extends Statement {
    private static native void configIfExist(long r100);

    private static native void configSchema(long r100, int r101, long r102, String r103);

    private static native void configTableName(long r100, String r101);

    private static native long createCppObj();

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 50;
    }

    public StatementDropTable ifExist() {
        configIfExist(this.cppObj);
        return this;
    }

    public StatementDropTable() {
        this.cppObj = createCppObj();
    }

    public StatementDropTable dropTable(String r100) {
        configTableName(this.cppObj, r100);
        return this;
    }

    public StatementDropTable of(Schema r100) {
        configSchema(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public StatementDropTable of(String r100) {
        configSchema(this.cppObj, 6, 0, r100);
        return this;
    }
}
