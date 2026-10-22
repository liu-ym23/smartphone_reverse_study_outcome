package i12;

/* JADX INFO: loaded from: classes9.dex */
public interface m {

    /* JADX INFO: renamed from: e2, reason: collision with root package name */
    public static final a f487958e2 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f487959a = null;

        public a() {
        }

        static {
            f487959a = new a();
        }

        public final d a() {
            Object r100 = com.bytedance.live.datacontext.d.d(this);
            if ((r100 instanceof m) == true) goto L5;
            r100 = null;
        L5:
            m r101 = (m) r100;
            if (r101 != null) goto L8;
            return null;
        L8:
            return r101.getInst();
        }
    }

    static {
        f487958e2 = a.f487959a;
    }

    d getInst();
}
