package com.tencent.wcdb.core;

import com.tencent.wcdb.base.CppObject;
import com.tencent.wcdb.base.Value;
import com.tencent.wcdb.base.WCDBException;
import com.tencent.wcdb.winq.Column;
import com.tencent.wcdb.winq.ConflictAction;
import com.tencent.wcdb.winq.Expression;
import com.tencent.wcdb.winq.OrderingTerm;
import com.tencent.wcdb.winq.ResultColumnConvertible;
import com.tencent.wcdb.winq.Statement;
import com.tencent.wcdb.winq.StatementDelete;
import com.tencent.wcdb.winq.StatementInsert;
import com.tencent.wcdb.winq.StatementSelect;
import com.tencent.wcdb.winq.StatementUpdate;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes35.dex */
public abstract class HandleOperation extends CppObject {
    public abstract boolean autoInvalidateHandle();

    public void beginTransaction() throws WCDBException {
        Handle r100 = getHandle(true);
    L14:
        th = move-exception;
        if (autoInvalidateHandle() == false) goto L18;
        r100.invalidate();
    L18:
        throw th;
    L4:
        if (Handle.beginTransaction(r100.getCppHandle()) == true) goto L7;
        WCDBException r101 = r100.createException();     // Catch: Throwable -> L14
    L9:
        if (autoInvalidateHandle() == false) goto L11;
        r100.invalidate();
    L11:
        if (r101 != null) goto L13;
        return;
    L13:
        throw r101;
    L7:
        r101 = null;
        goto L9
    }

    public void commitTransaction() throws WCDBException {
        Handle r100 = getHandle(true);
    L14:
        th = move-exception;
        if (autoInvalidateHandle() == false) goto L18;
        r100.invalidate();
    L18:
        throw th;
    L4:
        if (Handle.commitTransaction(r100.getCppHandle()) == true) goto L7;
        WCDBException r101 = r100.createException();     // Catch: Throwable -> L14
    L9:
        if (autoInvalidateHandle() == false) goto L11;
        r100.invalidate();
    L11:
        if (r101 != null) goto L13;
        return;
    L13:
        throw r101;
    L7:
        r101 = null;
        goto L9
    }

    public abstract Handle getHandle(boolean r100);

    public boolean isInTransaction() throws WCDBException {
        Handle r100 = getHandle(false);     // Catch: Throwable -> L11
        boolean r101 = Handle.isInTransaction(r100.getCppHandle());     // Catch: Throwable -> L9
        if (autoInvalidateHandle() == false) goto L8;
        r100.invalidate();
    L8:
        return r101;
    L9:
        th = th;
    L13:
        if (r100 != null) goto L15;
    L17:
        throw th;
    L15:
        if (autoInvalidateHandle() == false) goto L17;
        r100.invalidate();
    L11:
        th = th;
        r100 = null;
        goto L13
    }

    public void rollbackTransaction() throws WCDBException {
        Handle r100 = getHandle(true);
        Handle.rollbackTransaction(r100.getCppHandle());     // Catch: Throwable -> L8
        if (autoInvalidateHandle() == false) goto L16;
        r100.invalidate();
        return;
    L16:
        return;
    L8:
        th = move-exception;
        if (r100 != null) goto L11;
    L13:
        throw th;
    L11:
        if (autoInvalidateHandle() == false) goto L13;
        r100.invalidate();
        goto L13
    }

    public HandleOperation() {
    }

    private void deleteValue(StatementDelete r100) throws WCDBException {
        Handle r101 = getHandle(true);
        r101.execute(r100);     // Catch: Throwable -> L8
        if (autoInvalidateHandle() == false) goto L15;
        r101.invalidate();
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if (autoInvalidateHandle() == false) goto L12;
        r101.invalidate();
    L12:
        throw th;
    }

    public void execute(Statement r100) throws WCDBException {
        Handle r101 = getHandle(r100.isWriteStatement());
    L14:
        th = move-exception;
        if (autoInvalidateHandle() == false) goto L18;
        r101.invalidate();
    L18:
        throw th;
    L4:
        if (Handle.execute(r101.getCppHandle(), CppObject.get(r100)) == true) goto L7;
        WCDBException r102 = r101.createException();     // Catch: Throwable -> L14
    L9:
        if (autoInvalidateHandle() == false) goto L11;
        r101.invalidate();
    L11:
        if (r102 != null) goto L13;
        return;
    L13:
        throw r102;
    L7:
        r102 = null;
        goto L9
    }

