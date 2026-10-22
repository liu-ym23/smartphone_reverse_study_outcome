package tn6;

import com.bytedance.dux.window.controller.DuxBreakPointController;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.bytedance.dux.window.controller.a f546875a;

    @Override // tn6.c
    public final void release() {
        DuxBreakPointController r100 = gm4.a.f481672a;
        com.bytedance.dux.window.controller.a r101 = this.f546875a;
        if (r101 == null) goto L6;
        gm4.a.f481672a.a(r101);
    L6:
        this.f546875a = null;
    }

    public a() {
    }

    @Override // tn6.c
    public final void a(hm4.c r100, jm4.b r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "listener");
        gm4.a.a(r100, r101);
        this.f546875a = com.bytedance.dux.window.controller.a.f205935a;
    }
}
