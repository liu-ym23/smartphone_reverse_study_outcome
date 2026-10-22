package net.sqlcipher;

import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.os.Parcel;
import android.text.TextUtils;
import com.alipay.sdk.m.n.a;
import com.alipay.sdk.m.u.i;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.Collator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import net.sqlcipher.database.SQLiteAbortException;
import net.sqlcipher.database.SQLiteConstraintException;
import net.sqlcipher.database.SQLiteDatabase;
import net.sqlcipher.database.SQLiteDatabaseCorruptException;
import net.sqlcipher.database.SQLiteDiskIOException;
import net.sqlcipher.database.SQLiteException;
import net.sqlcipher.database.SQLiteFullException;
import net.sqlcipher.database.SQLiteProgram;
import net.sqlcipher.database.SQLiteStatement;

/* JADX INFO: loaded from: classes42.dex */
public class DatabaseUtils {
    private static final boolean DEBUG = false;
    private static final char[] HEX_DIGITS_LOWER = null;
    private static final boolean LOCAL_LOGV = false;
    private static final String TAG = "DatabaseUtils";
    private static final String[] countProjection = null;
    private static Collator mColl;

    public static class InsertHelper {
        public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
        public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
        private HashMap<String, Integer> mColumns;
        private final SQLiteDatabase mDb;
        private String mInsertSQL;
        private SQLiteStatement mInsertStatement;
        private SQLiteStatement mPreparedStatement;
        private SQLiteStatement mReplaceStatement;
        private final String mTableName;

        public void prepareForInsert() {
            SQLiteStatement r100 = getStatement(false);
            this.mPreparedStatement = r100;
            r100.clearBindings();
        }

        public void prepareForReplace() {
            SQLiteStatement r100 = getStatement(true);
            this.mPreparedStatement = r100;
            r100.clearBindings();
        }

        private void buildSQL() throws SQLException {
            StringBuilder r100 = new StringBuilder(128);
            r100.append("INSERT INTO ");
            r100.append(this.mTableName);
            r100.append(" (");
            StringBuilder r101 = new StringBuilder(128);
            r101.append("VALUES (");
            Cursor r102 = null;
            r102 = this.mDb.rawQuery("PRAGMA table_info(" + this.mTableName + ")", null);     // Catch: Throwable -> L22
            this.mColumns = new HashMap(r102.getCount());     // Catch: Throwable -> L22
            int r103 = 1;
        L4:
            if (r102.moveToNext() == false) goto L20;
            String r104 = r102.getString(1);     // Catch: Throwable -> L22
            String r105 = r102.getString(4);     // Catch: Throwable -> L22
            this.mColumns.put(r104, Integer.valueOf(r103));     // Catch: Throwable -> L22
            r100.append("'");     // Catch: Throwable -> L22
            r100.append(r104);     // Catch: Throwable -> L22
            r100.append("'");     // Catch: Throwable -> L22
            if (r105 != null) goto L9;
            r101.append("?");     // Catch: Throwable -> L22
        L11:
            String r106 = ", ";
            if (r103 != r102.getCount()) goto L14;
            String r107 = ") ";
        L15:
            r100.append(r107);     // Catch: Throwable -> L22
            if (r103 != r102.getCount()) goto L18;
            r106 = ");";
        L18:
            r101.append(r106);     // Catch: Throwable -> L22
            r103 = r103 + 1;
            goto L4
        L14:
            r107 = ", ";
            goto L15
        L9:
            r101.append("COALESCE(?, ");     // Catch: Throwable -> L22
            r101.append(r105);     // Catch: Throwable -> L22
            r101.append(")");     // Catch: Throwable -> L22
            goto L11
        L20:
            r102.close();
            r100.append(r101);
            this.mInsertSQL = r100.toString();
            return;
        L22:
            th = move-exception;
            if (r102 == null) goto L25;
            r102.close();
        L25:
            throw th;
        }

