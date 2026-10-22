package kotlinx.coroutines.flow;

/* JADX INFO: loaded from: classes42.dex */
public interface g1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f504854a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f504855a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final h1 f504856b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final StartedLazily f504857c = null;

        public a() {
        }

        static {
            f504855a = new a();
            f504856b = new h1();
            f504857c = new StartedLazily();
        }

        public static StartedWhileSubscribed a(a r100, long r101, int r102) {
            long r103 = 0;
            if ((r102 & 1) == 0) goto L6;
            r101 = 0;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r103 = Long.MAX_VALUE;
        L8:
            r100.getClass();
            return new StartedWhileSubscribed(r101, r103);
        }
    }

    static {
        f504854a = a.f504855a;
    }

    Flow<SharingCommand> a(i1<Integer> r100);
}
