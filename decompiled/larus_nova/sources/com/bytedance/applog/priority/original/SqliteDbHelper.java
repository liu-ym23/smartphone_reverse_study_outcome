package com.bytedance.applog.priority.original;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class SqliteDbHelper extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.applog.log.a f192705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f192706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f192707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f192708d;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onConfigure(SQLiteDatabase r100) {
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
    }

    public final Context getContext() {
        return this.f192706b;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r100) {
        Iterator<T> r101 = this.f192708d.iterator();     // Catch: Throwable -> L9
    L4:
        if (r101.hasNext() == false) goto L19;
        String r102 = (String) r101.next();     // Catch: Throwable -> L9
        if (r100 == null) goto L4;
        r100.execSQL(r102);     // Catch: Throwable -> L9
        goto L4
    L19:
        return;
    L9:
        th = move-exception;
        this.f192705a.b("SqliteDbHelper:onCreate", th, new AnonymousClass2(this));
    }

    public SqliteDbHelper(com.bytedance.applog.log.a r100, Context r101, String r102, int r103, List r104, w r105) {
        Intrinsics.checkNotNullParameter(r100, "logger");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "name");
        Intrinsics.checkNotNullParameter(r104, "createTableSql");
        super(r101, r102, null, r103);
        this.f192705a = r100;
        this.f192706b = r101;
        this.f192707c = r102;
        this.f192708d = r104;
    }
}
