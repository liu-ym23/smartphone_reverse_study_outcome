package com.ss.android.lark.biz.im.api;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.MessageParams;
import com.ss.android.lark.chat.entity.message.content.ShareGroupChatContent;

/* JADX INFO: loaded from: classes34.dex */
public final class i1 extends MessageParams<i1, Object> {
    @Override // com.ss.android.lark.chat.entity.message.MessageParams
    public final Message c(String r100, String r101) {
        Message r102 = b(r100, r101);
        r102.setType(Message.Type.SHARE_GROUP_CHAT);
        ShareGroupChatContent r103 = new ShareGroupChatContent();
        r103.setChat(null);
        r102.setMessageContent(r103);
        return r102;
    }
}
