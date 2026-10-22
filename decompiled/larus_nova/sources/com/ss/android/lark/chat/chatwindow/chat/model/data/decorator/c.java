package com.ss.android.lark.chat.chatwindow.chat.model.data.decorator;

import com.ss.android.lark.chat.entity.message.MessageInfo;
import com.ss.android.lark.chat.utils.q0;
import com.ss.android.lark.chatbase.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c implements i<MessageInfo> {
    public c() {
    }

    @Override // com.ss.android.lark.chatbase.i
    public final void a(f5b.b r100) {
        MessageInfo r101 = (MessageInfo) r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        q0.a(r101);
    }
}
