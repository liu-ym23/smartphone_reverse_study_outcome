package net.sqlcipher.database;

import android.util.Log;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes42.dex */
public final class SQLiteDebug {
    public static final boolean DEBUG_ACTIVE_CURSOR_FINALIZATION = false;
    public static final boolean DEBUG_LOCK_TIME_TRACKING = false;
    public static final boolean DEBUG_LOCK_TIME_TRACKING_STACK_TRACE = false;
    public static final boolean DEBUG_SQL_CACHE = false;
    public static final boolean DEBUG_SQL_STATEMENTS = false;
    public static final boolean DEBUG_SQL_TIME = false;
    private static int sNumActiveCursorsFinalized;

    public static class DbStats {
        public String dbName;
        public long dbSize;
        public int lookaside;
        public long pageSize;

        public DbStats(String r100, long r101, long r102, int r103) {
            this.dbName = r100;
            this.pageSize = r102;
            this.dbSize = (r101 * r102) / 1024;
            this.lookaside = r103;
        }
    }

    public static class PagerStats {
        public long databaseBytes;
        public ArrayList<DbStats> dbStats;
        public int largestMemAlloc;
        public int memoryUsed;
        public int numPagers;
        public int pageCacheOverflo;
        public long referencedBytes;
        public long totalBytes;

        public PagerStats() {
        }
    }

    public SQLiteDebug() {
    }

    public static native long getHeapAllocatedSize();

    public static native void getHeapDirtyPages(int[] r100);

    public static native long getHeapFreeSize();

    public static native long getHeapSize();

    public static native void getPagerStats(PagerStats r100);

    static {
        DEBUG_SQL_STATEMENTS = Log.isLoggable("SQLiteStatements", 2);
        DEBUG_SQL_TIME = Log.isLoggable("SQLiteTime", 2);
        DEBUG_SQL_CACHE = Log.isLoggable("SQLiteCompiledSql", 2);
        DEBUG_ACTIVE_CURSOR_FINALIZATION = Log.isLoggable("SQLiteCursorClosing", 2);
        DEBUG_LOCK_TIME_TRACKING = Log.isLoggable("SQLiteLockTime", 2);
        DEBUG_LOCK_TIME_TRACKING_STACK_TRACE = Log.isLoggable("SQLiteLockStackTrace", 2);
        sNumActiveCursorsFinalized = 0;
    }

    public static PagerStats getDatabaseInfo() {
        PagerStats r100 = new PagerStats();
        getPagerStats(r100);
        r100.dbStats = SQLiteDatabase.getDbStats();
        return r100;
    }

    public static synchronized void notifyActiveCursorFinalized() {
        monitor-enter(SQLiteDebug.class);
        sNumActiveCursorsFinalized++;     // Catch: Throwable -> L7
        monitor-exit(SQLiteDebug.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static int getNumActiveCursorsFinalized() {
        return sNumActiveCursorsFinalized;
    }
}
