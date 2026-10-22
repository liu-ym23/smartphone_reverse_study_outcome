package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes18.dex */
public class Migration9_10 extends Migration {
    public Migration9_10() {
        super(9, 10);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("CREATE TABLE IF NOT EXISTS `t_wiki_space` (`space_id` TEXT NOT NULL, `space_name` TEXT, `description` TEXT, `space_icon` TEXT, `tenant_id` TEXT, `cover_origin` TEXT, `cover_thumbnail` TEXT, `cover_key` TEXT, `cover_is_graph_dark` INTEGER NOT NULL, `cover_color_value` TEXT, `root_token` TEXT, `space_type` INTEGER NOT NULL, `wiki_scope` INTEGER NOT NULL, `is_star` INTEGER NOT NULL, `browse_time` TEXT, `owner_perm_type` INTEGER NOT NULL, `open_sharing` INTEGER NOT NULL, PRIMARY KEY(`space_id`))");
        r100.execSQL("CREATE TABLE IF NOT EXISTS `t_wiki_space_list_ref` (`space_id` TEXT NOT NULL, `space_list_type` INTEGER NOT NULL, `space_type_id` TEXT NOT NULL, `space_class_id` TEXT NOT NULL, PRIMARY KEY(`space_id`, `space_list_type`, `space_type_id`, `space_class_id`), FOREIGN KEY(`space_id`) REFERENCES `t_wiki_space`(`space_id`) ON UPDATE CASCADE)");
    }
}
