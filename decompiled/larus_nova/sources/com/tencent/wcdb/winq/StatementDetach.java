package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class StatementDetach extends Statement {
    private static native void configSchema(long r100, int r101, long r102, String r103);

    private static native long createCppObj();

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 48;
    }

    public StatementDetach() {
        this.cppObj = createCppObj();
    }

    public StatementDetach detach(Schema r100) {
        configSchema(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public StatementDetach detach(String r100) {
        configSchema(this.cppObj, 6, 0, r100);
        return this;
    }
}
