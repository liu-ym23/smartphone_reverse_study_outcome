package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes18.dex */
public class Migration42_43 extends Migration {
    public Migration42_43() {
        super(42, 43);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("CREATE INDEX IF NOT EXISTS `index_ListTypes_obj_token_list_type` ON `ListTypes` (`obj_token`, `list_type`)");
    }
}
