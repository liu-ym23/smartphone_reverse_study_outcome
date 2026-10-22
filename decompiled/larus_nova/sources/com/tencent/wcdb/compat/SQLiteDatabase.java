package com.tencent.wcdb.compat;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteClosable;
import android.database.sqlite.SQLiteQueryBuilder;
import android.database.sqlite.SQLiteTransactionListener;
import android.os.CancellationSignal;
import android.os.OperationCanceledException;
import android.text.TextUtils;
import com.tencent.wcdb.base.Value;
import com.tencent.wcdb.base.WCDBInterruptException;
import com.tencent.wcdb.core.Database;
import com.tencent.wcdb.core.Handle;
import com.tencent.wcdb.core.PreparedStatement;
import com.tencent.wcdb.winq.StatementInsert;
import java.util.Iterator;

/* JADX INFO: loaded from: classes40.dex */
public final class SQLiteDatabase extends SQLiteClosable {
    public static final int CONFLICT_ABORT = 2;
    public static final int CONFLICT_FAIL = 3;
    public static final int CONFLICT_IGNORE = 4;
    public static final int CONFLICT_NONE = 0;
    public static final int CONFLICT_REPLACE = 5;
    public static final int CONFLICT_ROLLBACK = 1;
    private static final String[] CONFLICT_VALUES = null;
    private static final Database.CipherVersion[] kCipherVersionMapping = null;
    private static final DatabaseErrorHandler sDefaultErrorHandler = null;
    private final Database mDB;
    private final ThreadLocal<Transaction> mTransactionStack;

    public static final class Transaction {
        boolean childFailed;
        SQLiteTransactionListener listener;
        boolean markedSuccessful;
        Transaction parent;

        private Transaction() {
        }

        public /* synthetic */ Transaction(AnonymousClass1 r100) {
            this();
        }
    }

    public void beginTransaction() {
        beginTransactionWithListener(null);
    }

    public void beginTransactionNonExclusive() {
        beginTransactionWithListener(null);
    }

    static {
        CONFLICT_VALUES = new String[]{"", " OR ROLLBACK ", " OR ABORT ", " OR FAIL ", " OR IGNORE ", " OR REPLACE "};
        kCipherVersionMapping = Database.CipherVersion.values();
        sDefaultErrorHandler = new AnonymousClass3();
    }

    public void endTransaction() {
        Transaction r100 = this.mTransactionStack.get();
        throwIfNoTransaction(r100);
        boolean r101 = false;
        if (r100.markedSuccessful == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        SQLiteTransactionListener r103 = r100.listener;
        if (r103 != null) goto L28;
    L16:
        r101 = r102;
        e = null;
    L17:
        Transaction r104 = r100.parent;
        this.mTransactionStack.set(r104);
        if (r104 == null) goto L21;
        if (r101 == true) goto L24;
        r104.childFailed = true;
    L24:
        if (e != null) goto L26;
        return;
    L26:
        throw e;
    L21:
        if (r101 == false) goto L23;
        this.mDB.commitTransaction();
        goto L24
    L23:
        this.mDB.rollbackTransaction();
        goto L24
    L28:
        if (r102 == false) goto L12;
        r103.onCommit();     // Catch: RuntimeException -> L14
    L27:
        goto L16
    L12:
        r103.onRollback();     // Catch: RuntimeException -> L14
    L14:
        e = e;
        goto L17
    L5:
        if (r100.childFailed == true) goto L7;
        r102 = true;
        goto L8
    }

    public long getMaximumSize() {
        return this.mDB.getValueFromSQL("PRAGMA max_page_count").getLong() * getPageSize();
    }

    public long getPageSize() {
        return this.mDB.getValueFromSQL("PRAGMA page_size").getLong();
    }

    public String getPath() {
        return this.mDB.getPath();
    }

    public int getVersion() {
        return this.mDB.getValueFromSQL("PRAGMA user_version").getInt();
    }

    public boolean inTransaction() {
        return this.mDB.isInTransaction();
    }

    public boolean isOpen() {
        return this.mDB.isOpened();
    }

    @Override // android.database.sqlite.SQLiteClosable
    public void onAllReferencesReleased() {
        Database r100 = this.mDB;
        if (r100 == null) goto L6;
        r100.close();
        return;
    }

    public void setTransactionSuccessful() {
        Transaction r100 = this.mTransactionStack.get();
        throwIfNoTransaction(r100);
        throwIfTransactionMarkedSuccessful(r100);
        r100.markedSuccessful = true;
    }

    public String toString() {
        return "SQLiteDatabase: " + getPath();
    }

    public static int releaseMemory() {
        Database.purgeAll();
        return 0;
    }

    public static /* synthetic */ DatabaseErrorHandler access$100() {
        return sDefaultErrorHandler;
    }

    public Database getInnerDB() {
        return this.mDB;
    }

    public SQLiteDatabase(Database r100) {
        this.mTransactionStack = new ThreadLocal();
        this.mDB = r100;
    }

    public static SQLiteDatabase openDatabase(String r100) {
        return openDatabase(r100, null, null, null);
    }

    private static void throwIfNoTransaction(Transaction r100) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
    }

