package com.bytedance.ee.bear.drive.dao;

import android.content.Context;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.ee.bear.drive.cache.w;
import com.bytedance.ee.util.db.DBController;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c {
    public static volatile c a;

    public class a extends RoomDatabase.Callback {
        public a() {
        }

        public final void onCreate(SupportSQLiteDatabase r2) {
            super.onCreate(r2);
            tt5.a.h("DRIVE_DB", "onCreate");
        }

        public final void onOpen(SupportSQLiteDatabase r2) {
            super.onOpen(r2);
            tt5.a.h("DRIVE_DB", "onOpen");
        }
    }

    public class b extends Migration {
        public b() {
            super(9, 10);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE t_drive_cache ADD COLUMN risk_status Integer NOT NULL DEFAULT 0");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.dao.c$c, reason: collision with other inner class name */
    public class C0163c extends Migration {
        public C0163c() {
            super(8, 9);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE t_drive_cache ADD COLUMN cache_source_from TEXT");
        }
    }

    public class d extends Migration {
        public d() {
            super(7, 8);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("DELETE FROM t_drive_cache");
            r2.execSQL("DELETE FROM drive_excel_sub_cache");
            ((w) org.koin.java.a.a(w.class)).E8();
        }
    }

    public class e extends Migration {
        public e() {
            super(6, 7);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE t_drive_cache ADD COLUMN temp_file_path TEXT");
        }
    }

    public class f extends Migration {
        public f() {
            super(5, 6);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE t_drive_cache ADD COLUMN mime_type TEXT");
        }
    }

    public class g extends Migration {
        public g() {
            super(4, 5);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("DROP TABLE IF EXISTS `drive_excel_sub_cache`");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `drive_excel_sub_cache` (`sdk_app_id` TEXT NOT NULL , `obj_token` TEXT NOT NULL, `data_version` TEXT NOT NULL, `sub_id` TEXT NOT NULL, `json_data_file_path` TEXT NOT NULL, `json_data` TEXT NOT NULL,PRIMARY KEY(`sdk_app_id`, `obj_token`, `data_version`, `sub_id`))");
            r2.execSQL("ALTER TABLE t_drive_cache ADD COLUMN flags Integer NOT NULL DEFAULT 0");
        }
    }

    public class h extends Migration {
        public h() {
            super(3, 4);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE t_drive_cache ADD COLUMN cache_host Integer NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE t_drive_cache ADD COLUMN sdk_app_id TEXT");
            r2.execSQL("ALTER TABLE t_drive_cache ADD COLUMN sdk_extra TEXT");
        }
    }

    public class i extends Migration {
        public i() {
            super(2, 3);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE t_drive_cache ADD COLUMN partial_file_path TEXT");
            r2.execSQL("ALTER TABLE t_drive_cache ADD COLUMN is_use_partial_file INTEGER NOT NULL DEFAULT 0");
            r2.execSQL("ALTER TABLE t_drive_cache ADD COLUMN preview_extra TEXT");
        }
    }

    public class j extends Migration {
        public j() {
            super(1, 2);
        }

        public final void migrate(SupportSQLiteDatabase r2) {
            r2.execSQL("ALTER TABLE t_drive_cache ADD COLUMN cache_uid TEXT");
            r2.execSQL("ALTER TABLE t_drive_cache ADD COLUMN cache_tenant_id TEXT");
        }
    }

    public final com.bytedance.ee.bear.drive.dao.a a() {
        monitor-enter(this);
        DriveDatabase r0 = (DriveDatabase) DBController.a().r1("drive.db");     // Catch: Throwable -> L7
        monitor-exit(this);
        return r0.c();
    L7:
        th = move-exception;
        throw th;
    }

    public final com.bytedance.ee.bear.drive.dao.d b() {
        monitor-enter(this);
        DriveDatabase r0 = (DriveDatabase) DBController.a().r1("drive.db");     // Catch: Throwable -> L7
        monitor-exit(this);
        return r0.d();
    L7:
        th = move-exception;
        throw th;
    }

    public static c c() {
        if (a != null) goto L15;
        monitor-enter(c.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (a != null) goto L9;
        a = new c(eu5.b.a);     // Catch: Throwable -> L11
    L9:
        monitor-exit(c.class);     // Catch: Throwable -> L11
    L15:
        return a;
    }

    public c(Context r6) {
        DBController.a r0 = new DBController.a(r6);
        r0.a = "drive.db";
        r0.b = DriveDatabase.class;
        r0.d = new a();
        r0.a(new Migration[]{new j()});
        r0.a(new Migration[]{new i()});
        r0.a(new Migration[]{new h()});
        r0.a(new Migration[]{new g()});
        r0.a(new Migration[]{new f()});
        r0.a(new Migration[]{new e()});
        r0.a(new Migration[]{new d()});
        r0.a(new Migration[]{new C0163c()});
        r0.a(new Migration[]{new b()});
        DBController.a().W3("drive.db", r0);
    }
}
