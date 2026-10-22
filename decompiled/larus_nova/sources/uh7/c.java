package uh7;

import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.tools.kcp.modelx.runtime.protobuf.f;
import com.bytedance.tools.kcp.modelx.runtime.protobuf.g;
import com.google.gson.JsonObject;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NotImplementedError;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* JADX INFO: loaded from: classes22.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<b<?>> f550103a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<KClass<?>, b<?>> f550104b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<KClass<?>, Type> f550105c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final c f550106d = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final KClass<?> f550107a;

        public a(KClass<?> r100) {
            Intrinsics.checkNotNullParameter(r100, "selfType");
            this.f550107a = r100;
        }

        public final <T> JsonObject b(T r100) {
            Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r100.getClass()), this.f550107a) == true) goto L5;
            c.f550106d.getClass();
            return c.e(r100);
        L5:
            return GsonProtectorUtils.toJsonTree(uh7.b.f550102a, r100).getAsJsonObject();
        }

        public final <T> T a(JsonObject r100, KClass<T> r101) {
            Intrinsics.checkNotNullParameter(r100, "jsonObject");
            Intrinsics.checkNotNullParameter(r101, "type");
            if (Intrinsics.areEqual(r101, this.f550107a) == false) goto L6;
            Type r102 = (Type) ((LinkedHashMap) c.f550105c).get(r101);
            Intrinsics.checkNotNullParameter(r100, "jsonObject");
            Intrinsics.checkNotNullParameter(r101, "type");
            return (T) GsonProtectorUtils.fromJson(l97.a.f508113a, r100, JvmClassMappingKt.getJavaClass(r101));
        L6:
            c r103 = c.f550106d;
            Type r104 = (Type) ((LinkedHashMap) c.f550105c).get(r101);
            r103.getClass();
            return (T) c.a(r100, r101, r104);
        }

        public final <T> void c(com.bytedance.tools.kcp.modelx.runtime.protobuf.b r100, T r101) {
            Intrinsics.checkNotNullParameter(r100, "$this$writeProtobuf");
            Intrinsics.checkNotNullParameter(r101, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
            if ((!Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r101.getClass()), this.f550107a)) == false) goto L11;
            c r102 = c.f550106d;
            KClass r103 = Reflection.getOrCreateKotlinClass(r101.getClass());
            r102.getClass();
            b r104 = c.b(r103);
            if (r104 == null) goto L9;
            c.d(r100, r101, r104);
            return;
        L9:
            throw new IllegalArgumentException(("missing adapter for type: " + Reflection.getOrCreateKotlinClass(r101.getClass())).toString());
        L11:
            throw new IllegalStateException(("cannot serialize type: " + this.f550107a).toString());
        }
    }

    public interface b<T> {

        public static final class a {
            public static JsonObject a(Object r100, a r101) {
                Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
                Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
                return r101.b(r100);
            }
        }

        void a();

        boolean b(KClass<?> r100);

        void c(com.bytedance.tools.kcp.modelx.runtime.protobuf.b r100, Object r101, a r102);

        Object d(KClass r100, JsonObject r101, a r102);

        JsonObject e(Object r100, a r101);
    }

    public c() {
    }

    static {
        f550106d = new c();
        f550103a = new ArrayList();
        f550104b = new LinkedHashMap();
        f550105c = new LinkedHashMap();
    }

    public static b b(KClass r100) {
        b r101 = (b) ((LinkedHashMap) f550104b).get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        Iterator r102 = ((ArrayList) f550103a).iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if (((b) r103).b(r100) == false) goto L7;
    L12:
        b<?> r104 = (b) r103;
        if (r104 == null) goto L16;
        f550104b.put(r100, r104);
    L16:
        if ((r104 instanceof b) == true) goto L19;
        return null;
    L19:
        return r104;
    L11:
        r103 = null;
        goto L12
    }

    public static void c(b r100) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        ((ArrayList) f550103a).add(r100);
    }

    public static JsonObject e(Object r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        KClass r101 = Reflection.getOrCreateKotlinClass(r100.getClass());
        b r102 = b(r101);
        if (r102 == null) goto L7;
        JsonObject r103 = r102.e(r100, new a(r101));
        if (r103 == null) goto L7;
        return r103;
    L7:
        return GsonProtectorUtils.toJsonTree(uh7.b.f550102a, r100).getAsJsonObject();
    }

    public static byte[] f(Object r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.MapObjKey.OBJ_SL_OBJ);
        b r101 = b(Reflection.getOrCreateKotlinClass(r100.getClass()));
        if (r101 != null) goto L21;
        Object r102 = null;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L13
        if ((r100 instanceof vh7.c) == true) goto L8;
        r100 = null;
    L8:
        vh7.c r104 = (vh7.c) r100;     // Catch: Throwable -> L13
        if (r104 != null) goto L11;
        Object r105 = Result.m9449constructorimpl(null);     // Catch: Throwable -> L13
    L16:
        if (Result.m9455isFailureimpl(r105) == true) goto L20;
        r102 = r105;
    L20:
        return (byte[]) r102;
    L11:
        Intrinsics.checkNotNullParameter(r104, "$this$toProtobufBytes");     // Catch: Throwable -> L13
        Intrinsics.checkNotNullParameter("toProtobufBytes", "name");     // Catch: Throwable -> L13
        throw new NotImplementedError("toProtobufBytes is not implemented in 1.7.x version");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L16
    L21:
        r101.a();
        int r107 = f.f271004a;
        g r108 = new g();
        com.bytedance.tools.kcp.modelx.runtime.protobuf.b r109 = new com.bytedance.tools.kcp.modelx.runtime.protobuf.b(true);
        f550106d.getClass();
        d(r109, r100, r101);
        r109.a(-1).a(r108);
        return r108.f271005a.readByteArray();
    }

    public static Object a(JsonObject r100, KClass r101, Type r102) {
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        Intrinsics.checkNotNullParameter(r101, "type");
        if (r102 == null) goto L5;
        f550105c.put(r101, r102);
    L5:
        b r103 = b(r101);
        if (r103 == null) goto L9;
        Object r104 = r103.d(r101, r100, new a(r101));
        if (r104 == null) goto L9;
        return r104;
    L9:
        Intrinsics.checkNotNullParameter(r100, "jsonObject");
        Intrinsics.checkNotNullParameter(r101, "type");
        return GsonProtectorUtils.fromJson(l97.a.f508113a, r100, JvmClassMappingKt.getJavaClass(r101));
    }

    public static com.bytedance.tools.kcp.modelx.runtime.protobuf.b d(com.bytedance.tools.kcp.modelx.runtime.protobuf.b r100, Object r101, b r102) {
        r102.c(r100, r101, new a(Reflection.getOrCreateKotlinClass(r101.getClass())));
        return r100;
    }
}
