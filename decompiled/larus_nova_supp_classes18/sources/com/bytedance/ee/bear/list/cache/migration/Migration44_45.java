package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration44_45 extends Migration {
    public Migration44_45() {
        super(44, 45);
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("ALTER TABLE `DocMetaInfo` ADD COLUMN wiki_real_type INTEGER NOT NULL DEFAULT -1");
        r2.execSQL("ALTER TABLE `DocMetaInfo` ADD COLUMN is_subscribed INTEGER NOT NULL DEFAULT 0");
    }
}
