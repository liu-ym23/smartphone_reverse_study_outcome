package m60;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes45.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<o60.c>> f512254a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f512255a = null;

        static {
            f512255a = new d();
        }
    }

    public d() {
        this.f512254a = new HashMap();
    }

    public final List<o60.c> a(String r100) {
        List<o60.c> r101 = (List) ((HashMap) this.f512254a).get(r100);
        if (r101 != null) goto L6;
        ArrayList r102 = new ArrayList();
        ((HashMap) this.f512254a).put(r100, r102);
        return r102;
    L6:
        return r101;
    }
}
