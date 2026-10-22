package com.ss.android.lark.message.card.style;

import com.bytedance.lark.pb.tool.v1.UserSendHttpResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: classes36.dex */
public final class b implements SdkSender.IParser<UserSendHttpResponse> {
    public b() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final UserSendHttpResponse parse(byte[] r100) throws IOException {
        return UserSendHttpResponse.ADAPTER.decode(r100);
    }
}
