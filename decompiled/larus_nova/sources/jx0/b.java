package jx0;

import com.bytedance.android.live.recharge.panel.context.e;
import com.bytedance.android.live.revenue.common.u0;
import com.bytedance.android.scope.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class b implements o, a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f500745a;

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    public b(e r100) {
        Intrinsics.checkNotNullParameter(r100, "panelContextManager");
        this.f500745a = r100;
    }

    @Override // jx0.a
    public final void reportEvent(c r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        if (r100.b().length() <= 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L17;
        com.bytedance.android.live.recharge.panel.context.c r102 = this.f500745a.i();
        if (r102 == null) goto L10;
        com.bytedance.android.live.recharge.trace.session.a r103 = r102.getSession();
    L11:
        if (r103 == null) goto L15;
        String r104 = r100.a();
        String r105 = r100.b();
        u0 r106 = u0.f90999f;
        r103.b(new com.bytedance.android.live.recharge.trace.session.b(r104, r105, new u0(r100.c())));
        return;
    L15:
        throw new IllegalStateException("no active recharge panel session".toString());
    L10:
        r103 = null;
        goto L11
    L17:
        throw new IllegalStateException("event_name cannot be empty".toString());
    L5:
        r101 = false;
        goto L6
    }
}
