package y1;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: loaded from: classes39.dex */
public final class d {
    public static void c(Context r100, String r101) {
        r100.getSharedPreferences("bes_app_config", 0).edit().remove(r101).commit();
    }

    public static Object a(Context r100, String r101, Object r102) {
        SharedPreferences r103 = r100.getSharedPreferences("bes_app_config", 0);
        if ((r102 instanceof Integer) == true) goto L31;
        if ((r102 instanceof Short) == true) goto L31;
        if ((r102 instanceof Byte) == true) goto L31;
        if ((r102 instanceof Float) == true) goto L29;
        if ((r102 instanceof Double) == true) goto L29;
        if ((r102 instanceof Long) == false) goto L19;
        return Long.valueOf(r103.getLong(r101, ((Long) r102).longValue()));
    L19:
        if ((r102 instanceof Boolean) == false) goto L23;
        return Boolean.valueOf(r103.getBoolean(r101, ((Boolean) r102).booleanValue()));
    L23:
        if ((r102 instanceof String) == true) goto L25;
        return null;
    L25:
        return r103.getString(r101, (String) r102);
    L29:
        return Float.valueOf(r103.getFloat(r101, ((Float) r102).floatValue()));
    L31:
        return Integer.valueOf(r103.getInt(r101, ((Integer) r102).intValue()));
    }

    public static void b(Context r100, String r101, Object r102) {
        SharedPreferences.Editor r103 = r100.getSharedPreferences("bes_app_config", 0).edit();
        if ((r102 instanceof Integer) == false) goto L6;
        r103.putInt(r101, ((Integer) r102).intValue());
    L26:
        r103.commit();
        return;
    L6:
        if ((r102 instanceof Short) == false) goto L9;
        r103.putInt(r101, ((Short) r102).shortValue());
        goto L26
    L9:
        if ((r102 instanceof Byte) == false) goto L12;
        r103.putInt(r101, ((Byte) r102).byteValue());
        goto L26
    L12:
        if ((r102 instanceof Float) == false) goto L15;
        r103.putFloat(r101, ((Float) r102).floatValue());
        goto L26
    L15:
        if ((r102 instanceof Double) == false) goto L18;
        r103.putFloat(r101, (float) ((Double) r102).doubleValue());
        goto L26
    L18:
        if ((r102 instanceof Long) == false) goto L21;
        r103.putLong(r101, ((Long) r102).longValue());
        goto L26
    L21:
        if ((r102 instanceof Boolean) == false) goto L24;
        r103.putBoolean(r101, ((Boolean) r102).booleanValue());
        goto L26
    L24:
        if ((r102 instanceof String) == false) goto L26;
        r103.putString(r101, (String) r102);
        goto L26
    }
}