        public void close() {
            SQLiteStatement r100 = this.mInsertStatement;
            if (r100 == null) goto L5;
            r100.close();
            this.mInsertStatement = null;
        L5:
            SQLiteStatement r101 = this.mReplaceStatement;
            if (r101 == null) goto L8;
            r101.close();
            this.mReplaceStatement = null;
        L8:
            this.mInsertSQL = null;
            this.mColumns = null;
        }

        public long execute() {
            SQLiteStatement r100 = this.mPreparedStatement;
            if (r100 == null) goto L16;
            long r101 = r100.executeInsert();     // Catch: Throwable -> L8 SQLException -> L10
            this.mPreparedStatement = null;
            return r101;
        L10:
            this.mPreparedStatement = null;
            return -1;
        L8:
            th = move-exception;
            this.mPreparedStatement = null;
            throw th;
        L16:
            throw new IllegalStateException("you must prepare this inserter before calling execute");
        }

        private SQLiteStatement getStatement(boolean r100) throws SQLException {
            if (r100 == false) goto L12;
            if (this.mReplaceStatement != null) goto L10;
            if (this.mInsertSQL != null) goto L8;
            buildSQL();
        L8:
            this.mReplaceStatement = this.mDb.compileStatement("INSERT OR REPLACE" + this.mInsertSQL.substring(6));
        L10:
            return this.mReplaceStatement;
        L12:
            if (this.mInsertStatement != null) goto L18;
            if (this.mInsertSQL != null) goto L16;
            buildSQL();
        L16:
            this.mInsertStatement = this.mDb.compileStatement(this.mInsertSQL);
        L18:
            return this.mInsertStatement;
        }

        public void bindNull(int r100) {
            this.mPreparedStatement.bindNull(r100);
        }

        public int getColumnIndex(String r100) {
            getStatement(false);
            Integer r101 = this.mColumns.get(r100);
            if (r101 == null) goto L7;
            return r101.intValue();
        L7:
            throw new IllegalArgumentException("column '" + r100 + "' is invalid");
        }

        public long insert(ContentValues r100) {
            return insertInternal(r100, false);
        }

        public long replace(ContentValues r100) {
            return insertInternal(r100, true);
        }

        public InsertHelper(SQLiteDatabase r100, String r101) {
            this.mInsertSQL = null;
            this.mInsertStatement = null;
            this.mReplaceStatement = null;
            this.mPreparedStatement = null;
            this.mDb = r100;
            this.mTableName = r101;
        }

        private synchronized long insertInternal(ContentValues r100, boolean r101) {
            monitor-enter(this);
            SQLiteStatement r102 = getStatement(r101);     // Catch: Throwable -> L10 SQLException -> L12
            r102.clearBindings();     // Catch: Throwable -> L10 SQLException -> L12
            Iterator<Map.Entry<String, Object>> r103 = r100.valueSet().iterator();     // Catch: Throwable -> L10 SQLException -> L12
        L5:
            if (r103.hasNext() == false) goto L7;
            Map.Entry<String, Object> r104 = r103.next();     // Catch: Throwable -> L10 SQLException -> L12
            DatabaseUtils.bindObjectToProgram(r102, getColumnIndex(r104.getKey()), r104.getValue());     // Catch: Throwable -> L10 SQLException -> L12
            goto L5
        L7:
            long r105 = r102.executeInsert();     // Catch: Throwable -> L10 SQLException -> L12
            monitor-exit(this);
            return r105;
        L10:
            th = move-exception;
            throw th;
        L12:
            Objects.toString(r100);     // Catch: Throwable -> L10
            return -1;
        }

        public void bind(int r100, String r101) {
            if (r101 != null) goto L4;
            this.mPreparedStatement.bindNull(r100);
            return;
        L4:
            this.mPreparedStatement.bindString(r100, r101);
        }

