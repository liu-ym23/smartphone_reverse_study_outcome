package k57;

import com.bytedance.platform.aio.router.param.model.AioRpcParamSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: classes21.dex */
@JsonAdapter(AioRpcParamSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002¨\u0006\u0003"}, d2 = {"Lk57/f;", "Lk57/e;", "Lvh7/j;", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface f extends e, j<f> {

    @JsonAdapter(AioRpcParamSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "source")
    String getSource();

    @Override // k57.e
    /* synthetic */ String getType();

    @FieldName(name = "rpc_name")
    String o0();
}
