package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes18.dex */
public class Migration75To76 extends Migration {
    public Migration75To76() {
        super(75, 76);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("ALTER TABLE DocMetaInfo ADD COLUMN is_wiki_home_page INTEGER NOT NULL DEFAULT 0");
    }
}
