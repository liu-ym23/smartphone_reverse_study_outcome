package com.bytedance.ug.sdk.luckydog.task.newTimer.pendant;

import android.app.Activity;

/* JADX INFO: loaded from: classes3.dex */
public final class g extends uo7.c implements ym7.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f272137a;

    @Override // ym7.e
    public final String getRuleId() {
        return "background";
    }

    @Override // ym7.e
    public final boolean b() {
        return !this.f272137a;
    }

    public g() {
        to7.c.d(this);
    }

    @Override // uo7.c, uo7.b
    public final void onEnterBackground(Activity r100) {
        super.onEnterBackground(r100);
        this.f272137a = true;
        ym7.g r101 = (ym7.g) wm7.g.a(ym7.g.class);
        if (r101 == null) goto L6;
        r101.a("background");
        return;
    }

    @Override // uo7.c, uo7.b
    public final void onEnterForeground(Activity r100) {
        super.onEnterForeground(r100);
        this.f272137a = false;
        ym7.g r101 = (ym7.g) wm7.g.a(ym7.g.class);
        if (r101 == null) goto L6;
        r101.a("background");
        return;
    }
}
