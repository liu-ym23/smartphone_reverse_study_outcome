package uu6;

import com.bytedance.ies.xbridge.base.runtime.depend.IHostNetworkDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.IHostPureNetworkDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.XIRetrofit;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements IHostPureNetworkDepend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IHostNetworkDepend f551768a;

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostNetworkDepend
    public final Map<String, Object> getAPIParams() {
        return null;
    }

    public c(IHostPureNetworkDepend r100) {
        Intrinsics.checkNotNullParameter(r100, "originDepend");
        this.f551768a = r100;
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostNetworkDepend
    public final XIRetrofit createRetrofit(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        int r102 = wu6.a.f561434a;
        return wu6.a.a(this.f551768a, r100, r101);
    }
}
