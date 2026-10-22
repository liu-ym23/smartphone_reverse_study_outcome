package com.bytedance.ee.bear.middleground.permission.collaborator.sharecollaboratev2.folder;

import android.content.DialogInterface;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class g implements DialogInterface.OnClickListener {
    public final /* synthetic */ f a;

    public g(f r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r1, int r2) {
        this.a.getLockBannerFromXml().setVisibility(8);
        f.f(this.a).unlock();
        com.bytedance.ee.bear.middleground.permission.c.Y(true);
    }
}
