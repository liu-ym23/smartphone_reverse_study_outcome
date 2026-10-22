package com.commonsware.cwac.saferoom;

import android.util.SparseArray;
import androidx.sqlite.db.SupportSQLiteProgram;

/* JADX INFO: loaded from: classes22.dex */
class BindingsRecorder implements SupportSQLiteProgram {
    private SparseArray<Object> bindings;

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.bindings.clear();
    }

    public String[] getBindings() {
        String[] r100 = new String[this.bindings.size()];
        int r101 = 0;
    L4:
        if (r101 >= this.bindings.size()) goto L10;
        int r102 = this.bindings.keyAt(r101);
        if (this.bindings.get(r102) == null) goto L8;
        r100[r101] = this.bindings.get(r102).toString();
    L9:
        r101 = r101 + 1;
        goto L4
    L8:
        r100[r101] = "";
        goto L9
    L10:
        return r100;
    }

    public BindingsRecorder() {
        this.bindings = new SparseArray();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        clearBindings();
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int r100) {
        this.bindings.put(r100, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int r100, byte[] r101) {
        this.bindings.put(r100, r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int r100, double r101) {
        this.bindings.put(r100, Double.valueOf(r101));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int r100, long r101) {
        this.bindings.put(r100, Long.valueOf(r101));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int r100, String r101) {
        this.bindings.put(r100, r101);
    }
}
