package com.larus.bmhome.chat.detail.table;

import com.larus.im.bean.message.Message;

/* JADX INFO: loaded from: classes25.dex */
public final class a extends com.larus.bmhome.chat.detail.a implements b {
    @Override // com.larus.bmhome.chat.detail.table.b
    public final String a() {
        Message r100 = this.f302702a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getConversationId();
    }

    public a() {
    }
}
