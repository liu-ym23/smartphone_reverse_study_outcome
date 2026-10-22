package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes18.dex */
public class Migration59_60 extends Migration {
    public Migration59_60() {
        super(59, 60);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("ALTER TABLE `WikiSpace` ADD COLUMN open_sharing INTEGER NOT NULL DEFAULT 0");
    }
}
