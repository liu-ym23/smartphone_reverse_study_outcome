package net.sqlcipher.database;

import android.text.TextUtils;
import android.util.Log;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import net.sqlcipher.Cursor;
import net.sqlcipher.DatabaseUtils;
import tb2.c;

/* JADX INFO: loaded from: classes42.dex */
public class SQLiteQueryBuilder {
    private static final String TAG = "SQLiteQueryBuilder";
    private static final Pattern sLimitPattern = null;
    private boolean mDistinct;
    private SQLiteDatabase.CursorFactory mFactory;
    private Map<String, String> mProjectionMap;
    private boolean mStrictProjectionMap;
    private String mTables;
    private StringBuilder mWhereClause;

    static {
        sLimitPattern = PatternProtector.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    }

    public SQLiteQueryBuilder() {
        this.mProjectionMap = null;
        this.mTables = "";
        this.mWhereClause = null;
        this.mDistinct = false;
        this.mFactory = null;
    }

    public String getTables() {
        return this.mTables;
    }

    private String[] computeProjection(String[] r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
    L25:
        Map<String, String> r102 = this.mProjectionMap;
        if (r102 == null) goto L35;
        Set<Map.Entry<String, String>> r103 = r102.entrySet();
        String[] r104 = new String[r103.size()];
        Iterator<Map.Entry<String, String>> r105 = r103.iterator();
    L29:
        if (r105.hasNext() == false) goto L34;
        Map.Entry<String, String> r106 = r105.next();
        if (r106.getKey().equals("_count") == true) goto L29;
        r104[r101] = r106.getValue();
        r101 = r101 + 1;
        goto L29
    L34:
        return r104;
    L35:
        return null;
    L5:
        if (r100.length <= 0) goto L25;
        if (this.mProjectionMap == null) goto L24;
        String[] r107 = new String[r100.length];
        int r108 = r100.length;
    L9:
        if (r101 >= r108) goto L23;
        String r109 = r100[r101];
        String r110 = this.mProjectionMap.get(r109);
        if (r110 == null) goto L14;
        r107[r101] = r110;
    L20:
        r101 = r101 + 1;
        goto L9
    L14:
        if (this.mStrictProjectionMap == true) goto L22;
        if (r109.contains(" AS ") == false) goto L18;
    L19:
        r107[r101] = r109;
        goto L20
    L18:
        if (r109.contains(" as ") == true) goto L19;
    L22:
        throw new IllegalArgumentException("Invalid column " + r100[r101]);
    L23:
        return r107;
    L24:
        return r100;
    }

    public void appendWhere(CharSequence r100) {
        if (this.mWhereClause != null) goto L6;
        this.mWhereClause = new StringBuilder(r100.length() + 16);
    L6:
        if (this.mWhereClause.length() != 0) goto L8;
        this.mWhereClause.append('(');
    L8:
        this.mWhereClause.append(r100);
    }

    public void appendWhereEscapeString(String r100) {
        if (this.mWhereClause != null) goto L6;
        this.mWhereClause = new StringBuilder(r100.length() + 16);
    L6:
        if (this.mWhereClause.length() != 0) goto L8;
        this.mWhereClause.append('(');
    L8:
        DatabaseUtils.appendEscapedSQLString(this.mWhereClause, r100);
    }

    public void setCursorFactory(SQLiteDatabase.CursorFactory r100) {
        this.mFactory = r100;
    }

    public void setDistinct(boolean r100) {
        this.mDistinct = r100;
    }

    public void setProjectionMap(Map<String, String> r100) {
        this.mProjectionMap = r100;
    }

    public void setStrictProjectionMap(boolean r100) {
        this.mStrictProjectionMap = r100;
    }

    public void setTables(String r100) {
        this.mTables = r100;
    }

    public static void appendColumns(StringBuilder r100, String[] r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L10;
        String r104 = r101[r103];
        if (r104 == null) goto L9;
        if (r103 <= 0) goto L8;
        r100.append(", ");
    L8:
        r100.append(r104);
    L9:
        r103 = r103 + 1;
        goto L3
    L10:
        r100.append(' ');
    }

    private static void appendClause(StringBuilder r100, String r101, String r102) {
        if (TextUtils.isEmpty(r102) == true) goto L6;
        r100.append(r101);
        r100.append(r102);
        return;
    }

    private static void appendClauseEscapeClause(StringBuilder r100, String r101, String r102) {
        if (TextUtils.isEmpty(r102) == true) goto L6;
        r100.append(r101);
        DatabaseUtils.appendEscapedSQLString(r100, r102);
        return;
    }