    public List<Value[]> getAllRowsFromSQL(String r100) throws WCDBException {
        Handle r101 = getHandle(false);
        PreparedStatement r102 = r101.preparedWithMainStatement(r100);     // Catch: Throwable -> L11
        List<Value[]> r103 = r102.getMultiRows();     // Catch: Throwable -> L9
        r102.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L8;
        r101.invalidate();
    L8:
        return r103;
    L9:
        th = th;
    L13:
        if (r102 == null) goto L16;
        r102.finalizeStatement();
    L16:
        if (autoInvalidateHandle() == false) goto L18;
        r101.invalidate();
    L18:
        throw th;
    L11:
        th = th;
        r102 = null;
        goto L13
    }

    public List<Value[]> getAllRowsFromStatement(Statement r100) throws WCDBException {
        Handle r101 = getHandle(false);
        PreparedStatement r102 = r101.preparedWithMainStatement(r100);     // Catch: Throwable -> L11
        List<Value[]> r103 = r102.getMultiRows();     // Catch: Throwable -> L9
        r102.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L8;
        r101.invalidate();
    L8:
        return r103;
    L9:
        th = th;
    L13:
        if (r102 == null) goto L16;
        r102.finalizeStatement();
    L16:
        if (autoInvalidateHandle() == false) goto L18;
        r101.invalidate();
    L18:
        throw th;
    L11:
        th = th;
        r102 = null;
        goto L13
    }

    public List<byte[]> getOneColumnBLOBFromStatement(Statement r100) throws WCDBException {
        Handle r101 = getHandle(false);
        PreparedStatement r102 = r101.preparedWithMainStatement(r100);     // Catch: Throwable -> L11
        List<byte[]> r103 = r102.getOneColumnBLOB();     // Catch: Throwable -> L9
        r102.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L8;
        r101.invalidate();
    L8:
        return r103;
    L9:
        th = th;
    L13:
        if (r102 == null) goto L16;
        r102.finalizeStatement();
    L16:
        if (autoInvalidateHandle() == false) goto L18;
        r101.invalidate();
    L18:
        throw th;
    L11:
        th = th;
        r102 = null;
        goto L13
    }

    public List<Double> getOneColumnDoubleFromStatement(Statement r100) throws WCDBException {
        Handle r101 = getHandle(false);
        PreparedStatement r102 = r101.preparedWithMainStatement(r100);     // Catch: Throwable -> L11
        List<Double> r103 = r102.getOneColumnDouble();     // Catch: Throwable -> L9
        r102.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L8;
        r101.invalidate();
    L8:
        return r103;
    L9:
        th = th;
    L13:
        if (r102 == null) goto L16;
        r102.finalizeStatement();
    L16:
        if (autoInvalidateHandle() == false) goto L18;
        r101.invalidate();
    L18:
        throw th;
    L11:
        th = th;
        r102 = null;
        goto L13
    }

    public List<Float> getOneColumnFloatFromStatement(Statement r100) throws WCDBException {
        Handle r101 = getHandle(false);
        PreparedStatement r102 = r101.preparedWithMainStatement(r100);     // Catch: Throwable -> L11
        List<Float> r103 = r102.getOneColumnFloat();     // Catch: Throwable -> L9
        r102.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L8;
        r101.invalidate();
    L8:
        return r103;
    L9:
        th = th;
    L13:
        if (r102 == null) goto L16;
        r102.finalizeStatement();
    L16:
        if (autoInvalidateHandle() == false) goto L18;
        r101.invalidate();
    L18:
        throw th;
    L11:
        th = th;
        r102 = null;
        goto L13
    }

    public List<Value> getOneColumnFromSQL(String r100) throws WCDBException {
        Handle r101 = getHandle(false);
        PreparedStatement r102 = r101.preparedWithMainStatement(r100);     // Catch: Throwable -> L11
        List<Value> r103 = r102.getOneColumn();     // Catch: Throwable -> L9
        r102.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L8;
        r101.invalidate();
    L8:
        return r103;
    L9:
        th = th;
    L13:
        if (r102 == null) goto L16;
        r102.finalizeStatement();
    L16:
        if (autoInvalidateHandle() == false) goto L18;
        r101.invalidate();
    L18:
        throw th;
    L11:
        th = th;
        r102 = null;
        goto L13
    }

