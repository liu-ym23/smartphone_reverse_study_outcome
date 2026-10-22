package yq5;

import android.database.Cursor;
import android.text.TextUtils;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.VirtualNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class q extends f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f568835a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f568836b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i f568837c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j f568838d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final k f568839e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l f568840f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final m f568841g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final n f568842h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final o f568843i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final p f568844j;

    public q(WikiDatabase r100) {
        this.f568835a = r100;
        this.f568836b = new h(r100);
        this.f568837c = new i(r100);
        this.f568838d = new j(r100);
        this.f568839e = new k(r100);
        this.f568840f = new l(r100);
        this.f568841g = new m(r100);
        this.f568842h = new n(r100);
        this.f568843i = new o(r100);
        this.f568844j = new p(r100);
    }

    @Override // yq5.f
    public final void a(c r100) {
        this.f568835a.beginTransaction();
    L11:
        th = move-exception;
        this.f568835a.endTransaction();
        throw th;
    L4:
        if (hu5.a.d(r100.f568800b) == true) goto L8;
        a r101 = r100.f568799a;     // Catch: Throwable -> L11
        if (r101 == null) goto L8;
        r(r101.f568752a);     // Catch: Throwable -> L11
        u(r100.f568800b);     // Catch: Throwable -> L11
        k(r100.f568799a);     // Catch: Throwable -> L11
    L8:
        this.f568835a.setTransactionSuccessful();     // Catch: Throwable -> L11
        this.f568835a.endTransaction();
    }

    @Override // yq5.f
    public final void e(String r100) {
        this.f568835a.beginTransaction();
        p(this, r100);     // Catch: Throwable -> L6
        this.f568835a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f568835a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.f568835a.endTransaction();
        throw th;
    }

    @Override // yq5.f
    public final void f(VirtualNode r100) {
        this.f568835a.beginTransaction();
        o(this, r100);     // Catch: Throwable -> L6
        this.f568835a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f568835a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.f568835a.endTransaction();
        throw th;
    }

    @Override // yq5.f
    public final List<b> g(List<String> r210) {
        StringBuilder r100 = StringUtil.newStringBuilder();
        r100.append("SELECT ");
        r100.append("*");
        r100.append(" FROM t_wiki_relation WHERE wiki_token IN (");
        int r101 = r210.size();
        StringUtil.appendPlaceholders(r100, r101);
        r100.append(")");
        RoomSQLiteQuery r102 = RoomSQLiteQuery.acquire(r100.toString(), r101 + 0);
        Iterator<String> r103 = r210.iterator();
        int r104 = 1;
    L4:
        if (r103.hasNext() == false) goto L10;
        String r105 = r103.next();
        if (r105 != null) goto L8;
        r102.bindNull(r104);
    L9:
        r104 = r104 + 1;
        goto L4
    L8:
        r102.bindString(r104, r105);
        goto L9
    L10:
        this.f568835a.assertNotSuspendingTransaction();
        Cursor r106 = DBUtil.query(this.f568835a, r102, false, null);
        int r107 = CursorUtil.getColumnIndexOrThrow(r106, "wiki_token");     // Catch: Throwable -> L42
        int r108 = CursorUtil.getColumnIndexOrThrow(r106, DocViewModel.EXTRA_SPACE_ID);     // Catch: Throwable -> L42
        int r109 = CursorUtil.getColumnIndexOrThrow(r106, "obj_token");     // Catch: Throwable -> L42
        int r110 = CursorUtil.getColumnIndexOrThrow(r106, "obj_type");     // Catch: Throwable -> L42
        int r111 = CursorUtil.getColumnIndexOrThrow(r106, "title");     // Catch: Throwable -> L42
        int r112 = CursorUtil.getColumnIndexOrThrow(r106, "parent_wiki_token");     // Catch: Throwable -> L42
        int r113 = CursorUtil.getColumnIndexOrThrow(r106, "sort_id");     // Catch: Throwable -> L42
        int r114 = CursorUtil.getColumnIndexOrThrow(r106, "wiki_node_type");     // Catch: Throwable -> L42
        int r115 = CursorUtil.getColumnIndexOrThrow(r106, "origin_wiki_token");     // Catch: Throwable -> L42
        int r116 = CursorUtil.getColumnIndexOrThrow(r106, "origin_space_id");     // Catch: Throwable -> L42
        int r117 = CursorUtil.getColumnIndexOrThrow(r106, EventConstants.ExtraJson.EXTRA_IS_STAR);     // Catch: Throwable -> L42
        int r118 = CursorUtil.getColumnIndexOrThrow(r106, "children");     // Catch: Throwable -> L42
        int r119 = CursorUtil.getColumnIndexOrThrow(r106, "space_name");     // Catch: Throwable -> L42
        int r120 = CursorUtil.getColumnIndexOrThrow(r106, "has_child");     // Catch: Throwable -> L42
        RoomSQLiteQuery r121 = r102;
        int r122 = CursorUtil.getColumnIndexOrThrow(r106, "secret_key_delete");     // Catch: Throwable -> L40
        int r123 = CursorUtil.getColumnIndexOrThrow(r106, "is_explorer_star");     // Catch: Throwable -> L40
        int r124 = CursorUtil.getColumnIndexOrThrow(r106, "origin_is_external");     // Catch: Throwable -> L40
        int r211 = CursorUtil.getColumnIndexOrThrow(r106, "entity_delete_flag");     // Catch: Throwable -> L40
        int r212 = CursorUtil.getColumnIndexOrThrow(r106, "document_entity");     // Catch: Throwable -> L40
        int r213 = CursorUtil.getColumnIndexOrThrow(r106, "detail_info");     // Catch: Throwable -> L40
        int r214 = CursorUtil.getColumnIndexOrThrow(r106, "icon_entity");     // Catch: Throwable -> L40
        int r215 = r120;
        ArrayList r125 = new ArrayList(r106.getCount());     // Catch: Throwable -> L40
    L15:
        if (r106.moveToNext() == false) goto L38;
        b r126 = new b();     // Catch: Throwable -> L40
        ArrayList r216 = r125;
        r126.f568778a = r106.getString(r107);     // Catch: Throwable -> L40
        r126.f568779b = r106.getString(r108);     // Catch: Throwable -> L40
        r126.f568780c = r106.getString(r109);     // Catch: Throwable -> L40
        r126.f568781d = r106.getInt(r110);     // Catch: Throwable -> L40
        r126.f568782e = r106.getString(r111);     // Catch: Throwable -> L40
        r126.f568783f = r106.getString(r112);     // Catch: Throwable -> L40
        int r127 = r108;
        int r217 = r109;
        r126.f568784g = r106.getDouble(r113);     // Catch: Throwable -> L40
        r126.f568785h = r106.getInt(r114);     // Catch: Throwable -> L40
        r126.f568786i = r106.getString(r115);     // Catch: Throwable -> L40
        r126.f568787j = r106.getString(r116);     // Catch: Throwable -> L40
        if (r106.getInt(r117) == 0) goto L19;
        boolean r128 = true;
    L20:
        r126.f568788k = r128;     // Catch: Throwable -> L40
        r126.f568789l = r106.getString(r118);     // Catch: Throwable -> L40
        r126.f568790m = r106.getString(r119);     // Catch: Throwable -> L40
        int r129 = r215;
        if (r106.getInt(r129) == 0) goto L23;
        boolean r130 = true;
    L24:
        r126.f568791n = r130;     // Catch: Throwable -> L40
        int r131 = r122;
        if (r106.getInt(r131) == 0) goto L27;
        boolean r132 = true;
    L28:
        r126.f568792o = r132;     // Catch: Throwable -> L40
        r123 = r123;
        if (r106.getInt(r123) == 0) goto L31;
        boolean r133 = true;
    L32:
        r126.f568793p = r133;     // Catch: Throwable -> L40
        r124 = r124;
        if (r106.getInt(r124) == 0) goto L35;
        boolean r134 = true;
    L36:
        r126.f568794q = r134;     // Catch: Throwable -> L40
        int r135 = r211;
        r126.f568795r = r106.getInt(r135);     // Catch: Throwable -> L40
        int r136 = r212;
        r126.f568796s = r106.getString(r136);     // Catch: Throwable -> L40
        int r137 = r213;
        r126.f568797t = r106.getString(r137);     // Catch: Throwable -> L40
        int r138 = r214;
        r126.f568798u = r106.getString(r138);     // Catch: Throwable -> L40
        r216.add(r126);     // Catch: Throwable -> L40
        r215 = r129;
        r108 = r127;
        r211 = r135;
        r212 = r136;
        r213 = r137;
        r214 = r138;
        r125 = r216;
        r107 = r107;
        r122 = r131;
        r109 = r217;
        goto L15
    L35:
        r134 = false;
        goto L36
    L31:
        r133 = false;
        goto L32
    L27:
        r132 = false;
        goto L28
    L23:
        r130 = false;
        goto L24
    L19:
        r128 = false;
        goto L20
    L38:
        ArrayList r139 = r125;
        r106.close();
        r121.release();
        return r139;
    L40:
        th = th;
    L44:
        r106.close();
        r121.release();
        throw th;
    L42:
        th = th;
        r121 = r102;
        goto L44
    }

    @Override // yq5.f
    public final a h(String r310) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM t_wiki_relation_info WHERE space_id = ?", 1);
        if (r310 != null) goto L5;
        r100.bindNull(1);
    L6:
        this.f568835a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f568835a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, DocViewModel.EXTRA_SPACE_ID);     // Catch: Throwable -> L46
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, "space_name");     // Catch: Throwable -> L46
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "space_icon");     // Catch: Throwable -> L46
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "tenant_id");     // Catch: Throwable -> L46
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "description");     // Catch: Throwable -> L46
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, EventConstants.ExtraJson.EXTRA_IS_STAR);     // Catch: Throwable -> L46
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "space_type");     // Catch: Throwable -> L46
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "wiki_scope");     // Catch: Throwable -> L46
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "open_sharing");     // Catch: Throwable -> L46
        int r115 = CursorUtil.getColumnIndexOrThrow(r101, "owner_perm_type");     // Catch: Throwable -> L46
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "create_uid");     // Catch: Throwable -> L46
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "cover_origin");     // Catch: Throwable -> L46
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, "cover_thumbnail");     // Catch: Throwable -> L46
        int r109 = CursorUtil.getColumnIndexOrThrow(r101, "cover_key");     // Catch: Throwable -> L46
        RoomSQLiteQuery r116 = r100;
        int r117 = CursorUtil.getColumnIndexOrThrow(r101, "cover_is_graph_dark");     // Catch: Throwable -> L44
        int r118 = CursorUtil.getColumnIndexOrThrow(r101, "cover_color_value");     // Catch: Throwable -> L44
        int r119 = CursorUtil.getColumnIndexOrThrow(r101, "view_wiki_collaborator");     // Catch: Throwable -> L44
        int r120 = CursorUtil.getColumnIndexOrThrow(r101, "view_wiki_info");     // Catch: Throwable -> L44
        int r121 = CursorUtil.getColumnIndexOrThrow(r101, "star_wiki");     // Catch: Throwable -> L44
        int r122 = CursorUtil.getColumnIndexOrThrow(r101, "view_wiki_general_info");     // Catch: Throwable -> L44
        int r123 = CursorUtil.getColumnIndexOrThrow(r101, "can_edit_first_level");     // Catch: Throwable -> L44
        int r124 = CursorUtil.getColumnIndexOrThrow(r101, "wiki_homepage_obj_token");     // Catch: Throwable -> L44
        int r125 = CursorUtil.getColumnIndexOrThrow(r101, "wiki_homepage_obj_type");     // Catch: Throwable -> L44
        int r126 = CursorUtil.getColumnIndexOrThrow(r101, "wiki_homepage_wiki_token");     // Catch: Throwable -> L44
        int r127 = CursorUtil.getColumnIndexOrThrow(r101, "wiki_homepage_url");     // Catch: Throwable -> L44
        int r128 = CursorUtil.getColumnIndexOrThrow(r101, "wiki_homepage_title");     // Catch: Throwable -> L44
        if (r101.moveToFirst() == false) goto L41;
        a r129 = new a();     // Catch: Throwable -> L44
        r129.f568752a = r101.getString(r102);     // Catch: Throwable -> L44
        r129.f568753b = r101.getString(r103);     // Catch: Throwable -> L44
        r129.f568754c = r101.getString(r104);     // Catch: Throwable -> L44
        r129.f568755d = r101.getString(r105);     // Catch: Throwable -> L44
        r129.f568756e = r101.getString(r110);     // Catch: Throwable -> L44
        if (r101.getInt(r111) == 0) goto L14;
        boolean r130 = true;
    L15:
        r129.f568757f = r130;     // Catch: Throwable -> L44
        r129.f568758g = r101.getInt(r112);     // Catch: Throwable -> L44
        r129.f568759h = r101.getInt(r113);     // Catch: Throwable -> L44
        r129.f568760i = r101.getInt(r114);     // Catch: Throwable -> L44
        r129.f568761j = r101.getInt(r115);     // Catch: Throwable -> L44
        r129.f568762k = r101.getString(r106);     // Catch: Throwable -> L44
        r129.f568763l = r101.getString(r107);     // Catch: Throwable -> L44
        r129.f568764m = r101.getString(r108);     // Catch: Throwable -> L44
        r129.f568765n = r101.getString(r109);     // Catch: Throwable -> L44
        if (r101.getInt(r117) == 0) goto L18;
        boolean r131 = true;
    L19:
        r129.f568766o = r131;     // Catch: Throwable -> L44
        r129.f568767p = r101.getString(r118);     // Catch: Throwable -> L44
        if (r101.getInt(r119) == 0) goto L22;
        boolean r132 = true;
    L23:
        r129.f568768q = r132;     // Catch: Throwable -> L44
        if (r101.getInt(r120) == 0) goto L26;
        boolean r133 = true;
    L27:
        r129.f568769r = r133;     // Catch: Throwable -> L44
        if (r101.getInt(r121) == 0) goto L30;
        boolean r134 = true;
    L31:
        r129.f568770s = r134;     // Catch: Throwable -> L44
        if (r101.getInt(r122) == 0) goto L34;
        boolean r135 = true;
    L35:
        r129.f568771t = r135;     // Catch: Throwable -> L44
        if (r101.getInt(r123) == 0) goto L38;
        boolean r136 = true;
    L39:
        r129.f568772u = r136;     // Catch: Throwable -> L44
        r129.f568773v = r101.getString(r124);     // Catch: Throwable -> L44
        r129.f568774w = r101.getInt(r125);     // Catch: Throwable -> L44
        r129.f568775x = r101.getString(r126);     // Catch: Throwable -> L44
        r129.f568776y = r101.getString(r127);     // Catch: Throwable -> L44
        r129.f568777z = r101.getString(r128);     // Catch: Throwable -> L44
        a r137 = r129;
    L42:
        r101.close();
        r116.release();
        return r137;
    L38:
        r136 = false;
        goto L39
    L34:
        r135 = false;
        goto L35
    L30:
        r134 = false;
        goto L31
    L26:
        r133 = false;
        goto L27
    L22:
        r132 = false;
        goto L23
    L18:
        r131 = false;
        goto L19
    L14:
        r130 = false;
        goto L15
    L41:
        r137 = null;
    L44:
        th = th;
    L48:
        r101.close();
        r116.release();
        throw th;
    L46:
        th = th;
        r116 = r100;
        goto L48
    L5:
        r100.bindString(1, r310);
        goto L6
    }

    @Override // yq5.f
    public final c i(String r100) {
        this.f568835a.beginTransaction();
        c r101 = n(this, r100);     // Catch: Throwable -> L6
        this.f568835a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f568835a.endTransaction();
        return r101;
    L6:
        th = move-exception;
        this.f568835a.endTransaction();
        throw th;
    }

    @Override // yq5.f
    public final b j(String r210) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM t_wiki_relation WHERE space_id = ? AND wiki_node_type = 2 LIMIT 1", 1);
        if (r210 != null) goto L5;
        r100.bindNull(1);
    L6:
        this.f568835a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f568835a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "wiki_token");     // Catch: Throwable -> L38
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, DocViewModel.EXTRA_SPACE_ID);     // Catch: Throwable -> L38
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "obj_token");     // Catch: Throwable -> L38
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "obj_type");     // Catch: Throwable -> L38
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "title");     // Catch: Throwable -> L38
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, "parent_wiki_token");     // Catch: Throwable -> L38
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "sort_id");     // Catch: Throwable -> L38
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "wiki_node_type");     // Catch: Throwable -> L38
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "origin_wiki_token");     // Catch: Throwable -> L38
        int r115 = CursorUtil.getColumnIndexOrThrow(r101, "origin_space_id");     // Catch: Throwable -> L38
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, EventConstants.ExtraJson.EXTRA_IS_STAR);     // Catch: Throwable -> L38
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "children");     // Catch: Throwable -> L38
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, "space_name");     // Catch: Throwable -> L38
        int r109 = CursorUtil.getColumnIndexOrThrow(r101, "has_child");     // Catch: Throwable -> L38
        RoomSQLiteQuery r116 = r100;
        int r117 = CursorUtil.getColumnIndexOrThrow(r101, "secret_key_delete");     // Catch: Throwable -> L36
        int r118 = CursorUtil.getColumnIndexOrThrow(r101, "is_explorer_star");     // Catch: Throwable -> L36
        int r119 = CursorUtil.getColumnIndexOrThrow(r101, "origin_is_external");     // Catch: Throwable -> L36
        int r120 = CursorUtil.getColumnIndexOrThrow(r101, "entity_delete_flag");     // Catch: Throwable -> L36
        int r121 = CursorUtil.getColumnIndexOrThrow(r101, "document_entity");     // Catch: Throwable -> L36
        int r122 = CursorUtil.getColumnIndexOrThrow(r101, "detail_info");     // Catch: Throwable -> L36
        int r123 = CursorUtil.getColumnIndexOrThrow(r101, "icon_entity");     // Catch: Throwable -> L36
        if (r101.moveToFirst() == false) goto L33;
        b r124 = new b();     // Catch: Throwable -> L36
        r124.f568778a = r101.getString(r102);     // Catch: Throwable -> L36
        r124.f568779b = r101.getString(r103);     // Catch: Throwable -> L36
        r124.f568780c = r101.getString(r104);     // Catch: Throwable -> L36
        r124.f568781d = r101.getInt(r105);     // Catch: Throwable -> L36
        r124.f568782e = r101.getString(r110);     // Catch: Throwable -> L36
        r124.f568783f = r101.getString(r111);     // Catch: Throwable -> L36
        r124.f568784g = r101.getDouble(r112);     // Catch: Throwable -> L36
        r124.f568785h = r101.getInt(r113);     // Catch: Throwable -> L36
        r124.f568786i = r101.getString(r114);     // Catch: Throwable -> L36
        r124.f568787j = r101.getString(r115);     // Catch: Throwable -> L36
        if (r101.getInt(r106) == 0) goto L14;
        boolean r125 = true;
    L15:
        r124.f568788k = r125;     // Catch: Throwable -> L36
        r124.f568789l = r101.getString(r107);     // Catch: Throwable -> L36
        r124.f568790m = r101.getString(r108);     // Catch: Throwable -> L36
        if (r101.getInt(r109) == 0) goto L18;
        boolean r126 = true;
    L19:
        r124.f568791n = r126;     // Catch: Throwable -> L36
        if (r101.getInt(r117) == 0) goto L22;
        boolean r127 = true;
    L23:
        r124.f568792o = r127;     // Catch: Throwable -> L36
        if (r101.getInt(r118) == 0) goto L26;
        boolean r128 = true;
    L27:
        r124.f568793p = r128;     // Catch: Throwable -> L36
        if (r101.getInt(r119) == 0) goto L30;
        boolean r129 = true;
    L31:
        r124.f568794q = r129;     // Catch: Throwable -> L36
        r124.f568795r = r101.getInt(r120);     // Catch: Throwable -> L36
        r124.f568796s = r101.getString(r121);     // Catch: Throwable -> L36
        r124.f568797t = r101.getString(r122);     // Catch: Throwable -> L36
        r124.f568798u = r101.getString(r123);     // Catch: Throwable -> L36
        b r130 = r124;
    L34:
        r101.close();
        r116.release();
        return r130;
    L30:
        r129 = false;
        goto L31
    L26:
        r128 = false;
        goto L27
    L22:
        r127 = false;
        goto L23
    L18:
        r126 = false;
        goto L19
    L14:
        r125 = false;
        goto L15
    L33:
        r130 = null;
    L36:
        th = th;
    L40:
        r101.close();
        r116.release();
        throw th;
    L38:
        th = th;
        r116 = r100;
        goto L40
    L5:
        r100.bindString(1, r210);
        goto L6
    }

    @Override // yq5.f
    public final void k(a r100) {
        this.f568835a.assertNotSuspendingTransaction();
        this.f568835a.beginTransaction();
        this.f568837c.insert(r100);     // Catch: Throwable -> L6
        this.f568835a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f568835a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.f568835a.endTransaction();
        throw th;
    }

    @Override // yq5.f
    public final void l(List<b> r100) {
        this.f568835a.assertNotSuspendingTransaction();
        this.f568835a.beginTransaction();
        this.f568840f.handleMultiple(r100);     // Catch: Throwable -> L6
        this.f568835a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f568835a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.f568835a.endTransaction();
        throw th;
    }

    public final int r(String r100) {
        this.f568835a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r101 = this.f568843i.acquire();
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.f568835a.beginTransaction();
        int r102 = r101.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f568835a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.f568835a.endTransaction();
        this.f568843i.release(r101);
        return r102;
    L10:
        th = move-exception;
        this.f568835a.endTransaction();
        this.f568843i.release(r101);
        throw th;
    L5:
        r101.bindString(1, r100);
        goto L6
    }

    public final void t(List<b> r100) {
        this.f568835a.assertNotSuspendingTransaction();
        this.f568835a.beginTransaction();
        this.f568836b.insert(r100);     // Catch: Throwable -> L6
        this.f568835a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f568835a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.f568835a.endTransaction();
        throw th;
    }

    public final void u(List<b> r100) {
        this.f568835a.assertNotSuspendingTransaction();
        this.f568835a.beginTransaction();
        this.f568836b.insert(r100);     // Catch: Throwable -> L6
        this.f568835a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f568835a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.f568835a.endTransaction();
        throw th;
    }

    public static c n(q r210, String r211) {
        r210.getClass();
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM t_wiki_relation WHERE space_id = ?", 1);
        if (r211 != null) goto L5;
        r100.bindNull(1);
    L6:
        r210.f568835a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(r210.f568835a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "wiki_token");     // Catch: Throwable -> L38
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, DocViewModel.EXTRA_SPACE_ID);     // Catch: Throwable -> L38
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "obj_token");     // Catch: Throwable -> L38
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "obj_type");     // Catch: Throwable -> L38
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "title");     // Catch: Throwable -> L38
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, "parent_wiki_token");     // Catch: Throwable -> L38
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "sort_id");     // Catch: Throwable -> L38
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "wiki_node_type");     // Catch: Throwable -> L38
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "origin_wiki_token");     // Catch: Throwable -> L38
        int r115 = CursorUtil.getColumnIndexOrThrow(r101, "origin_space_id");     // Catch: Throwable -> L38
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, EventConstants.ExtraJson.EXTRA_IS_STAR);     // Catch: Throwable -> L38
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "children");     // Catch: Throwable -> L38
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, "space_name");     // Catch: Throwable -> L38
        int r109 = CursorUtil.getColumnIndexOrThrow(r101, "has_child");     // Catch: Throwable -> L38
        RoomSQLiteQuery r116 = r100;
        int r117 = CursorUtil.getColumnIndexOrThrow(r101, "secret_key_delete");     // Catch: Throwable -> L36
        int r118 = CursorUtil.getColumnIndexOrThrow(r101, "is_explorer_star");     // Catch: Throwable -> L36
        int r119 = CursorUtil.getColumnIndexOrThrow(r101, "origin_is_external");     // Catch: Throwable -> L36
        int r212 = CursorUtil.getColumnIndexOrThrow(r101, "entity_delete_flag");     // Catch: Throwable -> L36
        int r213 = CursorUtil.getColumnIndexOrThrow(r101, "document_entity");     // Catch: Throwable -> L36
        int r214 = CursorUtil.getColumnIndexOrThrow(r101, "detail_info");     // Catch: Throwable -> L36
        int r215 = CursorUtil.getColumnIndexOrThrow(r101, "icon_entity");     // Catch: Throwable -> L36
        int r216 = r109;
        ArrayList r120 = new ArrayList(r101.getCount());     // Catch: Throwable -> L36
    L11:
        if (r101.moveToNext() == false) goto L34;
        b r121 = new b();     // Catch: Throwable -> L36
        ArrayList r217 = r120;
        r121.f568778a = r101.getString(r102);     // Catch: Throwable -> L36
        r121.f568779b = r101.getString(r103);     // Catch: Throwable -> L36
        r121.f568780c = r101.getString(r104);     // Catch: Throwable -> L36
        r121.f568781d = r101.getInt(r105);     // Catch: Throwable -> L36
        r121.f568782e = r101.getString(r110);     // Catch: Throwable -> L36
        r121.f568783f = r101.getString(r111);     // Catch: Throwable -> L36
        int r122 = r103;
        int r218 = r104;
        r121.f568784g = r101.getDouble(r112);     // Catch: Throwable -> L36
        r121.f568785h = r101.getInt(r113);     // Catch: Throwable -> L36
        r121.f568786i = r101.getString(r114);     // Catch: Throwable -> L36
        r121.f568787j = r101.getString(r115);     // Catch: Throwable -> L36
        if (r101.getInt(r106) == 0) goto L15;
        boolean r123 = true;
    L16:
        r121.f568788k = r123;     // Catch: Throwable -> L36
        r121.f568789l = r101.getString(r107);     // Catch: Throwable -> L36
        r121.f568790m = r101.getString(r108);     // Catch: Throwable -> L36
        int r124 = r216;
        if (r101.getInt(r124) == 0) goto L19;
        boolean r125 = true;
    L20:
        r121.f568791n = r125;     // Catch: Throwable -> L36
        int r126 = r117;
        if (r101.getInt(r126) == 0) goto L23;
        boolean r127 = true;
    L24:
        r121.f568792o = r127;     // Catch: Throwable -> L36
        r118 = r118;
        if (r101.getInt(r118) == 0) goto L27;
        boolean r128 = true;
    L28:
        r121.f568793p = r128;     // Catch: Throwable -> L36
        r119 = r119;
        if (r101.getInt(r119) == 0) goto L31;
        boolean r129 = true;
    L32:
        r121.f568794q = r129;     // Catch: Throwable -> L36
        int r130 = r212;
        r121.f568795r = r101.getInt(r130);     // Catch: Throwable -> L36
        int r131 = r213;
        r121.f568796s = r101.getString(r131);     // Catch: Throwable -> L36
        int r132 = r214;
        r121.f568797t = r101.getString(r132);     // Catch: Throwable -> L36
        int r133 = r215;
        r121.f568798u = r101.getString(r133);     // Catch: Throwable -> L36
        r217.add(r121);     // Catch: Throwable -> L36
        r216 = r124;
        r103 = r122;
        r212 = r130;
        r213 = r131;
        r214 = r132;
        r215 = r133;
        r120 = r217;
        r108 = r108;
        r117 = r126;
        r104 = r218;
        goto L11
    L31:
        r129 = false;
        goto L32
    L27:
        r128 = false;
        goto L28
    L23:
        r127 = false;
        goto L24
    L19:
        r125 = false;
        goto L20
    L15:
        r123 = false;
        goto L16
    L34:
        ArrayList r134 = r120;
        r101.close();
        r116.release();
        a r135 = r210.h(r211);
        c r136 = new c();
        r136.f568800b = r134;
        r136.f568799a = r135;
        return r136;
    L36:
        th = th;
    L40:
        r101.close();
        r116.release();
        throw th;
    L38:
        th = th;
        r116 = r100;
        goto L40
    L5:
        r100.bindString(1, r211);
        goto L6
    }

    public static void o(q r100, VirtualNode r101) {
        r100.getClass();
        b r102 = r100.s(r101.getSpaceId(), r101.getRootToken());
        if (r102 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r102.f568789l) == true) goto L25;
        ArrayList<String> r103 = s.a(r102);     // Catch: Exception -> L17
        if (hu5.a.d(r103) == true) goto L26;
        List<b> r104 = r100.g(r103);     // Catch: Exception -> L17
        int r105 = ((ArrayList) r104).size();     // Catch: Exception -> L17
        b[] r106 = new b[r105];     // Catch: Exception -> L17
        int r107 = 0;
    L9:
        if (r107 >= r105) goto L11;
        r106[r107] = (b) ListProtector.get(r104, r107);     // Catch: Exception -> L17
        r107 = r107 + 1;     // Catch: Exception -> L17
        goto L9
    L11:
        r100.f568835a.assertNotSuspendingTransaction();     // Catch: Exception -> L17
        r100.f568835a.beginTransaction();     // Catch: Exception -> L17
        r100.f568839e.handleMultiple(r106);     // Catch: Throwable -> L14
        r100.f568835a.setTransactionSuccessful();     // Catch: Throwable -> L14
        r100.f568835a.endTransaction();     // Catch: Exception -> L17
        return;
    L14:
        th = move-exception;
        r100.f568835a.endTransaction();     // Catch: Exception -> L17
        throw th;     // Catch: Exception -> L17
    L26:
        return;
    L17:
        e = move-exception;
        tt5.a.d("DBTreeNode", "deleteAndInsertVirtualRelation, delete node fail: " + e);
        return;
    }

    public static void p(q r100, String r101) {
        r100.r(r101);
        r100.f568835a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r102 = r100.f568844j.acquire();
        if (r101 != null) goto L5;
        r102.bindNull(1);
    L6:
        r100.f568835a.beginTransaction();
        r102.executeUpdateDelete();     // Catch: Throwable -> L10
        r100.f568835a.setTransactionSuccessful();     // Catch: Throwable -> L10
        r100.f568835a.endTransaction();
        r100.f568844j.release(r102);
        return;
    L10:
        th = move-exception;
        r100.f568835a.endTransaction();
        r100.f568844j.release(r102);
        throw th;
    L5:
        r102.bindString(1, r101);
        goto L6
    }

    @Override // yq5.f
    public final void b(VirtualNode r100, c r101) {
        this.f568835a.beginTransaction();
    L11:
        th = move-exception;
        this.f568835a.endTransaction();
        throw th;
    L4:
        if (hu5.a.d(r101.f568800b) == false) goto L6;
    L8:
        this.f568835a.setTransactionSuccessful();     // Catch: Throwable -> L11
        this.f568835a.endTransaction();
        return;
    L6:
        if (r101.f568799a == null) goto L8;
        f(r100);     // Catch: Throwable -> L11
        u(r101.f568800b);     // Catch: Throwable -> L11
        k(r101.f568799a);     // Catch: Throwable -> L11
        goto L8
    }

    @Override // yq5.f
    public final int c(String r100, List<String> r101) {
        this.f568835a.assertNotSuspendingTransaction();
        StringBuilder r102 = StringUtil.newStringBuilder();
        r102.append("DELETE FROM t_wiki_relation WHERE space_id = ");
        r102.append("?");
        r102.append(" AND wiki_token IN (");
        StringUtil.appendPlaceholders(r102, r101.size());
        r102.append(")");
        String r103 = r102.toString();
        SupportSQLiteStatement r104 = this.f568835a.compileStatement(r103);
        if (r100 != null) goto L5;
        r104.bindNull(1);
    L6:
        Iterator<String> r105 = r101.iterator();
        int r106 = 2;
    L8:
        if (r105.hasNext() == false) goto L14;
        String r107 = r105.next();
        if (r107 != null) goto L12;
        r104.bindNull(r106);
    L13:
        r106 = r106 + 1;
        goto L8
    L12:
        r104.bindString(r106, r107);
        goto L13
    L14:
        this.f568835a.beginTransaction();
        int r108 = r104.executeUpdateDelete();     // Catch: Throwable -> L18
        this.f568835a.setTransactionSuccessful();     // Catch: Throwable -> L18
        this.f568835a.endTransaction();
        return r108;
    L18:
        th = move-exception;
        this.f568835a.endTransaction();
        throw th;
    L5:
        r104.bindString(1, r100);
        goto L6
    }

    public final b s(String r210, String r211) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM t_wiki_relation WHERE space_id = ? AND wiki_token = ?", 2);
        if (r210 != null) goto L5;
        r100.bindNull(1);
    L6:
        if (r211 != null) goto L8;
        r100.bindNull(2);
    L9:
        this.f568835a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f568835a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, "wiki_token");     // Catch: Throwable -> L41
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, DocViewModel.EXTRA_SPACE_ID);     // Catch: Throwable -> L41
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "obj_token");     // Catch: Throwable -> L41
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "obj_type");     // Catch: Throwable -> L41
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "title");     // Catch: Throwable -> L41
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, "parent_wiki_token");     // Catch: Throwable -> L41
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "sort_id");     // Catch: Throwable -> L41
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "wiki_node_type");     // Catch: Throwable -> L41
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "origin_wiki_token");     // Catch: Throwable -> L41
        int r115 = CursorUtil.getColumnIndexOrThrow(r101, "origin_space_id");     // Catch: Throwable -> L41
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, EventConstants.ExtraJson.EXTRA_IS_STAR);     // Catch: Throwable -> L41
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "children");     // Catch: Throwable -> L41
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, "space_name");     // Catch: Throwable -> L41
        int r109 = CursorUtil.getColumnIndexOrThrow(r101, "has_child");     // Catch: Throwable -> L41
        RoomSQLiteQuery r116 = r100;
        int r117 = CursorUtil.getColumnIndexOrThrow(r101, "secret_key_delete");     // Catch: Throwable -> L39
        int r118 = CursorUtil.getColumnIndexOrThrow(r101, "is_explorer_star");     // Catch: Throwable -> L39
        int r119 = CursorUtil.getColumnIndexOrThrow(r101, "origin_is_external");     // Catch: Throwable -> L39
        int r120 = CursorUtil.getColumnIndexOrThrow(r101, "entity_delete_flag");     // Catch: Throwable -> L39
        int r121 = CursorUtil.getColumnIndexOrThrow(r101, "document_entity");     // Catch: Throwable -> L39
        int r122 = CursorUtil.getColumnIndexOrThrow(r101, "detail_info");     // Catch: Throwable -> L39
        int r123 = CursorUtil.getColumnIndexOrThrow(r101, "icon_entity");     // Catch: Throwable -> L39
        if (r101.moveToFirst() == false) goto L36;
        b r124 = new b();     // Catch: Throwable -> L39
        r124.f568778a = r101.getString(r102);     // Catch: Throwable -> L39
        r124.f568779b = r101.getString(r103);     // Catch: Throwable -> L39
        r124.f568780c = r101.getString(r104);     // Catch: Throwable -> L39
        r124.f568781d = r101.getInt(r105);     // Catch: Throwable -> L39
        r124.f568782e = r101.getString(r110);     // Catch: Throwable -> L39
        r124.f568783f = r101.getString(r111);     // Catch: Throwable -> L39
        r124.f568784g = r101.getDouble(r112);     // Catch: Throwable -> L39
        r124.f568785h = r101.getInt(r113);     // Catch: Throwable -> L39
        r124.f568786i = r101.getString(r114);     // Catch: Throwable -> L39
        r124.f568787j = r101.getString(r115);     // Catch: Throwable -> L39
        if (r101.getInt(r106) == 0) goto L17;
        boolean r125 = true;
    L18:
        r124.f568788k = r125;     // Catch: Throwable -> L39
        r124.f568789l = r101.getString(r107);     // Catch: Throwable -> L39
        r124.f568790m = r101.getString(r108);     // Catch: Throwable -> L39
        if (r101.getInt(r109) == 0) goto L21;
        boolean r126 = true;
    L22:
        r124.f568791n = r126;     // Catch: Throwable -> L39
        if (r101.getInt(r117) == 0) goto L25;
        boolean r127 = true;
    L26:
        r124.f568792o = r127;     // Catch: Throwable -> L39
        if (r101.getInt(r118) == 0) goto L29;
        boolean r128 = true;
    L30:
        r124.f568793p = r128;     // Catch: Throwable -> L39
        if (r101.getInt(r119) == 0) goto L33;
        boolean r129 = true;
    L34:
        r124.f568794q = r129;     // Catch: Throwable -> L39
        r124.f568795r = r101.getInt(r120);     // Catch: Throwable -> L39
        r124.f568796s = r101.getString(r121);     // Catch: Throwable -> L39
        r124.f568797t = r101.getString(r122);     // Catch: Throwable -> L39
        r124.f568798u = r101.getString(r123);     // Catch: Throwable -> L39
        b r130 = r124;
    L37:
        r101.close();
        r116.release();
        return r130;
    L33:
        r129 = false;
        goto L34
    L29:
        r128 = false;
        goto L30
    L25:
        r127 = false;
        goto L26
    L21:
        r126 = false;
        goto L22
    L17:
        r125 = false;
        goto L18
    L36:
        r130 = null;
    L39:
        th = th;
    L43:
        r101.close();
        r116.release();
        throw th;
    L41:
        th = th;
        r116 = r100;
        goto L43
    L8:
        r100.bindString(2, r211);
        goto L9
    L5:
        r100.bindString(1, r210);
        goto L6
    }

    public static void q(q r100, b r101, List r102) {
        r100.getClass();
        r100.f568835a.assertNotSuspendingTransaction();
        r100.f568835a.beginTransaction();
        r100.f568838d.insert(r102);     // Catch: Throwable -> L6
        r100.f568835a.setTransactionSuccessful();     // Catch: Throwable -> L6
        r100.f568835a.endTransaction();
        r100.t(CollectionsKt.arrayListOf(new b[]{r101}));
        return;
    L6:
        th = move-exception;
        r100.f568835a.endTransaction();
        throw th;
    }

    @Override // yq5.f
    public final void d(String r100, List<String> r101, List<b> r102) {
        this.f568835a.beginTransaction();
        c(r100, r101);     // Catch: Throwable -> L6
        l(r102);     // Catch: Throwable -> L6
        this.f568835a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.f568835a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.f568835a.endTransaction();
        throw th;
    }

    @Override // yq5.f
    public final void m(String r100, String r101, String r102, String r103) {
        this.f568835a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r104 = this.f568841g.acquire();
        if (r102 != null) goto L5;
        r104.bindNull(1);
    L7:
        if (r103 != null) goto L9;
        r104.bindNull(2);
    L11:
        if (r100 != null) goto L13;
        r104.bindNull(3);
    L15:
        if (r101 != null) goto L17;
        r104.bindNull(4);
    L18:
        this.f568835a.beginTransaction();
        r104.executeUpdateDelete();     // Catch: Throwable -> L22
        this.f568835a.setTransactionSuccessful();     // Catch: Throwable -> L22
        this.f568835a.endTransaction();
        this.f568841g.release(r104);
        return;
    L22:
        th = move-exception;
        this.f568835a.endTransaction();
        this.f568841g.release(r104);
        throw th;
    L17:
        r104.bindString(4, r101);
        goto L18
    L13:
        r104.bindString(3, r100);
        goto L15
    L9:
        r104.bindString(2, r103);
        goto L11
    L5:
        r104.bindString(1, r102);
        goto L7
    }
}