    public String buildUnionQuery(String[] r100, String r101, String r102) {
        StringBuilder r103 = new StringBuilder(128);
        int r104 = r100.length;
        if (this.mDistinct == false) goto L5;
        String r105 = " UNION ";
    L6:
        int r106 = 0;
    L7:
        if (r106 >= r104) goto L11;
        if (r106 <= 0) goto L10;
        r103.append(r105);
    L10:
        r103.append(r100[r106]);
        r106 = r106 + 1;
        goto L7
    L11:
        appendClause(r103, " ORDER BY ", r101);
        appendClause(r103, " LIMIT ", r102);
        return r103.toString();
    L5:
        r105 = " UNION ALL ";
        goto L6
    }

    public String buildQuery(String[] r100, String r110, String[] r111, String r112, String r113, String r114, String r115) {
        String[] r101 = computeProjection(r100);
        StringBuilder r102 = new StringBuilder();
        StringBuilder r116 = this.mWhereClause;
        if (r116 != null) goto L5;
    L7:
        boolean r117 = false;
    L9:
        if (r117 == false) goto L11;
        r102.append(this.mWhereClause.toString());
        r102.append(')');
    L11:
        if (r110 == null) goto L18;
        if (r110.length() <= 0) goto L18;
        if (r117 == false) goto L16;
        r102.append(" AND ");
    L16:
        r102.append('(');
        r102.append(r110);
        r102.append(')');
    L18:
        return buildQueryString(this.mDistinct, this.mTables, r101, r102.toString(), r112, r113, r114, r115);
    L5:
        if (r116.length() <= 0) goto L7;
        r117 = true;
        goto L9
    }

    public Cursor query(SQLiteDatabase r110, String[] r111, String r112, String[] r113, String r114, String r115, String r116) {
        return query(r110, r111, r112, r113, r114, r115, r116, null);
    }

    public static String buildQueryString(boolean r100, String r101, String[] r102, String r103, String r104, String r105, String r106, String r107) {
        if (TextUtils.isEmpty(r104) == false) goto L10;
        if (TextUtils.isEmpty(r105) == true) goto L10;
        throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
    L10:
        if (TextUtils.isEmpty(r107) == false) goto L12;
    L16:
        StringBuilder r108 = new StringBuilder(120);
        r108.append("SELECT ");
        if (r100 == false) goto L19;
        r108.append("DISTINCT ");
    L19:
        if (r102 != null) goto L21;
    L23:
        r108.append(c.IMAGE_DEFAULT_TEXT);
    L24:
        r108.append("FROM ");
        r108.append(r101);
        appendClause(r108, " WHERE ", r103);
        appendClause(r108, " GROUP BY ", r104);
        appendClause(r108, " HAVING ", r105);
        appendClause(r108, " ORDER BY ", r106);
        appendClause(r108, " LIMIT ", r107);
        return r108.toString();
    L21:
        if (r102.length == 0) goto L23;
        appendColumns(r108, r102);
        goto L24
    L12:
        if (sLimitPattern.matcher(r107).matches() == true) goto L16;
        throw new IllegalArgumentException("invalid LIMIT clauses:" + r107);
    }

    public Cursor query(SQLiteDatabase r110, String[] r111, String r112, String[] r113, String r114, String r115, String r116, String r117) {
        if (this.mTables != null) goto L6;
        return null;
    L6:
        String r100 = buildQuery(r111, r112, r113, r114, r115, r116, r117);
        if (Log.isLoggable(TAG, 3) == true) goto L10;
    L10:
        return r110.rawQueryWithFactory(this.mFactory, r100, r113, SQLiteDatabase.findEditTable(this.mTables));
    }

    public String buildUnionSubQuery(String r110, String[] r111, Set<String> r112, int r113, String r114, String r115, String[] r116, String r117, String r210) {
        int r100 = r111.length;
        String[] r101 = new String[r100];
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L16;
        String r103 = r111[r102];
        if (r103.equals(r110) == false) goto L8;
        r101[r102] = "'" + r114 + "' AS " + r110;
    L14:
        r102 = r102 + 1;
        goto L3
    L8:
        if (r102 > r113) goto L10;
    L13:
        r101[r102] = r103;
        goto L14
    L10:
        if (r112.contains(r103) == true) goto L13;
        r101[r102] = "NULL AS ".concat(r103);
        goto L14
    L16:
        return buildQuery(r101, r115, r116, r117, r210, null, null);
    }
}
