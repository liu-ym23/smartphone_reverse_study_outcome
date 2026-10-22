package mv0;

import com.bytedance.android.live.pkaudience.api.IPkAudienceLinkOutService;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b0 extends qs0.a<IPkAudienceLinkOutService> implements qs0.u {

    public static final class a extends qs0.a<com.bytedance.android.live.pkaudience.api.a> {
        public a(com.bytedance.android.live.pkaudience.api.a r100) {
            Intrinsics.checkNotNullParameter(r100, "proxy");
            super(r100);
        }

        public final int k(String r100) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            return ((com.bytedance.android.live.pkaudience.api.a) this.f534640a).O4(r100);
        }

        public final boolean l(String r100) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            return ((com.bytedance.android.live.pkaudience.api.a) this.f534640a).a(r100);
        }
    }

    public b0() {
        super(jc1.k.n(IPkAudienceLinkOutService.class));
    }

    @Override // qs0.u
    public final a getPkLinkUserInfoCenter() {
        com.bytedance.android.live.pkaudience.api.a r100 = ((IPkAudienceLinkOutService) this.f534640a).getPkLinkUserInfoCenter();
        if (r100 != null) goto L7;
        return null;
    L7:
        return new a(r100);
    }
}
