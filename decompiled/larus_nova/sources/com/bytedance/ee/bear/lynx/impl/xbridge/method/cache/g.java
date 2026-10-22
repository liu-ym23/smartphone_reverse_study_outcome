package com.bytedance.ee.bear.lynx.impl.xbridge.method.cache;

import androidx.room.SharedSQLiteStatement;

/* JADX INFO: loaded from: classes18.dex */
public final class g extends SharedSQLiteStatement {
    @Override // androidx.room.SharedSQLiteStatement
    public final String createQuery() {
        return "DELETE FROM lynx_cache_model WHERE access_time<= ? ";
    }

    public g(LynxCacheDatabase r100) {
        super(r100);
    }
}
