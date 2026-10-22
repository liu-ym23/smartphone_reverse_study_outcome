package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.EditText;

/* JADX INFO: loaded from: classes37.dex */
public final class k implements ViewTreeObserver.OnGlobalFocusChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MmAINotePanelAnimator f436097a;

    public k(MmAINotePanelAnimator r100) {
        this.f436097a = r100;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
    public final void onGlobalFocusChanged(View r100, View r101) {
        boolean r102 = false;
        if (r101 == null) goto L25;
        MmAINotePanelAnimator r103 = this.f436097a;
        ViewGroup r104 = r103.f435968a.f516011f;
        r103.getClass();
        View r105 = r101;
    L6:
        if (r105 == null) goto L13;
        if (r105 == r104) goto L8;
        Object r106 = r105.getParent();
        if ((r106 instanceof View) == true) goto L11;
        r105 = null;
        goto L6
    L11:
        r105 = (View) r106;
        goto L6
    L8:
        boolean r107 = true;
    L14:
        if (r107 == true) goto L17;
    L21:
        boolean r108 = false;
    L23:
        if (r108 == false) goto L25;
        r102 = true;
        goto L25
    L17:
        if ((r101 instanceof EditText) == false) goto L19;
    L22:
        r108 = true;
        goto L23
    L19:
        if (r101.onCheckIsTextEditor() == false) goto L21;
    L13:
        r107 = false;
    L25:
        if (r102 == false) goto L39;
        MmAINotePanelAnimator r109 = this.f436097a;
        if (r109.x(r109.f435988u) <= 0) goto L40;
        MmAINotePanelAnimator r110 = this.f436097a;
        if (r110.f435982o == MmAINoteSheetState.FULL) goto L41;
        r110.p(MmAINotePanelAnimator.FullStateSource.KEYBOARD_PROMOTED, "focus_keyboard");
        return;
    L41:
        return;
    L40:
        return;
    }
}
