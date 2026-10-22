package com.ss.android.lark.keyboard.edittext2.widget;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class n implements KeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final KeyListener f429277a;

    @Override // android.text.method.KeyListener
    public final int getInputType() {
        return this.f429277a.getInputType();
    }

    public n(KeyListener r100) {
        Intrinsics.checkNotNullParameter(r100, "mKeyListener");
        this.f429277a = r100;
    }

    @Override // android.text.method.KeyListener
    public final void clearMetaKeyState(View r100, Editable r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "content");
        this.f429277a.clearMetaKeyState(r100, r101, r102);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyOther(View r100, Editable r101, KeyEvent r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r102, "event");
        return this.f429277a.onKeyOther(r100, r101, r102);
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyDown(View r100, Editable r101, int r102, KeyEvent r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r103, "event");
        if (h.f429267a.b(r101, r102, r103) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f429277a.onKeyDown(r100, r101, r102, r103) == true) goto L8;
        return false;
    }

    @Override // android.text.method.KeyListener
    public final boolean onKeyUp(View r100, Editable r101, int r102, KeyEvent r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r103, "event");
        return this.f429277a.onKeyUp(r100, r101, r102, r103);
    }
}
