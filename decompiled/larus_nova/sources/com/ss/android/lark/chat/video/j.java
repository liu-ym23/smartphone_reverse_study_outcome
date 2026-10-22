package com.ss.android.lark.chat.video;

import android.view.View;

/* JADX INFO: loaded from: classes35.dex */
public final class j implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f416823a;

    public j(h r100) {
        this.f416823a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        h r101 = this.f416823a;
        boolean r102 = r101.f416801m.isSelected();
        if (r102 == false) goto L7;
        h.f r103 = r101.f416811w;
        if (r103 == null) goto L8;
        r103.onPlay();
    L8:
        r101.f416801m.setSelected(!r102);
        return;
    L7:
        r101.o();
        goto L8
    }
}
