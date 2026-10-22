package f67;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.privacy.pcc.network.model.c;
import com.google.gson.Gson;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f475713b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f475714a;

    public class a extends SQLiteOpenHelper {
        public a(Context r100) {
            super(r100, "pcc_channel.db", null, 3);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onCreate(SQLiteDatabase r100) {
            r100.execSQL("CREATE TABLE IF NOT EXISTS pcc_channel (rpdid TEXT NOT NULL, rpuid TEXT NOT NULL, app_id TEXT NOT NULL, svc_id TEXT NOT NULL, access_token TEXT, channel_id TEXT, channel_expiry_time TEXT, service_info TEXT, evidence_info TEXT, payload_json TEXT, response_id TEXT, signature TEXT, protocol_version INTEGER, client_lane_type INTEGER DEFAULT 1, server_lane_type INTEGER DEFAULT 1, final_lane_type INTEGER DEFAULT 1, PRIMARY KEY (rpdid, rpuid, app_id, svc_id))");
            r100.execSQL("CREATE TABLE IF NOT EXISTS key_attestation_history (id INTEGER PRIMARY KEY AUTOINCREMENT, rpdid TEXT NOT NULL, rpuid TEXT NOT NULL, access_token TEXT, service_info TEXT, evidence_info TEXT, created_at INTEGER NOT NULL, app_id TEXT, svc_id TEXT)");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onDowngrade(SQLiteDatabase r100, int r101, int r102) {
            if (r101 < 2) goto L7;
            if (r102 >= 2) goto L7;
            r100.execSQL("DROP TABLE IF EXISTS key_attestation_history");
            k67.b.e(b.f475713b, "onDowngrade: dropped key_attestation_history table (v" + r101 + " -> v" + r102 + ")");
        L7:
            if (r101 < 3) goto L11;
            if (r102 >= 3) goto L12;
            r100.execSQL("DELETE FROM pcc_channel");
            k67.b.e(b.f475713b, "onDowngrade: cleared pcc_channel data due to protocol_version removal (v" + r101 + " -> v" + r102 + ")");
            return;
        L12:
            return;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public final void onUpgrade(SQLiteDatabase r100, int r101, int r102) {
            if (r101 >= 2) goto L6;
            r100.execSQL("CREATE TABLE IF NOT EXISTS key_attestation_history (id INTEGER PRIMARY KEY AUTOINCREMENT, rpdid TEXT NOT NULL, rpuid TEXT NOT NULL, access_token TEXT, service_info TEXT, evidence_info TEXT, created_at INTEGER NOT NULL, app_id TEXT, svc_id TEXT)");
        L6:
            if (r101 >= 3) goto L9;
            r100.execSQL("ALTER TABLE pcc_channel ADD COLUMN protocol_version INTEGER");
            r100.execSQL("ALTER TABLE pcc_channel ADD COLUMN client_lane_type INTEGER DEFAULT 1");
            r100.execSQL("ALTER TABLE pcc_channel ADD COLUMN server_lane_type INTEGER DEFAULT 1");
            r100.execSQL("ALTER TABLE pcc_channel ADD COLUMN final_lane_type INTEGER DEFAULT 1");
            r100.execSQL("UPDATE pcc_channel SET protocol_version = 1");
            k67.b.e(b.f475713b, "onUpgrade: added protocol_version, client_lane_type, server_lane_type, final_lane_type columns and marked existing data as V1 (v" + r101 + " -> v" + r102 + ")");
            return;
        }
    }

    static {
        f475713b = b.class.getSimpleName();
    }

    public b(Context r100) {
        this.f475714a = new a(r100);
    }

    public final f67.a a(String r100, String r110, String r111, String r112) {
        Cursor r113 = this.f475714a.getReadableDatabase().query("pcc_channel", new String[]{"client_lane_type", "server_lane_type", "final_lane_type"}, "rpdid=? AND rpuid=? AND app_id=? AND svc_id=?", new String[]{r100, r110, r111, r112}, null, null, null);     // Catch: Exception -> L29
        if (r113 != null) goto L36;
    L26:
        if (r113 == null) goto L38;
        r113.close();     // Catch: Exception -> L29
        return null;
    L38:
        return null;
    L36:
    L20:
        th = move-exception;
        r113.close();     // Catch: Throwable -> L23
    L25:
        throw th;     // Catch: Exception -> L29
    L23:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L29
        goto L25
    L6:
        if (r113.moveToFirst() == false) goto L26;
        int r101 = r113.getColumnIndex("client_lane_type");     // Catch: Throwable -> L20
        int r114 = r113.getColumnIndex("server_lane_type");     // Catch: Throwable -> L20
        int r115 = r113.getColumnIndex("final_lane_type");     // Catch: Throwable -> L20
        if (r101 == (-1)) goto L26;
        if (r114 == (-1)) goto L26;
        if (r115 == (-1)) goto L26;
        if (r113.isNull(r101) == true) goto L26;
        if (r113.isNull(r114) == true) goto L26;
        if (r113.isNull(r115) == true) goto L26;
        f67.a r102 = new f67.a(r113.getInt(r101), r113.getInt(r114), r113.getInt(r115));     // Catch: Throwable -> L20
        r113.close();     // Catch: Exception -> L29
        return r102;
    L29:
        e = move-exception;
        k67.b.c(f475713b, "getLaneTypeInfo exception: " + e.getMessage());
        return null;
    }

    public int delete(String r100, String r101, String r110, String r111) {
        String r102 = f475713b;
        int r103 = this.f475714a.getWritableDatabase().delete("pcc_channel", "rpdid=? AND rpuid=? AND app_id=? AND svc_id=?", new String[]{r100, r101, r110, r111});     // Catch: Exception -> L5
        k67.b.e(r102, "delete: deleted " + r103 + " rows for rpdid=" + r100 + " rpuid=" + r101 + " appId=" + r110 + " svcId=" + r111);     // Catch: Exception -> L5
        return r103;
    L5:
        e = move-exception;
        k67.b.c(r102, "delete exception: " + e.getMessage());
        return 0;
    }

    public c query(String r110, String r111, String r112, String r113) {
        Cursor r114 = this.f475714a.getReadableDatabase().query("pcc_channel", null, "rpdid=? AND rpuid=? AND app_id=? AND svc_id=?", new String[]{r110, r111, r112, r113}, null, null, null);     // Catch: Exception -> L19
        if (r114 != null) goto L23;
    L16:
        if (r114 == null) goto L28;
        r114.close();     // Catch: Exception -> L19
        return null;
    L28:
        return null;
    L23:
    L10:
        th = move-exception;
        r114.close();     // Catch: Throwable -> L13
    L15:
        throw th;     // Catch: Exception -> L19
    L13:
        th = move-exception;
        th.addSuppressed(th);     // Catch: Exception -> L19
        goto L15
    L6:
        if (r114.moveToFirst() == false) goto L16;
        c r115 = c.a(r114.getString(r114.getColumnIndexOrThrow("service_info")), r114.getString(r114.getColumnIndexOrThrow("evidence_info")), r114.getString(r114.getColumnIndexOrThrow("access_token")), r114.getString(r114.getColumnIndexOrThrow("channel_id")), r114.getString(r114.getColumnIndexOrThrow("channel_expiry_time")), r114.getString(r114.getColumnIndexOrThrow("payload_json")), r114.getString(r114.getColumnIndexOrThrow("response_id")), r114.getString(r114.getColumnIndexOrThrow("signature")), r114.getInt(r114.getColumnIndexOrThrow("protocol_version")));     // Catch: Throwable -> L10
        r114.close();     // Catch: Exception -> L19
        return r115;
    L19:
        e = move-exception;
        k67.b.c(f475713b, "query exception: " + e.getMessage());
        return null;
    }

    public final boolean b(String r110, String r111, String r112, String r113, c r114) {
        String r100 = f475713b;
        SQLiteDatabase r101 = this.f475714a.getWritableDatabase();     // Catch: Exception -> L22
        if (r114.c() == null) goto L6;
        c.C3731c r102 = r114.c();     // Catch: Exception -> L22
        r102.getClass();     // Catch: Exception -> L22
        String r103 = GsonProtectorUtils.toJson(new Gson(), r102);     // Catch: Exception -> L22
    L8:
        if (r114.b() == null) goto L10;
        c.a r104 = r114.b();     // Catch: Exception -> L22
        r104.getClass();     // Catch: Exception -> L22
        String r105 = GsonProtectorUtils.toJson(new Gson(), r104);     // Catch: Exception -> L22
    L11:
        ContentValues r106 = new ContentValues();     // Catch: Exception -> L22
        r106.put("rpdid", r110);     // Catch: Exception -> L22
        r106.put("rpuid", r111);     // Catch: Exception -> L22
        c.b r115 = r114.f266703a;     // Catch: Exception -> L22
        if (r115 == null) goto L14;
        String r116 = c.b.c(r115);     // Catch: Exception -> L22
    L15:
        r106.put("access_token", r116);     // Catch: Exception -> L22
        r106.put("service_info", r103);     // Catch: Exception -> L22
        r106.put("evidence_info", r105);     // Catch: Exception -> L22
        r106.put("created_at", Long.valueOf(System.currentTimeMillis()));     // Catch: Exception -> L22
        r106.put("app_id", r112);     // Catch: Exception -> L22
        r106.put("svc_id", r113);     // Catch: Exception -> L22
        if (r101.insert("key_attestation_history", null, r106) != (-1)) goto L19;
        k67.b.c(r100, "saveKeyAttestationHistory: insert returned -1");     // Catch: Exception -> L22
        return false;
    L19:
        r101.execSQL("DELETE FROM key_attestation_history WHERE id NOT IN (  SELECT id  FROM key_attestation_history  ORDER BY created_at DESC  LIMIT 1000)");     // Catch: Exception -> L22
        k67.b.e(r100, "saveKeyAttestationHistory success: rpdid=" + r110 + " rpuid=" + r111 + " appId=" + r112 + " svcId=" + r113);     // Catch: Exception -> L22
        return true;
    L14:
        r116 = "";
        goto L15
    L10:
        r105 = null;
        goto L11
    L6:
        r103 = null;
    L22:
        e = move-exception;
        k67.b.c(r100, "saveKeyAttestationHistory exception: " + e.getMessage());
        return false;
    }
}
