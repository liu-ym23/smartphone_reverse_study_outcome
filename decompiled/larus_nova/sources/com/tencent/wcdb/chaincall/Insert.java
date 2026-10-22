package com.tencent.wcdb.chaincall;

import com.tencent.wcdb.base.WCDBException;
import com.tencent.wcdb.core.Handle;
import com.tencent.wcdb.core.PreparedStatement;
import com.tencent.wcdb.orm.Field;
import com.tencent.wcdb.orm.TableBinding;
import com.tencent.wcdb.winq.StatementInsert;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: classes38.dex */
public class Insert<T> extends ChainCall<StatementInsert> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private Field<T>[] fields;
    private boolean hasConflictAction;
    private long lastInsertRowId;
    private Collection<T> values;

    public Insert<T> orIgnore() {
        this.hasConflictAction = true;
        ((StatementInsert) this.statement).orIgnore();
        return this;
    }

    public Insert<T> orReplace() {
        this.hasConflictAction = true;
        ((StatementInsert) this.statement).orReplace();
        return this;
    }

    private void realExecute() throws WCDBException {
        TableBinding r100 = Field.getBinding(this.fields);
        PreparedStatement r101 = this.handle.preparedWithMainStatement(this.statement);
        this.lastInsertRowId = 0;
        Iterator<T> r102 = this.values.iterator();     // Catch: Throwable -> L30
    L5:
        if (r102.hasNext() == false) goto L25;
        T r103 = r102.next();     // Catch: Throwable -> L30
        r101.reset();     // Catch: Throwable -> L30
        int r104 = 0;
        int r105 = 1;
        if (this.hasConflictAction == false) goto L9;
    L11:
        boolean r106 = false;
    L12:
        Field<T>[] r107 = this.fields;     // Catch: Throwable -> L30
        int r108 = r107.length;     // Catch: Throwable -> L30
    L13:
        if (r104 >= r108) goto L21;
        Field<T> r109 = r107[r104];     // Catch: Throwable -> L30
        if (r106 == true) goto L17;
    L19:
        r100.bindField(r103, r109, r105, r101);     // Catch: Throwable -> L30
    L20:
        r105 = r105 + 1;     // Catch: Throwable -> L30
        r104 = r104 + 1;     // Catch: Throwable -> L30
        goto L13
    L17:
        if (r109.isAutoIncrement() == false) goto L19;
        r101.bindNull(r105);     // Catch: Throwable -> L30
        goto L20
    L21:
        r101.step();     // Catch: Throwable -> L30
        if (r106 == false) goto L5;
        r100.setLastInsertRowId(r103, this.handle.getLastInsertedRowId());     // Catch: Throwable -> L30
        goto L5
    L9:
        if (r100.isAutoIncrement(r103) == false) goto L11;
        r106 = true;
        goto L12
    L25:
        if (this.values.size() <= 0) goto L27;
        this.lastInsertRowId = this.handle.getLastInsertedRowId();     // Catch: Throwable -> L30
    L27:
        updateChanges();     // Catch: Throwable -> L30
        r101.finalizeStatement();
        return;
    L30:
        th = move-exception;
        r101.finalizeStatement();
        throw th;
    }

    public Insert<T> execute() throws WCDBException {
        if (this.values.size() != 0) goto L14;
        return this;
    L14:
    L11:
        th = move-exception;
        invalidateHandle();
        throw th;
    L6:
        if (this.values.size() <= 1) goto L8;
        this.handle.runTransaction(new AnonymousClass1(this));     // Catch: Throwable -> L11
    L9:
        invalidateHandle();
        return this;
    L8:
        realExecute();     // Catch: Throwable -> L11
        goto L9
    }

    static {
    }

    public long getLastInsertRowId() {
        return this.lastInsertRowId;
    }

    public static /* synthetic */ void access$000(Insert r100) throws WCDBException {
        r100.realExecute();
    }

    public Insert<T> intoTable(String r100) {
        ((StatementInsert) this.statement).insertInto(r100);
        return this;
    }

    @SafeVarargs
    public final Insert<T> onFields(Field<T>... r100) {
        this.fields = r100;
        ((StatementInsert) this.statement).columns(r100).valuesWithBindParameters(r100.length);
        return this;
    }

    public Insert<T> value(T r100) {
        this.values = Collections.singleton(r100);
        return this;
    }

    public Insert<T> values(Collection<T> r100) {
        this.values = r100;
        return this;
    }

    public Insert(Handle r100, boolean r101, boolean r102) {
        super(r100, r101, r102);
        this.hasConflictAction = false;
        this.fields = null;
        this.values = null;
        this.lastInsertRowId = 0;
        this.statement = new StatementInsert();
    }
}
