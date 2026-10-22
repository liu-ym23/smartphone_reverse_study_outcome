package com.ss.android.lark.keyboard.widget;

import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements View.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BottomSheet f431040a;

    public d(com.ss.android.lark.keyboard.biz.mention.j r100) {
        this.f431040a = r100;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View r100, int r101, KeyEvent r102) {
        if (r101 == 4) goto L5;
    L7:
        return false;
    L5:
        if (r102.getAction() != 1) goto L7;
        this.f431040a.b();
        return true;
    }
}
