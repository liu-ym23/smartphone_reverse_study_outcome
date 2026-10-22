package com.ivy.ivykit.plugin.impl.jsb;

import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.ivy.ivykit.api.bridge.core.IvyBridgeMethod;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile j f278398b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f278399c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<IDLXBridgeMethod> f278400a;

    public static final class a {
        public a() {
        }
    }

    static {
        a r100 = new a();
        j r101 = f278398b;
        if (r101 != null) goto L13;
        monitor-enter(r100);
        r101 = f278398b;     // Catch: Throwable -> L10
        if (r101 != null) goto L8;
        r101 = new j();     // Catch: Throwable -> L10
        f278398b = r101;     // Catch: Throwable -> L10
    L8:
        monitor-exit(r100);
    L10:
        th = move-exception;
        throw th;
    L13:
        f278399c = r101;
    }

    public j() {
        this.f278400a = new CopyOnWriteArrayList();
    }

    public final <T> void a(Class<? extends T> r100) {
        if (r100 == null) goto L34;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L27
        if (IvyBridgeMethod.class.isAssignableFrom(r100) == false) goto L11;
        IvyBridgeMethod r102 = (IvyBridgeMethod) r100.newInstance();     // Catch: Throwable -> L27
        if (r102 == null) goto L29;
        int r103 = ux7.b.f552014a;     // Catch: Throwable -> L27
        Intrinsics.checkNotNullParameter(r102, com.alipay.sdk.m.p.e.f25671s);     // Catch: Throwable -> L27
        IDLXBridgeMethod r104 = new ux7.a(r102);     // Catch: Throwable -> L27
    L30:
        if (r104 == null) goto L35;
        this.f278400a.add(r104);
        return;
    L35:
        return;
    L29:
        r104 = null;
        goto L30
    L11:
        if (com.bytedance.ies.xbridge.IDLXBridgeMethod.class.isAssignableFrom(r100) == false) goto L17;
        com.bytedance.ies.xbridge.IDLXBridgeMethod r105 = (com.bytedance.ies.xbridge.IDLXBridgeMethod) r100.newInstance();     // Catch: Throwable -> L27
        if (r105 == null) goto L29;
        r104 = com.bytedance.ies.bullet.base.bridge.i.c(r105);     // Catch: Throwable -> L27
        goto L30
    L17:
        if (XBridgeMethod.class.isAssignableFrom(r100) == false) goto L23;
        XBridgeMethod r106 = (XBridgeMethod) r100.newInstance();     // Catch: Throwable -> L27
        if (r106 == null) goto L29;
        int r107 = com.bytedance.ies.bullet.base.bridge.i.f246288a;     // Catch: Throwable -> L27
        Intrinsics.checkNotNullParameter(r106, com.alipay.sdk.m.p.e.f25671s);     // Catch: Throwable -> L27
        r104 = new com.bytedance.ies.bullet.base.bridge.g(r106);     // Catch: Throwable -> L27
        goto L30
    L23:
        if (IDLXBridgeMethod.class.isAssignableFrom(r100) == false) goto L25;
        r104 = (IDLXBridgeMethod) r100.newInstance();     // Catch: Throwable -> L27
        goto L30
    L25:
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    }
}
