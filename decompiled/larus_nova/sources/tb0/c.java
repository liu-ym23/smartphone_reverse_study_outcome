package tb0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public tb0.b f545225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f545226b;

    public static final class a extends c {
        public a(tb0.b r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            super(r100, "Feed");
        }
    }

    public static final class b extends c {
        public b(tb0.b r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            super(r100, "InRoom");
        }
    }

    /* JADX INFO: renamed from: tb0.c$c, reason: collision with other inner class name */
    public static final class C7707c extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final C7707c f545227c = null;

        public C7707c() {
            super(null, "init");
        }

        static {
            f545227c = new C7707c();
        }
    }

    public c(tb0.b r100, String r101) {
        this.f545225a = r100;
        this.f545226b = r101;
    }
}
