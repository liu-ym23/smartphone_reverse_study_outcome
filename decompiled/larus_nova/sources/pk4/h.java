package pk4;

import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public interface h {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C7206a f529626a = null;

        /* JADX INFO: renamed from: pk4.h$a$a, reason: collision with other inner class name */
        public class C7206a implements h {
            public C7206a() {
            }

            @Override // pk4.h
            public final /* synthetic */ Map e() {
                return null;
            }

            @Override // pk4.h
            public final void d(String r100, Map r101) {
                j.a("T[" + r100 + "]", l.a(r101.size(), r101.keySet()));
            }
        }

        static {
            f529626a = new C7206a();
        }
    }

    void d(String r100, Map<String, Object> r101);

    Map<String, Object> e();
}
