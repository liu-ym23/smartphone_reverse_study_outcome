package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes18.dex */
public class Migration8_9 extends Migration {
    public Migration8_9() {
        super(8, 9);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("ALTER TABLE `t_wiki_relation` ADD COLUMN origin_is_external INTEGER NOT NULL DEFAULT 0");
        r100.execSQL("ALTER TABLE `t_wiki_relation` ADD COLUMN entity_delete_flag INTEGER NOT NULL DEFAULT 0");
    }
}
