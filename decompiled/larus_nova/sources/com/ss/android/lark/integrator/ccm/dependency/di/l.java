package com.ss.android.lark.integrator.ccm.dependency.di;

import com.bytedance.lark.pb.space.doc.v1.UpdateDocMessageBadgeResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: classes36.dex */
public final class l implements SdkSender.IParser<Boolean> {
    public l() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Boolean parse(byte[] r100) throws IOException {
        UpdateDocMessageBadgeResponse r101 = UpdateDocMessageBadgeResponse.ADAPTER.decode(r100);
        return Boolean.TRUE;
    }
}
