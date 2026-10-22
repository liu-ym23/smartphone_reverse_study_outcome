package com.bytedance.ee.bear.lynx.impl.xbridge;

import android.content.Context;
import android.view.View;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.ss.android.lark.lynxkit.xbridge.XBridgeLynxKitRuntime;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import qe5.h;
import qe5.i;
import qe5.j;
import qe5.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class XBridgeRegistryHelper {
    public final e a;
    public com.bytedance.ee.bear.lynx.api.g b;
    public final Object c;
    public XBridgeLynxKitRuntime d;
    public final List<Function1<XBridgeLynxKitRuntime, Unit>> e;
    public boolean f;

    public static final class a {
    }

    static {
    }

    public final void d() {
        Object r0 = this.c;
        monitor-enter(r0);
        ((ArrayList) this.e).clear();     // Catch: Throwable -> L7
        this.d = null;     // Catch: Throwable -> L7
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public XBridgeRegistryHelper() {
        this.a = new e();
        this.c = new Object();
        this.e = new ArrayList();
    }

    public final void e(Function1<? super XBridgeLynxKitRuntime, Unit> r4) {
        Object r0 = this.c;
        monitor-enter(r0);
        XBridgeLynxKitRuntime r1 = this.d;     // Catch: Throwable -> L13
        if (r1 != null) goto L9;
        ((ArrayList) this.e).add(r4);     // Catch: Throwable -> L13
        monitor-exit(r0);
        return;
    L9:
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L13
        monitor-exit(r0);
        r4.invoke(r1);
        return;
    L13:
        th = move-exception;
        throw th;
    }

    public final void a(String r2, final XBridgeMethod r3) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "bridgeMethod");
        e(new XBridgeRegistryHelper$registerLynxMethod$1(r3));
    }

    public final <T> void b(final Class<T> r2, final T r3) {
        Intrinsics.checkNotNullParameter(r2, "clazz");
        if (r3 != null) goto L5;
        return;
    L5:
        e(new XBridgeRegistryHelper$registerWeakHolder$1(r2, r3));
    }

    public final void c(Context r3, final View r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "view");
        tt5.a.h("ccm-lynx: XBridgeRegistryHelper", "registerXBridges");
        if (this.f == false) goto L6;
        tt5.a.h("ccm-lynx: XBridgeRegistryHelper", "has register bridges");
        return;
    L6:
        this.f = true;
        int r5 = g.a;
        tt5.a.h("ccm-lynx: XBridgeService", "registerXBridges");
        g.a(je5.d.class);
        g.a(je5.g.class);
        g.a(se5.a.class);
        g.a(me5.a.class);
        g.a(pe5.a.class);
        g.a(le5.a.class);
        g.a(je5.e.class);
        g.a(je5.c.class);
        g.a(oe5.b.class);
        g.a(re5.a.class);
        g.a(re5.b.class);
        g.a(re5.d.class);
        g.a(re5.e.class);
        g.a(me5.d.class);
        g.a(je5.f.class);
        g.a(te5.b.class);
        g.a(te5.a.class);
        g.a(com.bytedance.ee.bear.lynx.impl.xbridge.method.cache.a.class);
        g.a(com.bytedance.ee.bear.lynx.impl.xbridge.method.cache.c.class);
        g.a(k.class);
        g.a(qe5.f.class);
        g.a(d.class);
        g.a(i.class);
        g.a(h.class);
        g.a(j.class);
        g.a(c.class);
        g.a(b.class);
        g.a(qe5.g.class);
        g.a(je5.a.class);
        g.a(qe5.a.class);
        g.a(qe5.d.class);
        g.a(qe5.e.class);
        if (idb.f.a().isCurrentEnable("ccm.security.sensitivity_label.escape_enabled") == false) goto L10;
        tt5.a.h("ccm-lynx: XBridgeService", "fg admin.security.sensitivitylabel.escape is enabled");
        g.a(ke5.c.class);
        g.a(ke5.a.class);
        g.a(ke5.b.class);
    L10:
        if (idb.f.a().isCurrentEnable("ccm.mobile.subscribe_secret_level_updated") == false) goto L13;
        g.a(ne5.a.class);
    L13:
        if (idb.f.a().isCurrentEnable("ccm.mobile.lyxn_subscribe_permission_updated") == false) goto L15;
        g.a(qe5.b.class);
    L15:
        e(new XBridgeRegistryHelper$registerXBridges$1(r4, this));
    }
}
