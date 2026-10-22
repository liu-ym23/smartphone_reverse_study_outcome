package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class IndexedColumn extends Identifier implements IndexedColumnConvertible {
    private static native void collate(long r100, String r101);

    private static native long createCppObj(int r100, long r101, String r102);

    private static native void order(long r100, int r101);

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 18;
    }

    public IndexedColumn(IndexedColumnConvertible r100) {
        this.cppObj = createCppObj(Identifier.getCppType(r100), CppObject.get(r100), null);
    }

    public IndexedColumn collate(String r100) {
        collate(this.cppObj, r100);
        return this;
    }

    public IndexedColumn order(Order r100) {
        order(this.cppObj, r100.ordinal() + 1);
        return this;
    }

    public IndexedColumn(String r100) {
        this.cppObj = createCppObj(6, 0, r100);
    }
}
