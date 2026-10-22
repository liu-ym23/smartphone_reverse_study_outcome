package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes18.dex */
public class Migration67To68 extends Migration {
    public Migration67To68() {
        super(67, 68);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("ALTER TABLE `ListTypes` ADD COLUMN star_time_star TEXT");
        r100.execSQL("ALTER TABLE `DocMetaInfo` ADD COLUMN icon TEXT");
        r100.execSQL("ALTER TABLE `FilterCache` ADD COLUMN star_time_star TEXT");
        r100.execSQL("ALTER TABLE `FilterCache` ADD COLUMN icon TEXT");
    }
}
