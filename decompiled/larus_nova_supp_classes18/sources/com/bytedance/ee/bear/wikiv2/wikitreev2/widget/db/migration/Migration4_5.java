package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration4_5 extends Migration {
    public Migration4_5() {
        super(4, 5);
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("CREATE TABLE IF NOT EXISTS `t_wiki_route_table` (`wiki_token` TEXT, `obj_token` TEXT, `obj_type` INTEGER, `in_space` INTEGER NOT NULL DEFAULT 0, `access_time` INTEGER)");
        r2.execSQL("ALTER TABLE `t_wiki_relation` ADD COLUMN is_explorer_star INTEGER NOT NULL DEFAULT 0");
    }
}
