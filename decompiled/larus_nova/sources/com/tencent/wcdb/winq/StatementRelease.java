package com.tencent.wcdb.winq;

/* JADX INFO: loaded from: classes41.dex */
public class StatementRelease extends Statement {
    private static native void configSavepoint(long r100, String r101);

    private static native long createCppObj();

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 38;
    }

    public StatementRelease() {
        this.cppObj = createCppObj();
    }

    public StatementRelease release(String r100) {
        configSavepoint(this.cppObj, r100);
        return this;
    }
}
