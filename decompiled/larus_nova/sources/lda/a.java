package lda;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.obric.assistant.cocreationreview.modules.omni.OmniTaskTriggerType;
import com.obric.assistant.cocreationreview.s3;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes32.dex */
public final class a extends SQLiteOpenHelper {
    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, "cocreation_omni_data.db", null, 3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase r100) {
        Intrinsics.checkNotNullParameter(r100, "db");
        r100.execSQL(StringsKt.trimIndent("\n            CREATE TABLE IF NOT EXISTS omni_data (\n                -- 稳定主键：带业务前缀，和公共 feedback 数据库通过 record_id 唯一对应。\n                record_id TEXT PRIMARY KEY NOT NULL,\n                -- Omni 原始任务 id：来自执行链路，用于业务回查和排查真实任务。\n                task_id TEXT NOT NULL,\n                -- 创建时间：用于卡片标题区时间展示，也作为列表默认排序依据。\n                created_at INTEGER NOT NULL,\n                -- 用户原始 query：用于卡片 title。\n                user_query TEXT NOT NULL,\n                -- 豆包回复：用于 Omni domain_content 区域展示。\n                dobao_answer TEXT NOT NULL,\n                -- 任务状态：success / failed / user_stopped，用于 header_tag。\n                status TEXT NOT NULL,\n                -- 任务触发类型：proactive / automatic，用于 header_tag 区分主动任务和自动任务。\n                task_trigger_type TEXT NOT NULL DEFAULT '" + OmniTaskTriggerType.PROACTIVE.getRaw() + "',\n                -- 执行步骤列表：SQLite 不支持数组，这里用 JSON array 承载详情页步骤。\n                steps TEXT NOT NULL,\n                -- 耗时：用于 foot_tag，保留业务方给出的原始展示值。\n                time TEXT NOT NULL\n            )\n            "));
        r100.execSQL("CREATE INDEX IF NOT EXISTS idx_omni_data_created_at ON omni_data(created_at)");
        s3.b("omni.database", "created name=cocreation_omni_data.db, version=3, table=omni_data");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "db");
        if (r101 >= 2) goto L6;
        r100.execSQL("ALTER TABLE omni_data ADD COLUMN task_id TEXT NOT NULL DEFAULT ''");
        r100.execSQL("UPDATE omni_data SET task_id = record_id WHERE task_id = ''");
        r100.execSQL("UPDATE omni_data SET record_id = 'omni_' || record_id WHERE substr(record_id, 1, 5) != 'omni_'");
        int r103 = s3.f387719a;
        s3.b("omni.database", "migrated v2 add task_id and prefix record_id old=" + r101 + ", new=" + r102);
    L6:
        if (r101 >= 3) goto L9;
        r100.execSQL("ALTER TABLE omni_data ADD COLUMN task_trigger_type TEXT NOT NULL DEFAULT '" + OmniTaskTriggerType.PROACTIVE.getRaw() + '\'');
        int r104 = s3.f387719a;
        s3.b("omni.database", "migrated v3 add task_trigger_type old=" + r101 + ", new=" + r102);
        return;
    }
}
