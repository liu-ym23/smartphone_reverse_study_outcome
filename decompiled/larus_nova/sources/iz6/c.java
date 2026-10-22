package iz6;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.intercept.Interceptor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f496704a;

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        this.f496704a = r100;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r100) {
        hz6.a r101 = hz6.a.f487703a;
        String r102 = this.f496704a;
        Intrinsics.checkNotNullParameter(r102, ST.UUID_DEVICE);
        hz6.a.f487704b.set(r102);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.proceed(r100.request());
    }
}
