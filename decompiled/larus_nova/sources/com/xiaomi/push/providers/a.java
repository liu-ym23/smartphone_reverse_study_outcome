package com.xiaomi.push.providers;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.xiaomi.channel.commonutils.logger.b;

/* JADX INFO: loaded from: classes41.dex */
public class a extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f464134a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Object f970a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final String[] f971a = null;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
    }

    static {
        f970a = new Object();
        f971a = new String[]{"package_name", CardAdapter.TEXT, "message_ts", " LONG DEFAULT 0 ", HTTP.CONTENT_RANGE_BYTES, " LONG DEFAULT 0 ", "network_type", " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", "imsi", CardAdapter.TEXT};
    }

    public a(Context r100) {
        super(r100, "traffic.db", null, f464134a);
    }

    private void a(SQLiteDatabase r100) {
        StringBuilder r101 = new StringBuilder("CREATE TABLE traffic(_id INTEGER  PRIMARY KEY ,");
        int r102 = 0;
    L3:
        String[] r103 = f971a;
        if (r102 >= (r103.length - 1)) goto L8;
        if (r102 == 0) goto L7;
        r101.append(",");
    L7:
        r101.append(r103[r102]);
        r101.append(" ");
        r101.append(r103[r102 + 1]);
        r102 = r102 + 2;
        goto L3
    L8:
        r101.append(");");
        r100.execSQL(r101.toString());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase r100) {
        Object r101 = f970a;
        monitor-enter(r101);
        a(r100);     // Catch: Throwable -> L6 SQLException -> L8
    L10:
        monitor-exit(r101);     // Catch: Throwable -> L6
        return;
    L8:
        e = move-exception;
        b.a(e);     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        throw th;
    }
}
