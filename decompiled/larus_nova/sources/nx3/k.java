package nx3;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.bytedance.applog.log.n;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import java.io.Closeable;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f521052a;

    public static boolean a(String r100) {
        boolean r101 = false;
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L18:
        return false;
    L5:
        if ("unknown".equalsIgnoreCase(r100) == true) goto L18;
        if ("Null".equalsIgnoreCase(r100) == true) goto L18;
        int r102 = 0;
    L10:
        if (r102 >= r100.length()) goto L15;
        if (r100.charAt(r102) != '0') goto L17;
        r102 = r102 + 1;
    L17:
        return !r101;
    L15:
        r101 = true;
        goto L17
    }

    public static void b(Cursor r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static void c(Closeable r100) {
        if (r100 == null) goto L8;
        r100.close();     // Catch: Throwable -> L5
        return;
    L9:
        return;
    }

    public static JSONObject e(JSONObject r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Iterator<String> r101 = r100.keys();
        if (r101 != null) goto L8;
        return null;
    L8:
        LinkedList r102 = new LinkedList();
    L10:
        if (r101.hasNext() == false) goto L18;
        r102.add(r101.next());
        goto L10
    L18:
        return new JSONObject(r100, (String[]) r102.toArray(new String[0]));
    L15:
        e = move-exception;
        n.w().q("copyJson failed", e, new Object[0]);
        return r100;
    }

    public static void f(SQLiteDatabase r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isOpen() == false) goto L15;
    L9:
        th = move-exception;
        n.w().q("end transaction failed", th, new Object[0]);
        return;
    L6:
        if (r100.inTransaction() == false) goto L16;
        r100.endTransaction();     // Catch: Throwable -> L9
        return;
    L16:
        return;
    }

    public static boolean g(String r100) {
        return !h(r100);
    }

    public static boolean h(String r100) {
        if (r100 != null) goto L4;
    L6:
        return false;
    L4:
        if (r100.length() <= 0) goto L6;
        return true;
    }

    public static void d(JSONObject r100, JSONObject r101) {
        if (r101 == null) goto L15;
        Iterator<String> r102 = r101.keys();     // Catch: JSONException -> L8
    L5:
        if (r102.hasNext() == false) goto L16;
        String r103 = r102.next();     // Catch: JSONException -> L8
        r100.put(r103, r101.opt(r103));     // Catch: JSONException -> L8
        goto L5
    L16:
        return;
    L8:
        e = move-exception;
        n.w().q("copy failed", e, new Object[0]);
        return;
    }

    public static long i(JSONObject r100, String r101) {
        return CastLongProtector.parseLong(r100.optString(r101));
    L5:
        return 0;
    }
}
