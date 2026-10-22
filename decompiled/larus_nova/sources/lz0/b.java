package lz0;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Llz0/b;", "", "", "interfaceId", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "params", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "d", "(Ljava/lang/Object;)V", "<init>", "()V", "live-kmp-platform-dynamic-api_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "core.service.LazyLoadRequest")
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f511340a = null;

    @SerializedName("interface_id")
    private String interfaceId;

    @SerializedName("params")
    private Object params;

    public static final class a implements uh7.c.b<b> {
        public a() {
        }

        @Override // uh7.c.b
        public final void a() {
            a r100 = b.f511340a;
        }

        @Override // uh7.c.b
        public final boolean b(KClass<?> r100) {
            Intrinsics.checkNotNullParameter(r100, "type");
            return Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(b.class), r100);
        }

        @Override // uh7.c.b
        public final JsonObject e(Object r100, uh7.c.a r101) {
            b r102 = (b) r100;
            Intrinsics.checkNotNullParameter(r102, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
            return uh7.c.b.a.a(r102, r101);
        }

        @Override // uh7.c.b
        public final void c(com.bytedance.tools.kcp.modelx.runtime.protobuf.b r100, Object r101, uh7.c.a r102) {
            b r103 = (b) r101;
            Intrinsics.checkNotNullParameter(r100, "$this$writeProtobuf");
            Intrinsics.checkNotNullParameter(r103, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            r100.d(r103.a(), 1);
            Object r104 = r103.b();
            if ((r104 instanceof byte[]) == false) goto L5;
            r100.b((byte[]) r104, 2);
            return;
        L5:
            if (r104 != null) goto L8;
            return;
        L8:
            throw new IllegalStateException(("unknown type of params " + r104).toString());
        }

        @Override // uh7.c.b
        public final Object d(KClass r100, JsonObject r101, uh7.c.a r102) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "jsonObject");
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "jsonObject");
            Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
            return (b) r102.a(r101, r100);
        }
    }

    static {
        f511340a = new a();
    }

    public final void c() {
        Intrinsics.checkNotNullParameter("webcast.revenue.biz.luckyBox.LuckyBoxDataService", "<set-?>");
        this.interfaceId = "webcast.revenue.biz.luckyBox.LuckyBoxDataService";
    }

    public b() {
        this.interfaceId = "";
    }

    public final String a() {
        return this.interfaceId;
    }

    public final Object b() {
        return this.params;
    }

    public final void d(Object r100) {
        this.params = r100;
    }
}
