package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration62_63 extends Migration {
    public Migration62_63() {
        super(62, 63);
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("ALTER TABLE `DocMetaInfo` ADD COLUMN is_insert INTEGER NOT NULL DEFAULT 0");
        r2.execSQL("ALTER TABLE `DocMetaInfo` ADD COLUMN organization_tag_value TEXT");
    }
}
