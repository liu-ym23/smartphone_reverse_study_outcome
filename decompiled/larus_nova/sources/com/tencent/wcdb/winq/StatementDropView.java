package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class StatementDropView extends Statement {
    private static native void configIfExist(long r100);

    private static native void configSchema(long r100, int r101, long r102, String r103);

    private static native void configView(long r100, String r101);

    private static native long createCppObj();

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 52;
    }

    public StatementDropView ifExist() {
        configIfExist(this.cppObj);
        return this;
    }

    public StatementDropView() {
        this.cppObj = createCppObj();
    }

    public StatementDropView dropView(String r100) {
        configView(this.cppObj, r100);
        return this;
    }

    public StatementDropView of(Schema r100) {
        configSchema(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public StatementDropView of(String r100) {
        configSchema(this.cppObj, 6, 0, r100);
        return this;
    }
}
