package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/wikitreev2/widget/db/migration/MigrationTo16;", "Landroidx/room/migration/Migration;", "<init>", "()V", "migrate", "", "db", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MigrationTo16 extends Migration {
    public MigrationTo16() {
        super(15, 16);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        Intrinsics.checkNotNullParameter(r100, "db");
        r100.execSQL("ALTER TABLE `t_wiki_space` ADD COLUMN icon_info TEXT");
    }
}
