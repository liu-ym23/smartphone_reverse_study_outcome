package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration54_55 extends Migration {
    public Migration54_55() {
        super(54, 55);
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("ALTER TABLE `DocMetaInfo` ADD COLUMN security_name TEXT");
        r2.execSQL("ALTER TABLE `DocMetaInfo` ADD COLUMN security_level INTEGER NOT NULL DEFAULT 0");
        r2.execSQL("ALTER TABLE `DocMetaInfo` ADD COLUMN wiki_real_token TEXT");
    }
}
