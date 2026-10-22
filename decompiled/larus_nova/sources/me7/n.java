package me7;

import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.annotation.XBridgeResultModel;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class<? extends IDLXBridgeMethod> f513547a;

    public n(Class<? extends IDLXBridgeMethod> r100) {
        this.f513547a = r100;
    }

    public final void a() {
        ConcurrentHashMap<Class<? extends IDLXBridgeMethod>, f> r100 = o.f513548a;
        Class<? extends IDLXBridgeMethod> r101 = this.f513547a;
        ConcurrentHashMap<Class<? extends IDLXBridgeMethod>, f> r102 = o.f513548a;
        if (r102.contains(r101) == false) goto L5;
        id7.c.a(r101.getName().concat(" already cached"));
        return;
    L5:
        Class r103 = o.a(r101, XBridgeParamModel.class);
        if (r103 != null) goto L10;
        r103 = id7.e.c(r101);
        if (r103 != null) goto L10;
    L14:
        f r104 = null;
    L16:
        if (r104 == null) goto L20;
        r102.put(r101, r104);
        o.f513549b.put(r104.f513525b, r101);
        return;
    L20:
        return;
    L10:
        Class r105 = r103;
        Class r106 = o.a(r101, XBridgeResultModel.class);
        if (r106 != null) goto L15;
        ConcurrentHashMap<Class<? extends IDLXBridgeMethod>, id7.b> r107 = id7.e.f489350a;
        Intrinsics.checkNotNullParameter(r101, "clazz");
        r106 = id7.e.b(r101, XBridgeResultModel.class);
        if (r106 == null) goto L14;
    L15:
        Class r108 = r106;
        HashMap r109 = new HashMap();
        r104 = new f(r105, r108, o.b(r105, r109), o.b(r108, r109), r109);
        goto L16
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
