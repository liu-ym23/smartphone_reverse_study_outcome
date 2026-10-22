package m41;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f511832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f511833b;

    public static final class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f511834c = null;

        public a() {
            super("AutoUnload", null);
        }

        static {
            f511834c = new a();
        }
    }

    /* JADX INFO: renamed from: m41.b$b, reason: collision with other inner class name */
    public static final class C6767b extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final C6767b f511835c = null;

        public C6767b() {
            super("switch_to_link", null);
        }

        static {
            f511835c = new C6767b();
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f511836c = null;

        public c() {
            super("Unknown", null);
        }

        static {
            f511836c = new c();
        }
    }

    public static final class d extends b {
        public d() {
            Intrinsics.checkNotNullParameter("CMD_AUDIENCE_TURN_OFF_ENGINE", "source");
            super("Unexpected", "CMD_AUDIENCE_TURN_OFF_ENGINE");
        }
    }

    public final String toString() {
        String r100 = this.f511833b;
        if (r100 == null) goto L7;
        String r101 = this.f511832a + '_' + r100;
        if (r101 == null) goto L7;
        return r101;
    L7:
        return this.f511832a;
    }

    public b(String r100, String r101) {
        this.f511832a = r100;
        this.f511833b = r101;
    }
}
