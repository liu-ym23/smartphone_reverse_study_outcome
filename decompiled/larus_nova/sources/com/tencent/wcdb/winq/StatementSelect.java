package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;
import java.util.Arrays;

/* JADX INFO: loaded from: classes41.dex */
public class StatementSelect extends Statement implements TableOrSubqueryConvertible {
    private static native void configCondition(long r100, long r101);

    private static native void configDistinct(long r100);

    private static native void configExcept(long r100);

    private static native void configGroups(long r100, int[] r101, long[] r102, double[] r103, String[] r104);

    private static native void configHaving(long r100, long r101);

    private static native void configIntersect(long r100);

    private static native void configLimitCount(long r100, int r101, long r102);

    private static native void configLimitRange(long r100, int r101, long r102, int r103, long r104);

    private static native void configOffset(long r100, int r101, long r102);

    private static native void configOrders(long r100, long[] r101);

    private static native void configRecursive(long r100);

    private static native void configResultColumns(long r100, int[] r101, long[] r102, double[] r103, String[] r104);

    private static native void configTableOrSubqueries(long r100, int[] r101, long[] r102, double[] r103, String[] r104);

    private static native void configUnion(long r100);

    private static native void configUnionAll(long r100);

    private static native void configWith(long r100, long[] r101);

    private static native long createCppObj();

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 42;
    }

    public StatementSelect distinct() {
        configDistinct(this.cppObj);
        return this;
    }

    public StatementSelect except() {
        configExcept(this.cppObj);
        return this;
    }

    public StatementSelect intersect() {
        configIntersect(this.cppObj);
        return this;
    }

    public StatementSelect union() {
        configUnion(this.cppObj);
        return this;
    }

    public StatementSelect unionAll() {
        configUnionAll(this.cppObj);
        return this;
    }

    public StatementSelect() {
        this.cppObj = createCppObj();
    }

    public StatementSelect from(Object... r110) {
        if (r110.length != 0) goto L5;
        return this;
    L5:
        int r100 = r110.length;
        int[] r101 = new int[r100];
        long[] r102 = new long[r100];
        String[] r103 = new String[r100];
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L6:
        if (r104 >= r100) goto L15;
        Object r107 = r110[r104];
        if ((r107 instanceof String) == false) goto L11;
        r101[r104] = 6;
        r103[r105] = (String) r107;
        r105 = r105 + 1;
    L13:
        r104 = r104 + 1;
        goto L6
    L11:
        if ((r107 instanceof TableOrSubqueryConvertible) == false) goto L13;
        TableOrSubqueryConvertible r108 = (TableOrSubqueryConvertible) r107;
        r101[r104] = Identifier.getCppType(r108);
        r102[r106] = CppObject.get(r108);
        r106 = r106 + 1;
        goto L13
    L15:
        if ((((double) r100) * 0.75d) <= r105) goto L20;
        if (r105 != 0) goto L18;
        String[] r111 = null;
    L19:
        String[] r109 = r111;
    L21:
        configTableOrSubqueries(this.cppObj, r101, r102, null, r109);
        return this;
    L18:
        r111 = (String[]) Arrays.copyOf(r103, r105);
        goto L19
    L20:
        r109 = r103;
        goto L21
    }

    public StatementSelect groupBy(Object... r110) {
        if (r110 != null) goto L4;
    L23:
        return this;
    L4:
        if (r110.length == 0) goto L23;
        int r100 = r110.length;
        int[] r101 = new int[r100];
        long[] r102 = new long[r100];
        String[] r103 = new String[r100];
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L7:
        if (r104 >= r100) goto L16;
        Object r107 = r110[r104];
        if ((r107 instanceof String) == false) goto L12;
        r101[r104] = 6;
        r103[r105] = (String) r107;
        r105 = r105 + 1;
    L14:
        r104 = r104 + 1;
        goto L7
    L12:
        if ((r107 instanceof ExpressionConvertible) == false) goto L14;
        ExpressionConvertible r108 = (ExpressionConvertible) r107;
        r101[r104] = Identifier.getCppType(r108);
        r102[r106] = CppObject.get(r108);
        r106 = r106 + 1;
        goto L14
    L16:
        if ((((double) r100) * 0.75d) <= r105) goto L21;
        if (r105 != 0) goto L19;
        String[] r111 = null;
    L20:
        String[] r109 = r111;
    L22:
        configGroups(this.cppObj, r101, r102, null, r109);
        goto L23
    L19:
        r111 = (String[]) Arrays.copyOf(r103, r105);
        goto L20
    L21:
        r109 = r103;
        goto L22
    }

    public StatementSelect having(Expression r100) {
        configHaving(this.cppObj, CppObject.get(r100));
        return this;
    }

    public StatementSelect limit(ExpressionConvertible r100) {
        configLimitCount(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100));
        return this;
    }

    public StatementSelect offset(ExpressionConvertible r100) {
        configOffset(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100));
        return this;
    }

    public StatementSelect orderBy(OrderingTerm... r100) {
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

    public StatementSelect select(Object... r110) {
        if (r110.length != 0) goto L5;
        return this;
    L5:
        int r100 = r110.length;
        int[] r101 = new int[r100];
        long[] r102 = new long[r100];
        String[] r103 = new String[r100];
        int r104 = 0;
        int r105 = 0;
        int r106 = 0;
    L6:
        if (r104 >= r100) goto L15;
        Object r107 = r110[r104];
        if ((r107 instanceof String) == false) goto L11;
        r101[r104] = 6;
        r103[r105] = (String) r107;
        r105 = r105 + 1;
    L13:
        r104 = r104 + 1;
        goto L6
    L11:
        if ((r107 instanceof ResultColumnConvertible) == false) goto L13;
        ResultColumnConvertible r108 = (ResultColumnConvertible) r107;
        r101[r104] = Identifier.getCppType(r108);
        r102[r106] = CppObject.get(r108);
        r106 = r106 + 1;
        goto L13
    L15:
        if ((((double) r100) * 0.75d) <= r105) goto L20;
        if (r105 != 0) goto L18;
        String[] r111 = null;
    L19:
        String[] r109 = r111;
    L21:
        configResultColumns(this.cppObj, r101, r102, null, r109);
        return this;
    L18:
        r111 = (String[]) Arrays.copyOf(r103, r105);
        goto L19
    L20:
        r109 = r103;
        goto L21
    }

    public StatementSelect where(Expression r100) {
        configCondition(this.cppObj, CppObject.get(r100));
        return this;
    }

    public StatementSelect with(CommonTableExpression... r100) {
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

    public StatementSelect withRecursive(CommonTableExpression... r100) {
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

    public StatementSelect from(TableOrSubqueryConvertible... r100) {
        if (r100.length != 0) goto L5;
        return this;
    L5:
        int r101 = r100.length;
        int[] r102 = new int[r101];
        long[] r103 = new long[r101];
        int r104 = 0;
    L6:
        if (r104 >= r101) goto L8;
        r102[r104] = Identifier.getCppType(r100[r104]);
        r103[r104] = CppObject.get(r100[r104]);
        r104 = r104 + 1;
        goto L6
    L8:
        configTableOrSubqueries(this.cppObj, r102, r103, null, null);
        return this;
    }

    public StatementSelect groupBy(ExpressionConvertible... r100) {
        if (r100 != null) goto L4;
    L10:
        return this;
    L4:
        if (r100.length == 0) goto L10;
        int r101 = r100.length;
        int[] r102 = new int[r101];
        long[] r103 = new long[r101];
        int r104 = 0;
    L7:
        if (r104 >= r101) goto L9;
        r102[r104] = Identifier.getCppType(r100[r104]);
        r103[r104] = CppObject.get(r100[r104]);
        r104 = r104 + 1;
        goto L7
    L9:
        configGroups(this.cppObj, r102, r103, null, null);
        goto L10
    }

    public StatementSelect limit(long r100) {
        configLimitCount(this.cppObj, 3, r100);
        return this;
    }

    public StatementSelect offset(long r100) {
        configOffset(this.cppObj, 3, r100);
        return this;
    }

    public StatementSelect select(ResultColumnConvertible... r100) {
        if (r100.length != 0) goto L5;
        return this;
    L5:
        int r101 = r100.length;
        int[] r102 = new int[r101];
        long[] r103 = new long[r101];
        int r104 = 0;
    L6:
        if (r104 >= r101) goto L8;
        r102[r104] = Identifier.getCppType(r100[r104]);
        r103[r104] = CppObject.get(r100[r104]);
        r104 = r104 + 1;
        goto L6
    L8:
        configResultColumns(this.cppObj, r102, r103, null, null);
        return this;
    }

    public StatementSelect from(String... r100) {
        if (r100.length != 0) goto L5;
        return this;
    L5:
        int[] r101 = new int[r100.length];
        Arrays.fill(r101, 6);
        configTableOrSubqueries(this.cppObj, r101, null, null, r100);
        return this;
    }

    public StatementSelect groupBy(String... r100) {
        if (r100 != null) goto L4;
    L7:
        return this;
    L4:
        if (r100.length == 0) goto L7;
        int[] r101 = new int[r100.length];
        Arrays.fill(r101, 6);
        configGroups(this.cppObj, r101, null, null, r100);
        goto L7
    }

    public StatementSelect select(String... r100) {
        if (r100.length != 0) goto L5;
        return this;
    L5:
        int[] r101 = new int[r100.length];
        Arrays.fill(r101, 6);
        configResultColumns(this.cppObj, r101, null, null, r100);
        return this;
    }

    public StatementSelect limit(ExpressionConvertible r100, ExpressionConvertible r110) {
        configLimitRange(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), Identifier.getCppType(r110), CppObject.get(r110));
        return this;
    }

    public StatementSelect limit(long r100, ExpressionConvertible r110) {
        configLimitRange(this.cppObj, 3, r100, Identifier.getCppType(r110), CppObject.get(r110));
        return this;
    }

    public StatementSelect limit(ExpressionConvertible r100, long r110) {
        configLimitRange(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), 3, r110);
        return this;
    }

    public StatementSelect limit(long r100, long r110) {
        configLimitRange(this.cppObj, 3, r100, 3, r110);
        return this;
    }
}
