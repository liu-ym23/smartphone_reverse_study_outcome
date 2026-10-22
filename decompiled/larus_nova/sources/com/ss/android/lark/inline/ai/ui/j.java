package com.ss.android.lark.inline.ai.ui;

import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.log.Log;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class j implements wlb.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InlineAIDragView f427560a;

    public j(InlineAIDragView r100) {
        this.f427560a = r100;
    }

    @Override // wlb.d.a
    public final void a(int r100) {
        Log.i("InlineAIDragView", "onKeyboardHeightChange: " + r100 + ", needStartShowWhenKeyboardShow = " + this.f427560a.O + ", forceKeyboardWhenShowing = " + this.f427560a.N);
        InlineAIDragView r101 = this.f427560a;
        boolean r102 = true;
        if (r101.f427365l == r100) goto L5;
        boolean r103 = true;
    L6:
        if (r100 <= 0) goto L8;
        r101.f427366m = r100;
    L8:
        r101.f427365l = r100;
        if (r100 > 0) goto L12;
        r102 = false;
    L12:
        r101.f427364k = r102;
        if (r103 == false) goto L16;
        r101.o();
    L16:
        if (Intrinsics.areEqual(this.f427560a.N, Boolean.TRUE) == false) goto L23;
        InlineAIDragView r104 = this.f427560a;
        if (r104.f427364k == true) goto L20;
        KeyboardUtils.showKeyboard(r104.f427354a);
        return;
    L20:
        if (r104.O == false) goto L27;
        r104.O = false;
        r104.f427355b.removeCallbacks(r104.X);
        InlineAIDragView.c(this.f427560a);
        return;
    L27:
        return;
    L23:
        InlineAIDragView r105 = this.f427560a;
        if (r105.N != null) goto L30;
        r105.n(false, r103, InlineAIDragView.AdjustTopSource.KEYBOARD_CHANGE);
        InlineAIDragView r106 = this.f427560a;
        r106.f427358e.b(r106.f427364k);
        return;
    L30:
        return;
    L5:
        r103 = false;
        goto L6
    }
}
