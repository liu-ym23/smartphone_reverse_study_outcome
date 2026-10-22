package net.sqlcipher;

import android.content.ContentResolver;
import android.database.CharArrayBuffer;
import android.database.ContentObservable;
import android.database.ContentObserver;
import android.database.CrossProcessCursor;
import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes42.dex */
public abstract class AbstractCursor implements CrossProcessCursor, Cursor {
    private static final String TAG = "Cursor";
    protected boolean mClosed;
    ContentObservable mContentObservable;
    protected ContentResolver mContentResolver;
    protected Long mCurrentRowID;
    DataSetObservable mDataSetObservable;
    private Bundle mExtras;
    private Uri mNotifyUri;
    protected int mPos;
    protected int mRowIdColumnIndex;
    private ContentObserver mSelfObserver;
    private final Object mSelfObserverLock;
    private boolean mSelfObserverRegistered;
    protected HashMap<Long, Map<String, Object>> mUpdatedRows;

    public static class SelfContentObserver extends ContentObserver {
        WeakReference<AbstractCursor> mCursor;

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return false;
        }

        public SelfContentObserver(AbstractCursor r100) {
            super(null);
            this.mCursor = new WeakReference(r100);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r100) {
            AbstractCursor r101 = this.mCursor.get();
            if (r101 == null) goto L6;
            r101.onChange(false);
            return;
        }
    }

    public void checkPosition() {
        if ((-1) == this.mPos) goto L8;
        if (getCount() == this.mPos) goto L8;
        return;
    L8:
        throw new CursorIndexOutOfBoundsException(this.mPos, getCount());
    }

    @Override // android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mClosed = true;
        this.mContentObservable.unregisterAll();
        deactivateInternal();
    }

    public boolean commitUpdates() {
        return commitUpdates(null);
    }

    public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> r100) {
        return false;
    }

    public boolean deleteRow() {
        return false;
    }

    @Override // android.database.Cursor
    public abstract String[] getColumnNames();

    @Override // android.database.Cursor
    public abstract int getCount();

    @Override // android.database.Cursor
    public abstract double getDouble(int r100);

    @Override // android.database.Cursor
    public abstract float getFloat(int r100);

    @Override // android.database.Cursor
    public abstract int getInt(int r100);

    @Override // android.database.Cursor
    public abstract long getLong(int r100);

    @Override // android.database.Cursor
    public abstract short getShort(int r100);

    @Override // android.database.Cursor
    public abstract String getString(int r100);

    @Override // android.database.Cursor, net.sqlcipher.Cursor
    public abstract int getType(int r100);

    @Override // android.database.Cursor
    public boolean getWantsAllOnMoveCalls() {
        return false;
    }

    @Override // android.database.CrossProcessCursor
    public CursorWindow getWindow() {
        return null;
    }

    @Override // android.database.Cursor
    public abstract boolean isNull(int r100);

    @Override // android.database.Cursor
    public final boolean moveToFirst() {
        return moveToPosition(0);
    }

    @Override // android.database.CrossProcessCursor
    public boolean onMove(int r100, int r101) {
        return true;
    }

    public void abortUpdates() {
        HashMap<Long, Map<String, Object>> r100 = this.mUpdatedRows;
        monitor-enter(r100);
        this.mUpdatedRows.clear();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void deactivateInternal() {
        ContentObserver r100 = this.mSelfObserver;
        if (r100 == null) goto L5;
        this.mContentResolver.unregisterContentObserver(r100);
        this.mSelfObserverRegistered = false;
    L5:
        this.mDataSetObservable.notifyInvalidated();
    }

    public void finalize() {
        ContentObserver r100 = this.mSelfObserver;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mSelfObserverRegistered != true) goto L9;
        this.mContentResolver.unregisterContentObserver(r100);
        return;
    }

    public boolean hasUpdates() {
        HashMap<Long, Map<String, Object>> r100 = this.mUpdatedRows;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.mUpdatedRows.size() <= 0) goto L7;
        boolean r101 = true;
    L8:
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    L7:
        r101 = false;
        goto L8
    }

    @Override // android.database.Cursor
    public final boolean isFirst() {
        if (this.mPos == 0) goto L5;
    L7:
        return false;
    L5:
        if (getCount() == 0) goto L7;
        return true;
    }

    @Override // android.database.Cursor
    public final boolean moveToNext() {
        return moveToPosition(this.mPos + 1);
    }

    @Override // android.database.Cursor
    public final boolean moveToPrevious() {
        return moveToPosition(this.mPos - 1);
    }

    public void notifyDataSetChange() {
        this.mDataSetObservable.notifyChanged();
    }

    @Override // android.database.Cursor
    public boolean requery() {
        ContentObserver r100 = this.mSelfObserver;
        if (r100 != null) goto L5;
    L7:
        this.mDataSetObservable.notifyChanged();
        return true;
    L5:
        if (this.mSelfObserverRegistered == true) goto L7;
        this.mContentResolver.registerContentObserver(this.mNotifyUri, true, r100);
        this.mSelfObserverRegistered = true;
        goto L7
    }

    public boolean supportsUpdates() {
        if (this.mRowIdColumnIndex == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public AbstractCursor() {
        this.mDataSetObservable = new DataSetObservable();
        this.mContentObservable = new ContentObservable();
        this.mExtras = Bundle.EMPTY;
        this.mClosed = false;
        this.mSelfObserverLock = new Object();
        this.mPos = -1;
        this.mRowIdColumnIndex = -1;
        this.mCurrentRowID = null;
        this.mUpdatedRows = new HashMap();
    }

    @Override // android.database.Cursor
    public int getColumnCount() {
        return getColumnNames().length;
    }

    @Override // android.database.CrossProcessCursor
    public /* bridge */ /* synthetic */ android.database.CursorWindow getWindow() {
        return getWindow();
    }

    @Override // android.database.Cursor
    public final boolean isAfterLast() {
        if (getCount() != 0) goto L6;
        return true;
    L6:
        if (this.mPos == getCount()) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // android.database.Cursor
    public final boolean isBeforeFirst() {
        if (getCount() != 0) goto L6;
        return true;
    L6:
        if (this.mPos == (-1)) goto L10;
        return false;
    L10:
        return true;
    }

    @Override // android.database.Cursor
    public final boolean isLast() {
        int r100 = getCount();
        if (this.mPos != (r100 - 1)) goto L6;
        if (r100 == 0) goto L6;
        return true;
    L6:
        return false;
    }

    @Override // android.database.Cursor
    public final boolean moveToLast() {
        return moveToPosition(getCount() - 1);
    }

    @Override // android.database.Cursor
    public void deactivate() {
        deactivateInternal();
    }

    public DataSetObservable getDataSetObservable() {
        return this.mDataSetObservable;
    }

    @Override // android.database.Cursor
    public Bundle getExtras() {
        return this.mExtras;
    }

    @Override // android.database.Cursor
    public Uri getNotificationUri() {
        return this.mNotifyUri;
    }

    @Override // android.database.Cursor
    public final int getPosition() {
        return this.mPos;
    }

    @Override // android.database.Cursor
    public boolean isClosed() {
        return this.mClosed;
    }

    @Override // android.database.Cursor
    public byte[] getBlob(int r100) {
        throw new UnsupportedOperationException("getBlob is not supported");
    }

    @Override // android.database.Cursor
    public int getColumnIndex(String r100) {
        int r101 = r100.lastIndexOf(46);
        if (r101 == (-1)) goto L5;
        new Exception();
        r100 = r100.substring(r101 + 1);
    L5:
        String[] r102 = getColumnNames();
        int r103 = r102.length;
        int r104 = 0;
    L6:
        if (r104 >= r103) goto L11;
        if (r102[r104].equalsIgnoreCase(r100) == true) goto L9;
        r104 = r104 + 1;
        goto L6
    L9:
        return r104;
    L11:
        return -1;
    }

    @Override // android.database.Cursor
    public int getColumnIndexOrThrow(String r100) {
        int r101 = getColumnIndex(r100);
        if (r101 < 0) goto L6;
        return r101;
    L6:
        throw new IllegalArgumentException("column '" + r100 + "' does not exist");
    }

    @Override // android.database.Cursor
    public String getColumnName(int r100) {
        return getColumnNames()[r100];
    }

    public Object getUpdatedField(int r100) {
        return this.mUpdatedRows.get(this.mCurrentRowID).get(getColumnNames()[r100]);
    }

    public boolean isFieldUpdated(int r100) {
        if (this.mRowIdColumnIndex != (-1)) goto L5;
        return false;
    L5:
        if (this.mUpdatedRows.size() <= 0) goto L14;
        Map<String, Object> r101 = this.mUpdatedRows.get(this.mCurrentRowID);
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.containsKey(getColumnNames()[r100]) == false) goto L16;
        return true;
    L16:
        return false;
    L14:
        return false;
    }

    @Override // android.database.Cursor
    public final boolean move(int r100) {
        return moveToPosition(this.mPos + r100);
    }

    @Override // android.database.Cursor
    public final boolean moveToPosition(int r100) {
        int r101 = getCount();
        if (r100 < r101) goto L7;
        this.mPos = r101;
        return false;
    L7:
        if (r100 >= 0) goto L10;
        this.mPos = -1;
        return false;
    L10:
        int r102 = this.mPos;
        if (r100 != r102) goto L14;
        return true;
    L14:
        boolean r103 = onMove(r102, r100);
        if (r103 == true) goto L17;
        this.mPos = -1;
    L20:
        return r103;
    L17:
        this.mPos = r100;
        int r104 = this.mRowIdColumnIndex;
        if (r104 == (-1)) goto L20;
        this.mCurrentRowID = Long.valueOf(getLong(r104));
        goto L20
    }

    public void onChange(boolean r100) {
        Object r101 = this.mSelfObserverLock;
        monitor-enter(r101);
        this.mContentObservable.dispatchChange(r100);     // Catch: Throwable -> L10
        Uri r102 = this.mNotifyUri;     // Catch: Throwable -> L10
        if (r102 == null) goto L8;
        if (r100 == false) goto L8;
        this.mContentResolver.notifyChange(r102, this.mSelfObserver);     // Catch: Throwable -> L10
    L8:
        monitor-exit(r101);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    @Override // android.database.Cursor
    public void registerContentObserver(ContentObserver r100) {
        this.mContentObservable.registerObserver(r100);
    }

    @Override // android.database.Cursor
    public void registerDataSetObserver(DataSetObserver r100) {
        this.mDataSetObservable.registerObserver(r100);
    }

    @Override // android.database.Cursor
    public Bundle respond(Bundle r100) {
        return Bundle.EMPTY;
    }

    @Override // android.database.Cursor
    public void setExtras(Bundle r100) {
        if (r100 != null) goto L4;
        r100 = Bundle.EMPTY;
    L4:
        this.mExtras = r100;
    }

    @Override // android.database.Cursor
    public void unregisterContentObserver(ContentObserver r100) {
        if (this.mClosed == true) goto L6;
        this.mContentObservable.unregisterObserver(r100);
        return;
    }

    @Override // android.database.Cursor
    public void unregisterDataSetObserver(DataSetObserver r100) {
        this.mDataSetObservable.unregisterObserver(r100);
    }

    public boolean updateToNull(int r100) {
        return update(r100, null);
    }

    @Override // android.database.Cursor
    public void copyStringToBuffer(int r100, CharArrayBuffer r101) {
        String r102 = getString(r100);
        if (r102 == null) goto L12;
        char[] r103 = r101.data;
        if (r103 != null) goto L7;
    L10:
        r101.data = r102.toCharArray();
    L11:
        r101.sizeCopied = r102.length();
        return;
    L7:
        if (r103.length < r102.length()) goto L10;
        r102.getChars(0, r102.length(), r103, 0);
        goto L11
    L12:
        r101.sizeCopied = 0;
    }

    @Override // android.database.CrossProcessCursor
    public void fillWindow(int r100, android.database.CursorWindow r101) {
        DatabaseUtils.cursorFillWindow(this, r100, r101);
    }

    @Override // android.database.Cursor
    public void setNotificationUri(ContentResolver r100, Uri r101) {
        Object r102 = this.mSelfObserverLock;
        monitor-enter(r102);
        this.mNotifyUri = r101;     // Catch: Throwable -> L10
        this.mContentResolver = r100;     // Catch: Throwable -> L10
        ContentObserver r103 = this.mSelfObserver;     // Catch: Throwable -> L10
        if (r103 == null) goto L7;
        r100.unregisterContentObserver(r103);     // Catch: Throwable -> L10
    L7:
        SelfContentObserver r104 = new SelfContentObserver(this);     // Catch: Throwable -> L10
        this.mSelfObserver = r104;     // Catch: Throwable -> L10
        this.mContentResolver.registerContentObserver(this.mNotifyUri, true, r104);     // Catch: Throwable -> L10
        this.mSelfObserverRegistered = true;     // Catch: Throwable -> L10
        monitor-exit(r102);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public boolean update(int r100, Object r101) {
        if (supportsUpdates() == true) goto L6;
        return false;
    L6:
        Long r102 = Long.valueOf(getLong(this.mRowIdColumnIndex));
        if (r102 == null) goto L21;
        HashMap<Long, Map<String, Object>> r103 = this.mUpdatedRows;
        monitor-enter(r103);
        Map<String, Object> r104 = this.mUpdatedRows.get(r102);     // Catch: Throwable -> L17
        if (r104 != null) goto L13;
        r104 = new HashMap();     // Catch: Throwable -> L17
        this.mUpdatedRows.put(r102, r104);     // Catch: Throwable -> L17
    L13:
        r104.put(getColumnNames()[r100], r101);     // Catch: Throwable -> L17
        monitor-exit(r103);     // Catch: Throwable -> L17
        return true;
    L17:
        th = move-exception;
        throw th;
    L21:
        throw new IllegalStateException("null rowid. mRowIdColumnIndex = " + this.mRowIdColumnIndex);
    }

    public boolean updateBlob(int r100, byte[] r101) {
        return update(r100, r101);
    }

    public boolean updateDouble(int r100, double r101) {
        return update(r100, Double.valueOf(r101));
    }

    public boolean updateFloat(int r100, float r101) {
        return update(r100, Float.valueOf(r101));
    }

    public boolean updateInt(int r100, int r101) {
        return update(r100, Integer.valueOf(r101));
    }

    public boolean updateLong(int r100, long r101) {
        return update(r100, Long.valueOf(r101));
    }

    public boolean updateShort(int r100, short r101) {
        return update(r100, Short.valueOf(r101));
    }

    public boolean updateString(int r100, String r101) {
        return update(r100, r101);
    }
}
