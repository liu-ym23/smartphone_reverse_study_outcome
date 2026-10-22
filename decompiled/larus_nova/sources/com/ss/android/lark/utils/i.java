package com.ss.android.lark.utils;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes38.dex */
public final class i implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h.e f444720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Boolean f444721b;

    public i(h.e r100, Boolean r101) {
        this.f444720a = r100;
        this.f444721b = r101;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        h.e r102 = this.f444720a;
        if (r102 == null) goto L6;
        r102.a(this.f444721b.booleanValue());
        return;
    }
}
