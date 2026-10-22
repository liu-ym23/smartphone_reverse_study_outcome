package com.ss.android.lark.inline.ai.creationai;

import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes36.dex */
public final class k implements wlb.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CreationAIDragView f427139a;

    public k(CreationAIDragView r100) {
        this.f427139a = r100;
    }

    @Override // wlb.g.a
    public final void b(int r100) {
        Log.i("CreationAIDragView", "content height change, contentHeight = " + r100 + ", isNestedScrolling = " + this.f427139a.H);
        CreationAIDragView r101 = this.f427139a;
        if ((r101.f426932j instanceof wlb.g) == true) goto L5;
        return;
    L5:
        if (r101.H == true) goto L17;
        r101.u();
        CreationAIDragView r102 = this.f427139a;
        if (r102.D == false) goto L10;
        int r103 = Math.max(r102.E, r102.I);
    L14:
        CreationAIDragView.f(r102, r103, false, false, CreationAIDragView.AdjustTopSource.CONTENT_HEIGHT_CHANGE, 12);
        return;
    L10:
        Integer r104 = r102.F;
        if (r104 == null) goto L13;
        r103 = Math.max(r104.intValue(), r102.I);
        goto L14
    L13:
        r103 = r102.I;
        goto L14
    }
}
