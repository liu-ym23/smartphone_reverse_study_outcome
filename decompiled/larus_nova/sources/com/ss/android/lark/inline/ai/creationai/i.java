package com.ss.android.lark.inline.ai.creationai;

import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class i implements wlb.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CreationAIDragView f427135a;

    public i(CreationAIDragView r100) {
        this.f427135a = r100;
    }

    @Override // wlb.d.a
    public final void a(int r100) {
        Log.i("CreationAIDragView", "onKeyboardHeightChange: " + r100 + ", needStartShowWhenKeyboardShow = " + this.f427135a.O + ", forceKeyboardWhenShowing = " + this.f427135a.N + ", this@CreationAIDragView.keyboardHeight = " + this.f427135a.f426935m);
        CreationAIDragView r101 = this.f427135a;
        boolean r102 = true;
        if (r101.f426935m == r100) goto L5;
        boolean r103 = true;
    L6:
        if (r100 <= 0) goto L8;
        r101.f426936n = r100;
    L8:
        r101.f426935m = r100;
        if (r100 > 0) goto L12;
        r102 = false;
    L12:
        r101.f426934l = r102;
        if (r103 == false) goto L15;
        r101.u();
    L15:
        CreationAIDragView r104 = this.f427135a;
        if (r104.f426934l == false) goto L19;
        r104.s();
    L19:
        if (Intrinsics.areEqual(this.f427135a.N, Boolean.TRUE) == false) goto L26;
        CreationAIDragView r105 = this.f427135a;
        if (r105.f426934l == true) goto L23;
        CreationAIDragView.d(r105);
        return;
    L23:
        if (r105.O == false) goto L30;
        r105.O = false;
        r105.f426918b.removeCallbacks(r105.f426921c0);
        CreationAIDragView.c(this.f427135a);
        return;
    L30:
        return;
    L26:
        CreationAIDragView r106 = this.f427135a;
        if (r106.N != null) goto L33;
        r106.t(false, r103, CreationAIDragView.AdjustTopSource.KEYBOARD_CHANGE);
        CreationAIDragView r107 = this.f427135a;
        r107.f426924e.b(r107.f426934l);
        return;
    L33:
        return;
    L5:
        r103 = false;
        goto L6
    }
}
