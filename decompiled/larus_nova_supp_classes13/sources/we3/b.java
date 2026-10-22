package we3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class b extends z83.b {

    public static final class a extends b {
        public final boolean b;

        public a(boolean r2) {
            super("event_list_animated_set_visibility");
            this.b = r2;
        }
    }

    /* JADX INFO: renamed from: we3.b$b, reason: collision with other inner class name */
    public static final class C0239b extends b {
        public final boolean b;

        public C0239b() {
            super("event_list_close");
            this.b = false;
        }
    }

    public static final class c extends b {
        public final boolean b;
        public final boolean c;
        public final boolean d;

        public c(boolean r2, boolean r3, boolean r4) {
            super("event_list_refresh");
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public /* synthetic */ c(boolean r2, boolean r3, int r4) {
            if ((r4 & 2) == 0) goto L5;
            r3 = false;
        L5:
            this(r2, r3, false);
        }
    }

    public static final class d extends b {
    }

    public b(String r1) {
        super(r1);
    }
}
