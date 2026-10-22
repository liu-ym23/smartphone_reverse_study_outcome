package ux5;

import com.bytedance.common.utility.Logger;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.bytedance.frameworks.baselib.network.b.AbstractC3499b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile d f551996d;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f551997c;

    public d() {
        super(0);
        this.f551997c = new AtomicBoolean(false);
    }

    public static d c() {
        if (f551996d != null) goto L15;
        monitor-enter(d.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f551996d != null) goto L9;
        f551996d = new d();     // Catch: Throwable -> L11
    L9:
        monitor-exit(d.class);     // Catch: Throwable -> L11
    L15:
        return f551996d;
    }

    @Override // com.bytedance.frameworks.baselib.network.b.AbstractC3499b
    public final void a() {
        this.f551997c.set(true);
        if (Logger.debug() == false) goto L6;
        Logger.d("QueryFilterStateListener", "onEnterToBackground");
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.b.AbstractC3499b
    public final void b() {
        this.f551997c.set(false);
        if (Logger.debug() == false) goto L6;
        Logger.d("QueryFilterStateListener", "onEnterToForeground");
        return;
    }
}
