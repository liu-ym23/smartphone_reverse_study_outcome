package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class StatementExplain extends Statement {
    private static native long createCppObj();

    private static native void explain(long r100, long r101, boolean r102);

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 56;
    }

    public StatementExplain() {
        this.cppObj = createCppObj();
    }

    public StatementExplain explain(Statement r100) {
        explain(this.cppObj, CppObject.get(r100), false);
        return this;
    }

    public StatementExplain explainQueryPlan(Statement r100) {
        explain(this.cppObj, CppObject.get(r100), true);
        return this;
    }
}
