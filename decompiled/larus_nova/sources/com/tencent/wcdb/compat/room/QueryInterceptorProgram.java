package com.tencent.wcdb.compat.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
final class QueryInterceptorProgram implements SupportSQLiteProgram {
    private List<Object> mBindArgsCache;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.mBindArgsCache.clear();
    }

    public QueryInterceptorProgram() {
        this.mBindArgsCache = new ArrayList();
    }

    public List<Object> getBindArgs() {
        return this.mBindArgsCache;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int r100) {
        saveArgsToCache(r100, null);
    }

    private void saveArgsToCache(int r100, Object r101) {
        int r102 = r100 - 1;
        if (r102 < this.mBindArgsCache.size()) goto L7;
        int r103 = this.mBindArgsCache.size();
    L5:
        if (r103 > r102) goto L7;
        this.mBindArgsCache.add(null);
        r103 = r103 + 1;
    L7:
        ListProtector.set(this.mBindArgsCache, r102, r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int r100, byte[] r101) {
        saveArgsToCache(r100, r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int r100, double r101) {
        saveArgsToCache(r100, Double.valueOf(r101));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int r100, long r101) {
        saveArgsToCache(r100, Long.valueOf(r101));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int r100, String r101) {
        saveArgsToCache(r100, r101);
    }
}
