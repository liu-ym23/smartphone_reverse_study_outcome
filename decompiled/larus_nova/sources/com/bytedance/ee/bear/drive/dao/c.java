package com.bytedance.ee.bear.drive.dao;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.ee.bear.drive.cache.w;
import com.bytedance.ee.util.db.DBController;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;

/* JADX INFO: loaded from: classes16.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile c f224397a;

    public class a extends RoomDatabase.Callback {
        public a() {
        }

        @Override // androidx.room.RoomDatabase.Callback
        public final void onCreate(SupportSQLiteDatabase r100) {
            super.onCreate(r100);
            tt5.a.h("DRIVE_DB", WidgetCostModule.TYPE_ON_CREATE);
        }

        @Override // androidx.room.RoomDatabase.Callback
        public final void onOpen(SupportSQLiteDatabase r100) {
            super.onOpen(r100);
            tt5.a.h("DRIVE_DB", "onOpen");
        }
    }

    public class b extends Migration {
        public b() {
            super(9, 10);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE t_drive_cache ADD COLUMN risk_status Integer NOT NULL DEFAULT 0");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.dao.c$c, reason: collision with other inner class name */
    public class C3219c extends Migration {
        public C3219c() {
            super(8, 9);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE t_drive_cache ADD COLUMN cache_source_from TEXT");
        }
    }

    public class d extends Migration {
        public d() {
            super(7, 8);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("DELETE FROM t_drive_cache");
            r100.execSQL("DELETE FROM drive_excel_sub_cache");
            ((w) org.koin.java.a.a(w.class)).E8();
        }
    }

    public class e extends Migration {
        public e() {
            super(6, 7);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE t_drive_cache ADD COLUMN temp_file_path TEXT");
        }
    }

    public class f extends Migration {
        public f() {
            super(5, 6);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE t_drive_cache ADD COLUMN mime_type TEXT");
        }
    }

    public class g extends Migration {
        public g() {
            super(4, 5);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("DROP TABLE IF EXISTS `drive_excel_sub_cache`");
            r100.execSQL("CREATE TABLE IF NOT EXISTS `drive_excel_sub_cache` (`sdk_app_id` TEXT NOT NULL , `obj_token` TEXT NOT NULL, `data_version` TEXT NOT NULL, `sub_id` TEXT NOT NULL, `json_data_file_path` TEXT NOT NULL, `json_data` TEXT NOT NULL,PRIMARY KEY(`sdk_app_id`, `obj_token`, `data_version`, `sub_id`))");
            r100.execSQL("ALTER TABLE t_drive_cache ADD COLUMN flags Integer NOT NULL DEFAULT 0");
        }
    }

    public class h extends Migration {
        public h() {
            super(3, 4);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE t_drive_cache ADD COLUMN cache_host Integer NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE t_drive_cache ADD COLUMN sdk_app_id TEXT");
            r100.execSQL("ALTER TABLE t_drive_cache ADD COLUMN sdk_extra TEXT");
        }
    }

    public class i extends Migration {
        public i() {
            super(2, 3);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE t_drive_cache ADD COLUMN partial_file_path TEXT");
            r100.execSQL("ALTER TABLE t_drive_cache ADD COLUMN is_use_partial_file INTEGER NOT NULL DEFAULT 0");
            r100.execSQL("ALTER TABLE t_drive_cache ADD COLUMN preview_extra TEXT");
        }
    }

    public class j extends Migration {
        public j() {
            super(1, 2);
        }

        @Override // androidx.room.migration.Migration
        public final void migrate(SupportSQLiteDatabase r100) {
            r100.execSQL("ALTER TABLE t_drive_cache ADD COLUMN cache_uid TEXT");
            r100.execSQL("ALTER TABLE t_drive_cache ADD COLUMN cache_tenant_id TEXT");
        }
    }

    public final com.bytedance.ee.bear.drive.dao.a a() {
        monitor-enter(this);
        DriveDatabase r100 = (DriveDatabase) DBController.a().r1("drive.db");     // Catch: Throwable -> L7
        monitor-exit(this);
        return r100.c();
    L7:
        th = move-exception;
        throw th;
    }

    public final com.bytedance.ee.bear.drive.dao.d b() {
        monitor-enter(this);
        DriveDatabase r100 = (DriveDatabase) DBController.a().r1("drive.db");     // Catch: Throwable -> L7
        monitor-exit(this);
        return r100.d();
    L7:
        th = move-exception;
        throw th;
    }

    public static c c() {
        if (f224397a != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f224397a != null) goto L9;
        f224397a = new c(eu5.b.f474075a);     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return f224397a;
    }

    public c(Context r100) {
        DBController.a r101 = new DBController.a(r100);
        r101.f243099a = "drive.db";
        r101.f243100b = DriveDatabase.class;
        r101.f243102d = new a();
        r101.a(new Migration[]{new j()});
        r101.a(new Migration[]{new i()});
        r101.a(new Migration[]{new h()});
        r101.a(new Migration[]{new g()});
        r101.a(new Migration[]{new f()});
        r101.a(new Migration[]{new e()});
        r101.a(new Migration[]{new d()});
        r101.a(new Migration[]{new C3219c()});
        r101.a(new Migration[]{new b()});
        DBController.a().W3("drive.db", r101);
    }
}
