package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes18.dex */
public class Migration51_52 extends Migration {
    public Migration51_52() {
        super(51, 52);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("ALTER TABLE `WikiSpace` ADD COLUMN space_type INTEGER NOT NULL DEFAULT -1");
    }
}
