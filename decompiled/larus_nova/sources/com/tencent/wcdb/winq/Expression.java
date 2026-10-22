package com.tencent.wcdb.winq;

import androidx.camera.video.AudioStats;
import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class Expression extends ExpressionOperable implements IndexedColumnConvertible, ResultColumnConvertible {
    private static native void argument(long r100, int r101, long r102, double r103, String r104);

    private static native long as(long r100, String r101);

    private static native void as(long r100, int r101);

    private static native long caseWithExp(int r100, long r101, String r102);

    private static native long cast(int r100, long r101, String r102);

    private static native long createCppObj(int r100, long r101);

    private static native long createWithExistStatement(long r100);

    private static native long createWithFunction(String r100);

    private static native long createWithNotExistStatement(long r100);

    private static native long createWithWindowFunction(String r100);

    private static native void distinct(long r100);

    private static native void escape(long r100, String r101);

    private static native void filter(long r100, long r101);

    private static native void invoke(long r100);

    private static native void invokeAll(long r100);

    private static native void overWindow(long r100, String r101);

    private static native void overWindowDef(long r100, long r101);

    private static native void schema(long r100, int r101, long r102, String r103);

    private static native void setWithElseExp(long r100, int r101, long r102, double r103, String r104);

    private static native void setWithThenExp(long r100, int r101, long r102, double r103, String r104);

    private static native void setWithWhenExp(long r100, int r101, long r102, double r103, String r104);

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 11;
    }

    public static Expression case_() {
        Expression r100 = new Expression();
        r100.cppObj = caseWithExp(0, 0, null);
        return r100;
    }

    public Expression distinct() {
        distinct(this.cppObj);
        return this;
    }

    public Expression invoke() {
        invoke(this.cppObj);
        return this;
    }

    public Expression invokeAll() {
        invokeAll(this.cppObj);
        return this;
    }

    public Expression() {
    }

    public Expression(BindParameter r100) {
        this.cppObj = createCppObj(Identifier.getCppType(r100), CppObject.get(r100));
    }

    public static Expression case_(String r100) {
        if (r100 == null) goto L4;
        Expression r101 = new Expression();
        r101.cppObj = caseWithExp(6, 0, r100);
        return r101;
    L4:
        return case_();
    }

    public static Expression cast(ExpressionConvertible r100) {
        Expression r101 = new Expression();
        r101.cppObj = cast(Identifier.getCppType(r100), CppObject.get(r100), null);
        return r101;
    }

    public static Expression exists(StatementSelect r100) {
        Expression r101 = new Expression();
        r101.cppObj = createWithExistStatement(CppObject.get(r100));
        return r101;
    }

    public static Expression function(String r100) {
        return ExpressionOperable.createExpression(createWithFunction(r100));
    }

    public static Expression notExists(StatementSelect r100) {
        Expression r101 = new Expression();
        r101.cppObj = createWithNotExistStatement(CppObject.get(r100));
        return r101;
    }

    public static Expression windowFunction(String r100) {
        Expression r101 = new Expression();
        r101.cppObj = createWithWindowFunction(r100);
        return r101;
    }

    public Expression argument(String r110) {
        if (r110 == null) goto L5;
        argument(this.cppObj, 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r110);
    L6:
        return this;
    L5:
        argument(this.cppObj, 1, 0, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        goto L6
    }

    public ResultColumn as(String r100) {
        return new ResultColumn(as(this.cppObj, r100));
    }

    public Expression else_(String r110) {
        if (r110 == null) goto L5;
        setWithElseExp(this.cppObj, 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r110);
    L6:
        return this;
    L5:
        setWithElseExp(this.cppObj, 1, 0, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        goto L6
    }

    public Expression escape(String r100) {
        escape(this.cppObj, r100);
        return this;
    }

    public Expression filter(Expression r100) {
        filter(this.cppObj, r100.cppObj);
        return this;
    }

    public Expression over(WindowDef r100) {
        overWindowDef(this.cppObj, CppObject.get(r100));
        return this;
    }

    public Expression schema(Schema r100) {
        schema(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public Expression then(String r110) {
        if (r110 == null) goto L5;
        setWithThenExp(this.cppObj, 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r110);
    L6:
        return this;
    L5:
        setWithThenExp(this.cppObj, 1, 0, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        goto L6
    }

    public Expression when(String r110) {
        if (r110 == null) goto L5;
        setWithWhenExp(this.cppObj, 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r110);
    L6:
        return this;
    L5:
        setWithWhenExp(this.cppObj, 1, 0, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        goto L6
    }

    public Expression(Column r100) {
        this.cppObj = createCppObj(Identifier.getCppType(r100), CppObject.get(r100));
    }

    public static Expression case_(ExpressionConvertible r100) {
        Expression r101 = new Expression();
        r101.cppObj = caseWithExp(Identifier.getCppType(r100), CppObject.get(r100), null);
        return r101;
    }

    public static Expression cast(String r100) {
        Expression r101 = new Expression();
        r101.cppObj = cast(6, 0, r100);
        return r101;
    }

    public Expression argument(ExpressionConvertible r100) {
        argument(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public Expression as(ColumnType r100) {
        as(this.cppObj, r100.ordinal());
        return this;
    }

    public Expression else_(ExpressionConvertible r100) {
        setWithElseExp(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public Expression over(String r100) {
        overWindow(this.cppObj, r100);
        return this;
    }

    public Expression schema(String r100) {
        schema(this.cppObj, 6, 0, r100);
        return this;
    }

    public Expression then(ExpressionConvertible r100) {
        setWithThenExp(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public Expression when(ExpressionConvertible r100) {
        setWithWhenExp(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public Expression(LiteralValue r100) {
        this.cppObj = createCppObj(Identifier.getCppType(r100), CppObject.get(r100));
    }

    public Expression argument(boolean r100) {
        long r101 = this.cppObj;
        if (r100 == false) goto L5;
        long r102 = 1;
    L6:
        argument(r101, 2, r102, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    L5:
        r102 = 0;
        goto L6
    }

    public Expression else_(boolean r100) {
        long r101 = this.cppObj;
        if (r100 == false) goto L5;
        long r102 = 1;
    L6:
        setWithElseExp(r101, 2, r102, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    L5:
        r102 = 0;
        goto L6
    }

    public Expression then(boolean r100) {
        long r101 = this.cppObj;
        if (r100 == false) goto L5;
        long r102 = 1;
    L6:
        setWithThenExp(r101, 2, r102, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    L5:
        r102 = 0;
        goto L6
    }

    public Expression when(boolean r100) {
        long r101 = this.cppObj;
        if (r100 == false) goto L5;
        long r102 = 1;
    L6:
        setWithWhenExp(r101, 2, r102, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    L5:
        r102 = 0;
        goto L6
    }

    public Expression(StatementSelect r100) {
        this.cppObj = createCppObj(Identifier.getCppType(r100), CppObject.get(r100));
    }

    public Expression argument(byte r100) {
        argument(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public Expression else_(byte r100) {
        setWithElseExp(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public Expression then(byte r100) {
        setWithThenExp(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public Expression when(byte r100) {
        setWithWhenExp(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public Expression argument(double r100) {
        argument(this.cppObj, 5, 0, r100, null);
        return this;
    }

    public Expression else_(double r100) {
        setWithElseExp(this.cppObj, 5, 0, r100, null);
        return this;
    }

    public Expression then(double r100) {
        setWithThenExp(this.cppObj, 5, 0, r100, null);
        return this;
    }

    public Expression when(double r100) {
        setWithWhenExp(this.cppObj, 5, 0, r100, null);
        return this;
    }

    public Expression argument(float r100) {
        argument(this.cppObj, 5, 0, r100, null);
        return this;
    }

    public Expression else_(float r100) {
        setWithElseExp(this.cppObj, 5, 0, r100, null);
        return this;
    }

    public Expression then(float r100) {
        setWithThenExp(this.cppObj, 5, 0, r100, null);
        return this;
    }

    public Expression when(float r100) {
        setWithWhenExp(this.cppObj, 5, 0, r100, null);
        return this;
    }

    public Expression argument(int r100) {
        argument(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public Expression else_(int r100) {
        setWithElseExp(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public Expression then(int r100) {
        setWithThenExp(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public Expression when(int r100) {
        setWithWhenExp(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public Expression argument(long r100) {
        argument(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public Expression else_(long r100) {
        setWithElseExp(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public Expression then(long r100) {
        setWithThenExp(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public Expression when(long r100) {
        setWithWhenExp(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public Expression argument(short r100) {
        argument(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public Expression else_(short r100) {
        setWithElseExp(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public Expression then(short r100) {
        setWithThenExp(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public Expression when(short r100) {
        setWithWhenExp(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }
}
