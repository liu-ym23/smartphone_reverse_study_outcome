package com.bytedance.ee.bear.lynx.impl.xbridge.method.cache;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: classes18.dex */
public final class f extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM lynx_cache_model";
    }

    public f(LynxCacheDatabase r100) {
        super(r100);
    }
}
