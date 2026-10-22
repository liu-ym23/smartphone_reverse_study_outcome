package net.sqlcipher.database;

import android.database.DataSetObserver;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.alipay.sdk.m.n.a;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadThreadV2;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import me.ele.lancet.base.annotations.Skip;
import net.sqlcipher.AbstractWindowedCursor;
import net.sqlcipher.CursorWindow;
import net.sqlcipher.SQLException;

/* JADX INFO: loaded from: classes42.dex */
public class SQLiteCursor extends AbstractWindowedCursor {
    static final int NO_COUNT = -1;
    static final String TAG = "Cursor";
    private boolean fillWindowForwardOnly;
    private Map<String, Integer> mColumnNameMap;
    private String[] mColumns;
    private int mCount;
    private int mCursorState;
    private int mCursorWindowCapacity;
    private SQLiteDatabase mDatabase;
    private SQLiteCursorDriver mDriver;
    private String mEditTable;
    private int mInitialRead;
    private ReentrantLock mLock;
    private int mMaxRead;
    protected MainThreadNotificationHandler mNotificationHandler;
    private boolean mPendingData;
    private SQLiteQuery mQuery;
    private Throwable mStackTrace;

    public static class MainThreadNotificationHandler extends Handler {
        private final WeakReference<SQLiteCursor> wrappedCursor;

        public MainThreadNotificationHandler(SQLiteCursor r100) {
            this.wrappedCursor = new WeakReference(r100);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r100) {
            SQLiteCursor r101 = this.wrappedCursor.get();
            if (r101 == null) goto L6;
            SQLiteCursor.access$700(r101);
            return;
        }
    }

    public final class QueryThread implements Runnable {
        private final int mThreadState;
        final /* synthetic */ SQLiteCursor this$0;

