package vkc;

import android.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes40.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f555562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final vkc.b f555563b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Pair<String, String>> f555564c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f555565d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Integer> f555566e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f555567f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f555568g;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f555569a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public vkc.b f555570b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f555571c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Map<String, Integer> f555572d;

        public a() {
        }
    }

    public static class b implements vkc.b {
        public b() {
        }

        @Override // vkc.b
        public final String executeGet(String r100) throws Exception {
            throw new RuntimeException("no implementation");
        }

        @Override // vkc.b
        public final String a(String r100, byte[] r101) throws Exception {
            throw new RuntimeException("no implementation");
        }
    }

    public c(a r100) {
        this.f555567f = 10000;
        this.f555568g = 5;
        r100.getClass();
        this.f555562a = r100.f555569a;
        vkc.b r101 = r100.f555570b;
        if (r101 != null) goto L5;
        this.f555563b = new b();
    L6:
        this.f555564c = new ArrayList();
        this.f555565d = r100.f555571c;
        Map<String, Integer> r102 = r100.f555572d;
        this.f555566e = r102;
        if (r102 != null) goto L9;
        return;
    L9:
        if (r102.containsKey("request_retry_interval") == false) goto L12;
        this.f555567f = r102.get("request_retry_interval").intValue();
    L12:
        if (r102.containsKey("request_max_retry_times") == false) goto L15;
        this.f555568g = r102.get("request_max_retry_times").intValue();
    L15:
        return;
    L5:
        this.f555563b = r101;
        goto L6
    }
}
