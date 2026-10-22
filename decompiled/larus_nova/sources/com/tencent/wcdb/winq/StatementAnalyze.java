package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class StatementAnalyze extends Statement {
    private static native void configIndex(long r100, String r101);

    private static native void configSchema(long r100, int r101, long r102, String r103);

    private static native void configTable(long r100, String r101);

    private static native void configToAnalyze(long r100);

    private static native long createCppObj();

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 32;
    }

    public StatementAnalyze analyze() {
        configToAnalyze(this.cppObj);
        return this;
    }

    public StatementAnalyze() {
        this.cppObj = createCppObj();
    }

    public StatementAnalyze index(String r100) {
        configIndex(this.cppObj, r100);
        return this;
    }

    public StatementAnalyze schema(Schema r100) {
        configSchema(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public StatementAnalyze table(String r100) {
        configTable(this.cppObj, r100);
        return this;
    }

    public StatementAnalyze schema(String r100) {
        configSchema(this.cppObj, 6, 0, r100);
        return this;
    }
}
