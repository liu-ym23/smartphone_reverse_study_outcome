package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes18.dex */
public class Migration52_53 extends Migration {
    public Migration52_53() {
        super(52, 53);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("ALTER TABLE `DocMetaInfo` ADD COLUMN wiki_version TEXT");
        r100.execSQL("UPDATE FolderSortStrategy SET type = -1 WHERE type = 20");
    }
}
