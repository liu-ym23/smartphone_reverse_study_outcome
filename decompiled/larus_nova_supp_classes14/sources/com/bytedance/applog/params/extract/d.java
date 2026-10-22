package com.bytedance.applog.params.extract;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d extends SQLiteOpenHelper {
    public d(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, "applog_params_extract.db", null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onConfigure(SQLiteDatabase r2) {
        Intrinsics.checkNotNullParameter(r2, "db");
        super.onConfigure(r2);
        r2.enableWriteAheadLogging();     // Catch: Exception -> L5
        r2.execSQL("PRAGMA synchronous=NORMAL");     // Catch: Exception -> L5
        return;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r2) {
        Intrinsics.checkNotNullParameter(r2, "db");
        r2.execSQL("CREATE TABLE IF NOT EXISTS cp_entries (\n    cp_id TEXT PRIMARY KEY,\n    session_id TEXT NOT NULL,\n    json TEXT NOT NULL,\n    created_at INTEGER NOT NULL\n)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "db");
        r1.execSQL("DROP INDEX IF EXISTS idx_cp_entries_session_id");
        onCreate(r1);
    }
}
