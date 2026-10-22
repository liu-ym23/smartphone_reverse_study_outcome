package l11;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.JsonAdapter;
import com.huawei.hms.push.constant.RemoteMessageConst;
import ey.f;
import ey.l;
import java.lang.reflect.Constructor;
import java.util.concurrent.ConcurrentHashMap;
import k11.n;
import k11.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b {
    public static final o a(l r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$toLynx");
        n.a r101 = n.f501361o;
        f r102 = r100.f474780a;
        int r103 = r102.f474774d;
        long r104 = r102.f474771a;
        r101.getClass();
        n r105 = n.a.a(r103, r104);
        f r106 = r100.f474781b;
        n r107 = n.a.a(r106.f474774d, r106.f474771a);
        o.f501363p.getClass();
        Intrinsics.checkNotNullParameter(r105, "from");
        Intrinsics.checkNotNullParameter(r107, RemoteMessageConst.TO);
        Class<?> r108 = ((JsonAdapter) o.class.getAnnotation(JsonAdapter.class)).value();
        ConcurrentHashMap<Class<?>, Constructor<? extends SerializableObjectJsonAdapterBase>> r109 = vh7.b.f554981a;
        Constructor r110 = r109.get(r108);
        if (r110 != null) goto L12;
        r110 = r108.getConstructor(new Class[0]);
        if (r110 == null) goto L11;
        Constructor<? extends SerializableObjectJsonAdapterBase> r111 = r109.putIfAbsent(r108, (Constructor<? extends SerializableObjectJsonAdapterBase>) r110);
        if (r111 == null) goto L12;
        r110 = r111;
        goto L12
    L11:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.reflect.Constructor<out com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase>");
    L12:
        Object r112 = ((SerializableObjectJsonAdapterBase) r110.newInstance(new Object[0])).createInstance();
        if (r112 == null) goto L17;
        o r113 = (o) r112;
        r113.M6(r105);
        r113.q2(r107);
        return r113;
    L17:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.revlink.aio.StateTransition");
    }
}
