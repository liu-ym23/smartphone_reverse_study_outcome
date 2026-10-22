package io.noties.markwon.ext.onetex;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes5.dex */
public final class k extends wsc.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f492445a;

    public k(boolean r100) {
        this.f492445a = r100;
    }

    @Override // wsc.p
    public final Rect a(wsc.a r100) {
        Rect r101 = r100.f561120e.getBounds();
        int r102 = r100.f561122g;
        int r103 = r101.width();
        if (this.f492445a == false) goto L7;
        if (r103 <= r102) goto L7;
        return new Rect(0, 0, r102, (int) ((r102 / (r103 / r101.height())) + 0.5f));
    L7:
        return r101;
    }
}
