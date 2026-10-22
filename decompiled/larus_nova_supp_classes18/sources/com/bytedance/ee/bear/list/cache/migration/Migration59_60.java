package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration59_60 extends Migration {
    public Migration59_60() {
        super(59, 60);
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("ALTER TABLE `WikiSpace` ADD COLUMN open_sharing INTEGER NOT NULL DEFAULT 0");
    }
}
