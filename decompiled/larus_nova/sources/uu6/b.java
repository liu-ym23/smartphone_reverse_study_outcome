package uu6;

import com.bytedance.ies.xbridge.base.runtime.depend.IHostNetworkDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.XIRetrofit;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements IHostNetworkDepend {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IHostNetworkDepend f551767a;

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostNetworkDepend
    public final Map<String, Object> getAPIParams() {
        return this.f551767a.getAPIParams();
    }

    public b(IHostNetworkDepend r100) {
        Intrinsics.checkNotNullParameter(r100, "originDepend");
        this.f551767a = r100;
    }

    @Override // com.bytedance.ies.xbridge.base.runtime.depend.IHostNetworkDepend
    public final XIRetrofit createRetrofit(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        int r102 = wu6.a.f561434a;
        return wu6.a.a(this.f551767a, r100, r101);
    }
}