        @Override // java.lang.Runnable
        public void run() {
            net_sqlcipher_database_SQLiteCursor$QueryThread_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        private void sendMessage() {
            SQLiteCursor r100 = this.this$0;
            MainThreadNotificationHandler r101 = r100.mNotificationHandler;
            if (r101 == null) goto L5;
            r101.sendEmptyMessage(1);
            SQLiteCursor.access$002(this.this$0, false);
            return;
        L5:
            SQLiteCursor.access$002(r100, true);
        }

        public void net_sqlcipher_database_SQLiteCursor$QueryThread__run$___twin___() {
            CursorWindow r100 = SQLiteCursor.access$100(this.this$0);
            Process.setThreadPriority(Process.myTid(), 10);
        L4:
            if (SQLiteCursor.access$200(this.this$0) != null) goto L6;
            SQLiteCursor.access$202(this.this$0, new ReentrantLock(true));
        L6:
            SQLiteCursor.access$200(this.this$0).lock();
            if (SQLiteCursor.access$300(this.this$0) != this.mThreadState) goto L8;
            int r101 = SQLiteCursor.access$600(this.this$0).fillWindow(r100, SQLiteCursor.access$400(this.this$0), SQLiteCursor.access$500(this.this$0));     // Catch: Throwable -> L17 Exception -> L22
            if (r101 == 0) goto L20;
            if (r101 != (-1)) goto L15;
            SQLiteCursor r102 = this.this$0;     // Catch: Throwable -> L17 Exception -> L22
            SQLiteCursor.access$502(r102, SQLiteCursor.access$500(r102) + SQLiteCursor.access$400(this.this$0));     // Catch: Throwable -> L17 Exception -> L22
            sendMessage();     // Catch: Throwable -> L17 Exception -> L22
            SQLiteCursor.access$200(this.this$0).unlock();
            goto L4
        L15:
            SQLiteCursor.access$502(this.this$0, r101);     // Catch: Throwable -> L17 Exception -> L22
            sendMessage();     // Catch: Throwable -> L17 Exception -> L22
        L17:
            th = move-exception;
            SQLiteCursor.access$200(this.this$0).unlock();
            throw th;
        L20:
            SQLiteCursor.access$200(this.this$0).unlock();
            return;
        L8:
            SQLiteCursor.access$200(this.this$0).unlock();
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void net_sqlcipher_database_SQLiteCursor$QueryThread_com_larus_apm_impl_protector_RunnableLancet_run(QueryThread r100) {
            r100.net_sqlcipher_database_SQLiteCursor$QueryThread__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public QueryThread(SQLiteCursor r100, int r101) {
            this.this$0 = r100;
            this.mThreadState = r101;
        }
    }

    private void deactivateCommon() {
        this.mCursorState = 0;
        CursorWindow r100 = this.mWindow;
        if (r100 == null) goto L6;
        r100.close();
        this.mWindow = null;
        return;
    }

    private void queryThreadLock() {
        ReentrantLock r100 = this.mLock;
        if (r100 == null) goto L6;
        r100.lock();
        return;
    }

    private void queryThreadUnlock() {
        ReentrantLock r100 = this.mLock;
        if (r100 == null) goto L6;
        r100.unlock();
        return;
    }

    @Override // net.sqlcipher.AbstractCursor
    public void finalize() {
    L7:
        th = move-exception;
        super.finalize();
        throw th;
    L3:
        if (this.mWindow == null) goto L5;
        this.mQuery.mSql.getClass();     // Catch: Throwable -> L7
        close();     // Catch: Throwable -> L7
        SQLiteDebug.notifyActiveCursorFinalized();     // Catch: Throwable -> L7
    L5:
        super.finalize();
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getCount() {
        if (this.mCount != (-1)) goto L6;
        fillWindow(0);
    L6:
        return this.mCount;
    }

    @Override // net.sqlcipher.AbstractCursor
    public boolean supportsUpdates() {
        return !TextUtils.isEmpty(this.mEditTable);
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        super.close();
        deactivateCommon();
        this.mQuery.close();
        this.mDriver.cursorClosed();
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void deactivate() {
        super.deactivate();
        deactivateCommon();
        this.mDriver.cursorDeactivated();
    }

    @Override // net.sqlcipher.AbstractCursor
    public boolean deleteRow() {
        checkPosition();
        if (this.mRowIdColumnIndex != (-1)) goto L5;
    L21:
        return false;
    L5:
        if (this.mCurrentRowID == null) goto L21;
        this.mDatabase.lock();
        this.mDatabase.delete(this.mEditTable, this.mColumns[this.mRowIdColumnIndex] + "=?", new String[]{this.mCurrentRowID.toString()});     // Catch: Throwable -> L10 SQLException -> L12
        boolean r100 = true;
    L13:
        int r101 = this.mPos;     // Catch: Throwable -> L10
        requery();     // Catch: Throwable -> L10
        moveToPosition(r101);     // Catch: Throwable -> L10
        this.mDatabase.unlock();
        if (r100 == false) goto L18;
        onChange(true);
        return true;
    L18:
        return false;
    L12:
        r100 = false;
    L10:
        th = move-exception;
        this.mDatabase.unlock();
        throw th;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public boolean requery() {
        if (isClosed() == false) goto L6;
        return false;
    L6:
        this.mDatabase.lock();
        CursorWindow r100 = this.mWindow;     // Catch: Throwable -> L18
        if (r100 == null) goto L10;
        r100.clear();     // Catch: Throwable -> L18
    L10:
        this.mPos = -1;     // Catch: Throwable -> L18
        this.mDriver.cursorRequeried(this);     // Catch: Throwable -> L18
        this.mCount = -1;     // Catch: Throwable -> L18
        this.mCursorState++;     // Catch: Throwable -> L18
        queryThreadLock();     // Catch: Throwable -> L18
        this.mQuery.requery();     // Catch: Throwable -> L15
        queryThreadUnlock();     // Catch: Throwable -> L18
        this.mDatabase.unlock();
        return super.requery();
    L15:
        th = move-exception;
        queryThreadUnlock();     // Catch: Throwable -> L18
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        this.mDatabase.unlock();
        throw th;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public String[] getColumnNames() {
        return this.mColumns;
    }

    public SQLiteDatabase getDatabase() {
        return this.mDatabase;
    }

    public static /* synthetic */ CursorWindow access$100(SQLiteCursor r100) {
        return r100.mWindow;
    }

    public static /* synthetic */ ReentrantLock access$200(SQLiteCursor r100) {
        return r100.mLock;
    }

    public static /* synthetic */ int access$300(SQLiteCursor r100) {
        return r100.mCursorState;
    }

    public static /* synthetic */ int access$400(SQLiteCursor r100) {
        return r100.mMaxRead;
    }

    public static /* synthetic */ int access$500(SQLiteCursor r100) {
        return r100.mCount;
    }

    public static /* synthetic */ SQLiteQuery access$600(SQLiteCursor r100) {
        return r100.mQuery;
    }

    public static /* synthetic */ void access$700(SQLiteCursor r100) {
        r100.notifyDataSetChange();
    }

    private void fillWindow(int r100) {
        if (this.mWindow != null) goto L5;
        this.mWindow = new CursorWindow(true);
    L9:
        if (this.fillWindowForwardOnly == false) goto L12;
        int r101 = r100;
    L15:
        this.mWindow.setStartPosition(r101);
        this.mWindow.setRequiredPosition(r100);
        this.mCount = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
        if (this.mCursorWindowCapacity != 0) goto L19;
        this.mCursorWindowCapacity = this.mWindow.getNumRows();
    L19:
        if (this.mCount != (-1)) goto L27;
        this.mCount = r101 + this.mInitialRead;
        ThreadMethodProxy.start(new PthreadThreadV2(new QueryThread(this, this.mCursorState), "query thread"));
        return;
    L27:
        return;
    L12:
        if (this.mCount != (-1)) goto L14;
        r101 = cursorPickFillWindowStartPosition(r100, 0);
        goto L15
    L14:
        r101 = cursorPickFillWindowStartPosition(r100, this.mCursorWindowCapacity);
        goto L15
    L5:
        this.mCursorState++;
        queryThreadLock();
        this.mWindow.clear();     // Catch: Throwable -> L22
        queryThreadUnlock();
    L22:
        th = move-exception;
        queryThreadUnlock();
        throw th;
    }

    @Override // net.sqlcipher.AbstractCursor
    public boolean commitUpdates(Map<? extends Long, ? extends Map<String, Object>> r110) {
        if (supportsUpdates() == true) goto L5;
        return false;
    L5:
        HashMap<Long, Map<String, Object>> r100 = this.mUpdatedRows;
        monitor-enter(r100);
        if (r110 == null) goto L10;
        this.mUpdatedRows.putAll(r110);     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        throw th;
    L10:
        if (this.mUpdatedRows.size() != 0) goto L13;
        monitor-exit(r100);     // Catch: Throwable -> L41
        return true;
    L13:
        this.mDatabase.beginTransaction();     // Catch: Throwable -> L41
        StringBuilder r111 = new StringBuilder(128);     // Catch: Throwable -> L38
        Iterator<Map.Entry<Long, Map<String, Object>>> r101 = this.mUpdatedRows.entrySet().iterator();     // Catch: Throwable -> L38
    L16:
        if (r101.hasNext() == false) goto L33;
        Map.Entry<Long, Map<String, Object>> r102 = r101.next();     // Catch: Throwable -> L38
        Map<String, Object> r103 = r102.getValue();     // Catch: Throwable -> L38
        Long r104 = r102.getKey();     // Catch: Throwable -> L38
        if (r104 == null) goto L32;
        if (r103 == null) goto L32;
        if (r103.size() == 0) goto L16;
        long r105 = r104.longValue();     // Catch: Throwable -> L38
        Iterator<Map.Entry<String, Object>> r106 = r103.entrySet().iterator();     // Catch: Throwable -> L38
        r111.setLength(0);     // Catch: Throwable -> L38
        r111.append("UPDATE " + this.mEditTable + " SET ");     // Catch: Throwable -> L38
        Object[] r107 = new Object[r103.size()];     // Catch: Throwable -> L38
        int r108 = 0;
    L25:
        if (r106.hasNext() == false) goto L30;
        Map.Entry<String, Object> r109 = r106.next();     // Catch: Throwable -> L38
        r111.append(r109.getKey());     // Catch: Throwable -> L38
        r111.append("=?");     // Catch: Throwable -> L38
        r107[r108] = r109.getValue();     // Catch: Throwable -> L38
        if (r106.hasNext() == false) goto L29;
        r111.append(", ");     // Catch: Throwable -> L38
    L29:
        r108 = r108 + 1;     // Catch: Throwable -> L38
        goto L25
    L30:
        r111.append(" WHERE " + this.mColumns[this.mRowIdColumnIndex] + a.f25612h + r105);     // Catch: Throwable -> L38
        r111.append(';');     // Catch: Throwable -> L38
        this.mDatabase.execSQL(r111.toString(), r107);     // Catch: Throwable -> L38
        this.mDatabase.rowUpdated(this.mEditTable, r105);     // Catch: Throwable -> L38
    L32:
        throw new IllegalStateException("null rowId or values found! rowId = " + r104 + ", values = " + r103);     // Catch: Throwable -> L38
    L33:
        this.mDatabase.setTransactionSuccessful();     // Catch: Throwable -> L38
        this.mDatabase.endTransaction();     // Catch: Throwable -> L41
        this.mUpdatedRows.clear();     // Catch: Throwable -> L41
        monitor-exit(r100);     // Catch: Throwable -> L41
        onChange(true);
        return true;
    L38:
        th = move-exception;
        this.mDatabase.endTransaction();     // Catch: Throwable -> L41
        throw th;     // Catch: Throwable -> L41
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public int getColumnIndex(String r100) {
        if (this.mColumnNameMap != null) goto L9;
        String[] r101 = this.mColumns;
        int r102 = r101.length;
        HashMap r103 = new HashMap(r102, 1.0f);
        int r104 = 0;
    L5:
        if (r104 >= r102) goto L7;
        r103.put(r101[r104], Integer.valueOf(r104));
        r104 = r104 + 1;
        goto L5
    L7:
        this.mColumnNameMap = r103;
    L9:
        if (r100.lastIndexOf(46) == (-1)) goto L11;
        new Exception();
    L11:
        Integer r105 = this.mColumnNameMap.get(r100);
        if (r105 != null) goto L14;
        return -1;
    L14:
        return r105.intValue();
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.Cursor
    public void registerDataSetObserver(DataSetObserver r100) {
        super.registerDataSetObserver(r100);
        if (Integer.MAX_VALUE != this.mMaxRead) goto L7;
        if (Integer.MAX_VALUE != this.mInitialRead) goto L7;
        return;
    L7:
        if (this.mNotificationHandler != null) goto L19;
        queryThreadLock();
        this.mNotificationHandler = new MainThreadNotificationHandler(this);     // Catch: Throwable -> L13
        if (this.mPendingData == false) goto L12;
        notifyDataSetChange();     // Catch: Throwable -> L13
        this.mPendingData = false;     // Catch: Throwable -> L13
    L12:
        queryThreadUnlock();
        return;
    L13:
        th = move-exception;
        queryThreadUnlock();
        throw th;
    }

    public void setFillWindowForwardOnly(boolean r100) {
        this.fillWindowForwardOnly = r100;
    }

    public void setSelectionArguments(String[] r100) {
        this.mDriver.setBindArguments(r100);
    }

    @Override // net.sqlcipher.AbstractWindowedCursor
    public void setWindow(CursorWindow r100) {
        if (this.mWindow == null) goto L10;
        this.mCursorState++;
        queryThreadLock();
        this.mWindow.close();     // Catch: Throwable -> L7
        queryThreadUnlock();
        this.mCount = -1;
    L7:
        th = move-exception;
        queryThreadUnlock();
        throw th;
    L10:
        this.mWindow = r100;
    }

    public static /* synthetic */ boolean access$002(SQLiteCursor r100, boolean r101) {
        r100.mPendingData = r101;
        return r101;
    }

    public static /* synthetic */ ReentrantLock access$202(SQLiteCursor r100, ReentrantLock r101) {
        r100.mLock = r101;
        return r101;
    }

    public static /* synthetic */ int access$502(SQLiteCursor r100, int r101) {
        r100.mCount = r101;
        return r101;
    }

    public int cursorPickFillWindowStartPosition(int r100, int r101) {
        return Math.max(r100 - (r101 / 3), 0);
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.CrossProcessCursor
    public void fillWindow(int r100, android.database.CursorWindow r101) {
        if (this.mWindow != null) goto L5;
        this.mWindow = new CursorWindow(true);
    L9:
        if (this.fillWindowForwardOnly == false) goto L12;
        int r102 = r100;
    L15:
        this.mWindow.setStartPosition(r102);
        this.mWindow.setRequiredPosition(r100);
        this.mCount = this.mQuery.fillWindow(this.mWindow, this.mInitialRead, 0);
        if (this.mCursorWindowCapacity != 0) goto L19;
        this.mCursorWindowCapacity = this.mWindow.getNumRows();
    L19:
        if (this.mCount != (-1)) goto L27;
        this.mCount = r102 + this.mInitialRead;
        ThreadMethodProxy.start(new PthreadThreadV2(new QueryThread(this, this.mCursorState), "query thread"));
        return;
    L27:
        return;
    L12:
        if (this.mCount != (-1)) goto L14;
        r102 = cursorPickFillWindowStartPosition(r100, 0);
        goto L15
    L14:
        r102 = cursorPickFillWindowStartPosition(r100, this.mCursorWindowCapacity);
        goto L15
    L5:
        this.mCursorState++;
        queryThreadLock();
        this.mWindow.clear();     // Catch: Throwable -> L22
        queryThreadUnlock();
    L22:
        th = move-exception;
        queryThreadUnlock();
        throw th;
    }

    @Override // net.sqlcipher.AbstractCursor, android.database.CrossProcessCursor
    public boolean onMove(int r100, int r101) {
        CursorWindow r102 = this.mWindow;
        if (r102 != null) goto L5;
    L8:
        fillWindow(r101);
        return true;
    L5:
        if (r101 < r102.getStartPosition()) goto L8;
        if (r101 >= (this.mWindow.getStartPosition() + this.mWindow.getNumRows())) goto L8;
        return true;
    }

    public void setLoadStyle(int r100, int r101) {
        this.mMaxRead = r101;
        this.mInitialRead = r100;
        this.mLock = new ReentrantLock(true);
    }

    public SQLiteCursor(SQLiteDatabase r100, SQLiteCursorDriver r101, String r102, SQLiteQuery r103) {
        this.mCount = -1;
        int r104 = 0;
        this.mCursorWindowCapacity = 0;
        this.fillWindowForwardOnly = false;
        this.mMaxRead = Integer.MAX_VALUE;
        this.mInitialRead = Integer.MAX_VALUE;
        this.mCursorState = 0;
        this.mLock = null;
        this.mPendingData = false;
        this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
        this.mDatabase = r100;
        this.mDriver = r101;
        this.mEditTable = r102;
        this.mColumnNameMap = null;
        this.mQuery = r103;
        r100.lock();     // Catch: Throwable -> L11
        int r105 = this.mQuery.columnCountLocked();     // Catch: Throwable -> L11
        this.mColumns = new String[r105];     // Catch: Throwable -> L11
    L4:
        if (r104 >= r105) goto L9;
        String r106 = this.mQuery.columnNameLocked(r104);     // Catch: Throwable -> L11
        this.mColumns[r104] = r106;     // Catch: Throwable -> L11
        if (DBDefinition.ID.equals(r106) == false) goto L8;
        this.mRowIdColumnIndex = r104;     // Catch: Throwable -> L11
    L8:
        r104 = r104 + 1;
        goto L4
    L9:
        r100.unlock();
        return;
    L11:
        th = move-exception;
        r100.unlock();
        throw th;
    }
}
