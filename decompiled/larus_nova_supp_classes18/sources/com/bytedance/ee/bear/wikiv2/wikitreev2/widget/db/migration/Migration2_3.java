package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration2_3 extends Migration {
    public Migration2_3() {
        super(2, 3);
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("ALTER TABLE `t_wiki_relation` ADD COLUMN secret_key_delete INTEGER NOT NULL DEFAULT 0");
    }
}
