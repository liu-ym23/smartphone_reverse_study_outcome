package id7;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<Class<? extends IDLXBridgeMethod>, b> f489350a = null;

    static {
        f489350a = new ConcurrentHashMap();
    }

    public static Class c(Class r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        return b(r100, XBridgeParamModel.class);
    }

    public static void a(Class r100, b r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "methodModelBean");
        ConcurrentHashMap<Class<? extends IDLXBridgeMethod>, b> r102 = f489350a;
        if (r102.containsKey(r100) == true) goto L6;
        r102.put(r100, r101);
        return;
    }

    public static Class b(Class r100, Class r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        Intrinsics.checkNotNullParameter(r101, "annotation");
        if (Intrinsics.areEqual(r101, XBridgeParamModel.class) == false) goto L9;
        b r102 = f489350a.get(r100);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.f489339a;
    L9:
        if (Intrinsics.areEqual(r101, XBridgeResultModel.class) == false) goto L15;
        b r103 = f489350a.get(r100);
        if (r103 != null) goto L13;
        return null;
    L13:
        return r103.f489340b;
    L15:
        return null;
    }
}
