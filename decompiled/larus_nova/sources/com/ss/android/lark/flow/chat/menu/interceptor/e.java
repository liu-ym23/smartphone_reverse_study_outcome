package com.ss.android.lark.flow.chat.menu.interceptor;

import com.ss.android.lark.chat.entity.message.Message;

/* JADX INFO: loaded from: classes36.dex */
public final class e extends a {
    @Override // yya.l
    public final String getTAG() {
        return "FlowCommercializedRedPacketMessageActionInterceptor";
    }

    public e() {
    }

    @Override // yya.p
    public final Message.Type getMessageType() {
        return Message.Type.COMMERCIALIZED_HONGBAO;
    }
}
