package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class StatementCreateView extends Statement {
    private static native void configAs(long r100, long r101);

    private static native void configColumns(long r100, int r101, long[] r102, String[] r103);

    private static native void configIfNotExist(long r100);

    private static native void configSchema(long r100, int r101, long r102, String r103);

    private static native void configTemp(long r100);

    private static native void configView(long r100, String r101);

    private static native long createCppObj();

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 46;
    }

    public StatementCreateView ifNotExist() {
        configIfNotExist(this.cppObj);
        return this;
    }

    public StatementCreateView() {
        this.cppObj = createCppObj();
    }

    public StatementCreateView as(StatementSelect r100) {
        configAs(this.cppObj, CppObject.get(r100));
        return this;
    }

    public StatementCreateView createTempView(String r100) {
        configView(this.cppObj, r100);
        configTemp(this.cppObj);
        return this;
    }

    public StatementCreateView createView(String r100) {
        configView(this.cppObj, r100);
        return this;
    }

    public StatementCreateView of(Schema r100) {
        configSchema(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public StatementCreateView withColumns(Column... r100) {
        if (r100.length != 0) goto L5;
        return this;
    L5:
        long[] r101 = new long[r100.length];
        int r102 = 0;
    L7:
        if (r102 >= r100.length) goto L9;
        r101[r102] = CppObject.get(r100[r102]);
        r102 = r102 + 1;
        goto L7
    L9:
        configColumns(this.cppObj, 7, r101, null);
        return this;
    }

    public StatementCreateView of(String r100) {
        configSchema(this.cppObj, 6, 0, r100);
        return this;
    }

    public StatementCreateView withColumns(String... r100) {
        if (r100.length != 0) goto L5;
        return this;
    L5:
        configColumns(this.cppObj, 6, null, r100);
        return this;
    }
}
