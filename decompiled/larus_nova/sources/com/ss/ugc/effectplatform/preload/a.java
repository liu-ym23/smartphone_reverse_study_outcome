package com.ss.ugc.effectplatform.preload;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import bytekn.foundation.logger.Logger;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends SQLiteOpenHelper {
    public a(Context r100) {
        super(r100, "effect_platform_db", null, 1, null);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r100) {
        if (r100 == null) goto L5;
        r100.execSQL("create table if not exists preload_table(file_name TEXT primary key,resource_key TEXT,uri TEXT,res_name TEXT,last_access_time INTEGER,busi_key_list TEXT)");
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
        Logger.INSTANCE.d("JKL", "onUpgrade，newVersion is " + r102);
        if (r100 != null) goto L5;
        return;
    L5:
        r100.beginTransaction();
        r100.setTransactionSuccessful();     // Catch: Throwable -> L8 Exception -> L10
    L7:
        r100.endTransaction();
        return;
    L8:
        th = move-exception;
        r100.endTransaction();
        throw th;
    L10:
        e = move-exception;
        e.printStackTrace();     // Catch: Throwable -> L8
        goto L7
    }
}
