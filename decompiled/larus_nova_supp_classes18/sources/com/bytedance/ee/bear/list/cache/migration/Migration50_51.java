package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration50_51 extends Migration {
    public Migration50_51() {
        super(50, 51);
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("ALTER TABLE `WikiSpace` ADD COLUMN wiki_scope INTEGER NOT NULL DEFAULT 0");
    }
}
