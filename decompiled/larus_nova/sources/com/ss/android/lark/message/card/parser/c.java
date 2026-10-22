package com.ss.android.lark.message.card.parser;

import com.larksuite.framework.utils.y;
import com.ss.android.lark.chat.entity.message.CardAction;
import com.ss.android.lark.chat.entity.message.CardActionPacket;

/* JADX INFO: loaded from: classes36.dex */
public final class c implements y.a<CardAction, com.bytedance.lark.pb.basic.v1.CardAction> {
    public c() {
    }

    @Override // com.larksuite.framework.utils.y.a
    public final com.bytedance.lark.pb.basic.v1.CardAction get(CardAction r100) {
        CardAction r101 = r100;
        com.bytedance.lark.pb.basic.v1.CardAction.RequiredParameters r102 = null;
        if (r101 == null) goto L18;
        com.bytedance.lark.pb.basic.v1.CardAction.Builder r103 = new com.bytedance.lark.pb.basic.v1.CardAction.Builder().url(r101.getUrl()).cmd(Integer.valueOf(r101.getCmd())).method(com.bytedance.lark.pb.basic.v1.CardAction.Method.fromValue(r101.getMethod().getValue()));
        CardAction.OpenUrl r104 = r101.getOpenUrl();
        if (r104 != null) goto L7;
        com.bytedance.lark.pb.basic.v1.CardAction.Url r105 = null;
    L8:
        com.bytedance.lark.pb.basic.v1.CardAction.Builder r106 = r103.open_url(r105);
        CardActionPacket r107 = r101.getPacket();
        if (r107 != null) goto L11;
        com.bytedance.lark.pb.basic.v1.CardActionPacket r108 = null;
    L12:
        com.bytedance.lark.pb.basic.v1.CardAction.Builder r109 = r106.packet(r108);
        CardAction.RequiredParameters r110 = r101.getRequiredParameters();
        if (r110 == null) goto L17;
        r102 = new com.bytedance.lark.pb.basic.v1.CardAction.RequiredParameters.Builder().need_message_id(Boolean.valueOf(r110.isNeedMessageId())).need_message_info(Boolean.valueOf(r110.isNeedMessageInfo())).need_user_id(Boolean.valueOf(r110.isNeedUserId())).need_user_info(Boolean.valueOf(r110.isNeedUserInfo())).build();
    L17:
        return r109.required_parameters(r102).parameters(d.f(r101.getParameters())).build();
    L11:
        r108 = new com.bytedance.lark.pb.basic.v1.CardActionPacket.Builder().cid(r107.getCid()).parameters(d.f(r107.getParameters())).payload(r107.getPayload()).build();
        goto L12
    L7:
        r105 = new com.bytedance.lark.pb.basic.v1.CardAction.Url.Builder().android_url(r104.getAndroidUrl()).ios_url(r104.getIosUrl()).pc_url(r104.getPcUrl()).url(r104.getUrl()).build();
        goto L8
    L18:
        return null;
    }
}
