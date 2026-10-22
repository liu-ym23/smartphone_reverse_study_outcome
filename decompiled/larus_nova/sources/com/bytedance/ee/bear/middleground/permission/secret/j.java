package com.bytedance.ee.bear.middleground.permission.secret;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes18.dex */
public final class j implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnClickListener f234106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f234107b;

    public j(DialogInterface.OnClickListener r100, boolean r101) {
        this.f234106a = r100;
        this.f234107b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f234106a.onClick(r100, r101);
        com.bytedance.ee.bear.middleground.permission.c.I("confirm", true, this.f234107b);
    }
}
