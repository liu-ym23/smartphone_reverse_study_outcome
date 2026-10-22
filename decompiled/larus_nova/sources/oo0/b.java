package oo0;

import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.impl.base.bootconfig.BootConfigContextService;
import com.bytedance.android.livesdk.sharedpref.f;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes46.dex */
public final class b<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BootConfigContextService f524507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f524508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function1 f524509c;

    public b(BootConfigContextService r100, String r101, Function1 r102) {
        this.f524507a = r100;
        this.f524508b = r101;
        this.f524509c = r102;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        qo0.a.c("BootConfigContextService", "requestBootConfig success, do not hit cache");
        com.bytedance.android.live.openplatform.impl.base.api.response.a r101 = (com.bytedance.android.live.openplatform.impl.base.api.response.a) ((e) r100).data;
        this.f524507a.f84010a.put(this.f524508b, r101);
        BootConfigContextService r102 = this.f524507a;
        String r103 = this.f524508b;
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.e<HashMap<String, String>> r104 = com.bytedance.android.livesdk.sharedpref.b.f158245z2;
        HashMap<String, String> r105 = r104.getValue();
        r105.put(r103, JsonUtil.toJSONString(r101));
        f.d(r104, r105);
        this.f524509c.invoke(r101);
    }
}
