package com.obric.assistant.cocreationreview.modules.searchqa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.obric.assistant.cocreationreview.s3;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends SQLiteOpenHelper {
    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, "cocreation_search_qa_data.db", null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r100) {
        Intrinsics.checkNotNullParameter(r100, "db");
        r100.execSQL("CREATE TABLE IF NOT EXISTS search_qa_data (\n    record_id TEXT PRIMARY KEY NOT NULL,\n    created_at INTEGER NOT NULL,\n    user_question TEXT NOT NULL,\n    answer_text TEXT NOT NULL,\n    answer_summary TEXT NOT NULL,\n    local_references TEXT NOT NULL,\n    log_id TEXT\n)");
        r100.execSQL("CREATE INDEX IF NOT EXISTS idx_search_qa_data_created_at ON search_qa_data(created_at)");
        s3.b("search_qa.database", "created name=cocreation_search_qa_data.db, version=1, table=search_qa_data");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "db");
        int r103 = s3.f387719a;
        s3.c("search_qa.database", "onUpgrade old=" + r101 + ", new=" + r102 + ", action=noop");
    }
}
