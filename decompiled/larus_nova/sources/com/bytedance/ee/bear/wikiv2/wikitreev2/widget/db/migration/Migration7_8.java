package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes18.dex */
public class Migration7_8 extends Migration {
    public Migration7_8() {
        super(7, 8);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("ALTER TABLE t_wiki_route_table ADD COLUMN log_id TEXT");
    }
}
