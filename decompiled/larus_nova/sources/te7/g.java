package te7;

import com.bytedance.frameworks.baselib.network.http.retrofit.SsHttpExecutor;
import com.bytedance.retrofit2.Retrofit;
import com.bytedance.retrofit2.client.Client;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XIRetrofit;
import com.bytedance.ttnet.retrofit.SsInterceptor;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class g implements IHostNetworkDepend {

    public final class a implements XIRetrofit {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Retrofit f545609a;

        public a(Retrofit r100) {
            Intrinsics.checkNotNullParameter(r100, "retrofit");
            this.f545609a = r100;
        }

        @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.XIRetrofit
        public final <T> T create(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "service");
            return (T) this.f545609a.create(r100);
        }
    }

    public g() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend
    public final Map<String, Object> getAPIParams() {
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend
    public final XIRetrofit createRetrofit(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        int r102 = se7.f.f541620a;
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        Retrofit.Builder r103 = new Retrofit.Builder().setEndpoint(r100).addConverterFactory(rx5.a.a()).httpExecutor(new SsHttpExecutor()).addInterceptor(new SsInterceptor());
        if (r101 == false) goto L5;
        Client.Provider r104 = new se7.e();
    L7:
        return new a(r103.client(r104).build());
    L5:
        r104 = new se7.g();
        goto L7
    }
}
