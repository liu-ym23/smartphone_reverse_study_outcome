package v56;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.annotation.XBridgeParamModel;
import com.bytedance.ies.xbridge.i;
import com.bytedance.ies.xbridge.model.idl.XBaseParamModel;
import com.bytedance.ies.xbridge.model.idl.XBaseResultModel;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class c<INPUT extends XBaseParamModel, OUTPUT extends XBaseResultModel> implements IDLXBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g66.c f553273a;

    public c() {
    }

    public abstract void e(XBaseParamModel r100, a r101, XBridgePlatformType r102);

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod, com.bytedance.sdk.xbridge.cn.protocol.h
    public void release() {
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public IDLXBridgeMethod.Access getAccess() {
        return IDLXBridgeMethod.Access.PRIVATE;
    }

    public static double c(Number r100) {
        Intrinsics.checkNotNullParameter(r100, PlayerResolution.SDKKEY.ORIGIN);
        if ((r100 instanceof Double) == false) goto L6;
        return r100.doubleValue();
    L6:
        if ((r100 instanceof Integer) == false) goto L9;
        return r100.doubleValue();
    L9:
        if ((r100 instanceof Float) == false) goto L12;
        return r100.doubleValue();
    L12:
        if ((r100 instanceof Long) == false) goto L16;
        return r100.doubleValue();
    L16:
        throw new IllegalArgumentException("Dynamic is not Double");
    }

    public final <T> T g(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clz");
        g66.c r101 = this.f553273a;
        if (r101 != null) goto L7;
        return null;
    L7:
        return (T) r101.c(r100);
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final void setProviderFactory(g66.c r100) {
        this.f553273a = r100;
    }

    @Override // com.bytedance.ies.xbridge.IDLXBridgeMethod
    public final void d(Map<String, ? extends Object> r110, IDLXBridgeMethod.a r111, XBridgePlatformType r112) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r111, "callback");
        Intrinsics.checkNotNullParameter(r112, "type");
        com.bytedance.ies.xbridge.c r100 = i.f249501b.get(getClass());
        if (r100 == null) goto L5;
        Class<?> r101 = r100.f249458a;
    L7:
        if (r101 != null) goto L35;
        System.out.println("idl Map->Model. no cache");
        Class<?>[] r102 = getClass().getDeclaredClasses();
        ArrayList r103 = new ArrayList();
        int r104 = r102.length;
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L19;
        Class<?> r106 = r102[r105];
        if (r106.getAnnotation(XBridgeParamModel.class) == null) goto L14;
        boolean r107 = true;
    L15:
        if (r107 == false) goto L17;
        r103.add(r106);
    L17:
        r105 = r105 + 1;
        goto L10
    L14:
        r107 = false;
        goto L15
    L19:
        if (r103.isEmpty() == false) goto L34;
        Class<?>[] r108 = getClass().getSuperclass().getDeclaredClasses();
        r103 = new ArrayList();
        int r109 = r108.length;
        int r113 = 0;
    L21:
        if (r113 >= r109) goto L30;
        Class<?> r114 = r108[r113];
        if (r114.getAnnotation(XBridgeParamModel.class) == null) goto L25;
        boolean r115 = true;
    L26:
        if (r115 == false) goto L28;
        r103.add(r114);
    L28:
        r113 = r113 + 1;
        goto L21
    L25:
        r115 = false;
        goto L26
    L30:
        if (r103.isEmpty() == false) goto L34;
        throw new IllegalStateException("Illegal class format, no param model is defined in class");
    L34:
        r101 = (Class) CollectionsKt.first(r103);
    L35:
        if (r101 == null) goto L43;
        Object r116 = Proxy.newProxyInstance(r101.getClassLoader(), new Class[]{r101}, new b(this, r110));
        Intrinsics.checkNotNull(r116, "null cannot be cast to non-null type INPUT of com.bytedance.ies.xbridge.bridgeInterfaces.XCoreIDLBridgeMethod");
        XBaseParamModel r117 = (XBaseParamModel) r116;
        if (r117 != null) goto L40;
        f(r111, -3, "", new LinkedHashMap());
        return;
    L40:
        ClassLoader r118 = getClass().getClassLoader();
        Intrinsics.checkNotNull(r118);
        Intrinsics.checkNotNullParameter(r118, "classLoader");
        Intrinsics.checkNotNullParameter(r111, "callback");
        e(r117, new a(this, r111), r112);
        return;
    L43:
        throw new IllegalStateException("params class is null");
    L5:
        r101 = null;
        goto L7
    }

    public static void f(IDLXBridgeMethod.a r100, int r101, String r102, Map r103) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        Intrinsics.checkNotNullParameter(r102, "msg");
        Intrinsics.checkNotNullParameter(r103, "data");
        LinkedHashMap r104 = new LinkedHashMap();
        r104.put("code", Integer.valueOf(r101));
        r104.put("msg", r102);
        r104.put("data", r103);
        r100.invoke(r104);
    }
}
