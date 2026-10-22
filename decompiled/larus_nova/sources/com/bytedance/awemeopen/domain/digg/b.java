package com.bytedance.awemeopen.domain.digg;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f198294a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f198295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public C2858b f198296b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public SQLiteDatabase f198297c;

        /* JADX INFO: renamed from: com.bytedance.awemeopen.domain.digg.b$a$a, reason: collision with other inner class name */
        public static final class C2857a {
        }

        /* JADX INFO: renamed from: com.bytedance.awemeopen.domain.digg.b$a$b, reason: collision with other inner class name */
        public final class C2858b extends SQLiteOpenHelper {
            public C2858b(Context r100) {
                Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
                super(r100, "digg_db", null, 2);
            }

            @Override // android.database.sqlite.SQLiteOpenHelper
            public final void onCreate(SQLiteDatabase r100) {
                Intrinsics.checkNotNullParameter(r100, "db");
                r100.execSQL("CREATE TABLE digg_local_tbl (_id INTEGER PRIMARY KEY,aweme_id TEXT,UNIQUE(aweme_id))");
                r100.execSQL("CREATE TABLE young_digg_local_tbl (_id INTEGER PRIMARY KEY,aweme_id TEXT,UNIQUE(aweme_id))");
            }

            @Override // android.database.sqlite.SQLiteOpenHelper
            public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
                Intrinsics.checkNotNullParameter(r100, "db");
                if (r101 == 1) goto L5;
                return;
            L5:
                if (r102 != 2) goto L9;
                r100.execSQL("CREATE TABLE young_digg_local_tbl (_id INTEGER PRIMARY KEY,aweme_id TEXT,UNIQUE(aweme_id))");
                return;
            }
        }

        static {
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "diggTableName");
            this.f198295a = r100;
        }

        public final void d(Context r100) {
            if (this.f198297c != null) goto L20;
            monitor-enter(this);
        L17:
            th = move-exception;
            throw th;
        L6:
            if (this.f198296b != null) goto L9;
            this.f198296b = new C2858b(r100);     // Catch: Throwable -> L17
        L9:
            if (this.f198297c != null) goto L14;
            C2858b r101 = this.f198296b;     // Catch: Throwable -> L17
            if (r101 != null) goto L13;
            Intrinsics.throwUninitializedPropertyAccessException("dbHelper");     // Catch: Throwable -> L17
            r101 = null;
        L13:
            this.f198297c = r101.getWritableDatabase();     // Catch: Throwable -> L17
        L14:
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L17
            monitor-exit(this);
            return;
        }

        public final boolean a(Context r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "awemeId");
            monitor-enter(this);
            d(r100);     // Catch: Throwable -> L14
            SQLiteDatabase r102 = this.f198297c;     // Catch: Throwable -> L14
            if (r102 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("db");     // Catch: Throwable -> L14
            r102 = null;
        L7:
            String r103 = this.f198295a;     // Catch: Throwable -> L14
            ContentValues r104 = new ContentValues();     // Catch: Throwable -> L14
            r104.put(SimilarProductParam.AWEME_ID, r101);     // Catch: Throwable -> L14
            Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L14
            if (r102.insertWithOnConflict(r103, null, r104, 2) < 0) goto L11;
            boolean r106 = true;
        L12:
            monitor-exit(this);
            return r106;
        L11:
            r106 = false;
        L14:
            th = move-exception;
            throw th;
        }

        public final boolean b(Context r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "awemeId");
            monitor-enter(this);
            d(r100);     // Catch: Throwable -> L13
            SQLiteDatabase r102 = this.f198297c;     // Catch: Throwable -> L13
            if (r102 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("db");     // Catch: Throwable -> L13
            r102 = null;
        L7:
            boolean r103 = true;
            if (r102.delete(this.f198295a, "aweme_id = ?", new String[]{r101}) > 0) goto L11;
            r103 = false;
        L11:
            monitor-exit(this);
            return r103;
        L13:
            th = move-exception;
            throw th;
        }

        public final boolean c(Context r110, String r111) {
            Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r111, "awemeId");
            monitor-enter(this);
            d(r110);     // Catch: Throwable -> L14
            SQLiteDatabase r112 = this.f198297c;     // Catch: Throwable -> L14
            if (r112 != null) goto L7;
            Intrinsics.throwUninitializedPropertyAccessException("db");     // Catch: Throwable -> L14
            r112 = null;
        L7:
            boolean r113 = true;
            Cursor r114 = r112.query(this.f198295a, new String[]{SimilarProductParam.AWEME_ID}, "aweme_id = ?", new String[]{r111}, null, null, null, "1");     // Catch: Throwable -> L14
            if (r114.getCount() > 0) goto L11;
            r113 = false;
        L11:
            r114.close();     // Catch: Throwable -> L14
            monitor-exit(this);
            return r113;
        L14:
            th = move-exception;
            throw th;
        }
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "storeTableName");
        this.f198294a = new a(r100);
    }

    public final boolean update(Context r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "aid");
        if (r102 == false) goto L8;
        if (this.f198294a.a(r100, r101) == false) goto L14;
        return true;
    L14:
        return false;
    L8:
        if (this.f198294a.b(r100, r101) == false) goto L14;
        return true;
    L11:
        e = move-exception;
        AoLogger.j(e);
        return false;
    }
}
