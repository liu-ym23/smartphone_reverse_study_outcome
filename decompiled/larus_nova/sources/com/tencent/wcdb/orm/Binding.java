package com.tencent.wcdb.orm;

import com.tencent.wcdb.base.CppObject;
import com.tencent.wcdb.base.WCDBException;
import com.tencent.wcdb.core.Handle;
import com.tencent.wcdb.winq.ColumnDef;
import com.tencent.wcdb.winq.StatementCreateIndex;
import com.tencent.wcdb.winq.TableConstraint;

/* JADX INFO: loaded from: classes35.dex */
public class Binding extends CppObject {
    private long baseBinding;

    private static native void addColumnDef(long r100, long r101);

    private static native void addIndex(long r100, String r101, boolean r102, long r103);

    private static native void addTableConstraint(long r100, long r101);

    private static native void configVirtualModule(long r100, String r101);

    private static native void configVirtualModuleArgument(long r100, String r101);

    private static native void configWithoutRowId(long r100);

    private static native long createCppObj();

    private static native boolean createTable(long r100, String r101, long r102);

    private static native boolean createVirtualTable(long r100, String r101, long r102);

    private static native void enableAutoIncrementForExistingTable(long r100);

    private static native long getBaseBinding(long r100);

    public void configWithoutRowId() {
        configWithoutRowId(this.cppObj);
    }

    public void enableAutoIncrementForExistingTable() {
        enableAutoIncrementForExistingTable(this.cppObj);
    }

    public long getBaseBinding() {
        if (this.baseBinding != 0) goto L6;
        this.baseBinding = getBaseBinding(this.cppObj);
    L6:
        return this.baseBinding;
    }

    public Binding() {
        this.baseBinding = 0;
        this.cppObj = createCppObj();
    }

    public void addColumnDef(ColumnDef r100) {
        addColumnDef(this.cppObj, CppObject.get(r100));
    }

    public void addTableConstraint(TableConstraint r100) {
        addTableConstraint(this.cppObj, CppObject.get(r100));
    }

    public Binding configVirtualModule(String r100) {
        configVirtualModule(this.cppObj, r100);
        return this;
    }

    public void configVirtualModuleArgument(String r100) {
        configVirtualModuleArgument(this.cppObj, r100);
    }

    public boolean createTable(String r100, Handle r101) throws WCDBException {
        return createTable(this.cppObj, r100, r101.getCppHandle());
    }

    public boolean createVirtualTable(String r100, Handle r101) throws WCDBException {
        return createVirtualTable(this.cppObj, r100, r101.getCppHandle());
    }

    public void addIndex(String r100, boolean r101, StatementCreateIndex r102) {
        addIndex(this.cppObj, r100, r101, CppObject.get(r102));
    }
}
