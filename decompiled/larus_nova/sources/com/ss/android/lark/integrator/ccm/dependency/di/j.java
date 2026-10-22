package com.ss.android.lark.integrator.ccm.dependency.di;

import com.bytedance.lark.pb.space.doc.v1.UpdateDocMeReadResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: classes36.dex */
public final class j implements SdkSender.IParser<Boolean> {
    public j() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Boolean parse(byte[] r100) throws IOException {
        UpdateDocMeReadResponse r101 = UpdateDocMeReadResponse.ADAPTER.decode(r100);
        return Boolean.TRUE;
    }
}
