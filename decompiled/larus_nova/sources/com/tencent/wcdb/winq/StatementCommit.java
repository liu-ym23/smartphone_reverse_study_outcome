package com.tencent.wcdb.winq;

/* JADX INFO: loaded from: classes41.dex */
public class StatementCommit extends Statement {
    private static native long createCppObj();

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 35;
    }

    public StatementCommit() {
        this.cppObj = createCppObj();
    }
}
