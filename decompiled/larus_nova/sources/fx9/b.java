package fx9;

import com.obric.trace.ObricActionBarTrackType;

/* JADX INFO: loaded from: classes31.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f479117a;

    public static final class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f479118b = null;

        static {
            f479118b = new a();
        }

        public a() {
            super("bottom_menu");
        }
    }

    /* JADX INFO: renamed from: fx9.b$b, reason: collision with other inner class name */
    public static final class C5961b extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C5961b f479119b = null;

        static {
            f479119b = new C5961b();
        }

        public C5961b() {
            super("ime");
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f479120b = null;

        static {
            f479120b = new c();
        }

        public c() {
            super(ObricActionBarTrackType.SPEAK);
        }
    }

    public b(String r100) {
        this.f479117a = r100;
    }
}
