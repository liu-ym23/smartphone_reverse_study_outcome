package com.ss.android.lark.integrator.ccm.dependency.di;

import com.bytedance.lark.pb.space.doc.v1.RemoveDocResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: classes36.dex */
public final class k implements SdkSender.IParser<Boolean> {
    public k() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Boolean parse(byte[] r100) throws IOException {
        RemoveDocResponse r101 = RemoveDocResponse.ADAPTER.decode(r100);
        return Boolean.TRUE;
    }
}
