package net.sqlcipher;

import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes42.dex */
public final class BulkCursorToCursorAdaptor extends AbstractWindowedCursor {
    private static final String TAG = "BulkCursor";
    private IBulkCursor mBulkCursor;
    private String[] mColumns;
    private int mCount;
    private AbstractCursor.SelfContentObserver mObserverBridge;
    private boolean mWantsAllOnMoveCalls;

    @Override // net.sqlcipher.AbstractWindowedCursor, net.sqlcipher.AbstractCursor, android.database.Cursor
    public void copyStringToBuffer(int r100, CharArrayBuffer r101) {
    }

    public synchronized IContentObserver getObserver() {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (this.mObserverBridge != null) goto L6;
        this.mObserverBridge = new AbstractCursor.SelfContentObserver(this);     // Catch: Throwable -> L9
    L6:
        monitor-exit(this);
        return null;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void registerContentObserver(ContentObserver r100) {
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void registerDataSetObserver(DataSetObserver r100) {
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public boolean requery() {
        int r100 = this.mBulkCursor.requery(getObserver(), new CursorWindow(false));     // Catch: Exception -> L9
        this.mCount = r100;     // Catch: Exception -> L9
        if (r100 == (-1)) goto L7;
        this.mPos = -1;     // Catch: Exception -> L9
        this.mWindow = null;     // Catch: Exception -> L9
        super.requery();     // Catch: Exception -> L9
        return true;
    L7:
        deactivate();     // Catch: Exception -> L9
        return false;
    L9:
        e = move-exception;
        e.getMessage();
        deactivate();
        return false;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void unregisterContentObserver(ContentObserver r100) {
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver r100) {
    }

    @Override // net.sqlcipher.AbstractCursor
    public boolean deleteRow() {
        boolean r100 = this.mBulkCursor.deleteRow(this.mPos);     // Catch: RemoteException -> L10
        if (r100 == false) goto L9;
        this.mWindow = null;     // Catch: RemoteException -> L10
        int r101 = this.mBulkCursor.count();     // Catch: RemoteException -> L10
        this.mCount = r101;     // Catch: RemoteException -> L10
        int r102 = this.mPos;     // Catch: RemoteException -> L10
        if (r102 >= r101) goto L7;
        this.mPos = -1;     // Catch: RemoteException -> L10
        moveToPosition(r102);     // Catch: RemoteException -> L10
    L8:
        onChange(true);     // Catch: RemoteException -> L10
        goto L9
    L7:
        this.mPos = r101;     // Catch: RemoteException -> L10
    L9:
        return r100;
    L10:
        return false;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        if (this.mColumns != null) goto L9;
        this.mColumns = this.mBulkCursor.getColumnNames();     // Catch: RemoteException -> L6
    L6:
        return null;
    L9:
        return this.mColumns;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public Bundle getExtras() {
        return this.mBulkCursor.getExtras();
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        this.mBulkCursor.close();     // Catch: RemoteException -> L6
    L4:
        this.mWindow = null;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void deactivate() {
        super.deactivate();
        this.mBulkCursor.deactivate();     // Catch: RemoteException -> L6
    L4:
        this.mWindow = null;
    }

    public BulkCursorToCursorAdaptor() {
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getCount() {
        return this.mCount;
    }

    public static int findRowIdColumnIndex(String[] r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (r100[r102].equals(DBDefinition.ID) == true) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return r102;
    L8:
        return -1;
    }

    @Override // net.sqlcipher.AbstractCursor
    public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> r100) {
        if (supportsUpdates() == true) goto L5;
        return false;
    L5:
        HashMap<Long, Map<String, Object>> r101 = this.mUpdatedRows;
        monitor-enter(r101);
        if (r100 == null) goto L10;
        this.mUpdatedRows.putAll(r100);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    L10:
        if (this.mUpdatedRows.size() > 0) goto L23;
        monitor-exit(r101);     // Catch: Throwable -> L20
        return false;
    L23:
        boolean r102 = this.mBulkCursor.updateRows(this.mUpdatedRows);     // Catch: RemoteException -> L18 Throwable -> L20
        if (r102 != true) goto L16;
        this.mUpdatedRows.clear();     // Catch: RemoteException -> L18 Throwable -> L20
        onChange(true);     // Catch: RemoteException -> L18 Throwable -> L20
    L16:
        monitor-exit(r101);     // Catch: Throwable -> L20
        return r102;
    L19:
        return false;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public Bundle respond(Bundle r100) {
        return this.mBulkCursor.respond(r100);
    L5:
        return Bundle.EMPTY;
    }

    public void set(IBulkCursor r100) {
        this.mBulkCursor = r100;
        this.mCount = r100.count();     // Catch: RemoteException -> L5
        this.mWantsAllOnMoveCalls = this.mBulkCursor.getWantsAllOnMoveCalls();     // Catch: RemoteException -> L5
        String[] r101 = this.mBulkCursor.getColumnNames();     // Catch: RemoteException -> L5
        this.mColumns = r101;     // Catch: RemoteException -> L5
        this.mRowIdColumnIndex = findRowIdColumnIndex(r101);     // Catch: RemoteException -> L5
        return;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.CrossProcessCursor
    public boolean onMove(int r100, int r101) {
        CursorWindow r102 = this.mWindow;     // Catch: RemoteException -> L20
        if (r102 != null) goto L6;
        this.mWindow = this.mBulkCursor.getWindow(r101);     // Catch: RemoteException -> L20
    L16:
        if (this.mWindow != null) goto L18;
        return false;
    L18:
        return true;
    L6:
        if (r101 >= r102.getStartPosition()) goto L8;
    L13:
        this.mWindow = this.mBulkCursor.getWindow(r101);     // Catch: RemoteException -> L20
        goto L16
    L8:
        if (r101 >= (this.mWindow.getStartPosition() + this.mWindow.getNumRows())) goto L13;
        if (this.mWantsAllOnMoveCalls == false) goto L16;
        this.mBulkCursor.onMove(r101);     // Catch: RemoteException -> L20
        goto L16
    L22:
        return false;
    }

    public void set(IBulkCursor r100, int r101, int r102) {
        this.mBulkCursor = r100;
        this.mColumns = null;
        this.mCount = r101;
        this.mRowIdColumnIndex = r102;
    }
}
