package com.ss.android.lark.message.card.parser;

import com.bytedance.lark.pb.basic.v1.CardAction;
import com.bytedance.lark.pb.basic.v1.CardActionPacket;
import com.larksuite.framework.utils.y;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements y.a<CardAction, com.ss.android.lark.chat.entity.message.CardAction> {
    public b() {
    }

    @Override // com.larksuite.framework.utils.y.a
    public final com.ss.android.lark.chat.entity.message.CardAction get(CardAction r100) {
        CardAction r101 = r100;
        com.ss.android.lark.chat.entity.message.CardAction.RequiredParameters r102 = null;
        if (r101 == null) goto L19;
        com.ss.android.lark.chat.entity.message.CardAction r103 = new com.ss.android.lark.chat.entity.message.CardAction();
        r103.setUrl(r101.url);
        r103.setCmd(r101.cmd.intValue());
        r103.setMethod(com.ss.android.lark.chat.entity.message.CardAction.Method.fromValue(r101.method.getValue()));
        CardAction.Url r104 = r101.open_url;
        if (r104 != null) goto L8;
        com.ss.android.lark.chat.entity.message.CardAction.OpenUrl r105 = null;
    L9:
        r103.setOpenUrl(r105);
        CardActionPacket r106 = r101.packet;
        if (r106 != null) goto L12;
        com.ss.android.lark.chat.entity.message.CardActionPacket r107 = null;
    L13:
        r103.setPacket(r107);
        CardAction.RequiredParameters r108 = r101.required_parameters;
        if (r108 == null) goto L17;
        r102 = new com.ss.android.lark.chat.entity.message.CardAction.RequiredParameters();
        r102.setNeedMessageId(r108.need_message_id.booleanValue());
        r102.setNeedMessageInfo(r108.need_message_info.booleanValue());
        r102.setNeedUserId(r108.need_user_id.booleanValue());
        r102.setNeedUserInfo(r108.need_user_info.booleanValue());
    L17:
        r103.setRequiredParameters(r102);
        r103.setParameters(d.e(r101.parameters));
        return r103;
    L12:
        r107 = new com.ss.android.lark.chat.entity.message.CardActionPacket();
        r107.setCid(r106.cid);
        r107.setParameters(d.e(r106.parameters));
        r107.setPayload(r106.payload);
        goto L13
    L8:
        r105 = new com.ss.android.lark.chat.entity.message.CardAction.OpenUrl();
        r105.setAndroidUrl(r104.android_url);
        r105.setIosUrl(r104.ios_url);
        r105.setPcUrl(r104.pc_url);
        r105.setUrl(r104.url);
        goto L9
    L19:
        return null;
    }
}
