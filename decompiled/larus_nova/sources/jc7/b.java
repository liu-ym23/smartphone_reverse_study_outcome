package jc7;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.ss.android.account.k;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import kc7.c;
import kc7.d;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final jc7.a f498142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public SQLiteDatabase f498143b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f498144a = null;

        static {
            f498144a = new b();
        }
    }

    public final boolean b() {
        SQLiteDatabase r100 = this.f498143b;     // Catch: Exception -> L11
        if (r100 != null) goto L5;
    L7:
        jc7.a r101 = this.f498142a;     // Catch: Exception -> L11
        if (r101 == null) goto L17;
        this.f498143b = r101.getWritableDatabase();     // Catch: Exception -> L11
        return true;
    L17:
        return false;
    L5:
        if (r100.isOpen() == false) goto L7;
        return true;
    L11:
        e = move-exception;
        e.printStackTrace();
        return false;
    }

    public b() {
        this.f498142a = new jc7.a(k.d().getApplicationContext());
        this.f498143b = null;
    }

    public final boolean c() {
        if (b() == true) goto L6;
        return false;
    L6:
        if (this.f498143b.delete(Constants.LOGIN_INFO, "time in (select min(time) from login_info)", null) == 0) goto L9;
        return true;
    L9:
        return false;
    }

    public boolean insert(c r100) {
        if (b() == true) goto L5;
    L28:
        return false;
    L5:
        if (d.a(r100.getType()) == false) goto L28;
        String r101 = r100.f502415c;
        if (r101 == null) goto L28;
        if (r101.length() == 0) goto L28;
        if (r100.f502416d <= 0) goto L28;
        if (TextUtils.isEmpty(r100.f502419g) == true) goto L28;
        ContentValues r102 = new ContentValues();
        r102.put("time", Long.valueOf(r100.f502413a));
        r102.put("type", Integer.valueOf(r100.getType()));
        r102.put("info", r100.f502415c);
        r102.put("uid", Long.valueOf(r100.f502416d));
        r102.put("avatar_url", r100.f502418f);
        r102.put("screen_name", r100.f502419g);
        r102.put("platform_avatar_url", r100.f502420h);
        r102.put("platform_screen_name", r100.f502421i);
        r102.put("sec_uid", r100.f502417e);
        kc7.a r103 = r100.f502422j;
        if (r103 != null) goto L30;
    L24:
        String r104 = null;
    L25:
        r102.put("ext", r104);
        if (this.f498143b.insert(Constants.LOGIN_INFO, null, r102) == (-1)) goto L28;
        return true;
    L30:
        Integer r105 = r103.f502412a;     // Catch: Exception -> L22
        JSONObject r106 = new JSONObject();     // Catch: Exception -> L22
        if (r105 == null) goto L20;
        r106.put("country_code", r105);     // Catch: Exception -> L22
    L20:
        r104 = r106.toString();     // Catch: Exception -> L22
    L22:
        e = move-exception;
        e.printStackTrace();
        goto L24
    }

    public boolean update(c r100) {
        if (b() == true) goto L5;
        return false;
    L5:
        if (d.a(r100.getType()) == false) goto L60;
        String r101 = r100.f502415c;
        if (r101 != null) goto L9;
        return false;
    L9:
        if (r101.length() != 0) goto L11;
        return false;
    L11:
        if (r100.f502416d <= 0) goto L64;
        ContentValues r102 = new ContentValues();
        long r103 = r100.f502413a;
        if (r103 <= 0) goto L17;
        r102.put("time", Long.valueOf(r103));
    L17:
        if (d.a(r100.getType()) == false) goto L20;
        r102.put("type", Integer.valueOf(r100.getType()));
    L20:
        if (TextUtils.isEmpty(r100.f502415c) == true) goto L22;
        r102.put("info", r100.f502415c);
    L22:
        long r104 = r100.f502416d;
        if (r104 <= 0) goto L26;
        r102.put("uid", Long.valueOf(r104));
    L26:
        if (TextUtils.isEmpty(r100.f502418f) == true) goto L29;
        r102.put("avatar_url", r100.f502418f);
    L29:
        if (TextUtils.isEmpty(r100.f502419g) == true) goto L32;
        r102.put("screen_name", r100.f502419g);
    L32:
        if (TextUtils.isEmpty(r100.f502420h) == true) goto L35;
        r102.put("platform_avatar_url", r100.f502420h);
    L35:
        if (TextUtils.isEmpty(r100.f502421i) == true) goto L38;
        r102.put("platform_screen_name", r100.f502421i);
    L38:
        if (TextUtils.isEmpty(r100.f502417e) == true) goto L40;
        r102.put("sec_uid", r100.f502417e);
    L40:
        kc7.a r105 = r100.f502422j;
        if (r105 != null) goto L57;
    L49:
        String r106 = null;
    L51:
        if (TextUtils.isEmpty(r106) == true) goto L54;
        r102.put("ext", r106);
    L54:
        if (this.f498143b.update(Constants.LOGIN_INFO, r102, "type = ? and info = ? and uid = ?", new String[]{String.valueOf(r100.getType()), r100.f502415c, String.valueOf(r100.f502416d)}) == 0) goto L63;
        return true;
    L63:
        return false;
    L57:
        Integer r107 = r105.f502412a;     // Catch: Exception -> L47
        JSONObject r108 = new JSONObject();     // Catch: Exception -> L47
        if (r107 == null) goto L45;
        r108.put("country_code", r107);     // Catch: Exception -> L47
    L45:
        r106 = r108.toString();     // Catch: Exception -> L47
    L47:
        e = move-exception;
        e.printStackTrace();
        goto L49
    L64:
        return false;
    L60:
        return false;
    }

    public static void a(StringBuilder r100, String r101) {
        if (r100.length() <= 0) goto L5;
        r100.append(" and ");
    L5:
        r100.append(r101);
        r100.append(" = ?");
    }

    public boolean delete(int r100, Object r101) {
        if (b() == true) goto L6;
        return false;
    L6:
        if (r100 == 1) goto L45;
        if (r100 == 2) goto L43;
        if (r100 != 3) goto L12;
        if (r101 != null) goto L35;
        return false;
    L35:
        long r102 = ((Long) r101).longValue();
        if (b() == true) goto L39;
        return false;
    L39:
        if (this.f498143b.delete(Constants.LOGIN_INFO, "time = ?", new String[]{String.valueOf(r102)}) == 0) goto L55;
        return true;
    L55:
        return false;
    L12:
        if (r100 != 4) goto L14;
        if (r101 != null) goto L26;
        return false;
    L26:
        int r103 = ((Integer) r101).intValue();
        if (b() == true) goto L30;
        return false;
    L30:
        if (this.f498143b.delete(Constants.LOGIN_INFO, "type = ?", new String[]{String.valueOf(r103)}) == 0) goto L53;
        return true;
    L53:
        return false;
    L14:
        if (r100 == 5) goto L16;
        return false;
    L16:
        if (r101 != null) goto L18;
        return false;
    L18:
        String r104 = (String) r101;
        if (b() == true) goto L21;
        return false;
    L21:
        if (this.f498143b.delete(Constants.LOGIN_INFO, "info = ?", new String[]{r104}) == 0) goto L52;
        return true;
    L52:
        return false;
    L43:
        return c();
    L45:
        if (b() == true) goto L48;
        return false;
    L48:
        if (this.f498143b.delete(Constants.LOGIN_INFO, "time in (select max(time) from login_info)", null) == 0) goto L57;
        return true;
    L57:
        return false;
    }

    public final c d(int r210, Long r211, Integer r310, String r311, Long r312) {
        Cursor r100 = null;
        r100 = null;
        c r101 = null;
        r100 = null;
        if (b() == true) goto L5;
        return null;
    L5:
        String[] r110 = {"time", "type", "info", "uid", "avatar_url", "screen_name", "platform_avatar_url", "platform_screen_name", "sec_uid", "ext"};
        StringBuilder r102 = new StringBuilder();
        if (r210 == 1) goto L54;
        if (r210 != 2) goto L9;
        r102.append("time");     // Catch: Throwable -> L71 Exception -> L73
        r102.append(" in (select min(");     // Catch: Throwable -> L71 Exception -> L73
        r102.append("time");     // Catch: Throwable -> L71 Exception -> L73
        r102.append(") from ");     // Catch: Throwable -> L71 Exception -> L73
        r102.append(Constants.LOGIN_INFO);     // Catch: Throwable -> L71 Exception -> L73
        r102.append(")");     // Catch: Throwable -> L71 Exception -> L73
        Cursor r103 = this.f498143b.query(Constants.LOGIN_INFO, r110, r102.toString(), null, null, null, null);     // Catch: Throwable -> L71 Exception -> L73
    L55:
        Cursor r104 = r103;
    L56:
        if (r104 != null) goto L84;
    L68:
        c r105 = null;
        r100 = r104;
    L69:
        if (r100 != null) goto L78;
    L79:
        return r105;
    L78:
        r100.close();
        goto L79
    L84:
    L66:
        e = e;
    L67:
        c r212 = r101;
        r100 = r104;
        c r106 = r212;
    L75:
        e.printStackTrace();     // Catch: Throwable -> L71
        com.bytedance.sdk.account.monitor.c.a(e);     // Catch: Throwable -> L71
        r105 = r106;
        if (r100 == null) goto L79;
    L64:
        th = th;
    L81:
        if (r104 == null) goto L83;
        r104.close();
    L83:
        throw th;
    L58:
        if (r104.getCount() <= 0) goto L68;
        r104.moveToFirst();     // Catch: Throwable -> L64 Exception -> L66
        r105 = new c(r104.getLong(0), r104.getInt(1), r104.getString(2), r104.getLong(3), r104.getString(8), r104.getString(4), r104.getString(5), r104.getString(6), r104.getString(7), kc7.b.a(r104.getString(9)));     // Catch: Throwable -> L64 Exception -> L66
        r104.close();     // Catch: Exception -> L62 Throwable -> L64
    L62:
        e = e;
        r101 = r105;
        goto L67
    L9:
        if (r210 == 3) goto L36;
        if (r210 != 4) goto L51;
        ArrayList r107 = new ArrayList();     // Catch: Throwable -> L71 Exception -> L73
        if (r211 == null) goto L15;
        a(r102, "time");     // Catch: Throwable -> L71 Exception -> L73
        r107.add(String.valueOf(r211));     // Catch: Throwable -> L71 Exception -> L73
    L15:
        if (r310 == null) goto L17;
        a(r102, "type");     // Catch: Throwable -> L71 Exception -> L73
        r107.add(String.valueOf(r310));     // Catch: Throwable -> L71 Exception -> L73
    L17:
        if (r312 != null) goto L19;
    L21:
        if (r311 != null) goto L23;
    L35:
        r103 = this.f498143b.query(Constants.LOGIN_INFO, r110, r102.toString(), (String[]) r107.toArray(new String[0]), null, null, "time desc", "0,1");     // Catch: Throwable -> L71 Exception -> L73
        goto L55
    L23:
        if (r311.length() == 0) goto L35;
        String[] r108 = r311.split("\\*");     // Catch: Throwable -> L71 Exception -> L73
        StringBuilder r109 = new StringBuilder();     // Catch: Throwable -> L71 Exception -> L73
        int r111 = r108.length;     // Catch: Throwable -> L71 Exception -> L73
        if (r111 == 0) goto L51;
        int r112 = 0;
    L29:
        if (r112 >= r111) goto L31;
        r109.append(GXTemplateKey.GAIAX_PE);     // Catch: Throwable -> L71 Exception -> L73
        r109.append(r108[r112]);     // Catch: Throwable -> L71 Exception -> L73
        r112 = r112 + 1;     // Catch: Throwable -> L71 Exception -> L73
        goto L29
    L31:
        r109.append(GXTemplateKey.GAIAX_PE);     // Catch: Throwable -> L71 Exception -> L73
        if (r102.length() <= 0) goto L34;
        r102.append(" and ");     // Catch: Throwable -> L71 Exception -> L73
    L34:
        r102.append("info");     // Catch: Throwable -> L71 Exception -> L73
        r102.append(" like ? ");     // Catch: Throwable -> L71 Exception -> L73
        r107.add(r109.toString());     // Catch: Throwable -> L71 Exception -> L73
        goto L35
    L19:
        if (r312.longValue() <= 0) goto L21;
        a(r102, "uid");     // Catch: Throwable -> L71 Exception -> L73
        r107.add(String.valueOf(r312));     // Catch: Throwable -> L71 Exception -> L73
    L51:
        r104 = null;
        goto L56
    L36:
        ArrayList r113 = new ArrayList();     // Catch: Throwable -> L71 Exception -> L73
        if (r211 == null) goto L39;
        a(r102, "time");     // Catch: Throwable -> L71 Exception -> L73
        r113.add(String.valueOf(r211));     // Catch: Throwable -> L71 Exception -> L73
    L39:
        if (r310 == null) goto L41;
        a(r102, "type");     // Catch: Throwable -> L71 Exception -> L73
        r113.add(String.valueOf(r310));     // Catch: Throwable -> L71 Exception -> L73
    L41:
        if (r311 != null) goto L43;
    L45:
        if (r312 == null) goto L50;
        if (r312.longValue() <= 0) goto L50;
        a(r102, "uid");     // Catch: Throwable -> L71 Exception -> L73
        r113.add(String.valueOf(r312));     // Catch: Throwable -> L71 Exception -> L73
    L50:
        if (r102.length() == 0) goto L51;
        r103 = this.f498143b.query(Constants.LOGIN_INFO, r110, r102.toString(), (String[]) r113.toArray(new String[0]), null, null, "time desc", "0,1");     // Catch: Throwable -> L71 Exception -> L73
        goto L55
    L43:
        if (r311.length() == 0) goto L45;
        a(r102, "info");     // Catch: Throwable -> L71 Exception -> L73
        r113.add(r311);     // Catch: Throwable -> L71 Exception -> L73
        goto L45
    L54:
        r102.append("time");     // Catch: Throwable -> L71 Exception -> L73
        r102.append(" in (select max(");     // Catch: Throwable -> L71 Exception -> L73
        r102.append("time");     // Catch: Throwable -> L71 Exception -> L73
        r102.append(") from ");     // Catch: Throwable -> L71 Exception -> L73
        r102.append(Constants.LOGIN_INFO);     // Catch: Throwable -> L71 Exception -> L73
        r102.append(")");     // Catch: Throwable -> L71 Exception -> L73
        r103 = this.f498143b.query(Constants.LOGIN_INFO, r110, r102.toString(), null, null, null, null);     // Catch: Throwable -> L71 Exception -> L73
    L73:
        e = e;
        r106 = null;
    L71:
        th = th;
        r104 = r100;
        goto L81
    }
}
