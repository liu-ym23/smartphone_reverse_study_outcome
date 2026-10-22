package com.ss.android.lark.flow.group;

import android.content.DialogInterface;

/* JADX INFO: loaded from: classes36.dex */
public final class i implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowJoinGroupChatUtil.CallbackWrap f423674a;

    public i(FlowJoinGroupChatUtil.CallbackWrap r100) {
        this.f423674a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r100, int r101) {
        if (r100 == null) goto L4;
        r100.dismiss();
    L4:
        this.f423674a.onCancelSendApply();
    }
}
