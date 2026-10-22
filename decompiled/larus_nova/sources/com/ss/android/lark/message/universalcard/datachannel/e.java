package com.ss.android.lark.message.universalcard.datachannel;

import com.bytedance.lark.pb.openplatform.v1.UnSubscribeUniversalCardResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes36.dex */
public final class e<T> implements SdkSender.IParser {
    public e(UniversalCardSubscriptionManager r100) {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        if (r100 == null) goto L6;
        UnSubscribeUniversalCardResponse r101 = UnSubscribeUniversalCardResponse.ADAPTER.decode(r100);
        if (r101 == null) goto L6;
        return r101;
    L6:
        return new UnSubscribeUniversalCardResponse.Builder().build();
    }
}
