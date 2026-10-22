package w18;

import android.util.ArrayMap;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes24.dex */
public final class b implements a {
    public b() {
    }

    public static boolean a(Collection r100) {
        ArrayMap r101 = new ArrayMap(r100.size());
        Iterator r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        Object r103 = r102.next();
        if (((Boolean) r101.get(r103)) != null) goto L7;
        r101.put(r103, Boolean.TRUE);
        goto L4
    L7:
        return true;
    L10:
        return false;
    }
}
