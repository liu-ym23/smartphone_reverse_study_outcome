package hu5;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static int c(Collection r100) {
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.size();
    }

    public static boolean d(Collection r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.isEmpty() == true) goto L7;
        return false;
    }

    public static boolean e(Map r100) {
        if (r100 != null) goto L4;
    L7:
        return true;
    L4:
        if (r100.isEmpty() == true) goto L7;
        return false;
    }

    public static boolean f(Collection r100) {
        return !d(r100);
    }

    public static boolean g(Map r100) {
        return !e(r100);
    }

    public static boolean a(int r100, Collection r101) {
        if (d(r101) == false) goto L5;
        return false;
    L5:
        if (r100 >= 0) goto L7;
        return false;
    L7:
        if (r100 >= r101.size()) goto L11;
        return true;
    L11:
        return false;
    }

    public static <T> T b(List<T> r100, int r101) {
        if (a(r101, r100) == true) goto L5;
        return null;
    L5:
        return (T) ListProtector.get(r100, r101);
    }
}
