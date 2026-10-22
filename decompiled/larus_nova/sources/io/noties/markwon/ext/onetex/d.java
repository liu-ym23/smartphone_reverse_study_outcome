package io.noties.markwon.ext.onetex;

import android.graphics.Rect;

/* JADX INFO: loaded from: classes5.dex */
public final class d extends wsc.p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f492401a;

    public d(boolean r100) {
        this.f492401a = r100;
    }

    @Override // wsc.p
    public final Rect a(wsc.a r100) {
        Rect r101 = r100.f561120e.getBounds();
        int r102 = r100.f561122g;
        if (this.f492401a == false) goto L11;
        int r103 = r101.width();
        if (r103 < r102) goto L7;
        if (r103 <= r102) goto L11;
        return new Rect(0, 0, r102, (int) ((r102 / (r103 / r101.height())) + 0.5f));
    L7:
        return new Rect(0, 0, r102, r101.height());
    L11:
        return r101;
    }
}
