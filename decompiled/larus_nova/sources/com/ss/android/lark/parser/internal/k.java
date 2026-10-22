package com.ss.android.lark.parser.internal;

import com.bytedance.lark.pb.basic.v1.Chatter;
import com.bytedance.lark.pb.basic.v1.MergeForwardContent;
import com.ss.android.lark.chat.entity.chatter.ChatterInfo;

/* JADX INFO: loaded from: classes37.dex */
public final class k implements com.larksuite.framework.utils.y.a<MergeForwardContent.ChatterInfo, ChatterInfo> {
    public k() {
    }

    @Override // com.larksuite.framework.utils.y.a
    public final ChatterInfo get(MergeForwardContent.ChatterInfo r100) {
        MergeForwardContent.ChatterInfo r101 = r100;
        ChatterInfo r102 = new ChatterInfo();
        r102.setId(r101.f253511id);
        r102.setName(r101.name);
        r102.setAvatarKey(r101.avatar_key);
        r102.setAnonymous(r101.is_anonymous.booleanValue());
        Chatter.Type r103 = r101.type;
        if (r103 != Chatter.Type.USER) goto L6;
        r102.setType(com.ss.android.lark.chat.entity.chatter.Chatter.ChatterType.USER);
    L9:
        return r102;
    L6:
        if (r103 != Chatter.Type.AI) goto L8;
        r102.setType(com.ss.android.lark.chat.entity.chatter.Chatter.ChatterType.AI);
        goto L9
    L8:
        r102.setType(com.ss.android.lark.chat.entity.chatter.Chatter.ChatterType.BOT);
        goto L9
    }
}
