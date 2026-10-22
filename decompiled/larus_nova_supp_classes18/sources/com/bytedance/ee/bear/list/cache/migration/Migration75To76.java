package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration75To76 extends Migration {
    public Migration75To76() {
        super(75, 76);
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("ALTER TABLE DocMetaInfo ADD COLUMN is_wiki_home_page INTEGER NOT NULL DEFAULT 0");
    }
}
