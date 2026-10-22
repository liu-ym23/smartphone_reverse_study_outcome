package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes18.dex */
public class Migration1_2 extends Migration {
    public Migration1_2() {
        super(1, 2);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("DELETE FROM t_wiki_relation");
        r100.execSQL("ALTER TABLE t_wiki_relation ADD COLUMN has_child INTEGER NOT NULL DEFAULT 0");
    }
}
