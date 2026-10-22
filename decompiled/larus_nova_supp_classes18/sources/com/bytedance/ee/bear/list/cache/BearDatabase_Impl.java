package com.bytedance.ee.bear.list.cache;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.room.RoomOpenHelper;
import androidx.room.util.DBUtil;
import androidx.room.util.TableInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import mc5.c3;
import mc5.d1;
import mc5.e;
import mc5.i;
import mc5.j3;
import mc5.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class BearDatabase_Impl extends BearDatabase {
    public volatile i a;
    public volatile j3 b;
    public volatile d1 c;

    public class a extends RoomOpenHelper.Delegate {
        public final /* synthetic */ BearDatabase_Impl a;

        public final void onPostMigrate(SupportSQLiteDatabase r1) {
        }

        public a(BearDatabase_Impl r1) {
            this.a = r1;
            super(77);
        }

        public final void createAllTables(SupportSQLiteDatabase r2) {
            r2.execSQL("CREATE TABLE IF NOT EXISTS `FolderSortStrategy` (`obj_token` TEXT NOT NULL, `type` INTEGER NOT NULL, `file_type` TEXT, `forbidden_file_type` TEXT, `strategy` INTEGER NOT NULL, `is_asc` INTEGER NOT NULL, `update_time` TEXT, `user_id` TEXT, PRIMARY KEY(`obj_token`))");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `WikiSpace` (`space_id` TEXT NOT NULL, `user_id` TEXT, `space_name` TEXT, `space_icon` TEXT, `attr` INTEGER NOT NULL, `description` TEXT, `is_star` INTEGER NOT NULL, `browse_time` TEXT, `wiki_token` TEXT, `obj_type` INTEGER NOT NULL, `obj_token` TEXT, `origin` TEXT, `thumbnail` TEXT, `cover_key` TEXT, `is_graph_dark` INTEGER NOT NULL, `color_value` TEXT, `wiki_scope` INTEGER NOT NULL, `space_type` INTEGER NOT NULL, `open_sharing` INTEGER NOT NULL, `tag_type` INTEGER NOT NULL, `tag_value` TEXT, PRIMARY KEY(`space_id`))");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `ListTypes` (`obj_token` TEXT NOT NULL, `list_type` INTEGER NOT NULL, `token` TEXT NOT NULL, `extra` TEXT, `space_id` TEXT, `file_path` TEXT NOT NULL, `add_time_manualoffline` TEXT, `is_need_wifi_download` INTEGER NOT NULL, `open_time_recent` TEXT, `my_edit_time_recent` TEXT, `activity_time_recent` TEXT, `has_perm_folder` INTEGER NOT NULL, `show_external_hint_folder` INTEGER NOT NULL, `node_type_folder` INTEGER NOT NULL, `shortcut_name_folder` TEXT, `shortcut_owner_cn_name` TEXT, `shortcut_owner_en_name` TEXT, `shortcut_obj_biz_type` INTEGER NOT NULL, `shortcut_obj_node_token` TEXT, `shortcut_obj_delete_flag` INTEGER NOT NULL, `is_hidden_share` INTEGER NOT NULL, `share_time_share` TEXT, `sharer_en_name` TEXT, `sharer_cn_name` TEXT, `star_time_star` TEXT, `shortcut_thumbnail_url` TEXT, `shortcut_thumbnail_secret` TEXT, `shortcut_thumbnail_nonce` TEXT, `shortcut_thumbnail_type` INTEGER NOT NULL, `shortcut_thumbnail` TEXT, `subordinate_id` TEXT, PRIMARY KEY(`obj_token`, `list_type`, `token`), FOREIGN KEY(`obj_token`) REFERENCES `DocMetaInfo`(`obj_token`) ON UPDATE CASCADE ON DELETE NO ACTION )");
            r2.execSQL("CREATE INDEX IF NOT EXISTS `index_ListTypes_obj_token_list_type` ON `ListTypes` (`obj_token`, `list_type`)");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `DocMetaInfo` (`obj_token` TEXT NOT NULL, `name` TEXT, `type` TEXT, `owner_id` TEXT, `create_tenant_id` TEXT, `creator_cn_name` TEXT, `creator_en_name` TEXT, `edit_uid` TEXT, `edit_time` TEXT, `url` TEXT, `fake_token` TEXT, `is_stared` INTEGER NOT NULL, `is_pined` INTEGER NOT NULL, `is_subscribed` INTEGER NOT NULL, `extra_icon_url` TEXT, `extra_icon_key` TEXT, `extra_icon_nonce` TEXT, `extra_icon_encrypted_type` INTEGER NOT NULL, `extra_copiable` INTEGER NOT NULL, `extra_is_share_root` INTEGER NOT NULL, `extra_is_external` INTEGER NOT NULL, `extra_sub_type` TEXT, `obj_sub_type` INTEGER NOT NULL, `is_visited` INTEGER NOT NULL, `create_time` TEXT, `thumbnail_url` TEXT, `thumbnail_secret` TEXT, `thumbnail_nonce` TEXT, `thumbnail_type` INTEGER NOT NULL, `permission` INTEGER NOT NULL, `share_time` TEXT, `share_version` INTEGER NOT NULL, `is_hidden` INTEGER NOT NULL, `need_sync` INTEGER NOT NULL, `size` TEXT, `thumbnail` TEXT, `document_icon_key` TEXT, `document_icon_type` INTEGER NOT NULL, `document_icon_fsunit` TEXT, `app_id` TEXT, `doc_cache_status` INTEGER NOT NULL, `is_offline_create` INTEGER NOT NULL, `wiki_real_type` INTEGER NOT NULL, `wiki_real_token` TEXT, `wiki_version` TEXT, `owner_type` INTEGER NOT NULL, `is_share_folder` INTEGER NOT NULL, `security_name` TEXT, `security_level` INTEGER NOT NULL, `is_secret_key_delete` INTEGER NOT NULL, `template_type` INTEGER NOT NULL, `is_insert` INTEGER NOT NULL, `organization_tag_value` TEXT, `wiki_extra` TEXT, `icon` TEXT, `file_risk_tag` INTEGER NOT NULL, `is_wiki_home_page` INTEGER NOT NULL, PRIMARY KEY(`obj_token`))");
            r2.execSQL("CREATE INDEX IF NOT EXISTS `index_DocMetaInfo_obj_token` ON `DocMetaInfo` (`obj_token`)");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `FilterCache` (`list_type` INTEGER NOT NULL, `filter_type` INTEGER NOT NULL, `file_type` TEXT NOT NULL, `strategy` INTEGER NOT NULL, `is_asc` INTEGER NOT NULL, `obj_token` TEXT NOT NULL, `file_path` TEXT NOT NULL, `token` TEXT, `extra` TEXT, `space_id` TEXT, `add_time_manualoffline` TEXT, `is_need_wifi_download` INTEGER NOT NULL, `open_time_recent` TEXT, `my_edit_time_recent` TEXT, `activity_time_recent` TEXT, `has_perm_folder` INTEGER NOT NULL, `show_external_hint_folder` INTEGER NOT NULL, `node_type_folder` INTEGER NOT NULL, `shortcut_name_folder` TEXT, `shortcut_owner_cn_name` TEXT, `shortcut_owner_en_name` TEXT, `shortcut_obj_biz_type` INTEGER NOT NULL, `shortcut_obj_node_token` TEXT, `is_hidden_share` INTEGER NOT NULL, `share_time_share` TEXT, `sharer_en_name` TEXT, `sharer_cn_name` TEXT, `star_time_star` TEXT, `shortcut_thumbnail_url` TEXT, `shortcut_thumbnail_secret` TEXT, `shortcut_thumbnail_nonce` TEXT, `shortcut_thumbnail_type` INTEGER NOT NULL, `shortcut_thumbnail` TEXT, `id` INTEGER NOT NULL, `icon` TEXT, PRIMARY KEY(`list_type`, `filter_type`, `file_type`, `strategy`, `is_asc`, `obj_token`, `file_path`))");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `CacheStatus` (`obj_token` TEXT NOT NULL, `doc_cache_status` INTEGER NOT NULL, `status_manualoffline` INTEGER NOT NULL, `obj_type` INTEGER NOT NULL, `download_type` INTEGER NOT NULL, PRIMARY KEY(`obj_token`))");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `TtsPlaybackBean` (`obj_token` TEXT NOT NULL, `obj_type` INTEGER NOT NULL, `title` TEXT, `owner_name` TEXT, `icon_info` TEXT, `create_time_ms` INTEGER NOT NULL, `update_time_ms` INTEGER NOT NULL, `last_play_time_ms` INTEGER NOT NULL, `duration_ms` INTEGER NOT NULL, `progress_ms` INTEGER NOT NULL, `speed` REAL NOT NULL, `tone_id` TEXT, `tone_name` TEXT, PRIMARY KEY(`obj_token`))");
            r2.execSQL("CREATE INDEX IF NOT EXISTS `index_TtsPlaybackBean_obj_token` ON `TtsPlaybackBean` (`obj_token`)");
            r2.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            r2.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '2750f15aa498ac3f9503ac5104360096')");
        }

        public final void dropAllTables(SupportSQLiteDatabase r4) {
            r4.execSQL("DROP TABLE IF EXISTS `FolderSortStrategy`");
            r4.execSQL("DROP TABLE IF EXISTS `WikiSpace`");
            r4.execSQL("DROP TABLE IF EXISTS `ListTypes`");
            r4.execSQL("DROP TABLE IF EXISTS `DocMetaInfo`");
            r4.execSQL("DROP TABLE IF EXISTS `FilterCache`");
            r4.execSQL("DROP TABLE IF EXISTS `CacheStatus`");
            r4.execSQL("DROP TABLE IF EXISTS `TtsPlaybackBean`");
            if (BearDatabase_Impl.f(this.a) == null) goto L7;
            int r0 = BearDatabase_Impl.g(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(BearDatabase_Impl.i(this.a), r1)).onDestructiveMigration(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onCreate(SupportSQLiteDatabase r4) {
            if (BearDatabase_Impl.j(this.a) == null) goto L7;
            int r0 = BearDatabase_Impl.k(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(BearDatabase_Impl.l(this.a), r1)).onCreate(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onOpen(SupportSQLiteDatabase r4) {
            BearDatabase_Impl.m(this.a, r4);
            r4.execSQL("PRAGMA foreign_keys = ON");
            this.a.internalInitInvalidationTracker(r4);
            if (BearDatabase_Impl.n(this.a) == null) goto L7;
            int r0 = BearDatabase_Impl.o(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(BearDatabase_Impl.h(this.a), r1)).onOpen(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onPreMigrate(SupportSQLiteDatabase r1) {
            DBUtil.dropFtsSyncTriggers(r1);
        }

        public final RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase r44) {
            HashMap r1 = new HashMap(8);
            r1.put(ResourceData.KEY_OBJ_TOKEN, new TableInfo.Column(ResourceData.KEY_OBJ_TOKEN, CardAdapter.TEXT, true, 1, null, 1));
            r1.put(ResourceData.KEY_TYPE, new TableInfo.Column(ResourceData.KEY_TYPE, "INTEGER", true, 0, null, 1));
            r1.put("file_type", new TableInfo.Column("file_type", CardAdapter.TEXT, false, 0, null, 1));
            r1.put("forbidden_file_type", new TableInfo.Column("forbidden_file_type", CardAdapter.TEXT, false, 0, null, 1));
            r1.put("strategy", new TableInfo.Column("strategy", "INTEGER", true, 0, null, 1));
            r1.put("is_asc", new TableInfo.Column("is_asc", "INTEGER", true, 0, null, 1));
            r1.put("update_time", new TableInfo.Column("update_time", CardAdapter.TEXT, false, 0, null, 1));
            r1.put("user_id", new TableInfo.Column("user_id", CardAdapter.TEXT, false, 0, null, 1));
            TableInfo r11 = new TableInfo("FolderSortStrategy", r1, new HashSet(0), new HashSet(0));
            TableInfo r2 = TableInfo.read(r44, "FolderSortStrategy");
            if (r11.equals(r2) == false) goto L5;
            HashMap r3 = new HashMap(21);
            r3.put("space_id", new TableInfo.Column("space_id", CardAdapter.TEXT, true, 1, null, 1));
            r3.put("user_id", new TableInfo.Column("user_id", CardAdapter.TEXT, false, 0, null, 1));
            r3.put("space_name", new TableInfo.Column("space_name", CardAdapter.TEXT, false, 0, null, 1));
            r3.put("space_icon", new TableInfo.Column("space_icon", CardAdapter.TEXT, false, 0, null, 1));
            r3.put("attr", new TableInfo.Column("attr", "INTEGER", true, 0, null, 1));
            r3.put("description", new TableInfo.Column("description", CardAdapter.TEXT, false, 0, null, 1));
            r3.put("is_star", new TableInfo.Column("is_star", "INTEGER", true, 0, null, 1));
            r3.put("browse_time", new TableInfo.Column("browse_time", CardAdapter.TEXT, false, 0, null, 1));
            r3.put("wiki_token", new TableInfo.Column("wiki_token", CardAdapter.TEXT, false, 0, null, 1));
            r3.put("obj_type", new TableInfo.Column("obj_type", "INTEGER", true, 0, null, 1));
            r3.put(ResourceData.KEY_OBJ_TOKEN, new TableInfo.Column(ResourceData.KEY_OBJ_TOKEN, CardAdapter.TEXT, false, 0, null, 1));
            r3.put("origin", new TableInfo.Column("origin", CardAdapter.TEXT, false, 0, null, 1));
            r3.put("thumbnail", new TableInfo.Column("thumbnail", CardAdapter.TEXT, false, 0, null, 1));
            r3.put("cover_key", new TableInfo.Column("cover_key", CardAdapter.TEXT, false, 0, null, 1));
            r3.put("is_graph_dark", new TableInfo.Column("is_graph_dark", "INTEGER", true, 0, null, 1));
            r3.put("color_value", new TableInfo.Column("color_value", CardAdapter.TEXT, false, 0, null, 1));
            r3.put("wiki_scope", new TableInfo.Column("wiki_scope", "INTEGER", true, 0, null, 1));
            r3.put("space_type", new TableInfo.Column("space_type", "INTEGER", true, 0, null, 1));
            r3.put("open_sharing", new TableInfo.Column("open_sharing", "INTEGER", true, 0, null, 1));
            r3.put("tag_type", new TableInfo.Column("tag_type", "INTEGER", true, 0, null, 1));
            r3.put("tag_value", new TableInfo.Column("tag_value", CardAdapter.TEXT, false, 0, null, 1));
            TableInfo r14 = new TableInfo("WikiSpace", r3, new HashSet(0), new HashSet(0));
            TableInfo r4 = TableInfo.read(r44, "WikiSpace");
            if (r14.equals(r4) == false) goto L9;
            HashMap r5 = new HashMap(31);
            r5.put(ResourceData.KEY_OBJ_TOKEN, new TableInfo.Column(ResourceData.KEY_OBJ_TOKEN, CardAdapter.TEXT, true, 1, null, 1));
            r5.put("list_type", new TableInfo.Column("list_type", "INTEGER", true, 2, null, 1));
            r5.put(ResourceData.KEY_TOKEN, new TableInfo.Column(ResourceData.KEY_TOKEN, CardAdapter.TEXT, true, 3, null, 1));
            r5.put("extra", new TableInfo.Column("extra", CardAdapter.TEXT, false, 0, null, 1));
            r5.put("space_id", new TableInfo.Column("space_id", CardAdapter.TEXT, false, 0, null, 1));
            r5.put("file_path", new TableInfo.Column("file_path", CardAdapter.TEXT, true, 0, null, 1));
            r5.put("add_time_manualoffline", new TableInfo.Column("add_time_manualoffline", CardAdapter.TEXT, false, 0, null, 1));
            r5.put("is_need_wifi_download", new TableInfo.Column("is_need_wifi_download", "INTEGER", true, 0, null, 1));
            r5.put("open_time_recent", new TableInfo.Column("open_time_recent", CardAdapter.TEXT, false, 0, null, 1));
            r5.put("my_edit_time_recent", new TableInfo.Column("my_edit_time_recent", CardAdapter.TEXT, false, 0, null, 1));
            r5.put("activity_time_recent", new TableInfo.Column("activity_time_recent", CardAdapter.TEXT, false, 0, null, 1));
            r5.put("has_perm_folder", new TableInfo.Column("has_perm_folder", "INTEGER", true, 0, null, 1));
            r5.put("show_external_hint_folder", new TableInfo.Column("show_external_hint_folder", "INTEGER", true, 0, null, 1));
            r5.put("node_type_folder", new TableInfo.Column("node_type_folder", "INTEGER", true, 0, null, 1));
            r5.put("shortcut_name_folder", new TableInfo.Column("shortcut_name_folder", CardAdapter.TEXT, false, 0, null, 1));
            r5.put("shortcut_owner_cn_name", new TableInfo.Column("shortcut_owner_cn_name", CardAdapter.TEXT, false, 0, null, 1));
            r5.put("shortcut_owner_en_name", new TableInfo.Column("shortcut_owner_en_name", CardAdapter.TEXT, false, 0, null, 1));
            r5.put("shortcut_obj_biz_type", new TableInfo.Column("shortcut_obj_biz_type", "INTEGER", true, 0, null, 1));
            r5.put("shortcut_obj_node_token", new TableInfo.Column("shortcut_obj_node_token", CardAdapter.TEXT, false, 0, null, 1));
            r5.put("shortcut_obj_delete_flag", new TableInfo.Column("shortcut_obj_delete_flag", "INTEGER", true, 0, null, 1));
            r5.put("is_hidden_share", new TableInfo.Column("is_hidden_share", "INTEGER", true, 0, null, 1));
            r5.put("share_time_share", new TableInfo.Column("share_time_share", CardAdapter.TEXT, false, 0, null, 1));
            r5.put("sharer_en_name", new TableInfo.Column("sharer_en_name", CardAdapter.TEXT, false, 0, null, 1));
            r5.put("sharer_cn_name", new TableInfo.Column("sharer_cn_name", CardAdapter.TEXT, false, 0, null, 1));
            r5.put("star_time_star", new TableInfo.Column("star_time_star", CardAdapter.TEXT, false, 0, null, 1));
            r5.put("shortcut_thumbnail_url", new TableInfo.Column("shortcut_thumbnail_url", CardAdapter.TEXT, false, 0, null, 1));
            r5.put("shortcut_thumbnail_secret", new TableInfo.Column("shortcut_thumbnail_secret", CardAdapter.TEXT, false, 0, null, 1));
            r5.put("shortcut_thumbnail_nonce", new TableInfo.Column("shortcut_thumbnail_nonce", CardAdapter.TEXT, false, 0, null, 1));
            r5.put("shortcut_thumbnail_type", new TableInfo.Column("shortcut_thumbnail_type", "INTEGER", true, 0, null, 1));
            r5.put("shortcut_thumbnail", new TableInfo.Column("shortcut_thumbnail", CardAdapter.TEXT, false, 0, null, 1));
            r5.put("subordinate_id", new TableInfo.Column("subordinate_id", CardAdapter.TEXT, false, 0, null, 1));
            HashSet r6 = new HashSet(1);
            r6.add(new TableInfo.ForeignKey("DocMetaInfo", "NO ACTION", "CASCADE", Arrays.asList(new String[]{ResourceData.KEY_OBJ_TOKEN}), Arrays.asList(new String[]{ResourceData.KEY_OBJ_TOKEN})));
            HashSet r8 = new HashSet(1);
            r8.add(new TableInfo.Index("index_ListTypes_obj_token_list_type", false, Arrays.asList(new String[]{ResourceData.KEY_OBJ_TOKEN, "list_type"})));
            TableInfo r9 = new TableInfo("ListTypes", r5, r6, r8);
            TableInfo r7 = TableInfo.read(r44, "ListTypes");
            if (r9.equals(r7) == false) goto L13;
            HashMap r10 = new HashMap(57);
            r10.put(ResourceData.KEY_OBJ_TOKEN, new TableInfo.Column(ResourceData.KEY_OBJ_TOKEN, CardAdapter.TEXT, true, 1, null, 1));
            r10.put("name", new TableInfo.Column("name", CardAdapter.TEXT, false, 0, null, 1));
            r10.put(ResourceData.KEY_TYPE, new TableInfo.Column(ResourceData.KEY_TYPE, CardAdapter.TEXT, false, 0, null, 1));
            r10.put("owner_id", new TableInfo.Column("owner_id", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("create_tenant_id", new TableInfo.Column("create_tenant_id", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("creator_cn_name", new TableInfo.Column("creator_cn_name", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("creator_en_name", new TableInfo.Column("creator_en_name", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("edit_uid", new TableInfo.Column("edit_uid", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("edit_time", new TableInfo.Column("edit_time", CardAdapter.TEXT, false, 0, null, 1));
            r10.put(ResourceData.KEY_URL, new TableInfo.Column(ResourceData.KEY_URL, CardAdapter.TEXT, false, 0, null, 1));
            r10.put("fake_token", new TableInfo.Column("fake_token", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("is_stared", new TableInfo.Column("is_stared", "INTEGER", true, 0, null, 1));
            r10.put("is_pined", new TableInfo.Column("is_pined", "INTEGER", true, 0, null, 1));
            r10.put("is_subscribed", new TableInfo.Column("is_subscribed", "INTEGER", true, 0, null, 1));
            r10.put("extra_icon_url", new TableInfo.Column("extra_icon_url", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("extra_icon_key", new TableInfo.Column("extra_icon_key", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("extra_icon_nonce", new TableInfo.Column("extra_icon_nonce", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("extra_icon_encrypted_type", new TableInfo.Column("extra_icon_encrypted_type", "INTEGER", true, 0, null, 1));
            r10.put("extra_copiable", new TableInfo.Column("extra_copiable", "INTEGER", true, 0, null, 1));
            r10.put("extra_is_share_root", new TableInfo.Column("extra_is_share_root", "INTEGER", true, 0, null, 1));
            r10.put("extra_is_external", new TableInfo.Column("extra_is_external", "INTEGER", true, 0, null, 1));
            r10.put("extra_sub_type", new TableInfo.Column("extra_sub_type", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("obj_sub_type", new TableInfo.Column("obj_sub_type", "INTEGER", true, 0, null, 1));
            r10.put("is_visited", new TableInfo.Column("is_visited", "INTEGER", true, 0, null, 1));
            r10.put("create_time", new TableInfo.Column("create_time", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("thumbnail_url", new TableInfo.Column("thumbnail_url", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("thumbnail_secret", new TableInfo.Column("thumbnail_secret", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("thumbnail_nonce", new TableInfo.Column("thumbnail_nonce", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("thumbnail_type", new TableInfo.Column("thumbnail_type", "INTEGER", true, 0, null, 1));
            r10.put("permission", new TableInfo.Column("permission", "INTEGER", true, 0, null, 1));
            r10.put("share_time", new TableInfo.Column("share_time", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("share_version", new TableInfo.Column("share_version", "INTEGER", true, 0, null, 1));
            r10.put("is_hidden", new TableInfo.Column("is_hidden", "INTEGER", true, 0, null, 1));
            r10.put("need_sync", new TableInfo.Column("need_sync", "INTEGER", true, 0, null, 1));
            r10.put("size", new TableInfo.Column("size", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("thumbnail", new TableInfo.Column("thumbnail", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("document_icon_key", new TableInfo.Column("document_icon_key", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("document_icon_type", new TableInfo.Column("document_icon_type", "INTEGER", true, 0, null, 1));
            r10.put("document_icon_fsunit", new TableInfo.Column("document_icon_fsunit", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("app_id", new TableInfo.Column("app_id", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("doc_cache_status", new TableInfo.Column("doc_cache_status", "INTEGER", true, 0, null, 1));
            r10.put("is_offline_create", new TableInfo.Column("is_offline_create", "INTEGER", true, 0, null, 1));
            r10.put("wiki_real_type", new TableInfo.Column("wiki_real_type", "INTEGER", true, 0, null, 1));
            r10.put("wiki_real_token", new TableInfo.Column("wiki_real_token", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("wiki_version", new TableInfo.Column("wiki_version", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("owner_type", new TableInfo.Column("owner_type", "INTEGER", true, 0, null, 1));
            r10.put("is_share_folder", new TableInfo.Column("is_share_folder", "INTEGER", true, 0, null, 1));
            r10.put("security_name", new TableInfo.Column("security_name", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("security_level", new TableInfo.Column("security_level", "INTEGER", true, 0, null, 1));
            r10.put("is_secret_key_delete", new TableInfo.Column("is_secret_key_delete", "INTEGER", true, 0, null, 1));
            r10.put("template_type", new TableInfo.Column("template_type", "INTEGER", true, 0, null, 1));
            r10.put("is_insert", new TableInfo.Column("is_insert", "INTEGER", true, 0, null, 1));
            r10.put("organization_tag_value", new TableInfo.Column("organization_tag_value", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("wiki_extra", new TableInfo.Column("wiki_extra", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("icon", new TableInfo.Column("icon", CardAdapter.TEXT, false, 0, null, 1));
            r10.put("file_risk_tag", new TableInfo.Column("file_risk_tag", "INTEGER", true, 0, null, 1));
            r10.put("is_wiki_home_page", new TableInfo.Column("is_wiki_home_page", "INTEGER", true, 0, null, 1));
            HashSet r12 = new HashSet(0);
            HashSet r13 = new HashSet(1);
            r13.add(new TableInfo.Index("index_DocMetaInfo_obj_token", false, Arrays.asList(new String[]{ResourceData.KEY_OBJ_TOKEN})));
            TableInfo r15 = new TableInfo("DocMetaInfo", r10, r12, r13);
            TableInfo r16 = TableInfo.read(r44, "DocMetaInfo");
            if (r15.equals(r16) == false) goto L17;
            HashMap r17 = new HashMap(35);
            r17.put("list_type", new TableInfo.Column("list_type", "INTEGER", true, 1, null, 1));
            r17.put("filter_type", new TableInfo.Column("filter_type", "INTEGER", true, 2, null, 1));
            r17.put("file_type", new TableInfo.Column("file_type", CardAdapter.TEXT, true, 3, null, 1));
            r17.put("strategy", new TableInfo.Column("strategy", "INTEGER", true, 4, null, 1));
            r17.put("is_asc", new TableInfo.Column("is_asc", "INTEGER", true, 5, null, 1));
            r17.put(ResourceData.KEY_OBJ_TOKEN, new TableInfo.Column(ResourceData.KEY_OBJ_TOKEN, CardAdapter.TEXT, true, 6, null, 1));
            r17.put("file_path", new TableInfo.Column("file_path", CardAdapter.TEXT, true, 7, null, 1));
            r17.put(ResourceData.KEY_TOKEN, new TableInfo.Column(ResourceData.KEY_TOKEN, CardAdapter.TEXT, false, 0, null, 1));
            r17.put("extra", new TableInfo.Column("extra", CardAdapter.TEXT, false, 0, null, 1));
            r17.put("space_id", new TableInfo.Column("space_id", CardAdapter.TEXT, false, 0, null, 1));
            r17.put("add_time_manualoffline", new TableInfo.Column("add_time_manualoffline", CardAdapter.TEXT, false, 0, null, 1));
            r17.put("is_need_wifi_download", new TableInfo.Column("is_need_wifi_download", "INTEGER", true, 0, null, 1));
            r17.put("open_time_recent", new TableInfo.Column("open_time_recent", CardAdapter.TEXT, false, 0, null, 1));
            r17.put("my_edit_time_recent", new TableInfo.Column("my_edit_time_recent", CardAdapter.TEXT, false, 0, null, 1));
            r17.put("activity_time_recent", new TableInfo.Column("activity_time_recent", CardAdapter.TEXT, false, 0, null, 1));
            r17.put("has_perm_folder", new TableInfo.Column("has_perm_folder", "INTEGER", true, 0, null, 1));
            r17.put("show_external_hint_folder", new TableInfo.Column("show_external_hint_folder", "INTEGER", true, 0, null, 1));
            r17.put("node_type_folder", new TableInfo.Column("node_type_folder", "INTEGER", true, 0, null, 1));
            r17.put("shortcut_name_folder", new TableInfo.Column("shortcut_name_folder", CardAdapter.TEXT, false, 0, null, 1));
            r17.put("shortcut_owner_cn_name", new TableInfo.Column("shortcut_owner_cn_name", CardAdapter.TEXT, false, 0, null, 1));
            r17.put("shortcut_owner_en_name", new TableInfo.Column("shortcut_owner_en_name", CardAdapter.TEXT, false, 0, null, 1));
            r17.put("shortcut_obj_biz_type", new TableInfo.Column("shortcut_obj_biz_type", "INTEGER", true, 0, null, 1));
            r17.put("shortcut_obj_node_token", new TableInfo.Column("shortcut_obj_node_token", CardAdapter.TEXT, false, 0, null, 1));
            r17.put("is_hidden_share", new TableInfo.Column("is_hidden_share", "INTEGER", true, 0, null, 1));
            r17.put("share_time_share", new TableInfo.Column("share_time_share", CardAdapter.TEXT, false, 0, null, 1));
            r17.put("sharer_en_name", new TableInfo.Column("sharer_en_name", CardAdapter.TEXT, false, 0, null, 1));
            r17.put("sharer_cn_name", new TableInfo.Column("sharer_cn_name", CardAdapter.TEXT, false, 0, null, 1));
            r17.put("star_time_star", new TableInfo.Column("star_time_star", CardAdapter.TEXT, false, 0, null, 1));
            r17.put("shortcut_thumbnail_url", new TableInfo.Column("shortcut_thumbnail_url", CardAdapter.TEXT, false, 0, null, 1));
            r17.put("shortcut_thumbnail_secret", new TableInfo.Column("shortcut_thumbnail_secret", CardAdapter.TEXT, false, 0, null, 1));
            r17.put("shortcut_thumbnail_nonce", new TableInfo.Column("shortcut_thumbnail_nonce", CardAdapter.TEXT, false, 0, null, 1));
            r17.put("shortcut_thumbnail_type", new TableInfo.Column("shortcut_thumbnail_type", "INTEGER", true, 0, null, 1));
            r17.put("shortcut_thumbnail", new TableInfo.Column("shortcut_thumbnail", CardAdapter.TEXT, false, 0, null, 1));
            r17.put(ResourceData.KEY_ID, new TableInfo.Column(ResourceData.KEY_ID, "INTEGER", true, 0, null, 1));
            r17.put("icon", new TableInfo.Column("icon", CardAdapter.TEXT, false, 0, null, 1));
            TableInfo r18 = new TableInfo("FilterCache", r17, new HashSet(0), new HashSet(0));
            TableInfo r19 = TableInfo.read(r44, "FilterCache");
            if (r18.equals(r19) == false) goto L21;
            HashMap r20 = new HashMap(5);
            r20.put(ResourceData.KEY_OBJ_TOKEN, new TableInfo.Column(ResourceData.KEY_OBJ_TOKEN, CardAdapter.TEXT, true, 1, null, 1));
            r20.put("doc_cache_status", new TableInfo.Column("doc_cache_status", "INTEGER", true, 0, null, 1));
            r20.put("status_manualoffline", new TableInfo.Column("status_manualoffline", "INTEGER", true, 0, null, 1));
            r20.put("obj_type", new TableInfo.Column("obj_type", "INTEGER", true, 0, null, 1));
            r20.put("download_type", new TableInfo.Column("download_type", "INTEGER", true, 0, null, 1));
            TableInfo r21 = new TableInfo("CacheStatus", r20, new HashSet(0), new HashSet(0));
            TableInfo r22 = TableInfo.read(r44, "CacheStatus");
            if (r21.equals(r22) == false) goto L25;
            HashMap r23 = new HashMap(13);
            r23.put(ResourceData.KEY_OBJ_TOKEN, new TableInfo.Column(ResourceData.KEY_OBJ_TOKEN, CardAdapter.TEXT, true, 1, null, 1));
            r23.put("obj_type", new TableInfo.Column("obj_type", "INTEGER", true, 0, null, 1));
            r23.put("title", new TableInfo.Column("title", CardAdapter.TEXT, false, 0, null, 1));
            r23.put("owner_name", new TableInfo.Column("owner_name", CardAdapter.TEXT, false, 0, null, 1));
            r23.put("icon_info", new TableInfo.Column("icon_info", CardAdapter.TEXT, false, 0, null, 1));
            r23.put("create_time_ms", new TableInfo.Column("create_time_ms", "INTEGER", true, 0, null, 1));
            r23.put("update_time_ms", new TableInfo.Column("update_time_ms", "INTEGER", true, 0, null, 1));
            r23.put("last_play_time_ms", new TableInfo.Column("last_play_time_ms", "INTEGER", true, 0, null, 1));
            r23.put("duration_ms", new TableInfo.Column("duration_ms", "INTEGER", true, 0, null, 1));
            r23.put("progress_ms", new TableInfo.Column("progress_ms", "INTEGER", true, 0, null, 1));
            r23.put("speed", new TableInfo.Column("speed", "REAL", true, 0, null, 1));
            r23.put("tone_id", new TableInfo.Column("tone_id", CardAdapter.TEXT, false, 0, null, 1));
            r23.put("tone_name", new TableInfo.Column("tone_name", CardAdapter.TEXT, false, 0, null, 1));
            HashSet r24 = new HashSet(0);
            HashSet r25 = new HashSet(1);
            r25.add(new TableInfo.Index("index_TtsPlaybackBean_obj_token", false, Arrays.asList(new String[]{ResourceData.KEY_OBJ_TOKEN})));
            TableInfo r26 = new TableInfo("TtsPlaybackBean", r23, r24, r25);
            TableInfo r0 = TableInfo.read(r44, "TtsPlaybackBean");
            if (r26.equals(r0) == true) goto L31;
            return new RoomOpenHelper.ValidationResult(false, "TtsPlaybackBean(com.bytedance.ee.bear.tts.playback.TtsPlaybackBean).\n Expected:\n" + r26 + "\n Found:\n" + r0);
        L31:
            return new RoomOpenHelper.ValidationResult(true, null);
        L25:
            return new RoomOpenHelper.ValidationResult(false, "CacheStatus(com.bytedance.ee.bear.list.cache.CacheStatus).\n Expected:\n" + r21 + "\n Found:\n" + r22);
        L21:
            return new RoomOpenHelper.ValidationResult(false, "FilterCache(com.bytedance.ee.bear.list.cache.FilterCache).\n Expected:\n" + r18 + "\n Found:\n" + r19);
        L17:
            return new RoomOpenHelper.ValidationResult(false, "DocMetaInfo(com.bytedance.ee.bear.list.cache.DocMetaInfo).\n Expected:\n" + r15 + "\n Found:\n" + r16);
        L13:
            return new RoomOpenHelper.ValidationResult(false, "ListTypes(com.bytedance.ee.bear.list.cache.ListType).\n Expected:\n" + r9 + "\n Found:\n" + r7);
        L9:
            return new RoomOpenHelper.ValidationResult(false, "WikiSpace(com.bytedance.ee.bear.list.cache.WikiSpace).\n Expected:\n" + r14 + "\n Found:\n" + r4);
        L5:
            return new RoomOpenHelper.ValidationResult(false, "FolderSortStrategy(com.bytedance.ee.bear.list.cache.FolderSortStrategy).\n Expected:\n" + r11 + "\n Found:\n" + r2);
        }
    }

    @Override // com.bytedance.ee.bear.list.cache.BearDatabase
    public final n c() {
        if (this.c != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.c != null) goto L10;
        this.c = new d1(this);     // Catch: Throwable -> L13
    L10:
        d1 r0 = this.c;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.c;
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r2 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r2.execSQL("PRAGMA defer_foreign_keys = TRUE");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `FolderSortStrategy`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `WikiSpace`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `ListTypes`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `DocMetaInfo`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `FilterCache`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `CacheStatus`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `TtsPlaybackBean`");     // Catch: Throwable -> L8
        super.setTransactionSuccessful();     // Catch: Throwable -> L8
        super.endTransaction();
        r2.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r2.inTransaction() == true) goto L15;
        r2.execSQL("VACUUM");
        return;
    L15:
        return;
    L8:
        th = move-exception;
        super.endTransaction();
        r2.query("PRAGMA wal_checkpoint(FULL)").close();
        if (r2.inTransaction() == true) goto L12;
        r2.execSQL("VACUUM");
    L12:
        throw th;
    }

    public final InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"FolderSortStrategy", "WikiSpace", "ListTypes", "DocMetaInfo", "FilterCache", "CacheStatus", "TtsPlaybackBean"});
    }

    @Override // com.bytedance.ee.bear.list.cache.BearDatabase
    public final e d() {
        if (this.a != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.a != null) goto L10;
        this.a = new i(this);     // Catch: Throwable -> L13
    L10:
        i r0 = this.a;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.a;
    }

    @Override // com.bytedance.ee.bear.list.cache.BearDatabase
    public final c3 e() {
        if (this.b != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.b != null) goto L10;
        this.b = new j3(this);     // Catch: Throwable -> L13
    L10:
        j3 r0 = this.b;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.b;
    }

    public BearDatabase_Impl() {
    }

    public static /* synthetic */ List f(BearDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List g(BearDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List h(BearDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List i(BearDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List j(BearDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List k(BearDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List l(BearDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List n(BearDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List o(BearDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r5) {
        RoomOpenHelper r0 = new RoomOpenHelper(r5, new a(this), "2750f15aa498ac3f9503ac5104360096", "d91ea83b1da730bc87c3ac9b0f43aa1f");
        SupportSQLiteOpenHelper.Configuration r1 = SupportSQLiteOpenHelper.Configuration.builder(r5.context).name(r5.name).callback(r0).build();
        return r5.sqliteOpenHelperFactory.create(r1);
    }

    public static /* synthetic */ void m(BearDatabase_Impl r0, SupportSQLiteDatabase r1) {
        ((RoomDatabase) r0).mDatabase = r1;
    }
}
