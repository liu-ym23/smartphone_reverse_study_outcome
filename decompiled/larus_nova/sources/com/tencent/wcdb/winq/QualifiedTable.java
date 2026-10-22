package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class QualifiedTable extends Identifier {
    private static native void alias(long r100, String r101);

    private static native long createCppObj(String r100);

    private static native void indexed(long r100, String r101);

    private static native void notIndexed(long r100);

    private static native void schema(long r100, int r101, long r102, String r103);

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 21;
    }

    public QualifiedTable notIndexed() {
        notIndexed(this.cppObj);
        return this;
    }

    public QualifiedTable(String r100) {
        this.cppObj = createCppObj(r100);
    }

    public QualifiedTable as(String r100) {
        alias(this.cppObj, r100);
        return this;
    }

    public QualifiedTable indexed(String r100) {
        indexed(this.cppObj, r100);
        return this;
    }

    public QualifiedTable of(Schema r100) {
        schema(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public QualifiedTable of(String r100) {
        schema(this.cppObj, 6, 0, r100);
        return this;
    }
}
