package com.tencent.wcdb.compat;

import android.database.sqlite.SQLiteClosable;
import android.database.sqlite.SQLiteDoneException;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.tencent.wcdb.base.Value;
import com.tencent.wcdb.base.WCDBInterruptException;
import com.tencent.wcdb.core.Database;
import com.tencent.wcdb.core.Handle;
import com.tencent.wcdb.core.PreparedStatement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes40.dex */
public final class SQLiteStatement extends SQLiteClosable {
    private final ArrayList<Object> mBindArgs;
    private final Database mDB;
    private final String mSql;

    public void execute() {
        execute(null);
    }

    public long executeInsert() {
        return executeInsert(null);
    }

    public int executeUpdateDelete() {
        return executeUpdateDelete(null);
    }

    public long simpleQueryForLong() {
        return simpleQueryForLong(null);
    }

    public String simpleQueryForString() {
        return simpleQueryForString(null);
    }

    public void clearBindings() {
        this.mBindArgs.clear();
    }

    public String toString() {
        return "SQLiteProgram: " + this.mSql;
    }

    @Override // android.database.sqlite.SQLiteClosable
    public void onAllReferencesReleased() {
        clearBindings();
    }

    public void bindAllArgs(Object[] r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.length;
        if (this.mBindArgs.size() >= r101) goto L9;
        this.mBindArgs.ensureCapacity(r101);
    L7:
        this.mBindArgs.add(null);
        if (this.mBindArgs.size() < r101) goto L7;
    L9:
        int r102 = 0;
    L10:
        if (r102 >= r101) goto L12;
        ListProtector.set(this.mBindArgs, r102, r100[r102]);
        r102 = r102 + 1;
        goto L10
    }

    public void bindNull(int r100) {
        bind(r100, null);
    }

    public void execute(CancellationSignal r100) {
        Handle r101 = null;
        r101 = this.mDB.getHandle(true);     // Catch: Throwable -> L7
        execute(r101, r100);     // Catch: Throwable -> L7
        if (r101 == null) goto L13;
        r101.invalidate();
        return;
    L13:
        return;
    L7:
        th = move-exception;
        if (r101 == null) goto L10;
        r101.invalidate();
    L10:
        throw th;
    }

    public long executeInsert(CancellationSignal r100) {
        Handle r101 = null;
        r101 = this.mDB.getHandle(true);     // Catch: Throwable -> L6
        execute(r101, r100);     // Catch: Throwable -> L6
        long r102 = r101.getLastInsertedRowId();     // Catch: Throwable -> L6
        r101.invalidate();
        return r102;
    L6:
        th = move-exception;
        if (r101 == null) goto L9;
        r101.invalidate();
    L9:
        throw th;
    }

    public int executeUpdateDelete(CancellationSignal r100) {
        Handle r101 = null;
        r101 = this.mDB.getHandle(true);     // Catch: Throwable -> L6
        execute(r101, r100);     // Catch: Throwable -> L6
        int r102 = r101.getChanges();     // Catch: Throwable -> L6
        r101.invalidate();
        return r102;
    L6:
        th = move-exception;
        if (r101 == null) goto L9;
        r101.invalidate();
    L9:
        throw th;
    }

    public long simpleQueryForLong(CancellationSignal r100) {
        Handle r101 = null;
        r101 = this.mDB.getHandle(false);     // Catch: Throwable -> L7
        long r102 = executeForValue(r101, r100).getLong();     // Catch: Throwable -> L7
        if (r101 == null) goto L6;
        r101.invalidate();
    L6:
        return r102;
    L7:
        th = move-exception;
        if (r101 == null) goto L10;
        r101.invalidate();
    L10:
        throw th;
    }

    public String simpleQueryForString(CancellationSignal r100) {
        Handle r101 = null;
        r101 = this.mDB.getHandle(false);     // Catch: Throwable -> L7
        String r102 = executeForValue(r101, r100).getText();     // Catch: Throwable -> L7
        if (r101 == null) goto L6;
        r101.invalidate();
    L6:
        return r102;
    L7:
        th = move-exception;
        if (r101 == null) goto L10;
        r101.invalidate();
    L10:
        throw th;
    }

