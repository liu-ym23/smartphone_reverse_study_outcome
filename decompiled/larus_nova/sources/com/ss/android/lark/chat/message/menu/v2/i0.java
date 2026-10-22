package com.ss.android.lark.chat.message.menu.v2;

import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;

/* JADX INFO: loaded from: classes35.dex */
public final /* synthetic */ class i0 {
    public static /* synthetic */ void a(j0 r100, boolean r101, MessageActionType r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r101 = false;
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = null;
    L8:
        r100.d(r101, r102, false);
    }
}
