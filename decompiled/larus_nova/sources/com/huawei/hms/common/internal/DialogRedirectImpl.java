package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Intent;

/* JADX INFO: loaded from: classes23.dex */
public class DialogRedirectImpl extends DialogRedirect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Activity f277099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f277100b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Intent f277101c;

    @Override // com.huawei.hms.common.internal.DialogRedirect
    public final void redirect() {
        Intent r100 = this.f277101c;
        if (r100 == null) goto L8;
        Activity r101 = this.f277099a;
        if (r101 == null) goto L9;
        r101.startActivityForResult(r100, this.f277100b);
        return;
    L9:
        return;
    }

    public DialogRedirectImpl(Intent r100, Activity r101, int r102) {
        this.f277101c = r100;
        this.f277099a = r101;
        this.f277100b = r102;
    }
}
