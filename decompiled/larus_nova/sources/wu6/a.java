package wu6;

import com.bytedance.ies.xbridge.base.runtime.depend.IHostNetworkDepend;
import com.bytedance.ies.xbridge.base.runtime.depend.XIRetrofit;
import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.locallife.hybrid.bridge.network.LifeSaasNetwork;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f561434a = 0;

    /* JADX INFO: renamed from: wu6.a$a, reason: collision with other inner class name */
    public static final class C8162a implements XIRetrofit {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f561435a;

        public C8162a(String r100) {
            this.f561435a = r100;
        }

        @Override // com.bytedance.ies.xbridge.base.runtime.depend.XIRetrofit
        public final <T> T create(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "service");
            return (T) HostServiceUtilsKt.S().create(this.f561435a, r100);
        }
    }

    static {
    }

    public static XIRetrofit a(IHostNetworkDepend r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "originDepend");
        Intrinsics.checkNotNullParameter(r101, "baseUrl");
        if (LifeSaasNetwork.a(r101) == false) goto L7;
        return new C8162a(r101);
    L7:
        return r100.createRetrofit(r101, r102);
    }
}
