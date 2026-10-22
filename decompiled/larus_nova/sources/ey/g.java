package ey;

import com.bytedance.android.live.link.ILinkServiceExternal;

/* JADX INFO: loaded from: classes45.dex */
public interface g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f474778a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f474779a = null;

        public a() {
        }

        static {
            f474779a = new a();
        }

        public static nc0.b a() {
            com.bytedance.android.live.revenuelink.connect.f r100 = ((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getConnectService();
            if (r100 != null) goto L7;
            return null;
        L7:
            return new nc0.b(r100);
        }
    }

    static {
        f474778a = a.f474779a;
    }

    void a(int r100, j r101);
}
