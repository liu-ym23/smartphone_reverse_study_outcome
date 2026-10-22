package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.migration;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

/* JADX INFO: loaded from: classes18.dex */
public class Migration6_7 extends Migration {
    public Migration6_7() {
        super(6, 7);
    }

    @Override // androidx.room.migration.Migration
    public final void migrate(SupportSQLiteDatabase r100) {
        r100.execSQL("CREATE TABLE IF NOT EXISTS `t_wiki_relation_info` (`space_id` TEXT NOT NULL, `space_name` TEXT, `space_icon` TEXT, `tenant_id` TEXT, `description` TEXT, `is_star` INTEGER NOT NULL, `space_type` INTEGER NOT NULL, `wiki_scope` INTEGER NOT NULL, `open_sharing` INTEGER NOT NULL, `owner_perm_type` INTEGER NOT NULL, `cover_origin` TEXT, `cover_thumbnail` TEXT, `cover_key` TEXT, `cover_is_graph_dark` INTEGER NOT NULL, `cover_color_value` TEXT, `view_wiki_collaborator` INTEGER NOT NULL, `view_wiki_info` INTEGER NOT NULL, `can_edit_first_level` INTEGER NOT NULL, PRIMARY KEY(`space_id`))");
        r100.execSQL("DROP TABLE IF EXISTS `t_wiki_version`");
    }
}
