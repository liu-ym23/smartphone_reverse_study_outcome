package com.bytedance.ee.bear.middleground.permission.secret;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes18.dex */
public final class i implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnClickListener f234104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f234105b;

    public i(DialogInterface.OnClickListener r100, boolean r101) {
        this.f234104a = r100;
        this.f234105b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        DialogInterface.OnClickListener r102 = this.f234104a;
        if (r102 == null) goto L5;
        r102.onClick(r100, r101);
    L5:
        com.bytedance.ee.bear.middleground.permission.c.I("cancel", true, this.f234105b);
    }
}
