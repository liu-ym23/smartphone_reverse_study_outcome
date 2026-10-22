package lsc;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes5.dex */
public final class l implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Class<? extends uvc.b>, x> f510608a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<Class<? extends uvc.b>, x> f510609a;

        public a() {
            this.f510609a = new HashMap(3);
        }

        public final a a(Class r100, x r101) {
            ((HashMap) this.f510609a).put(r100, r101);
            return this;
        }
    }

    public l(Map<Class<? extends uvc.b>, x> r100) {
        this.f510608a = r100;
    }

    public final <N extends uvc.b> x a(Class<N> r100) {
        return this.f510608a.get(r100);
    }
}
