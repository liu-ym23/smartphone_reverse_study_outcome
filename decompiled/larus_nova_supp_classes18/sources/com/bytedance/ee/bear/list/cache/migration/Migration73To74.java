package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration73To74 extends Migration {
    public Migration73To74() {
        super(73, 74);
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("ALTER TABLE `CacheStatus` ADD COLUMN download_type INTEGER NOT NULL DEFAULT 0");
    }
}
