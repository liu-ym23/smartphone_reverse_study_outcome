package com.bytedance.ee.bear.middleground.comment.cell;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes18.dex */
public final class f implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.ee.bear.middleground.comment.uitls.p f231050a;

    public f(com.bytedance.ee.bear.middleground.comment.uitls.p r100) {
        this.f231050a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        this.f231050a.N.a(new ef5.k());
    }
}
