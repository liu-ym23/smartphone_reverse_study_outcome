package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes18.dex */
public class Migration76To77 extends Migration {
    public Migration76To77() {
        super(76, 77);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("ALTER TABLE DocMetaInfo ADD COLUMN obj_sub_type INTEGER NOT NULL DEFAULT 0");
    }
}
