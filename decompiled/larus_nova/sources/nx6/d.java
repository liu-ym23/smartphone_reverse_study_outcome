package nx6;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.intercept.Interceptor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class d implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f521061a;

    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        this.f521061a = r100;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r100) {
        com.bytedance.locallife.pdp.mob.b r101 = com.bytedance.locallife.pdp.mob.b.f261576a;
        com.bytedance.locallife.pdp.mob.b.f261577b.set(this.f521061a);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.proceed(r100.request());
    }
}
