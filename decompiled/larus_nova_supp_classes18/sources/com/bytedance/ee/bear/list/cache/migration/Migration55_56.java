package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration55_56 extends Migration {
    public Migration55_56() {
        super(55, 56);
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("ALTER TABLE `DocMetaInfo` ADD COLUMN is_secret_key_delete INTEGER NOT NULL DEFAULT 0");
        r2.execSQL("ALTER TABLE `RecentWiki` ADD COLUMN is_secret_key_delete INTEGER NOT NULL DEFAULT 0");
    }
}
