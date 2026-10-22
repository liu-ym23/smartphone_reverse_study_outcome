package com.larus.bmhome.chat.deepsearch;

import com.larus.bmhome.chat.list.cell.prompt.w0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class k implements xc8.g {
    @Override // xc8.g
    public final int c() {
        return 42;
    }

    public k() {
    }

    @Override // ei9.g
    public final boolean a(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        if (r101.getContentType() == 2) goto L5;
    L9:
        return false;
    L5:
        if (r101.getMessageStatus() != MessageStatus.MessageStatus_AVAILABLE) goto L9;
        if (r101.getMessageStatusLocal() != 21) goto L9;
        return true;
    }

    @Override // ei9.g
    public final ei9.f b(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        return new w0(r101);
    }
}
