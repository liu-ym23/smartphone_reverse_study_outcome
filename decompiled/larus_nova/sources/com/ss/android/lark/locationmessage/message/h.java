package com.ss.android.lark.locationmessage.message;

import com.larus.nova.R;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.LocationContent;
import com.ss.android.lark.chat.export.entity.message.MessageType;
import com.ss.android.lark.utils.UIHelper;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class h implements v5b.b<LocationContentVO> {
    public h() {
    }

    @Override // v5b.b
    public final MessageType a() {
        return MessageType.LOCATION;
    }

    @Override // v5b.b
    public final CharSequence b(p5b.c r100) {
        Intrinsics.checkNotNullParameter(r100, "messageInfo");
        return UIHelper.mustacheFormat(R.string.Lark_Chat_MessageReplyStatusLocation, "title", ((LocationContent) r100.getMessage().getContent()).getName());
    }

    @Override // v5b.b
    public final v5b.a c(p5b.c r100) {
        Intrinsics.checkNotNullParameter(r100, "messageInfo");
        LocationContent r101 = (LocationContent) r100.getMessage().getContent();
        p5b.b r102 = r100.getMessage();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.ss.android.lark.chat.entity.message.Message");
        return new LocationContentVO(r101, (Message) r102);
    }
}
