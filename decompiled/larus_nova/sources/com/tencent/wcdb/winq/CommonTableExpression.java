package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class CommonTableExpression extends Identifier {
    private static native void configColumn(long r100, long r101);

    private static native void configSelect(long r100, long r101);

    private static native long createCPPObject(String r100);

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 20;
    }

    public CommonTableExpression(String r100) {
        this.cppObj = createCPPObject(r100);
    }

    public CommonTableExpression as(StatementSelect r100) {
        configSelect(this.cppObj, CppObject.get(r100));
        return this;
    }

    public CommonTableExpression column(Column r100) {
        configColumn(this.cppObj, CppObject.get(r100));
        return this;
    }
}
