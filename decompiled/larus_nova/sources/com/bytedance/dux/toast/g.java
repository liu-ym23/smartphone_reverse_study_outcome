package com.bytedance.dux.toast;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes15.dex */
public final class g implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PopupToast f205840a;

    public g(PopupToast r100) {
        this.f205840a = r100;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r100) {
        this.f205840a.f205832l.invoke(Boolean.TRUE);
    }
}