    private void bind(int r100, Object r101) {
        if (r100 < 1) goto L12;
        if (this.mBindArgs.size() >= r100) goto L9;
        this.mBindArgs.ensureCapacity(r100);
    L7:
        this.mBindArgs.add(null);
        if (this.mBindArgs.size() < r100) goto L7;
    L9:
        ListProtector.set(this.mBindArgs, r100 - 1, r101);
        return;
    L12:
        throw new IllegalArgumentException("Cannot bind argument at index " + r100 + " because the index is out of range.");
    }

    private void execute(Handle r100, CancellationSignal r101) {
        DatabaseUtils.bindCancellationSignal(r100, r101);
        PreparedStatement r102 = null;
        r102 = r100.preparedWithMainStatement(this.mSql);     // Catch: Throwable -> L11 WCDBInterruptException -> L13
        Iterator<Object> r103 = this.mBindArgs.iterator();     // Catch: Throwable -> L11 WCDBInterruptException -> L13
        int r104 = 1;
    L5:
        if (r103.hasNext() == false) goto L7;
        Value r105 = new Value(r103.next());     // Catch: Throwable -> L11 WCDBInterruptException -> L13
        r102.bindValue(r105, r104);     // Catch: Throwable -> L11 WCDBInterruptException -> L13
        r104 = r104 + 1;     // Catch: Throwable -> L11 WCDBInterruptException -> L13
    L7:
        r102.step();     // Catch: Throwable -> L11 WCDBInterruptException -> L13
        if (r102.isDone() == false) goto L7;
        r102.finalizeStatement();
        return;
    L11:
        th = move-exception;
        if (r102 == null) goto L18;
        r102.finalizeStatement();
    L18:
        throw th;
    L13:
        e = move-exception;
        throw ((OperationCanceledException) new OperationCanceledException().initCause(e));     // Catch: Throwable -> L11
    }

    private Value executeForValue(Handle r100, CancellationSignal r101) {
        DatabaseUtils.bindCancellationSignal(r100, r101);
        PreparedStatement r102 = null;
        PreparedStatement r103 = r100.preparedWithMainStatement(this.mSql);     // Catch: Throwable -> L14
        Iterator<Object> r104 = this.mBindArgs.iterator();     // Catch: Throwable -> L14
        int r105 = 1;
    L5:
        if (r104.hasNext() == false) goto L7;
        Value r106 = new Value(r104.next());     // Catch: Throwable -> L14
        r103.bindValue(r106, r105);     // Catch: Throwable -> L14
        r105 = r105 + 1;     // Catch: Throwable -> L14
        goto L5
    L7:
        r103.step();     // Catch: Throwable -> L14
        if (r103.isDone() == true) goto L13;
        Value r107 = r103.getValue(0);     // Catch: Throwable -> L14
        r103.finalizeStatement();
        return r107;
    L13:
        throw new SQLiteDoneException();     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        if (0 == 0) goto L17;
        r102.finalizeStatement();
    L17:
        throw th;
    }

    public void bindBlob(int r100, byte[] r101) {
        if (r101 == null) goto L6;
        bind(r100, r101);
        return;
    L6:
        throw new IllegalArgumentException("the bind value at index " + r100 + " is null");
    }

    public void bindDouble(int r100, double r101) {
        bind(r100, Double.valueOf(r101));
    }

    public void bindLong(int r100, long r101) {
        bind(r100, Long.valueOf(r101));
    }

    public void bindString(int r100, String r101) {
        if (r101 == null) goto L6;
        bind(r100, r101);
        return;
    L6:
        throw new IllegalArgumentException("the bind value at index " + r100 + " is null");
    }

    public SQLiteStatement(Database r100, String r101, Object[] r102) {
        ArrayList<Object> r103 = new ArrayList();
        this.mBindArgs = r103;
        this.mDB = r100;
        this.mSql = r101;
        if (r102 == null) goto L6;
        r103.addAll(Arrays.asList(r102));
        return;
    }
}
