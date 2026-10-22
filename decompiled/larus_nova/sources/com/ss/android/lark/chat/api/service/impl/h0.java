package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.GetChatLinkInfoResponse;
import com.ss.android.lark.dto.chat.ChatLinkInfoResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: classes35.dex */
public final class h0 implements SdkSender.IParser<ChatLinkInfoResponse> {
    public h0() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final ChatLinkInfoResponse parse(byte[] r100) throws IOException {
        return new ChatLinkInfoResponse(GetChatLinkInfoResponse.ADAPTER.decode(r100));
    }
}
