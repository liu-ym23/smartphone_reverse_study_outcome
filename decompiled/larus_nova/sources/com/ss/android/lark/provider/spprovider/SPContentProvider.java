package com.ss.android.lark.provider.spprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.obric.sva.sdk.controller.Global;
import g5c.a;
import java.util.Iterator;
import java.util.Map;
import y1c.c;

/* JADX INFO: loaded from: classes5.dex */
public class SPContentProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        return true;
    }

    public SPContentProvider() {
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        String[] r101 = r100.getPath().split(HTTP.URL_DEFAULT);
        String r102 = r101[1];
        String r103 = r101[2];
        int r104 = 0;
        boolean r105 = false;
        boolean r106 = false;
        if (r102.equals(LynxVideoManagerLite.CONTAIN) == false) goto L10;
        StringBuilder r107 = new StringBuilder();
        a r108 = c.a();
        if (r108 == null) goto L8;
        r105 = r108.contains(r103);
    L8:
        r107.append(r105);
        r107.append("");
        return r107.toString();
    L10:
        StringBuilder r109 = new StringBuilder("");
        a r110 = c.a();
        if (r110 != null) goto L13;
        boolean r111 = false;
    L14:
        Object r112 = null;
        if (r111 == true) goto L18;
    L58:
        r109.append(r112 + "");
        return r109.toString();
    L18:
        if (r102.equalsIgnoreCase("string") == false) goto L25;
        a r113 = c.a();
        if (r113 == null) goto L58;
        String r114 = r113.getString(r103, null);
    L23:
        r112 = r114;
        goto L58
    L25:
        if (r102.equalsIgnoreCase("boolean") == false) goto L32;
        a r115 = c.a();
        if (r115 == null) goto L30;
        r106 = r115.getBoolean(r103, false);
    L30:
        r112 = Boolean.valueOf(r106);
        goto L58
    L32:
        if (r102.equalsIgnoreCase("int") == false) goto L39;
        a r116 = c.a();
        if (r116 == null) goto L37;
        r104 = r116.getInt(r103);
    L37:
        r112 = Integer.valueOf(r104);
        goto L58
    L39:
        if (r102.equalsIgnoreCase("long") == false) goto L46;
        a r117 = c.a();
        if (r117 != null) goto L43;
        long r118 = 0;
    L44:
        r112 = Long.valueOf(r118);
        goto L58
    L43:
        r118 = r117.getLong(r103);
        goto L44
    L46:
        if (r102.equalsIgnoreCase("float") == false) goto L53;
        a r119 = c.a();
        float r120 = 0.0f;
        if (r119 == null) goto L51;
        r120 = r119.getFloat(r103, 0.0f);
    L51:
        r112 = Float.valueOf(r120);
        goto L58
    L53:
        if (r102.equalsIgnoreCase("string_set") == false) goto L58;
        a r121 = c.a();
        if (r121 == null) goto L58;
        r114 = r121.getString(r103, null);
        goto L23
    L13:
        r111 = r110.contains(r103);
        goto L14
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r110, ContentValues r111) {
        String[] r112 = r110.getPath().split(HTTP.URL_DEFAULT);
        String r100 = r112[1];
        String r113 = r112[2];
        Object r114 = r111.get("value");
        monitor-enter(c.class);
        a r101 = c.a();     // Catch: Throwable -> L62
        if (r101 != null) goto L9;
        monitor-exit(c.class);
    L61:
        return null;
    L9:
        if (r100 != null) goto L14;
        c.b(r113, r100, r114);     // Catch: Throwable -> L62
        monitor-exit(c.class);
        goto L61
    L14:
        switch(r100.hashCode()) {
            case -891985903: goto L29;
            case 104431: goto L26;
            case 3327612: goto L23;
            case 64711720: goto L20;
            case 97526364: goto L17;
            default: goto L31;
        };     // Catch: Throwable -> L62
    L31:
        byte r102 = -1;
    L32:
        if (r102 == 0) goto L57;
        if (r102 == 1) goto L50;
        if (r102 == 2) goto L47;
        if (r102 == 3) goto L43;
        if (r102 == 4) goto L39;
    L60:
        monitor-exit(c.class);
        goto L61
    L39:
        if ((r114 instanceof Float) == false) goto L41;
        r101.putFloat(r113, ((Float) r114).floatValue());     // Catch: Throwable -> L62
        goto L60
    L41:
        c.b(r113, r100, r114);     // Catch: Throwable -> L62
        goto L60
    L43:
        if ((r114 instanceof Long) == false) goto L45;
        r101.putLong(r113, ((Long) r114).longValue());     // Catch: Throwable -> L62
        goto L60
    L45:
        c.b(r113, r100, r114);     // Catch: Throwable -> L62
        goto L60
    L47:
        if ((r114 instanceof Integer) == false) goto L49;
        r101.putInt(r113, ((Integer) r114).intValue());     // Catch: Throwable -> L62
        goto L60
    L49:
        c.b(r113, r100, r114);     // Catch: Throwable -> L62
        goto L60
    L50:
        if (r114 != null) goto L53;
        r101.putString(r113, null);     // Catch: Throwable -> L62
        goto L60
    L53:
        if ((r114 instanceof String) == false) goto L55;
        r101.putString(r113, (String) r114);     // Catch: Throwable -> L62
        goto L60
    L55:
        c.b(r113, r100, r114);     // Catch: Throwable -> L62
        goto L60
    L57:
        if ((r114 instanceof Boolean) == false) goto L59;
        r101.putBoolean(r113, ((Boolean) r114).booleanValue());     // Catch: Throwable -> L62
        goto L60
    L59:
        c.b(r113, r100, r114);     // Catch: Throwable -> L62
        goto L60
    L17:
        if (r100.equals("float") == false) goto L31;
        r102 = 4;
        goto L32
    L20:
        if (r100.equals("boolean") == false) goto L31;
        r102 = 0;
        goto L32
    L23:
        if (r100.equals("long") == false) goto L31;
        r102 = 3;
        goto L32
    L26:
        if (r100.equals("int") == false) goto L31;
        r102 = 2;
        goto L32
    L29:
        if (r100.equals("string") == false) goto L31;
        r102 = 1;
    L62:
        th = move-exception;
        throw th;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        String[] r103 = r100.getPath().split(HTTP.URL_DEFAULT);
        if (r103[1].equals(Global.RECORDING_TYPE_CLEAN) == false) goto L6;
        c.a().cleanSharedPreference();
        return 0;
    L6:
        String r104 = r103[2];
        a r105 = c.a();
        if (r105 != null) goto L9;
        boolean r106 = false;
    L10:
        if (r106 == false) goto L15;
        a r107 = c.a();
        if (r107 == null) goto L15;
        r107.remove(r104);
    L15:
        return 0;
    L9:
        r106 = r105.contains(r104);
        goto L10
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        insert(r100, r101);
        return 0;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        if (r100.getPath().split(HTTP.URL_DEFAULT)[1].equals("get_all") == false) goto L26;
        Map<String, ?> r105 = c.a().getAll();
        if (r105 == null) goto L35;
        MatrixCursor r106 = new MatrixCursor(new String[]{"cursor_name", "cursor_type", "cursor_value"});
        Iterator<String> r107 = r105.keySet().iterator();
    L8:
        if (r107.hasNext() == false) goto L25;
        String r108 = r107.next();
        Object[] r109 = new Object[3];
        r109[0] = r108;
        Object r110 = r105.get(r108);
        r109[2] = r110;
        if ((r110 instanceof Boolean) == false) goto L13;
        r109[1] = "boolean";
    L24:
        r106.addRow(r109);
        goto L8
    L13:
        if ((r110 instanceof String) == false) goto L16;
        r109[1] = "string";
        goto L24
    L16:
        if ((r110 instanceof Integer) == false) goto L19;
        r109[1] = "int";
        goto L24
    L19:
        if ((r110 instanceof Long) == false) goto L22;
        r109[1] = "long";
        goto L24
    L22:
        if ((r110 instanceof Float) == false) goto L24;
        r109[1] = "float";
        goto L24
    L25:
        return r106;
    L35:
        return null;
    L26:
        return null;
    }
}
