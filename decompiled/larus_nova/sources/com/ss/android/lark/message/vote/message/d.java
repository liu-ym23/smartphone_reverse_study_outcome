package com.ss.android.lark.message.vote.message;

import com.larus.nova.R;
import com.ss.android.lark.chat.entity.message.content.CardContent;
import com.ss.android.lark.chat.export.entity.message.Content;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class d implements v5b.b<VoteContentVO> {
    public d() {
    }

    @Override // v5b.b
    public final MessageType a() {
        return MessageType.CARD;
    }

    @Override // v5b.b
    public final CharSequence b(p5b.c r100) {
        Intrinsics.checkNotNullParameter(r100, "messageInfo");
        if (((CardContent) r100.getMessage().getContent()).getType() != CardContent.Type.VOTE) goto L5;
        int r101 = R.string.Lark_Legacy_MessagePoCardVote;
    L7:
        return UIHelper.getString(r101);
    L5:
        r101 = R.string.Lark_Legacy_UnknownCardContentHolder;
        goto L7
    }

    @Override // v5b.b
    public final v5b.a c(p5b.c r100) {
        Intrinsics.checkNotNullParameter(r100, "messageInfo");
        Content r101 = r100.getMessage().getContent();
        if ((r101 instanceof CardContent) == false) goto L7;
        CardContent r102 = (CardContent) r101;
        if (r102.getType() != CardContent.Type.VOTE) goto L7;
        return new VoteContentVO(r102);
    L7:
        return null;
    }
}
