package j01;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.android.live.revenue.platform.trace.api.MonitorRequestSerializableObjectImpl;
import com.bytedance.revenue.platform.api.core.JsonOrBytesJvm;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.bytedance.tools.kcp.modelx.runtime.protobuf.MessagePayload;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.JsonAdapter;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import vh7.j;

/* JADX INFO: loaded from: classes47.dex */
@JsonAdapter(MonitorRequestSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lj01/c;", "Lvh7/j;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "live-kmp-platform-base_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.foundation.MonitorRequest")
public interface c extends j<c> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f496786g = null;

    public static final class a implements uh7.c.b<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f496787a = null;

        public a() {
        }

        @Override // uh7.c.b
        public final void a() {
        }

        static {
            f496787a = new a();
        }

        @Override // uh7.c.b
        public final boolean b(KClass<?> r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            return Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(c.class), r100);
        }

        @Override // uh7.c.b
        public final JsonObject e(Object r100, uh7.c.a r101) {
            c r102 = (c) r100;
            Intrinsics.checkNotNullParameter(r102, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            JsonObject r103 = new JsonObject();
            j01.a.InterfaceC6375a r104 = r102.getMeta();
            if (r104 == null) goto L5;
            r103.add("meta", r101.b(r104));
        L5:
            JsonOrBytesJvm r105 = r102.getCategory();
            if (r105 == null) goto L8;
            r103.add("category", r101.b(r105));
        L8:
            JsonOrBytesJvm r106 = r102.y6();
            if (r106 == null) goto L11;
            r103.add("metric", r101.b(r106));
        L11:
            JsonOrBytesJvm r107 = r102.getExtra();
            if (r107 == null) goto L14;
            r103.add("extra", r101.b(r107));
        L14:
            return r103;
        }

        @Override // uh7.c.b
        public final void c(com.bytedance.tools.kcp.modelx.runtime.protobuf.b r100, Object r101, uh7.c.a r102) {
            c r103 = (c) r101;
            Intrinsics.checkNotNullParameter(r100, "$this$writeProtobuf");
            Intrinsics.checkNotNullParameter(r103, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            j01.a.InterfaceC6375a r104 = r103.getMeta();
            if (r104 == null) goto L9;
            com.bytedance.tools.kcp.modelx.runtime.protobuf.b r105 = new com.bytedance.tools.kcp.modelx.runtime.protobuf.b(r100.f271000b);
            r102.c(r105, r104);
            MessagePayload r106 = r105.a(1);
            if (r100.f271000b == true) goto L7;
        L8:
            ((ArrayList) r100.f270999a).add(r106);
            goto L9
        L7:
            if (r106.d() == true) goto L8;
        L9:
            JsonOrBytesJvm r107 = r103.getCategory();
            JsonOrBytesJvm r108 = null;
            if (r107 != null) goto L12;
        L17:
            JsonOrBytesJvm r109 = r103.y6();
            if (r109 != null) goto L20;
        L25:
            JsonOrBytesJvm r110 = r103.getExtra();
            if (r110 != null) goto L28;
            return;
        L28:
            if (r110.a() == false) goto L30;
            r108 = r110;
        L30:
            if (r108 == null) goto L34;
            r100.d(r108.b().toString(), 4);
            return;
        L34:
            return;
        L20:
            if (r109.a() == true) goto L23;
            r109 = null;
        L23:
            if (r109 == null) goto L25;
            r100.d(r109.b().toString(), 3);
            goto L25
        L12:
            if (r107.a() == true) goto L15;
            r107 = null;
        L15:
            if (r107 == null) goto L17;
            r100.d(r107.b().toString(), 2);
            goto L17
        }

        @Override // uh7.c.b
        public final Object d(KClass r100, JsonObject r101, uh7.c.a r102) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "jsonObject");
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            Class<?> r103 = ((JsonAdapter) c.class.getAnnotation(JsonAdapter.class)).value();
            ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r104 = vh7.b.f554981a;
            Constructor r105 = r104.get(r103);
            if (r105 != null) goto L12;
            r105 = r103.getConstructor(new Class[0]);
            if (r105 == null) goto L11;
            Constructor<? extends SerializableObjectJsonAdapterBase> r106 = r104.putIfAbsent(r103, (Constructor<? extends SerializableObjectJsonAdapterBase>) r105);
            if (r106 == null) goto L12;
            r105 = r106;
            goto L12
        L11:
            throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
        L12:
            Object r107 = ((SerializableObjectJsonAdapterBase) r105.newInstance(new Object[0])).createInstance();
            if (r107 == null) goto L28;
            c r108 = (c) r107;
            JsonElement r109 = r101.get("meta");
            if (r109 == null) goto L17;
            r108.i4((j01.a.InterfaceC6375a) r102.a(r109.getAsJsonObject(), Reflection.getOrCreateKotlinClass(j01.a.InterfaceC6375a.class)));
        L17:
            JsonElement r110 = r101.get("category");
            if (r110 == null) goto L20;
            r108.f1(new JsonOrBytesJvm(r110));
        L20:
            JsonElement r111 = r101.get("metric");
            if (r111 == null) goto L23;
            r108.D3(new JsonOrBytesJvm(r111));
        L23:
            JsonElement r112 = r101.get("extra");
            if (r112 == null) goto L26;
            r108.W0(new JsonOrBytesJvm(r112));
        L26:
            return r108;
        L28:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revenue.platform.trace.api.MonitorRequest");
        }
    }

    @JsonAdapter(MonitorRequestSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        f496786g = a.f496787a;
    }

    @FieldName(name = "metric#setter")
    void D3(JsonOrBytesJvm r100);

    @FieldName(name = "extra#setter")
    void W0(JsonOrBytesJvm r100);

    @FieldName(name = "category#setter")
    void f1(JsonOrBytesJvm r100);

    @FieldName(name = "category")
    JsonOrBytesJvm getCategory();

    @FieldName(name = "extra")
    JsonOrBytesJvm getExtra();

    @FieldName(name = "meta")
    j01.a.InterfaceC6375a getMeta();

    @FieldName(name = "meta#setter")
    void i4(j01.a.InterfaceC6375a r100);

    @FieldName(name = "metric")
    JsonOrBytesJvm y6();
}
