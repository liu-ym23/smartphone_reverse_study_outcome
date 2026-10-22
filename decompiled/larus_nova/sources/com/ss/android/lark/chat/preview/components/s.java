package com.ss.android.lark.chat.preview.components;

import android.content.DialogInterface;
import com.ss.android.lark.chat.preview.components.view.SpinButton;

/* JADX INFO: loaded from: classes35.dex */
public final class s implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpinButton f416103a;

    public s(SpinButton r100) {
        this.f416103a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        this.f416103a.d();
    }
}
