package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import mc5.j2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration72To73 extends Migration {
    public final Function0<Unit> a;

    public Migration72To73(j2 r3) {
        super(72, 73);
        this.a = r3;
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("ALTER TABLE `CacheStatus` ADD COLUMN status_manualoffline INTEGER NOT NULL DEFAULT 0");
        r2.execSQL("ALTER TABLE `CacheStatus` ADD COLUMN obj_type INTEGER NOT NULL DEFAULT -1");
        Function0<Unit> r3 = this.a;
        if (r3 == null) goto L6;
        r3.invoke();
        return;
    }
}
