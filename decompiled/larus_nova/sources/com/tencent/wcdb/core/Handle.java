package com.tencent.wcdb.core;

import com.tencent.wcdb.base.CppObject;
import com.tencent.wcdb.base.WCDBException;
import com.tencent.wcdb.winq.Statement;

/* JADX INFO: loaded from: classes35.dex */
public class Handle extends HandleORMOperation implements AutoCloseable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Database database;
    private PreparedStatement mainStatement;
    private boolean writeHint;

    public static class CancellationSignal extends CppObject {
        public void cancel() {
            Handle.access$100(this.cppObj);
        }

        public CancellationSignal() {
            this.cppObj = Handle.access$000();
        }
    }

    private static native void attachCancellationSignal(long r100, long r101);

    public static native boolean beginTransaction(long r100);

    private static native void cancelSignal(long r100);

    public static native boolean commitTransaction(long r100);

    private static native long createCancellationSignal();

    private static native void detachCancellationSignal(long r100);

    public static native boolean execute(long r100, long r101);

    public static native boolean executeSQL(long r100, String r101);

    public static native void finalizeAllStatements(long r100);

    public static native int getChanges(long r100);

    public static native long getError(long r100);

    public static native long getLastInsertedRowId(long r100);

    public static native long getMainStatement(long r100);

    public static native long getOrCreatePreparedStatement(long r100, long r101);

    public static native long getOrCreatePreparedStatementWithSQL(long r100, String r101);

    public static native int getTotalChanges(long r100);

    public static native boolean isInTransaction(long r100);

    public static native void rollbackTransaction(long r100);

    public static native int tableExist(long r100, String r101);

    @Override // com.tencent.wcdb.core.HandleOperation
    public boolean autoInvalidateHandle() {
        return false;
    }

    @Override // com.tencent.wcdb.core.HandleOperation
    public Handle getHandle(boolean r100) {
        return this;
    }

    public void invalidate() {
        this.mainStatement = null;
        long r100 = this.cppObj;
        if (r100 == 0) goto L6;
        this.cppObj = 0;
        CppObject.releaseCPPObject(r100);
        this.writeHint = false;
        return;
    }

    public native boolean runPausableTransaction(long r100, PausableTransaction r101);

    public native boolean runTransaction(long r100, Transaction r101);

    public WCDBException createException() {
        return WCDBException.createException(getError(this.cppObj));
    }

    public void detachCancellationSignal() {
        long r100 = this.cppObj;
        if (r100 == 0) goto L6;
        detachCancellationSignal(r100);
        return;
    }

    public void finalizeAllStatements() {
        long r100 = this.cppObj;
        if (r100 <= 0) goto L6;
        finalizeAllStatements(r100);
        return;
    }

    public long getCppHandle() throws WCDBException {
        if (this.cppObj != 0) goto L10;
        long r100 = Database.getHandle(CppObject.get(this.database), this.writeHint);
        this.cppObj = r100;
        if (r100 != 0) goto L10;
        throw this.database.createException();
    L10:
        return this.cppObj;
    }

    public static /* synthetic */ long access$000() {
        return createCancellationSignal();
    }

    public int getChanges() throws WCDBException {
        return getChanges(getCppHandle());
    }

    public long getLastInsertedRowId() throws WCDBException {
        return getLastInsertedRowId(getCppHandle());
    }

    public int getTotalChanges() throws WCDBException {
        return getTotalChanges(getCppHandle());
    }

    static {
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        invalidate();
    }

    @Override // com.tencent.wcdb.core.HandleORMOperation
    public Database getDatabase() {
        return this.database;
    }

    public static /* synthetic */ void access$100(long r100) {
        cancelSignal(r100);
    }

    public void attachCancellationSignal(CancellationSignal r100) throws WCDBException {
        attachCancellationSignal(getCppHandle(), CppObject.get(r100));
    }

    public PreparedStatement getOrCreatePreparedStatement(Statement r100) throws WCDBException {
        long r101 = getOrCreatePreparedStatement(getCppHandle(), CppObject.get(r100));
        if (r101 == 0) goto L7;
        return new PreparedStatement(r101);
    L7:
        throw createException();
    }

    public PreparedStatement preparedWithMainStatement(Statement r100) throws WCDBException {
        if (this.mainStatement != null) goto L5;
        PreparedStatement r101 = new PreparedStatement(getMainStatement(getCppHandle()));
        this.mainStatement = r101;
        r101.autoFinalize = true;
    L5:
        this.mainStatement.prepare(r100);
        return this.mainStatement;
    }

    public PreparedStatement getOrCreatePreparedStatement(String r100) throws WCDBException {
        long r101 = getOrCreatePreparedStatementWithSQL(getCppHandle(), r100);
        if (r101 == 0) goto L7;
        return new PreparedStatement(r101);
    L7:
        throw createException();
    }

    public PreparedStatement preparedWithMainStatement(String r100) throws WCDBException {
        if (this.mainStatement != null) goto L5;
        PreparedStatement r101 = new PreparedStatement(getMainStatement(getCppHandle()));
        this.mainStatement = r101;
        r101.autoFinalize = true;
    L5:
        this.mainStatement.prepare(r100);
        return this.mainStatement;
    }

    public Handle(long r100, Database r101) {
        this.mainStatement = null;
        this.writeHint = false;
        this.cppObj = r100;
        this.database = r101;
    }

    private boolean onTransaction(long r100, Transaction r101) {
        return r101.insideTransaction(new Handle(r100, this.database));
    L5:
        return false;
    }

    public Handle(Database r100, boolean r101) {
        this.mainStatement = null;
        this.database = r100;
        this.writeHint = r101;
    }

    private int onPausableTransaction(long r100, PausableTransaction r101, boolean r102) {
        return r101.insideTransaction(new Handle(r100, this.database), r102) ? 1 : 0;
    L5:
        return 2;
    }
}
