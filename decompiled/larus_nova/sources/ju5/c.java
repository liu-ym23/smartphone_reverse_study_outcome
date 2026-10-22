package ju5;

import androidx.room.RoomDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public final class c {
    public static int a(List<String> r100, final m r101, RoomDatabase r102) {
        if (r100 == null) goto L34;
        if (r102 == null) goto L34;
        final ArrayList r103 = new ArrayList();
    L32:
        e = move-exception;
        iu5.d.c(e);
        goto L34
    L8:
        if (r100.size() <= 900) goto L23;
        final ArrayList r104 = new ArrayList();     // Catch: Exception -> L32
        if (r100.size() != 0) goto L12;
    L21:
        r104.add(r100);     // Catch: Exception -> L32
    L22:
        r102.runInTransaction(new b(r104, r101, r103));     // Catch: Exception -> L32
    L24:
        Iterator r105 = r103.iterator();     // Catch: Exception -> L32
    L25:
        if (r105.hasNext() == false) goto L30;
        if (((Integer) r105.next()).intValue() >= 0) goto L25;
        return -1;
    L30:
        return 1;
    L12:
        if (r100.size() <= 900) goto L21;
        int r106 = 0;
        int r107 = 0;
    L16:
        if (r106 >= r100.size()) goto L22;
        r107 = r107 + 900;     // Catch: Exception -> L32
        if (r107 <= r100.size()) goto L20;
        r107 = r100.size();     // Catch: Exception -> L32
    L20:
        r104.add(r100.subList(r106, r107));     // Catch: Exception -> L32
        r106 = r107;
        goto L16
    L23:
        r103.add(Integer.valueOf(r101.a(r100)));     // Catch: Exception -> L32
    L34:
        return -1;
    }
}
