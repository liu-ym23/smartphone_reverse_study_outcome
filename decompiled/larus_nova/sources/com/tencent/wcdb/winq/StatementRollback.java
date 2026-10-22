package com.tencent.wcdb.winq;

/* JADX INFO: loaded from: classes41.dex */
public class StatementRollback extends Statement {
    private static native void configSavepoint(long r100, String r101);

    private static native long createCppObj();

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 36;
    }

    public StatementRollback() {
        this.cppObj = createCppObj();
    }

    public StatementRollback rollbackTo(String r100) {
        configSavepoint(this.cppObj, r100);
        return this;
    }
}
