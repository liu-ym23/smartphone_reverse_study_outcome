package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes18.dex */
public class Migration64_65 extends Migration {
    public Migration64_65() {
        super(64, 65);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("ALTER TABLE `ListTypes` ADD COLUMN shortcut_thumbnail_type INTEGER NOT NULL DEFAULT 0");
        r100.execSQL("ALTER TABLE `ListTypes` ADD COLUMN shortcut_thumbnail_url TEXT");
        r100.execSQL("ALTER TABLE `ListTypes` ADD COLUMN shortcut_thumbnail_secret TEXT");
        r100.execSQL("ALTER TABLE `ListTypes` ADD COLUMN shortcut_thumbnail_nonce TEXT");
        r100.execSQL("ALTER TABLE `ListTypes` ADD COLUMN shortcut_thumbnail TEXT");
        r100.execSQL("ALTER TABLE `FilterCache` ADD COLUMN shortcut_thumbnail_type INTEGER NOT NULL DEFAULT 0");
        r100.execSQL("ALTER TABLE `FilterCache` ADD COLUMN shortcut_thumbnail_url TEXT");
        r100.execSQL("ALTER TABLE `FilterCache` ADD COLUMN shortcut_thumbnail_secret TEXT");
        r100.execSQL("ALTER TABLE `FilterCache` ADD COLUMN shortcut_thumbnail_nonce TEXT");
        r100.execSQL("ALTER TABLE `FilterCache` ADD COLUMN shortcut_thumbnail TEXT");
    }
}
