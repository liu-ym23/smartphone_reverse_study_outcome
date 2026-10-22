package com.tencent.wcdb.winq;

/* JADX INFO: loaded from: classes41.dex */
public class Statement extends Identifier {
    public boolean isWriteStatement() {
        return Identifier.isWriteStatement(this.cppObj);
    }

    public Statement() {
    }
}
