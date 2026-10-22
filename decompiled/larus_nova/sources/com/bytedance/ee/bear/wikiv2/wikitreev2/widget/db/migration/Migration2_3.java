package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes18.dex */
public class Migration2_3 extends Migration {
    public Migration2_3() {
        super(2, 3);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("ALTER TABLE `t_wiki_relation` ADD COLUMN secret_key_delete INTEGER NOT NULL DEFAULT 0");
    }
}
