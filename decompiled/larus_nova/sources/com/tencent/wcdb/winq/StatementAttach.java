package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class StatementAttach extends Statement {
    private static native void configKey(long r100, int r101, long r102, String r103);

    private static native void configPath(long r100, int r101, long r102, String r103);

    private static native void configSchema(long r100, int r101, long r102, String r103);

    private static native long createCppObj();

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 33;
    }

    public StatementAttach() {
        this.cppObj = createCppObj();
    }

    public StatementAttach as(Schema r100) {
        configSchema(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public StatementAttach attach(BindParameter r100) {
        configPath(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public StatementAttach key(BindParameter r100) {
        configKey(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public StatementAttach as(String r100) {
        configSchema(this.cppObj, 6, 0, r100);
        return this;
    }

    public StatementAttach attach(String r100) {
        configPath(this.cppObj, 6, 0, r100);
        return this;
    }

    public StatementAttach key(String r100) {
        configKey(this.cppObj, 6, 0, r100);
        return this;
    }
}
