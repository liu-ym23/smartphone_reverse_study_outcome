package net.sqlcipher;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import net.sqlcipher.database.SQLiteDatabase;

/* JADX INFO: loaded from: classes42.dex */
public final class DefaultDatabaseErrorHandler implements DatabaseErrorHandler {
    private final String TAG;

    public DefaultDatabaseErrorHandler() {
        this.TAG = "DefaultDatabaseErrorHandler";
    }

    private void deleteDatabaseFile(String r100) {
        if (r100.equalsIgnoreCase(SQLiteDatabase.MEMORY) == false) goto L5;
        return;
    L5:
        if (r100.trim().length() != 0) goto L13;
        return;
    L13:
        new PolarisFileWrapper(r100).delete();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        e.getMessage();
    }

    @Override // net.sqlcipher.DatabaseErrorHandler
    public void onCorruption(SQLiteDatabase r100) {
        r100.getPath();
        if (r100.isOpen() == true) goto L8;
    L5:
        deleteDatabaseFile(r100.getPath());
        return;
    L8:
        r100.close();     // Catch: Exception -> L7
        goto L5
    }
}
