package com.tencent.wcdb.winq;

import androidx.camera.video.AudioStats;
import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class ColumnConstraint extends Identifier {
    private static native void configAutoIncrement(long r100);

    private static native void configCheck(long r100, long r101);

    private static native void configCollate(long r100, String r101);

    private static native void configConflictAction(long r100, int r101);

    private static native void configForeignKey(long r100, long r101);

    private static native void configNotNull(long r100);

    private static native void configOrder(long r100, int r101);

    private static native void configPrimaryKey(long r100);

    private static native void configUnIndex(long r100);

    private static native void configUnique(long r100);

    private static native long createCppObject(String r100);

    private static native void defaultTo(long r100, int r101, long r102, double r103, String r104);

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 10;
    }

    public ColumnConstraint autoIncrement() {
        configAutoIncrement(this.cppObj);
        return this;
    }

    public ColumnConstraint notNull() {
        configNotNull(this.cppObj);
        return this;
    }

    public ColumnConstraint primaryKey() {
        configPrimaryKey(this.cppObj);
        return this;
    }

    public ColumnConstraint unIndex() {
        configUnIndex(this.cppObj);
        return this;
    }

    public ColumnConstraint unique() {
        configUnique(this.cppObj);
        return this;
    }

    public ColumnConstraint() {
        this.cppObj = createCppObject(null);
    }

    public ColumnConstraint(String r100) {
        this.cppObj = createCppObject(r100);
    }

    public ColumnConstraint check(Expression r100) {
        configCheck(this.cppObj, CppObject.get(r100));
        return this;
    }

    public ColumnConstraint collate(String r100) {
        configCollate(this.cppObj, r100);
        return this;
    }

    public ColumnConstraint conflict(ConflictAction r100) {
        configConflictAction(this.cppObj, r100.ordinal());
        return this;
    }

    public ColumnConstraint defaultTo(String r110) {
        if (r110 == null) goto L5;
        defaultTo(this.cppObj, 6, 0, AudioStats.AUDIO_AMPLITUDE_NONE, r110);
    L6:
        return this;
    L5:
        defaultTo(this.cppObj, 1, 0, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        goto L6
    }

    public ColumnConstraint foreignKey(ForeignKey r100) {
        configForeignKey(this.cppObj, CppObject.get(r100));
        return this;
    }

    public ColumnConstraint order(Order r100) {
        configOrder(this.cppObj, r100.ordinal() + 1);
        return this;
    }

    public ColumnConstraint defaultTo(ExpressionConvertible r100) {
        defaultTo(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public ColumnConstraint defaultTo(boolean r100) {
        long r101 = this.cppObj;
        if (r100 == false) goto L5;
        long r102 = 1;
    L6:
        defaultTo(r101, 2, r102, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    L5:
        r102 = 0;
        goto L6
    }

    public ColumnConstraint defaultTo(byte r100) {
        defaultTo(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public ColumnConstraint defaultTo(double r100) {
        defaultTo(this.cppObj, 5, 0, r100, null);
        return this;
    }

    public ColumnConstraint defaultTo(float r100) {
        defaultTo(this.cppObj, 5, 0, r100, null);
        return this;
    }

    public ColumnConstraint defaultTo(int r100) {
        defaultTo(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public ColumnConstraint defaultTo(long r100) {
        defaultTo(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }

    public ColumnConstraint defaultTo(short r100) {
        defaultTo(this.cppObj, 3, r100, AudioStats.AUDIO_AMPLITUDE_NONE, null);
        return this;
    }
}
