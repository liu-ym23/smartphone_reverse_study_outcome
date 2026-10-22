package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes18.dex */
public class Migration53_54 extends Migration {
    public Migration53_54() {
        super(53, 54);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("ALTER TABLE `ListTypes` ADD COLUMN shortcut_owner_cn_name TEXT");
        r100.execSQL("ALTER TABLE `ListTypes` ADD COLUMN shortcut_owner_en_name TEXT");
        r100.execSQL("ALTER TABLE `FilterCache` ADD COLUMN shortcut_owner_cn_name TEXT");
        r100.execSQL("ALTER TABLE `FilterCache` ADD COLUMN shortcut_owner_en_name TEXT");
    }
}
