package com.obric.assistant.window;

import com.larus.im.bean.message.Message;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public class a implements nf9.b {
    public a() {
    }

    @Override // nf9.b
    public final void d(String r100, Message r101) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        Intrinsics.checkNotNullParameter(r101, "msg");
    }

    @Override // nf9.b
    public final void f(String r100, Message r101) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        Intrinsics.checkNotNullParameter(r101, "msg");
    }

    @Override // nf9.b
    public final void onMessageListReplaced(String r100, List<Message> r101, List<Message> r102) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        Intrinsics.checkNotNullParameter(r101, "oldMsgList");
        Intrinsics.checkNotNullParameter(r102, "newMsgList");
    }
}
