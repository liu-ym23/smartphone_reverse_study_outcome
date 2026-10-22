package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes18.dex */
public class Migration65_66 extends Migration {
    public Migration65_66() {
        super(65, 66);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("ALTER TABLE `WikiSpace` ADD COLUMN tag_type INTEGER NOT NULL DEFAULT 0");
        r100.execSQL("ALTER TABLE `WikiSpace` ADD COLUMN tag_value TEXT");
    }
}
