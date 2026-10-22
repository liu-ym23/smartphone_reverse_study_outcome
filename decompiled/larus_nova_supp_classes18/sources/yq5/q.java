package yq5;

import android.database.Cursor;
import android.text.TextUtils;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.VirtualNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class q extends f {
    public final RoomDatabase a;
    public final h b;
    public final i c;
    public final j d;
    public final k e;
    public final l f;
    public final m g;
    public final n h;
    public final o i;
    public final p j;

    public q(WikiDatabase r2) {
        this.a = r2;
        this.b = new h(r2);
        this.c = new i(r2);
        this.d = new j(r2);
        this.e = new k(r2);
        this.f = new l(r2);
        this.g = new m(r2);
        this.h = new n(r2);
        this.i = new o(r2);
        this.j = new p(r2);
    }

    @Override // yq5.f
    public final void a(c r2) {
        this.a.beginTransaction();
    L11:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    L4:
        if (hu5.a.d(r2.b) == true) goto L8;
        a r0 = r2.a;     // Catch: Throwable -> L11
        if (r0 == null) goto L8;
        r(r0.a);     // Catch: Throwable -> L11
        u(r2.b);     // Catch: Throwable -> L11
        k(r2.a);     // Catch: Throwable -> L11
    L8:
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L11
        this.a.endTransaction();
    }

    @Override // yq5.f
    public final void e(String r2) {
        this.a.beginTransaction();
        p(this, r2);     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    @Override // yq5.f
    public final void f(VirtualNode r2) {
        this.a.beginTransaction();
        o(this, r2);     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    @Override // yq5.f
    public final List<b> g(List<String> r28) {
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("SELECT ");
        r0.append("*");
        r0.append(" FROM t_wiki_relation WHERE wiki_token IN (");
        int r2 = r28.size();
        StringUtil.appendPlaceholders(r0, r2);
        r0.append(")");
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire(r0.toString(), r2 + 0);
        Iterator<String> r1 = r28.iterator();
        int r5 = 1;
    L4:
        if (r1.hasNext() == false) goto L10;
        String r6 = r1.next();
        if (r6 != null) goto L8;
        r3.bindNull(r5);
    L9:
        r5 = r5 + 1;
        goto L4
    L8:
        r3.bindString(r5, r6);
        goto L9
    L10:
        this.a.assertNotSuspendingTransaction();
        Cursor r7 = DBUtil.query(this.a, r3, false, null);
        int r4 = CursorUtil.getColumnIndexOrThrow(r7, "wiki_token");     // Catch: Throwable -> L42
        int r8 = CursorUtil.getColumnIndexOrThrow(r7, "space_id");     // Catch: Throwable -> L42
        int r9 = CursorUtil.getColumnIndexOrThrow(r7, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L42
        int r10 = CursorUtil.getColumnIndexOrThrow(r7, "obj_type");     // Catch: Throwable -> L42
        int r11 = CursorUtil.getColumnIndexOrThrow(r7, "title");     // Catch: Throwable -> L42
        int r12 = CursorUtil.getColumnIndexOrThrow(r7, "parent_wiki_token");     // Catch: Throwable -> L42
        int r13 = CursorUtil.getColumnIndexOrThrow(r7, "sort_id");     // Catch: Throwable -> L42
        int r14 = CursorUtil.getColumnIndexOrThrow(r7, "wiki_node_type");     // Catch: Throwable -> L42
        int r15 = CursorUtil.getColumnIndexOrThrow(r7, "origin_wiki_token");     // Catch: Throwable -> L42
        int r16 = CursorUtil.getColumnIndexOrThrow(r7, "origin_space_id");     // Catch: Throwable -> L42
        int r17 = CursorUtil.getColumnIndexOrThrow(r7, "is_star");     // Catch: Throwable -> L42
        int r18 = CursorUtil.getColumnIndexOrThrow(r7, "children");     // Catch: Throwable -> L42
        int r19 = CursorUtil.getColumnIndexOrThrow(r7, "space_name");     // Catch: Throwable -> L42
        int r20 = CursorUtil.getColumnIndexOrThrow(r7, "has_child");     // Catch: Throwable -> L42
        RoomSQLiteQuery r110 = r3;
        int r111 = CursorUtil.getColumnIndexOrThrow(r7, "secret_key_delete");     // Catch: Throwable -> L40
        int r112 = CursorUtil.getColumnIndexOrThrow(r7, "is_explorer_star");     // Catch: Throwable -> L40
        int r113 = CursorUtil.getColumnIndexOrThrow(r7, "origin_is_external");     // Catch: Throwable -> L40
        int r21 = CursorUtil.getColumnIndexOrThrow(r7, "entity_delete_flag");     // Catch: Throwable -> L40
        int r22 = CursorUtil.getColumnIndexOrThrow(r7, "document_entity");     // Catch: Throwable -> L40
        int r23 = CursorUtil.getColumnIndexOrThrow(r7, "detail_info");     // Catch: Throwable -> L40
        int r24 = CursorUtil.getColumnIndexOrThrow(r7, "icon_entity");     // Catch: Throwable -> L40
        int r25 = r20;
        ArrayList r26 = new ArrayList(r7.getCount());     // Catch: Throwable -> L40
    L15:
        if (r7.moveToNext() == false) goto L38;
        b r27 = new b();     // Catch: Throwable -> L40
        ArrayList r29 = r26;
        r27.a = r7.getString(r4);     // Catch: Throwable -> L40
        r27.b = r7.getString(r8);     // Catch: Throwable -> L40
        r27.c = r7.getString(r9);     // Catch: Throwable -> L40
        r27.d = r7.getInt(r10);     // Catch: Throwable -> L40
        r27.e = r7.getString(r11);     // Catch: Throwable -> L40
        r27.f = r7.getString(r12);     // Catch: Throwable -> L40
        int r30 = r8;
        int r210 = r9;
        r27.g = r7.getDouble(r13);     // Catch: Throwable -> L40
        r27.h = r7.getInt(r14);     // Catch: Throwable -> L40
        r27.i = r7.getString(r15);     // Catch: Throwable -> L40
        r27.j = r7.getString(r16);     // Catch: Throwable -> L40
        if (r7.getInt(r17) == 0) goto L19;
        boolean r31 = true;
    L20:
        r27.k = r31;     // Catch: Throwable -> L40
        r27.l = r7.getString(r18);     // Catch: Throwable -> L40
        r27.m = r7.getString(r19);     // Catch: Throwable -> L40
        int r32 = r25;
        if (r7.getInt(r32) == 0) goto L23;
        boolean r33 = true;
    L24:
        r27.n = r33;     // Catch: Throwable -> L40
        int r34 = r111;
        if (r7.getInt(r34) == 0) goto L27;
        boolean r35 = true;
    L28:
        r27.o = r35;     // Catch: Throwable -> L40
        r112 = r112;
        if (r7.getInt(r112) == 0) goto L31;
        boolean r36 = true;
    L32:
        r27.p = r36;     // Catch: Throwable -> L40
        r113 = r113;
        if (r7.getInt(r113) == 0) goto L35;
        boolean r37 = true;
    L36:
        r27.q = r37;     // Catch: Throwable -> L40
        int r38 = r21;
        r27.r = r7.getInt(r38);     // Catch: Throwable -> L40
        int r39 = r22;
        r27.s = r7.getString(r39);     // Catch: Throwable -> L40
        int r40 = r23;
        r27.t = r7.getString(r40);     // Catch: Throwable -> L40
        int r41 = r24;
        r27.u = r7.getString(r41);     // Catch: Throwable -> L40
        r29.add(r27);     // Catch: Throwable -> L40
        r25 = r32;
        r8 = r30;
        r21 = r38;
        r22 = r39;
        r23 = r40;
        r24 = r41;
        r26 = r29;
        r4 = r4;
        r111 = r34;
        r9 = r210;
        goto L15
    L35:
        r37 = false;
        goto L36
    L31:
        r36 = false;
        goto L32
    L27:
        r35 = false;
        goto L28
    L23:
        r33 = false;
        goto L24
    L19:
        r31 = false;
        goto L20
    L38:
        ArrayList r42 = r26;
        r7.close();
        r110.release();
        return r42;
    L40:
        th = th;
    L44:
        r7.close();
        r110.release();
        throw th;
    L42:
        th = th;
        r110 = r3;
        goto L44
    }

    @Override // yq5.f
    public final a h(String r30) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM t_wiki_relation_info WHERE space_id = ?", 1);
        if (r30 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.a.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.a, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r6, "space_id");     // Catch: Throwable -> L46
        int r7 = CursorUtil.getColumnIndexOrThrow(r6, "space_name");     // Catch: Throwable -> L46
        int r8 = CursorUtil.getColumnIndexOrThrow(r6, "space_icon");     // Catch: Throwable -> L46
        int r9 = CursorUtil.getColumnIndexOrThrow(r6, "tenant_id");     // Catch: Throwable -> L46
        int r10 = CursorUtil.getColumnIndexOrThrow(r6, "description");     // Catch: Throwable -> L46
        int r11 = CursorUtil.getColumnIndexOrThrow(r6, "is_star");     // Catch: Throwable -> L46
        int r12 = CursorUtil.getColumnIndexOrThrow(r6, "space_type");     // Catch: Throwable -> L46
        int r13 = CursorUtil.getColumnIndexOrThrow(r6, "wiki_scope");     // Catch: Throwable -> L46
        int r14 = CursorUtil.getColumnIndexOrThrow(r6, "open_sharing");     // Catch: Throwable -> L46
        int r15 = CursorUtil.getColumnIndexOrThrow(r6, "owner_perm_type");     // Catch: Throwable -> L46
        int r3 = CursorUtil.getColumnIndexOrThrow(r6, "create_uid");     // Catch: Throwable -> L46
        int r4 = CursorUtil.getColumnIndexOrThrow(r6, "cover_origin");     // Catch: Throwable -> L46
        int r5 = CursorUtil.getColumnIndexOrThrow(r6, "cover_thumbnail");     // Catch: Throwable -> L46
        int r1 = CursorUtil.getColumnIndexOrThrow(r6, "cover_key");     // Catch: Throwable -> L46
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r6, "cover_is_graph_dark");     // Catch: Throwable -> L44
        int r18 = CursorUtil.getColumnIndexOrThrow(r6, "cover_color_value");     // Catch: Throwable -> L44
        int r19 = CursorUtil.getColumnIndexOrThrow(r6, "view_wiki_collaborator");     // Catch: Throwable -> L44
        int r20 = CursorUtil.getColumnIndexOrThrow(r6, "view_wiki_info");     // Catch: Throwable -> L44
        int r21 = CursorUtil.getColumnIndexOrThrow(r6, "star_wiki");     // Catch: Throwable -> L44
        int r22 = CursorUtil.getColumnIndexOrThrow(r6, "view_wiki_general_info");     // Catch: Throwable -> L44
        int r23 = CursorUtil.getColumnIndexOrThrow(r6, "can_edit_first_level");     // Catch: Throwable -> L44
        int r24 = CursorUtil.getColumnIndexOrThrow(r6, "wiki_homepage_obj_token");     // Catch: Throwable -> L44
        int r25 = CursorUtil.getColumnIndexOrThrow(r6, "wiki_homepage_obj_type");     // Catch: Throwable -> L44
        int r26 = CursorUtil.getColumnIndexOrThrow(r6, "wiki_homepage_wiki_token");     // Catch: Throwable -> L44
        int r27 = CursorUtil.getColumnIndexOrThrow(r6, "wiki_homepage_url");     // Catch: Throwable -> L44
        int r28 = CursorUtil.getColumnIndexOrThrow(r6, "wiki_homepage_title");     // Catch: Throwable -> L44
        if (r6.moveToFirst() == false) goto L41;
        a r29 = new a();     // Catch: Throwable -> L44
        r29.a = r6.getString(r0);     // Catch: Throwable -> L44
        r29.b = r6.getString(r7);     // Catch: Throwable -> L44
        r29.c = r6.getString(r8);     // Catch: Throwable -> L44
        r29.d = r6.getString(r9);     // Catch: Throwable -> L44
        r29.e = r6.getString(r10);     // Catch: Throwable -> L44
        if (r6.getInt(r11) == 0) goto L14;
        boolean r31 = true;
    L15:
        r29.f = r31;     // Catch: Throwable -> L44
        r29.g = r6.getInt(r12);     // Catch: Throwable -> L44
        r29.h = r6.getInt(r13);     // Catch: Throwable -> L44
        r29.i = r6.getInt(r14);     // Catch: Throwable -> L44
        r29.j = r6.getInt(r15);     // Catch: Throwable -> L44
        r29.k = r6.getString(r3);     // Catch: Throwable -> L44
        r29.l = r6.getString(r4);     // Catch: Throwable -> L44
        r29.m = r6.getString(r5);     // Catch: Throwable -> L44
        r29.n = r6.getString(r1);     // Catch: Throwable -> L44
        if (r6.getInt(r17) == 0) goto L18;
        boolean r32 = true;
    L19:
        r29.o = r32;     // Catch: Throwable -> L44
        r29.p = r6.getString(r18);     // Catch: Throwable -> L44
        if (r6.getInt(r19) == 0) goto L22;
        boolean r33 = true;
    L23:
        r29.q = r33;     // Catch: Throwable -> L44
        if (r6.getInt(r20) == 0) goto L26;
        boolean r34 = true;
    L27:
        r29.r = r34;     // Catch: Throwable -> L44
        if (r6.getInt(r21) == 0) goto L30;
        boolean r35 = true;
    L31:
        r29.s = r35;     // Catch: Throwable -> L44
        if (r6.getInt(r22) == 0) goto L34;
        boolean r36 = true;
    L35:
        r29.t = r36;     // Catch: Throwable -> L44
        if (r6.getInt(r23) == 0) goto L38;
        boolean r37 = true;
    L39:
        r29.u = r37;     // Catch: Throwable -> L44
        r29.v = r6.getString(r24);     // Catch: Throwable -> L44
        r29.w = r6.getInt(r25);     // Catch: Throwable -> L44
        r29.x = r6.getString(r26);     // Catch: Throwable -> L44
        r29.y = r6.getString(r27);     // Catch: Throwable -> L44
        r29.z = r6.getString(r28);     // Catch: Throwable -> L44
        a r38 = r29;
    L42:
        r6.close();
        r16.release();
        return r38;
    L38:
        r37 = false;
        goto L39
    L34:
        r36 = false;
        goto L35
    L30:
        r35 = false;
        goto L31
    L26:
        r34 = false;
        goto L27
    L22:
        r33 = false;
        goto L23
    L18:
        r32 = false;
        goto L19
    L14:
        r31 = false;
        goto L15
    L41:
        r38 = null;
    L44:
        th = th;
    L48:
        r6.close();
        r16.release();
        throw th;
    L46:
        th = th;
        r16 = r2;
        goto L48
    L5:
        r2.bindString(1, r30);
        goto L6
    }

    @Override // yq5.f
    public final c i(String r2) {
        this.a.beginTransaction();
        c r3 = n(this, r2);     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        return r3;
    L6:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    @Override // yq5.f
    public final b j(String r25) {
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM t_wiki_relation WHERE space_id = ? AND wiki_node_type = 2 LIMIT 1", 1);
        if (r25 != null) goto L5;
        r2.bindNull(1);
    L6:
        this.a.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.a, r2, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r6, "wiki_token");     // Catch: Throwable -> L38
        int r7 = CursorUtil.getColumnIndexOrThrow(r6, "space_id");     // Catch: Throwable -> L38
        int r8 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L38
        int r9 = CursorUtil.getColumnIndexOrThrow(r6, "obj_type");     // Catch: Throwable -> L38
        int r10 = CursorUtil.getColumnIndexOrThrow(r6, "title");     // Catch: Throwable -> L38
        int r11 = CursorUtil.getColumnIndexOrThrow(r6, "parent_wiki_token");     // Catch: Throwable -> L38
        int r12 = CursorUtil.getColumnIndexOrThrow(r6, "sort_id");     // Catch: Throwable -> L38
        int r13 = CursorUtil.getColumnIndexOrThrow(r6, "wiki_node_type");     // Catch: Throwable -> L38
        int r14 = CursorUtil.getColumnIndexOrThrow(r6, "origin_wiki_token");     // Catch: Throwable -> L38
        int r15 = CursorUtil.getColumnIndexOrThrow(r6, "origin_space_id");     // Catch: Throwable -> L38
        int r3 = CursorUtil.getColumnIndexOrThrow(r6, "is_star");     // Catch: Throwable -> L38
        int r4 = CursorUtil.getColumnIndexOrThrow(r6, "children");     // Catch: Throwable -> L38
        int r5 = CursorUtil.getColumnIndexOrThrow(r6, "space_name");     // Catch: Throwable -> L38
        int r1 = CursorUtil.getColumnIndexOrThrow(r6, "has_child");     // Catch: Throwable -> L38
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r6, "secret_key_delete");     // Catch: Throwable -> L36
        int r18 = CursorUtil.getColumnIndexOrThrow(r6, "is_explorer_star");     // Catch: Throwable -> L36
        int r19 = CursorUtil.getColumnIndexOrThrow(r6, "origin_is_external");     // Catch: Throwable -> L36
        int r20 = CursorUtil.getColumnIndexOrThrow(r6, "entity_delete_flag");     // Catch: Throwable -> L36
        int r21 = CursorUtil.getColumnIndexOrThrow(r6, "document_entity");     // Catch: Throwable -> L36
        int r22 = CursorUtil.getColumnIndexOrThrow(r6, "detail_info");     // Catch: Throwable -> L36
        int r23 = CursorUtil.getColumnIndexOrThrow(r6, "icon_entity");     // Catch: Throwable -> L36
        if (r6.moveToFirst() == false) goto L33;
        b r24 = new b();     // Catch: Throwable -> L36
        r24.a = r6.getString(r0);     // Catch: Throwable -> L36
        r24.b = r6.getString(r7);     // Catch: Throwable -> L36
        r24.c = r6.getString(r8);     // Catch: Throwable -> L36
        r24.d = r6.getInt(r9);     // Catch: Throwable -> L36
        r24.e = r6.getString(r10);     // Catch: Throwable -> L36
        r24.f = r6.getString(r11);     // Catch: Throwable -> L36
        r24.g = r6.getDouble(r12);     // Catch: Throwable -> L36
        r24.h = r6.getInt(r13);     // Catch: Throwable -> L36
        r24.i = r6.getString(r14);     // Catch: Throwable -> L36
        r24.j = r6.getString(r15);     // Catch: Throwable -> L36
        if (r6.getInt(r3) == 0) goto L14;
        boolean r26 = true;
    L15:
        r24.k = r26;     // Catch: Throwable -> L36
        r24.l = r6.getString(r4);     // Catch: Throwable -> L36
        r24.m = r6.getString(r5);     // Catch: Throwable -> L36
        if (r6.getInt(r1) == 0) goto L18;
        boolean r27 = true;
    L19:
        r24.n = r27;     // Catch: Throwable -> L36
        if (r6.getInt(r17) == 0) goto L22;
        boolean r28 = true;
    L23:
        r24.o = r28;     // Catch: Throwable -> L36
        if (r6.getInt(r18) == 0) goto L26;
        boolean r29 = true;
    L27:
        r24.p = r29;     // Catch: Throwable -> L36
        if (r6.getInt(r19) == 0) goto L30;
        boolean r30 = true;
    L31:
        r24.q = r30;     // Catch: Throwable -> L36
        r24.r = r6.getInt(r20);     // Catch: Throwable -> L36
        r24.s = r6.getString(r21);     // Catch: Throwable -> L36
        r24.t = r6.getString(r22);     // Catch: Throwable -> L36
        r24.u = r6.getString(r23);     // Catch: Throwable -> L36
        b r31 = r24;
    L34:
        r6.close();
        r16.release();
        return r31;
    L30:
        r30 = false;
        goto L31
    L26:
        r29 = false;
        goto L27
    L22:
        r28 = false;
        goto L23
    L18:
        r27 = false;
        goto L19
    L14:
        r26 = false;
        goto L15
    L33:
        r31 = null;
    L36:
        th = th;
    L40:
        r6.close();
        r16.release();
        throw th;
    L38:
        th = th;
        r16 = r2;
        goto L40
    L5:
        r2.bindString(1, r25);
        goto L6
    }

    @Override // yq5.f
    public final void k(a r2) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        this.c.insert(r2);     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    @Override // yq5.f
    public final void l(List<b> r2) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        this.f.handleMultiple(r2);     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    public final int r(String r3) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.i.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        this.a.beginTransaction();
        int r4 = r0.executeUpdateDelete();     // Catch: Throwable -> L10
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.a.endTransaction();
        this.i.release(r0);
        return r4;
    L10:
        th = move-exception;
        this.a.endTransaction();
        this.i.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    public final void t(List<b> r2) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        this.b.insert(r2);     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    public final void u(List<b> r2) {
        this.a.assertNotSuspendingTransaction();
        this.a.beginTransaction();
        this.b.insert(r2);     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    public static c n(q r27, String r28) {
        r27.getClass();
        RoomSQLiteQuery r2 = RoomSQLiteQuery.acquire("SELECT * FROM t_wiki_relation WHERE space_id = ?", 1);
        if (r28 != null) goto L5;
        r2.bindNull(1);
    L6:
        r27.a.assertNotSuspendingTransaction();
        Cursor r4 = DBUtil.query(r27.a, r2, false, null);
        int r5 = CursorUtil.getColumnIndexOrThrow(r4, "wiki_token");     // Catch: Throwable -> L38
        int r7 = CursorUtil.getColumnIndexOrThrow(r4, "space_id");     // Catch: Throwable -> L38
        int r8 = CursorUtil.getColumnIndexOrThrow(r4, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L38
        int r9 = CursorUtil.getColumnIndexOrThrow(r4, "obj_type");     // Catch: Throwable -> L38
        int r10 = CursorUtil.getColumnIndexOrThrow(r4, "title");     // Catch: Throwable -> L38
        int r11 = CursorUtil.getColumnIndexOrThrow(r4, "parent_wiki_token");     // Catch: Throwable -> L38
        int r12 = CursorUtil.getColumnIndexOrThrow(r4, "sort_id");     // Catch: Throwable -> L38
        int r13 = CursorUtil.getColumnIndexOrThrow(r4, "wiki_node_type");     // Catch: Throwable -> L38
        int r14 = CursorUtil.getColumnIndexOrThrow(r4, "origin_wiki_token");     // Catch: Throwable -> L38
        int r15 = CursorUtil.getColumnIndexOrThrow(r4, "origin_space_id");     // Catch: Throwable -> L38
        int r3 = CursorUtil.getColumnIndexOrThrow(r4, "is_star");     // Catch: Throwable -> L38
        int r6 = CursorUtil.getColumnIndexOrThrow(r4, "children");     // Catch: Throwable -> L38
        int r0 = CursorUtil.getColumnIndexOrThrow(r4, "space_name");     // Catch: Throwable -> L38
        int r1 = CursorUtil.getColumnIndexOrThrow(r4, "has_child");     // Catch: Throwable -> L38
        RoomSQLiteQuery r16 = r2;
        int r17 = CursorUtil.getColumnIndexOrThrow(r4, "secret_key_delete");     // Catch: Throwable -> L36
        int r18 = CursorUtil.getColumnIndexOrThrow(r4, "is_explorer_star");     // Catch: Throwable -> L36
        int r19 = CursorUtil.getColumnIndexOrThrow(r4, "origin_is_external");     // Catch: Throwable -> L36
        int r20 = CursorUtil.getColumnIndexOrThrow(r4, "entity_delete_flag");     // Catch: Throwable -> L36
        int r21 = CursorUtil.getColumnIndexOrThrow(r4, "document_entity");     // Catch: Throwable -> L36
        int r22 = CursorUtil.getColumnIndexOrThrow(r4, "detail_info");     // Catch: Throwable -> L36
        int r23 = CursorUtil.getColumnIndexOrThrow(r4, "icon_entity");     // Catch: Throwable -> L36
        int r24 = r1;
        ArrayList r25 = new ArrayList(r4.getCount());     // Catch: Throwable -> L36
    L11:
        if (r4.moveToNext() == false) goto L34;
        b r26 = new b();     // Catch: Throwable -> L36
        ArrayList r29 = r25;
        r26.a = r4.getString(r5);     // Catch: Throwable -> L36
        r26.b = r4.getString(r7);     // Catch: Throwable -> L36
        r26.c = r4.getString(r8);     // Catch: Throwable -> L36
        r26.d = r4.getInt(r9);     // Catch: Throwable -> L36
        r26.e = r4.getString(r10);     // Catch: Throwable -> L36
        r26.f = r4.getString(r11);     // Catch: Throwable -> L36
        int r30 = r7;
        int r210 = r8;
        r26.g = r4.getDouble(r12);     // Catch: Throwable -> L36
        r26.h = r4.getInt(r13);     // Catch: Throwable -> L36
        r26.i = r4.getString(r14);     // Catch: Throwable -> L36
        r26.j = r4.getString(r15);     // Catch: Throwable -> L36
        if (r4.getInt(r3) == 0) goto L15;
        boolean r31 = true;
    L16:
        r26.k = r31;     // Catch: Throwable -> L36
        r26.l = r4.getString(r6);     // Catch: Throwable -> L36
        r26.m = r4.getString(r0);     // Catch: Throwable -> L36
        int r32 = r24;
        if (r4.getInt(r32) == 0) goto L19;
        boolean r33 = true;
    L20:
        r26.n = r33;     // Catch: Throwable -> L36
        int r34 = r17;
        if (r4.getInt(r34) == 0) goto L23;
        boolean r35 = true;
    L24:
        r26.o = r35;     // Catch: Throwable -> L36
        r18 = r18;
        if (r4.getInt(r18) == 0) goto L27;
        boolean r36 = true;
    L28:
        r26.p = r36;     // Catch: Throwable -> L36
        r19 = r19;
        if (r4.getInt(r19) == 0) goto L31;
        boolean r37 = true;
    L32:
        r26.q = r37;     // Catch: Throwable -> L36
        int r38 = r20;
        r26.r = r4.getInt(r38);     // Catch: Throwable -> L36
        int r39 = r21;
        r26.s = r4.getString(r39);     // Catch: Throwable -> L36
        int r40 = r22;
        r26.t = r4.getString(r40);     // Catch: Throwable -> L36
        int r41 = r23;
        r26.u = r4.getString(r41);     // Catch: Throwable -> L36
        r29.add(r26);     // Catch: Throwable -> L36
        r24 = r32;
        r7 = r30;
        r20 = r38;
        r21 = r39;
        r22 = r40;
        r23 = r41;
        r25 = r29;
        r0 = r0;
        r17 = r34;
        r8 = r210;
        goto L11
    L31:
        r37 = false;
        goto L32
    L27:
        r36 = false;
        goto L28
    L23:
        r35 = false;
        goto L24
    L19:
        r33 = false;
        goto L20
    L15:
        r31 = false;
        goto L16
    L34:
        ArrayList r42 = r25;
        r4.close();
        r16.release();
        a r43 = r27.h(r28);
        c r44 = new c();
        r44.b = r42;
        r44.a = r43;
        return r44;
    L36:
        th = th;
    L40:
        r4.close();
        r16.release();
        throw th;
    L38:
        th = th;
        r16 = r2;
        goto L40
    L5:
        r2.bindString(1, r28);
        goto L6
    }

    public static void o(q r4, VirtualNode r5) {
        r4.getClass();
        b r6 = r4.s(r5.getSpaceId(), r5.getRootToken());
        if (r6 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r6.l) == true) goto L25;
        ArrayList<String> r7 = s.a(r6);     // Catch: Exception -> L17
        if (hu5.a.d(r7) == true) goto L26;
        List<b> r8 = r4.g(r7);     // Catch: Exception -> L17
        int r0 = ((ArrayList) r8).size();     // Catch: Exception -> L17
        b[] r1 = new b[r0];     // Catch: Exception -> L17
        int r2 = 0;
    L9:
        if (r2 >= r0) goto L11;
        r1[r2] = (b) ListProtector.get(r8, r2);     // Catch: Exception -> L17
        r2 = r2 + 1;     // Catch: Exception -> L17
        goto L9
    L11:
        r4.a.assertNotSuspendingTransaction();     // Catch: Exception -> L17
        r4.a.beginTransaction();     // Catch: Exception -> L17
        r4.e.handleMultiple(r1);     // Catch: Throwable -> L14
        r4.a.setTransactionSuccessful();     // Catch: Throwable -> L14
        r4.a.endTransaction();     // Catch: Exception -> L17
        return;
    L14:
        th = move-exception;
        r4.a.endTransaction();     // Catch: Exception -> L17
        throw th;     // Catch: Exception -> L17
    L26:
        return;
    L17:
        e = move-exception;
        tt5.a.d("DBTreeNode", "deleteAndInsertVirtualRelation, delete node fail: " + e);
        return;
    }

    public static void p(q r2, String r3) {
        r2.r(r3);
        r2.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = r2.j.acquire();
        if (r3 != null) goto L5;
        r0.bindNull(1);
    L6:
        r2.a.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L10
        r2.a.setTransactionSuccessful();     // Catch: Throwable -> L10
        r2.a.endTransaction();
        r2.j.release(r0);
        return;
    L10:
        th = move-exception;
        r2.a.endTransaction();
        r2.j.release(r0);
        throw th;
    L5:
        r0.bindString(1, r3);
        goto L6
    }

    @Override // yq5.f
    public final void b(VirtualNode r2, c r3) {
        this.a.beginTransaction();
    L11:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    L4:
        if (hu5.a.d(r3.b) == false) goto L6;
    L8:
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L11
        this.a.endTransaction();
        return;
    L6:
        if (r3.a == null) goto L8;
        f(r2);     // Catch: Throwable -> L11
        u(r3.b);     // Catch: Throwable -> L11
        k(r3.a);     // Catch: Throwable -> L11
        goto L8
    }

    @Override // yq5.f
    public final int c(String r3, List<String> r4) {
        this.a.assertNotSuspendingTransaction();
        StringBuilder r0 = StringUtil.newStringBuilder();
        r0.append("DELETE FROM t_wiki_relation WHERE space_id = ");
        r0.append("?");
        r0.append(" AND wiki_token IN (");
        StringUtil.appendPlaceholders(r0, r4.size());
        r0.append(")");
        String r1 = r0.toString();
        SupportSQLiteStatement r2 = this.a.compileStatement(r1);
        if (r3 != null) goto L5;
        r2.bindNull(1);
    L6:
        Iterator<String> r5 = r4.iterator();
        int r6 = 2;
    L8:
        if (r5.hasNext() == false) goto L14;
        String r7 = r5.next();
        if (r7 != null) goto L12;
        r2.bindNull(r6);
    L13:
        r6 = r6 + 1;
        goto L8
    L12:
        r2.bindString(r6, r7);
        goto L13
    L14:
        this.a.beginTransaction();
        int r8 = r2.executeUpdateDelete();     // Catch: Throwable -> L18
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L18
        this.a.endTransaction();
        return r8;
    L18:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    L5:
        r2.bindString(1, r3);
        goto L6
    }

    public final b s(String r25, String r26) {
        RoomSQLiteQuery r3 = RoomSQLiteQuery.acquire("SELECT * FROM t_wiki_relation WHERE space_id = ? AND wiki_token = ?", 2);
        if (r25 != null) goto L5;
        r3.bindNull(1);
    L6:
        if (r26 != null) goto L8;
        r3.bindNull(2);
    L9:
        this.a.assertNotSuspendingTransaction();
        Cursor r6 = DBUtil.query(this.a, r3, false, null);
        int r0 = CursorUtil.getColumnIndexOrThrow(r6, "wiki_token");     // Catch: Throwable -> L41
        int r7 = CursorUtil.getColumnIndexOrThrow(r6, "space_id");     // Catch: Throwable -> L41
        int r8 = CursorUtil.getColumnIndexOrThrow(r6, ResourceData.KEY_OBJ_TOKEN);     // Catch: Throwable -> L41
        int r9 = CursorUtil.getColumnIndexOrThrow(r6, "obj_type");     // Catch: Throwable -> L41
        int r10 = CursorUtil.getColumnIndexOrThrow(r6, "title");     // Catch: Throwable -> L41
        int r11 = CursorUtil.getColumnIndexOrThrow(r6, "parent_wiki_token");     // Catch: Throwable -> L41
        int r12 = CursorUtil.getColumnIndexOrThrow(r6, "sort_id");     // Catch: Throwable -> L41
        int r13 = CursorUtil.getColumnIndexOrThrow(r6, "wiki_node_type");     // Catch: Throwable -> L41
        int r14 = CursorUtil.getColumnIndexOrThrow(r6, "origin_wiki_token");     // Catch: Throwable -> L41
        int r15 = CursorUtil.getColumnIndexOrThrow(r6, "origin_space_id");     // Catch: Throwable -> L41
        int r2 = CursorUtil.getColumnIndexOrThrow(r6, "is_star");     // Catch: Throwable -> L41
        int r4 = CursorUtil.getColumnIndexOrThrow(r6, "children");     // Catch: Throwable -> L41
        int r5 = CursorUtil.getColumnIndexOrThrow(r6, "space_name");     // Catch: Throwable -> L41
        int r1 = CursorUtil.getColumnIndexOrThrow(r6, "has_child");     // Catch: Throwable -> L41
        RoomSQLiteQuery r16 = r3;
        int r17 = CursorUtil.getColumnIndexOrThrow(r6, "secret_key_delete");     // Catch: Throwable -> L39
        int r18 = CursorUtil.getColumnIndexOrThrow(r6, "is_explorer_star");     // Catch: Throwable -> L39
        int r19 = CursorUtil.getColumnIndexOrThrow(r6, "origin_is_external");     // Catch: Throwable -> L39
        int r20 = CursorUtil.getColumnIndexOrThrow(r6, "entity_delete_flag");     // Catch: Throwable -> L39
        int r21 = CursorUtil.getColumnIndexOrThrow(r6, "document_entity");     // Catch: Throwable -> L39
        int r22 = CursorUtil.getColumnIndexOrThrow(r6, "detail_info");     // Catch: Throwable -> L39
        int r23 = CursorUtil.getColumnIndexOrThrow(r6, "icon_entity");     // Catch: Throwable -> L39
        if (r6.moveToFirst() == false) goto L36;
        b r24 = new b();     // Catch: Throwable -> L39
        r24.a = r6.getString(r0);     // Catch: Throwable -> L39
        r24.b = r6.getString(r7);     // Catch: Throwable -> L39
        r24.c = r6.getString(r8);     // Catch: Throwable -> L39
        r24.d = r6.getInt(r9);     // Catch: Throwable -> L39
        r24.e = r6.getString(r10);     // Catch: Throwable -> L39
        r24.f = r6.getString(r11);     // Catch: Throwable -> L39
        r24.g = r6.getDouble(r12);     // Catch: Throwable -> L39
        r24.h = r6.getInt(r13);     // Catch: Throwable -> L39
        r24.i = r6.getString(r14);     // Catch: Throwable -> L39
        r24.j = r6.getString(r15);     // Catch: Throwable -> L39
        if (r6.getInt(r2) == 0) goto L17;
        boolean r27 = true;
    L18:
        r24.k = r27;     // Catch: Throwable -> L39
        r24.l = r6.getString(r4);     // Catch: Throwable -> L39
        r24.m = r6.getString(r5);     // Catch: Throwable -> L39
        if (r6.getInt(r1) == 0) goto L21;
        boolean r28 = true;
    L22:
        r24.n = r28;     // Catch: Throwable -> L39
        if (r6.getInt(r17) == 0) goto L25;
        boolean r29 = true;
    L26:
        r24.o = r29;     // Catch: Throwable -> L39
        if (r6.getInt(r18) == 0) goto L29;
        boolean r30 = true;
    L30:
        r24.p = r30;     // Catch: Throwable -> L39
        if (r6.getInt(r19) == 0) goto L33;
        boolean r31 = true;
    L34:
        r24.q = r31;     // Catch: Throwable -> L39
        r24.r = r6.getInt(r20);     // Catch: Throwable -> L39
        r24.s = r6.getString(r21);     // Catch: Throwable -> L39
        r24.t = r6.getString(r22);     // Catch: Throwable -> L39
        r24.u = r6.getString(r23);     // Catch: Throwable -> L39
        b r32 = r24;
    L37:
        r6.close();
        r16.release();
        return r32;
    L33:
        r31 = false;
        goto L34
    L29:
        r30 = false;
        goto L30
    L25:
        r29 = false;
        goto L26
    L21:
        r28 = false;
        goto L22
    L17:
        r27 = false;
        goto L18
    L36:
        r32 = null;
    L39:
        th = th;
    L43:
        r6.close();
        r16.release();
        throw th;
    L41:
        th = th;
        r16 = r3;
        goto L43
    L8:
        r3.bindString(2, r26);
        goto L9
    L5:
        r3.bindString(1, r25);
        goto L6
    }

    public static void q(q r1, b r2, List r3) {
        r1.getClass();
        r1.a.assertNotSuspendingTransaction();
        r1.a.beginTransaction();
        r1.d.insert(r3);     // Catch: Throwable -> L6
        r1.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        r1.a.endTransaction();
        r1.t(CollectionsKt.arrayListOf(new b[]{r2}));
        return;
    L6:
        th = move-exception;
        r1.a.endTransaction();
        throw th;
    }

    @Override // yq5.f
    public final void d(String r2, List<String> r3, List<b> r4) {
        this.a.beginTransaction();
        c(r2, r3);     // Catch: Throwable -> L6
        l(r4);     // Catch: Throwable -> L6
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L6
        this.a.endTransaction();
        return;
    L6:
        th = move-exception;
        this.a.endTransaction();
        throw th;
    }

    @Override // yq5.f
    public final void m(String r3, String r4, String r5, String r6) {
        this.a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r0 = this.g.acquire();
        if (r5 != null) goto L5;
        r0.bindNull(1);
    L7:
        if (r6 != null) goto L9;
        r0.bindNull(2);
    L11:
        if (r3 != null) goto L13;
        r0.bindNull(3);
    L15:
        if (r4 != null) goto L17;
        r0.bindNull(4);
    L18:
        this.a.beginTransaction();
        r0.executeUpdateDelete();     // Catch: Throwable -> L22
        this.a.setTransactionSuccessful();     // Catch: Throwable -> L22
        this.a.endTransaction();
        this.g.release(r0);
        return;
    L22:
        th = move-exception;
        this.a.endTransaction();
        this.g.release(r0);
        throw th;
    L17:
        r0.bindString(4, r4);
        goto L18
    L13:
        r0.bindString(3, r3);
        goto L15
    L9:
        r0.bindString(2, r6);
        goto L11
    L5:
        r0.bindString(1, r5);
        goto L7
    }
}
