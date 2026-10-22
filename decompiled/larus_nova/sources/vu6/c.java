package vu6;

import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPureNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XIRetrofit;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements IHostPureNetworkDepend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IHostNetworkDepend f557359a;

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend
    public final Map<String, Object> getAPIParams() {
        return this.f557359a.getAPIParams();
    }

    public c(IHostPureNetworkDepend r100) {
        Intrinsics.checkNotNullParameter(r100, "originDepend");
        this.f557359a = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend
    public final XIRetrofit createRetrofit(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        int r102 = wu6.b.f561436a;
        return wu6.b.a(this.f557359a, r100, r101);
    }
}
