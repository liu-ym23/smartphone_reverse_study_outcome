package com.bytedance.ee.bear.share.externalshare.external.handler;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes18.dex */
public final class j implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f237101a = null;

    static {
        f237101a = new j();
    }

    public j() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        tt5.a.h("OpenFolderPasswordLinkHandler", "showSafeTipsDialog()...click cancel.");
    }
}
