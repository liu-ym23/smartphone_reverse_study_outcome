package com.larus.avlink.plugins;

import com.larus.im.bean.message.Message;
import com.larus.im.observer.MessageListState;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public class y4 implements nf9.b {
    public y4() {
    }

    @Override // nf9.b
    public final void a(String r100, Message r101) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        Intrinsics.checkNotNullParameter(r101, "msg");
    }

    @Override // nf9.b
    public void b(String r100, MessageListState r101, List<Message> r102) {
        Intrinsics.checkNotNullParameter(r100, "cid");
        Intrinsics.checkNotNullParameter(r101, "state");
        Intrinsics.checkNotNullParameter(r102, "msgList");
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
