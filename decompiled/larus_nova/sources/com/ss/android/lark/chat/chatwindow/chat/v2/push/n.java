package com.ss.android.lark.chat.chatwindow.chat.v2.push;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes35.dex */
public final class n implements aqb.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ o.a f414629a;

    public n(o.a r100) {
        this.f414629a = r100;
    }

    @Override // aqb.h
    public final MessageInfo p(String r100) {
        return this.f414629a.f414644b.f414636c.getMessageById(r100);
    }

    @Override // aqb.h
    public final void q(MessageInfo r100) {
        if (this.f414629a.f414644b.f414635b == null) goto L6;
        ArrayList r101 = new ArrayList();
        r101.add(r100);
        this.f414629a.f414644b.f414635b.onPushMessage(r101, false);
        return;
    }
}
