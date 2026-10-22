package com.tencent.wcdb.chaincall;

import com.tencent.wcdb.base.Value;
import com.tencent.wcdb.base.WCDBException;
import com.tencent.wcdb.core.Handle;
import com.tencent.wcdb.core.PreparedStatement;
import com.tencent.wcdb.orm.Field;
import com.tencent.wcdb.winq.Expression;
import com.tencent.wcdb.winq.ExpressionConvertible;
import com.tencent.wcdb.winq.OrderingTerm;
import com.tencent.wcdb.winq.StatementUpdate;

/* JADX INFO: loaded from: classes38.dex */
public class Update<T> extends ChainCall<StatementUpdate> {
    private Field<T>[] fields;
    private T object;
    private Value[] row;

    public Update<T> execute() throws WCDBException {
        Field.getBinding(this.fields);
        PreparedStatement r100 = null;
        r100 = this.handle.preparedWithMainStatement(this.statement);     // Catch: Throwable -> L12
        T r101 = this.object;     // Catch: Throwable -> L12
        if (r101 == null) goto L6;
        r100.bindObject(r101, this.fields);     // Catch: Throwable -> L12
    L9:
        r100.step();     // Catch: Throwable -> L12
        updateChanges();     // Catch: Throwable -> L12
        r100.finalizeStatement();
        invalidateHandle();
        return this;
    L6:
        Value[] r102 = this.row;     // Catch: Throwable -> L12
        if (r102 == null) goto L9;
        r100.bindRow(r102);     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        if (r100 == null) goto L15;
        r100.finalizeStatement();
    L15:
        invalidateHandle();
        throw th;
    }

    public Update<T> limit(int r100) {
        ((StatementUpdate) this.statement).limit(r100);
        return this;
    }

    public Update<T> offset(int r100) {
        ((StatementUpdate) this.statement).offset(r100);
        return this;
    }

    public Update<T> orderBy(OrderingTerm r100) {
        ((StatementUpdate) this.statement).orderBy(new OrderingTerm[]{r100});
        return this;
    }

    @SafeVarargs
    public final Update<T> set(Field<T>... r100) {
        this.fields = r100;
        ((StatementUpdate) this.statement).setColumnsToBindParameters(r100);
        return this;
    }

    public Update<T> table(String r100) {
        ((StatementUpdate) this.statement).update(r100);
        return this;
    }

    public Update<T> toObject(T r100) {
        this.object = r100;
        return this;
    }

    public Update<T> toRow(Value... r100) {
        this.row = r100;
        return this;
    }

    public Update<T> toValue(byte r100) {
        return toRow(new Value[]{new Value(r100)});
    }

    public Update<T> where(Expression r100) {
        ((StatementUpdate) this.statement).where(r100);
        return this;
    }

    public Update<T> limit(short r100) {
        ((StatementUpdate) this.statement).limit(r100);
        return this;
    }

    public Update<T> offset(short r100) {
        ((StatementUpdate) this.statement).offset(r100);
        return this;
    }

    public Update<T> orderBy(OrderingTerm... r100) {
        ((StatementUpdate) this.statement).orderBy(r100);
        return this;
    }

    public Update<T> toValue(double r100) {
        return toRow(new Value[]{new Value(r100)});
    }

    public Update<T> limit(long r100) {
        ((StatementUpdate) this.statement).limit(r100);
        return this;
    }

    public Update<T> offset(long r100) {
        ((StatementUpdate) this.statement).offset(r100);
        return this;
    }

    public Update<T> toValue(float r100) {
        return toRow(new Value[]{new Value(r100)});
    }

    public Update<T> limit(ExpressionConvertible r100) {
        ((StatementUpdate) this.statement).limit(r100);
        return this;
    }

    public Update<T> offset(ExpressionConvertible r100) {
        ((StatementUpdate) this.statement).offset(r100);
        return this;
    }

    public Update<T> toValue(int r100) {
        return toRow(new Value[]{new Value(r100)});
    }

    public Update<T> toValue(long r100) {
        return toRow(new Value[]{new Value(r100)});
    }

    public Update<T> toValue(String r100) {
        return toRow(new Value[]{new Value(r100)});
    }

    public Update<T> toValue(short r100) {
        return toRow(new Value[]{new Value(r100)});
    }

    public Update<T> toValue(byte[] r100) {
        return toRow(new Value[]{new Value(r100)});
    }

    public Update<T> toValue(Value r100) {
        return toRow(new Value[]{r100});
    }

    public Update(Handle r100, boolean r101, boolean r102) {
        super(r100, r101, r102);
        this.fields = null;
        this.object = null;
        this.row = null;
        this.statement = new StatementUpdate();
    }
}
