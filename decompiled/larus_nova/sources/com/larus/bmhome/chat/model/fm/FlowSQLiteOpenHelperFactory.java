package com.larus.bmhome.chat.model.fm;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import xh8.f;

/* JADX INFO: loaded from: classes4.dex */
public class FlowSQLiteOpenHelperFactory implements SupportSQLiteOpenHelper.Factory {
    public FlowSQLiteOpenHelperFactory() {
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public final SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration r100) {
        return new f(r100.context, r100.name, r100.callback, r100.useNoBackupDirectory);
    }
}
