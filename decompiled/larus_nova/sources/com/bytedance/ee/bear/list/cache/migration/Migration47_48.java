package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes18.dex */
public class Migration47_48 extends Migration {
    public Migration47_48() {
        super(47, 48);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("ALTER TABLE `FilterCache` ADD COLUMN id INTEGER NOT NULL DEFAULT 0");
    }
}
