package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db;

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
import yq5.b0;
import yq5.f;
import yq5.j0;
import yq5.q;
import yq5.t;
import yq5.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class WikiDatabase_Impl extends WikiDatabase {
    public volatile q a;
    public volatile y b;
    public volatile j0 c;

    public class a extends RoomOpenHelper.Delegate {
        public final /* synthetic */ WikiDatabase_Impl a;

        public final void onPostMigrate(SupportSQLiteDatabase r1) {
        }

        public a(WikiDatabase_Impl r1) {
            this.a = r1;
            super(17);
        }

        public final void createAllTables(SupportSQLiteDatabase r2) {
            r2.execSQL("CREATE TABLE IF NOT EXISTS `t_wiki_relation` (`wiki_token` TEXT NOT NULL, `space_id` TEXT NOT NULL, `obj_token` TEXT, `obj_type` INTEGER NOT NULL, `title` TEXT, `parent_wiki_token` TEXT, `sort_id` REAL NOT NULL, `wiki_node_type` INTEGER NOT NULL, `origin_wiki_token` TEXT, `origin_space_id` TEXT, `is_star` INTEGER NOT NULL, `children` TEXT, `space_name` TEXT, `has_child` INTEGER NOT NULL, `secret_key_delete` INTEGER NOT NULL, `is_explorer_star` INTEGER NOT NULL, `origin_is_external` INTEGER NOT NULL, `entity_delete_flag` INTEGER NOT NULL, `document_entity` TEXT, `detail_info` TEXT, `icon_entity` TEXT, PRIMARY KEY(`wiki_token`, `space_id`))");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `t_wiki_route_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `wiki_token` TEXT, `obj_token` TEXT, `obj_type` INTEGER NOT NULL, `in_space` INTEGER NOT NULL, `access_time` INTEGER NOT NULL, `log_id` TEXT)");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `t_wiki_relation_info` (`space_id` TEXT NOT NULL, `space_name` TEXT, `space_icon` TEXT, `tenant_id` TEXT, `description` TEXT, `is_star` INTEGER NOT NULL, `space_type` INTEGER NOT NULL, `wiki_scope` INTEGER NOT NULL, `open_sharing` INTEGER NOT NULL, `owner_perm_type` INTEGER NOT NULL, `create_uid` TEXT, `cover_origin` TEXT, `cover_thumbnail` TEXT, `cover_key` TEXT, `cover_is_graph_dark` INTEGER NOT NULL, `cover_color_value` TEXT, `view_wiki_collaborator` INTEGER NOT NULL, `view_wiki_info` INTEGER NOT NULL, `star_wiki` INTEGER NOT NULL, `view_wiki_general_info` INTEGER NOT NULL, `can_edit_first_level` INTEGER NOT NULL, `wiki_homepage_obj_token` TEXT, `wiki_homepage_obj_type` INTEGER NOT NULL, `wiki_homepage_wiki_token` TEXT, `wiki_homepage_url` TEXT, `wiki_homepage_title` TEXT, PRIMARY KEY(`space_id`))");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `t_wiki_space_list_ref` (`space_id` TEXT NOT NULL, `space_list_type` INTEGER NOT NULL, `space_type_id` TEXT NOT NULL, `space_class_id` TEXT NOT NULL, PRIMARY KEY(`space_id`, `space_list_type`, `space_type_id`, `space_class_id`), FOREIGN KEY(`space_id`) REFERENCES `t_wiki_space`(`space_id`) ON UPDATE CASCADE ON DELETE NO ACTION )");
            r2.execSQL("CREATE TABLE IF NOT EXISTS `t_wiki_space` (`space_id` TEXT NOT NULL, `space_name` TEXT, `description` TEXT, `space_icon` TEXT, `tenant_id` TEXT, `cover_origin` TEXT, `cover_thumbnail` TEXT, `cover_key` TEXT, `cover_is_graph_dark` INTEGER NOT NULL, `cover_color_value` TEXT, `root_token` TEXT, `space_type` INTEGER NOT NULL, `wiki_scope` INTEGER NOT NULL, `is_star` INTEGER NOT NULL, `browse_time` TEXT, `owner_perm_type` INTEGER NOT NULL, `open_sharing` INTEGER NOT NULL, `tag_type` INTEGER NOT NULL, `tag_value` TEXT, `icon_info` TEXT, PRIMARY KEY(`space_id`))");
            r2.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            r2.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, 'b7f46a25ce909a6290102ab6f196696d')");
        }

        public final void dropAllTables(SupportSQLiteDatabase r4) {
            r4.execSQL("DROP TABLE IF EXISTS `t_wiki_relation`");
            r4.execSQL("DROP TABLE IF EXISTS `t_wiki_route_table`");
            r4.execSQL("DROP TABLE IF EXISTS `t_wiki_relation_info`");
            r4.execSQL("DROP TABLE IF EXISTS `t_wiki_space_list_ref`");
            r4.execSQL("DROP TABLE IF EXISTS `t_wiki_space`");
            if (WikiDatabase_Impl.g(this.a) == null) goto L7;
            int r0 = WikiDatabase_Impl.h(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(WikiDatabase_Impl.j(this.a), r1)).onDestructiveMigration(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onCreate(SupportSQLiteDatabase r4) {
            if (WikiDatabase_Impl.k(this.a) == null) goto L7;
            int r0 = WikiDatabase_Impl.l(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(WikiDatabase_Impl.m(this.a), r1)).onCreate(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onOpen(SupportSQLiteDatabase r4) {
            WikiDatabase_Impl.n(this.a, r4);
            r4.execSQL("PRAGMA foreign_keys = ON");
            this.a.internalInitInvalidationTracker(r4);
            if (WikiDatabase_Impl.o(this.a) == null) goto L7;
            int r0 = WikiDatabase_Impl.p(this.a).size();
            int r1 = 0;
        L5:
            if (r1 >= r0) goto L9;
            ((RoomDatabase.Callback) ListProtector.get(WikiDatabase_Impl.i(this.a), r1)).onOpen(r4);
            r1 = r1 + 1;
            goto L5
        L9:
            return;
        }

        public final void onPreMigrate(SupportSQLiteDatabase r1) {
            DBUtil.dropFtsSyncTriggers(r1);
        }

        public final RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase r38) {
            HashMap r1 = new HashMap(21);
            r1.put("wiki_token", new TableInfo.Column("wiki_token", CardAdapter.TEXT, true, 1, null, 1));
            r1.put("space_id", new TableInfo.Column("space_id", CardAdapter.TEXT, true, 2, null, 1));
            r1.put(ResourceData.KEY_OBJ_TOKEN, new TableInfo.Column(ResourceData.KEY_OBJ_TOKEN, CardAdapter.TEXT, false, 0, null, 1));
            r1.put("obj_type", new TableInfo.Column("obj_type", "INTEGER", true, 0, null, 1));
            r1.put("title", new TableInfo.Column("title", CardAdapter.TEXT, false, 0, null, 1));
            r1.put("parent_wiki_token", new TableInfo.Column("parent_wiki_token", CardAdapter.TEXT, false, 0, null, 1));
            r1.put("sort_id", new TableInfo.Column("sort_id", "REAL", true, 0, null, 1));
            r1.put("wiki_node_type", new TableInfo.Column("wiki_node_type", "INTEGER", true, 0, null, 1));
            r1.put("origin_wiki_token", new TableInfo.Column("origin_wiki_token", CardAdapter.TEXT, false, 0, null, 1));
            r1.put("origin_space_id", new TableInfo.Column("origin_space_id", CardAdapter.TEXT, false, 0, null, 1));
            r1.put("is_star", new TableInfo.Column("is_star", "INTEGER", true, 0, null, 1));
            r1.put("children", new TableInfo.Column("children", CardAdapter.TEXT, false, 0, null, 1));
            r1.put("space_name", new TableInfo.Column("space_name", CardAdapter.TEXT, false, 0, null, 1));
            r1.put("has_child", new TableInfo.Column("has_child", "INTEGER", true, 0, null, 1));
            r1.put("secret_key_delete", new TableInfo.Column("secret_key_delete", "INTEGER", true, 0, null, 1));
            r1.put("is_explorer_star", new TableInfo.Column("is_explorer_star", "INTEGER", true, 0, null, 1));
            r1.put("origin_is_external", new TableInfo.Column("origin_is_external", "INTEGER", true, 0, null, 1));
            r1.put("entity_delete_flag", new TableInfo.Column("entity_delete_flag", "INTEGER", true, 0, null, 1));
            r1.put("document_entity", new TableInfo.Column("document_entity", CardAdapter.TEXT, false, 0, null, 1));
            r1.put("detail_info", new TableInfo.Column("detail_info", CardAdapter.TEXT, false, 0, null, 1));
            r1.put("icon_entity", new TableInfo.Column("icon_entity", CardAdapter.TEXT, false, 0, null, 1));
            TableInfo r11 = new TableInfo("t_wiki_relation", r1, new HashSet(0), new HashSet(0));
            TableInfo r2 = TableInfo.read(r38, "t_wiki_relation");
            if (r11.equals(r2) == false) goto L5;
            HashMap r3 = new HashMap(7);
            r3.put(ResourceData.KEY_ID, new TableInfo.Column(ResourceData.KEY_ID, "INTEGER", true, 1, null, 1));
            r3.put("wiki_token", new TableInfo.Column("wiki_token", CardAdapter.TEXT, false, 0, null, 1));
            r3.put(ResourceData.KEY_OBJ_TOKEN, new TableInfo.Column(ResourceData.KEY_OBJ_TOKEN, CardAdapter.TEXT, false, 0, null, 1));
            r3.put("obj_type", new TableInfo.Column("obj_type", "INTEGER", true, 0, null, 1));
            r3.put("in_space", new TableInfo.Column("in_space", "INTEGER", true, 0, null, 1));
            r3.put(ResourceData.ACCESS_TIME, new TableInfo.Column(ResourceData.ACCESS_TIME, "INTEGER", true, 0, null, 1));
            r3.put("log_id", new TableInfo.Column("log_id", CardAdapter.TEXT, false, 0, null, 1));
            TableInfo r5 = new TableInfo("t_wiki_route_table", r3, new HashSet(0), new HashSet(0));
            TableInfo r4 = TableInfo.read(r38, "t_wiki_route_table");
            if (r5.equals(r4) == false) goto L9;
            HashMap r6 = new HashMap(26);
            r6.put("space_id", new TableInfo.Column("space_id", CardAdapter.TEXT, true, 1, null, 1));
            r6.put("space_name", new TableInfo.Column("space_name", CardAdapter.TEXT, false, 0, null, 1));
            r6.put("space_icon", new TableInfo.Column("space_icon", CardAdapter.TEXT, false, 0, null, 1));
            r6.put("tenant_id", new TableInfo.Column("tenant_id", CardAdapter.TEXT, false, 0, null, 1));
            r6.put("description", new TableInfo.Column("description", CardAdapter.TEXT, false, 0, null, 1));
            r6.put("is_star", new TableInfo.Column("is_star", "INTEGER", true, 0, null, 1));
            r6.put("space_type", new TableInfo.Column("space_type", "INTEGER", true, 0, null, 1));
            r6.put("wiki_scope", new TableInfo.Column("wiki_scope", "INTEGER", true, 0, null, 1));
            r6.put("open_sharing", new TableInfo.Column("open_sharing", "INTEGER", true, 0, null, 1));
            r6.put("owner_perm_type", new TableInfo.Column("owner_perm_type", "INTEGER", true, 0, null, 1));
            r6.put("create_uid", new TableInfo.Column("create_uid", CardAdapter.TEXT, false, 0, null, 1));
            r6.put("cover_origin", new TableInfo.Column("cover_origin", CardAdapter.TEXT, false, 0, null, 1));
            r6.put("cover_thumbnail", new TableInfo.Column("cover_thumbnail", CardAdapter.TEXT, false, 0, null, 1));
            r6.put("cover_key", new TableInfo.Column("cover_key", CardAdapter.TEXT, false, 0, null, 1));
            r6.put("cover_is_graph_dark", new TableInfo.Column("cover_is_graph_dark", "INTEGER", true, 0, null, 1));
            r6.put("cover_color_value", new TableInfo.Column("cover_color_value", CardAdapter.TEXT, false, 0, null, 1));
            r6.put("view_wiki_collaborator", new TableInfo.Column("view_wiki_collaborator", "INTEGER", true, 0, null, 1));
            r6.put("view_wiki_info", new TableInfo.Column("view_wiki_info", "INTEGER", true, 0, null, 1));
            r6.put("star_wiki", new TableInfo.Column("star_wiki", "INTEGER", true, 0, null, 1));
            r6.put("view_wiki_general_info", new TableInfo.Column("view_wiki_general_info", "INTEGER", true, 0, null, 1));
            r6.put("can_edit_first_level", new TableInfo.Column("can_edit_first_level", "INTEGER", true, 0, null, 1));
            r6.put("wiki_homepage_obj_token", new TableInfo.Column("wiki_homepage_obj_token", CardAdapter.TEXT, false, 0, null, 1));
            r6.put("wiki_homepage_obj_type", new TableInfo.Column("wiki_homepage_obj_type", "INTEGER", true, 0, null, 1));
            r6.put("wiki_homepage_wiki_token", new TableInfo.Column("wiki_homepage_wiki_token", CardAdapter.TEXT, false, 0, null, 1));
            r6.put("wiki_homepage_url", new TableInfo.Column("wiki_homepage_url", CardAdapter.TEXT, false, 0, null, 1));
            r6.put("wiki_homepage_title", new TableInfo.Column("wiki_homepage_title", CardAdapter.TEXT, false, 0, null, 1));
            TableInfo r12 = new TableInfo("t_wiki_relation_info", r6, new HashSet(0), new HashSet(0));
            TableInfo r7 = TableInfo.read(r38, "t_wiki_relation_info");
            if (r12.equals(r7) == false) goto L13;
            HashMap r8 = new HashMap(4);
            r8.put("space_id", new TableInfo.Column("space_id", CardAdapter.TEXT, true, 1, null, 1));
            r8.put("space_list_type", new TableInfo.Column("space_list_type", "INTEGER", true, 2, null, 1));
            r8.put("space_type_id", new TableInfo.Column("space_type_id", CardAdapter.TEXT, true, 3, null, 1));
            r8.put("space_class_id", new TableInfo.Column("space_class_id", CardAdapter.TEXT, true, 4, null, 1));
            HashSet r9 = new HashSet(1);
            r9.add(new TableInfo.ForeignKey("t_wiki_space", "NO ACTION", "CASCADE", Arrays.asList(new String[]{"space_id"}), Arrays.asList(new String[]{"space_id"})));
            TableInfo r13 = new TableInfo("t_wiki_space_list_ref", r8, r9, new HashSet(0));
            TableInfo r10 = TableInfo.read(r38, "t_wiki_space_list_ref");
            if (r13.equals(r10) == false) goto L17;
            HashMap r14 = new HashMap(20);
            r14.put("space_id", new TableInfo.Column("space_id", CardAdapter.TEXT, true, 1, null, 1));
            r14.put("space_name", new TableInfo.Column("space_name", CardAdapter.TEXT, false, 0, null, 1));
            r14.put("description", new TableInfo.Column("description", CardAdapter.TEXT, false, 0, null, 1));
            r14.put("space_icon", new TableInfo.Column("space_icon", CardAdapter.TEXT, false, 0, null, 1));
            r14.put("tenant_id", new TableInfo.Column("tenant_id", CardAdapter.TEXT, false, 0, null, 1));
            r14.put("cover_origin", new TableInfo.Column("cover_origin", CardAdapter.TEXT, false, 0, null, 1));
            r14.put("cover_thumbnail", new TableInfo.Column("cover_thumbnail", CardAdapter.TEXT, false, 0, null, 1));
            r14.put("cover_key", new TableInfo.Column("cover_key", CardAdapter.TEXT, false, 0, null, 1));
            r14.put("cover_is_graph_dark", new TableInfo.Column("cover_is_graph_dark", "INTEGER", true, 0, null, 1));
            r14.put("cover_color_value", new TableInfo.Column("cover_color_value", CardAdapter.TEXT, false, 0, null, 1));
            r14.put("root_token", new TableInfo.Column("root_token", CardAdapter.TEXT, false, 0, null, 1));
            r14.put("space_type", new TableInfo.Column("space_type", "INTEGER", true, 0, null, 1));
            r14.put("wiki_scope", new TableInfo.Column("wiki_scope", "INTEGER", true, 0, null, 1));
            r14.put("is_star", new TableInfo.Column("is_star", "INTEGER", true, 0, null, 1));
            r14.put("browse_time", new TableInfo.Column("browse_time", CardAdapter.TEXT, false, 0, null, 1));
            r14.put("owner_perm_type", new TableInfo.Column("owner_perm_type", "INTEGER", true, 0, null, 1));
            r14.put("open_sharing", new TableInfo.Column("open_sharing", "INTEGER", true, 0, null, 1));
            r14.put("tag_type", new TableInfo.Column("tag_type", "INTEGER", true, 0, null, 1));
            r14.put("tag_value", new TableInfo.Column("tag_value", CardAdapter.TEXT, false, 0, null, 1));
            r14.put("icon_info", new TableInfo.Column("icon_info", CardAdapter.TEXT, false, 0, null, 1));
            TableInfo r15 = new TableInfo("t_wiki_space", r14, new HashSet(0), new HashSet(0));
            TableInfo r0 = TableInfo.read(r38, "t_wiki_space");
            if (r15.equals(r0) == true) goto L23;
            return new RoomOpenHelper.ValidationResult(false, "t_wiki_space(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.DBWikiSpace).\n Expected:\n" + r15 + "\n Found:\n" + r0);
        L23:
            return new RoomOpenHelper.ValidationResult(true, null);
        L17:
            return new RoomOpenHelper.ValidationResult(false, "t_wiki_space_list_ref(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.DBWikiSpaceListRef).\n Expected:\n" + r13 + "\n Found:\n" + r10);
        L13:
            return new RoomOpenHelper.ValidationResult(false, "t_wiki_relation_info(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.DBRelationInfo).\n Expected:\n" + r12 + "\n Found:\n" + r7);
        L9:
            return new RoomOpenHelper.ValidationResult(false, "t_wiki_route_table(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiRouteEntry).\n Expected:\n" + r5 + "\n Found:\n" + r4);
        L5:
            return new RoomOpenHelper.ValidationResult(false, "t_wiki_relation(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.DBTreeNode).\n Expected:\n" + r11 + "\n Found:\n" + r2);
        }
    }

    public final void clearAllTables() {
        super.assertNotMainThread();
        SupportSQLiteDatabase r2 = super.getOpenHelper().getWritableDatabase();
        super.beginTransaction();     // Catch: Throwable -> L8
        r2.execSQL("PRAGMA defer_foreign_keys = TRUE");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `t_wiki_relation`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `t_wiki_route_table`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `t_wiki_relation_info`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `t_wiki_space_list_ref`");     // Catch: Throwable -> L8
        r2.execSQL("DELETE FROM `t_wiki_space`");     // Catch: Throwable -> L8
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
        return new InvalidationTracker(this, new HashMap(0), new HashMap(0), new String[]{"t_wiki_relation", "t_wiki_route_table", "t_wiki_relation_info", "t_wiki_space_list_ref", "t_wiki_space"});
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase
    public final f d() {
        if (this.a != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.a != null) goto L10;
        this.a = new q(this);     // Catch: Throwable -> L13
    L10:
        q r0 = this.a;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.a;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase
    public final t e() {
        if (this.b != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.b != null) goto L10;
        this.b = new y(this);     // Catch: Throwable -> L13
    L10:
        y r0 = this.b;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.b;
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase
    public final b0 f() {
        if (this.c != null) goto L5;
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (this.c != null) goto L10;
        this.c = new j0(this);     // Catch: Throwable -> L13
    L10:
        j0 r0 = this.c;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r0;
    L5:
        return this.c;
    }

    public WikiDatabase_Impl() {
    }

    public static /* synthetic */ List g(WikiDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List h(WikiDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List i(WikiDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List j(WikiDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List k(WikiDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List l(WikiDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List m(WikiDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List o(WikiDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public static /* synthetic */ List p(WikiDatabase_Impl r0) {
        return ((RoomDatabase) r0).mCallbacks;
    }

    public final SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration r5) {
        RoomOpenHelper r0 = new RoomOpenHelper(r5, new a(this), "b7f46a25ce909a6290102ab6f196696d", "3c4fb1bd13c03ad6328a6c61fbbb2d8c");
        SupportSQLiteOpenHelper.Configuration r1 = SupportSQLiteOpenHelper.Configuration.builder(r5.context).name(r5.name).callback(r0).build();
        return r5.sqliteOpenHelperFactory.create(r1);
    }

    public static /* synthetic */ void n(WikiDatabase_Impl r0, SupportSQLiteDatabase r1) {
        ((RoomDatabase) r0).mDatabase = r1;
    }
}
