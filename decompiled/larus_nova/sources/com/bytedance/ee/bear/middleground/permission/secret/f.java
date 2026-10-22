package com.bytedance.ee.bear.middleground.permission.secret;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnClickListener f234096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SecretReviewModel f234097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f234098c;

    public f(DialogInterface.OnClickListener r100, SecretReviewModel r101, boolean r102) {
        this.f234096a = r100;
        this.f234097b = r101;
        this.f234098c = r102;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        DialogInterface.OnClickListener r102 = this.f234096a;
        if (r102 == null) goto L5;
        r102.onClick(r100, r101);
    L5:
        int r103 = ReSubmitApplyDialog.f233941a;
        com.bytedance.ee.bear.middleground.permission.c.I("cancel", ReSubmitApplyDialog.b(this.f234097b), this.f234098c);
    }
}
