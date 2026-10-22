package com.bytedance.ee.bear.list.cache.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class Migration74To75 extends Migration {
    public Migration74To75() {
        super(74, 75);
    }

    public final void migrate(SupportSQLiteDatabase r2) {
        r2.execSQL("CREATE TABLE IF NOT EXISTS `TtsPlaybackBean` (`obj_token` TEXT NOT NULL PRIMARY KEY, `obj_type` INTEGER NOT NULL DEFAULT -1, `title` TEXT, `owner_name` TEXT, `icon_info` TEXT, `create_time_ms` INTEGER NOT NULL DEFAULT 0, `update_time_ms` INTEGER NOT NULL DEFAULT 0, `last_play_time_ms` INTEGER NOT NULL DEFAULT 0, `duration_ms` INTEGER NOT NULL DEFAULT 0, `progress_ms` INTEGER NOT NULL DEFAULT 0, `speed` REAL NOT NULL DEFAULT 1.0, `tone_id` TEXT, `tone_name` TEXT)");
        r2.execSQL("CREATE INDEX IF NOT EXISTS index_obj_token ON TtsPlaybackBean(`obj_token`)");
    }
}
