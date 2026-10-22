package gy;

import com.bytedance.android.live.link.ILinkServiceExternal;
import jc1.k;

/* JADX INFO: loaded from: classes45.dex */
public interface c {

    /* JADX INFO: renamed from: c2, reason: collision with root package name */
    public static final a f483309c2 = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f483310a = null;

        public a() {
        }

        static {
            f483310a = new a();
        }

        public static c a() {
            return ((ILinkServiceExternal) k.n(ILinkServiceExternal.class)).getRtcService();
        }
    }

    static {
        f483309c2 = a.f483310a;
    }

    f getRtcManager();
}
