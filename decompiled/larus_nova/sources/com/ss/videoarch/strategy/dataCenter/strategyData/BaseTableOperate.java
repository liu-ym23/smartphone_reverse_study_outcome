package com.ss.videoarch.strategy.dataCenter.strategyData;

import android.content.ContentValues;
import android.database.Cursor;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class BaseTableOperate {
    public BaseTableOperate() {
    }

    public static String getCurrentTimeFormat() {
        Date r100 = new Date(System.currentTimeMillis());
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(r100);
    }

    public static long calDiffOfTime(String r100, String r101) {
        SimpleDateFormat r102 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date r103 = new Date();
        Date r104 = new Date();
        r103 = r102.parse(r100);     // Catch: ParseException -> L5
        r104 = r102.parse(r101);     // Catch: ParseException -> L5
    L7:
        long r105 = r103.getTime();
        return r104.getTime() - r105;
    L5:
        e = move-exception;
        e.printStackTrace();
        goto L7
    }

    public static long insert(String r100, ContentValues r101) {
        return StrategySQLiteWrapper.insert(r100, r101);
    }

    public static Cursor querySQL(String r100, String r101) {
        return StrategySQLiteWrapper.queryBySQL(r100, r101);
    }

    public static long getCount(String r100, String r101, String[] r102) {
        return StrategySQLiteWrapper.getCount(r100, r101, r102);
    }

    public static long replaceAll(String r100, String[] r101, List<ContentValues> r102) {
        return StrategySQLiteWrapper.replaceAll(r100, r101, r102);
    }

    public static long update(String r100, ContentValues r101, String r102, String[] r103) {
        return StrategySQLiteWrapper.update(r100, r101, r102, r103);
    }

    public static long replace(String r100, String[] r101, ContentValues r102, String r103, String[] r104) {
        return StrategySQLiteWrapper.replace(r100, r101, r102, r103, r104);
    }

    public static Cursor query(String r100, String[] r101, String r102, String[] r103, String r104, String r105, String r106) {
        return StrategySQLiteWrapper.query(r100, r101, r102, r103, r104, r105, r106);
    }
}
