package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import mc5.j2;

/* JADX INFO: loaded from: classes18.dex */
public class Migration72To73 extends Migration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f227688a;

    public Migration72To73(j2 r100) {
        super(72, 73);
        this.f227688a = r100;
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("ALTER TABLE `CacheStatus` ADD COLUMN status_manualoffline INTEGER NOT NULL DEFAULT 0");
        r100.execSQL("ALTER TABLE `CacheStatus` ADD COLUMN obj_type INTEGER NOT NULL DEFAULT -1");
        Function0<Unit> r101 = this.f227688a;
        if (r101 == null) goto L6;
        r101.invoke();
        return;
    }
}
