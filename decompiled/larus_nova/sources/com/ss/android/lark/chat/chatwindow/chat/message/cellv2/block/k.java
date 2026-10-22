package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block;

import android.content.DialogInterface;
import com.ss.android.lark.chat.preview.components.view.SpinButton;

/* JADX INFO: loaded from: classes35.dex */
public final class k implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpinButton f413177a;

    public k(SpinButton r100) {
        this.f413177a = r100;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface r100) {
        this.f413177a.d();
    }
}
