package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes18.dex */
public class Migration44_45 extends Migration {
    public Migration44_45() {
        super(44, 45);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("ALTER TABLE `DocMetaInfo` ADD COLUMN wiki_real_type INTEGER NOT NULL DEFAULT -1");
        r100.execSQL("ALTER TABLE `DocMetaInfo` ADD COLUMN is_subscribed INTEGER NOT NULL DEFAULT 0");
    }
}