    public List<Value> getOneColumnFromStatement(Statement r100) throws WCDBException {
        Handle r101 = getHandle(false);
        PreparedStatement r102 = r101.preparedWithMainStatement(r100);     // Catch: Throwable -> L11
        List<Value> r103 = r102.getOneColumn();     // Catch: Throwable -> L9
        r102.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L8;
        r101.invalidate();
    L8:
        return r103;
    L9:
        th = th;
    L13:
        if (r102 == null) goto L16;
        r102.finalizeStatement();
    L16:
        if (autoInvalidateHandle() == false) goto L18;
        r101.invalidate();
    L18:
        throw th;
    L11:
        th = th;
        r102 = null;
        goto L13
    }

    public List<Integer> getOneColumnIntFromStatement(Statement r100) throws WCDBException {
        Handle r101 = getHandle(false);
        PreparedStatement r102 = r101.preparedWithMainStatement(r100);     // Catch: Throwable -> L11
        List<Integer> r103 = r102.getOneColumnInt();     // Catch: Throwable -> L9
        r102.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L8;
        r101.invalidate();
    L8:
        return r103;
    L9:
        th = th;
    L13:
        if (r102 == null) goto L16;
        r102.finalizeStatement();
    L16:
        if (autoInvalidateHandle() == false) goto L18;
        r101.invalidate();
    L18:
        throw th;
    L11:
        th = th;
        r102 = null;
        goto L13
    }

    public List<Long> getOneColumnLongFromStatement(Statement r100) throws WCDBException {
        Handle r101 = getHandle(false);
        PreparedStatement r102 = r101.preparedWithMainStatement(r100);     // Catch: Throwable -> L11
        List<Long> r103 = r102.getOneColumnLong();     // Catch: Throwable -> L9
        r102.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L8;
        r101.invalidate();
    L8:
        return r103;
    L9:
        th = th;
    L13:
        if (r102 == null) goto L16;
        r102.finalizeStatement();
    L16:
        if (autoInvalidateHandle() == false) goto L18;
        r101.invalidate();
    L18:
        throw th;
    L11:
        th = th;
        r102 = null;
        goto L13
    }

    public List<String> getOneColumnStringFromStatement(Statement r100) throws WCDBException {
        Handle r101 = getHandle(false);
        PreparedStatement r102 = r101.preparedWithMainStatement(r100);     // Catch: Throwable -> L11
        List<String> r103 = r102.getOneColumnString();     // Catch: Throwable -> L9
        r102.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L8;
        r101.invalidate();
    L8:
        return r103;
    L9:
        th = th;
    L13:
        if (r102 == null) goto L16;
        r102.finalizeStatement();
    L16:
        if (autoInvalidateHandle() == false) goto L18;
        r101.invalidate();
    L18:
        throw th;
    L11:
        th = th;
        r102 = null;
        goto L13
    }

    public Value[] getOneRowFromSQL(String r100) throws WCDBException {
        Handle r101 = getHandle(false);
        Value[] r102 = null;
        PreparedStatement r103 = r101.preparedWithMainStatement(r100);     // Catch: Throwable -> L13
        r103.step();     // Catch: Throwable -> L11
        if (r103.isDone() == true) goto L7;
        r102 = r103.getOneRow();     // Catch: Throwable -> L11
    L7:
        r103.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L10;
        r101.invalidate();
    L10:
        return r102;
    L11:
        Throwable th10 = th;
    L15:
        if (r103 == null) goto L18;
        r103.finalizeStatement();
    L18:
        if (autoInvalidateHandle() == false) goto L20;
        r101.invalidate();
    L20:
        throw th10;
    L13:
        th = move-exception;
        th10 = th;
        r103 = null;
        goto L15
    }

    public Value[] getOneRowFromStatement(Statement r100) throws WCDBException {
        Handle r101 = getHandle(false);
        Value[] r102 = null;
        PreparedStatement r103 = r101.preparedWithMainStatement(r100);     // Catch: Throwable -> L13
        r103.step();     // Catch: Throwable -> L11
        if (r103.isDone() == true) goto L7;
        r102 = r103.getOneRow();     // Catch: Throwable -> L11
    L7:
        r103.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L10;
        r101.invalidate();
    L10:
        return r102;
    L11:
        Throwable th10 = th;
    L15:
        if (r103 == null) goto L18;
        r103.finalizeStatement();
    L18:
        if (autoInvalidateHandle() == false) goto L20;
        r101.invalidate();
    L20:
        throw th10;
    L13:
        th = move-exception;
        th10 = th;
        r103 = null;
        goto L15
    }