        public void bind(int r100, byte[] r101) {
            if (r101 != null) goto L4;
            this.mPreparedStatement.bindNull(r100);
            return;
        L4:
            this.mPreparedStatement.bindBlob(r100, r101);
        }

        public void bind(int r100, boolean r101) {
            SQLiteStatement r102 = this.mPreparedStatement;
            if (r101 == false) goto L5;
            long r103 = 1;
        L6:
            r102.bindLong(r100, r103);
            return;
        L5:
            r103 = 0;
            goto L6
        }

        public void bind(int r100, float r101) {
            this.mPreparedStatement.bindDouble(r100, r101);
        }

        public void bind(int r100, int r101) {
            this.mPreparedStatement.bindLong(r100, r101);
        }

        public void bind(int r100, double r101) {
            this.mPreparedStatement.bindDouble(r100, r101);
        }

        public void bind(int r100, long r101) {
            this.mPreparedStatement.bindLong(r100, r101);
        }
    }

    public DatabaseUtils() {
    }

    static {
        countProjection = new String[]{"count(*)"};
        HEX_DIGITS_LOWER = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
        mColl = null;
    }

    public static void dumpCurrentRow(Cursor r100) {
        dumpCurrentRow(r100, System.out);
    }

    public static String dumpCurrentRowToString(Cursor r100) {
        StringBuilder r101 = new StringBuilder();
        dumpCurrentRow(r100, r101);
        return r101.toString();
    }

    public static void dumpCursor(Cursor r100) {
        dumpCursor(r100, System.out);
    }

    public static String dumpCursorToString(Cursor r100) {
        StringBuilder r101 = new StringBuilder();
        dumpCursor(r100, r101);
        return r101.toString();
    }

    public static String getCollationKey(String r100) {
        byte[] r101 = getCollationKeyInBytes(r100);
        return new String(r101, 0, getKeyLen(r101), "ISO8859_1");
    L5:
        return "";
    }

    private static byte[] getCollationKeyInBytes(String r100) {
        if (mColl != null) goto L6;
        Collator r101 = Collator.getInstance();
        mColl = r101;
        r101.setStrength(0);
    L6:
        return mColl.getCollationKey(r100).toByteArray();
    }

    public static String getHexCollationKey(String r100) {
        byte[] r101 = getCollationKeyInBytes(r100);
        return new String(encodeHex(r101, HEX_DIGITS_LOWER), 0, getKeyLen(r101) * 2);
    }

    private static int getKeyLen(byte[] r100) {
        if (r100[r100.length - 1] == 0) goto L7;
        return r100.length;
    L7:
        return r100.length - 1;
    }

    public static int getTypeOfObject(Object r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        if ((r100 instanceof byte[]) == false) goto L10;
        return 4;
    L10:
        if ((r100 instanceof Float) == false) goto L12;
        return 2;
    L12:
        if ((r100 instanceof Double) == false) goto L15;
        return 2;
    L15:
        if ((r100 instanceof Long) == false) goto L17;
        return 1;
    L17:
        if ((r100 instanceof Integer) == true) goto L25;
        return 3;
    L25:
        return 1;
    }

    public static final void readExceptionFromParcel(Parcel r100) {
        int r101 = r100.readInt();
        if (r101 != 0) goto L5;
        return;
    L5:
        readExceptionFromParcel(r100, r100.readString(), r101);
    }

    public static void readExceptionWithFileNotFoundExceptionFromParcel(Parcel r100) throws FileNotFoundException {
        int r101 = r100.readInt();
        if (r101 != 0) goto L5;
        return;
    L5:
        String r102 = r100.readString();
        if (r101 == 1) goto L10;
        readExceptionFromParcel(r100, r102, r101);
        return;
    L10:
        throw new FileNotFoundException(r102);
    }

    public static void readExceptionWithOperationApplicationExceptionFromParcel(Parcel r100) throws OperationApplicationException {
        int r101 = r100.readInt();
        if (r101 != 0) goto L5;
        return;
    L5:
        String r102 = r100.readString();
        if (r101 == 10) goto L10;
        readExceptionFromParcel(r100, r102, r101);
        return;
    L10:
        throw new OperationApplicationException(r102);
    }

