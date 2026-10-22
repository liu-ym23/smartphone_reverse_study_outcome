package com.bytedance.dux.toast;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes15.dex */
public final class f implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PopupToast f205839a;

    public f(PopupToast r100) {
        this.f205839a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        this.f205839a.f205832l.invoke(Boolean.FALSE);
    }
}
