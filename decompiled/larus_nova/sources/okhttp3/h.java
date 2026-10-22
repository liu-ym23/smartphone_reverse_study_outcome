package okhttp3;

import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
public interface h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f523873a = null;

    public static class a implements h {
        public a() {
        }

        @Override // okhttp3.h
        public final void b(HttpUrl r100, List<g> r101) {
        }

        @Override // okhttp3.h
        public final List<g> a(HttpUrl r100) {
            return Collections.emptyList();
        }
    }

    List<g> a(HttpUrl r100);

    void b(HttpUrl r100, List<g> r101);

    static {
        f523873a = new a();
    }
}
