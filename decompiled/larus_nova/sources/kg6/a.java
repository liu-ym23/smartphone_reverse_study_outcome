package kg6;

/* JADX INFO: loaded from: classes19.dex */
public abstract class a extends mg6.c {

    /* JADX INFO: renamed from: kg6.a$a, reason: collision with other inner class name */
    public static final class C6550a extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C6550a f503374b = null;

        static {
            f503374b = new C6550a();
        }

        public C6550a() {
            super("audio_capture_status");
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f503375b = null;

        static {
            f503375b = new b();
        }

        public b() {
            super("audio_mute_status");
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f503376b = null;

        static {
            f503376b = new c();
        }

        public c() {
            super("audio_stream_status");
        }
    }

    public a(String r100) {
        super(r100);
    }
}
