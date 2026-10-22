package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration70To71 extends Migration {
    public Migration70To71() {
        super(70, 71);
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("ALTER TABLE `ListTypes` ADD COLUMN sharer_en_name TEXT");
        r2.execSQL("ALTER TABLE `ListTypes` ADD COLUMN sharer_cn_name TEXT");
        r2.execSQL("ALTER TABLE `FilterCache` ADD COLUMN sharer_en_name TEXT");
        r2.execSQL("ALTER TABLE `FilterCache` ADD COLUMN sharer_cn_name TEXT");
    }
}
