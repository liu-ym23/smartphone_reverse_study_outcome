package com.tencent.wcdb.chaincall;

import com.tencent.wcdb.base.WCDBException;
import com.tencent.wcdb.core.Handle;
import com.tencent.wcdb.winq.Statement;

/* JADX INFO: loaded from: classes38.dex */
public class ChainCall<T extends Statement> {
    boolean autoInvalidateHandle;
    int changes;
    Handle handle;
    boolean needChanges;
    T statement;

    public void invalidateHandle() {
        if (this.autoInvalidateHandle == false) goto L6;
        this.handle.invalidate();
        return;
    }

    public void updateChanges() throws WCDBException {
        if (this.needChanges == false) goto L6;
        this.changes = this.handle.getChanges();
        return;
    }

    public int getChanges() {
        return this.changes;
    }

    public T getStatement() {
        return this.statement;
    }

    public ChainCall(Handle r100, boolean r101, boolean r102) {
        this.changes = 0;
        this.handle = r100;
        this.needChanges = r101;
        this.autoInvalidateHandle = r102;
    }
}
