package ps3;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    public static class a {
        public a() {
        }
    }

    static {
        new a();
    }

    public static void a(String[] r100) {
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        String r103 = r100[r102];
        r102 = r102 + 1;
        goto L3
    }

    public static void b(Object... r100) {
        JSONObject r101 = new JSONObject();
        int r102 = r100.length;
        if ((r102 % 2) != 0) goto L13;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L10;
        r101.put(String.valueOf(r100[r103]), String.valueOf(r100[r103 + 1]));     // Catch: JSONException -> L8
        r103 = r103 + 2;
    L8:
        e = move-exception;
        e.printStackTrace();
    L10:
        a(new String[]{r101.toString()});
        return;
    L13:
        throw new IllegalArgumentException();
    }
}
