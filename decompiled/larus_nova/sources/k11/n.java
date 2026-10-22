package k11;

import com.bytedance.android.live.revlink.aio.StateInfoSerializableObjectImpl;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(StateInfoSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lk11/n;", "Lvh7/j;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.revlink.StateInfo")
public interface n extends vh7.j<n> {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f501361o = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f501362a = null;

        public a() {
        }

        static {
            f501362a = new a();
        }

        public static n a(int r100, long r101) {
            Class<?> r102 = ((JsonAdapter) n.class.getAnnotation(JsonAdapter.class)).value();
            ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r103 = vh7.b.f554981a;
            Constructor r104 = r103.get(r102);
            if (r104 != null) goto L12;
            r104 = r102.getConstructor(new Class[0]);
            if (r104 == null) goto L11;
            Constructor<? extends SerializableObjectJsonAdapterBase> r105 = r103.putIfAbsent(r102, (Constructor<? extends SerializableObjectJsonAdapterBase>) r104);
            if (r105 == null) goto L12;
            r104 = r105;
            goto L12
        L11:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
        L12:
            Object r106 = ((SerializableObjectJsonAdapterBase) r104.newInstance(new Object[0])).createInstance();
            if (r106 == null) goto L17;
            n r107 = (n) r106;
            r107.N(r100);
            r107.setChannelId(r101);
            return r107;
        L17:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.aio.StateInfo");
        }
    }

    @JsonAdapter(StateInfoSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        f501361o = a.f501362a;
    }

    @FieldName(name = "state#setter")
    void N(int r100);

    @FieldName(name = "channel_id#setter")
    void setChannelId(long r100);
}
