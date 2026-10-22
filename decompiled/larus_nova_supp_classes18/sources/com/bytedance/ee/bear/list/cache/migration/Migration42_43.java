package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration42_43 extends Migration {
    public Migration42_43() {
        super(42, 43);
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("CREATE INDEX IF NOT EXISTS `index_ListTypes_obj_token_list_type` ON `ListTypes` (`obj_token`, `list_type`)");
    }
}
