package com.obric.assistant.cocreationreview;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class h extends SQLiteOpenHelper {
    public h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, "cocreation_feedback_data.db", null, 3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r100) {
        Intrinsics.checkNotNullParameter(r100, "db");
        r100.execSQL("CREATE TABLE IF NOT EXISTS feedback_data (\n    -- 稳定主键：和各业务自己的原子数据表通过 record_id 唯一对应。\n    record_id TEXT PRIMARY KEY NOT NULL,\n    -- 标注结果创建时间：用于已标注历史里的“提交于”展示和后续增量同步。\n    created_at INTEGER NOT NULL,\n    -- 点赞 / 点踩：存储 Vote.raw，也允许空值以兼容未完成草稿不入库的约束。\n    vote TEXT,\n    -- 反馈标签列表：SQLite 不支持数组，这里用 JSON array 承载。\n    reasons TEXT NOT NULL,\n    -- 用户补充说明：没有填写时存空字符串。\n    comment TEXT NOT NULL,\n    -- 已提交媒体元数据：仅用于本地进程重启后的缩略图恢复。\n    media_json TEXT NOT NULL DEFAULT '[]',\n    -- 未填写为 NULL，0 是明确选择的价值。\n    feedback_value INTEGER\n)");
        r100.execSQL("CREATE INDEX IF NOT EXISTS idx_feedback_data_created_at ON feedback_data(created_at)");
        s3.b("feedback.database", "created name=cocreation_feedback_data.db, version=3, table=feedback_data");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "db");
        if (r101 >= 2) goto L8;
        if (k.a(r100, "media_json") == true) goto L8;
        r100.execSQL("ALTER TABLE feedback_data ADD COLUMN media_json TEXT NOT NULL DEFAULT '[]'");
    L8:
        if (r101 < 3) goto L10;
    L12:
        int r103 = s3.f387719a;
        s3.c("feedback.database", "onUpgrade old=" + r101 + ", new=" + r102 + ", action=incremental");
        return;
    L10:
        if (k.a(r100, "feedback_value") == true) goto L12;
        r100.execSQL("ALTER TABLE feedback_data ADD COLUMN feedback_value INTEGER");
        goto L12
    }
}
