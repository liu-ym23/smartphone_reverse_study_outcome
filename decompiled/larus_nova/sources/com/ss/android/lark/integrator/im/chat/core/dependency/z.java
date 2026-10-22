package com.ss.android.lark.integrator.im.chat.core.dependency;

import com.ss.android.lark.biz.im.api.param.IMConstants$NetworkLevel;
import com.ss.android.lark.rustinfrabridge.netstate.impl.LarkNetworkLevelManager;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import w4b.g0;

/* JADX INFO: loaded from: classes36.dex */
public final class z implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<aqb.d> f427929a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f427930b;

    public z() {
    }

    static {
        f427929a = new CopyOnWriteArrayList();
        f427930b = false;
    }

    @Override // w4b.g0
    public final IMConstants$NetworkLevel getCurNetWorkLevel() {
        List<h3c.a> r100 = com.ss.android.lark.rustinfrabridge.netstate.impl.d.f439712a;
        com.ss.android.lark.rustinfrabridge.netstate.impl.d.b.f439716a.getClass();
        Object r101 = LarkNetworkLevelManager.f439693d;
        return IMConstants$NetworkLevel.forNumber(LarkNetworkLevelManager.a.a().getCurNetWorkLevel().getValue());
    }

    @Override // w4b.g0
    public final void a(aqb.d r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        ((CopyOnWriteArrayList) f427929a).add(r100);
        if (f427930b == false) goto L7;
        return;
    L7:
        monitor-enter(z.class);
    L13:
        th = move-exception;
        throw th;
    L9:
        if (f427930b == true) goto L11;
        y r101 = new y();     // Catch: Throwable -> L13
        List<h3c.a> r102 = com.ss.android.lark.rustinfrabridge.netstate.impl.d.f439712a;     // Catch: Throwable -> L13
        com.ss.android.lark.rustinfrabridge.netstate.impl.d.b.f439716a.getClass();     // Catch: Throwable -> L13
        ((CopyOnWriteArrayList) com.ss.android.lark.rustinfrabridge.netstate.impl.d.f439712a).add(r101);     // Catch: Throwable -> L13
        f427930b = true;     // Catch: Throwable -> L13
    L11:
        monitor-exit(z.class);     // Catch: Throwable -> L13
    }

    @Override // w4b.g0
    public final void b(aqb.d r100) {
        if (r100 == null) goto L5;
        ((CopyOnWriteArrayList) f427929a).remove(r100);
        return;
    }
}
