package dmc;

import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f469270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f469271b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashSet<e> f469272c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.ugc.live.sdk.msg.c f469273d;

    @Override // dmc.a
    public final void o(e r100) {
    }

    @Override // dmc.a
    public final void t() {
        boolean r100 = this.f469270a;
        if (r100 == true) goto L5;
        return;
    L5:
        if (r100 == false) goto L7;
    L12:
        this.f469270a = false;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f469273d, "end replay");
        return;
    L7:
        if (this.f469272c.isEmpty() == false) goto L12;
        b r101 = this.f469271b;
        if (r101 == null) goto L11;
        r101.f469259a.clear();
    L11:
        this.f469271b = null;
        goto L12
    }

    public f(com.ss.ugc.live.sdk.msg.c r100) {
        Intrinsics.checkNotNullParameter(r100, "messageContext");
        this.f469273d = r100;
        this.f469272c = new LinkedHashSet();
    }

    @Override // dmc.a
    public final void C(e r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (this.f469270a == false) goto L8;
        this.f469272c.add(r100);
        return;
    }

    @Override // dmc.a
    public final void s(c r100) {
        Intrinsics.checkNotNullParameter(r100, "replayBufferConfig");
        if (this.f469270a == false) goto L5;
        return;
    L5:
        b r101 = this.f469271b;
        if (r101 == null) goto L8;
        r101.f469259a.clear();
    L8:
        this.f469272c.clear();
        this.f469271b = new b(r100);
        this.f469270a = true;
        com.ss.ugc.live.sdk.msg.utils.a.c(this.f469273d, "start replay");
    }
}
