package com.tencent.wcdb.winq;

import androidx.camera.video.AudioStats;
import com.tencent.wcdb.base.CppObject;
import com.tencent.wcdb.base.Value;
import com.tencent.wcdb.fts.BuiltinFTSAuxiliaryFunction;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes41.dex */
public abstract class ExpressionOperable extends Identifier implements ExpressionConvertible {

    /* JADX INFO: renamed from: com.tencent.wcdb.winq.ExpressionOperable$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$wcdb$winq$ColumnType = null;

        static {
            int[] r100 = new int[ColumnType.values().length];
            $SwitchMap$com$tencent$wcdb$winq$ColumnType = r100;
            r100[ColumnType.Integer.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            $SwitchMap$com$tencent$wcdb$winq$ColumnType[ColumnType.Float.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$tencent$wcdb$winq$ColumnType[ColumnType.Text.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    public static class BinaryOperatorType {
        static final int And = 18;
        static final int BitwiseAnd = 9;
        static final int BitwiseOr = 10;
        static final int Concatenate = 1;
        static final int Divide = 3;
        static final int Equal = 15;
        static final int GLOB = 21;
        static final int Greater = 13;
        static final int GreaterOrEqual = 14;
        static final int Is = 17;
        static final int LeftShift = 7;
        static final int Less = 11;
        static final int LessOrEqual = 12;
        static final int Like = 20;
        static final int Match = 23;
        static final int Minus = 6;
        static final int Modulo = 4;
        static final int Multiply = 2;
        static final int NotEqual = 16;
        static final int Or = 19;
        static final int Plus = 5;
        static final int RegExp = 22;
        static final int RightShift = 8;

        private BinaryOperatorType() {
        }
    }

    private static native long betweenOperate(int r100, long r101, int r102, long r103, double r104, String r105, int r106, long r110, double r111, String r112, boolean r113);

    private static native long binaryOperate(int r100, long r101, int r102, long r103, double r104, String r105, int r106, boolean r110);

    private static native long collate(int r100, long r101, String r102);

    private static native long in(int r100, long r101, int r102, long[] r103, double[] r104, String[] r105, boolean r106);

    private static native long inFunction(int r100, long r101, String r102, boolean r103);

    private static native long inSelect(int r100, long r101, long r102, boolean r103);

    private static native long inTable(int r100, long r101, String r102, boolean r103);

    private static native long nullOperate(int r100, long r101, boolean r102);

    public Expression isNull() {
        return nullOperate(false);
    }

    public Expression notNull() {
        return nullOperate(true);
    }

    public Expression abs() {
        return Expression.function("ABS").argument(this);
    }

    public Expression avg() {
        return Expression.function("AVG").argument(this);
    }

    public Expression bm25() {
        return Expression.function("bm25").argument(this);
    }

    public Expression count() {
        return Expression.function("COUNT").argument(this);
    }

    public Expression groupConcat() {
        return Expression.function("GROUP_CONCAT").argument(this);
    }

    public Expression hex() {
        return Expression.function("HEX").argument(this);
    }

    public Expression highlight() {
        return Expression.function("highlight").argument(this);
    }

    public Expression length() {
        return Expression.function("LENGTH").argument(this);
    }

    public Expression lower() {
        return Expression.function("LOWER").argument(this);
    }

    public Expression matchInfo() {
        return Expression.function("matchInfo").argument(this);
    }

    public Expression max() {
        return Expression.function("MAX").argument(this);
    }

    public Expression min() {
        return Expression.function("MIN").argument(this);
    }

    public Expression offsets() {
        return Expression.function("offsets").argument(this);
    }

    public Expression round() {
        return Expression.function("ROUND").argument(this);
    }

    public Expression snippet() {
        return Expression.function("snippet").argument(this);
    }

    public Expression substringMatchInfo() {
        return Expression.function(BuiltinFTSAuxiliaryFunction.SubstringMatchInfo).argument(this);
    }

    public Expression sum() {
        return Expression.function("SUM").argument(this);
    }

    public Expression total() {
        return Expression.function("TOTAL").argument(this);
    }

    public Expression upper() {
        return Expression.function("UPPER").argument(this);
    }

    public ExpressionOperable() {
    }

    public static Expression createExpression(long r100) {
        Expression r101 = new Expression();
        r101.cppObj = r100;
        return r101;
    }

    private Expression nullOperate(boolean r100) {
        Expression r101 = new Expression();
        r101.cppObj = nullOperate(Identifier.getCppType(this), CppObject.get(this), r100);
        return r101;
    }

    public Expression add(byte r100) {
        return binaryOperate(r100, 5, false);
    }

    public Expression and(ExpressionConvertible r100) {
        return binaryOperate(r100, 18, false);
    }

    public Expression bitAnd(byte r100) {
        return binaryOperate(r100, 9, false);
    }

    public Expression bitOr(byte r100) {
        return binaryOperate(r100, 10, false);
    }

    public Expression collate(String r100) {
        return createExpression(collate(Identifier.getCppType(this), CppObject.get(this), r100));
    }

    public Expression concat(byte r100) {
        return binaryOperate(r100, 1, false);
    }

    public Expression divide(byte r100) {
        return binaryOperate(r100, 3, false);
    }

    public Expression eq(byte r100) {
        return binaryOperate(r100, 15, false);
    }

    public Expression ge(byte r100) {
        return binaryOperate(r100, 14, false);
    }

    public Expression glob(String r100) {
        return binaryOperate(r100, 21, false);
    }

    public Expression groupConcat(String r100) {
        return Expression.function("GROUP_CONCAT").argument(this).argument(r100);
    }

    public Expression gt(byte r100) {
        return binaryOperate(r100, 13, false);
    }

    public Expression in(Float[] r100) {
        double[] r101 = new double[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        r101[r102] = r100[r102].floatValue();
        r102 = r102 + 1;
        goto L4
    L7:
        return in(r101, false);
    }

    public Expression inFunction(String r100) {
        return inFunction(r100, false);
    }

    public Expression inTable(String r100) {
        return inTable(r100, false);
    }

    public Expression is(byte r100) {
        return binaryOperate(r100, 17, false);
    }

    public Expression isNot(byte r100) {
        return binaryOperate(r100, 17, true);
    }

    public Expression le(byte r100) {
        return binaryOperate(r100, 12, false);
    }

    public Expression leftShift(byte r100) {
        return binaryOperate(r100, 7, false);
    }

    public Expression like(String r100) {
        return binaryOperate(r100, 20, false);
    }

    public Expression lt(byte r100) {
        return binaryOperate(r100, 11, false);
    }

    public Expression match(String r100) {
        return binaryOperate(r100, 23, false);
    }

    public Expression minus(byte r100) {
        return binaryOperate(r100, 6, false);
    }

    public Expression mod(byte r100) {
        return binaryOperate(r100, 4, false);
    }

    public Expression multiply(byte r100) {
        return binaryOperate(r100, 2, false);
    }

    public Expression notEq(byte r100) {
        return binaryOperate(r100, 16, false);
    }

    public Expression notGlob(String r100) {
        return binaryOperate(r100, 21, true);
    }

    public Expression notIn(Float[] r100) {
        double[] r101 = new double[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        r101[r102] = r100[r102].floatValue();
        r102 = r102 + 1;
        goto L4
    L7:
        return in(r101, true);
    }

    public Expression notInFunction(String r100) {
        return inFunction(r100, true);
    }

    public Expression notInTable(String r100) {
        return inTable(r100, true);
    }

    public Expression notLike(String r100) {
        return binaryOperate(r100, 20, true);
    }

    public Expression notMatch(String r100) {
        return binaryOperate(r100, 23, true);
    }

    public Expression notRegexp(String r100) {
        return binaryOperate(r100, 22, true);
    }

    public Expression or(ExpressionConvertible r100) {
        return binaryOperate(r100, 19, false);
    }

    public Expression regexp(String r100) {
        return binaryOperate(r100, 22, false);
    }

    public Expression rightShift(byte r100) {
        return binaryOperate(r100, 8, false);
    }

    public Expression add(float r100) {
        return binaryOperate(r100, 5, false);
    }

    public Expression bitAnd(int r100) {
        return binaryOperate(r100, 9, false);
    }

    public Expression bitOr(int r100) {
        return binaryOperate(r100, 10, false);
    }

    public Expression concat(float r100) {
        return binaryOperate(r100, 1, false);
    }

    public Expression divide(float r100) {
        return binaryOperate(r100, 3, false);
    }

    public Expression eq(float r100) {
        return binaryOperate(r100, 15, false);
    }

    public Expression ge(float r100) {
        return binaryOperate(r100, 14, false);
    }

    public Expression gt(float r100) {
        return binaryOperate(r100, 13, false);
    }

    public Expression in(Integer[] r100) {
        long[] r101 = new long[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        r101[r102] = r100[r102].intValue();
        r102 = r102 + 1;
        goto L4
    L7:
        return in(r101, false);
    }

    public Expression is(float r100) {
        return binaryOperate(r100, 17, false);
    }

    public Expression isNot(float r100) {
        return binaryOperate(r100, 17, true);
    }

    public Expression le(float r100) {
        return binaryOperate(r100, 12, false);
    }

    public Expression leftShift(int r100) {
        return binaryOperate(r100, 7, false);
    }

    public Expression lt(int r100) {
        return binaryOperate(r100, 11, false);
    }

    public Expression minus(float r100) {
        return binaryOperate(r100, 6, false);
    }

    public Expression mod(float r100) {
        return binaryOperate(r100, 4, false);
    }

    public Expression multiply(float r100) {
        return binaryOperate(r100, 2, false);
    }

    public Expression notEq(float r100) {
        return binaryOperate(r100, 16, false);
    }

    public Expression notIn(Integer[] r100) {
        long[] r101 = new long[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        r101[r102] = r100[r102].intValue();
        r102 = r102 + 1;
        goto L4
    L7:
        return in(r101, true);
    }

    public Expression rightShift(int r100) {
        return binaryOperate(r100, 8, false);
    }

    public Expression add(int r100) {
        return binaryOperate(r100, 5, false);
    }

    public Expression bitAnd(short r100) {
        return binaryOperate(r100, 9, false);
    }

    public Expression bitOr(short r100) {
        return binaryOperate(r100, 10, false);
    }

    public Expression concat(int r100) {
        return binaryOperate(r100, 1, false);
    }

    public Expression divide(int r100) {
        return binaryOperate(r100, 3, false);
    }

    public Expression eq(int r100) {
        return binaryOperate(r100, 15, false);
    }

    public Expression ge(int r100) {
        return binaryOperate(r100, 14, false);
    }

    public Expression gt(int r100) {
        return binaryOperate(r100, 13, false);
    }

    public Expression in(Short[] r100) {
        long[] r101 = new long[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        r101[r102] = r100[r102].shortValue();
        r102 = r102 + 1;
        goto L4
    L7:
        return in(r101, false);
    }

    public Expression is(int r100) {
        return binaryOperate(r100, 17, false);
    }

    public Expression isNot(int r100) {
        return binaryOperate(r100, 17, true);
    }

    public Expression le(int r100) {
        return binaryOperate(r100, 12, false);
    }

    public Expression leftShift(short r100) {
        return binaryOperate(r100, 7, false);
    }

    public Expression lt(short r100) {
        return binaryOperate(r100, 11, false);
    }

    public Expression minus(int r100) {
        return binaryOperate(r100, 6, false);
    }

    public Expression mod(int r100) {
        return binaryOperate(r100, 4, false);
    }

    public Expression multiply(int r100) {
        return binaryOperate(r100, 2, false);
    }

    public Expression notEq(int r100) {
        return binaryOperate(r100, 16, false);
    }

    public Expression notIn(Short[] r100) {
        long[] r101 = new long[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        r101[r102] = r100[r102].shortValue();
        r102 = r102 + 1;
        goto L4
    L7:
        return in(r101, true);
    }

    public Expression rightShift(short r100) {
        return binaryOperate(r100, 8, false);
    }

    public Expression add(short r100) {
        return binaryOperate(r100, 5, false);
    }

    public Expression bitAnd(long r100) {
        return binaryOperate(r100, 9, false);
    }

    public Expression bitOr(long r100) {
        return binaryOperate(r100, 10, false);
    }

    public Expression concat(short r100) {
        return binaryOperate(r100, 1, false);
    }

    public Expression divide(short r100) {
        return binaryOperate(r100, 3, false);
    }

    public Expression eq(short r100) {
        return binaryOperate(r100, 15, false);
    }

    public Expression ge(short r100) {
        return binaryOperate(r100, 14, false);
    }

    public Expression gt(short r100) {
        return binaryOperate(r100, 13, false);
    }

    public Expression in(float... r100) {
        double[] r101 = new double[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        r101[r102] = r100[r102];
        r102 = r102 + 1;
        goto L4
    L7:
        return in(r101, false);
    }

    public Expression is(short r100) {
        return binaryOperate(r100, 17, false);
    }

    public Expression isNot(short r100) {
        return binaryOperate(r100, 17, true);
    }

    public Expression le(short r100) {
        return binaryOperate(r100, 12, false);
    }

    public Expression leftShift(long r100) {
        return binaryOperate(r100, 7, false);
    }

    public Expression lt(double r100) {
        return binaryOperate(r100, 11, false);
    }

    public Expression minus(short r100) {
        return binaryOperate(r100, 6, false);
    }

    public Expression mod(short r100) {
        return binaryOperate(r100, 4, false);
    }

    public Expression multiply(short r100) {
        return binaryOperate(r100, 2, false);
    }

    public Expression notEq(short r100) {
        return binaryOperate(r100, 16, false);
    }

    public Expression notIn(float... r100) {
        double[] r101 = new double[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        r101[r102] = r100[r102];
        r102 = r102 + 1;
        goto L4
    L7:
        return in(r101, true);
    }

    public Expression rightShift(long r100) {
        return binaryOperate(r100, 8, false);
    }

    public Expression add(double r100) {
        return binaryOperate(r100, 5, false);
    }

    public Expression bitAnd(ExpressionConvertible r100) {
        return binaryOperate(r100, 9, false);
    }

    public Expression bitOr(ExpressionConvertible r100) {
        return binaryOperate(r100, 10, false);
    }

    public Expression concat(double r100) {
        return binaryOperate(r100, 1, false);
    }

    public Expression divide(double r100) {
        return binaryOperate(r100, 3, false);
    }

    public Expression eq(double r100) {
        return binaryOperate(r100, 15, false);
    }

    public Expression ge(double r100) {
        return binaryOperate(r100, 14, false);
    }

    public Expression gt(double r100) {
        return binaryOperate(r100, 13, false);
    }

    public Expression in(int... r100) {
        long[] r101 = new long[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        r101[r102] = r100[r102];
        r102 = r102 + 1;
        goto L4
    L7:
        return in(r101, false);
    }

    public Expression is(double r100) {
        return binaryOperate(r100, 17, false);
    }

    public Expression isNot(double r100) {
        return binaryOperate(r100, 17, true);
    }

    public Expression le(double r100) {
        return binaryOperate(r100, 12, false);
    }

    public Expression leftShift(ExpressionConvertible r100) {
        return binaryOperate(r100, 7, false);
    }

    public Expression lt(long r100) {
        return binaryOperate(r100, 11, false);
    }

    public Expression minus(double r100) {
        return binaryOperate(r100, 6, false);
    }

    public Expression mod(double r100) {
        return binaryOperate(r100, 4, false);
    }

    public Expression multiply(double r100) {
        return binaryOperate(r100, 2, false);
    }

    public Expression notEq(double r100) {
        return binaryOperate(r100, 16, false);
    }

    public Expression notIn(int... r100) {
        long[] r101 = new long[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        r101[r102] = r100[r102];
        r102 = r102 + 1;
        goto L4
    L7:
        return in(r101, true);
    }

    public Expression rightShift(ExpressionConvertible r100) {
        return binaryOperate(r100, 8, false);
    }

    public Expression add(long r100) {
        return binaryOperate(r100, 5, false);
    }

    public Expression concat(long r100) {
        return binaryOperate(r100, 1, false);
    }

    public Expression divide(long r100) {
        return binaryOperate(r100, 3, false);
    }

    public Expression eq(long r100) {
        return binaryOperate(r100, 15, false);
    }

    public Expression ge(long r100) {
        return binaryOperate(r100, 14, false);
    }

    public Expression gt(long r100) {
        return binaryOperate(r100, 13, false);
    }

    public Expression in(short... r100) {
        long[] r101 = new long[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        r101[r102] = r100[r102];
        r102 = r102 + 1;
        goto L4
    L7:
        return in(r101, false);
    }

    public Expression is(long r100) {
        return binaryOperate(r100, 17, false);
    }

    public Expression isNot(long r100) {
        return binaryOperate(r100, 17, true);
    }

    public Expression le(long r100) {
        return binaryOperate(r100, 12, false);
    }

    public Expression lt(ExpressionConvertible r100) {
        return binaryOperate(r100, 11, false);
    }

    public Expression minus(long r100) {
        return binaryOperate(r100, 6, false);
    }

    public Expression mod(long r100) {
        return binaryOperate(r100, 4, false);
    }

    public Expression multiply(long r100) {
        return binaryOperate(r100, 2, false);
    }

    public Expression notEq(long r100) {
        return binaryOperate(r100, 16, false);
    }

    public Expression notIn(short... r100) {
        long[] r101 = new long[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L7;
        r101[r102] = r100[r102];
        r102 = r102 + 1;
        goto L4
    L7:
        return in(r101, true);
    }

    public Expression add(ExpressionConvertible r100) {
        return binaryOperate(r100, 5, false);
    }

    public Expression concat(ExpressionConvertible r100) {
        return binaryOperate(r100, 1, false);
    }

    public Expression divide(ExpressionConvertible r100) {
        return binaryOperate(r100, 3, false);
    }

    public Expression eq(ExpressionConvertible r100) {
        return binaryOperate(r100, 15, false);
    }

    public Expression ge(ExpressionConvertible r100) {
        return binaryOperate(r100, 14, false);
    }

    public Expression gt(ExpressionConvertible r100) {
        return binaryOperate(r100, 13, false);
    }

    public <T> Expression in(List<T> r100) {
        return in(r100.toArray(), false);
    }

    public Expression is(ExpressionConvertible r100) {
        return binaryOperate(r100, 17, false);
    }

    public Expression isNot(ExpressionConvertible r100) {
        return binaryOperate(r100, 17, true);
    }

    public Expression le(ExpressionConvertible r100) {
        return binaryOperate(r100, 12, false);
    }

    public Expression lt(String r100) {
        return binaryOperate(r100, 11, false);
    }

    public Expression minus(ExpressionConvertible r100) {
        return binaryOperate(r100, 6, false);
    }

    public Expression mod(ExpressionConvertible r100) {
        return binaryOperate(r100, 4, false);
    }

    public Expression multiply(ExpressionConvertible r100) {
        return binaryOperate(r100, 2, false);
    }

    public Expression notEq(ExpressionConvertible r100) {
        return binaryOperate(r100, 16, false);
    }

    public <T> Expression notIn(List<T> r100) {
        return in(r100.toArray(), true);
    }

    public Expression concat(String r100) {
        return binaryOperate(r100, 1, false);
    }

    public Expression eq(String r100) {
        return binaryOperate(r100, 15, false);
    }

    public Expression ge(String r100) {
        return binaryOperate(r100, 14, false);
    }

    public Expression gt(String r100) {
        return binaryOperate(r100, 13, false);
    }

    public <T> Expression in(Set<T> r100) {
        return in(r100.toArray(), false);
    }

    public Expression is(String r100) {
        return binaryOperate(r100, 17, false);
    }

    public Expression isNot(String r100) {
        return binaryOperate(r100, 17, true);
    }

    public Expression le(String r100) {
        return binaryOperate(r100, 12, false);
    }

    public Expression notEq(String r100) {
        return binaryOperate(r100, 16, false);
    }

    public <T> Expression notIn(Set<T> r100) {
        return in(r100.toArray(), true);
    }

    public Expression eq(boolean r100) {
        return binaryOperate(r100, 15, false);
    }

    public Expression in(StatementSelect r100) {
        return in(r100, false);
    }

    public Expression is(boolean r100) {
        return binaryOperate(r100, 17, false);
    }

    public Expression isNot(boolean r100) {
        return binaryOperate(r100, 17, true);
    }

    public Expression notEq(boolean r100) {
        return binaryOperate(r100, 16, false);
    }

    public Expression notIn(StatementSelect r100) {
        return in(r100, true);
    }

    public Expression in(double... r100) {
        return in(r100, false);
    }

    public Expression notIn(double... r100) {
        return in(r100, true);
    }

    public Expression in(long... r100) {
        return in(r100, false);
    }

    public Expression notIn(long... r100) {
        return in(r100, true);
    }

    public Expression in(Value... r100) {
        return in(r100, false);
    }

    public Expression notIn(Value... r100) {
        return in(r100, true);
    }

    public Expression in(Double[] r100) {
        return in(r100, false);
    }

    public Expression notIn(Double[] r100) {
        return in(r100, true);
    }

    public Expression in(Long[] r100) {
        return in(r100, false);
    }

    public Expression notIn(Long[] r100) {
        return in(r100, true);
    }

    public Expression in(String... r100) {
        return in(r100, false);
    }

    public Expression notIn(String... r100) {
        return in(r100, true);
    }

    private Expression in(Object[] r100, boolean r110) {
        if (r100 == null) goto L102;
        if (r100.length == 0) goto L102;
        int r101 = 0;
        int r102 = MultiTypeArray.getObjectType(r100[0]);
        if (r102 != 10) goto L16;
        long[] r103 = new long[r100.length];
        int r104 = 0;
    L11:
        if (r104 >= r100.length) goto L14;
        r103[r104] = CppObject.get((Identifier) r100[r104]);
        r104 = r104 + 1;
        goto L11
    L14:
        return in(Identifier.getCppType((Identifier) r100[0]), r103, r110);
    L16:
        if (r102 != 11) goto L50;
        int r105 = AnonymousClass1.$SwitchMap$com$tencent$wcdb$winq$ColumnType[((Value) r100[0]).getType().ordinal()];
        if (r105 == 1) goto L43;
        if (r105 != 2) goto L21;
        double[] r106 = new double[r100.length];
    L39:
        if (r101 >= r100.length) goto L42;
        r106[r101] = ((Value) r100[r101]).getDouble();
        r101 = r101 + 1;
        goto L39
    L42:
        return in(r106, r110);
    L21:
        if (r105 != 3) goto L23;
        String[] r107 = new String[r100.length];
    L33:
        if (r101 >= r100.length) goto L36;
        r107[r101] = ((Value) r100[r101]).getText();
        r101 = r101 + 1;
        goto L33
    L36:
        return in(r107, r110);
    L23:
        if ((r100 instanceof String[]) == true) goto L25;
        int r108 = r100.length;
        String[] r109 = new String[r108];
    L27:
        if (r101 >= r108) goto L30;
        r109[r101] = (String) r100[r101];
        r101 = r101 + 1;
        goto L27
    L30:
        return in(r109, r110);
    L25:
        return in((String[]) r100, r110);
    L43:
        long[] r111 = new long[r100.length];
    L45:
        if (r101 >= r100.length) goto L48;
        r111[r101] = ((Value) r100[r101]).getLong();
        r101 = r101 + 1;
        goto L45
    L48:
        return in(r111, r110);
    L50:
        if (r102 != 9) goto L61;
        if ((r100 instanceof String[]) == true) goto L54;
        int r112 = r100.length;
        String[] r113 = new String[r112];
    L56:
        if (r101 >= r112) goto L59;
        r113[r101] = (String) r100[r101];
        r101 = r101 + 1;
        goto L56
    L59:
        return in(r113, r110);
    L54:
        return in((String[]) r100, r110);
    L61:
        if (r102 >= 7) goto L89;
        long[] r114 = new long[r100.length];
    L64:
        if (r101 >= r100.length) goto L87;
        long r115 = 0;
        if (r102 == 0) goto L84;
        if (r102 == 1) goto L81;
        if (r102 != 2) goto L70;
        r114[r101] = ((Character) r100[r101]).charValue();
    L85:
        r101 = r101 + 1;
        goto L64
    L70:
        if (r102 != 4) goto L72;
        r114[r101] = ((Short) r100[r101]).shortValue();
        goto L85
    L72:
        if (r102 != 5) goto L74;
        r114[r101] = ((Integer) r100[r101]).intValue();
        goto L85
    L74:
        if (r102 != 6) goto L85;
        r114[r101] = ((Long) r100[r101]).longValue();
        goto L85
    L81:
        if (((Boolean) r100[r101]).booleanValue() == false) goto L83;
        r115 = 1;
    L83:
        r114[r101] = r115;
        goto L85
    L84:
        r114[r101] = 0;
        goto L85
    L87:
        return in(r114, r110);
    L89:
        if (r102 == 12) goto L100;
        double[] r116 = new double[r100.length];
    L92:
        if (r101 >= r100.length) goto L98;
        if (r102 != 7) goto L95;
        r116[r101] = ((Float) r100[r101]).floatValue();
    L96:
        r101 = r101 + 1;
        goto L92
    L95:
        r116[r101] = ((Double) r100[r101]).doubleValue();
        goto L96
    L98:
        return in(r116, r110);
    L100:
        return in(null);
    L102:
        return in(null, r110);
    }

    private Expression inFunction(String r100, boolean r101) {
        return createExpression(inFunction(Identifier.getCppType(this), CppObject.get(this), r100, r101));
    }

    private Expression inTable(String r100, boolean r101) {
        return createExpression(inTable(Identifier.getCppType(this), CppObject.get(this), r100, r101));
    }

    public Expression between(ExpressionConvertible r110, ExpressionConvertible r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), Identifier.getCppType(r110), CppObject.get(r110), AudioStats.AUDIO_AMPLITUDE_NONE, null, Identifier.getCppType(r111), CppObject.get(r111), AudioStats.AUDIO_AMPLITUDE_NONE, null, false));
    }

    public Expression notBetween(ExpressionConvertible r110, ExpressionConvertible r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), Identifier.getCppType(r110), CppObject.get(r110), AudioStats.AUDIO_AMPLITUDE_NONE, null, Identifier.getCppType(r111), CppObject.get(r111), AudioStats.AUDIO_AMPLITUDE_NONE, null, true));
    }

    public Expression substr(int r100, int r101) {
        return Expression.function("SUBSTR").argument(this).argument(r100).argument(r101);
    }

    private Expression in(StatementSelect r100, boolean r101) {
        return createExpression(inSelect(Identifier.getCppType(this), CppObject.get(this), CppObject.get(r100), r101));
    }

    public Expression between(ExpressionConvertible r110, String r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), Identifier.getCppType(r110), CppObject.get(r110), AudioStats.AUDIO_AMPLITUDE_NONE, null, 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r111, false));
    }

    public Expression notBetween(ExpressionConvertible r110, String r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), Identifier.getCppType(r110), CppObject.get(r110), AudioStats.AUDIO_AMPLITUDE_NONE, null, 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r111, true));
    }

    public Expression substr(long r100, long r101) {
        return Expression.function("SUBSTR").argument(this).argument(r100).argument(r101);
    }

    private Expression in(double[] r100, boolean r110) {
        return createExpression(in(Identifier.getCppType(this), CppObject.get(this), 5, null, r100, null, r110));
    }

    public Expression between(String r110, ExpressionConvertible r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r110, Identifier.getCppType(r111), CppObject.get(r111), AudioStats.AUDIO_AMPLITUDE_NONE, null, false));
    }

    public Expression notBetween(String r110, ExpressionConvertible r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r110, Identifier.getCppType(r111), CppObject.get(r111), AudioStats.AUDIO_AMPLITUDE_NONE, null, true));
    }

    public Expression substr(short r100, short r101) {
        return Expression.function("SUBSTR").argument(this).argument(r100).argument(r101);
    }

    private Expression in(long[] r100, boolean r110) {
        return createExpression(in(Identifier.getCppType(this), CppObject.get(this), 3, r100, null, null, r110));
    }

    public Expression between(double r110, ExpressionConvertible r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), 5, 0, r110, null, Identifier.getCppType(r111), CppObject.get(r111), AudioStats.AUDIO_AMPLITUDE_NONE, null, false));
    }

    public Expression notBetween(double r110, ExpressionConvertible r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), 5, 0, r110, null, Identifier.getCppType(r111), CppObject.get(r111), AudioStats.AUDIO_AMPLITUDE_NONE, null, true));
    }

    private Expression in(String[] r100, boolean r110) {
        return createExpression(in(Identifier.getCppType(this), CppObject.get(this), 6, null, null, r100, r110));
    }

    public Expression between(long r110, ExpressionConvertible r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), 3, r110, AudioStats.AUDIO_AMPLITUDE_NONE, null, Identifier.getCppType(r111), CppObject.get(r111), AudioStats.AUDIO_AMPLITUDE_NONE, null, false));
    }

    public Expression notBetween(long r110, ExpressionConvertible r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), 3, r110, AudioStats.AUDIO_AMPLITUDE_NONE, null, Identifier.getCppType(r111), CppObject.get(r111), AudioStats.AUDIO_AMPLITUDE_NONE, null, true));
    }

    public Expression between(ExpressionConvertible r110, double r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), Identifier.getCppType(r110), CppObject.get(r110), AudioStats.AUDIO_AMPLITUDE_NONE, null, 5, 0, r111, null, false));
    }

    public Expression notBetween(ExpressionConvertible r110, double r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), Identifier.getCppType(r110), CppObject.get(r110), AudioStats.AUDIO_AMPLITUDE_NONE, null, 5, 0, r111, null, true));
    }

    public Expression between(ExpressionConvertible r110, long r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), Identifier.getCppType(r110), CppObject.get(r110), AudioStats.AUDIO_AMPLITUDE_NONE, null, 3, r111, AudioStats.AUDIO_AMPLITUDE_NONE, null, false));
    }

    public Expression notBetween(ExpressionConvertible r110, long r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), Identifier.getCppType(r110), CppObject.get(r110), AudioStats.AUDIO_AMPLITUDE_NONE, null, 3, r111, AudioStats.AUDIO_AMPLITUDE_NONE, null, true));
    }

    public Expression between(String r110, String r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r110, 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r111, false));
    }

    public Expression notBetween(String r110, String r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r110, 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r111, true));
    }

    public Expression between(double r110, String r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), 5, 0, r110, null, 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r111, false));
    }

    public Expression notBetween(double r110, String r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), 5, 0, r110, null, 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r111, true));
    }

    public Expression between(long r110, String r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), 3, r110, AudioStats.AUDIO_AMPLITUDE_NONE, null, 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r111, false));
    }

    public Expression notBetween(long r110, String r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), 3, r110, AudioStats.AUDIO_AMPLITUDE_NONE, null, 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r111, true));
    }

    public Expression between(String r110, double r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r110, 5, 0, r111, null, false));
    }

    public Expression notBetween(String r110, double r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r110, 5, 0, r111, null, true));
    }

    public Expression between(String r110, long r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r110, 3, r111, AudioStats.AUDIO_AMPLITUDE_NONE, null, false));
    }

    public Expression notBetween(String r110, long r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r110, 3, r111, AudioStats.AUDIO_AMPLITUDE_NONE, null, true));
    }

    public Expression between(double r110, double r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), 5, 0, r110, null, 5, 0, r111, null, false));
    }

    public Expression notBetween(double r110, double r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), 5, 0, r110, null, 5, 0, r111, null, true));
    }

    public Expression between(double r110, long r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), 5, 0, r110, null, 3, r111, AudioStats.AUDIO_AMPLITUDE_NONE, null, false));
    }

    public Expression notBetween(double r110, long r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), 5, 0, r110, null, 3, r111, AudioStats.AUDIO_AMPLITUDE_NONE, null, true));
    }

    public Expression between(long r110, double r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), 3, r110, AudioStats.AUDIO_AMPLITUDE_NONE, null, 5, 0, r111, null, false));
    }

    public Expression notBetween(long r110, double r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), 3, r110, AudioStats.AUDIO_AMPLITUDE_NONE, null, 5, 0, r111, null, true));
    }

    public Expression between(long r110, long r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), 3, r110, AudioStats.AUDIO_AMPLITUDE_NONE, null, 3, r111, AudioStats.AUDIO_AMPLITUDE_NONE, null, false));
    }

    public Expression notBetween(long r110, long r111) {
        return createExpression(betweenOperate(Identifier.getCppType(this), CppObject.get(this), 3, r110, AudioStats.AUDIO_AMPLITUDE_NONE, null, 3, r111, AudioStats.AUDIO_AMPLITUDE_NONE, null, true));
    }

    private Expression binaryOperate(ExpressionConvertible r110, int r111, boolean r112) {
        return createExpression(binaryOperate(Identifier.getCppType(this), CppObject.get(this), Identifier.getCppType(r110), CppObject.get(r110), AudioStats.AUDIO_AMPLITUDE_NONE, null, r111, r112));
    }

    private Expression in(int r100, long[] r110, boolean r111) {
        return createExpression(in(Identifier.getCppType(this), CppObject.get(this), r100, r110, null, null, r111));
    }

    private Expression binaryOperate(boolean r110, int r111, boolean r112) {
        int r100 = Identifier.getCppType(this);
        long r101 = CppObject.get(this);
        if (r110 == false) goto L5;
        long r102 = 1;
    L7:
        return createExpression(binaryOperate(r100, r101, 2, r102, AudioStats.AUDIO_AMPLITUDE_NONE, null, r111, r112));
    L5:
        r102 = 0;
        goto L7
    }

    private Expression binaryOperate(String r110, int r111, boolean r112) {
        return createExpression(binaryOperate(Identifier.getCppType(this), CppObject.get(this), 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r110, r111, r112));
    }

    private Expression binaryOperate(double r110, int r111, boolean r112) {
        return createExpression(binaryOperate(Identifier.getCppType(this), CppObject.get(this), 5, 0, r110, null, r111, r112));
    }

    private Expression binaryOperate(long r110, int r111, boolean r112) {
        return createExpression(binaryOperate(Identifier.getCppType(this), CppObject.get(this), 3, r110, AudioStats.AUDIO_AMPLITUDE_NONE, null, r111, r112));
    }
}
