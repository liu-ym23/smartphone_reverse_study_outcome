package k11;

import com.bytedance.android.live.revlink.aio.CancelParamsAndResultDataSerializableObjectImpl;
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
@JsonAdapter(CancelParamsAndResultDataSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lk11/b;", "Lvh7/j;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.revlink.CancelParamsAndResultData")
public interface b extends vh7.j<b> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f501348j = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f501349a = null;

        public a() {
        }

        static {
            f501349a = new a();
        }

        public static b a(d11.i r100, Map r101, o r102, long r103, long r104, String r110) {
            Class<?> r105 = ((JsonAdapter) b.class.getAnnotation(JsonAdapter.class)).value();
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
            b r111 = (b) r109;
            r111.N3(r100);
            r111.e(r101);
            r111.a(r102);
            r111.d(r103);
            r111.b(r104);
            r111.setErrorMessage(r110);
            return r111;
        L17:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.aio.CancelParamsAndResultData");
        }
    }

    /* JADX INFO: renamed from: k11.b$b, reason: collision with other inner class name */
    @JsonAdapter(CancelParamsAndResultDataSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C6500b {
    }

    static {
        f501348j = a.f501349a;
    }

    @FieldName(name = "request_params#setter")
    void N3(d11.i r100);

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
}