    public Value getValueFromSQL(String r100) throws WCDBException {
        Handle r101 = getHandle(false);
        PreparedStatement r102 = null;
        Value r103 = null;
        PreparedStatement r104 = r101.preparedWithMainStatement(r100);     // Catch: Throwable -> L13
        r104.step();     // Catch: Throwable -> L11
        if (r104.isDone() == true) goto L7;
        r103 = r104.getValue(0);     // Catch: Throwable -> L11
    L7:
        r104.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L10;
        r101.invalidate();
    L10:
        return r103;
    L11:
        th = th;
        r102 = r104;
    L14:
        if (r102 == null) goto L17;
        r102.finalizeStatement();
    L17:
        if (autoInvalidateHandle() == false) goto L19;
        r101.invalidate();
    L19:
        throw th;
    L13:
        th = th;
        goto L14
    }

    public Value getValueFromStatement(Statement r100) throws WCDBException {
        Handle r101 = getHandle(false);
        PreparedStatement r102 = null;
        Value r103 = null;
        PreparedStatement r104 = r101.preparedWithMainStatement(r100);     // Catch: Throwable -> L13
        r104.step();     // Catch: Throwable -> L11
        if (r104.isDone() == true) goto L7;
        r103 = r104.getValue(0);     // Catch: Throwable -> L11
    L7:
        r104.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L10;
        r101.invalidate();
    L10:
        return r103;
    L11:
        th = th;
        r102 = r104;
    L14:
        if (r102 == null) goto L17;
        r102.finalizeStatement();
    L17:
        if (autoInvalidateHandle() == false) goto L19;
        r101.invalidate();
    L19:
        throw th;
    L13:
        th = th;
        goto L14
    }

    public void runPausableTransaction(PausableTransaction r100) throws WCDBException {
        Handle r101 = getHandle(true);
    L14:
        th = move-exception;
        if (autoInvalidateHandle() == false) goto L18;
        r101.invalidate();
    L18:
        throw th;
    L4:
        if (r101.runPausableTransaction(r101.getCppHandle(), r100) == true) goto L7;
        WCDBException r102 = r101.createException();     // Catch: Throwable -> L14
    L9:
        if (autoInvalidateHandle() == false) goto L11;
        r101.invalidate();
    L11:
        if (r102 != null) goto L13;
        return;
    L13:
        throw r102;
    L7:
        r102 = null;
        goto L9
    }

    public void runTransaction(Transaction r100) throws WCDBException {
        Handle r101 = getHandle(true);
    L14:
        th = move-exception;
        if (autoInvalidateHandle() == false) goto L18;
        r101.invalidate();
    L18:
        throw th;
    L4:
        if (r101.runTransaction(r101.getCppHandle(), r100) == true) goto L7;
        WCDBException r102 = r101.createException();     // Catch: Throwable -> L14
    L9:
        if (autoInvalidateHandle() == false) goto L11;
        r101.invalidate();
    L11:
        if (r102 != null) goto L13;
        return;
    L13:
        throw r102;
    L7:
        r102 = null;
        goto L9
    }

    public void deleteValue(String r100) throws WCDBException {
        deleteValue(new StatementDelete().deleteFrom(r100));
    }

    public void execute(String r100) throws WCDBException {
        Handle r101 = getHandle(false);
    L14:
        th = move-exception;
        if (autoInvalidateHandle() == false) goto L18;
        r101.invalidate();
    L18:
        throw th;
    L4:
        if (Handle.executeSQL(r101.getCppHandle(), r100) == true) goto L7;
        WCDBException r102 = r101.createException();     // Catch: Throwable -> L14
    L9:
        if (autoInvalidateHandle() == false) goto L11;
        r101.invalidate();
    L11:
        if (r102 != null) goto L13;
        return;
    L13:
        throw r102;
    L7:
        r102 = null;
        goto L9
    }

    private void updateRow(Value[] r100, StatementUpdate r101) throws WCDBException {
        Handle r102 = getHandle(true);
        PreparedStatement r103 = r102.preparedWithMainStatement(r101);     // Catch: Throwable -> L11
        r103.bindRow(r100);     // Catch: Throwable -> L9
        r103.step();     // Catch: Throwable -> L9
        r103.finalizeStatement();     // Catch: Throwable -> L9
        r103.finalizeStatement();
        if (autoInvalidateHandle() == false) goto L23;
        r102.invalidate();
        return;
    L23:
        return;
    L9:
        th = th;
    L13:
        if (r103 == null) goto L16;
        r103.finalizeStatement();
    L16:
        if (autoInvalidateHandle() == false) goto L18;
        r102.invalidate();
    L18:
        throw th;
    L11:
        th = th;
        r103 = null;
        goto L13
    }