    public static String sqlEscapeString(String r100) {
        StringBuilder r101 = new StringBuilder();
        appendEscapedSQLString(r101, r100);
        return r101.toString();
    }

    public static void appendEscapedSQLString(StringBuilder r100, String r101) {
        r100.append('\'');
        if (r101.indexOf(39) == (-1)) goto L10;
        int r102 = r101.length();
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L11;
        char r104 = r101.charAt(r103);
        if (r104 != '\'') goto L9;
        r100.append('\'');
    L9:
        r100.append(r104);
        r103 = r103 + 1;
    L11:
        r100.append('\'');
        return;
    L10:
        r100.append(r101);
        goto L11
    }

    public static final void appendValueToSql(StringBuilder r100, Object r101) {
        if (r101 != null) goto L5;
        r100.append("NULL");
        return;
    L5:
        if ((r101 instanceof Boolean) == true) goto L7;
        appendEscapedSQLString(r100, r101.toString());
        return;
    L7:
        if (((Boolean) r101).booleanValue() == false) goto L9;
        r100.append('1');
        return;
    L9:
        r100.append('0');
    }

    public static String concatenateWhere(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return r101;
    L6:
        if (TextUtils.isEmpty(r101) == false) goto L9;
        return r100;
    L9:
        return "(" + r100 + ") AND (" + r101 + ")";
    }

