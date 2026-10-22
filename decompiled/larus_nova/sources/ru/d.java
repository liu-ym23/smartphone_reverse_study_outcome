package ru;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes44.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, List<uu.c>> f539222a;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f539223a = null;

        static {
            f539223a = new d();
        }
    }

    public d() {
        this.f539222a = new HashMap();
    }

    public final List<uu.c> a(String r100) {
        List<uu.c> r101 = (List) ((HashMap) this.f539222a).get(r100);
        if (r101 != null) goto L6;
        ArrayList r102 = new ArrayList();
        ((HashMap) this.f539222a).put(r100, r102);
        return r102;
    L6:
        return r101;
    }
}
