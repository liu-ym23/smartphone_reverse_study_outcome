package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class OrderingTerm extends Identifier {
    private static native void collate(long r100, String r101);

    private static native long createCppObj(int r100, long r101);

    private static native void order(long r100, int r101);

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 22;
    }

    public static OrderingTerm ascendingRowid() {
        return Column.rowId().order(Order.Asc);
    }

    public static OrderingTerm descendingRowid() {
        return Column.rowId().order(Order.Desc);
    }

    public OrderingTerm(ExpressionConvertible r100) {
        this.cppObj = createCppObj(Identifier.getCppType(r100), CppObject.get(r100));
    }

    public OrderingTerm collate(String r100) {
        collate(this.cppObj, r100);
        return this;
    }

    public OrderingTerm order(Order r100) {
        order(this.cppObj, r100.ordinal() + 1);
        return this;
    }
}
