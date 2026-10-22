package com.tencent.wcdb.winq;

import androidx.camera.video.AudioStats;
import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class StatementUpdate extends Statement {
    private static native void configColumns(long r100, int r101, long[] r102, String[] r103);

    private static native void configColumnsToBindParameters(long r100, int r101, long[] r102, String[] r103);

    private static native void configColumnsToValues(long r100, int r101, long[] r102, String[] r103, int[] r104, long[] r105, double[] r106, String[] r107);

    private static native void configCondition(long r100, long r101);

    private static native void configConflictAction(long r100, int r101);

    private static native void configLimitCount(long r100, int r101, long r102);

    private static native void configLimitRange(long r100, int r101, long r102, int r103, long r104);

    private static native void configOffset(long r100, int r101, long r102);

    private static native void configOrders(long r100, long[] r101);

    private static native void configRecursive(long r100);

    private static native void configTable(long r100, int r101, long r102, String r103);

    private static native void configToValue(long r100, int r101, long r102, double r103, String r104);

    private static native void configWith(long r100, long[] r101);

    private static native long createCppObj();

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 45;
    }

    public StatementUpdate orAbort() {
        configConflictAction(this.cppObj, ConflictAction.Abort.ordinal());
        return this;
    }

    public StatementUpdate orFail() {
        configConflictAction(this.cppObj, ConflictAction.Fail.ordinal());
        return this;
    }

    public StatementUpdate orIgnore() {
        configConflictAction(this.cppObj, ConflictAction.Ignore.ordinal());
        return this;
    }

    public StatementUpdate orReplace() {
        configConflictAction(this.cppObj, ConflictAction.Replace.ordinal());
        return this;
    }

    public StatementUpdate orRollback() {
        configConflictAction(this.cppObj, ConflictAction.Rollback.ordinal());
        return this;
    }

    public StatementUpdate() {
        this.cppObj = createCppObj();
    }

    public StatementUpdate limit(ExpressionConvertible r100) {
        configLimitCount(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100));
        return this;
    }

    public StatementUpdate offset(ExpressionConvertible r100) {
        configOffset(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100));
        return this;
    }

    public StatementUpdate orderBy(OrderingTerm... r100) {
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

    public StatementUpdate set(Column... r100) {
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

    public StatementUpdate setColumnsToBindParameters(Column... r100) {
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
        configColumnsToBindParameters(this.cppObj, 7, r101, null);
        return this;
    }

    public StatementUpdate to(String r110) {
        if (r110 == null) goto L5;
        configToValue(this.cppObj, 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r110);
    L6:
        return this;
    L5:
        configToValue(this.cppObj, 1, 0, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        goto L6
    }

    public StatementUpdate update(QualifiedTable r100) {
        configTable(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public StatementUpdate where(Expression r100) {
        configCondition(this.cppObj, CppObject.get(r100));
        return this;
    }

    public StatementUpdate with(CommonTableExpression... r100) {
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

    public StatementUpdate withRecursive(CommonTableExpression... r100) {
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

    public StatementUpdate limit(long r100) {
        configLimitCount(this.cppObj, 3, r100);
        return this;
    }

    public StatementUpdate offset(long r100) {
        configOffset(this.cppObj, 3, r100);
        return this;
    }

    public StatementUpdate set(String... r100) {
        if (r100.length != 0) goto L5;
        return this;
    L5:
        configColumns(this.cppObj, 6, null, r100);
        return this;
    }

    public StatementUpdate setColumnsToBindParameters(String... r100) {
        if (r100.length != 0) goto L5;
        return this;
    L5:
        configColumnsToBindParameters(this.cppObj, 6, null, r100);
        return this;
    }

    public StatementUpdate to(ExpressionConvertible r100) {
        configToValue(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public StatementUpdate update(String r100) {
        configTable(this.cppObj, 6, 0, r100);
        return this;
    }

    public StatementUpdate to(boolean r100) {
        long r101 = this.cppObj;
        if (r100 == false) goto L5;
        long r102 = 1;
    L6:
        configToValue(r101, 2, r102, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    L5:
        r102 = 0;
        goto L6
    }

    public StatementUpdate to(byte r100) {
        configToValue(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public StatementUpdate to(double r100) {
        configToValue(this.cppObj, 5, 0, r100, null);
        return this;
    }

    public StatementUpdate to(float r100) {
        configToValue(this.cppObj, 5, 0, r100, null);
        return this;
    }

    public StatementUpdate to(int r100) {
        configToValue(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public StatementUpdate to(long r100) {
        configToValue(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public StatementUpdate to(short r100) {
        configToValue(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public StatementUpdate limit(ExpressionConvertible r100, ExpressionConvertible r110) {
        configLimitRange(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), Identifier.getCppType(r110), CppObject.get(r110));
        return this;
    }

    public StatementUpdate setColumnsToValues(Column[] r110, Object[] r111) {
        if (r110.length != 0) goto L5;
    L12:
        return this;
    L5:
        if (r111.length == 0) goto L12;
        long[] r100 = new long[r110.length];
        int r101 = 0;
    L9:
        if (r101 >= r110.length) goto L11;
        r100[r101] = CppObject.get(r110[r101]);
        r101 = r101 + 1;
        goto L9
    L11:
        MultiTypeArray r112 = new MultiTypeArray(r111);
        configColumnsToValues(this.cppObj, 7, r100, null, r112.types, r112.longValues, r112.doubleValues, r112.stringValues);
        goto L12
    }

    public StatementUpdate limit(long r100, ExpressionConvertible r110) {
        configLimitRange(this.cppObj, 3, r100, Identifier.getCppType(r110), CppObject.get(r110));
        return this;
    }

    public StatementUpdate setColumnsToValues(String[] r110, Object[] r111) {
        if (r110.length != 0) goto L5;
    L8:
        return this;
    L5:
        if (r111.length == 0) goto L8;
        MultiTypeArray r100 = new MultiTypeArray(r111);
        configColumnsToValues(this.cppObj, 6, null, r110, r100.types, r100.longValues, r100.doubleValues, r100.stringValues);
        goto L8
    }

    public StatementUpdate limit(ExpressionConvertible r100, long r110) {
        configLimitRange(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), 3, r110);
        return this;
    }

    public StatementUpdate limit(long r100, long r110) {
        configLimitRange(this.cppObj, 3, r100, 3, r110);
        return this;
    }
}