    private static void throwIfTransactionMarkedSuccessful(Transaction r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.markedSuccessful == true) goto L7;
        return;
    L7:
        throw new IllegalStateException("Cannot perform this operation because the transaction has already been marked successful.  The only thing you can do now is call endTransaction().");
    }

    public static SQLiteDatabase wrap(Database r100) {
        return new SQLiteDatabase(r100);
    }

    public void beginTransactionWithListener(SQLiteTransactionListener r100) {
        Transaction r101 = this.mTransactionStack.get();
        throwIfTransactionMarkedSuccessful(r101);
        if (r101 != null) goto L5;
        this.mDB.beginTransaction();
    L5:
        if (r100 != null) goto L14;
    L12:
        Transaction r102 = new Transaction(null);
        r102.listener = r100;
        r102.parent = r101;
        this.mTransactionStack.set(r102);
        return;
    L14:
        r100.onBegin();     // Catch: RuntimeException -> L8
    L8:
        e = move-exception;
        if (r101 != null) goto L11;
        this.mDB.rollbackTransaction();
    L11:
        throw e;
    }

    public void beginTransactionWithListenerNonExclusive(SQLiteTransactionListener r100) {
        beginTransactionWithListener(r100);
    }

    public SQLiteStatement compileStatement(String r100) {
        return new SQLiteStatement(this.mDB, r100, null);
    }

    public void execSQL(String r100) {
        execSQL(r100, null);
    }

    public long setMaximumSize(long r100) {
        long r101 = getPageSize();
        long r102 = r100 / r101;
        if ((r100 % r101) == 0) goto L6;
        r102 = r102 + 1;
    L6:
        return this.mDB.getValueFromSQL("PRAGMA max_page_count = " + r102).getLong() * r101;
    }

    public void setPageSize(long r100) {
        this.mDB.execute("PRAGMA page_size = " + r100);
    }

    public void setVersion(int r100) {
        this.mDB.execute("PRAGMA user_version = " + r100);
    }

    public static SQLiteDatabase openDatabase(String r100, DatabaseErrorHandler r101) {
        return openDatabase(r100, null, null, r101);
    }

    public void execSQL(String r100, Object[] r101) {
        execSQL(r100, r101, null);
    }

    public Cursor rawQuery(String r100, Object[] r101) {
        return rawQuery(r100, r101, null);
    }

    public static SQLiteDatabase openDatabase(String r100, byte[] r101, SQLiteCipherSpec r102) {
        return openDatabase(r100, r101, r102, null);
    }

    public int delete(String r100, String r101, String[] r102) {
        StringBuilder r103 = new StringBuilder("DELETE FROM ");
        r103.append(r100);
        if (TextUtils.isEmpty(r101) == true) goto L5;
        String r104 = " WHERE " + r101;
    L6:
        r103.append(r104);
        String r105 = r103.toString();
        PreparedStatement r106 = null;
        Handle r107 = this.mDB.getHandle(true);     // Catch: Throwable -> L21
        r106 = r107.preparedWithMainStatement(r105);     // Catch: Throwable -> L19
        if (r102 == null) goto L14;
        int r108 = 0;
    L12:
        if (r108 >= r102.length) goto L14;
        String r109 = r102[r108];     // Catch: Throwable -> L19
        r108 = r108 + 1;     // Catch: Throwable -> L19
        r106.bindText(r109, r108);     // Catch: Throwable -> L19
    L14:
        r106.step();     // Catch: Throwable -> L19
        if (r106.isDone() == false) goto L14;
        int r110 = r107.getChanges();     // Catch: Throwable -> L19
        r106.finalizeStatement();
        r107.invalidate();
        return r110;
    L19:
        th = th;
    L23:
        if (r106 == null) goto L25;
        r106.finalizeStatement();
    L25:
        if (r107 == null) goto L27;
        r107.invalidate();
    L27:
        throw th;
    L21:
        th = th;
        r107 = null;
        goto L23
    L5:
        r104 = "";
        goto L6
    }

    public void execSQL(String r100, Object[] r101, CancellationSignal r102) {
        SQLiteStatement r103 = new SQLiteStatement(this.mDB, r100, r101);
        r103.execute(r102);     // Catch: Throwable -> L6
        r103.close();
        return;
    L6:
        th = move-exception;
        r103.close();     // Catch: Throwable -> L9
    L11:
        throw th;
    L9:
        th = move-exception;
        th.addSuppressed(th);
        goto L11
    }

    public long insert(String r100, String r101, ContentValues r102) {
        return insertWithOnConflict(r100, r101, r102, 0);
    L5:
        return -1;
    }

    public long insertOrThrow(String r100, String r101, ContentValues r102) throws SQLException {
        return insertWithOnConflict(r100, r101, r102, 0);
    }

    public Cursor rawQuery(String r100, Object[] r101, CancellationSignal r102) {
        PreparedStatement r103 = null;
        r103 = null;
        r103 = null;
        Handle r104 = null;
        int r105 = 0;
        Handle r106 = this.mDB.getHandle(false);     // Catch: Throwable -> L19 WCDBInterruptException -> L21
        DatabaseUtils.bindCancellationSignal(r106, r102);     // Catch: Throwable -> L15 WCDBInterruptException -> L17
        r103 = r106.preparedWithMainStatement(r100);     // Catch: Throwable -> L15 WCDBInterruptException -> L17
        if (r101 == null) goto L9;
        int r107 = r101.length;     // Catch: Throwable -> L15 WCDBInterruptException -> L17
        int r108 = 0;
    L7:
        if (r108 >= r107) goto L9;
        Value r109 = new Value(r101[r108]);     // Catch: Throwable -> L15 WCDBInterruptException -> L17
        r108 = r108 + 1;     // Catch: Throwable -> L15 WCDBInterruptException -> L17
        r103.bindValue(r109, r108);     // Catch: Throwable -> L15 WCDBInterruptException -> L17
    L9:
        int r110 = r103.getColumnCount();     // Catch: Throwable -> L15 WCDBInterruptException -> L17
        String[] r111 = new String[r110];     // Catch: Throwable -> L15 WCDBInterruptException -> L17
    L10:
        if (r105 >= r110) goto L12;
        r111[r105] = r103.getColumnName(r105);     // Catch: Throwable -> L15 WCDBInterruptException -> L17
        r105 = r105 + 1;     // Catch: Throwable -> L15 WCDBInterruptException -> L17
        goto L10
    L12:
        ValueCursor r112 = new ValueCursor(r103.getMultiRows(), r111);     // Catch: Throwable -> L15 WCDBInterruptException -> L17
        r103.finalizeStatement();
        r106.invalidate();
        return r112;
    L17:
        e = e;
        PreparedStatement r113 = r103;
        r104 = r106;
    L32:
    L25:
        th = th;
        r106 = r104;
        r103 = r113;
    L27:
        if (r103 == null) goto L29;
        r103.finalizeStatement();
    L29:
        if (r106 == null) goto L31;
        r106.invalidate();
    L31:
        throw th;
    L24:
        throw ((OperationCanceledException) new OperationCanceledException().initCause(e));     // Catch: Throwable -> L25
    L15:
        th = th;
        goto L27
    L21:
        e = e;
        r113 = null;
    L19:
        th = th;
        r106 = null;
        goto L27
    }

    public long replace(String r100, String r101, ContentValues r102) {
        return insertWithOnConflict(r100, r101, r102, 5);
    L5:
        return -1;
    }

    public long replaceOrThrow(String r100, String r101, ContentValues r102) throws SQLException {
        return insertWithOnConflict(r100, r101, r102, 5);
    }

    public static SQLiteDatabase openDatabase(String r100, byte[] r101, final SQLiteCipherSpec r102, final DatabaseErrorHandler r103) {
        Database r104 = new Database(r100);
        if (r101 == null) goto L10;
        if (r102 != null) goto L6;
        r104.setCipherKey(r101);
        goto L10
    L6:
        int r105 = r102.cipherVersion;
        if (r105 < 0) goto L9;
        r104.setCipherKey(r101, r102.pageSize, kCipherVersionMapping[r105]);
        goto L10
    L9:
        r104.setCipherKey(r101, r102.pageSize);
        r104.setConfig("com.Tencent.WCDB.Config.CipherSpecCompat", new AnonymousClass1(r102), Database.ConfigPriority.highest);
    L10:
        final SQLiteDatabase r106 = new SQLiteDatabase(r104);
        Database.CorruptionNotification r107 = new AnonymousClass2(r103, r106);
        r104.setNotificationWhenCorrupted(r107);
        if (r104.canOpen() == true) goto L13;
        r107.onCorrupted(r104);
        r104.getHandle().invalidate();
    L13:
        return r106;
    }

    public long insertWithOnConflict(String r100, String r110, ContentValues r111, int r112) {
        int r101 = 0;
        if (r111 != null) goto L5;
    L7:
        int r102 = 0;
    L8:
        PreparedStatement r103 = null;
        if (r102 <= 0) goto L14;
        Object[] r113 = new Object[r102];
        String[] r104 = new String[r102];
        Iterator<String> r105 = r111.keySet().iterator();
        int r106 = 0;
    L12:
        if (r105.hasNext() == false) goto L15;
        String r107 = r105.next();
        r104[r106] = r107;
        r113[r106] = r111.get(r107);
        r106 = r106 + 1;
    L15:
        StatementInsert r108 = new StatementInsert().insertInto(r100);
        if (r112 != 1) goto L18;
        r108.orRollback();
    L31:
        r108.columns(r104).valuesWithBindParameters(r113.length);
        Handle r114 = this.mDB.getHandle(true);     // Catch: Throwable -> L44
        r103 = r114.preparedWithMainStatement(r108);     // Catch: Throwable -> L42
    L35:
        if (r101 >= r113.length) goto L37;
        Value r109 = new Value(r113[r101]);     // Catch: Throwable -> L42
        r101 = r101 + 1;     // Catch: Throwable -> L42
        r103.bindValue(r109, r101);     // Catch: Throwable -> L42
    L37:
        r103.step();     // Catch: Throwable -> L42
        if (r103.isDone() == false) goto L37;
        long r115 = r114.getLastInsertedRowId();     // Catch: Throwable -> L42
        r103.finalizeStatement();
        r114.invalidate();
        return r115;
    L42:
        th = th;
    L46:
        if (r103 == null) goto L48;
        r103.finalizeStatement();
    L48:
        if (r114 == null) goto L50;
        r114.invalidate();
    L50:
        throw th;
    L44:
        th = th;
        r114 = null;
        goto L46
    L18:
        if (r112 != 2) goto L20;
        r108.orAbort();
        goto L31
    L20:
        if (r112 != 3) goto L22;
        r108.orFail();
        goto L31
    L22:
        if (r112 != 4) goto L24;
        r108.orIgnore();
        goto L31
    L24:
        if (r112 != 5) goto L31;
        r108.orReplace();
        goto L31
    L14:
        r104 = new String[]{r110};
        r113 = new Object[]{null};
        goto L15
    L5:
        if (r111.size() <= 0) goto L7;
        r102 = r111.size();
        goto L8
    }

    public int update(String r100, ContentValues r101, String r102, String[] r110) {
        return updateWithOnConflict(r100, r101, r102, r110, 0);
    }

    public int updateWithOnConflict(String r100, ContentValues r101, String r110, String[] r111, int r112) {
        StringBuilder r102 = new StringBuilder(120);
        r102.append("UPDATE ");
        r102.append(CONFLICT_VALUES[r112]);
        r102.append(r100);
        r102.append(" SET ");
        int r103 = r101.size();
        if (r111 != null) goto L5;
        int r113 = r103;
    L6:
        Object[] r104 = new Object[r113];
        Iterator<String> r105 = r101.keySet().iterator();
        int r106 = 0;
        int r107 = 0;
    L8:
        if (r105.hasNext() == false) goto L14;
        String r108 = r105.next();
        if (r107 <= 0) goto L12;
        String r109 = ",";
    L13:
        r102.append(r109);
        r102.append(r108);
        r104[r107] = r101.get(r108);
        r102.append("=?");
        r107 = r107 + 1;
        goto L8
    L12:
        r109 = "";
        goto L13
    L14:
        if (r111 == null) goto L19;
        int r114 = r103;
    L16:
        if (r114 >= r113) goto L19;
        r104[r114] = r111[r114 - r103];
        r114 = r114 + 1;
    L19:
        if (TextUtils.isEmpty(r110) == true) goto L21;
        r102.append(" WHERE ");
        r102.append(r110);
    L21:
        PreparedStatement r115 = null;
        Handle r116 = this.mDB.getHandle(true);     // Catch: Throwable -> L33
        r115 = r116.preparedWithMainStatement(r102.toString());     // Catch: Throwable -> L31
    L24:
        if (r106 >= r113) goto L26;
        Value r117 = new Value(r104[r106]);     // Catch: Throwable -> L31
        r106 = r106 + 1;     // Catch: Throwable -> L31
        r115.bindValue(r117, r106);     // Catch: Throwable -> L31
    L26:
        r115.step();     // Catch: Throwable -> L31
        if (r115.isDone() == false) goto L26;
        int r118 = r116.getChanges();     // Catch: Throwable -> L31
        r115.finalizeStatement();
        r116.invalidate();
        return r118;
    L31:
        th = th;
    L35:
        if (r115 == null) goto L37;
        r115.finalizeStatement();
    L37:
        if (r116 == null) goto L39;
        r116.invalidate();
    L39:
        throw th;
    L33:
        th = th;
        r116 = null;
        goto L35
    L5:
        r113 = r111.length + r103;
        goto L6
    }

    public Cursor query(String r110, String[] r111, String r112, String[] r113, String r114, String r115, String r116) {
        return query(false, r110, r111, r112, r113, r114, r115, r116, null);
    }

    public Cursor query(String r110, String[] r111, String r112, String[] r113, String r114, String r115, String r116, String r117) {
        return query(false, r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public Cursor query(boolean r110, String r111, String[] r112, String r113, String[] r114, String r115, String r116, String r117, String r210) {
        return query(r110, r111, r112, r113, r114, r115, r116, r117, r210, null);
    }

    public Cursor query(boolean r100, String r110, String[] r111, String r112, String[] r113, String r114, String r115, String r116, String r117, CancellationSignal r118) {
        return rawQuery(SQLiteQueryBuilder.buildQueryString(r100, r110, r111, r112, r114, r115, r116, r117), r113, r118);
    }
}
