package com.larus.uaigc.spring.lottery;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements xc8.g {
    @Override // xc8.g
    public final int c() {
        return 48;
    }

    public f() {
    }

    @Override // ei9.g
    public final boolean a(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        if (com.larus.bmhome.chat.bean.d.Y0(r101) == true) goto L6;
    L14:
        return false;
    L6:
        if (r101.getContentType() != 2) goto L14;
        if (r101.getMessageStatus() != MessageStatus.MessageStatus_AVAILABLE) goto L14;
        if (r101.getMessageStatusLocal() != 20) goto L12;
    L13:
        return true;
    L12:
        if (r101.getMessageStatusLocal() != 21) goto L14;
        goto L13
    }

    @Override // ei9.g
    public final ei9.f b(Message r100) {
        Message r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "sourceData");
        return new e(r101);
    }
}
