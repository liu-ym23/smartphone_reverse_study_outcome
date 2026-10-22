package com.tencent.wcdb.chaincall;

import com.tencent.wcdb.base.WCDBException;
import com.tencent.wcdb.core.Handle;
import com.tencent.wcdb.core.PreparedStatement;
import com.tencent.wcdb.orm.Field;
import com.tencent.wcdb.winq.Expression;
import com.tencent.wcdb.winq.ExpressionConvertible;
import com.tencent.wcdb.winq.OrderingTerm;
import com.tencent.wcdb.winq.StatementSelect;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class Select<T> extends ChainCall<StatementSelect> {
    private Field<T>[] fields;

    private PreparedStatement prepareStatement() throws WCDBException {
        return this.handle.preparedWithMainStatement(this.statement);
    }

    public List<T> allObjects() throws WCDBException {
        return (List<T>) allObjects(Field.getBindClass(this.fields));
    }

    public T firstObject() throws WCDBException {
        return (T) firstObject(Field.getBindClass(this.fields));
    }

    public <R extends T> List<R> allObjects(Class<R> r100) throws WCDBException {
        PreparedStatement r101 = prepareStatement();     // Catch: Throwable -> L8
        List<R> r102 = r101.getAllObjects(this.fields, r100);     // Catch: Throwable -> L6
        r101.finalizeStatement();
        invalidateHandle();
        return r102;
    L6:
        th = th;
    L10:
        if (r101 == null) goto L12;
        r101.finalizeStatement();
    L12:
        invalidateHandle();
        throw th;
    L8:
        th = th;
        r101 = null;
        goto L10
    }

    public <R extends T> R firstObject(Class<R> r100) throws WCDBException {
        PreparedStatement r101 = (R) null;
        PreparedStatement r102 = prepareStatement();     // Catch: Throwable -> L11
        r102.step();     // Catch: Throwable -> L9
        Object r103 = r101;
        if (r102.isDone() == true) goto L7;
        r103 = (R) r102.getOneObject(this.fields, r100);
    L7:
        r102.finalizeStatement();
        invalidateHandle();
        return (R) r103;
    L9:
        th = th;
        r101 = (R) r102;
    L12:
        if (r101 == null) goto L14;
        r101.finalizeStatement();
    L14:
        invalidateHandle();
        throw th;
    L11:
        th = th;
        goto L12
    }

    public Select<T> from(String r100) {
        ((StatementSelect) this.statement).from(new String[]{r100});
        return this;
    }

    public Select<T> limit(long r100) {
        ((StatementSelect) this.statement).limit(r100);
        return this;
    }

    public Select<T> offset(long r100) {
        ((StatementSelect) this.statement).offset(r100);
        return this;
    }

    public Select<T> orderBy(OrderingTerm r100) {
        ((StatementSelect) this.statement).orderBy(new OrderingTerm[]{r100});
        return this;
    }

    @SafeVarargs
    public final Select<T> select(Field<T>... r100) {
        this.fields = r100;
        ((StatementSelect) this.statement).select(r100);
        return this;
    }

    public Select<T> where(Expression r100) {
        ((StatementSelect) this.statement).where(r100);
        return this;
    }

    public Select<T> limit(ExpressionConvertible r100) {
        ((StatementSelect) this.statement).limit(r100);
        return this;
    }

    public Select<T> offset(ExpressionConvertible r100) {
        ((StatementSelect) this.statement).offset(r100);
        return this;
    }

    public Select<T> orderBy(OrderingTerm... r100) {
        ((StatementSelect) this.statement).orderBy(r100);
        return this;
    }

    public Select(Handle r100, boolean r101, boolean r102) {
        super(r100, r101, r102);
        this.fields = null;
        this.statement = new StatementSelect();
    }
}
