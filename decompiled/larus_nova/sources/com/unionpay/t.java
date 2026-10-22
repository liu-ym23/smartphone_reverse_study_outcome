package com.unionpay;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes41.dex */
public final class t implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UPPayWapActivity f462173a;

    public t(UPPayWapActivity r100) {
        this.f462173a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        UPPayWapActivity r102 = this.f462173a;
        int r103 = UPPayWapActivity.f462117i;
        r102.a("cancel", null);
    }
}
