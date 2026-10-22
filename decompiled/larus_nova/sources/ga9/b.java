package ga9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f480596a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f480597a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C5999a f480598b = null;

        /* JADX INFO: renamed from: ga9.b$a$a, reason: collision with other inner class name */
        public static final class C5999a implements b {
            public C5999a() {
            }

            @Override // ga9.b
            public final void i(String r100) {
                Intrinsics.checkNotNullParameter("FlowClientExperiment", "tag");
                Intrinsics.checkNotNullParameter(r100, "msg");
            }

            @Override // ga9.b
            public final void w(String r100) {
                Intrinsics.checkNotNullParameter("FlowClientExperiment", "tag");
                Intrinsics.checkNotNullParameter(r100, "msg");
            }
        }

        public a() {
        }

        static {
            f480597a = new a();
            f480598b = new C5999a();
        }
    }

    static {
        f480596a = a.f480597a;
    }

    void i(String r100);

    void w(String r100);
}
