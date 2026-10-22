package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration76To77 extends Migration {
    public Migration76To77() {
        super(76, 77);
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("ALTER TABLE DocMetaInfo ADD COLUMN obj_sub_type INTEGER NOT NULL DEFAULT 0");
    }
}
