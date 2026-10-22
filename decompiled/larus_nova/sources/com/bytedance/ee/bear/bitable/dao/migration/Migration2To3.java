package com.bytedance.ee.bear.bitable.dao.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/dao/migration/Migration2To3;", "Landroidx/room/migration/Migration;", "<init>", "()V", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Migration2To3 extends Migration {
    public Migration2To3() {
        super(2, 3);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        Intrinsics.checkNotNullParameter(r100, "database");
        r100.execSQL("DROP TABLE BitableResourceData");
        r100.execSQL("CREATE TABLE BitableResourceData(base_token  TEXT NOT NULL,block_id    TEXT NOT NULL,res_key     TEXT NOT NULL,obj_token   TEXT NOT NULL,view_id     TEXT NOT NULL,res_value   TEXT,rev1        INTEGER NOT NULL,rev2        INTEGER NOT NULL,timestamp   INTEGER NOT NULL,PRIMARY KEY(base_token,res_key,block_id,obj_token))");
    }
}
