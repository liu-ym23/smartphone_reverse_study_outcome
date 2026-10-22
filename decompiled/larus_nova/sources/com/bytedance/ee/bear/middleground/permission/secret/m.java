package com.bytedance.ee.bear.middleground.permission.secret;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes18.dex */
public final class m implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m f234110a = null;

    static {
        f234110a = new m();
    }

    public m() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        com.bytedance.ee.bear.middleground.permission.c.K("known");
    }
}
