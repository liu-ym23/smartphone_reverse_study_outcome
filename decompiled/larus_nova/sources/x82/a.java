package x82;

import ey.k;

/* JADX INFO: loaded from: classes9.dex */
public interface a extends com.bytedance.android.livesdk.interactivity.medialink.contract.b {

    /* JADX INFO: renamed from: t2, reason: collision with root package name */
    public static final C8201a f562886t2 = null;

    /* JADX INFO: renamed from: x82.a$a, reason: collision with other inner class name */
    public static final class C8201a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ C8201a f562887a = null;

        public C8201a() {
        }

        static {
            f562887a = new C8201a();
        }

        public static a a() {
            com.bytedance.android.livesdk.interactivity.medialink.contract.b.R0.getClass();
            com.bytedance.android.livesdk.interactivity.medialink.contract.b r100 = com.bytedance.android.livesdk.interactivity.medialink.contract.b.a.a();
            if ((r100 instanceof a) == true) goto L6;
            r100 = null;
        L6:
            return (a) r100;
        }
    }

    static {
        f562886t2 = C8201a.f562887a;
    }

    void Mn(String r100, dy.a r101);

    boolean N(String r100);

    com.bytedance.android.livesdk.interactivity.medialink.contract.d getConnectionContext();

    k getLinkOutManager();
}
