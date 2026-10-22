package com.ss.android.lark.chat.api.service.impl;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Comparator;

/* JADX INFO: loaded from: classes35.dex */
public final class r1 implements Comparator<MessageInfo> {
    public r1() {
    }

    @Override // java.util.Comparator
    public final int compare(MessageInfo r100, MessageInfo r101) {
        return r100.getMessage().getThreadPosition() - r101.getMessage().getThreadPosition();
    }
}
