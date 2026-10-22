package pu0;

import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR>\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lpu0/c;", "", "", "", "Lpu0/h;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "regions", "Ljava/util/Map;", "getRegions", "()Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/util/Map;)V", "<init>", "()V", "live-privilege-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.live_pet.LinkRegion")
public final class c {

    @SerializedName("regions")
    private Map<String, h> regions;

    public c() {
        this.regions = MapsKt.emptyMap();
    }

    public final void a(Map<String, h> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.regions = r100;
    }
}
