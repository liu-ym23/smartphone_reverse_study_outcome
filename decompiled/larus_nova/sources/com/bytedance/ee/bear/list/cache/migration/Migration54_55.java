package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes18.dex */
public class Migration54_55 extends Migration {
    public Migration54_55() {
        super(54, 55);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("ALTER TABLE `DocMetaInfo` ADD COLUMN security_name TEXT");
        r100.execSQL("ALTER TABLE `DocMetaInfo` ADD COLUMN security_level INTEGER NOT NULL DEFAULT 0");
        r100.execSQL("ALTER TABLE `DocMetaInfo` ADD COLUMN wiki_real_token TEXT");
    }
}
