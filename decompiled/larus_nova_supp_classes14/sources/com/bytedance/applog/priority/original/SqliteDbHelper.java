package com.bytedance.applog.priority.original;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class SqliteDbHelper extends SQLiteOpenHelper {
    public final com.bytedance.applog.log.a a;
    public final Context b;
    public final String c;
    public final List<String> d;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onConfigure(SQLiteDatabase r1) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r1, int r2, int r3) {
    }

    public final Context getContext() {
        return this.b;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r4) {
        Iterator<T> r0 = this.d.iterator();     // Catch: Throwable -> L9
    L4:
        if (r0.hasNext() == false) goto L19;
        String r1 = (String) r0.next();     // Catch: Throwable -> L9
        if (r4 == null) goto L4;
        r4.execSQL(r1);     // Catch: Throwable -> L9
        goto L4
    L19:
        return;
    L9:
        th = move-exception;
        this.a.b("SqliteDbHelper:onCreate", th, new AnonymousClass2(this));
    }

    public SqliteDbHelper(com.bytedance.applog.log.a r1, Context r2, String r3, int r4, List r5, w r6) {
        Intrinsics.checkNotNullParameter(r1, "logger");
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "name");
        Intrinsics.checkNotNullParameter(r5, "createTableSql");
        super(r2, r3, null, r4);
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r5;
    }
}
