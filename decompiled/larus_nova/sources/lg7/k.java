package lg7;

import android.database.Cursor;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import com.bytedance.sync.v2.presistence.AppDatabase;
import com.bytedance.sync.v2.protocal.PacketStatus;
import com.bytedance.sync.v2.protocal.TopicType;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public final class k implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RoomDatabase f509180a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f509181b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final j f509182c;

    public k(AppDatabase r100) {
        this.f509180a = r100;
        this.f509181b = new i(r100);
        this.f509182c = new j(r100);
    }

    public final List b(String r210, String r211, long r212, TopicType r213) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM t_history_synclog  WHERE did=? AND uid in (0, ?) AND business =?  AND topic_type = ? ORDER BY publish_ts DESC  LIMIT ?", 5);
        if (r210 != null) goto L5;
        r100.bindNull(1);
    L7:
        if (r211 != null) goto L9;
        r100.bindNull(2);
    L10:
        r100.bindLong(3, r212);
        r100.bindLong(4, kg7.g.a(r213));
        r100.bindLong(5, -1);
        Cursor r101 = this.f509180a.query(r100);
        int r102 = r101.getColumnIndexOrThrow("sync_id");     // Catch: Throwable -> L25
        int r103 = r101.getColumnIndexOrThrow(com.bytedance.android.ec.core.event.a.KEY_DID);     // Catch: Throwable -> L25
        int r104 = r101.getColumnIndexOrThrow("uid");     // Catch: Throwable -> L25
        int r105 = r101.getColumnIndexOrThrow("sync_cursor");     // Catch: Throwable -> L25
        int r106 = r101.getColumnIndexOrThrow("data");     // Catch: Throwable -> L25
        int r107 = r101.getColumnIndexOrThrow("md5");     // Catch: Throwable -> L25
        int r108 = r101.getColumnIndexOrThrow("business");     // Catch: Throwable -> L25
        int r110 = r101.getColumnIndexOrThrow("consume_type");     // Catch: Throwable -> L25
        int r111 = r101.getColumnIndexOrThrow("data_type");     // Catch: Throwable -> L25
        int r112 = r101.getColumnIndexOrThrow("publish_ts");     // Catch: Throwable -> L25
        int r113 = r101.getColumnIndexOrThrow("receive_ts");     // Catch: Throwable -> L25
        int r114 = r101.getColumnIndexOrThrow("bucket");     // Catch: Throwable -> L25
        int r115 = r101.getColumnIndexOrThrow("req_id");     // Catch: Throwable -> L25
        int r109 = r101.getColumnIndexOrThrow("topic_type");     // Catch: Throwable -> L25
        RoomSQLiteQuery r116 = r100;
        int r214 = r101.getColumnIndexOrThrow("packet_status");     // Catch: Throwable -> L19
        int r215 = r101.getColumnIndexOrThrow("extra");     // Catch: Throwable -> L19
        int r216 = r109;
        ArrayList r117 = new ArrayList(r101.getCount());     // Catch: Throwable -> L19
    L14:
        if (r101.moveToNext() == false) goto L23;
        mg7.d r118 = new mg7.d();     // Catch: Throwable -> L19
        ArrayList r217 = r117;
        r118.f513764a = r101.getString(r102);     // Catch: Throwable -> L19
        r118.f513765b = r101.getString(r103);     // Catch: Throwable -> L19
        r118.f513766c = r101.getString(r104);     // Catch: Throwable -> L19
        int r218 = r103;
        int r119 = r104;
        r118.f513767d = r101.getLong(r105);     // Catch: Throwable -> L19
        r118.f513768e = r101.getBlob(r106);     // Catch: Throwable -> L19
        r118.f513769f = r101.getString(r107);     // Catch: Throwable -> L19
        r118.f513770g = r101.getLong(r108);     // Catch: Throwable -> L19
        r118.f513771h = kg7.b.a(r101.getInt(r110));     // Catch: Throwable -> L19
        r118.f513772i = bg7.a.a(r101.getInt(r111));     // Catch: Throwable -> L19
        r118.f513773j = r101.getLong(r112);     // Catch: Throwable -> L19
        r118.f513774k = r101.getLong(r113);     // Catch: Throwable -> L19
        r118.f513775l = kg7.a.b(r101.getInt(r114));     // Catch: Throwable -> L19
        r118.f513776m = r101.getString(r115);     // Catch: Throwable -> L19
        int r120 = r216;
        r118.f513777n = kg7.g.b(r101.getInt(r120));     // Catch: Throwable -> L19
        int r121 = r214;
        PacketStatus r122 = PacketStatus.fromValue(r101.getInt(r121));     // Catch: Throwable -> L19
        if (r122 != null) goto L21;
        r122 = PacketStatus.Full;     // Catch: Throwable -> L19
    L21:
        int r219 = r102;
        r118.f513778o = r122;     // Catch: Throwable -> L19
        int r123 = r215;
        r215 = r123;
        r118.f513779p = kg7.c.a(r101.getString(r123));     // Catch: Throwable -> L19
        r217.add(r118);     // Catch: Throwable -> L19
        r216 = r120;
        r103 = r218;
        r102 = r219;
        r214 = r121;
        r104 = r119;
        r117 = r217;
        goto L14
    L23:
        ArrayList r124 = r117;
        r101.close();
        r116.release();
        return r124;
    L19:
        th = th;
    L27:
        r101.close();
        r116.release();
        throw th;
    L25:
        th = th;
        r116 = r100;
        goto L27
    L9:
        r100.bindString(2, r211);
        goto L10
    L5:
        r100.bindString(1, r210);
        goto L7
    }

    public final List c(String r210, String r211, long r212, TopicType r213) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM t_history_synclog  WHERE did=? AND uid in (0, ?) AND business =?  AND topic_type = ? ORDER BY sync_cursor DESC  LIMIT ?", 5);
        if (r210 != null) goto L5;
        r100.bindNull(1);
    L7:
        if (r211 != null) goto L9;
        r100.bindNull(2);
    L10:
        r100.bindLong(3, r212);
        r100.bindLong(4, kg7.g.a(r213));
        r100.bindLong(5, -1);
        Cursor r101 = this.f509180a.query(r100);
        int r102 = r101.getColumnIndexOrThrow("sync_id");     // Catch: Throwable -> L25
        int r103 = r101.getColumnIndexOrThrow(com.bytedance.android.ec.core.event.a.KEY_DID);     // Catch: Throwable -> L25
        int r104 = r101.getColumnIndexOrThrow("uid");     // Catch: Throwable -> L25
        int r105 = r101.getColumnIndexOrThrow("sync_cursor");     // Catch: Throwable -> L25
        int r106 = r101.getColumnIndexOrThrow("data");     // Catch: Throwable -> L25
        int r107 = r101.getColumnIndexOrThrow("md5");     // Catch: Throwable -> L25
        int r108 = r101.getColumnIndexOrThrow("business");     // Catch: Throwable -> L25
        int r110 = r101.getColumnIndexOrThrow("consume_type");     // Catch: Throwable -> L25
        int r111 = r101.getColumnIndexOrThrow("data_type");     // Catch: Throwable -> L25
        int r112 = r101.getColumnIndexOrThrow("publish_ts");     // Catch: Throwable -> L25
        int r113 = r101.getColumnIndexOrThrow("receive_ts");     // Catch: Throwable -> L25
        int r114 = r101.getColumnIndexOrThrow("bucket");     // Catch: Throwable -> L25
        int r115 = r101.getColumnIndexOrThrow("req_id");     // Catch: Throwable -> L25
        int r109 = r101.getColumnIndexOrThrow("topic_type");     // Catch: Throwable -> L25
        RoomSQLiteQuery r116 = r100;
        int r214 = r101.getColumnIndexOrThrow("packet_status");     // Catch: Throwable -> L19
        int r215 = r101.getColumnIndexOrThrow("extra");     // Catch: Throwable -> L19
        int r216 = r109;
        ArrayList r117 = new ArrayList(r101.getCount());     // Catch: Throwable -> L19
    L14:
        if (r101.moveToNext() == false) goto L23;
        mg7.d r118 = new mg7.d();     // Catch: Throwable -> L19
        ArrayList r217 = r117;
        r118.f513764a = r101.getString(r102);     // Catch: Throwable -> L19
        r118.f513765b = r101.getString(r103);     // Catch: Throwable -> L19
        r118.f513766c = r101.getString(r104);     // Catch: Throwable -> L19
        int r218 = r103;
        int r119 = r104;
        r118.f513767d = r101.getLong(r105);     // Catch: Throwable -> L19
        r118.f513768e = r101.getBlob(r106);     // Catch: Throwable -> L19
        r118.f513769f = r101.getString(r107);     // Catch: Throwable -> L19
        r118.f513770g = r101.getLong(r108);     // Catch: Throwable -> L19
        r118.f513771h = kg7.b.a(r101.getInt(r110));     // Catch: Throwable -> L19
        r118.f513772i = bg7.a.a(r101.getInt(r111));     // Catch: Throwable -> L19
        r118.f513773j = r101.getLong(r112);     // Catch: Throwable -> L19
        r118.f513774k = r101.getLong(r113);     // Catch: Throwable -> L19
        r118.f513775l = kg7.a.b(r101.getInt(r114));     // Catch: Throwable -> L19
        r118.f513776m = r101.getString(r115);     // Catch: Throwable -> L19
        int r120 = r216;
        r118.f513777n = kg7.g.b(r101.getInt(r120));     // Catch: Throwable -> L19
        int r121 = r214;
        PacketStatus r122 = PacketStatus.fromValue(r101.getInt(r121));     // Catch: Throwable -> L19
        if (r122 != null) goto L21;
        r122 = PacketStatus.Full;     // Catch: Throwable -> L19
    L21:
        int r219 = r102;
        r118.f513778o = r122;     // Catch: Throwable -> L19
        int r123 = r215;
        r215 = r123;
        r118.f513779p = kg7.c.a(r101.getString(r123));     // Catch: Throwable -> L19
        r217.add(r118);     // Catch: Throwable -> L19
        r216 = r120;
        r103 = r218;
        r102 = r219;
        r214 = r121;
        r104 = r119;
        r117 = r217;
        goto L14
    L23:
        ArrayList r124 = r117;
        r101.close();
        r116.release();
        return r124;
    L19:
        th = th;
    L27:
        r101.close();
        r116.release();
        throw th;
    L25:
        th = th;
        r116 = r100;
        goto L27
    L9:
        r100.bindString(2, r211);
        goto L10
    L5:
        r100.bindString(1, r210);
        goto L7
    }

    public final List a(String r110, String r210, long r211, TopicType r212, String r213) {
        RoomSQLiteQuery r100 = RoomSQLiteQuery.acquire("SELECT * FROM t_history_synclog  WHERE did=? AND uid in (0, ?) AND business =?  AND topic_type = ? AND req_id = ? ORDER BY sync_cursor DESC LIMIT ?", 6);
        if (r110 != null) goto L5;
        r100.bindNull(1);
    L7:
        if (r210 != null) goto L9;
        r100.bindNull(2);
    L10:
        r100.bindLong(3, r211);
        r100.bindLong(4, kg7.g.a(r212));
        if (r213 != null) goto L13;
        r100.bindNull(5);
    L14:
        r100.bindLong(6, -1);
        Cursor r101 = this.f509180a.query(r100);
        int r102 = r101.getColumnIndexOrThrow("sync_id");     // Catch: Throwable -> L29
        int r103 = r101.getColumnIndexOrThrow(com.bytedance.android.ec.core.event.a.KEY_DID);     // Catch: Throwable -> L29
        int r104 = r101.getColumnIndexOrThrow("uid");     // Catch: Throwable -> L29
        int r105 = r101.getColumnIndexOrThrow("sync_cursor");     // Catch: Throwable -> L29
        int r106 = r101.getColumnIndexOrThrow("data");     // Catch: Throwable -> L29
        int r107 = r101.getColumnIndexOrThrow("md5");     // Catch: Throwable -> L29
        int r108 = r101.getColumnIndexOrThrow("business");     // Catch: Throwable -> L29
        int r111 = r101.getColumnIndexOrThrow("consume_type");     // Catch: Throwable -> L29
        int r112 = r101.getColumnIndexOrThrow("data_type");     // Catch: Throwable -> L29
        int r113 = r101.getColumnIndexOrThrow("publish_ts");     // Catch: Throwable -> L29
        int r114 = r101.getColumnIndexOrThrow("receive_ts");     // Catch: Throwable -> L29
        int r115 = r101.getColumnIndexOrThrow("bucket");     // Catch: Throwable -> L29
        int r116 = r101.getColumnIndexOrThrow("req_id");     // Catch: Throwable -> L29
        int r109 = r101.getColumnIndexOrThrow("topic_type");     // Catch: Throwable -> L29
        RoomSQLiteQuery r117 = r100;
        int r118 = r101.getColumnIndexOrThrow("packet_status");     // Catch: Throwable -> L23
        int r214 = r101.getColumnIndexOrThrow("extra");     // Catch: Throwable -> L23
        int r215 = r109;
        ArrayList r119 = new ArrayList(r101.getCount());     // Catch: Throwable -> L23
    L18:
        if (r101.moveToNext() == false) goto L27;
        mg7.d r120 = new mg7.d();     // Catch: Throwable -> L23
        ArrayList r216 = r119;
        r120.f513764a = r101.getString(r102);     // Catch: Throwable -> L23
        r120.f513765b = r101.getString(r103);     // Catch: Throwable -> L23
        r120.f513766c = r101.getString(r104);     // Catch: Throwable -> L23
        int r217 = r103;
        r120.f513767d = r101.getLong(r105);     // Catch: Throwable -> L23
        r120.f513768e = r101.getBlob(r106);     // Catch: Throwable -> L23
        r120.f513769f = r101.getString(r107);     // Catch: Throwable -> L23
        r120.f513770g = r101.getLong(r108);     // Catch: Throwable -> L23
        r120.f513771h = kg7.b.a(r101.getInt(r111));     // Catch: Throwable -> L23
        r120.f513772i = bg7.a.a(r101.getInt(r112));     // Catch: Throwable -> L23
        r120.f513773j = r101.getLong(r113);     // Catch: Throwable -> L23
        r120.f513774k = r101.getLong(r114);     // Catch: Throwable -> L23
        r120.f513775l = kg7.a.b(r101.getInt(r115));     // Catch: Throwable -> L23
        r120.f513776m = r101.getString(r116);     // Catch: Throwable -> L23
        int r121 = r215;
        r120.f513777n = kg7.g.b(r101.getInt(r121));     // Catch: Throwable -> L23
        int r122 = r118;
        PacketStatus r123 = PacketStatus.fromValue(r101.getInt(r122));     // Catch: Throwable -> L23
        if (r123 != null) goto L25;
        r123 = PacketStatus.Full;     // Catch: Throwable -> L23
    L25:
        int r124 = r102;
        r120.f513778o = r123;     // Catch: Throwable -> L23
        int r125 = r214;
        r214 = r125;
        r120.f513779p = kg7.c.a(r101.getString(r125));     // Catch: Throwable -> L23
        r216.add(r120);     // Catch: Throwable -> L23
        r215 = r121;
        r119 = r216;
        r102 = r124;
        r118 = r122;
        r103 = r217;
        goto L18
    L27:
        ArrayList r126 = r119;
        r101.close();
        r117.release();
        return r126;
    L23:
        th = th;
    L31:
        r101.close();
        r117.release();
        throw th;
    L29:
        th = th;
        r117 = r100;
        goto L31
    L13:
        r100.bindString(5, r213);
        goto L14
    L9:
        r100.bindString(2, r210);
        goto L10
    L5:
        r100.bindString(1, r110);
        goto L7
    }
}
