package com.bytedance.ee.bear.middleground.permission.secret;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnClickListener f234099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SecretReviewModel f234100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f234101c;

    public g(DialogInterface.OnClickListener r100, SecretReviewModel r101, boolean r102) {
        this.f234099a = r100;
        this.f234100b = r101;
        this.f234101c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f234099a.onClick(r100, r101);
        int r102 = ReSubmitApplyDialog.f233941a;
        com.bytedance.ee.bear.middleground.permission.c.I("confirm", ReSubmitApplyDialog.b(this.f234100b), this.f234101c);
    }
}
