package k11;

import com.bytedance.android.live.revlink.aio.StateTransitionSerializableObjectImpl;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(StateTransitionSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lk11/o;", "Lvh7/j;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.revlink.StateTransition")
public interface o extends vh7.j<o> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f501363p = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f501364a = null;

        public a() {
        }

        static {
            f501364a = new a();
        }
    }

    @JsonAdapter(StateTransitionSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        f501363p = a.f501364a;
    }

    @FieldName(name = "from_state#setter")
    void M6(n r100);

    @FieldName(name = "to_state#setter")
    void q2(n r100);
}
