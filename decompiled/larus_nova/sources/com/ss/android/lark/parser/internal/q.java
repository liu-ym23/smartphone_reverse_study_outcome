package com.ss.android.lark.parser.internal;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import java.util.Comparator;

/* JADX INFO: loaded from: classes37.dex */
public final class q implements Comparator<MessageInfo> {
    public q() {
    }

    @Override // java.util.Comparator
    public final int compare(MessageInfo r100, MessageInfo r101) {
        return r100.getMessage().getPosition() - r101.getMessage().getPosition();
    }
}
