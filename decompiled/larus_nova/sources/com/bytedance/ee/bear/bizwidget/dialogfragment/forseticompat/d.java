package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes16.dex */
public final class d implements DialogInterface {
    public d() {
    }

    @Override // android.content.DialogInterface
    public final void cancel() {
        tt5.a.d("BaseForsetiCompatBSDF", "unexpected call cancel!");
    }

    @Override // android.content.DialogInterface
    public final void dismiss() {
        tt5.a.d("BaseForsetiCompatBSDF", "unexpected call dismiss!");
    }
}
