package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration52_53 extends Migration {
    public Migration52_53() {
        super(52, 53);
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("ALTER TABLE `DocMetaInfo` ADD COLUMN wiki_version TEXT");
        r2.execSQL("UPDATE FolderSortStrategy SET type = -1 WHERE type = 20");
    }
}
