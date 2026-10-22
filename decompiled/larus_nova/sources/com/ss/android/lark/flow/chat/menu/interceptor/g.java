package com.ss.android.lark.flow.chat.menu.interceptor;

import com.ss.android.lark.chat.entity.message.Message;

/* JADX INFO: loaded from: classes36.dex */
public final class g extends a {
    @Override // yya.l
    public final String getTAG() {
        return "FlowRedPacketMessageActionInterceptor";
    }

    public g() {
    }

    @Override // yya.p
    public final Message.Type getMessageType() {
        return Message.Type.RED_PACKET;
    }
}
