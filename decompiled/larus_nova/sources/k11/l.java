package k11;

import com.bytedance.android.live.revlink.aio.PermitParamsAndResultDataSerializableObjectImpl;
import com.bytedance.android.livesdk.link.model.v;
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
@JsonAdapter(PermitParamsAndResultDataSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nR$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lk11/l;", "Lvh7/j;", "Lcom/bytedance/android/livesdk/link/model/bridge/m;", "getResult", "()Lcom/bytedance/android/livesdk/link/model/bridge/m;", "setResult", "(Lcom/bytedance/android/livesdk/link/model/bridge/m;)V", "getResult$annotations", "()V", "result", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.revlink.PermitParamsAndResultData")
public interface l extends vh7.j<l> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f501357m = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f501358a = null;

        public a() {
        }

        static {
            f501358a = new a();
        }

        public static l a(v r100, d11.k r101, Map r102, o r103, long r104, long r110, String r111) {
            Class<?> r105 = ((JsonAdapter) l.class.getAnnotation(JsonAdapter.class)).value();
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
            l r112 = (l) r109;
            r112.setResult(r100);
            r112.z1(r101);
            r112.e(r102);
            r112.a(r103);
            r112.d(r104);
            r112.b(r110);
            r112.setErrorMessage(r111);
            return r112;
        L17:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.aio.PermitParamsAndResultData");
        }
    }

    @JsonAdapter(PermitParamsAndResultDataSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        f501357m = a.f501358a;
    }

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
    void setResult(com.bytedance.android.livesdk.link.model.bridge.m r100);

    @FieldName(name = "request_params#setter")
    void z1(d11.k r100);
}
