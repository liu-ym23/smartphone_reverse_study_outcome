package mc5;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.lark.aidl.DocCallbackImpl;
import com.bytedance.ee.bear.list.cache.BearDatabase;
import com.ss.android.downloadlib.constants.EventConstants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final class j3 implements c3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f513085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d3 f513086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e3 f513087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f3 f513088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g3 f513089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h3 f513090f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i3 f513091g;

    public final List<b3> b() {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM WikiSpace ORDER BY browse_time DESC", 0);
        this.f513085a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f513085a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, DocViewModel.EXTRA_SPACE_ID);     // Catch: Throwable -> L22
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, "user_id");     // Catch: Throwable -> L22
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "space_name");     // Catch: Throwable -> L22
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "space_icon");     // Catch: Throwable -> L22
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, SlcElement.KEY_ATTR);     // Catch: Throwable -> L22
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, "description");     // Catch: Throwable -> L22
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, EventConstants.ExtraJson.EXTRA_IS_STAR);     // Catch: Throwable -> L22
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, "browse_time");     // Catch: Throwable -> L22
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "wiki_token");     // Catch: Throwable -> L22
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "obj_type");     // Catch: Throwable -> L22
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "obj_token");     // Catch: Throwable -> L22
        int r115 = CursorUtil.getColumnIndexOrThrow(r101, PlayerResolution.SDKKEY.ORIGIN);     // Catch: Throwable -> L22
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, DocCallbackImpl.KEY_THUMBNAIL);     // Catch: Throwable -> L22
        int r109 = CursorUtil.getColumnIndexOrThrow(r101, "cover_key");     // Catch: Throwable -> L22
        RoomSQLiteQuery r116 = r100;
        int r117 = CursorUtil.getColumnIndexOrThrow(r101, "is_graph_dark");     // Catch: Throwable -> L20
        int r118 = CursorUtil.getColumnIndexOrThrow(r101, "color_value");     // Catch: Throwable -> L20
        int r119 = CursorUtil.getColumnIndexOrThrow(r101, "wiki_scope");     // Catch: Throwable -> L20
        int r210 = CursorUtil.getColumnIndexOrThrow(r101, "space_type");     // Catch: Throwable -> L20
        int r211 = CursorUtil.getColumnIndexOrThrow(r101, "open_sharing");     // Catch: Throwable -> L20
        int r212 = CursorUtil.getColumnIndexOrThrow(r101, com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE);     // Catch: Throwable -> L20
        int r213 = CursorUtil.getColumnIndexOrThrow(r101, "tag_value");     // Catch: Throwable -> L20
        int r214 = r109;
        ArrayList r120 = new ArrayList(r101.getCount());     // Catch: Throwable -> L20
    L7:
        if (r101.moveToNext() == false) goto L18;
        b3 r121 = new b3();     // Catch: Throwable -> L20
        ArrayList r215 = r120;
        r121.f512923a = r101.getString(r102);     // Catch: Throwable -> L20
        r121.f512924b = r101.getString(r103);     // Catch: Throwable -> L20
        r121.f512925c = r101.getString(r104);     // Catch: Throwable -> L20
        r121.f512926d = r101.getString(r105);     // Catch: Throwable -> L20
        r121.f512927e = r101.getInt(r106);     // Catch: Throwable -> L20
        r121.f512928f = r101.getString(r107);     // Catch: Throwable -> L20
        if (r101.getInt(r110) == 0) goto L11;
        boolean r122 = true;
    L12:
        r121.f512929g = r122;     // Catch: Throwable -> L20
        r121.f512930h = r101.getString(r111);     // Catch: Throwable -> L20
        r121.f512931i = r101.getString(r112);     // Catch: Throwable -> L20
        r121.f512932j = r101.getInt(r113);     // Catch: Throwable -> L20
        r121.f512933k = r101.getString(r114);     // Catch: Throwable -> L20
        r121.f512934l = r101.getString(r115);     // Catch: Throwable -> L20
        r121.f512935m = r101.getString(r108);     // Catch: Throwable -> L20
        int r123 = r214;
        int r216 = r102;
        r121.f512936n = r101.getString(r123);     // Catch: Throwable -> L20
        r117 = r117;
        if (r101.getInt(r117) == 0) goto L15;
        boolean r124 = true;
    L16:
        r121.f512937o = r124;     // Catch: Throwable -> L20
        int r125 = r118;
        int r126 = r108;
        r121.f512938p = r101.getString(r125);     // Catch: Throwable -> L20
        int r127 = r119;
        r121.f512939q = r101.getInt(r127);     // Catch: Throwable -> L20
        int r128 = r210;
        r121.f512940r = r101.getInt(r128);     // Catch: Throwable -> L20
        int r129 = r211;
        r121.f512941s = r101.getInt(r129);     // Catch: Throwable -> L20
        int r130 = r212;
        r121.f512942t = r101.getInt(r130);     // Catch: Throwable -> L20
        int r131 = r213;
        r121.f512943u = r101.getString(r131);     // Catch: Throwable -> L20
        r215.add(r121);     // Catch: Throwable -> L20
        r120 = r215;
        r102 = r216;
        r214 = r123;
        r213 = r131;
        r108 = r126;
        r118 = r125;
        r119 = r127;
        r210 = r128;
        r211 = r129;
        r212 = r130;
        goto L7
    L15:
        r124 = false;
        goto L16
    L11:
        r122 = false;
        goto L12
    L18:
        ArrayList r132 = r120;
        r101.close();
        r116.release();
        return r132;
    L20:
        th = th;
    L24:
        r101.close();
        r116.release();
        throw th;
    L22:
        th = th;
        r116 = r100;
        goto L24
    }

    public j3(BearDatabase r100) {
        this.f513085a = r100;
        this.f513086b = new d3(r100);
        this.f513087c = new e3(r100);
        this.f513088d = new f3(r100);
        this.f513089e = new g3(r100);
        this.f513090f = new h3(r100);
        this.f513091g = new i3(r100);
    }

    public final int a(String r100) {
        this.f513085a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r101 = this.f513088d.acquire();
        if (r100 != null) goto L5;
        r101.bindNull(1);
    L6:
        this.f513085a.beginTransaction();
        int r102 = r101.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f513085a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.f513085a.endTransaction();
        this.f513088d.release(r101);
        return r102;
    L10:
        th = move-exception;
        this.f513085a.endTransaction();
        this.f513088d.release(r101);
        throw th;
    L5:
        r101.bindString(1, r100);
        goto L6
    }

    public final List<b3> c(int r210) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM WikiSpace WHERE space_type=? ORDER BY browse_time DESC", 1);
        r100.bindLong(1, r210);
        this.f513085a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f513085a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, DocViewModel.EXTRA_SPACE_ID);     // Catch: Throwable -> L22
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, "user_id");     // Catch: Throwable -> L22
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "space_name");     // Catch: Throwable -> L22
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "space_icon");     // Catch: Throwable -> L22
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, SlcElement.KEY_ATTR);     // Catch: Throwable -> L22
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, "description");     // Catch: Throwable -> L22
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, EventConstants.ExtraJson.EXTRA_IS_STAR);     // Catch: Throwable -> L22
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, "browse_time");     // Catch: Throwable -> L22
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "wiki_token");     // Catch: Throwable -> L22
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "obj_type");     // Catch: Throwable -> L22
        int r115 = CursorUtil.getColumnIndexOrThrow(r101, "obj_token");     // Catch: Throwable -> L22
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, PlayerResolution.SDKKEY.ORIGIN);     // Catch: Throwable -> L22
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, DocCallbackImpl.KEY_THUMBNAIL);     // Catch: Throwable -> L22
        int r109 = CursorUtil.getColumnIndexOrThrow(r101, "cover_key");     // Catch: Throwable -> L22
        RoomSQLiteQuery r116 = r100;
        int r117 = CursorUtil.getColumnIndexOrThrow(r101, "is_graph_dark");     // Catch: Throwable -> L20
        int r118 = CursorUtil.getColumnIndexOrThrow(r101, "color_value");     // Catch: Throwable -> L20
        int r119 = CursorUtil.getColumnIndexOrThrow(r101, "wiki_scope");     // Catch: Throwable -> L20
        int r211 = CursorUtil.getColumnIndexOrThrow(r101, "space_type");     // Catch: Throwable -> L20
        int r212 = CursorUtil.getColumnIndexOrThrow(r101, "open_sharing");     // Catch: Throwable -> L20
        int r213 = CursorUtil.getColumnIndexOrThrow(r101, com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE);     // Catch: Throwable -> L20
        int r214 = CursorUtil.getColumnIndexOrThrow(r101, "tag_value");     // Catch: Throwable -> L20
        int r215 = r109;
        ArrayList r120 = new ArrayList(r101.getCount());     // Catch: Throwable -> L20
    L7:
        if (r101.moveToNext() == false) goto L18;
        b3 r121 = new b3();     // Catch: Throwable -> L20
        ArrayList r216 = r120;
        r121.f512923a = r101.getString(r102);     // Catch: Throwable -> L20
        r121.f512924b = r101.getString(r103);     // Catch: Throwable -> L20
        r121.f512925c = r101.getString(r104);     // Catch: Throwable -> L20
        r121.f512926d = r101.getString(r105);     // Catch: Throwable -> L20
        r121.f512927e = r101.getInt(r106);     // Catch: Throwable -> L20
        r121.f512928f = r101.getString(r110);     // Catch: Throwable -> L20
        if (r101.getInt(r111) == 0) goto L11;
        boolean r122 = true;
    L12:
        r121.f512929g = r122;     // Catch: Throwable -> L20
        r121.f512930h = r101.getString(r112);     // Catch: Throwable -> L20
        r121.f512931i = r101.getString(r113);     // Catch: Throwable -> L20
        r121.f512932j = r101.getInt(r114);     // Catch: Throwable -> L20
        r121.f512933k = r101.getString(r115);     // Catch: Throwable -> L20
        r121.f512934l = r101.getString(r107);     // Catch: Throwable -> L20
        r121.f512935m = r101.getString(r108);     // Catch: Throwable -> L20
        int r123 = r215;
        int r217 = r102;
        r121.f512936n = r101.getString(r123);     // Catch: Throwable -> L20
        r117 = r117;
        if (r101.getInt(r117) == 0) goto L15;
        boolean r124 = true;
    L16:
        r121.f512937o = r124;     // Catch: Throwable -> L20
        int r125 = r118;
        int r126 = r107;
        r121.f512938p = r101.getString(r125);     // Catch: Throwable -> L20
        int r127 = r119;
        r121.f512939q = r101.getInt(r127);     // Catch: Throwable -> L20
        int r128 = r211;
        r121.f512940r = r101.getInt(r128);     // Catch: Throwable -> L20
        int r129 = r212;
        r121.f512941s = r101.getInt(r129);     // Catch: Throwable -> L20
        int r130 = r213;
        r121.f512942t = r101.getInt(r130);     // Catch: Throwable -> L20
        int r131 = r214;
        r121.f512943u = r101.getString(r131);     // Catch: Throwable -> L20
        r216.add(r121);     // Catch: Throwable -> L20
        r120 = r216;
        r102 = r217;
        r215 = r123;
        r214 = r131;
        r107 = r126;
        r118 = r125;
        r119 = r127;
        r211 = r128;
        r212 = r129;
        r213 = r130;
        goto L7
    L15:
        r124 = false;
        goto L16
    L11:
        r122 = false;
        goto L12
    L18:
        ArrayList r132 = r120;
        r101.close();
        r116.release();
        return r132;
    L20:
        th = th;
    L24:
        r101.close();
        r116.release();
        throw th;
    L22:
        th = th;
        r116 = r100;
        goto L24
    }

    public final b3 d(String r210) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM WikiSpace WHERE space_id=?", 1);
        if (r210 != null) goto L5;
        r100.bindNull(1);
    L6:
        this.f513085a.assertNotSuspendingTransaction();
        Cursor r101 = DBUtil.query(this.f513085a, r100, false, null);
        int r102 = CursorUtil.getColumnIndexOrThrow(r101, DocViewModel.EXTRA_SPACE_ID);     // Catch: Throwable -> L26
        int r103 = CursorUtil.getColumnIndexOrThrow(r101, "user_id");     // Catch: Throwable -> L26
        int r104 = CursorUtil.getColumnIndexOrThrow(r101, "space_name");     // Catch: Throwable -> L26
        int r105 = CursorUtil.getColumnIndexOrThrow(r101, "space_icon");     // Catch: Throwable -> L26
        int r110 = CursorUtil.getColumnIndexOrThrow(r101, SlcElement.KEY_ATTR);     // Catch: Throwable -> L26
        int r111 = CursorUtil.getColumnIndexOrThrow(r101, "description");     // Catch: Throwable -> L26
        int r112 = CursorUtil.getColumnIndexOrThrow(r101, EventConstants.ExtraJson.EXTRA_IS_STAR);     // Catch: Throwable -> L26
        int r113 = CursorUtil.getColumnIndexOrThrow(r101, "browse_time");     // Catch: Throwable -> L26
        int r114 = CursorUtil.getColumnIndexOrThrow(r101, "wiki_token");     // Catch: Throwable -> L26
        int r115 = CursorUtil.getColumnIndexOrThrow(r101, "obj_type");     // Catch: Throwable -> L26
        int r106 = CursorUtil.getColumnIndexOrThrow(r101, "obj_token");     // Catch: Throwable -> L26
        int r107 = CursorUtil.getColumnIndexOrThrow(r101, PlayerResolution.SDKKEY.ORIGIN);     // Catch: Throwable -> L26
        int r108 = CursorUtil.getColumnIndexOrThrow(r101, DocCallbackImpl.KEY_THUMBNAIL);     // Catch: Throwable -> L26
        int r109 = CursorUtil.getColumnIndexOrThrow(r101, "cover_key");     // Catch: Throwable -> L26
        RoomSQLiteQuery r116 = r100;
        int r117 = CursorUtil.getColumnIndexOrThrow(r101, "is_graph_dark");     // Catch: Throwable -> L24
        int r118 = CursorUtil.getColumnIndexOrThrow(r101, "color_value");     // Catch: Throwable -> L24
        int r119 = CursorUtil.getColumnIndexOrThrow(r101, "wiki_scope");     // Catch: Throwable -> L24
        int r120 = CursorUtil.getColumnIndexOrThrow(r101, "space_type");     // Catch: Throwable -> L24
        int r121 = CursorUtil.getColumnIndexOrThrow(r101, "open_sharing");     // Catch: Throwable -> L24
        int r122 = CursorUtil.getColumnIndexOrThrow(r101, com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE);     // Catch: Throwable -> L24
        int r123 = CursorUtil.getColumnIndexOrThrow(r101, "tag_value");     // Catch: Throwable -> L24
        if (r101.moveToFirst() == false) goto L21;
        b3 r124 = new b3();     // Catch: Throwable -> L24
        r124.f512923a = r101.getString(r102);     // Catch: Throwable -> L24
        r124.f512924b = r101.getString(r103);     // Catch: Throwable -> L24
        r124.f512925c = r101.getString(r104);     // Catch: Throwable -> L24
        r124.f512926d = r101.getString(r105);     // Catch: Throwable -> L24
        r124.f512927e = r101.getInt(r110);     // Catch: Throwable -> L24
        r124.f512928f = r101.getString(r111);     // Catch: Throwable -> L24
        if (r101.getInt(r112) == 0) goto L14;
        boolean r125 = true;
    L15:
        r124.f512929g = r125;     // Catch: Throwable -> L24
        r124.f512930h = r101.getString(r113);     // Catch: Throwable -> L24
        r124.f512931i = r101.getString(r114);     // Catch: Throwable -> L24
        r124.f512932j = r101.getInt(r115);     // Catch: Throwable -> L24
        r124.f512933k = r101.getString(r106);     // Catch: Throwable -> L24
        r124.f512934l = r101.getString(r107);     // Catch: Throwable -> L24
        r124.f512935m = r101.getString(r108);     // Catch: Throwable -> L24
        r124.f512936n = r101.getString(r109);     // Catch: Throwable -> L24
        if (r101.getInt(r117) == 0) goto L18;
        boolean r126 = true;
    L19:
        r124.f512937o = r126;     // Catch: Throwable -> L24
        r124.f512938p = r101.getString(r118);     // Catch: Throwable -> L24
        r124.f512939q = r101.getInt(r119);     // Catch: Throwable -> L24
        r124.f512940r = r101.getInt(r120);     // Catch: Throwable -> L24
        r124.f512941s = r101.getInt(r121);     // Catch: Throwable -> L24
        r124.f512942t = r101.getInt(r122);     // Catch: Throwable -> L24
        r124.f512943u = r101.getString(r123);     // Catch: Throwable -> L24
        b3 r127 = r124;
    L22:
        r101.close();
        r116.release();
        return r127;
    L18:
        r126 = false;
        goto L19
    L14:
        r125 = false;
        goto L15
    L21:
        r127 = null;
    L24:
        th = th;
    L28:
        r101.close();
        r116.release();
        throw th;
    L26:
        th = th;
        r116 = r100;
        goto L28
    L5:
        r100.bindString(1, r210);
        goto L6
    }

    public final int e(String r100, boolean r101) {
        this.f513085a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r102 = this.f513090f.acquire();
        r102.bindLong(1, r101 ? 1 : 0);
        if (r100 != null) goto L5;
        r102.bindNull(2);
    L6:
        this.f513085a.beginTransaction();
        int r103 = r102.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f513085a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.f513085a.endTransaction();
        this.f513090f.release(r102);
        return r103;
    L10:
        th = move-exception;
        this.f513085a.endTransaction();
        this.f513090f.release(r102);
        throw th;
    L5:
        r102.bindString(2, r100);
        goto L6
    }

    public final int f(String r100, boolean r101) {
        this.f513085a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r102 = this.f513091g.acquire();
        r102.bindLong(1, r101 ? 1 : 0);
        if (r100 != null) goto L5;
        r102.bindNull(2);
    L6:
        this.f513085a.beginTransaction();
        int r103 = r102.executeUpdateDelete();     // Catch: Throwable -> L10
        this.f513085a.setTransactionSuccessful();     // Catch: Throwable -> L10
        this.f513085a.endTransaction();
        this.f513091g.release(r102);
        return r103;
    L10:
        th = move-exception;
        this.f513085a.endTransaction();
        this.f513091g.release(r102);
        throw th;
    L5:
        r102.bindString(2, r100);
        goto L6
    }

    public final int g(String r100, String r101) {
        this.f513085a.assertNotSuspendingTransaction();
        SupportSQLiteStatement r102 = this.f513089e.acquire();
        if (r101 != null) goto L5;
        r102.bindNull(1);
    L7:
        if (r100 != null) goto L9;
        r102.bindNull(2);
    L10:
        this.f513085a.beginTransaction();
        int r103 = r102.executeUpdateDelete();     // Catch: Throwable -> L14
        this.f513085a.setTransactionSuccessful();     // Catch: Throwable -> L14
        this.f513085a.endTransaction();
        this.f513089e.release(r102);
        return r103;
    L14:
        th = move-exception;
        this.f513085a.endTransaction();
        this.f513089e.release(r102);
        throw th;
    L9:
        r102.bindString(2, r100);
        goto L10
    L5:
        r102.bindString(1, r101);
        goto L7
    }
}
