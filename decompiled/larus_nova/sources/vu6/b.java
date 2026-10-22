package vu6;

import com.bytedance.locallife.hybrid.bridge.network.LifeSaasNetwork;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XIRetrofit;
import com.bytedance.sdk.xbridge.cn.runtime.depend.f;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f557358a;

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend
    public final Map<String, Object> getAPIParams() {
        return this.f557358a.getAPIParams();
    }

    public b(f r100) {
        Intrinsics.checkNotNullParameter(r100, "originDepend");
        this.f557358a = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend
    public final XIRetrofit createRetrofit(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        int r102 = wu6.b.f561436a;
        return wu6.b.a(this.f557358a, r100, r101);
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.f
    public final XIRetrofit createRetrofit(String r100, boolean r101, Map<String, ? extends Object> r102) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        int r103 = wu6.b.f561436a;
        f r104 = this.f557358a;
        Intrinsics.checkNotNullParameter(r104, "originDepend");
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        if (LifeSaasNetwork.a(r100) == false) goto L6;
        return new wu6.c(r100);
    L6:
        return r104.createRetrofit(r100, r101, r102);
    }
}
