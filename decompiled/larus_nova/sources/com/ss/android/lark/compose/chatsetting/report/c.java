package com.ss.android.lark.compose.chatsetting.report;

import android.view.KeyEvent;
import android.view.View;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements View.OnKeyListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowChatFunctionAbandonBottomSheet f417518a;

    public c(FlowChatFunctionAbandonBottomSheet r100) {
        this.f417518a = r100;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View r100, int r101, KeyEvent r102) {
        if (r101 == 4) goto L5;
    L7:
        return false;
    L5:
        if (r102.getAction() != 1) goto L7;
        this.f417518a.a();
        return true;
    }
}
