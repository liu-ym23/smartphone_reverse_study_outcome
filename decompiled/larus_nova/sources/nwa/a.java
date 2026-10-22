package nwa;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class a {
    public static <T> boolean a(List<T> r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.isEmpty() == true) goto L7;
        return false;
    }

    public static <K, V> boolean b(Map<K, V> r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.isEmpty() == true) goto L7;
        return false;
    }
}
