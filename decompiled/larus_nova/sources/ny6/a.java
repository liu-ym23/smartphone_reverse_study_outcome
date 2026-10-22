package ny6;

import com.byted.cast.linkcommon.cybergarage.upnp.device.ST;
import com.bytedance.locallife.poi.dito.container.api.DitoPoiApi;
import com.bytedance.retrofit2.SsResponse;
import com.bytedance.retrofit2.intercept.Interceptor;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements Interceptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f521207a;

    public a(String r100) {
        Intrinsics.checkNotNullParameter(r100, ST.UUID_DEVICE);
        this.f521207a = r100;
    }

    @Override // com.bytedance.retrofit2.intercept.Interceptor
    public final SsResponse<?> intercept(Interceptor.Chain r100) {
        com.bytedance.locallife.poi.dito.mob.a r101 = com.bytedance.locallife.poi.dito.mob.a.f262418a;
        String r102 = this.f521207a;
        Intrinsics.checkNotNullParameter(r102, ST.UUID_DEVICE);
        com.bytedance.locallife.poi.dito.mob.a.f262421d.set(r102);
        String r103 = DitoPoiApi.f262360f;
        DitoPoiApi.f262360f = this.f521207a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.proceed(r100.request());
    }
}
