package gc6;

import com.bytedance.android.live.pushstream.d;
import com.bytedance.kmp.live.livelink.api.ILiveLinkServiceKmp;
import hh1.v0;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import uf2.d0;

/* JADX INFO: loaded from: classes19.dex */
public final class b {
    public static final d a(ec6.b r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toMain");
        return ((ILiveLinkServiceKmp) k.n(ILiveLinkServiceKmp.class)).unWrapBizLiveAVClient(r100);
    }

    public static final v0 b(ec6.a r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toMain");
        return ((ILiveLinkServiceKmp) k.n(ILiveLinkServiceKmp.class)).unWrapLiveVideoClientFactory(r100);
    }

    public static final ec6.a c(v0 r100, d0 r101) {
        Intrinsics.checkNotNullParameter(r100, "factory");
        return ((ILiveLinkServiceKmp) k.n(ILiveLinkServiceKmp.class)).wrapLiveVideoClientFactory(r100, r101);
    }
}
