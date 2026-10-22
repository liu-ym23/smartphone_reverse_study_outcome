package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration41_42 extends Migration {
    public Migration41_42() {
        super(41, 42);
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("ALTER TABLE ListTypes ADD COLUMN has_perm_folder INTEGER NOT NULL DEFAULT 1");
        r2.execSQL("ALTER TABLE ListTypes ADD COLUMN show_external_hint_folder INTEGER NOT NULL DEFAULT 0");
    }
}
