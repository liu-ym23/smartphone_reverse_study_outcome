package com.ss.android.lark.flow.group;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes36.dex */
public final class g implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowJoinGroupChatUtil.CallbackWrap f423671a;

    public g(FlowJoinGroupChatUtil.CallbackWrap r100) {
        this.f423671a = r100;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        this.f423671a.onCancelSendApply();
    }
}
