package com.bytedance.locallife.live.goodsshelves.span;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes21.dex */
public final class a extends hf6.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f259879a;

    public a(b r100) {
        this.f259879a = r100;
    }

    @Override // hf6.i
    public final void onCompleted(Bitmap r100) {
        b r101 = this.f259879a;
        if (r101.f259883d != 3) goto L5;
        return;
    L5:
        r101.f259883d = 2;
        if (r100 != null) goto L10;
        d r102 = r101.f259882c;
        if (r102 == null) goto L14;
        r102.onFailed(r101.f259880a);
        return;
    L14:
        return;
    L10:
        d r103 = r101.f259882c;
        if (r103 == null) goto L16;
        r103.a(r101.f259880a, r100);
        return;
    }

    @Override // hf6.i
    public final void onFailed(Throwable r100) {
        b r101 = this.f259879a;
        if (r101.f259883d != 3) goto L5;
        return;
    L5:
        r101.f259883d = 2;
        d r102 = r101.f259882c;
        if (r102 == null) goto L9;
        r102.onFailed(r101.f259880a);
        return;
    }
}
