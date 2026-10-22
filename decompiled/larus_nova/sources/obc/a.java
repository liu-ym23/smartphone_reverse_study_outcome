package obc;

import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.vote.message.content.VoteContent;
import com.ss.android.lark.vote.message.entity.VoteContentVO;
import kotlin.jvm.internal.Intrinsics;
import p5b.c;
import v5b.b;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements b<VoteContentVO> {
    public a() {
    }

    @Override // v5b.b
    public final CharSequence b(c r100) {
        Intrinsics.checkNotNullParameter(r100, "messageInfo");
        return "VoteMessage";
    }

    @Override // v5b.b
    public final MessageType a() {
        return MessageType.VOTE;
    }

    @Override // v5b.b
    public final v5b.a c(c r100) {
        Intrinsics.checkNotNullParameter(r100, "messageInfo");
        return new VoteContentVO((VoteContent) r100.getMessage().getContent());
    }
}
