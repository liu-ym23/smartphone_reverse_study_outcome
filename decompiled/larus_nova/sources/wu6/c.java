package wu6;

import com.bytedance.locallife.biz.common.utils.HostServiceUtilsKt;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XIRetrofit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c implements XIRetrofit {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f561438a;

    public c(String r100) {
        this.f561438a = r100;
    }

    @Override // com.bytedance.sdk.xbridge.cn.runtime.depend.XIRetrofit
    public final <T> T create(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "service");
        return (T) HostServiceUtilsKt.S().create(this.f561438a, r100);
    }
}
