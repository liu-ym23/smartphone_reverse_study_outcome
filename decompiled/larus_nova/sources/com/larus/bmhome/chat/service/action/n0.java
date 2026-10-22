package com.larus.bmhome.chat.service.action;

import com.larus.bmhome.chat.api.ConversationFeedActionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class n0 extends k0 {
    public n0(a r100) {
        Intrinsics.checkNotNullParameter(r100, "executeContext");
        super(r100, false, ConversationFeedActionType.UNPIN);
    }
}
