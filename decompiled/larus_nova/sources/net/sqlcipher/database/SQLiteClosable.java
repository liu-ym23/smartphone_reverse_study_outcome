package net.sqlcipher.database;

/* JADX INFO: loaded from: classes42.dex */
public abstract class SQLiteClosable {
    private Object mLock;
    private int mReferenceCount;

    public abstract void onAllReferencesReleased();

    public void onAllReferencesReleasedFromContainer() {
    }

    private String getObjInfo() {
        StringBuilder r100 = new StringBuilder();
        r100.append(getClass().getName());
        r100.append(" (");
        if ((this instanceof SQLiteDatabase) == false) goto L6;
        r100.append("database = ");
        r100.append(((SQLiteDatabase) this).getPath());
    L12:
        r100.append(") ");
        return r100.toString();
    L6:
        if ((this instanceof SQLiteProgram) == false) goto L8;
    L11:
        r100.append("mSql = ");
        r100.append(((SQLiteProgram) this).mSql);
        goto L12
    L8:
        if ((this instanceof SQLiteStatement) == true) goto L11;
        if ((this instanceof SQLiteQuery) == false) goto L12;
        goto L11
    }

    public void acquireReference() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        int r101 = this.mReferenceCount;     // Catch: Throwable -> L11
        if (r101 <= 0) goto L10;
        this.mReferenceCount = r101 + 1;     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L10:
        throw new IllegalStateException("attempt to re-open an already-closed object: " + getObjInfo());     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public void releaseReference() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        int r101 = this.mReferenceCount - 1;     // Catch: Throwable -> L9
        this.mReferenceCount = r101;     // Catch: Throwable -> L9
        if (r101 != 0) goto L7;
        onAllReferencesReleased();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void releaseReferenceFromContainer() {
        Object r100 = this.mLock;
        monitor-enter(r100);
        int r101 = this.mReferenceCount - 1;     // Catch: Throwable -> L9
        this.mReferenceCount = r101;     // Catch: Throwable -> L9
        if (r101 != 0) goto L7;
        onAllReferencesReleasedFromContainer();     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public SQLiteClosable() {
        this.mReferenceCount = 1;
        this.mLock = new Object();
    }
}
