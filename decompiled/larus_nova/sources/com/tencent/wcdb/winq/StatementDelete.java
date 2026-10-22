package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class StatementDelete extends Statement {
    private static native void configCondition(long r100, long r101);

    private static native void configLimitCount(long r100, int r101, long r102);

    private static native void configLimitRange(long r100, int r101, long r102, int r103, long r104);

    private static native void configOffset(long r100, int r101, long r102);

    private static native void configOrders(long r100, long[] r101);

    private static native void configRecursive(long r100);

    private static native void configTable(long r100, int r101, long r102, String r103);

    private static native void configWith(long r100, long[] r101);

    private static native long createCppObj();

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 44;
    }

    public StatementDelete() {
        this.cppObj = createCppObj();
    }

    public StatementDelete deleteFrom(QualifiedTable r100) {
        configTable(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public StatementDelete limit(ExpressionConvertible r100) {
        configLimitCount(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100));
        return this;
    }

    public StatementDelete offset(ExpressionConvertible r100) {
        configOffset(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100));
        return this;
    }

    public StatementDelete orderBy(OrderingTerm... r100) {
        if (r100 != null) goto L4;
    L11:
        return this;
    L4:
        if (r100.length == 0) goto L11;
        long[] r101 = new long[r100.length];
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L10;
        r101[r102] = CppObject.get(r100[r102]);
        r102 = r102 + 1;
        goto L8
    L10:
        configOrders(this.cppObj, r101);
        goto L11
    }

    public StatementDelete where(Expression r100) {
        configCondition(this.cppObj, CppObject.get(r100));
        return this;
    }

    public StatementDelete with(CommonTableExpression... r100) {
        if (r100 != null) goto L4;
    L11:
        return this;
    L4:
        if (r100.length == 0) goto L11;
        long[] r101 = new long[r100.length];
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L10;
        r101[r102] = CppObject.get(r100[r102]);
        r102 = r102 + 1;
        goto L8
    L10:
        configWith(this.cppObj, r101);
        goto L11
    }

    public StatementDelete withRecursive(CommonTableExpression... r100) {
        if (r100 != null) goto L4;
    L11:
        return this;
    L4:
        if (r100.length == 0) goto L11;
        long[] r101 = new long[r100.length];
        int r102 = 0;
    L8:
        if (r102 >= r100.length) goto L10;
        r101[r102] = CppObject.get(r100[r102]);
        r102 = r102 + 1;
        goto L8
    L10:
        configWith(this.cppObj, r101);
        configRecursive(this.cppObj);
        goto L11
    }

    public StatementDelete deleteFrom(String r100) {
        configTable(this.cppObj, 6, 0, r100);
        return this;
    }

    public StatementDelete limit(long r100) {
        configLimitCount(this.cppObj, 3, r100);
        return this;
    }

    public StatementDelete offset(long r100) {
        configOffset(this.cppObj, 3, r100);
        return this;
    }

    public StatementDelete limit(ExpressionConvertible r100, ExpressionConvertible r110) {
        configLimitRange(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), Identifier.getCppType(r110), CppObject.get(r110));
        return this;
    }

    public StatementDelete limit(long r100, ExpressionConvertible r110) {
        configLimitRange(this.cppObj, 3, r100, Identifier.getCppType(r110), CppObject.get(r110));
        return this;
    }

    public StatementDelete limit(ExpressionConvertible r100, long r110) {
        configLimitRange(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), 3, r110);
        return this;
    }

    public StatementDelete limit(long r100, long r110) {
        configLimitRange(this.cppObj, 3, r100, 3, r110);
        return this;
    }
}
