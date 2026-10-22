package com.ss.android.socialbase.downloader.utils;

import kotlin.text.Typography;

/* JADX INFO: loaded from: classes5.dex */
public class SqlUtils {
    public SqlUtils() {
    }

    public static StringBuilder appendColumn(StringBuilder r100, String r101) {
        r100.append(Typography.quote);
        r100.append(r101);
        r100.append(Typography.quote);
        return r100;
    }

    public static StringBuilder appendColumns(StringBuilder r100, String[] r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        r100.append(Typography.quote);
        r100.append(r101[r103]);
        r100.append(Typography.quote);
        if (r103 >= (r102 - 1)) goto L7;
        r100.append(',');
    L7:
        r103 = r103 + 1;
        goto L3
    L8:
        return r100;
    }

    public static StringBuilder appendColumnsEqualPlaceholders(StringBuilder r100, String[] r101) {
        int r102 = 0;
    L4:
        if (r102 >= r101.length) goto L9;
        appendColumn(r100, r101[r102]).append("=?");
        if (r102 >= (r101.length - 1)) goto L8;
        r100.append(',');
    L8:
        r102 = r102 + 1;
        goto L4
    L9:
        return r100;
    }

    public static StringBuilder appendPlaceholders(StringBuilder r100, int r101) {
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L9;
        if (r102 >= (r101 - 1)) goto L7;
        r100.append("?,");
    L8:
        r102 = r102 + 1;
        goto L3
    L7:
        r100.append('?');
        goto L8
    L9:
        return r100;
    }

    public static String createSqlDelete(String r100, String[] r101) {
        String r102 = "\"" + r100 + Typography.quote;
        StringBuilder r103 = new StringBuilder("DELETE FROM ");
        r103.append(r102);
        if (r101 == null) goto L8;
        if (r101.length <= 0) goto L8;
        r103.append(" WHERE ");
        appendColumnsEqValue(r103, r102, r101);
    L8:
        return r103.toString();
    }

    public static StringBuilder appendColumn(StringBuilder r100, String r101, String r102) {
        r100.append(r101);
        r100.append(".\"");
        r100.append(r102);
        r100.append(Typography.quote);
        return r100;
    }

    public static StringBuilder appendColumnsEqValue(StringBuilder r100, String r101, String[] r102) {
        int r103 = 0;
    L4:
        if (r103 >= r102.length) goto L9;
        appendColumn(r100, r101, r102[r103]).append("=?");
        if (r103 >= (r102.length - 1)) goto L8;
        r100.append(',');
    L8:
        r103 = r103 + 1;
        goto L4
    L9:
        return r100;
    }

    public static String createSqlInsert(String r100, String r101, String[] r102) {
        StringBuilder r103 = new StringBuilder(r100);
        r103.append(Typography.quote);
        r103.append(r101);
        r103.append("\" (");
        appendColumns(r103, r102);
        r103.append(") VALUES (");
        appendPlaceholders(r103, r102.length);
        r103.append(')');
        return r103.toString();
    }

    public static String createSqlInsertOrReplace(String r100, String[] r101, String[] r102) {
        StringBuilder r103 = new StringBuilder("INSERT OR REPLACE INTO ");
        r103.append("\"" + r100 + Typography.quote);
        r103.append(" (");
        appendColumns(r103, r101);
        r103.append(") VALUES (");
        appendPlaceholders(r103, r101.length);
        r103.append(')');
        return r103.toString();
    }

    public static String createSqlUpdate(String r100, String[] r101, String[] r102) {
        String r103 = "\"" + r100 + Typography.quote;
        StringBuilder r104 = new StringBuilder("UPDATE ");
        r104.append(r103);
        r104.append(" SET ");
        appendColumnsEqualPlaceholders(r104, r101);
        if (r102 == null) goto L8;
        if (r102.length <= 0) goto L8;
        r104.append(" WHERE ");
        appendColumnsEqValue(r104, r103, r102);
    L8:
        return r104.toString();
    }
}
