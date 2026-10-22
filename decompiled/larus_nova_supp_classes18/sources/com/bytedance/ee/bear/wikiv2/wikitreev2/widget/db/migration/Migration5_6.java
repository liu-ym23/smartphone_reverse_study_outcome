package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration5_6 extends Migration {
    public Migration5_6() {
        super(5, 6);
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("CREATE TABLE IF NOT EXISTS `t_wiki_route_table_new` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `wiki_token` TEXT, `obj_token` TEXT, `obj_type` INTEGER NOT NULL DEFAULT -1, `in_space` INTEGER NOT NULL DEFAULT 0, `access_time` INTEGER NOT NULL DEFAULT 0)");
        r2.execSQL("DROP TABLE IF EXISTS 't_wiki_route_table'");
        r2.execSQL("ALTER TABLE t_wiki_route_table_new RENAME TO t_wiki_route_table");
    }
}