    public static void cursorRowToContentValues(Cursor r100, ContentValues r101) {
        if ((r100 instanceof AbstractWindowedCursor) == false) goto L5;
        AbstractWindowedCursor r102 = (AbstractWindowedCursor) r100;
    L6:
        String[] r103 = r100.getColumnNames();
        int r104 = r103.length;
        int r105 = 0;
    L7:
        if (r105 >= r104) goto L14;
        if (r102 != null) goto L10;
    L12:
        r101.put(r103[r105], r100.getString(r105));
    L13:
        r105 = r105 + 1;
        goto L7
    L10:
        if (r102.isBlob(r105) == false) goto L12;
        r101.put(r103[r105], r100.getBlob(r105));
        goto L13
    L14:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static void dumpCurrentRow(Cursor r100, StringBuilder r101) {
        String[] r102 = r100.getColumnNames();
        r101.append("" + r100.getPosition() + " {\n");
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        String r105 = r100.getString(r104);     // Catch: SQLiteException -> L6
    L7:
        r101.append("   " + r102[r104] + a.f25612h + r105 + "\n");
        r104 = r104 + 1;
    L6:
        r105 = "<unprintable>";
        goto L7
    L8:
        r101.append("}\n");
    }

    public static void dumpCursor(Cursor r100, StringBuilder r101) {
        r101.append(">>>>> Dumping cursor " + r100 + "\n");
        if (r100 == null) goto L9;
        int r102 = r100.getPosition();
        r100.moveToPosition(-1);
    L6:
        if (r100.moveToNext() == false) goto L8;
        dumpCurrentRow(r100, r101);
        goto L6
    L8:
        r100.moveToPosition(r102);
    L9:
        r101.append("<<<<<\n");
    }

    private static char[] encodeHex(byte[] r100, char[] r101) {
        int r102 = r100.length;
        char[] r103 = new char[r102 << 1];
        int r104 = 0;
        int r105 = 0;
    L3:
        if (r104 >= r102) goto L5;
        int r106 = r105 + 1;
        byte r107 = r100[r104];
        r103[r105] = r101[(r107 & 240) >>> 4];
        r105 = r106 + 1;
        r103[r106] = r101[r107 & 15];
        r104 = r104 + 1;
        goto L3
    L5:
        return r103;
    }

    public static long longForQuery(SQLiteStatement r100, String[] r101) {
        if (r101 == null) goto L7;
        int r102 = r101.length;
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L7;
        int r104 = r103 + 1;
        bindObjectToProgram(r100, r104, r101[r103]);
        r103 = r104;
    L7:
        return r100.simpleQueryForLong();
    }

    public static long queryNumEntries(SQLiteDatabase r100, String r101) {
        Cursor r102 = r100.query(r101, countProjection, null, null, null, null, null);
        r102.moveToFirst();     // Catch: Throwable -> L6
        long r103 = r102.getLong(0);     // Catch: Throwable -> L6
        r102.close();
        return r103;
    L6:
        th = move-exception;
        r102.close();
        throw th;
    }

    public static String stringForQuery(SQLiteStatement r100, String[] r101) {
        if (r101 == null) goto L7;
        int r102 = r101.length;
        int r103 = 0;
    L4:
        if (r103 >= r102) goto L7;
        int r104 = r103 + 1;
        bindObjectToProgram(r100, r104, r101[r103]);
        r103 = r104;
    L7:
        return r100.simpleQueryForString();
    }

    public static final void writeExceptionToParcel(Parcel r100, Exception r101) {
        if ((r101 instanceof FileNotFoundException) == false) goto L6;
        int r102 = 1;
    L32:
        r100.writeInt(r102);
        r100.writeString(r101.getMessage());
        return;
    L6:
        if ((r101 instanceof IllegalArgumentException) == false) goto L9;
        r102 = 2;
        goto L32
    L9:
        if ((r101 instanceof UnsupportedOperationException) == false) goto L12;
        r102 = 3;
        goto L32
    L12:
        if ((r101 instanceof SQLiteAbortException) == false) goto L15;
        r102 = 4;
        goto L32
    L15:
        if ((r101 instanceof SQLiteConstraintException) == false) goto L18;
        r102 = 5;
        goto L32
    L18:
        if ((r101 instanceof SQLiteDatabaseCorruptException) == false) goto L21;
        r102 = 6;
        goto L32
    L21:
        if ((r101 instanceof SQLiteFullException) == false) goto L24;
        r102 = 7;
        goto L32
    L24:
        if ((r101 instanceof SQLiteDiskIOException) == false) goto L27;
        r102 = 8;
        goto L32
    L27:
        if ((r101 instanceof SQLiteException) == false) goto L30;
        r102 = 9;
        goto L32
    L30:
        if ((r101 instanceof OperationApplicationException) == false) goto L34;
        r102 = 10;
        goto L32
    L34:
        r100.writeException(r101);
    }

    public static void dumpCurrentRow(Cursor r100, PrintStream r101) {
        String[] r102 = r100.getColumnNames();
        r101.println("" + r100.getPosition() + " {");
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L8;
        String r105 = r100.getString(r104);     // Catch: SQLiteException -> L6
    L7:
        r101.println("   " + r102[r104] + a.f25612h + r105);
        r104 = r104 + 1;
    L6:
        r105 = "<unprintable>";
        goto L7
    L8:
        r101.println(i.f25855d);
    }

    public static void dumpCursor(Cursor r100, PrintStream r101) {
        r101.println(">>>>> Dumping cursor " + r100);
        if (r100 == null) goto L9;
        int r102 = r100.getPosition();
        r100.moveToPosition(-1);
    L6:
        if (r100.moveToNext() == false) goto L8;
        dumpCurrentRow(r100, r101);
        goto L6
    L8:
        r100.moveToPosition(r102);
    L9:
        r101.println("<<<<<");
    }

    public static void bindObjectToProgram(SQLiteProgram r100, int r101, Object r102) {
        if (r102 != null) goto L5;
        r100.bindNull(r101);
        return;
    L5:
        if ((r102 instanceof Double) == false) goto L7;
    L22:
        r100.bindDouble(r101, ((Number) r102).doubleValue());
        return;
    L7:
        if ((r102 instanceof Float) == true) goto L22;
        if ((r102 instanceof Number) == false) goto L13;
        r100.bindLong(r101, ((Number) r102).longValue());
        return;
    L13:
        if ((r102 instanceof Boolean) == false) goto L19;
        if (((Boolean) r102).booleanValue() == false) goto L17;
        r100.bindLong(r101, 1);
        return;
    L17:
        r100.bindLong(r101, 0);
        return;
    L19:
        if ((r102 instanceof byte[]) == false) goto L21;
        r100.bindBlob(r101, (byte[]) r102);
        return;
    L21:
        r100.bindString(r101, r102.toString());
    }

    public static void cursorDoubleToContentValuesIfPresent(Cursor r100, ContentValues r101, String r102) {
        int r103 = r100.getColumnIndexOrThrow(r102);
        if (r100.isNull(r103) == true) goto L6;
        r101.put(r102, Double.valueOf(r100.getDouble(r103)));
        return;
    }

    public static void cursorDoubleToCursorValues(Cursor r100, String r101, ContentValues r102) {
        cursorDoubleToContentValues(r100, r101, r102, r101);
    }

    public static void cursorFillWindow(Cursor r100, int r101, android.database.CursorWindow r102) {
        if (r101 >= 0) goto L4;
        return;
    L4:
        if (r101 >= r100.getCount()) goto L45;
        int r103 = r100.getPosition();
        int r104 = r100.getColumnCount();
        r102.clear();
        r102.setStartPosition(r101);
        r102.setNumColumns(r104);
        if (r100.moveToPosition(r101) == true) goto L9;
    L37:
        r100.moveToPosition(r103);
        return;
    L9:
        if (r102.allocRow() == false) goto L37;
        int r105 = 0;
    L12:
        if (r105 >= r104) goto L35;
        int r106 = r100.getType(r105);
        if (r106 != 0) goto L16;
        boolean r107 = r102.putNull(r101, r105);
    L32:
        if (r107 == false) goto L33;
        r105 = r105 + 1;
        goto L12
    L33:
        r102.freeLastRow();
        goto L35
    L16:
        if (r106 != 1) goto L18;
        r107 = r102.putLong(r100.getLong(r105), r101, r105);
        goto L32
    L18:
        if (r106 != 2) goto L20;
        r107 = r102.putDouble(r100.getDouble(r105), r101, r105);
        goto L32
    L20:
        if (r106 == 4) goto L25;
        String r108 = r100.getString(r105);
        if (r108 == null) goto L24;
        r107 = r102.putString(r108, r101, r105);
        goto L32
    L24:
        r107 = r102.putNull(r101, r105);
        goto L32
    L25:
        byte[] r109 = r100.getBlob(r105);
        if (r109 == null) goto L28;
        r107 = r102.putBlob(r109, r101, r105);
        goto L32
    L28:
        r107 = r102.putNull(r101, r105);
    L35:
        r101 = r101 + 1;
        if (r100.moveToNext() == true) goto L9;
    }

    public static void cursorFloatToContentValuesIfPresent(Cursor r100, ContentValues r101, String r102) {
        int r103 = r100.getColumnIndexOrThrow(r102);
        if (r100.isNull(r103) == true) goto L6;
        r101.put(r102, Float.valueOf(r100.getFloat(r103)));
        return;
    }

    public static void cursorIntToContentValues(Cursor r100, String r101, ContentValues r102) {
        cursorIntToContentValues(r100, r101, r102, r101);
    }

    public static void cursorIntToContentValuesIfPresent(Cursor r100, ContentValues r101, String r102) {
        int r103 = r100.getColumnIndexOrThrow(r102);
        if (r100.isNull(r103) == true) goto L6;
        r101.put(r102, Integer.valueOf(r100.getInt(r103)));
        return;
    }

    public static void cursorLongToContentValues(Cursor r100, String r101, ContentValues r102) {
        cursorLongToContentValues(r100, r101, r102, r101);
    }

    public static void cursorLongToContentValuesIfPresent(Cursor r100, ContentValues r101, String r102) {
        int r103 = r100.getColumnIndexOrThrow(r102);
        if (r100.isNull(r103) == true) goto L6;
        r101.put(r102, Long.valueOf(r100.getLong(r103)));
        return;
    }

    public static void cursorShortToContentValuesIfPresent(Cursor r100, ContentValues r101, String r102) {
        int r103 = r100.getColumnIndexOrThrow(r102);
        if (r100.isNull(r103) == true) goto L6;
        r101.put(r102, Short.valueOf(r100.getShort(r103)));
        return;
    }

    public static void cursorStringToContentValues(Cursor r100, String r101, ContentValues r102) {
        cursorStringToContentValues(r100, r101, r102, r101);
    }

    public static void cursorStringToContentValuesIfPresent(Cursor r100, ContentValues r101, String r102) {
        int r103 = r100.getColumnIndexOrThrow(r102);
        if (r100.isNull(r103) == true) goto L6;
        r101.put(r102, r100.getString(r103));
        return;
    }

    public static long longForQuery(SQLiteDatabase r100, String r101, String[] r102) {
        SQLiteStatement r103 = r100.compileStatement(r101);
        long r104 = longForQuery(r103, r102);     // Catch: Throwable -> L6
        r103.close();
        return r104;
    L6:
        th = move-exception;
        r103.close();
        throw th;
    }

    private static final void readExceptionFromParcel(Parcel r100, String r101, int r102) {
        switch(r102) {
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L6;
            default: goto L3;
        };
    L3:
        r100.readException(r102, r101);
        return;
    L6:
        throw new SQLiteException(r101);
    L8:
        throw new SQLiteDiskIOException(r101);
    L10:
        throw new SQLiteFullException(r101);
    L12:
        throw new SQLiteDatabaseCorruptException(r101);
    L14:
        throw new SQLiteConstraintException(r101);
    L16:
        throw new SQLiteAbortException(r101);
    L18:
        throw new UnsupportedOperationException(r101);
    L20:
        throw new IllegalArgumentException(r101);
    }

    public static String stringForQuery(SQLiteDatabase r100, String r101, String[] r102) {
        SQLiteStatement r103 = r100.compileStatement(r101);
        String r104 = stringForQuery(r103, r102);     // Catch: Throwable -> L6
        r103.close();
        return r104;
    L6:
        th = move-exception;
        r103.close();
        throw th;
    }

    public static void cursorDoubleToContentValues(Cursor r100, String r101, ContentValues r102, String r103) {
        int r104 = r100.getColumnIndex(r101);
        if (r100.isNull(r104) == true) goto L5;
        r102.put(r103, Double.valueOf(r100.getDouble(r104)));
        return;
    L5:
        r102.put(r103, null);
    }

    public static void cursorIntToContentValues(Cursor r100, String r101, ContentValues r102, String r103) {
        int r104 = r100.getColumnIndex(r101);
        if (r100.isNull(r104) == true) goto L5;
        r102.put(r103, Integer.valueOf(r100.getInt(r104)));
        return;
    L5:
        r102.put(r103, null);
    }

    public static void cursorLongToContentValues(Cursor r100, String r101, ContentValues r102, String r103) {
        int r104 = r100.getColumnIndex(r101);
        if (r100.isNull(r104) == true) goto L5;
        r102.put(r103, Long.valueOf(r100.getLong(r104)));
        return;
    L5:
        r102.put(r103, null);
    }

    public static void cursorStringToContentValues(Cursor r100, String r101, ContentValues r102, String r103) {
        r102.put(r103, r100.getString(r100.getColumnIndexOrThrow(r101)));
    }

    public static void cursorStringToInsertHelper(Cursor r100, String r101, InsertHelper r102, int r103) {
        r102.bind(r103, r100.getString(r100.getColumnIndexOrThrow(r101)));
    }
}
