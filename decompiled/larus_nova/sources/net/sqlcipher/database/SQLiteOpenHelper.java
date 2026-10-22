package net.sqlcipher.database;

import android.content.Context;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import net.sqlcipher.DatabaseErrorHandler;
import net.sqlcipher.DefaultDatabaseErrorHandler;

/* JADX INFO: loaded from: classes42.dex */
public abstract class SQLiteOpenHelper {
    private static final String TAG = null;
    private final Context mContext;
    private SQLiteDatabase mDatabase;
    private boolean mDeferSetWriteAheadLoggingEnabled;
    private boolean mEnableWriteAheadLogging;
    private final DatabaseErrorHandler mErrorHandler;
    private final SQLiteDatabase.CursorFactory mFactory;
    private final SQLiteDatabaseHook mHook;
    private boolean mIsInitializing;
    private final String mName;
    private final int mNewVersion;

    public synchronized void close() {
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsInitializing == true) goto L13;
        SQLiteDatabase r100 = this.mDatabase;     // Catch: Throwable -> L14
        if (r100 != null) goto L8;
    L10:
        monitor-exit(this);
        return;
    L8:
        if (r100.isOpen() == false) goto L10;
        this.mDatabase.close();     // Catch: Throwable -> L14
        this.mDatabase = null;     // Catch: Throwable -> L14
        goto L10
    L13:
        throw new IllegalStateException("Closed during initialization");     // Catch: Throwable -> L14
    }

    public void onConfigure(SQLiteDatabase r100) {
    }

    public abstract void onCreate(SQLiteDatabase r100);

    public void onOpen(SQLiteDatabase r100) {
    }

    public abstract void onUpgrade(SQLiteDatabase r100, int r101, int r102);

    static {
        TAG = "SQLiteOpenHelper";
    }

    public String getDatabaseName() {
        return this.mName;
    }

    public synchronized SQLiteDatabase getReadableDatabase(byte[] r110) {
        monitor-enter(this);
        SQLiteDatabase r100 = this.mDatabase;     // Catch: Throwable -> L45
        if (r100 == null) goto L12;
        if (r100.isOpen() == false) goto L12;
        SQLiteDatabase r111 = this.mDatabase;     // Catch: Throwable -> L45
        monitor-exit(this);
        return r111;
    L12:
        if (this.mIsInitializing == true) goto L44;
        SQLiteDatabase r112 = getWritableDatabase(r110);     // Catch: SQLiteException -> L16 Throwable -> L45
        monitor-exit(this);
        return r112;
    L16:
        e = move-exception;
        if (this.mName == null) goto L42;
        String r101 = this.mName;     // Catch: Throwable -> L45
        AutoCloseable r102 = null;
        this.mIsInitializing = true;     // Catch: Throwable -> L35
        String r103 = this.mContext.getDatabasePath(r101).getPath();     // Catch: Throwable -> L35
        PolarisFileWrapper r104 = new PolarisFileWrapper(r103);     // Catch: Throwable -> L35
        PolarisFileWrapper r105 = new PolarisFileWrapper(this.mContext.getDatabasePath(this.mName).getParent());     // Catch: Throwable -> L35
        if (r105.exists() == true) goto L25;
        r105.mkdirs();     // Catch: Throwable -> L35
    L25:
        if (r104.exists() == true) goto L27;
        this.mIsInitializing = false;     // Catch: Throwable -> L35
        SQLiteDatabase r106 = getWritableDatabase(r110);     // Catch: Throwable -> L35
        this.mIsInitializing = true;     // Catch: Throwable -> L35
        r106.close();     // Catch: Throwable -> L35
    L27:
        SQLiteDatabase r107 = SQLiteDatabase.openDatabase(r103, r110, this.mFactory, 1, this.mHook, this.mErrorHandler);     // Catch: Throwable -> L35
        if (r107.getVersion() != this.mNewVersion) goto L34;
        onOpen(r107);     // Catch: Throwable -> L35
        this.mDatabase = r107;     // Catch: Throwable -> L35
        this.mIsInitializing = false;     // Catch: Throwable -> L45
        return r107;
    L34:
        throw new SQLiteException("Can't upgrade read-only database from version " + r107.getVersion() + " to " + this.mNewVersion + ": " + r103);     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        this.mIsInitializing = false;     // Catch: Throwable -> L45
        if (0 != 0) goto L39;
    L41:
        throw th;     // Catch: Throwable -> L45
    L39:
        if (null == this.mDatabase) goto L41;
        r102.close();     // Catch: Throwable -> L45
        goto L41
    L42:
        throw e;     // Catch: Throwable -> L45
    L44:
        throw new IllegalStateException("getReadableDatabase called recursively");     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        throw th;
    }

    public synchronized SQLiteDatabase getWritableDatabase(byte[] r100) {
        monitor-enter(this);
        SQLiteDatabase r101 = this.mDatabase;     // Catch: Throwable -> L60
        if (r101 == null) goto L13;
        if (r101.isOpen() == false) goto L13;
        if (this.mDatabase.isReadOnly() == true) goto L13;
        SQLiteDatabase r102 = this.mDatabase;     // Catch: Throwable -> L60
        monitor-exit(this);
        return r102;
    L13:
        if (this.mIsInitializing == true) goto L59;
        SQLiteDatabase r103 = this.mDatabase;     // Catch: Throwable -> L60
        if (r103 == null) goto L17;
        r103.lock();     // Catch: Throwable -> L60
    L17:
        SQLiteDatabase r104 = null;
        this.mIsInitializing = true;     // Catch: Throwable -> L51
        String r105 = this.mName;     // Catch: Throwable -> L51
        if (r105 != null) goto L22;
        SQLiteDatabase r106 = SQLiteDatabase.create(null, "");     // Catch: Throwable -> L51
    L21:
        r104 = r106;
        if (this.mDeferSetWriteAheadLoggingEnabled == false) goto L29;
        this.mEnableWriteAheadLogging = r104.enableWriteAheadLogging();     // Catch: Throwable -> L51
    L29:
        onConfigure(r104);     // Catch: Throwable -> L51
        int r107 = r104.getVersion();     // Catch: Throwable -> L51
        if (r107 == this.mNewVersion) goto L43;
        r104.beginTransaction();     // Catch: Throwable -> L51
        if (r107 != 0) goto L34;
        onCreate(r104);     // Catch: Throwable -> L40
    L38:
        r104.setVersion(this.mNewVersion);     // Catch: Throwable -> L40
        r104.setTransactionSuccessful();     // Catch: Throwable -> L40
        r104.endTransaction();     // Catch: Throwable -> L51
        goto L43
    L34:
        int r108 = this.mNewVersion;     // Catch: Throwable -> L40
        if (r107 <= r108) goto L37;
        onDowngrade(r104, r107, r108);     // Catch: Throwable -> L40
        goto L38
    L37:
        onUpgrade(r104, r107, r108);     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        r104.endTransaction();     // Catch: Throwable -> L51
        throw th;     // Catch: Throwable -> L51
    L43:
        onOpen(r104);     // Catch: Throwable -> L51
        this.mIsInitializing = false;     // Catch: Throwable -> L60
        SQLiteDatabase r109 = this.mDatabase;     // Catch: Throwable -> L60
        if (r109 != null) goto L64;
    L48:
        this.mDatabase = r104;     // Catch: Throwable -> L60
        monitor-exit(this);
        return r104;
    L64:
        r109.close();     // Catch: Exception -> L63 Throwable -> L60
    L47:
        this.mDatabase.unlock();     // Catch: Throwable -> L60
        goto L48
    L22:
        String r110 = this.mContext.getDatabasePath(r105).getPath();     // Catch: Throwable -> L51
        PolarisFileWrapper r111 = new PolarisFileWrapper(r110);     // Catch: Throwable -> L51
        if (r111.exists() == true) goto L25;
        r111.getParentFile().mkdirs();     // Catch: Throwable -> L51
    L25:
        r106 = SQLiteDatabase.openOrCreateDatabase(r110, r100, this.mFactory, this.mHook, this.mErrorHandler);     // Catch: Throwable -> L51
    L51:
        th = move-exception;
        this.mIsInitializing = false;     // Catch: Throwable -> L60
        SQLiteDatabase r112 = this.mDatabase;     // Catch: Throwable -> L60
        if (r112 == null) goto L55;
        r112.unlock();     // Catch: Throwable -> L60
    L55:
        if (r104 == null) goto L57;
        r104.close();     // Catch: Throwable -> L60
    L57:
        throw th;     // Catch: Throwable -> L60
    L59:
        throw new IllegalStateException("getWritableDatabase called recursively");     // Catch: Throwable -> L60
    L60:
        th = move-exception;
        throw th;
    }

    public void setWriteAheadLoggingEnabled(boolean r100) {
        monitor-enter(this);
    L18:
        th = move-exception;
        throw th;
    L4:
        if (this.mEnableWriteAheadLogging == r100) goto L16;
        SQLiteDatabase r101 = this.mDatabase;     // Catch: Throwable -> L18
        if (r101 != null) goto L8;
    L15:
        this.mDeferSetWriteAheadLoggingEnabled = r100;     // Catch: Throwable -> L18
        goto L16
    L8:
        if (r101.isOpen() == false) goto L15;
        if (this.mDatabase.isReadOnly() == true) goto L15;
        if (r100 == false) goto L13;
        this.mDatabase.enableWriteAheadLogging();     // Catch: Throwable -> L18
    L14:
        this.mEnableWriteAheadLogging = r100;     // Catch: Throwable -> L18
        goto L16
    L13:
        this.mDatabase.disableWriteAheadLogging();     // Catch: Throwable -> L18
    L16:
        monitor-exit(this);     // Catch: Throwable -> L18
    }

    public synchronized SQLiteDatabase getReadableDatabase(String r100) {
        monitor-enter(this);
        if (r100 != null) goto L12;
        char[] r101 = null;
    L6:
        SQLiteDatabase r102 = getReadableDatabase(r101);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r102;
    L9:
        th = move-exception;
        throw th;
    L12:
        r101 = r100.toCharArray();     // Catch: Throwable -> L9
        goto L6
    }

    public synchronized SQLiteDatabase getWritableDatabase(String r100) {
        monitor-enter(this);
        if (r100 != null) goto L12;
        char[] r101 = null;
    L6:
        SQLiteDatabase r102 = getWritableDatabase(r101);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r102;
    L9:
        th = move-exception;
        throw th;
    L12:
        r101 = r100.toCharArray();     // Catch: Throwable -> L9
        goto L6
    }

    public synchronized SQLiteDatabase getReadableDatabase(char[] r100) {
        monitor-enter(this);
        if (r100 != null) goto L12;
        byte[] r101 = null;
    L6:
        SQLiteDatabase r102 = getReadableDatabase(r101);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r102;
    L9:
        th = move-exception;
        throw th;
    L12:
        r101 = SQLiteDatabase.getBytes(r100);     // Catch: Throwable -> L9
        goto L6
    }

    public synchronized SQLiteDatabase getWritableDatabase(char[] r100) {
        monitor-enter(this);
        if (r100 != null) goto L12;
        byte[] r101 = null;
    L6:
        SQLiteDatabase r102 = getWritableDatabase(r101);     // Catch: Throwable -> L9
        monitor-exit(this);
        return r102;
    L9:
        th = move-exception;
        throw th;
    L12:
        r101 = SQLiteDatabase.getBytes(r100);     // Catch: Throwable -> L9
        goto L6
    }

    public void onDowngrade(SQLiteDatabase r100, int r101, int r102) {
        throw new SQLiteException("Can't downgrade database from version " + r101 + " to " + r102);
    }

    public SQLiteOpenHelper(Context r100, String r101, SQLiteDatabase.CursorFactory r110, int r111) {
        this(r100, r101, r110, r111, null, new DefaultDatabaseErrorHandler());
    }

    public SQLiteOpenHelper(Context r100, String r101, SQLiteDatabase.CursorFactory r110, int r111, SQLiteDatabaseHook r112) {
        this(r100, r101, r110, r111, r112, new DefaultDatabaseErrorHandler());
    }

    public SQLiteOpenHelper(Context r100, String r101, SQLiteDatabase.CursorFactory r102, int r103, SQLiteDatabaseHook r104, DatabaseErrorHandler r105) {
        this.mDatabase = null;
        this.mIsInitializing = false;
        if (r103 < 1) goto L10;
        if (r105 == null) goto L8;
        this.mContext = r100;
        this.mName = r101;
        this.mFactory = r102;
        this.mNewVersion = r103;
        this.mHook = r104;
        this.mErrorHandler = r105;
        return;
    L8:
        throw new IllegalArgumentException("DatabaseErrorHandler param value can't be null.");
    L10:
        throw new IllegalArgumentException("Version must be >= 1, was " + r103);
    }
}
