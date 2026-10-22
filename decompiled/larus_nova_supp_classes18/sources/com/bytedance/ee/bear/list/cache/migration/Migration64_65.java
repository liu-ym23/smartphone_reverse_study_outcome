package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration64_65 extends Migration {
    public Migration64_65() {
        super(64, 65);
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("ALTER TABLE `ListTypes` ADD COLUMN shortcut_thumbnail_type INTEGER NOT NULL DEFAULT 0");
        r2.execSQL("ALTER TABLE `ListTypes` ADD COLUMN shortcut_thumbnail_url TEXT");
        r2.execSQL("ALTER TABLE `ListTypes` ADD COLUMN shortcut_thumbnail_secret TEXT");
        r2.execSQL("ALTER TABLE `ListTypes` ADD COLUMN shortcut_thumbnail_nonce TEXT");
        r2.execSQL("ALTER TABLE `ListTypes` ADD COLUMN shortcut_thumbnail TEXT");
        r2.execSQL("ALTER TABLE `FilterCache` ADD COLUMN shortcut_thumbnail_type INTEGER NOT NULL DEFAULT 0");
        r2.execSQL("ALTER TABLE `FilterCache` ADD COLUMN shortcut_thumbnail_url TEXT");
        r2.execSQL("ALTER TABLE `FilterCache` ADD COLUMN shortcut_thumbnail_secret TEXT");
        r2.execSQL("ALTER TABLE `FilterCache` ADD COLUMN shortcut_thumbnail_nonce TEXT");
        r2.execSQL("ALTER TABLE `FilterCache` ADD COLUMN shortcut_thumbnail TEXT");
    }
}
