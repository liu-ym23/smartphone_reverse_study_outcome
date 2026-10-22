package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration69To70 extends Migration {
    public Migration69To70() {
        super(69, 70);
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("DROP TABLE IF EXISTS `RecentWiki`");
    }
}
