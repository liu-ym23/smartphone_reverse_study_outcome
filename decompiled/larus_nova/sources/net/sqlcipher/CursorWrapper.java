package net.sqlcipher;

/* JADX INFO: loaded from: classes42.dex */
public class CursorWrapper extends android.database.CursorWrapper implements Cursor {
    private final Cursor mCursor;

    @Override // android.database.CursorWrapper
    public /* bridge */ /* synthetic */ android.database.Cursor getWrappedCursor() {
        return getWrappedCursor();
    }

    @Override // android.database.CursorWrapper
    public Cursor getWrappedCursor() {
        return this.mCursor;
    }

    public CursorWrapper(Cursor r100) {
        super(r100);
        this.mCursor = r100;
    }

    @Override // android.database.CursorWrapper, android.database.Cursor, net.sqlcipher.Cursor
    public int getType(int r100) {
        return this.mCursor.getType(r100);
    }
}
