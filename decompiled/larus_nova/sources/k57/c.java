package k57;

import com.bytedance.platform.aio.router.param.model.AioInitialRpcInfoSerializableObjectImpl;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: classes21.dex */
@JsonAdapter(AioInitialRpcInfoSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lk57/c;", "Lvh7/j;", "live-kmp-platform-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c extends j<c> {

    @JsonAdapter(AioInitialRpcInfoSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "param_names")
    List<f> P3();

    @FieldName(name = "id")
    String getId();
}
