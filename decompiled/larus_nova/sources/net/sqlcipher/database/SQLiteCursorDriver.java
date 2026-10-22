package net.sqlcipher.database;

import android.database.Cursor;

/* JADX INFO: loaded from: classes42.dex */
public interface SQLiteCursorDriver {
    void cursorClosed();

    void cursorDeactivated();

    void cursorRequeried(Cursor r100);

    net.sqlcipher.Cursor query(SQLiteDatabase.CursorFactory r100, String[] r101);

    void setBindArguments(String[] r100);
}
