package com.tencent.wcdb.chaincall;

import com.tencent.wcdb.base.WCDBException;
import com.tencent.wcdb.core.Handle;
import com.tencent.wcdb.winq.Expression;
import com.tencent.wcdb.winq.ExpressionConvertible;
import com.tencent.wcdb.winq.OrderingTerm;
import com.tencent.wcdb.winq.StatementDelete;

/* JADX INFO: loaded from: classes38.dex */
public class Delete extends ChainCall<StatementDelete> {
    public Delete execute() throws WCDBException {
        this.handle.execute(this.statement);     // Catch: Throwable -> L9
        updateChanges();     // Catch: Throwable -> L6
        invalidateHandle();
        return this;
    L6:
        th = move-exception;
        invalidateHandle();
        throw th;
    L9:
        th = move-exception;
        updateChanges();     // Catch: Throwable -> L13
        invalidateHandle();
        throw th;
    L13:
        th = move-exception;
        invalidateHandle();
        throw th;
    }

    public Delete fromTable(String r100) {
        ((StatementDelete) this.statement).deleteFrom(r100);
        return this;
    }

    public Delete limit(long r100) {
        ((StatementDelete) this.statement).limit(r100);
        return this;
    }

    public Delete offset(long r100) {
        ((StatementDelete) this.statement).offset(r100);
        return this;
    }

    public Delete orderBy(OrderingTerm... r100) {
        ((StatementDelete) this.statement).orderBy(r100);
        return this;
    }

    public Delete where(Expression r100) {
        ((StatementDelete) this.statement).where(r100);
        return this;
    }

    public Delete limit(ExpressionConvertible r100) {
        ((StatementDelete) this.statement).limit(r100);
        return this;
    }

    public Delete offset(ExpressionConvertible r100) {
        ((StatementDelete) this.statement).offset(r100);
        return this;
    }

    public Delete(Handle r100, boolean r101, boolean r102) {
        super(r100, r101, r102);
        this.statement = new StatementDelete();
    }
}
