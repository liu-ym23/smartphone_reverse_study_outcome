package ly;

import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes45.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap<Long, t> f511283a = null;

    static {
        f511283a = new LinkedHashMap();
    }

    public static void a(long r100) {
        t r101 = f511283a.remove(Long.valueOf(r100));
        if (r101 == null) goto L6;
        r101.a();
        return;
    }
}
