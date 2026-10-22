package xr3;

import android.database.Cursor;
import java.util.HashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public class a$b {
    public final Cursor a;
    public final HashMap<String, Integer> b;

    public final int a(String r3) {
        Integer r0 = this.b.get(r3);
        if (r0 != null) goto L9;
        r0 = Integer.valueOf(this.a.getColumnIndex(r3));     // Catch: Throwable -> L6
    L7:
        this.b.put(r3, r0);
    L6:
        r0 = -1;
    L9:
        return r0.intValue();
    }

    public final long b(String r3) {
        return this.a.getLong(a(r3));
    L4:
        return -1;
    }

    public final String c(String r2) {
        return this.a.getString(a(r2));
    L4:
        return "";
    }

    public a$b(Cursor r1, HashMap r2) {
        this.a = r1;
        this.b = r2;
    }
}
