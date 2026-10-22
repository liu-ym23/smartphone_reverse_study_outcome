package wu6;

import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.hybrid.bridge.network.LifeSaasNetwork;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XIRetrofit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f561436a = 0;

    public static final class a implements XIRetrofit {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f561437a;

        public a(String r100) {
            this.f561437a = r100;
        }

        @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.XIRetrofit
        public final <T> T create(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "service");
            return (T) HostServiceUtilsKt.S().create(this.f561437a, r100);
        }
    }

    static {
    }

    public static XIRetrofit a(IHostNetworkDepend r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "originDepend");
        Intrinsics.checkNotNullParameter(r101, "baseUrl");
        if (LifeSaasNetwork.a(r101) == false) goto L7;
        return new a(r101);
    L7:
        return r100.createRetrofit(r101, r102);
    }
}
