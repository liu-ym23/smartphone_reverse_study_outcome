package we3;

/* JADX INFO: loaded from: classes13.dex */
public abstract class b extends z83.b {

    public static final class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f559387b;

        public a(boolean r100) {
            super("event_list_animated_set_visibility");
            this.f559387b = r100;
        }
    }

    /* JADX INFO: renamed from: we3.b$b, reason: collision with other inner class name */
    public static final class C8101b extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f559388b;

        public C8101b() {
            super("event_list_close");
            this.f559388b = false;
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f559389b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f559390c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f559391d;

        public c(boolean r100, boolean r101, boolean r102) {
            super("event_list_refresh");
            this.f559389b = r100;
            this.f559390c = r101;
            this.f559391d = r102;
        }

        public /* synthetic */ c(boolean r100, boolean r101, int r102) {
            if ((r102 & 2) == 0) goto L5;
            r101 = false;
        L5:
            this(r100, r101, false);
        }
    }

    public static final class d extends b {
    }

    public b(String r100) {
        super(r100);
    }
}
