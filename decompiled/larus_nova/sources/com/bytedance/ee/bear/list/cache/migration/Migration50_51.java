package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes18.dex */
public class Migration50_51 extends Migration {
    public Migration50_51() {
        super(50, 51);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("ALTER TABLE `WikiSpace` ADD COLUMN wiki_scope INTEGER NOT NULL DEFAULT 0");
    }
}
