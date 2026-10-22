package net.sqlcipher;

import android.database.CrossProcessCursor;

/* JADX INFO: loaded from: classes42.dex */
public class CrossProcessCursorWrapper extends CursorWrapper implements CrossProcessCursor {
    @Override // android.database.CrossProcessCursor
    public android.database.CursorWindow getWindow() {
        return null;
    }

    @Override // android.database.CrossProcessCursor
    public boolean onMove(int r100, int r101) {
        return true;
    }

    public CrossProcessCursorWrapper(Cursor r100) {
        super(r100);
    }

    @Override // android.database.CrossProcessCursor
    public void fillWindow(int r100, android.database.CursorWindow r101) {
        DatabaseUtils.cursorFillWindow(this, r100, r101);
    }
}
