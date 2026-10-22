package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class StatementDropIndex extends Statement {
    private static native void configIfExist(long r100);

    private static native void configIndex(long r100, String r101);

    private static native void configSchema(long r100, int r101, long r102, String r103);

    private static native long createCppObj();

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 49;
    }

    public StatementDropIndex ifExist() {
        configIfExist(this.cppObj);
        return this;
    }

    public StatementDropIndex() {
        this.cppObj = createCppObj();
    }

    public StatementDropIndex dropIndex(String r100) {
        configIndex(this.cppObj, r100);
        return this;
    }

    public StatementDropIndex of(Schema r100) {
        configSchema(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public StatementDropIndex of(String r100) {
        configSchema(this.cppObj, 6, 0, r100);
        return this;
    }
}
