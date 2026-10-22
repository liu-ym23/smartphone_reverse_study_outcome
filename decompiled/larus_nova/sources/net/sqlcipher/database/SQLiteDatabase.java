package net.sqlcipher.database;

import android.content.ContentValues;
import android.content.Context;
import android.os.CancellationSignal;
import android.os.Debug;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;
import java.util.zip.ZipInputStream;
import net.sqlcipher.CrossProcessCursorWrapper;
import net.sqlcipher.Cursor;
import net.sqlcipher.CursorWrapper;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.DatabaseUtils;
import net.sqlcipher.DefaultDatabaseErrorHandler;
import net.sqlcipher.SQLException;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public class SQLiteDatabase extends SQLiteClosable implements SupportSQLiteDatabase {
    private static final String COMMIT_SQL = "COMMIT;";
    public static final int CONFLICT_ABORT = 2;
    public static final int CONFLICT_FAIL = 3;
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_NONE = 0;
    public static final int CONFLICT_REPLACE = 5;
    public static final int CONFLICT_ROLLBACK = 1;
    private static final String[] CONFLICT_VALUES = null;
    public static final int CREATE_IF_NECESSARY = 268435456;
    private static final Pattern EMAIL_IN_DB_PATTERN = null;
    private static final int EVENT_DB_CORRUPT = 75004;
    private static final int EVENT_DB_OPERATION = 52000;
    static final String GET_LOCK_LOG_PREFIX = "GETLOCK:";
    private static final String KEY_ENCODING = "UTF-8";
    private static final int LOCK_ACQUIRED_WARNING_THREAD_TIME_IN_MS = 100;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS = 300;
    private static final int LOCK_ACQUIRED_WARNING_TIME_IN_MS_ALWAYS_PRINT = 2000;
    private static final int LOCK_WARNING_WINDOW_IN_MS = 20000;
    private static final String LOG_SLOW_QUERIES_PROPERTY = "db.log.slow_query_threshold";
    public static final int MAX_SQL_CACHE_SIZE = 250;
    private static final int MAX_WARNINGS_ON_CACHESIZE_CONDITION = 1;
    public static final String MEMORY = ":memory:";
    public static final int NO_LOCALIZED_COLLATORS = 16;
    public static final int OPEN_READONLY = 1;
    public static final int OPEN_READWRITE = 0;
    private static final int OPEN_READ_MASK = 1;
    private static final int QUERY_LOG_SQL_LENGTH = 64;
    private static final int SLEEP_AFTER_YIELD_QUANTUM = 1000;
    public static final String SQLCIPHER_ANDROID_VERSION = "1.0";
    public static final int SQLITE_MAX_LIKE_PATTERN_LENGTH = 50000;
    private static final String TAG = "Database";
    private static WeakHashMap<SQLiteDatabase, Object> sActiveDatabases;
    private static int sQueryLogTimeInMillis;
    private int mCacheFullWarnings;
    Map<String, SQLiteCompiledSql> mCompiledQueries;
    private final DatabaseErrorHandler mErrorHandler;
    private CursorFactory mFactory;
    private int mFlags;
    private boolean mInnerTransactionIsSuccessful;
    private long mLastLockMessageTime;
    private String mLastSqlStatement;
    private final ReentrantLock mLock;
    private long mLockAcquiredThreadTime;
    private long mLockAcquiredWallTime;
    private boolean mLockingEnabled;
    private int mMaxSqlCacheSize;
    long mNativeHandle;
    private int mNumCacheHits;
    private int mNumCacheMisses;
    private String mPath;
    private String mPathForLogs;
    private WeakHashMap<SQLiteClosable, Object> mPrograms;
    private final int mSlowQueryThreshold;
    private Throwable mStackTrace;
    private final Map<String, SyncUpdateInfo> mSyncUpdateInfo;
    int mTempTableSequence;
    private String mTimeClosed;
    private String mTimeOpened;
    private boolean mTransactionIsSuccessful;
    private SQLiteTransactionListener mTransactionListener;

    public interface CursorFactory {
        Cursor newCursor(SQLiteDatabase r100, SQLiteCursorDriver r101, String r102, SQLiteQuery r103);
    }

    public interface LibraryLoader {
        void loadLibraries(String... r100);
    }

    public static final enum SQLiteDatabaseTransactionType extends Enum<SQLiteDatabaseTransactionType> {
        private static final /* synthetic */ SQLiteDatabaseTransactionType[] $VALUES = null;
        public static final SQLiteDatabaseTransactionType Deferred = null;
        public static final SQLiteDatabaseTransactionType Exclusive = null;
        public static final SQLiteDatabaseTransactionType Immediate = null;

        static {
            SQLiteDatabaseTransactionType r100 = new SQLiteDatabaseTransactionType("Deferred", 0);
            Deferred = r100;
            SQLiteDatabaseTransactionType r101 = new SQLiteDatabaseTransactionType("Immediate", 1);
            Immediate = r101;
            SQLiteDatabaseTransactionType r102 = new SQLiteDatabaseTransactionType("Exclusive", 2);
            Exclusive = r102;
            $VALUES = new SQLiteDatabaseTransactionType[]{r100, r101, r102};
        }

        public static SQLiteDatabaseTransactionType[] values() {
            return (SQLiteDatabaseTransactionType[]) $VALUES.clone();
        }

        public static SQLiteDatabaseTransactionType valueOf(String r100) {
            return (SQLiteDatabaseTransactionType) a.a(SQLiteDatabaseTransactionType.class, r100);
        }

        private SQLiteDatabaseTransactionType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class SyncUpdateInfo {
        String deletedTable;
        String foreignKey;
        String masterTable;

        public SyncUpdateInfo(String r100, String r101, String r102) {
            this.masterTable = r100;
            this.deletedTable = r101;
            this.foreignKey = r102;
        }
    }

    private native void dbclose();

    private native void dbopen(String r100, int r101);

    private native void enableSqlProfiling(String r100);

    private native void enableSqlTracing(String r100);

    private native void key(byte[] r100) throws SQLException;

    private native void key_mutf8(char[] r100) throws SQLException;

    private native int native_getDbLookaside();

    private native void native_rawExecSQL(String r100);

    private native int native_status(int r100, boolean r101);

    private native void rekey(byte[] r100) throws SQLException;

    public static native int releaseMemory();

    public static native void setICURoot(String r100);

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransaction() {
        beginTransactionWithListener(null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionNonExclusive() {
        beginTransactionWithListenerInternal(null, SQLiteDatabaseTransactionType.Immediate);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final /* synthetic */ void execPerConnectionSQL(String r100, Object[] r101) {
        SupportSQLiteDatabase.CC.$default$execPerConnectionSQL(this, r100, r101);
    }

    public synchronized int getMaxSqlCacheSize() {
        monitor-enter(this);
        int r100 = this.mMaxSqlCacheSize;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final /* synthetic */ boolean isExecPerConnectionSQLSupported() {
        return SupportSQLiteDatabase.CC.$default$isExecPerConnectionSQLSupported(this);
    }

    public native int lastChangeCount();

    public native long lastInsertRow();

    public native void native_execSQL(String r100) throws SQLException;

    public native void native_setLocale(String r100, int r101);

    static {
        sActiveDatabases = new WeakHashMap();
        CONFLICT_VALUES = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
        EMAIL_IN_DB_PATTERN = PatternProtector.compile("[\\w\\.\\-]+@[\\w\\.\\-]+");
        sQueryLogTimeInMillis = 0;
    }

    private void deallocCachedSqlStatements() {
        Map<String, SQLiteCompiledSql> r100 = this.mCompiledQueries;
        monitor-enter(r100);
        Iterator<SQLiteCompiledSql> r101 = this.mCompiledQueries.values().iterator();     // Catch: Throwable -> L11
    L6:
        if (r101.hasNext() == false) goto L8;
        r101.next().releaseSqlStatement();     // Catch: Throwable -> L11
        goto L6
    L8:
        this.mCompiledQueries.clear();     // Catch: Throwable -> L11
        monitor-exit(r100);     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        throw th;
    }

    private static ArrayList<SQLiteDatabase> getActiveDatabases() {
        ArrayList<SQLiteDatabase> r100 = new ArrayList();
        WeakHashMap<SQLiteDatabase, Object> r101 = sActiveDatabases;
        monitor-enter(r101);
        r100.addAll(sActiveDatabases.keySet());     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r100;
    L7:
        th = move-exception;
        throw th;
    }

    public static ArrayList<SQLiteDebug.DbStats> getDbStats() {
        ArrayList<SQLiteDebug.DbStats> r100 = new ArrayList();
        Iterator<SQLiteDatabase> r101 = getActiveDatabases().iterator();
    L4:
        if (r101.hasNext() == false) goto L35;
        SQLiteDatabase r102 = r101.next();
        if (r102 == null) goto L4;
        if (r102.isOpen() == false) goto L4;
        int r103 = r102.native_getDbLookaside();
        String r104 = r102.getPath();
        int r105 = r104.lastIndexOf(HTTP.URL_DEFAULT);
        if (r105 == (-1)) goto L13;
        int r106 = r105 + 1;
    L14:
        String r107 = r104.substring(r106);
        ArrayList<Pair<String, String>> r108 = getAttachedDbs(r102);
        if (r108 == null) goto L4;
        int r109 = 0;
    L19:
        if (r109 >= r108.size()) goto L4;
        Pair r110 = (Pair) ListProtector.get(r108, r109);
        long r111 = getPragmaVal(r102, ((String) r110.first) + ".page_count;");
        if (r109 != 0) goto L23;
        String r112 = r107;
    L32:
        if (r111 <= 0) goto L34;
        r100.add(new SQLiteDebug.DbStats(r112, r111, r102.getPageSize(), r103));
    L34:
        r109 = r109 + 1;
        goto L19
    L23:
        String r113 = "  (attached) " + ((String) r110.first);
        if (((String) r110.second).trim().length() <= 0) goto L30;
        int r114 = ((String) r110.second).lastIndexOf(HTTP.URL_DEFAULT);
        StringBuilder r115 = new StringBuilder();
        r115.append(r113);
        r115.append(" : ");
        String r116 = (String) r110.second;
        if (r114 == (-1)) goto L28;
        int r117 = r114 + 1;
    L29:
        r115.append(r116.substring(r117));
        r113 = r115.toString();
        goto L30
    L28:
        r117 = 0;
    L30:
        r112 = r113;
        r103 = 0;
        goto L32
    L13:
        r106 = 0;
        goto L14
    L35:
        return r100;
    }

    private String getPathForLogs() {
        String r100 = this.mPathForLogs;
        if (r100 == null) goto L5;
        return r100;
    L5:
        String r101 = this.mPath;
        if (r101 != null) goto L10;
        return null;
    L10:
        if (r101.indexOf(64) != (-1)) goto L12;
        this.mPathForLogs = this.mPath;
    L14:
        return this.mPathForLogs;
    L12:
        this.mPathForLogs = EMAIL_IN_DB_PATTERN.matcher(this.mPath).replaceAll("XX@YY");
        goto L14
    }

    private String getTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS ", Locale.US).format(Long.valueOf(System.currentTimeMillis()));
    }

    private void lockForced() {
        this.mLock.lock();
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING == true) goto L5;
        return;
    L5:
        if (this.mLock.getHoldCount() != 1) goto L9;
        this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
        this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
        return;
    }

    private void unlockForced() {
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING == true) goto L5;
    L7:
        this.mLock.unlock();
        return;
    L5:
        if (this.mLock.getHoldCount() != 1) goto L7;
        checkLockHoldTime();
        goto L7
    }

    public Map<String, String> getSyncedTables() {
        Map<String, SyncUpdateInfo> r100 = this.mSyncUpdateInfo;
        monitor-enter(r100);
        HashMap r101 = new HashMap();     // Catch: Throwable -> L12
        Iterator<String> r102 = this.mSyncUpdateInfo.keySet().iterator();     // Catch: Throwable -> L12
    L6:
        if (r102.hasNext() == false) goto L10;
        String r103 = r102.next();     // Catch: Throwable -> L12
        String r104 = this.mSyncUpdateInfo.get(r103).deletedTable;     // Catch: Throwable -> L12
        if (r104 == null) goto L6;
        r101.put(r103, r104);     // Catch: Throwable -> L12
        goto L6
    L10:
        monitor-exit(r100);     // Catch: Throwable -> L12
        return r101;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean inTransaction() {
        if (this.mLock.getHoldCount() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDatabaseIntegrityOk() {
        Pair<Boolean, String> r100 = getResultFromPragma("PRAGMA integrity_check;");
        if (((Boolean) r100.first).booleanValue() == false) goto L6;
        return ((String) r100.second).equals(com.bytedance.android.ec.core.event.a.VALUE_CLICK_TYPE);
    L6:
        return ((Boolean) r100.first).booleanValue();
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isDbLockedByCurrentThread() {
        return this.mLock.isHeldByCurrentThread();
    }

    public boolean isDbLockedByOtherThreads() {
        if (this.mLock.isHeldByCurrentThread() == false) goto L5;
    L7:
        return false;
    L5:
        if (this.mLock.isLocked() == false) goto L7;
        return true;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isOpen() {
        if (this.mNativeHandle == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isReadOnly() {
        if ((this.mFlags & 1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean isWriteAheadLoggingEnabled() {
        Pair<Boolean, String> r100 = getResultFromPragma("PRAGMA journal_mode;");
        if (((Boolean) r100.first).booleanValue() == false) goto L6;
        return ((String) r100.second).equals("wal");
    L6:
        return ((Boolean) r100.first).booleanValue();
    }

    public void lock() {
        if (this.mLockingEnabled == true) goto L5;
        return;
    L5:
        this.mLock.lock();
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING == true) goto L8;
        return;
    L8:
        if (this.mLock.getHoldCount() != 1) goto L12;
        this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
        this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
        return;
    }

    public void onCorruption() {
        this.mErrorHandler.onCorruption(this);
    }

    public void resetCompiledSqlCache() {
        Map<String, SQLiteCompiledSql> r100 = this.mCompiledQueries;
        monitor-enter(r100);
        this.mCompiledQueries.clear();     // Catch: Throwable -> L7
        monitor-exit(r100);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void unlock() {
        if (this.mLockingEnabled == true) goto L6;
        return;
    L6:
        if (SQLiteDebug.DEBUG_LOCK_TIME_TRACKING == true) goto L8;
    L10:
        this.mLock.unlock();
        return;
    L8:
        if (this.mLock.getHoldCount() != 1) goto L10;
        checkLockHoldTime();
        goto L10
    }

    private void checkLockHoldTime() {
        long r100 = SystemClock.elapsedRealtime();
        long r101 = r100 - this.mLockAcquiredWallTime;
        if (r101 >= 2000) goto L10;
        if (Log.isLoggable(TAG, 2) == true) goto L10;
        if ((r100 - this.mLastLockMessageTime) >= 20000) goto L10;
        return;
    L10:
        if (r101 > 300) goto L12;
        return;
    L12:
        if (((int) ((Debug.threadCpuTimeNanos() - this.mLockAcquiredThreadTime) / 1000000)) > 100) goto L14;
        if (r101 > 2000) goto L14;
        return;
    L14:
        this.mLastLockMessageTime = r100;
        boolean r102 = SQLiteDebug.DEBUG_SQL_STATEMENTS;
    }

    private void closeClosable() {
        deallocCachedSqlStatements();
        Iterator<Map.Entry<SQLiteClosable, Object>> r100 = this.mPrograms.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L8;
        SQLiteClosable r101 = r100.next().getKey();
        if (r101 == null) goto L4;
        r101.onAllReferencesReleasedFromContainer();
        goto L4
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (isOpen() == true) goto L5;
        return;
    L5:
        lock();
        closeClosable();     // Catch: Throwable -> L9
        onAllReferencesReleased();     // Catch: Throwable -> L9
        unlock();
        return;
    L9:
        th = move-exception;
        unlock();
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void disableWriteAheadLogging() {
        if (inTransaction() == true) goto L7;
        rawExecSQL("PRAGMA journal_mode = DELETE;");
        return;
    L7:
        throw new IllegalStateException("Write Ahead Logging cannot be disabled while in a transaction");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean enableWriteAheadLogging() {
        if (inTransaction() == true) goto L18;
        ArrayList<Pair<String, String>> r100 = getAttachedDbs(this);
        if (r100 == null) goto L10;
        if (r100.size() <= 1) goto L10;
        return false;
    L10:
        if (isReadOnly() == false) goto L12;
    L16:
        return false;
    L12:
        if (getPath().equals(MEMORY) == true) goto L16;
        rawExecSQL("PRAGMA journal_mode = WAL;");
        return true;
    L18:
        throw new IllegalStateException("Write Ahead Logging cannot be enabled while in a transaction");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void endTransaction() {
        if (isOpen() == false) goto L42;
        if (this.mLock.isHeldByCurrentThread() == false) goto L40;
    L36:
        th = move-exception;
        this.mTransactionListener = null;
        unlockForced();
        throw th;
    L8:
        if (this.mInnerTransactionIsSuccessful == false) goto L10;
        this.mInnerTransactionIsSuccessful = false;     // Catch: Throwable -> L36
    L13:
        if (this.mLock.getHoldCount() == 1) goto L16;
        this.mTransactionListener = null;
        unlockForced();
        return;
    L16:
        SQLiteTransactionListener r100 = this.mTransactionListener;     // Catch: Throwable -> L36
        if (r100 != null) goto L45;
    L25:
        e = null;
    L27:
        if (this.mTransactionIsSuccessful == false) goto L47;
        execSQL(COMMIT_SQL);     // Catch: Throwable -> L36
    L34:
        this.mTransactionListener = null;
        unlockForced();
        return;
    L47:
        execSQL("ROLLBACK;");     // Catch: SQLException -> L43 Throwable -> L36
        if (e == null) goto L34;
        throw e;     // Catch: SQLException -> L43 Throwable -> L36
    L45:
    L23:
        e = e;
        this.mTransactionIsSuccessful = false;     // Catch: Throwable -> L36
        goto L27
    L19:
        if (this.mTransactionIsSuccessful == false) goto L21;
        r100.onCommit();     // Catch: RuntimeException -> L23 Throwable -> L36
    L44:
    L21:
        r100.onRollback();     // Catch: RuntimeException -> L23 Throwable -> L36
        goto L44
    L10:
        this.mTransactionIsSuccessful = false;     // Catch: Throwable -> L36
        goto L13
    L40:
        throw new IllegalStateException("no transaction pending");
    L42:
        throw new IllegalStateException("database not open");
    }

    public void finalize() {
        if (isOpen() == false) goto L6;
        closeClosable();
        onAllReferencesReleased();
        return;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public List<Pair<String, String>> getAttachedDbs() {
        return getAttachedDbs(this);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getMaximumSize() {
        lock();
    L13:
        th = move-exception;
        SQLiteStatement r100 = null;
        Throwable th10 = th;
    L15:
        if (r100 == null) goto L17;
        r100.close();
    L17:
        unlock();
        throw th10;
    L4:
        if (isOpen() == false) goto L12;
        r100 = new SQLiteStatement(this, "PRAGMA max_page_count;");     // Catch: Throwable -> L13
        long r101 = r100.simpleQueryForLong() * getPageSize();
        r100.close();
        unlock();
        return r101;
    L9:
        th10 = th;
        goto L15
    L12:
        throw new IllegalStateException("database not open");     // Catch: Throwable -> L13
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long getPageSize() {
        lock();
    L13:
        th = move-exception;
        SQLiteStatement r100 = null;
        Throwable th10 = th;
    L15:
        if (r100 == null) goto L17;
        r100.close();
    L17:
        unlock();
        throw th10;
    L4:
        if (isOpen() == false) goto L12;
        r100 = new SQLiteStatement(this, "PRAGMA page_size;");     // Catch: Throwable -> L13
        long r101 = r100.simpleQueryForLong();     // Catch: Throwable -> L9
        r100.close();
        unlock();
        return r101;
    L9:
        th10 = th;
        goto L15
    L12:
        throw new IllegalStateException("database not open");     // Catch: Throwable -> L13
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int getVersion() {
        lock();
    L13:
        th = move-exception;
        SQLiteStatement r100 = null;
        Throwable th10 = th;
    L15:
        if (r100 == null) goto L17;
        r100.close();
    L17:
        unlock();
        throw th10;
    L4:
        if (isOpen() == false) goto L12;
        r100 = new SQLiteStatement(this, "PRAGMA user_version;");     // Catch: Throwable -> L13
        int r101 = (int) r100.simpleQueryForLong();
        r100.close();
        unlock();
        return r101;
    L9:
        th10 = th;
        goto L15
    L12:
        throw new IllegalStateException("database not open");     // Catch: Throwable -> L13
    }

    @Override // net.sqlcipher.database.SQLiteClosable
    public void onAllReferencesReleased() {
        if (isOpen() == true) goto L5;
        return;
    L5:
        if (SQLiteDebug.DEBUG_SQL_CACHE == false) goto L7;
        this.mTimeClosed = getTime();
    L7:
        dbclose();
        WeakHashMap<SQLiteDatabase, Object> r100 = sActiveDatabases;
        monitor-enter(r100);
        sActiveDatabases.remove(this);     // Catch: Throwable -> L12
        monitor-exit(r100);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setTransactionSuccessful() {
        if (isOpen() == false) goto L15;
        if (this.mLock.isHeldByCurrentThread() == false) goto L13;
        if (this.mInnerTransactionIsSuccessful == true) goto L11;
        this.mInnerTransactionIsSuccessful = true;
        return;
    L11:
        throw new IllegalStateException("setTransactionSuccessful may only be called once per call to beginTransaction");
    L13:
        throw new IllegalStateException("no transaction pending");
    L15:
        throw new IllegalStateException("database not open");
    }

    public boolean yieldIfContended() {
        if (isOpen() == true) goto L6;
        return false;
    L6:
        return yieldIfContendedHelper(false, -1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely() {
        if (isOpen() == true) goto L7;
        return false;
    L7:
        return yieldIfContendedHelper(true, -1);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public final String getPath() {
        return this.mPath;
    }

    private boolean containsNull(char[] r100) {
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.length <= 0) goto L15;
        int r101 = r100.length;
        int r102 = 0;
    L7:
        if (r102 >= r101) goto L17;
        if (r100[r102] == 0) goto L10;
        r102 = r102 + 1;
        goto L7
    L10:
        return true;
    L17:
        return false;
    L15:
        return false;
    }

    public static String findEditTable(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L16;
        int r101 = r100.indexOf(32);
        int r102 = r100.indexOf(44);
        if (r101 <= 0) goto L10;
        if (r101 < r102) goto L9;
        if (r102 >= 0) goto L10;
    L9:
        return r100.substring(0, r101);
    L10:
        if (r102 <= 0) goto L17;
        if (r102 < r101) goto L14;
        if (r101 < 0) goto L14;
        return r100;
    L14:
        return r100.substring(0, r102);
    L17:
        return r100;
    L16:
        throw new IllegalStateException("Invalid tables");
    }

    private static ArrayList<Pair<String, String>> getAttachedDbs(SQLiteDatabase r100) {
        if (r100.isOpen() == true) goto L5;
        return null;
    L5:
        ArrayList<Pair<String, String>> r101 = new ArrayList();
        Cursor r102 = r100.rawQuery("pragma database_list;", null);
    L7:
        if (r102.moveToNext() == false) goto L9;
        r101.add(new Pair(r102.getString(1), r102.getString(2)));
        goto L7
    L9:
        r102.close();
        return r101;
    }

    public static byte[] getBytes(char[] r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length == 0) goto L10;
        CharBuffer r101 = CharBuffer.wrap(r100);
        ByteBuffer r102 = Charset.forName("UTF-8").encode(r101);
        byte[] r103 = new byte[r102.limit()];
        r102.get(r103);
        return r103;
    L10:
        return null;
    }

    public static char[] getChars(byte[] r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        if (r100.length == 0) goto L10;
        ByteBuffer r101 = ByteBuffer.wrap(r100);
        CharBuffer r102 = Charset.forName("UTF-8").decode(r101);
        char[] r103 = new char[r102.limit()];
        r102.get(r103);
        return r103;
    L10:
        return null;
    }

    private Pair<Boolean, String> getResultFromPragma(String r100) {
        Pair<Boolean, String> r101 = new Pair(Boolean.FALSE, "");
        Cursor r102 = rawQuery(r100, new Object[0]);
        if (r102 != null) goto L6;
        return r101;
    L6:
        if (r102.moveToFirst() == false) goto L8;
        String r103 = r102.getString(0);
        r101 = new Pair(Boolean.TRUE, r103);
    L8:
        r102.close();
        return r101;
    }

    public static synchronized void loadLibs(Context r100) {
        monitor-enter(SQLiteDatabase.class);
        loadLibs(r100, r100.getFilesDir());     // Catch: Throwable -> L7
        monitor-exit(SQLiteDatabase.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void addSQLiteClosable(SQLiteClosable r100) {
        lock();
        this.mPrograms.put(r100, null);     // Catch: Throwable -> L6
        unlock();
        return;
    L6:
        th = move-exception;
        unlock();
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListener(final android.database.sqlite.SQLiteTransactionListener r100) {
        beginTransactionWithListener(new AnonymousClass4(this, r100));
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void beginTransactionWithListenerNonExclusive(final android.database.sqlite.SQLiteTransactionListener r100) {
        beginTransactionWithListenerNonExclusive(new AnonymousClass5(this, r100));
    }

    public void changePassword(String r100) throws SQLiteException {
        if (isOpen() == false) goto L8;
        if (r100 == null) goto L9;
        byte[] r101 = getBytes(r100.toCharArray());
        rekey(r101);
        Arrays.fill(r101, (byte) 0);
        return;
    L9:
        return;
    L8:
        throw new SQLiteException("database not open");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public SQLiteStatement compileStatement(String r100) throws SQLException {
        lock();
    L10:
        th = move-exception;
        unlock();
        throw th;
    L4:
        if (isOpen() == false) goto L9;
        SQLiteStatement r101 = new SQLiteStatement(this, r100);     // Catch: Throwable -> L10
        unlock();
        return r101;
    L9:
        throw new IllegalStateException("database not open");     // Catch: Throwable -> L10
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String r100) throws SQLException {
        SystemClock.uptimeMillis();
        lock();
    L12:
        e = move-exception;
        onCorruption();     // Catch: Throwable -> L10
        throw e;     // Catch: Throwable -> L10
    L4:
        if (isOpen() == false) goto L9;
        native_execSQL(r100);     // Catch: Throwable -> L10 SQLiteDatabaseCorruptException -> L12
        unlock();
        return;
    L9:
        throw new IllegalStateException("database not open");     // Catch: Throwable -> L10 SQLiteDatabaseCorruptException -> L12
    L10:
        th = move-exception;
        unlock();
        throw th;
    }

    public SQLiteCompiledSql getCompiledStatementForSql(String r100) {
        Map<String, SQLiteCompiledSql> r101 = this.mCompiledQueries;
        monitor-enter(r101);
    L20:
        th = move-exception;
        throw th;
    L5:
        if (this.mMaxSqlCacheSize != 0) goto L10;
        boolean r102 = SQLiteDebug.DEBUG_SQL_STATEMENTS;     // Catch: Throwable -> L20
        monitor-exit(r101);     // Catch: Throwable -> L20
        return null;
    L10:
        SQLiteCompiledSql r103 = this.mCompiledQueries.get(r100);     // Catch: Throwable -> L20
        if (r103 == null) goto L13;
        boolean r104 = true;
    L14:
        monitor-exit(r101);     // Catch: Throwable -> L20
        if (r104 == false) goto L17;
        this.mNumCacheHits++;
    L18:
        boolean r105 = SQLiteDebug.DEBUG_SQL_STATEMENTS;
        return r103;
    L17:
        this.mNumCacheMisses++;
        goto L18
    L13:
        r104 = false;
        goto L14
    }

    public boolean isInCompiledSqlCache(String r100) {
        Map<String, SQLiteCompiledSql> r101 = this.mCompiledQueries;
        monitor-enter(r101);
        boolean r102 = this.mCompiledQueries.containsKey(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean needUpgrade(int r100) {
        if (r100 <= getVersion()) goto L5;
        return true;
    L5:
        return false;
    }

    public void purgeFromCompiledSqlCache(String r100) {
        Map<String, SQLiteCompiledSql> r101 = this.mCompiledQueries;
        monitor-enter(r101);
        this.mCompiledQueries.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public android.database.Cursor query(SupportSQLiteQuery r100) {
        return query(r100, null);
    }

    public void rawExecSQL(String r100) {
        SystemClock.uptimeMillis();
        lock();
    L12:
        e = move-exception;
        onCorruption();     // Catch: Throwable -> L10
        throw e;     // Catch: Throwable -> L10
    L4:
        if (isOpen() == false) goto L9;
        native_rawExecSQL(r100);     // Catch: Throwable -> L10 SQLiteDatabaseCorruptException -> L12
        unlock();
        return;
    L9:
        throw new IllegalStateException("database not open");     // Catch: Throwable -> L10 SQLiteDatabaseCorruptException -> L12
    L10:
        th = move-exception;
        unlock();
        throw th;
    }

    public void removeSQLiteClosable(SQLiteClosable r100) {
        lock();
        this.mPrograms.remove(r100);     // Catch: Throwable -> L6
        unlock();
        return;
    L6:
        th = move-exception;
        unlock();
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setForeignKeyConstraintsEnabled(boolean r100) {
        if (inTransaction() == true) goto L11;
        Object[] r101 = new Object[1];
        if (r100 == false) goto L7;
        String r102 = "ON";
    L8:
        r101[0] = r102;
        execSQL(String.format("PRAGMA foreign_keys = %s;", r101));
        return;
    L7:
        r102 = "OFF";
        goto L8
    L11:
        throw new IllegalStateException("Foreign key constraints may not be changed while in a transaction");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setLocale(Locale r100) {
        lock();
        native_setLocale(r100.toString(), this.mFlags);     // Catch: Throwable -> L6
        unlock();
        return;
    L6:
        th = move-exception;
        unlock();
        throw th;
    }

    public void setLockingEnabled(boolean r100) {
        this.mLockingEnabled = r100;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public synchronized void setMaxSqlCacheSize(int r100) {
        monitor-enter(this);
        if (r100 > 250) goto L14;
        if (r100 < 0) goto L14;
        if (r100 < this.mMaxSqlCacheSize) goto L12;
        this.mMaxSqlCacheSize = r100;     // Catch: Throwable -> L15
        monitor-exit(this);
        return;
    L12:
        throw new IllegalStateException("cannot set cacheSize to a value less than the value set with previous setMaxSqlCacheSize() call.");     // Catch: Throwable -> L15
    L14:
        throw new IllegalStateException("expected value between 0 and 250");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long setMaximumSize(long r110) {
        lock();
        SQLiteStatement r100 = null;
    L16:
        th = th;
    L17:
        if (r100 == null) goto L19;
        r100.close();
    L19:
        unlock();
        throw th;
    L4:
        if (isOpen() == false) goto L15;
        long r101 = getPageSize();     // Catch: Throwable -> L16
        long r102 = r110 / r101;     // Catch: Throwable -> L16
        if ((r110 % r101) == 0) goto L8;
        r102 = r102 + 1;     // Catch: Throwable -> L16
    L8:
        SQLiteStatement r111 = new SQLiteStatement(this, "PRAGMA max_page_count = " + r102);     // Catch: Throwable -> L16
        long r103 = r111.simpleQueryForLong() * r101;
        r111.close();
        unlock();
        return r103;
    L12:
        th = th;
        r100 = r111;
        goto L17
    L15:
        throw new IllegalStateException("database not open");     // Catch: Throwable -> L16
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setPageSize(long r100) {
        execSQL("PRAGMA page_size = " + r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void setVersion(int r100) {
        execSQL("PRAGMA user_version = " + r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public boolean yieldIfContendedSafely(long r100) {
        if (isOpen() == true) goto L7;
        return false;
    L7:
        return yieldIfContendedHelper(true, r100);
    }

    public void beginTransactionWithListener(SQLiteTransactionListener r100) {
        beginTransactionWithListenerInternal(r100, SQLiteDatabaseTransactionType.Exclusive);
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener r100) {
        beginTransactionWithListenerInternal(r100, SQLiteDatabaseTransactionType.Immediate);
    }

    public void changePassword(char[] r100) throws SQLiteException {
        if (isOpen() == false) goto L8;
        if (r100 == null) goto L9;
        byte[] r101 = getBytes(r100);
        rekey(r101);
        Arrays.fill(r101, (byte) 0);
        return;
    L9:
        return;
    L8:
        throw new SQLiteException("database not open");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public /* bridge */ /* synthetic */ SupportSQLiteStatement compileStatement(String r100) {
        return compileStatement(r100);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public android.database.Cursor query(String r100) {
        return rawQuery(r100, null);
    }

    public static /* synthetic */ void access$000(SQLiteDatabase r100, byte[] r101) throws SQLException {
        r100.key(r101);
    }

    public static /* synthetic */ void access$100(SQLiteDatabase r100, char[] r101) throws SQLException {
        r100.key_mutf8(r101);
    }

    private void beginTransactionWithListenerInternal(SQLiteTransactionListener r100, SQLiteDatabaseTransactionType r101) {
        lockForced();
        if (isOpen() == false) goto L34;
    L30:
        th = move-exception;
        unlockForced();
        throw th;
    L5:
        if (this.mLock.getHoldCount() <= 1) goto L12;
        if (this.mInnerTransactionIsSuccessful == true) goto L10;
        return;
    L10:
        throw new IllegalStateException("Cannot call beginTransaction between calling setTransactionSuccessful and endTransaction");     // Catch: Throwable -> L30
    L12:
        if (r101 != SQLiteDatabaseTransactionType.Exclusive) goto L15;
        execSQL("BEGIN EXCLUSIVE;");     // Catch: Throwable -> L30
    L20:
        this.mTransactionListener = r100;     // Catch: Throwable -> L30
        this.mTransactionIsSuccessful = true;     // Catch: Throwable -> L30
        this.mInnerTransactionIsSuccessful = false;     // Catch: Throwable -> L30
        if (r100 != null) goto L36;
        return;
    L36:
        r100.onBegin();     // Catch: RuntimeException -> L24 Throwable -> L30
    L38:
        return;
    L24:
        e = move-exception;
        execSQL("ROLLBACK;");     // Catch: Throwable -> L30
        throw e;     // Catch: Throwable -> L30
    L15:
        if (r101 != SQLiteDatabaseTransactionType.Immediate) goto L18;
        execSQL("BEGIN IMMEDIATE;");     // Catch: Throwable -> L30
        goto L20
    L18:
        if (r101 != SQLiteDatabaseTransactionType.Deferred) goto L29;
        execSQL("BEGIN DEFERRED;");     // Catch: Throwable -> L30
        goto L20
    L29:
        throw new IllegalArgumentException(String.format("%s is an unsupported transaction type", new Object[]{r101}));     // Catch: Throwable -> L30
    L34:
        throw new IllegalStateException("database not open");
    }

    public static SQLiteDatabase create(CursorFactory r100, String r101) {
        if (r101 != null) goto L4;
        char[] r102 = null;
    L6:
        return openDatabase(MEMORY, r102, r100, 268435456);
    L4:
        r102 = r101.toCharArray();
        goto L6
    }

    private static long getPragmaVal(SQLiteDatabase r100, String r101) {
        if (r100.isOpen() == true) goto L6;
        return 0;
    L6:
        SQLiteStatement r102 = null;
        SQLiteStatement r103 = new SQLiteStatement(r100, "PRAGMA " + r101);     // Catch: Throwable -> L13
        long r104 = r103.simpleQueryForLong();     // Catch: Throwable -> L11
        r103.close();
        return r104;
    L11:
        th = th;
        r102 = r103;
    L14:
        if (r102 == null) goto L16;
        r102.close();
    L16:
        throw th;
    L13:
        th = th;
        goto L14
    }

    private void keyDatabase(SQLiteDatabaseHook r100, Runnable r101) {
        if (r100 == null) goto L4;
        r100.preKey(this);
    L4:
        if (r101 == null) goto L6;
        r101.run();
    L6:
        if (r100 == null) goto L9;
        r100.postKey(this);
    L9:
        if (SQLiteDebug.DEBUG_SQL_CACHE == false) goto L17;
        this.mTimeOpened = getTime();
    L17:
        Cursor r102 = rawQuery("select count(*) from sqlite_master;", new String[0]);     // Catch: RuntimeException -> L15
        if (r102 == null) goto L19;
        r102.moveToFirst();     // Catch: RuntimeException -> L15
        r102.getInt(0);     // Catch: RuntimeException -> L15
        r102.close();     // Catch: RuntimeException -> L15
        return;
    L19:
        return;
    L15:
        e = move-exception;
        throw e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.util.zip.ZipInputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    private static void loadICUData(Context r100, File r101) {
        PolarisFileWrapper r102 = new PolarisFileWrapper(r101, "icu");
        PolarisFileWrapper r103 = new PolarisFileWrapper(r102, "icudt46l.dat");
        ?? r104 = 0;
        ZipInputStream r105 = null;
    L43:
        th = th;
        PolarisFileOutputStreamWrapper r106 = null;
        r104 = r102;
    L45:
        if (r104 != 0) goto L55;
    L49:
        if (r106 == null) goto L54;
        r106.flush();     // Catch: IOException -> L47
        r106.close();     // Catch: IOException -> L47
    L47:
        e = move-exception;
        throw new RuntimeException(e);
    L54:
        throw th;
    L55:
        r104.close();     // Catch: IOException -> L47
    L36:
        e = e;
    L39:
        if (r103.exists() == false) goto L42;
        r103.delete();     // Catch: Throwable -> L43
    L42:
        throw new RuntimeException(e);     // Catch: Throwable -> L43
    L34:
        th = th;
        r106 = null;
        goto L45
    L4:
        if (r102.exists() == true) goto L7;
        r102.mkdirs();     // Catch: Throwable -> L34 Exception -> L36
    L7:
        if (r103.exists() == true) goto L23;
        ZipInputStream r107 = new ZipInputStream(r100.getAssets().open("icudt46l.zip"));     // Catch: Throwable -> L34 Exception -> L36
        r107.getNextEntry();     // Catch: Exception -> L21 Throwable -> L43
        PolarisFileOutputStreamWrapper r108 = new PolarisFileOutputStreamWrapper(r103);     // Catch: Exception -> L21 Throwable -> L43
        byte[] r109 = new byte[1024];     // Catch: Throwable -> L17 Exception -> L19
    L12:
        int r110 = r107.read(r109);     // Catch: Throwable -> L17 Exception -> L19
        if (r110 <= 0) goto L16;
        r108.write(r109, 0, r110);     // Catch: Throwable -> L17 Exception -> L19
    L16:
        r105 = r107;
    L24:
        if (r105 != null) goto L58;
    L28:
        if (r108 == null) goto L33;
        r108.flush();     // Catch: IOException -> L26
        r108.close();     // Catch: IOException -> L26
        return;
    L26:
        e = move-exception;
        throw new RuntimeException(e);
    L33:
        return;
    L58:
        r105.close();     // Catch: IOException -> L26
    L19:
        e = move-exception;
        e = e;
    L17:
        th = move-exception;
        r104 = r107;
        r106 = r108;
        th = th;
    L21:
        e = e;
        goto L39
    L23:
        r108 = null;
        goto L24
    }

    public static synchronized void loadLibs(Context r100, File r101) {
        monitor-enter(SQLiteDatabase.class);
        loadLibs(r100, r101, new AnonymousClass1());     // Catch: Throwable -> L7
        monitor-exit(SQLiteDatabase.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void openDatabaseInternal(final byte[] r100, SQLiteDatabaseHook r101) {
        dbopen(this.mPath, this.mFlags);
        keyDatabase(r101, new AnonymousClass2(this, r100));     // Catch: Throwable -> L5 RuntimeException -> L7
    L30:
        return;
    L5:
        th = move-exception;
        if (1 == 0) goto L25;
        dbclose();
        if (SQLiteDebug.DEBUG_SQL_CACHE == false) goto L25;
        this.mTimeClosed = getTime();
    L25:
        throw th;
    L7:
        e = move-exception;
        final char[] r102 = getChars(r100);     // Catch: Throwable -> L5
        if (containsNull(r102) == false) goto L20;
        keyDatabase(r101, new AnonymousClass3(this, r100, r102));     // Catch: Throwable -> L5
        if (r100 != null) goto L13;
    L15:
        if (r102 != null) goto L17;
        return;
    L17:
        if (r102.length <= 0) goto L29;
        Arrays.fill(r102, 0);     // Catch: Throwable -> L5
        return;
    L29:
        return;
    L13:
        if (r100.length <= 0) goto L15;
        rekey(r100);     // Catch: Throwable -> L5
        goto L15
    L20:
        throw e;     // Catch: Throwable -> L5
    }

    private boolean yieldIfContendedHelper(boolean r100, long r101) {
        if (this.mLock.getQueueLength() != 0) goto L6;
        this.mLockAcquiredWallTime = SystemClock.elapsedRealtime();
        this.mLockAcquiredThreadTime = Debug.threadCpuTimeNanos();
        return false;
    L6:
        setTransactionSuccessful();
        SQLiteTransactionListener r102 = this.mTransactionListener;
        endTransaction();
        if (r100 == false) goto L14;
        if (isDbLockedByCurrentThread() == false) goto L14;
        throw new IllegalStateException("Db locked more than once. yielfIfContended cannot yield");
    L14:
        if (r101 > 0) goto L16;
    L26:
        beginTransactionWithListener(r102);
        return true;
    L16:
        if (r101 <= 0) goto L26;
        if (r101 >= 1000) goto L20;
        long r103 = r101;
    L28:
        Thread.sleep(r103);     // Catch: InterruptedException -> L23
    L24:
        r101 = r101 - 1000;
        if (this.mLock.getQueueLength() != 0) goto L16;
    L23:
        Thread.interrupted();
        goto L24
    L20:
        r103 = 1000;
        goto L28
    }

    public void addToCompiledQueries(String r100, SQLiteCompiledSql r101) {
        if (this.mMaxSqlCacheSize != 0) goto L6;
        boolean r102 = SQLiteDebug.DEBUG_SQL_STATEMENTS;
        return;
    L6:
        Map<String, SQLiteCompiledSql> r103 = this.mCompiledQueries;
        monitor-enter(r103);
    L18:
        th = move-exception;
        throw th;
    L9:
        if (this.mCompiledQueries.get(r100) == null) goto L13;
        monitor-exit(r103);     // Catch: Throwable -> L18
        return;
    L13:
        if (this.mCompiledQueries.size() != this.mMaxSqlCacheSize) goto L15;
        this.mCacheFullWarnings++;     // Catch: Throwable -> L18
    L16:
        monitor-exit(r103);     // Catch: Throwable -> L18
        return;
    L15:
        this.mCompiledQueries.put(r100, r101);     // Catch: Throwable -> L18
        boolean r104 = SQLiteDebug.DEBUG_SQL_STATEMENTS;     // Catch: Throwable -> L18
        goto L16
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public void execSQL(String r100, Object[] r101) throws SQLException {
        if (r101 == null) goto L24;
        SystemClock.uptimeMillis();
        lock();
        AutoCloseable r102 = null;
    L14:
        th = move-exception;
        if (0 == 0) goto L21;
        r102.close();
    L21:
        unlock();
        throw th;
    L16:
        e = move-exception;
        onCorruption();     // Catch: Throwable -> L14
        throw e;     // Catch: Throwable -> L14
    L5:
        if (isOpen() == false) goto L13;
        SQLiteStatement r103 = compileStatement(r100);     // Catch: Throwable -> L14 SQLiteDatabaseCorruptException -> L16
        int r104 = r101.length;     // Catch: Throwable -> L14 SQLiteDatabaseCorruptException -> L16
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L9;
        int r106 = r105 + 1;     // Catch: Throwable -> L14 SQLiteDatabaseCorruptException -> L16
        DatabaseUtils.bindObjectToProgram(r103, r106, r101[r105]);     // Catch: Throwable -> L14 SQLiteDatabaseCorruptException -> L16
        r105 = r106;
        goto L7
    L9:
        r103.execute();     // Catch: Throwable -> L14 SQLiteDatabaseCorruptException -> L16
        r103.close();
        unlock();
        return;
    L13:
        throw new IllegalStateException("database not open");     // Catch: Throwable -> L14 SQLiteDatabaseCorruptException -> L16
    L24:
        throw new IllegalArgumentException("Empty bindArgs");
    }

    public SQLiteQueryStats getQueryStats(String r100, Object[] r101) {
        execSQL(String.format("CREATE TABLE tempstat AS %s", new Object[]{r100}), r101);     // Catch: SQLiteException -> L13
        Cursor r102 = rawQuery("SELECT sum(payload) FROM dbstat WHERE name = 'tempstat';", new Object[0]);     // Catch: SQLiteException -> L13
        if (r102 == null) goto L5;
        r102.moveToFirst();     // Catch: SQLiteException -> L13
        long r103 = r102.getLong(0);     // Catch: SQLiteException -> L13
        r102.close();     // Catch: SQLiteException -> L13
        Cursor r104 = rawQuery("SELECT max(mx_payload) FROM dbstat WHERE name = 'tempstat';", new Object[0]);     // Catch: SQLiteException -> L13
        if (r104 == null) goto L9;
        r104.moveToFirst();     // Catch: SQLiteException -> L13
        long r105 = r104.getLong(0);     // Catch: SQLiteException -> L13
        r104.close();     // Catch: SQLiteException -> L13
        execSQL("DROP TABLE tempstat;");     // Catch: SQLiteException -> L13
        return new SQLiteQueryStats(r103, r105);
    L9:
        return new SQLiteQueryStats(r103, 0);
    L5:
        return new SQLiteQueryStats(0, 0);
    L13:
        e = move-exception;
        execSQL("DROP TABLE IF EXISTS tempstat;");
        throw e;
    }

    public void markTableSyncable(String r100, String r101) {
        if (isOpen() == false) goto L7;
        markTableSyncable(r100, DBDefinition.ID, r100, r101);
        return;
    L7:
        throw new SQLiteException("database not open");
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public android.database.Cursor query(SupportSQLiteQuery r100, CancellationSignal r101) {
        String r102 = r100.getSql();
        Object[] r103 = new Object[r100.getArgCount()];
        SQLiteDirectCursorDriver r104 = new SQLiteDirectCursorDriver(this, r102, null);
        SQLiteQuery r105 = new SQLiteQuery(this, r102, 0, r103);
        r100.bindTo(r105);
        return new CrossProcessCursorWrapper(new SQLiteCursor(this, r104, null, r105));
    }

    public Cursor rawQuery(String r100, Object[] r101) {
        if (isOpen() == false) goto L27;
        if (this.mSlowQueryThreshold == (-1)) goto L7;
        long r102 = System.currentTimeMillis();
    L8:
        SQLiteDirectCursorDriver r103 = new SQLiteDirectCursorDriver(this, r100, null);
        Cursor r104 = r103.query(this.mFactory, r101);     // Catch: Throwable -> L19
        if (this.mSlowQueryThreshold == (-1)) goto L18;
        if (r104 == null) goto L15;
        r104.getCount();
    L15:
        if ((System.currentTimeMillis() - r102) < this.mSlowQueryThreshold) goto L18;
        r103.toString();
    L18:
        return new CrossProcessCursorWrapper(r104);
    L19:
        th = move-exception;
        if (this.mSlowQueryThreshold != (-1)) goto L23;
    L25:
        throw th;
    L23:
        if ((System.currentTimeMillis() - r102) < this.mSlowQueryThreshold) goto L25;
        r103.toString();
        goto L25
    L7:
        r102 = 0;
        goto L8
    L27:
        throw new IllegalStateException("database not open");
    }

    public void rowUpdated(String r100, long r101) {
        Map<String, SyncUpdateInfo> r102 = this.mSyncUpdateInfo;
        monitor-enter(r102);
        SyncUpdateInfo r103 = this.mSyncUpdateInfo.get(r100);     // Catch: Throwable -> L9
        monitor-exit(r102);     // Catch: Throwable -> L9
        if (r103 == null) goto L14;
        execSQL("UPDATE " + r103.masterTable + " SET _sync_dirty=1 WHERE _id=(SELECT " + r103.foreignKey + " FROM " + r100 + " WHERE _id=" + r101 + ")");
        return;
    L14:
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public int status(int r100, boolean r101) {
        return native_status(r100, r101);
    }

    public static SQLiteDatabase create(CursorFactory r100, char[] r101) {
        return openDatabase(MEMORY, r101, r100, 268435456);
    }

    public static synchronized void loadLibs(Context r100, LibraryLoader r101) {
        monitor-enter(SQLiteDatabase.class);
        loadLibs(r100, r100.getFilesDir(), r101);     // Catch: Throwable -> L7
        monitor-exit(SQLiteDatabase.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private void openDatabaseInternal(char[] r100, SQLiteDatabaseHook r101) {
        openDatabaseInternal(getBytes(r100), r101);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public android.database.Cursor query(String r100, Object[] r101) {
        return rawQuery(r100, r101);
    }

    public Cursor rawQuery(String r100, String[] r101) {
        return rawQueryWithFactory(null, r100, r101, null);
    }

    public static synchronized void loadLibs(Context r100, File r101, LibraryLoader r102) {
        monitor-enter(SQLiteDatabase.class);
        r102.loadLibraries(new String[]{"sqlcipher"});     // Catch: Throwable -> L7
        monitor-exit(SQLiteDatabase.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static SQLiteDatabase openOrCreateDatabase(String r100, byte[] r101, CursorFactory r102) {
        return openDatabase(r100, r101, r102, 268435456, null, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int delete(String r100, String r101, Object[] r102) {
        lock();
        AutoCloseable r103 = null;
    L21:
        e = move-exception;
        onCorruption();     // Catch: Throwable -> L19
        throw e;     // Catch: Throwable -> L19
    L4:
        if (isOpen() == false) goto L18;
        StringBuilder r104 = new StringBuilder("DELETE FROM ");     // Catch: Throwable -> L19 SQLiteDatabaseCorruptException -> L21
        r104.append(r100);     // Catch: Throwable -> L19 SQLiteDatabaseCorruptException -> L21
        if (TextUtils.isEmpty(r101) == true) goto L8;
        String r105 = " WHERE " + r101;     // Catch: Throwable -> L19 SQLiteDatabaseCorruptException -> L21
    L9:
        r104.append(r105);     // Catch: Throwable -> L19 SQLiteDatabaseCorruptException -> L21
        SQLiteStatement r106 = compileStatement(r104.toString());     // Catch: Throwable -> L19 SQLiteDatabaseCorruptException -> L21
        if (r102 == null) goto L14;
        int r107 = r102.length;     // Catch: Throwable -> L19 SQLiteDatabaseCorruptException -> L21
        int r108 = 0;
    L12:
        if (r108 >= r107) goto L14;
        int r109 = r108 + 1;     // Catch: Throwable -> L19 SQLiteDatabaseCorruptException -> L21
        DatabaseUtils.bindObjectToProgram(r106, r109, r102[r108]);     // Catch: Throwable -> L19 SQLiteDatabaseCorruptException -> L21
        r108 = r109;
    L14:
        r106.execute();     // Catch: Throwable -> L19 SQLiteDatabaseCorruptException -> L21
        int r110 = lastChangeCount();     // Catch: Throwable -> L19 SQLiteDatabaseCorruptException -> L21
        r106.close();
        unlock();
        return r110;
    L8:
        r105 = "";
        goto L9
    L18:
        throw new IllegalStateException("database not open");     // Catch: Throwable -> L19 SQLiteDatabaseCorruptException -> L21
    L19:
        th = move-exception;
        if (0 == 0) goto L26;
        r103.close();
    L26:
        unlock();
        throw th;
    }

    public long insert(String r100, String r101, ContentValues r102) {
        return insertWithOnConflict(r100, r101, r102, 0);
    L5:
        return -1;
    }

    public long insertOrThrow(String r100, String r101, ContentValues r102) throws SQLException {
        return insertWithOnConflict(r100, r101, r102, 0);
    }

    public void markTableSyncable(String r100, String r101, String r102) {
        if (isOpen() == false) goto L7;
        markTableSyncable(r100, r101, r102, null);
        return;
    L7:
        throw new SQLiteException("database not open");
    }

    public long replace(String r100, String r101, ContentValues r102) {
        return insertWithOnConflict(r100, r101, r102, 5);
    L5:
        return -1;
    }

    public long replaceOrThrow(String r100, String r101, ContentValues r102) throws SQLException {
        return insertWithOnConflict(r100, r101, r102, 5);
    }

    public static SQLiteDatabase openOrCreateDatabase(String r100, String r101, CursorFactory r102) {
        return openDatabase(r100, r101, r102, 268435456, null);
    }

    public int delete(String r100, String r101, String[] r102) {
        return delete(r100, r101, r102);
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public long insert(String r100, int r101, ContentValues r102) throws android.database.SQLException {
        return insertWithOnConflict(r100, null, r102, r101);
    }

    public static SQLiteDatabase openOrCreateDatabase(String r100, char[] r101, CursorFactory r102) {
        return openDatabase(r100, r101, r102, 268435456, null);
    }

    public static SQLiteDatabase openOrCreateDatabase(File r100, String r101, CursorFactory r102) {
        return openOrCreateDatabase(r100, r101, r102, null);
    }

    private SQLiteDatabase(String r100, CursorFactory r101, int r102, DatabaseErrorHandler r103) {
        this.mLock = new ReentrantLock(true);
        this.mLockAcquiredWallTime = 0;
        this.mLockAcquiredThreadTime = 0;
        this.mLastLockMessageTime = 0;
        this.mLastSqlStatement = null;
        this.mNativeHandle = 0;
        this.mTempTableSequence = 0;
        this.mPathForLogs = null;
        this.mCompiledQueries = new HashMap();
        this.mMaxSqlCacheSize = 250;
        this.mTimeOpened = null;
        this.mTimeClosed = null;
        this.mStackTrace = null;
        this.mLockingEnabled = true;
        this.mSyncUpdateInfo = new HashMap();
        if (r100 == null) goto L7;
        this.mFlags = r102;
        this.mPath = r100;
        this.mSlowQueryThreshold = -1;
        this.mStackTrace = new DatabaseObjectNotClosedException().fillInStackTrace();
        this.mFactory = r101;
        this.mPrograms = new WeakHashMap();
        this.mErrorHandler = r103;
        return;
    L7:
        throw new IllegalArgumentException("path should not be null");
    }

    private void markTableSyncable(String r100, String r101, String r102, String r103) {
        lock();
        native_execSQL("SELECT _sync_dirty FROM " + r102 + " LIMIT 0");     // Catch: Throwable -> L12
        native_execSQL("SELECT " + r101 + " FROM " + r100 + " LIMIT 0");     // Catch: Throwable -> L12
        unlock();
        SyncUpdateInfo r104 = new SyncUpdateInfo(r102, r103, r101);
        Map<String, SyncUpdateInfo> r105 = this.mSyncUpdateInfo;
        monitor-enter(r105);
        this.mSyncUpdateInfo.put(r100, r104);     // Catch: Throwable -> L9
        monitor-exit(r105);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    L12:
        th = move-exception;
        unlock();
        throw th;
    }

    public static SQLiteDatabase openDatabase(String r100, char[] r101, CursorFactory r102, int r103) {
        return openDatabase(r100, r101, r102, r103, null, null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String r100, byte[] r101, CursorFactory r102, SQLiteDatabaseHook r103) {
        return openDatabase(r100, r101, r102, 268435456, r103, null);
    }

    public long insertWithOnConflict(String r100, String r101, ContentValues r102, int r103) {
        if (isOpen() == false) goto L39;
        StringBuilder r104 = new StringBuilder(152);
        r104.append("INSERT");
        r104.append(CONFLICT_VALUES[r103]);
        r104.append(" INTO ");
        r104.append(r100);
        StringBuilder r105 = new StringBuilder(40);
        int r106 = 0;
        SQLiteStatement r107 = null;
        if (r102 != null) goto L7;
    L15:
        r104.append("(" + r101 + ") ");
        r105.append("NULL");
        Set<Map.Entry<String, Object>> r108 = null;
    L16:
        r104.append(" VALUES(");
        r104.append(r105);
        r104.append(");");
        lock();
        r107 = compileStatement(r104.toString());     // Catch: Throwable -> L29 SQLiteDatabaseCorruptException -> L31
        if (r108 == null) goto L22;
        int r109 = r108.size();     // Catch: Throwable -> L29 SQLiteDatabaseCorruptException -> L31
        Iterator<Map.Entry<String, Object>> r110 = r108.iterator();     // Catch: Throwable -> L29 SQLiteDatabaseCorruptException -> L31
    L20:
        if (r106 >= r109) goto L22;
        r106 = r106 + 1;     // Catch: Throwable -> L29 SQLiteDatabaseCorruptException -> L31
        DatabaseUtils.bindObjectToProgram(r107, r106, r110.next().getValue());     // Catch: Throwable -> L29 SQLiteDatabaseCorruptException -> L31
    L22:
        r107.execute();     // Catch: Throwable -> L29 SQLiteDatabaseCorruptException -> L31
        if (lastChangeCount() <= 0) goto L26;
        long r111 = lastInsertRow();     // Catch: Throwable -> L29 SQLiteDatabaseCorruptException -> L31
    L27:
        r107.close();
        unlock();
        return r111;
    L26:
        r111 = -1;
    L29:
        th = move-exception;
        if (r107 == null) goto L36;
        r107.close();
    L36:
        unlock();
        throw th;
    L31:
        e = move-exception;
        onCorruption();     // Catch: Throwable -> L29
        throw e;     // Catch: Throwable -> L29
    L7:
        if (r102.size() <= 0) goto L15;
        r108 = r102.valueSet();
        Iterator<Map.Entry<String, Object>> r112 = r108.iterator();
        r104.append('(');
        boolean r113 = false;
    L10:
        if (r112.hasNext() == false) goto L14;
        if (r113 == false) goto L13;
        r104.append(", ");
        r105.append(", ");
    L13:
        r104.append(r112.next().getKey());
        r105.append('?');
        r113 = true;
        goto L10
    L14:
        r104.append(')');
        goto L16
    L39:
        throw new IllegalStateException("database not open");
    }

    public Cursor rawQuery(String r100, String[] r101, int r102, int r103) {
        CursorWrapper r104 = (CursorWrapper) rawQueryWithFactory(null, r100, r101, null);
        ((SQLiteCursor) r104.getWrappedCursor()).setLoadStyle(r102, r103);
        return r104;
    }

    public Cursor rawQueryWithFactory(CursorFactory r100, String r101, String[] r102, String r103) {
        if (isOpen() == false) goto L30;
        if (this.mSlowQueryThreshold == (-1)) goto L7;
        long r104 = System.currentTimeMillis();
    L8:
        SQLiteDirectCursorDriver r105 = new SQLiteDirectCursorDriver(this, r101, r103);
        if (r100 == null) goto L31;
    L12:
        Cursor r106 = r105.query(r100, r102);     // Catch: Throwable -> L22
        if (this.mSlowQueryThreshold == (-1)) goto L21;
        if (r106 == null) goto L18;
        r106.getCount();
    L18:
        if ((System.currentTimeMillis() - r104) < this.mSlowQueryThreshold) goto L21;
        r105.toString();
    L21:
        return new CrossProcessCursorWrapper(r106);
    L22:
        th = move-exception;
        if (this.mSlowQueryThreshold != (-1)) goto L26;
    L28:
        throw th;
    L26:
        if ((System.currentTimeMillis() - r104) < this.mSlowQueryThreshold) goto L28;
        r105.toString();
        goto L28
    L31:
        r100 = this.mFactory;     // Catch: Throwable -> L22
        goto L12
    L7:
        r104 = 0;
        goto L8
    L30:
        throw new IllegalStateException("database not open");
    }

    public int update(String r100, ContentValues r101, String r102, String[] r110) {
        return updateWithOnConflict(r100, r101, r102, r110, 0);
    }

    public SQLiteDatabase(String r100, char[] r101, CursorFactory r102, int r103) {
        this(r100, r102, r103, null);
        openDatabaseInternal(r101, null);
    }

    public static SQLiteDatabase openDatabase(String r100, String r101, CursorFactory r102, int r103) {
        return openDatabase(r100, r101, r102, r103, null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String r100, String r101, CursorFactory r102, SQLiteDatabaseHook r103) {
        return openDatabase(r100, r101, r102, 268435456, r103);
    }

    public static SQLiteDatabase openOrCreateDatabase(String r100, char[] r101, CursorFactory r102, SQLiteDatabaseHook r103) {
        return openDatabase(r100, r101, r102, 268435456, r103);
    }

    public static SQLiteDatabase openOrCreateDatabase(File r100, String r101, CursorFactory r102, SQLiteDatabaseHook r103) {
        return openOrCreateDatabase(r100, r101, r102, r103, null);
    }

    public SQLiteDatabase(String r100, byte[] r101, CursorFactory r102, int r103, SQLiteDatabaseHook r104) {
        this(r100, r102, r103, null);
        openDatabaseInternal(r101, r104);
    }

    public static SQLiteDatabase openDatabase(String r100, String r101, CursorFactory r102, int r103, SQLiteDatabaseHook r110) {
        return openDatabase(r100, r101, r102, r103, r110, null);
    }

    public static SQLiteDatabase openOrCreateDatabase(String r100, String r101, CursorFactory r102, SQLiteDatabaseHook r103, DatabaseErrorHandler r110) {
        if (r101 != null) goto L4;
        char[] r104 = null;
    L6:
        return openDatabase(r100, r104, r102, 268435456, r103, r110);
    L4:
        r104 = r101.toCharArray();
        goto L6
    }

    @Override // androidx.sqlite.db.SupportSQLiteDatabase
    public int update(String r100, int r101, ContentValues r110, String r111, Object[] r112) {
        String[] r102 = new String[r112.length];
        int r103 = 0;
    L4:
        if (r103 >= r112.length) goto L7;
        r102[r103] = r112[r103].toString();
        r103 = r103 + 1;
        goto L4
    L7:
        return updateWithOnConflict(r100, r110, r111, r102, r101);
    }

    public int updateWithOnConflict(String r100, ContentValues r101, String r102, String[] r103, int r104) {
        if (r101 == null) goto L41;
        if (r101.size() == 0) goto L41;
        StringBuilder r105 = new StringBuilder(120);
        r105.append("UPDATE ");
        r105.append(CONFLICT_VALUES[r104]);
        r105.append(r100);
        r105.append(" SET ");
        Set<Map.Entry<String, Object>> r106 = r101.valueSet();
        Iterator<Map.Entry<String, Object>> r107 = r106.iterator();
    L7:
        if (r107.hasNext() == false) goto L12;
        r105.append(r107.next().getKey());
        r105.append("=?");
        if (r107.hasNext() == false) goto L7;
        r105.append(", ");
        goto L7
    L12:
        if (TextUtils.isEmpty(r102) == true) goto L14;
        r105.append(" WHERE ");
        r105.append(r102);
    L14:
        lock();
        AutoCloseable r108 = null;
    L29:
        th = move-exception;
        if (0 == 0) goto L38;
        r108.close();
    L38:
        unlock();
        throw th;
    L31:
        e = move-exception;
        throw e;     // Catch: Throwable -> L29
    L33:
        e = move-exception;
        onCorruption();     // Catch: Throwable -> L29
        throw e;     // Catch: Throwable -> L29
    L16:
        if (isOpen() == false) goto L28;
        SQLiteStatement r109 = compileStatement(r105.toString());     // Catch: Throwable -> L29 SQLException -> L31 SQLiteDatabaseCorruptException -> L33
        int r110 = r106.size();     // Catch: Throwable -> L29 SQLException -> L31 SQLiteDatabaseCorruptException -> L33
        Iterator<Map.Entry<String, Object>> r111 = r106.iterator();     // Catch: Throwable -> L29 SQLException -> L31 SQLiteDatabaseCorruptException -> L33
        int r112 = 0;
        int r113 = 1;
        int r114 = 0;
    L18:
        if (r114 >= r110) goto L20;
        DatabaseUtils.bindObjectToProgram(r109, r113, r111.next().getValue());     // Catch: Throwable -> L29 SQLException -> L31 SQLiteDatabaseCorruptException -> L33
        r113 = r113 + 1;     // Catch: Throwable -> L29 SQLException -> L31 SQLiteDatabaseCorruptException -> L33
        r114 = r114 + 1;     // Catch: Throwable -> L29 SQLException -> L31 SQLiteDatabaseCorruptException -> L33
        goto L18
    L20:
        if (r103 == null) goto L24;
        int r115 = r103.length;     // Catch: Throwable -> L29 SQLException -> L31 SQLiteDatabaseCorruptException -> L33
    L22:
        if (r112 >= r115) goto L24;
        r109.bindString(r113, r103[r112]);     // Catch: Throwable -> L29 SQLException -> L31 SQLiteDatabaseCorruptException -> L33
        r113 = r113 + 1;     // Catch: Throwable -> L29 SQLException -> L31 SQLiteDatabaseCorruptException -> L33
        r112 = r112 + 1;     // Catch: Throwable -> L29 SQLException -> L31 SQLiteDatabaseCorruptException -> L33
    L24:
        r109.execute();     // Catch: Throwable -> L29 SQLException -> L31 SQLiteDatabaseCorruptException -> L33
        int r116 = lastChangeCount();     // Catch: Throwable -> L29 SQLException -> L31 SQLiteDatabaseCorruptException -> L33
        r109.close();
        unlock();
        return r116;
    L28:
        throw new IllegalStateException("database not open");     // Catch: Throwable -> L29 SQLException -> L31 SQLiteDatabaseCorruptException -> L33
    L41:
        throw new IllegalArgumentException("Empty values");
    }

    public SQLiteDatabase(String r100, char[] r101, CursorFactory r102, int r103, SQLiteDatabaseHook r104) {
        this(r100, r102, r103, null);
        openDatabaseInternal(r101, r104);
    }

    public static SQLiteDatabase openDatabase(String r100, char[] r101, CursorFactory r102, int r103, SQLiteDatabaseHook r110) {
        return openDatabase(r100, r101, r102, r103, r110, null);
    }

    public static SQLiteDatabase openOrCreateDatabase(File r100, String r101, CursorFactory r102, SQLiteDatabaseHook r103, DatabaseErrorHandler r104) {
        if (r100 != null) goto L4;
        String r105 = null;
    L6:
        return openOrCreateDatabase(r105, r101, r102, r103, r104);
    L4:
        r105 = r100.getPath();
        goto L6
    }

    public static SQLiteDatabase openOrCreateDatabase(String r100, byte[] r101, CursorFactory r102, SQLiteDatabaseHook r103, DatabaseErrorHandler r110) {
        return openDatabase(r100, r101, r102, 268435456, r103, r110);
    }

    public static SQLiteDatabase openOrCreateDatabase(String r100, char[] r101, CursorFactory r102, SQLiteDatabaseHook r103, DatabaseErrorHandler r110) {
        return openDatabase(r100, r101, r102, 268435456, r103, r110);
    }

    public static SQLiteDatabase openDatabase(String r100, byte[] r101, CursorFactory r102, int r103, SQLiteDatabaseHook r104, DatabaseErrorHandler r105) {
        if (r105 != null) goto L26;
        r105 = new DefaultDatabaseErrorHandler();
    L26:
        SQLiteDatabase r106 = new SQLiteDatabase(r100, r102, r103, r105);     // Catch: SQLiteDatabaseCorruptException -> L9
        r106.openDatabaseInternal(r101, r104);     // Catch: SQLiteDatabaseCorruptException -> L25
    L12:
        if (SQLiteDebug.DEBUG_SQL_STATEMENTS == false) goto L15;
        r106.enableSqlTracing(r100);
    L15:
        if (SQLiteDebug.DEBUG_SQL_TIME == false) goto L17;
        r106.enableSqlProfiling(r100);
    L17:
        WeakHashMap<SQLiteDatabase, Object> r107 = sActiveDatabases;
        monitor-enter(r107);
        sActiveDatabases.put(r106, null);     // Catch: Throwable -> L22
        monitor-exit(r107);     // Catch: Throwable -> L22
        return r106;
    L22:
        th = move-exception;
        throw th;
    L10:
        r105.onCorruption(r106);
        r106 = new SQLiteDatabase(r100, r102, r103, r105);
        r106.openDatabaseInternal(r101, r104);
    L9:
        r106 = null;
        goto L10
    }

    public static SQLiteDatabase openDatabase(String r100, String r101, CursorFactory r102, int r103, SQLiteDatabaseHook r110, DatabaseErrorHandler r111) {
        if (r101 != null) goto L4;
        char[] r104 = null;
    L6:
        return openDatabase(r100, r104, r102, r103, r110, r111);
    L4:
        r104 = r101.toCharArray();
        goto L6
    }

    public static SQLiteDatabase openDatabase(String r100, char[] r101, CursorFactory r102, int r103, SQLiteDatabaseHook r110, DatabaseErrorHandler r111) {
        return openDatabase(r100, getBytes(r101), r102, r103, r110, r111);
    }

    public Cursor query(String r110, String[] r111, String r112, String[] r113, String r114, String r115, String r116) {
        return query(false, r110, r111, r112, r113, r114, r115, r116, null);
    }

    public Cursor query(String r110, String[] r111, String r112, String[] r113, String r114, String r115, String r116, String r117) {
        return query(false, r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public Cursor query(boolean r110, String r111, String[] r112, String r113, String[] r114, String r115, String r116, String r117, String r210) {
        return queryWithFactory(null, r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public Cursor queryWithFactory(CursorFactory r100, boolean r110, String r111, String[] r112, String r113, String[] r114, String r115, String r116, String r117, String r118) {
        if (isOpen() == false) goto L7;
        return rawQueryWithFactory(r100, SQLiteQueryBuilder.buildQueryString(r110, r111, r112, r113, r115, r116, r117, r118), r114, findEditTable(r111));
    L7:
        throw new IllegalStateException("database not open");
    }
}
