package zz0;

import com.bytedance.android.live.revenue.platform.schema.api.HybridComponentConfigSerializableObjectImpl;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(HybridComponentConfigSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lzz0/a;", "Lvh7/j;", "live-kmp-platform-dynamic-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.foundation.HybridComponentConfig")
public interface a extends vh7.j<a> {

    /* JADX INFO: renamed from: zz0.a$a, reason: collision with other inner class name */
    @JsonAdapter(HybridComponentConfigSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C8508a {
    }

    @FieldName(name = "aio_router_key")
    String E3();
}
