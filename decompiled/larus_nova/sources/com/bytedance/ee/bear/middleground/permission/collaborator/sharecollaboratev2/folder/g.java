package com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes18.dex */
public final class g implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f233778a;

    public g(f r100) {
        this.f233778a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        this.f233778a.getLockBannerFromXml().setVisibility(8);
        f.f(this.f233778a).unlock();
        com.bytedance.ee.bear.middleground.permission.c.Y(true);
    }
}
