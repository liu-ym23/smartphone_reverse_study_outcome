package k11;

import com.bytedance.android.live.revlink.aio.ReplyParamsAndResultDataSerializableObjectImpl;
import com.bytedance.android.livesdk.link.model.bridge.d1;
import com.bytedance.android.livesdk.link.model.q5;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(ReplyParamsAndResultDataSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nR$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lk11/m;", "Lvh7/j;", "Lcom/bytedance/android/livesdk/link/model/bridge/d1;", "getResult", "()Lcom/bytedance/android/livesdk/link/model/bridge/d1;", "setResult", "(Lcom/bytedance/android/livesdk/link/model/bridge/d1;)V", "getResult$annotations", "()V", "result", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.revlink.ReplyParamsAndResultData")
public interface m extends vh7.j<m> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f501359n = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f501360a = null;

        public a() {
        }

        static {
            f501360a = new a();
        }

        public static m a(q5 r100, d11.l r101, Map r102, o r103, long r104, long r110, String r111) {
            Class<?> r105 = ((JsonAdapter) m.class.getAnnotation(JsonAdapter.class)).value();
            ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r106 = vh7.b.f554981a;
            Constructor r107 = r106.get(r105);
            if (r107 != null) goto L12;
            r107 = r105.getConstructor(new Class[0]);
            if (r107 == null) goto L11;
            Constructor<? extends SerializableObjectJsonAdapterBase> r108 = r106.putIfAbsent(r105, (Constructor<? extends SerializableObjectJsonAdapterBase>) r107);
            if (r108 == null) goto L12;
            r107 = r108;
            goto L12
        L11:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
        L12:
            Object r109 = ((SerializableObjectJsonAdapterBase) r107.newInstance(new Object[0])).createInstance();
            if (r109 == null) goto L17;
            m r112 = (m) r109;
            r112.setResult(r100);
            r112.A6(r101);
            r112.e(r102);
            r112.a(r103);
            r112.d(r104);
            r112.b(r110);
            r112.setErrorMessage(r111);
            return r112;
        L17:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.aio.ReplyParamsAndResultData");
        }
    }

    @JsonAdapter(ReplyParamsAndResultDataSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        f501359n = a.f501360a;
    }

    @FieldName(name = "request_params#setter")
    void A6(d11.l r100);

    @FieldName(name = "state_transition#setter")
    void a(o r100);

    @FieldName(name = "error_code#setter")
    void b(long r100);

    @FieldName(name = "start_ts#setter")
    void d(long r100);

    @FieldName(name = "client_params#setter")
    void e(Map<String, String> r100);

    @FieldName(name = "error_message#setter")
    void setErrorMessage(String r100);

    @FieldName(name = "response#setter")
    void setResult(d1 r100);
}
