package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration3_4 extends Migration {
    public Migration3_4() {
        super(3, 4);
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("CREATE TABLE IF NOT EXISTS `t_wiki_version` (`wiki_token` TEXT NOT NULL, `version` TEXT, PRIMARY KEY(`wiki_token`))");
    }
}
