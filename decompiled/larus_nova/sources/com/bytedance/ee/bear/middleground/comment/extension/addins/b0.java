package com.bytedance.ee.bear.middleground.comment.extension.addins;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes18.dex */
public final class b0 implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f231428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a0 f231429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f231430c;

    public b0(boolean r100, a0 r101, String r102) {
        this.f231428a = r100;
        this.f231429b = r101;
        this.f231430c = r102;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        if (this.f231428a == false) goto L11;
        kf5.b r101 = this.f231429b.getContext().d();
        if (r101 == null) goto L7;
        r101.c(this.f231430c);
    L7:
        kf5.b r102 = this.f231429b.getContext().d();
        if (r102 == null) goto L12;
        r102.l();
        return;
    L12:
        return;
    }
}
