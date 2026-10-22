package com.bytedance.sync.v2.net;

import com.bytedance.common.wschannel.event.ConnectEvent;
import com.bytedance.common.wschannel.event.ConnectionState;
import java.util.ArrayList;
import java.util.List;
import xf7.g;
import yf7.m;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements m, hg7.m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<a> f270461a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f270462b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ConnectEvent f270463c;

    public interface a {
        void M(boolean r100);
    }

    @Override // hg7.m
    public final boolean a() {
        ConnectEvent r100 = this.f270463c;
        if (r100 == null) goto L9;
        if (r100.connectionState != ConnectionState.CONNECTED) goto L9;
        return true;
    L9:
        return this.f270462b.f563456c.a();
    }

    public d(g r100) {
        this.f270461a = new ArrayList();
        this.f270462b = r100;
        r100.f563456c.c(this);
    }

    @Override // hg7.m
    public final void o(a r100) {
        monitor-enter(this);
        ((ArrayList) this.f270461a).remove(r100);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // hg7.m
    public final void o0(a r100) {
        monitor-enter(this);
        ((ArrayList) this.f270461a).add(r100);     // Catch: Throwable -> L6
        monitor-exit(this);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        throw th;
    }
}
