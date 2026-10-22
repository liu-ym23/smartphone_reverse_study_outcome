package com.ss.android.lark.keyboard.keyboard2.content;

import android.view.View;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KeyboardMainContent f429543a;

    public d(KeyboardMainContent r100) {
        this.f429543a = r100;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r100, int r101, int r102, int r103, int r104, int r105, int r106, int r107, int r108) {
        r100.removeOnLayoutChangeListener(this);
        if ((!this.f429543a.f429522k.isEmpty()) == false) goto L5;
        this.f429543a.f429522k.clear();
    L5:
        this.f429543a.f429523l = false;
    }
}
