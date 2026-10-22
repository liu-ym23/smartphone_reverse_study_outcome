package com.tencent.wcdb.core;

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
public class TableOperation {
    Database database;
    String tableName;

    public void deleteValue() throws WCDBException {
        deleteValue(new StatementDelete().deleteFrom(this.tableName));
    }

    public TableOperation() {
        this.tableName = null;
        this.database = null;
    }

    public Database getDatabase() {
        return this.database;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void deleteValue(Expression r100) throws WCDBException {
        deleteValue(new StatementDelete().deleteFrom(this.tableName).where(r100));
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r100) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r100).from(new String[]{this.tableName}));
    }

    public List<Value[]> getAllRowsFromStatement(Statement r100) throws WCDBException {
        Handle r101 = this.database.getHandle(false);
        PreparedStatement r102 = r101.preparedWithMainStatement(r100);     // Catch: Throwable -> L9
        List<Value[]> r103 = r102.getMultiRows();     // Catch: Throwable -> L7
        r102.finalizeStatement();
        r101.invalidate();
        return r103;
    L7:
        th = th;
    L11:
        if (r102 == null) goto L13;
        r102.finalizeStatement();
    L13:
        r101.invalidate();
        throw th;
    L9:
        th = th;
        r102 = null;
        goto L11
    }

    public List<Value> getOneColumn(ResultColumnConvertible r100) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r100) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}));
    }

    public List<byte[]> getOneColumnBLOBFromStatement(Statement r100) throws WCDBException {
        Handle r101 = this.database.getHandle(false);
        PreparedStatement r102 = r101.preparedWithMainStatement(r100);     // Catch: Throwable -> L9
        List<byte[]> r103 = r102.getOneColumnBLOB();     // Catch: Throwable -> L7
        r102.finalizeStatement();
        r101.invalidate();
        return r103;
    L7:
        th = th;
    L11:
        if (r102 == null) goto L13;
        r102.finalizeStatement();
    L13:
        r101.invalidate();
        throw th;
    L9:
        th = th;
        r102 = null;
        goto L11
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r100) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}));
    }

    public List<Double> getOneColumnDoubleFromStatement(Statement r100) throws WCDBException {
        Handle r101 = this.database.getHandle(false);
        PreparedStatement r102 = r101.preparedWithMainStatement(r100);     // Catch: Throwable -> L9
        List<Double> r103 = r102.getOneColumnDouble();     // Catch: Throwable -> L7
        r102.finalizeStatement();
        r101.invalidate();
        return r103;
    L7:
        th = th;
    L11:
        if (r102 == null) goto L13;
        r102.finalizeStatement();
    L13:
        r101.invalidate();
        throw th;
    L9:
        th = th;
        r102 = null;
        goto L11
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r100) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}));
    }

    public List<Float> getOneColumnFloatFromStatement(Statement r100) throws WCDBException {
        Handle r101 = this.database.getHandle(false);
        PreparedStatement r102 = r101.preparedWithMainStatement(r100);     // Catch: Throwable -> L9
        List<Float> r103 = r102.getOneColumnFloat();     // Catch: Throwable -> L7
        r102.finalizeStatement();
        r101.invalidate();
        return r103;
    L7:
        th = th;
    L11:
        if (r102 == null) goto L13;
        r102.finalizeStatement();
    L13:
        r101.invalidate();
        throw th;
    L9:
        th = th;
        r102 = null;
        goto L11
    }

    public List<Value> getOneColumnFromStatement(Statement r100) throws WCDBException {
        Handle r101 = this.database.getHandle(false);
        PreparedStatement r102 = r101.preparedWithMainStatement(r100);     // Catch: Throwable -> L9
        List<Value> r103 = r102.getOneColumn();     // Catch: Throwable -> L7
        r102.finalizeStatement();
        r101.invalidate();
        return r103;
    L7:
        th = th;
    L11:
        if (r102 == null) goto L13;
        r102.finalizeStatement();
    L13:
        r101.invalidate();
        throw th;
    L9:
        th = th;
        r102 = null;
        goto L11
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r100) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}));
    }

    public List<Integer> getOneColumnIntFromStatement(Statement r100) throws WCDBException {
        Handle r101 = this.database.getHandle(false);
        PreparedStatement r102 = r101.preparedWithMainStatement(r100);     // Catch: Throwable -> L9
        List<Integer> r103 = r102.getOneColumnInt();     // Catch: Throwable -> L7
        r102.finalizeStatement();
        r101.invalidate();
        return r103;
    L7:
        th = th;
    L11:
        if (r102 == null) goto L13;
        r102.finalizeStatement();
    L13:
        r101.invalidate();
        throw th;
    L9:
        th = th;
        r102 = null;
        goto L11
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r100) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}));
    }

    public List<Long> getOneColumnLongFromStatement(Statement r100) throws WCDBException {
        Handle r101 = this.database.getHandle(false);
        PreparedStatement r102 = r101.preparedWithMainStatement(r100);     // Catch: Throwable -> L9
        List<Long> r103 = r102.getOneColumnLong();     // Catch: Throwable -> L7
        r102.finalizeStatement();
        r101.invalidate();
        return r103;
    L7:
        th = th;
    L11:
        if (r102 == null) goto L13;
        r102.finalizeStatement();
    L13:
        r101.invalidate();
        throw th;
    L9:
        th = th;
        r102 = null;
        goto L11
    }

    public List<String> getOneColumnString(ResultColumnConvertible r100) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}));
    }

    public List<String> getOneColumnStringFromStatement(Statement r100) throws WCDBException {
        Handle r101 = this.database.getHandle(false);
        PreparedStatement r102 = r101.preparedWithMainStatement(r100);     // Catch: Throwable -> L9
        List<String> r103 = r102.getOneColumnString();     // Catch: Throwable -> L7
        r102.finalizeStatement();
        r101.invalidate();
        return r103;
    L7:
        th = th;
    L11:
        if (r102 == null) goto L13;
        r102.finalizeStatement();
    L13:
        r101.invalidate();
        throw th;
    L9:
        th = th;
        r102 = null;
        goto L11
    }

    public Value[] getOneRow(ResultColumnConvertible[] r100) throws WCDBException {
        return getOneRowFromStatement(new StatementSelect().select(r100).from(new String[]{this.tableName}));
    }

    public Value[] getOneRowFromStatement(Statement r100) throws WCDBException {
        Handle r101 = this.database.getHandle(false);
        Value[] r102 = null;
        PreparedStatement r103 = r101.preparedWithMainStatement(r100);     // Catch: Throwable -> L11
        r103.step();     // Catch: Throwable -> L9
        if (r103.isDone() == true) goto L7;
        r102 = r103.getOneRow();     // Catch: Throwable -> L9
    L7:
        r103.finalizeStatement();
        r101.invalidate();
        return r102;
    L9:
        Throwable th10 = th;
    L13:
        if (r103 == null) goto L15;
        r103.finalizeStatement();
    L15:
        r101.invalidate();
        throw th10;
    L11:
        th = move-exception;
        th10 = th;
        r103 = null;
        goto L13
    }

    public Value getValue(ResultColumnConvertible r100) throws WCDBException {
        return getValueFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}));
    }

    public Value getValueFromStatement(Statement r100) throws WCDBException {
        Handle r101 = this.database.getHandle(false);
        PreparedStatement r102 = null;
        Value r103 = null;
        PreparedStatement r104 = r101.preparedWithMainStatement(r100);     // Catch: Throwable -> L11
        r104.step();     // Catch: Throwable -> L9
        if (r104.isDone() == true) goto L7;
        r103 = r104.getValue(0);     // Catch: Throwable -> L9
    L7:
        r104.finalizeStatement();
        r101.invalidate();
        return r103;
    L9:
        th = th;
        r102 = r104;
    L12:
        if (r102 == null) goto L14;
        r102.finalizeStatement();
    L14:
        r101.invalidate();
        throw th;
    L11:
        th = th;
        goto L12
    }

    private void deleteValue(StatementDelete r100) throws WCDBException {
        Handle r101 = this.database.getHandle(true);
        r101.execute(r100);     // Catch: Throwable -> L6
        r101.invalidate();
        return;
    L6:
        th = move-exception;
        r101.invalidate();
        throw th;
    }

    private void updateRow(Value[] r100, StatementUpdate r101) throws WCDBException {
        Handle r102 = this.database.getHandle(true);
        PreparedStatement r103 = r102.preparedWithMainStatement(r101);     // Catch: Throwable -> L9
        r103.bindRow(r100);     // Catch: Throwable -> L7
        r103.step();     // Catch: Throwable -> L7
        r103.finalizeStatement();
        r102.invalidate();
        return;
    L7:
        th = th;
    L11:
        if (r103 == null) goto L13;
        r103.finalizeStatement();
    L13:
        r102.invalidate();
        throw th;
    L9:
        th = th;
        r103 = null;
        goto L11
    }

    public void deleteValue(OrderingTerm r100, int r101) throws WCDBException {
        deleteValue(new StatementDelete().deleteFrom(this.tableName).orderBy(new OrderingTerm[]{r100}).limit(r101));
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r100, OrderingTerm r101) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r100).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r100, OrderingTerm r101) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r100, OrderingTerm r101) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r100, OrderingTerm r101) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r100, OrderingTerm r101) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r100, OrderingTerm r101) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r100, OrderingTerm r101) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r100, OrderingTerm r101) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}));
    }

    public Value[] getOneRow(ResultColumnConvertible[] r100, OrderingTerm r101) throws WCDBException {
        return getOneRowFromStatement(new StatementSelect().select(r100).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}));
    }

    public Value getValue(ResultColumnConvertible r100, OrderingTerm r101) throws WCDBException {
        return getValueFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}));
    }

    public void insertOrIgnoreRow(Value[] r100, Column[] r101) throws WCDBException {
        insertOrIgnoreRows(Collections.singleton(r100), r101);
    }

    public void insertOrIgnoreRows(Collection<Value[]> r100, Column[] r101) throws WCDBException {
        insertRows(r100, r101, ConflictAction.Ignore);
    }

    public void insertOrReplaceRow(Value[] r100, Column[] r101) throws WCDBException {
        insertOrReplaceRows(Collections.singleton(r100), r101);
    }

    public void insertOrReplaceRows(Collection<Value[]> r100, Column[] r101) throws WCDBException {
        insertRows(r100, r101, ConflictAction.Replace);
    }

    public void insertRow(Value[] r100, Column[] r101) throws WCDBException {
        insertRows(Collections.singleton(r100), r101);
    }

    public void insertRows(Collection<Value[]> r100, Column[] r101) throws WCDBException {
        insertRows(r100, r101, ConflictAction.None);
    }

    public void updateValue(double r100, Column r101) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101});
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r100, Expression r101) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r100).from(new String[]{this.tableName}).where(r101));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r100, Expression r101) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r100, Expression r101) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r100, Expression r101) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r100, Expression r101) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r100, Expression r101) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r100, Expression r101) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r100, Expression r101) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101));
    }

    public Value[] getOneRow(ResultColumnConvertible[] r100, Expression r101) throws WCDBException {
        return getOneRowFromStatement(new StatementSelect().select(r100).from(new String[]{this.tableName}).where(r101));
    }

    public Value getValue(ResultColumnConvertible r100, Expression r101) throws WCDBException {
        return getValueFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101));
    }

    public void updateRow(Value[] r100, Column[] r101) throws WCDBException {
        updateRow(r100, new StatementUpdate().update(this.tableName).setColumnsToBindParameters(r101));
    }

    public void updateValue(float r100, Column r101) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101});
    }

    public void updateValue(int r100, Column r101) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101});
    }

    public void updateValue(long r100, Column r101) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101});
    }

    public void updateValue(String r100, Column r101) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101});
    }

    public void updateValue(byte[] r100, Column r101) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101});
    }

    public void updateValue(Value r100, Column r101) throws WCDBException {
        updateRow(new Value[]{r100}, new Column[]{r101});
    }

    private void insertRows(final Collection<Value[]> r100, Column[] r101, ConflictAction r102) throws WCDBException {
        final StatementInsert r103 = new StatementInsert().insertInto(this.tableName).columns(r101).valuesWithBindParameters(r101.length);
        if (r102 != ConflictAction.Replace) goto L6;
        r103.orReplace();
    L8:
        Handle r104 = this.database.getHandle(true);
    L15:
        th = move-exception;
        r104.invalidate();
        throw th;
    L10:
        if (r100.size() <= 1) goto L12;
        r104.runTransaction(new AnonymousClass1(this, r100, r103));     // Catch: Throwable -> L15
    L13:
        r104.invalidate();
        return;
    L12:
        insertRows(r100, r103, r104);     // Catch: Throwable -> L15
        goto L13
    L6:
        if (r102 != ConflictAction.Ignore) goto L8;
        r103.orIgnore();
        goto L8
    }

    public void deleteValue(OrderingTerm r100, int r101, int r102) throws WCDBException {
        deleteValue(new StatementDelete().deleteFrom(this.tableName).orderBy(new OrderingTerm[]{r100}).limit(r101).offset(r102));
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r100, OrderingTerm r101, int r102) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r100).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}).limit(r102));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r100, OrderingTerm r101, int r102) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}).limit(r102));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r100, OrderingTerm r101, int r102) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}).limit(r102));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r100, OrderingTerm r101, int r102) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}).limit(r102));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r100, OrderingTerm r101, int r102) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}).limit(r102));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r100, OrderingTerm r101, int r102) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}).limit(r102));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r100, OrderingTerm r101, int r102) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}).limit(r102));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r100, OrderingTerm r101, int r102) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}).limit(r102));
    }

    public Value[] getOneRow(ResultColumnConvertible[] r100, OrderingTerm r101, int r102) throws WCDBException {
        return getOneRowFromStatement(new StatementSelect().select(r100).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}).limit(1).offset(r102));
    }

    public Value getValue(ResultColumnConvertible r100, OrderingTerm r101, int r102) throws WCDBException {
        return getValueFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}).limit(1).offset(r102));
    }

    public void updateRow(Value[] r100, Column[] r101, Expression r102) throws WCDBException {
        updateRow(r100, new StatementUpdate().update(this.tableName).setColumnsToBindParameters(r101).where(r102));
    }

    public void updateValue(double r100, Column r101, Expression r102) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r102);
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

    public void deleteValue(Expression r100, OrderingTerm r101, int r102) throws WCDBException {
        deleteValue(new StatementDelete().deleteFrom(this.tableName).where(r100).orderBy(new OrderingTerm[]{r101}).limit(r102));
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r100, Expression r101, OrderingTerm r102) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r100).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r100, Expression r101, OrderingTerm r102) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r100, Expression r101, OrderingTerm r102) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r100, Expression r101, OrderingTerm r102) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r100, Expression r101, OrderingTerm r102) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r100, Expression r101, OrderingTerm r102) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r100, Expression r101, OrderingTerm r102) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r100, Expression r101, OrderingTerm r102) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}));
    }

    public Value[] getOneRow(ResultColumnConvertible[] r100, Expression r101, OrderingTerm r102) throws WCDBException {
        return getOneRowFromStatement(new StatementSelect().select(r100).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}));
    }

    public Value getValue(ResultColumnConvertible r100, Expression r101, OrderingTerm r102) throws WCDBException {
        return getValueFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}));
    }

    public void updateValue(float r100, Column r101, Expression r102) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r102);
    }

    public void updateValue(int r100, Column r101, Expression r102) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r102);
    }

    public void updateValue(long r100, Column r101, Expression r102) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r102);
    }

    public void updateValue(String r100, Column r101, Expression r102) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r102);
    }

    public void updateValue(byte[] r100, Column r101, Expression r102) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r102);
    }

    public void updateValue(Value r100, Column r101, Expression r102) throws WCDBException {
        updateRow(new Value[]{r100}, new Column[]{r101}, r102);
    }

    public static /* synthetic */ void access$000(TableOperation r100, Collection r101, StatementInsert r102, Handle r103) throws WCDBException {
        r100.insertRows(r101, r102, r103);
    }

    public void deleteValue(Expression r100, OrderingTerm r101, int r102, int r103) throws WCDBException {
        deleteValue(new StatementDelete().deleteFrom(this.tableName).where(r100).orderBy(new OrderingTerm[]{r101}).limit(r102).offset(r103));
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r100, OrderingTerm r101, int r102, int r103) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r100).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}).limit(r102).offset(r103));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r100, OrderingTerm r101, int r102, int r103) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}).limit(r102).offset(r103));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r100, OrderingTerm r101, int r102, int r103) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}).limit(r102).offset(r103));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r100, OrderingTerm r101, int r102, int r103) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}).limit(r102).offset(r103));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r100, OrderingTerm r101, int r102, int r103) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}).limit(r102).offset(r103));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r100, OrderingTerm r101, int r102, int r103) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}).limit(r102).offset(r103));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r100, OrderingTerm r101, int r102, int r103) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}).limit(r102).offset(r103));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r100, OrderingTerm r101, int r102, int r103) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).orderBy(new OrderingTerm[]{r101}).limit(r102).offset(r103));
    }

    public Value[] getOneRow(ResultColumnConvertible[] r100, Expression r101, OrderingTerm r102, int r103) throws WCDBException {
        return getOneRowFromStatement(new StatementSelect().select(r100).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}).limit(1).offset(r103));
    }

    public Value getValue(ResultColumnConvertible r100, Expression r101, OrderingTerm r102, int r103) throws WCDBException {
        return getValueFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}).limit(1).offset(r103));
    }

    public void updateRow(Value[] r100, Column[] r101, OrderingTerm r102, int r103) throws WCDBException {
        updateRow(r100, new StatementUpdate().update(this.tableName).setColumnsToBindParameters(r101).orderBy(new OrderingTerm[]{r102}).limit(r103));
    }

    public void updateValue(double r100, Column r101, OrderingTerm r102, int r103) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r102, r103);
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r100, Expression r101, OrderingTerm r102, int r103) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r100).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}).limit(r103));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r100, Expression r101, OrderingTerm r102, int r103) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}).limit(r103));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r100, Expression r101, OrderingTerm r102, int r103) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}).limit(r103));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r100, Expression r101, OrderingTerm r102, int r103) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}).limit(r103));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r100, Expression r101, OrderingTerm r102, int r103) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}).limit(r103));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r100, Expression r101, OrderingTerm r102, int r103) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}).limit(r103));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r100, Expression r101, OrderingTerm r102, int r103) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}).limit(r103));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r100, Expression r101, OrderingTerm r102, int r103) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}).limit(r103));
    }

    public void updateValue(float r100, Column r101, OrderingTerm r102, int r103) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r102, r103);
    }

    public void updateValue(int r100, Column r101, OrderingTerm r102, int r103) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r102, r103);
    }

    public void updateValue(long r100, Column r101, OrderingTerm r102, int r103) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r102, r103);
    }

    public void updateValue(String r100, Column r101, OrderingTerm r102, int r103) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r102, r103);
    }

    public void updateValue(byte[] r100, Column r101, OrderingTerm r102, int r103) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r102, r103);
    }

    public void updateValue(Value r100, Column r101, OrderingTerm r102, int r103) throws WCDBException {
        updateRow(new Value[]{r100}, new Column[]{r101}, r102, r103);
    }

    public List<Value[]> getAllRows(ResultColumnConvertible[] r100, Expression r101, OrderingTerm r102, int r103, int r104) throws WCDBException {
        return getAllRowsFromStatement(new StatementSelect().select(r100).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}).limit(r103).offset(r104));
    }

    public List<Value> getOneColumn(ResultColumnConvertible r100, Expression r101, OrderingTerm r102, int r103, int r104) throws WCDBException {
        return getOneColumnFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}).limit(r103).offset(r104));
    }

    public List<byte[]> getOneColumnBLOB(ResultColumnConvertible r100, Expression r101, OrderingTerm r102, int r103, int r104) throws WCDBException {
        return getOneColumnBLOBFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}).limit(r103).offset(r104));
    }

    public List<Double> getOneColumnDouble(ResultColumnConvertible r100, Expression r101, OrderingTerm r102, int r103, int r104) throws WCDBException {
        return getOneColumnDoubleFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}).limit(r103).offset(r104));
    }

    public List<Float> getOneColumnFloat(ResultColumnConvertible r100, Expression r101, OrderingTerm r102, int r103, int r104) throws WCDBException {
        return getOneColumnFloatFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}).limit(r103).offset(r104));
    }

    public List<Integer> getOneColumnInt(ResultColumnConvertible r100, Expression r101, OrderingTerm r102, int r103, int r104) throws WCDBException {
        return getOneColumnIntFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}).limit(r103).offset(r104));
    }

    public List<Long> getOneColumnLong(ResultColumnConvertible r100, Expression r101, OrderingTerm r102, int r103, int r104) throws WCDBException {
        return getOneColumnLongFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}).limit(r103).offset(r104));
    }

    public List<String> getOneColumnString(ResultColumnConvertible r100, Expression r101, OrderingTerm r102, int r103, int r104) throws WCDBException {
        return getOneColumnStringFromStatement(new StatementSelect().select(new ResultColumnConvertible[]{r100}).from(new String[]{this.tableName}).where(r101).orderBy(new OrderingTerm[]{r102}).limit(r103).offset(r104));
    }

    public void updateRow(Value[] r100, Column[] r101, OrderingTerm r102, int r103, int r104) throws WCDBException {
        updateRow(r100, new StatementUpdate().update(this.tableName).setColumnsToBindParameters(r101).orderBy(new OrderingTerm[]{r102}).limit(r103).offset(r104));
    }

    public void updateValue(double r100, Column r110, Expression r111, OrderingTerm r112, int r113) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r110}, r111, r112, r113);
    }

    public void updateRow(Value[] r100, Column[] r101, Expression r102, OrderingTerm r103, int r104) throws WCDBException {
        updateRow(r100, new StatementUpdate().update(this.tableName).setColumnsToBindParameters(r101).where(r102).orderBy(new OrderingTerm[]{r103}).limit(r104));
    }

    public void updateValue(double r100, Column r110, OrderingTerm r111, int r112, int r113) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r110}, r111, r112, r113);
    }

    public void updateValue(float r100, Column r101, Expression r110, OrderingTerm r111, int r112) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r110, r111, r112);
    }

    public void updateValue(float r100, Column r101, OrderingTerm r110, int r111, int r112) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r110, r111, r112);
    }

    public void updateValue(int r100, Column r101, Expression r110, OrderingTerm r111, int r112) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r110, r111, r112);
    }

    public void updateValue(int r100, Column r101, OrderingTerm r110, int r111, int r112) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r110, r111, r112);
    }

    public void updateValue(long r100, Column r110, Expression r111, OrderingTerm r112, int r113) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r110}, r111, r112, r113);
    }

    public void updateValue(long r100, Column r110, OrderingTerm r111, int r112, int r113) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r110}, r111, r112, r113);
    }

    public void updateValue(String r100, Column r101, Expression r110, OrderingTerm r111, int r112) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r110, r111, r112);
    }

    public void updateValue(String r100, Column r101, OrderingTerm r110, int r111, int r112) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r110, r111, r112);
    }

    public void updateValue(byte[] r100, Column r101, Expression r110, OrderingTerm r111, int r112) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r110, r111, r112);
    }

    public void updateValue(byte[] r100, Column r101, OrderingTerm r110, int r111, int r112) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r101}, r110, r111, r112);
    }

    public void updateValue(Value r100, Column r101, Expression r110, OrderingTerm r111, int r112) throws WCDBException {
        updateRow(new Value[]{r100}, new Column[]{r101}, r110, r111, r112);
    }

    public void updateValue(Value r100, Column r101, OrderingTerm r110, int r111, int r112) throws WCDBException {
        updateRow(new Value[]{r100}, new Column[]{r101}, r110, r111, r112);
    }

    public void updateRow(Value[] r100, Column[] r101, Expression r102, OrderingTerm r103, int r104, int r105) throws WCDBException {
        updateRow(r100, new StatementUpdate().update(this.tableName).setColumnsToBindParameters(r101).where(r102).orderBy(new OrderingTerm[]{r103}).limit(r104).offset(r105));
    }

    public void updateValue(double r100, Column r110, Expression r111, OrderingTerm r112, int r113, int r114) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r110}, r111, r112, r113, r114);
    }

    public void updateValue(float r100, Column r110, Expression r111, OrderingTerm r112, int r113, int r114) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r110}, r111, r112, r113, r114);
    }

    public void updateValue(int r100, Column r110, Expression r111, OrderingTerm r112, int r113, int r114) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r110}, r111, r112, r113, r114);
    }

    public void updateValue(long r100, Column r110, Expression r111, OrderingTerm r112, int r113, int r114) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r110}, r111, r112, r113, r114);
    }

    public void updateValue(String r100, Column r110, Expression r111, OrderingTerm r112, int r113, int r114) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r110}, r111, r112, r113, r114);
    }

    public void updateValue(byte[] r100, Column r110, Expression r111, OrderingTerm r112, int r113, int r114) throws WCDBException {
        updateRow(new Value[]{new Value(r100)}, new Column[]{r110}, r111, r112, r113, r114);
    }

    public void updateValue(Value r100, Column r110, Expression r111, OrderingTerm r112, int r113, int r114) throws WCDBException {
        updateRow(new Value[]{r100}, new Column[]{r110}, r111, r112, r113, r114);
    }
}
