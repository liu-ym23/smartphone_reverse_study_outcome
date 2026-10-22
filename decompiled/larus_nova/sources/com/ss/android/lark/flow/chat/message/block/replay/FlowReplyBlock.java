package com.ss.android.lark.flow.chat.message.block.replay;

import com.ss.android.lark.blueprint.g;
import com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.reply.h;
import com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ReplyBlock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowReplyBlock extends ReplyBlock {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f422423i;

    @Override // com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.ReplyBlock
    public final h i() {
        return (h) this.f422423i.getValue();
    }

    public FlowReplyBlock(g r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        super(r100);
        this.f422423i = LazyKt.lazy(new FlowReplyBlock$replyBlockRender$2(this));
    }
}
