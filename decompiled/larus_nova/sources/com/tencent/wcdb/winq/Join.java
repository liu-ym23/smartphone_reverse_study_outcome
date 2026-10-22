package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class Join extends Identifier implements TableOrSubqueryConvertible {
    private static native void configJoin(long r100, int r101, long r102, String r103);

    private static native void configOn(long r100, long r101);

    private static native void configUsingColumn(long r100, int r101, long[] r102, String[] r103);

    private static native void configWith(long r100, int r101, long r102, String r103);

    private static native void configWithCrossJoin(long r100, int r101, long r102, String r103);

    private static native void configWithInnerJoin(long r100, int r101, long r102, String r103);

    private static native void configWithLeftJoin(long r100, int r101, long r102, String r103);

    private static native void configWithLeftOuterJoin(long r100, int r101, long r102, String r103);

    private static native void configWithNaturalCrossJoin(long r100, int r101, long r102, String r103);

    private static native void configWithNaturalInnerJoin(long r100, int r101, long r102, String r103);

    private static native void configWithNaturalJoin(long r100, int r101, long r102, String r103);

    private static native void configWithNaturalLeftJoin(long r100, int r101, long r102, String r103);

    private static native void configWithNaturalLeftOuterJoin(long r100, int r101, long r102, String r103);

    private static native long createCppObj(int r100, long r101, String r102);

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 25;
    }

    public Join(TableOrSubqueryConvertible r100) {
        this.cppObj = createCppObj(Identifier.getCppType(r100), CppObject.get(r100), null);
    }

    public Join crossJoin(TableOrSubqueryConvertible r100) {
        configWithCrossJoin(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public Join innerJoin(TableOrSubqueryConvertible r100) {
        configWithInnerJoin(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public Join join(TableOrSubqueryConvertible r100) {
        configJoin(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public Join leftJoin(TableOrSubqueryConvertible r100) {
        configWithLeftJoin(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public Join leftOuterJoin(TableOrSubqueryConvertible r100) {
        configWithLeftOuterJoin(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public Join naturalCrossJoin(TableOrSubqueryConvertible r100) {
        configWithNaturalCrossJoin(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public Join naturalInnerJoin(TableOrSubqueryConvertible r100) {
        configWithNaturalInnerJoin(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public Join naturalJoin(TableOrSubqueryConvertible r100) {
        configWithNaturalJoin(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public Join naturalLeftJoin(TableOrSubqueryConvertible r100) {
        configWithNaturalLeftJoin(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public Join naturalLeftOuterJoin(TableOrSubqueryConvertible r100) {
        configWithNaturalLeftOuterJoin(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public Join on(Expression r100) {
        configOn(this.cppObj, CppObject.get(r100));
        return this;
    }

    public Join using(Column... r100) {
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
        configUsingColumn(this.cppObj, 7, r101, null);
        goto L11
    }

    public Join with(TableOrSubqueryConvertible r100) {
        configWith(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public Join(String r100) {
        this.cppObj = createCppObj(6, 0, r100);
    }

    public Join crossJoin(String r100) {
        configWithCrossJoin(this.cppObj, 6, 0, r100);
        return this;
    }

    public Join innerJoin(String r100) {
        configWithInnerJoin(this.cppObj, 6, 0, r100);
        return this;
    }

    public Join join(String r100) {
        configJoin(this.cppObj, 6, 0, r100);
        return this;
    }

    public Join leftJoin(String r100) {
        configWithLeftJoin(this.cppObj, 6, 0, r100);
        return this;
    }

    public Join leftOuterJoin(String r100) {
        configWithLeftOuterJoin(this.cppObj, 6, 0, r100);
        return this;
    }

    public Join naturalCrossJoin(String r100) {
        configWithNaturalCrossJoin(this.cppObj, 6, 0, r100);
        return this;
    }

    public Join naturalInnerJoin(String r100) {
        configWithNaturalInnerJoin(this.cppObj, 6, 0, r100);
        return this;
    }

    public Join naturalJoin(String r100) {
        configWithNaturalJoin(this.cppObj, 6, 0, r100);
        return this;
    }

    public Join naturalLeftJoin(String r100) {
        configWithNaturalLeftJoin(this.cppObj, 6, 0, r100);
        return this;
    }

    public Join naturalLeftOuterJoin(String r100) {
        configWithNaturalLeftOuterJoin(this.cppObj, 6, 0, r100);
        return this;
    }

    public Join using(Column r100) {
        configUsingColumn(this.cppObj, Identifier.getCppType(r100), new long[]{CppObject.get(r100)}, null);
        return this;
    }

    public Join with(String r100) {
        configWith(this.cppObj, 6, 0, r100);
        return this;
    }

    public Join using(String r100) {
        configUsingColumn(this.cppObj, 6, null, new String[]{r100});
        return this;
    }

    public Join using(String... r100) {
        configUsingColumn(this.cppObj, 6, null, r100);
        return this;
    }
}
