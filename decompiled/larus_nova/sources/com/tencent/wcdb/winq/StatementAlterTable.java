package com.tencent.wcdb.winq;

import com.tencent.wcdb.base.CppObject;

/* JADX INFO: loaded from: classes41.dex */
public class StatementAlterTable extends Statement {
    private static native void configAddColumn(long r100, long r101);

    private static native void configRenameColumn(long r100, int r101, long r102, String r103);

    private static native void configRenameToColumn(long r100, int r101, long r102, String r103);

    private static native void configRenameToTable(long r100, String r101);

    private static native void configSchema(long r100, int r101, long r102, String r103);

    private static native void configTable(long r100, String r101);

    private static native long createCppObj();

    @Override // com.tencent.wcdb.winq.Identifier
    public int getType() {
        return 31;
    }

    public StatementAlterTable() {
        this.cppObj = createCppObj();
    }

    public StatementAlterTable addColumn(ColumnDef r100) {
        configAddColumn(this.cppObj, CppObject.get(r100));
        return this;
    }

    public StatementAlterTable alterTable(String r100) {
        configTable(this.cppObj, r100);
        return this;
    }

    public StatementAlterTable of(Schema r100) {
        configSchema(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public StatementAlterTable renameColumn(Column r100) {
        configRenameColumn(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public StatementAlterTable renameTo(String r100) {
        configRenameToTable(this.cppObj, r100);
        return this;
    }

    public StatementAlterTable toColumn(Column r100) {
        configRenameToColumn(this.cppObj, Identifier.getCppType(r100), CppObject.get(r100), null);
        return this;
    }

    public StatementAlterTable of(String r100) {
        configSchema(this.cppObj, 6, 0, r100);
        return this;
    }

    public StatementAlterTable renameColumn(String r100) {
        configRenameColumn(this.cppObj, 6, 0, r100);
        return this;
    }

    public StatementAlterTable toColumn(String r100) {
        configRenameToColumn(this.cppObj, 6, 0, r100);
        return this;
    }
}
