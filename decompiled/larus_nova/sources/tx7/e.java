package tx7;

import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XIRetrofit;
import com.ivy.ivykit.api.bridge.inject.IvyIRetrofit;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class e implements IHostNetworkDepend {

    public static final class a implements XIRetrofit {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ IvyIRetrofit f547828a;

        public a(IvyIRetrofit r100) {
            this.f547828a = r100;
        }

        @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.XIRetrofit
        public final <T> T create(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "service");
            return (T) this.f547828a.create(r100);
        }
    }

    public e() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend
    public final Map<String, Object> getAPIParams() {
        Map<Class<?>, com.ivy.ivykit.api.bridge.d<?>> r100 = com.ivy.ivykit.api.bridge.b.f278301a;
        hx7.d r101 = (hx7.d) com.ivy.ivykit.api.bridge.b.a(hx7.d.class);
        if (r101 == null) goto L7;
        r101.getAPIParams();
        return null;
    L7:
        return null;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.IHostNetworkDepend
    public final XIRetrofit createRetrofit(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "baseUrl");
        Map<Class<?>, com.ivy.ivykit.api.bridge.d<?>> r102 = com.ivy.ivykit.api.bridge.b.f278301a;
        hx7.d r103 = (hx7.d) com.ivy.ivykit.api.bridge.b.a(hx7.d.class);
        if (r103 == null) goto L9;
        h4a.f.a r104 = r103.createRetrofit(r100, r101);
        if (r104 != null) goto L8;
        return null;
    L8:
        return new a(r104);
    L9:
        return null;
    }
}
