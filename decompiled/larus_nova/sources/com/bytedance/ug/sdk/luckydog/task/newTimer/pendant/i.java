package com.bytedance.ug.sdk.luckydog.task.newTimer.pendant;

import android.app.Application;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements ym7.e, gk7.f {
    @Override // ym7.e
    public final String getRuleId() {
        return "login";
    }

    @Override // gk7.f
    public final void onAccountBindUpdate() {
    }

    @Override // ym7.e
    public final boolean b() {
        Application r100 = rk7.m.f538347a;
        return rk7.m.o();
    }

    public i() {
        rk7.h.a(this);
    }

    @Override // gk7.f
    public final void onAccountRefresh(boolean r100) {
        ym7.g r101 = (ym7.g) wm7.g.a(ym7.g.class);
        if (r101 == null) goto L6;
        r101.a("login");
        return;
    }
}
