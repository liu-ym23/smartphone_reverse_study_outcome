package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class ColumnDef extends Identifier {
    private static native void constraint(long r100, long r101);

    private static native long createCppObj(int r100, long r101, String r102, int r103);

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 9;
    }

    public ColumnDef makeNotIndexed() {
        return constraint(new ColumnConstraint().unIndex());
    }

    public ColumnDef makeNotNull() {
        return constraint(new ColumnConstraint().notNull());
    }

    public ColumnDef makePrimary() {
        return constraint(new ColumnConstraint().primaryKey());
    }

    public ColumnDef makeUnique() {
        return constraint(new ColumnConstraint().unique());
    }

    public ColumnDef(Column r100) {
        this.cppObj = createCppObj(Identifier.getCppType(r100), CppObject.get(r100), null, 0);
    }

    public ColumnDef constraint(ColumnConstraint r100) {
        constraint(this.cppObj, CppObject.get(r100));
        return this;
    }

    public ColumnDef makeDefaultTo(byte r100) {
        return constraint(new ColumnConstraint().defaultTo(r100));
    }

    public ColumnDef makeForeignKey(ForeignKey r100) {
        return constraint(new ColumnConstraint().foreignKey(r100));
    }

    public ColumnDef makePrimary(boolean r100) {
        return constraint(new ColumnConstraint().primaryKey().autoIncrement());
    }

    public ColumnDef(String r100) {
        this.cppObj = createCppObj(6, 0, r100, 0);
    }

    public ColumnDef makeDefaultTo(double r100) {
        return constraint(new ColumnConstraint().defaultTo(r100));
    }

    public ColumnDef makeDefaultTo(float r100) {
        return constraint(new ColumnConstraint().defaultTo(r100));
    }

    public ColumnDef makeDefaultTo(int r100) {
        return constraint(new ColumnConstraint().defaultTo(r100));
    }

    public ColumnDef makeDefaultTo(long r100) {
        return constraint(new ColumnConstraint().defaultTo(r100));
    }

    public ColumnDef makeDefaultTo(ExpressionConvertible r100) {
        return constraint(new ColumnConstraint().defaultTo(r100));
    }

    public ColumnDef makeDefaultTo(String r100) {
        return constraint(new ColumnConstraint().defaultTo(r100));
    }

    public ColumnDef makeDefaultTo(short r100) {
        return constraint(new ColumnConstraint().defaultTo(r100));
    }

    public ColumnDef makeDefaultTo(boolean r100) {
        return constraint(new ColumnConstraint().defaultTo(r100));
    }

    public ColumnDef(Column r100, ColumnType r101) {
        this.cppObj = createCppObj(Identifier.getCppType(r100), CppObject.get(r100), null, r101.ordinal());
    }

    public ColumnDef(String r100, ColumnType r101) {
        this.cppObj = createCppObj(6, 0, r100, r101.ordinal());
    }
}
