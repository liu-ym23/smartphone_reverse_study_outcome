package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes18.dex */
public class Migration41_42 extends Migration {
    public Migration41_42() {
        super(41, 42);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("ALTER TABLE ListTypes ADD COLUMN has_perm_folder INTEGER NOT NULL DEFAULT 1");
        r100.execSQL("ALTER TABLE ListTypes ADD COLUMN show_external_hint_folder INTEGER NOT NULL DEFAULT 0");
    }
}