    public void deleteValue(String r100, Expression r101) throws WCDBException {
        deleteValue(new StatementDelete().deleteFrom(r100).where(r101));
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r100, String r101) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r100).from(new String[]{r101}));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r100, String r101) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r100, String r101) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r100, String r101) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r100, String r101) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r100, String r101) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r100, String r101) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r100, String r101) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}));
    }

    public Value[] getOneRow(ResultColumnConvertible[] r100, String r101) throws WCDBException {
        return getOneRowFromStatement(new StatementSelect().select(r100).from(new String[]{r101}));
    }

    public Value getValue(ResultColumnConvertible r100, String r101) throws WCDBException {
        return getValueFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}));
    }

    private void insertRows(Collection<Value[]> r100, StatementInsert r101, Handle r102) throws WCDBException {
        PreparedStatement r103 = r102.preparedWithMainStatement(r101);
        Iterator<Value[]> r104 = r100.iterator();     // Catch: Throwable -> L10
    L5:
        if (r104.hasNext() == false) goto L8;
        Value[] r105 = r104.next();     // Catch: Throwable -> L10
        r103.reset();     // Catch: Throwable -> L10
        r103.bindRow(r105);     // Catch: Throwable -> L10
        r103.step();     // Catch: Throwable -> L10
        goto L5
    L8:
        r103.finalizeStatement();
        return;
    L10:
        th = move-exception;
        r103.finalizeStatement();
        throw th;
    }

    public void deleteValue(String r100, OrderingTerm r101, int r102) throws WCDBException {
        deleteValue(new StatementDelete().deleteFrom(r100).orderBy(new OrderingTerm[]{r101}).limit(r102));
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r100, String r101, OrderingTerm r102) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r100).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r100, String r101, OrderingTerm r102) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r100, String r101, OrderingTerm r102) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r100, String r101, OrderingTerm r102) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r100, String r101, OrderingTerm r102) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r100, String r101, OrderingTerm r102) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r100, String r101, OrderingTerm r102) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r100, String r101, OrderingTerm r102) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}));
    }

    public Value[] getOneRow(ResultColumnConvertible[] r100, String r101, OrderingTerm r102) throws WCDBException {
        return getOneRowFromStatement(new StatementSelect().select(r100).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}));
    }

    public Value getValue(ResultColumnConvertible r100, String r101, OrderingTerm r102) throws WCDBException {
        return getValueFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}));
    }

    public void insertOrIgnoreRow(Value[] r100, Column[] r101, String r102) throws WCDBException {
        insertOrIgnoreRows(Collections.singleton(r100), r101, r102);
    }

    public void insertOrIgnoreRows(Collection<Value[]> r100, Column[] r101, String r102) throws WCDBException {
        insertRows(r100, r101, r102, ConflictAction.Ignore);
    }

    public void insertOrReplaceRow(Value[] r100, Column[] r101, String r102) throws WCDBException {
        insertOrReplaceRows(Collections.singleton(r100), r101, r102);
    }

    public void insertOrReplaceRows(Collection<Value[]> r100, Column[] r101, String r102) throws WCDBException {
        insertRows(r100, r101, r102, ConflictAction.Replace);
    }

    public void insertRow(Value[] r100, Column[] r101, String r102) throws WCDBException {
        insertRows(Collections.singleton(r100), r101, r102);
    }

    public void updateRow(Value[] r100, Column[] r101, String r102) throws WCDBException {
        updateRow(r100, new StatementUpdate().update(r102).setColumnsToBindParameters(r101));
    }

    public void updateValue(Value r100, Column r101, String r102) throws WCDBException {
        if (r100 != null) goto L4;
        r100 = new Value();
    L4:
        updateRow(new Value[]{r100}, new Column[]{r101}, r102);
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r100, String r101, Expression r102) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r100).from(new String[]{r101}).where(r102));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r100, String r101, Expression r102) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r100, String r101, Expression r102) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r100, String r101, Expression r102) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r100, String r101, Expression r102) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r100, String r101, Expression r102) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r100, String r101, Expression r102) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r100, String r101, Expression r102) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102));
    }

    public Value[] getOneRow(ResultColumnConvertible[] r100, String r101, Expression r102) throws WCDBException {
        return getOneRowFromStatement(new StatementSelect().select(r100).from(new String[]{r101}).where(r102));
    }

    public Value getValue(ResultColumnConvertible r100, String r101, Expression r102) throws WCDBException {
        return getValueFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102));
    }

    public void insertRows(Collection<Value[]> r100, Column[] r101, String r102) throws WCDBException {
        insertRows(r100, r101, r102, ConflictAction.None);
    }

    public void updateValue(int r100, Column r101, String r102) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r102);
    }

    public void updateValue(long r100, Column r101, String r102) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r102);
    }

    public void updateValue(String r100, Column r101, String r102) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r102);
    }

    public void updateValue(byte[] r100, Column r101, String r102) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r102);
    }

    public static /* synthetic */ void access$000(HandleOperation r100, Collection r101, StatementInsert r102, Handle r103) throws WCDBException {
        r100.insertRows(r101, r102, r103);
    }

    private void insertRows(final Collection<Value[]> r100, Column[] r101, String r102, ConflictAction r103) throws WCDBException {
        final StatementInsert r104 = new StatementInsert().insertInto(r102).columns(r101).valuesWithBindParameters(r101.length);
        if (r103 != ConflictAction.Replace) goto L6;
        r104.orReplace();
    L8:
        Handle r105 = getHandle(true);
    L17:
        th = move-exception;
        if (autoInvalidateHandle() == false) goto L21;
        r105.invalidate();
    L21:
        throw th;
    L10:
        if (r100.size() <= 1) goto L12;
        r105.runTransaction(new AnonymousClass1(this, r100, r104));     // Catch: Throwable -> L17
    L14:
        if (autoInvalidateHandle() == false) goto L23;
        r105.invalidate();
        return;
    L23:
        return;
    L12:
        insertRows(r100, r104, r105);     // Catch: Throwable -> L17
        goto L14
    L6:
        if (r103 != ConflictAction.Ignore) goto L8;
        r104.orIgnore();
        goto L8
    }

    public void deleteValue(String r100, OrderingTerm r101, int r102, int r103) throws WCDBException {
        deleteValue(new StatementDelete().deleteFrom(r100).orderBy(new OrderingTerm[]{r101}).limit(r102).offset(r103));
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r100, String r101, OrderingTerm r102, int r103) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r100).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}).limit(r103));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r100, String r101, OrderingTerm r102, int r103) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}).limit(r103));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r100, String r101, OrderingTerm r102, int r103) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}).limit(r103));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r100, String r101, OrderingTerm r102, int r103) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}).limit(r103));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r100, String r101, OrderingTerm r102, int r103) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}).limit(r103));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r100, String r101, OrderingTerm r102, int r103) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}).limit(r103));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r100, String r101, OrderingTerm r102, int r103) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}).limit(r103));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r100, String r101, OrderingTerm r102, int r103) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}).limit(r103));
    }

    public Value[] getOneRow(ResultColumnConvertible[] r100, String r101, OrderingTerm r102, int r103) throws WCDBException {
        return getOneRowFromStatement(new StatementSelect().select(r100).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}).limit(1).offset(r103));
    }

    public Value getValue(ResultColumnConvertible r100, String r101, OrderingTerm r102, int r103) throws WCDBException {
        return getValueFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}).limit(1).offset(r103));
    }

    public void updateRow(Value[] r100, Column[] r101, String r102, Expression r103) throws WCDBException {
        updateRow(r100, new StatementUpdate().update(r102).setColumnsToBindParameters(r101).where(r103));
    }

    public void updateValue(Value r100, Column r101, String r102, Expression r103) throws WCDBException {
        if (r100 != null) goto L4;
        r100 = new Value();
    L4:
        updateRow(new Value[]{r100}, new Column[]{r101}, r102, r103);
    }

    public void deleteValue(String r100, Expression r101, OrderingTerm r102, int r103) throws WCDBException {
        deleteValue(new StatementDelete().deleteFrom(r100).where(r101).orderBy(new OrderingTerm[]{r102}).limit(r103));
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r100, String r101, Expression r102, OrderingTerm r103) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r100).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r100, String r101, Expression r102, OrderingTerm r103) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r100, String r101, Expression r102, OrderingTerm r103) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r100, String r101, Expression r102, OrderingTerm r103) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r100, String r101, Expression r102, OrderingTerm r103) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r100, String r101, Expression r102, OrderingTerm r103) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r100, String r101, Expression r102, OrderingTerm r103) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r100, String r101, Expression r102, OrderingTerm r103) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}));
    }

    public Value[] getOneRow(ResultColumnConvertible[] r100, String r101, Expression r102, OrderingTerm r103) throws WCDBException {
        return getOneRowFromStatement(new StatementSelect().select(r100).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}));
    }

    public Value getValue(ResultColumnConvertible r100, String r101, Expression r102, OrderingTerm r103) throws WCDBException {
        return getValueFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}));
    }

    public void updateValue(double r100, Column r101, String r102, Expression r103) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r102, r103);
    }

    public void updateValue(int r100, Column r101, String r102, Expression r103) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r102, r103);
    }

    public void updateValue(String r100, Column r101, String r102, Expression r103) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r102, r103);
    }

    public void updateValue(byte[] r100, Column r101, String r102, Expression r103) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r102, r103);
    }

    public void deleteValue(String r100, Expression r101, OrderingTerm r102, int r103, int r104) throws WCDBException {
        deleteValue(new StatementDelete().deleteFrom(r100).where(r101).orderBy(new OrderingTerm[]{r102}).limit(r103).offset(r104));
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r100, String r101, OrderingTerm r102, int r103, int r104) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r100).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}).limit(r103).offset(r104));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r100, String r101, OrderingTerm r102, int r103, int r104) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}).limit(r103).offset(r104));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r100, String r101, OrderingTerm r102, int r103, int r104) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}).limit(r103).offset(r104));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r100, String r101, OrderingTerm r102, int r103, int r104) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}).limit(r103).offset(r104));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r100, String r101, OrderingTerm r102, int r103, int r104) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}).limit(r103).offset(r104));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r100, String r101, OrderingTerm r102, int r103, int r104) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}).limit(r103).offset(r104));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r100, String r101, OrderingTerm r102, int r103, int r104) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}).limit(r103).offset(r104));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r100, String r101, OrderingTerm r102, int r103, int r104) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).orderBy(new OrderingTerm[]{r102}).limit(r103).offset(r104));
    }

    public Value[] getOneRow(ResultColumnConvertible[] r100, String r101, Expression r102, OrderingTerm r103, int r104) throws WCDBException {
        return getOneRowFromStatement(new StatementSelect().select(r100).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}).limit(1).offset(r104));
    }

    public Value getValue(ResultColumnConvertible r100, String r101, Expression r102, OrderingTerm r103, int r104) throws WCDBException {
        return getValueFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}).limit(1).offset(r104));
    }

    public void updateRow(Value[] r100, Column[] r101, String r102, OrderingTerm r103, int r104) throws WCDBException {
        updateRow(r100, new StatementUpdate().update(r102).setColumnsToBindParameters(r101).orderBy(new OrderingTerm[]{r103}).limit(r104));
    }

    public void updateValue(Value r100, Column r101, String r110, OrderingTerm r111, int r112) throws WCDBException {
        if (r100 != null) goto L4;
        r100 = new Value();
    L4:
        updateRow(new Value[]{r100}, new Column[]{r101}, r110, r111, r112);
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r100, String r101, Expression r102, OrderingTerm r103, int r104) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r100).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}).limit(r104));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r100, String r101, Expression r102, OrderingTerm r103, int r104) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}).limit(r104));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r100, String r101, Expression r102, OrderingTerm r103, int r104) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}).limit(r104));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r100, String r101, Expression r102, OrderingTerm r103, int r104) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}).limit(r104));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r100, String r101, Expression r102, OrderingTerm r103, int r104) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}).limit(r104));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r100, String r101, Expression r102, OrderingTerm r103, int r104) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}).limit(r104));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r100, String r101, Expression r102, OrderingTerm r103, int r104) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}).limit(r104));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r100, String r101, Expression r102, OrderingTerm r103, int r104) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}).limit(r104));
    }

    public void updateValue(double r100, Column r110, String r111, OrderingTerm r112, int r113) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r110}, r111, r112, r113);
    }

    public void updateValue(int r100, Column r101, String r110, OrderingTerm r111, int r112) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r110, r111, r112);
    }

    public void updateValue(String r100, Column r101, String r110, OrderingTerm r111, int r112) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r110, r111, r112);
    }

    public void updateValue(byte[] r100, Column r101, String r110, OrderingTerm r111, int r112) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r110, r111, r112);
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r100, String r101, Expression r102, OrderingTerm r103, int r104, int r105) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r100).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}).limit(r104).offset(r105));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r100, String r101, Expression r102, OrderingTerm r103, int r104, int r110) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}).limit(r104).offset(r110));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r100, String r101, Expression r102, OrderingTerm r103, int r104, int r110) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}).limit(r104).offset(r110));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r100, String r101, Expression r102, OrderingTerm r103, int r104, int r110) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}).limit(r104).offset(r110));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r100, String r101, Expression r102, OrderingTerm r103, int r104, int r110) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}).limit(r104).offset(r110));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r100, String r101, Expression r102, OrderingTerm r103, int r104, int r110) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}).limit(r104).offset(r110));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r100, String r101, Expression r102, OrderingTerm r103, int r104, int r110) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}).limit(r104).offset(r110));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r100, String r101, Expression r102, OrderingTerm r103, int r104, int r110) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{r101}).where(r102).orderBy(new OrderingTerm[]{r103}).limit(r104).offset(r110));
    }

    public void updateRow(Value[] r100, Column[] r101, String r102, OrderingTerm r103, int r104, int r105) throws WCDBException {
        updateRow(r100, new StatementUpdate().update(r102).setColumnsToBindParameters(r101).orderBy(new OrderingTerm[]{r103}).limit(r104).offset(r105));
    }

    public void updateValue(Value r100, Column r110, String r111, Expression r112, OrderingTerm r113, int r114) throws WCDBException {
        if (r100 != null) goto L4;
        r100 = new Value();
    L4:
        updateRow(new Value[]{r100}, new Column[]{r110}, r111, r112, r113, r114);
    }

    public void updateRow(Value[] r100, Column[] r101, String r102, Expression r103, OrderingTerm r104, int r105) throws WCDBException {
        updateRow(r100, new StatementUpdate().update(r102).setColumnsToBindParameters(r101).where(r103).orderBy(new OrderingTerm[]{r104}).limit(r105));
    }

    public void updateValue(double r100, Column r110, String r111, Expression r112, OrderingTerm r113, int r114) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r110}, r111, r112, r113, r114);
    }

    public void updateValue(double r100, Column r110, String r111, OrderingTerm r112, int r113, int r114) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r110}, r111, r112, r113, r114);
    }

    public void updateValue(int r100, Column r110, String r111, Expression r112, OrderingTerm r113, int r114) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r110}, r111, r112, r113, r114);
    }

    public void updateValue(int r100, Column r110, String r111, OrderingTerm r112, int r113, int r114) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r110}, r111, r112, r113, r114);
    }

    public void updateValue(String r100, Column r110, String r111, Expression r112, OrderingTerm r113, int r114) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r110}, r111, r112, r113, r114);
    }

    public void updateValue(String r100, Column r110, String r111, OrderingTerm r112, int r113, int r114) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r110}, r111, r112, r113, r114);
    }

    public void updateValue(byte[] r100, Column r110, String r111, Expression r112, OrderingTerm r113, int r114) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r110}, r111, r112, r113, r114);
    }

    public void updateValue(byte[] r100, Column r110, String r111, OrderingTerm r112, int r113, int r114) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r110}, r111, r112, r113, r114);
    }

    public void updateValue(Value r100, Column r110, String r111, OrderingTerm r112, int r113, int r114) throws WCDBException {
        updateRow(new Value[]{r100}, new Column[]{r110}, r111, r112, r113, r114);
    }

    public void updateRow(Value[] r100, Column[] r101, String r102, Expression r103, OrderingTerm r104, int r105, int r106) throws WCDBException {
        updateRow(r100, new StatementUpdate().update(r102).setColumnsToBindParameters(r101).where(r103).orderBy(new OrderingTerm[]{r104}).limit(r105).offset(r106));
    }

    public void updateValue(double r110, Column r111, String r112, Expression r113, OrderingTerm r114, int r115, int r116) throws WCDBException {
        updateRow(new Value[]{new Value(r110)}, new Column[]{r111}, r112, r113, r114, r115, r116);
    }

    public void updateValue(int r110, Column r111, String r112, Expression r113, OrderingTerm r114, int r115, int r116) throws WCDBException {
        updateRow(new Value[]{new Value(r110)}, new Column[]{r111}, r112, r113, r114, r115, r116);
    }

    public void updateValue(String r110, Column r111, String r112, Expression r113, OrderingTerm r114, int r115, int r116) throws WCDBException {
        updateRow(new Value[]{new Value(r110)}, new Column[]{r111}, r112, r113, r114, r115, r116);
    }

    public void updateValue(byte[] r110, Column r111, String r112, Expression r113, OrderingTerm r114, int r115, int r116) throws WCDBException {
        updateRow(new Value[]{new Value(r110)}, new Column[]{r111}, r112, r113, r114, r115, r116);
    }

    public void updateValue(Value r110, Column r111, String r112, Expression r113, OrderingTerm r114, int r115, int r116) throws WCDBException {
        updateRow(new Value[]{r110}, new Column[]{r111}, r112, r113, r114, r115, r116);
    }
}
