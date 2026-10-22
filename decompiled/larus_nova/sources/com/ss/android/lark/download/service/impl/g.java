package com.ss.android.lark.download.service.impl;

import com.bytedance.lark.pb.media.v1.DownloadFileResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: classes35.dex */
public final class g implements SdkSender.IParser<wbb.d.b> {
    public g() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final wbb.d.b parse(byte[] r100) throws IOException {
        DownloadFileResponse r101 = DownloadFileResponse.ADAPTER.decode(r100);
        if (r101 != null) goto L5;
        String r102 = "";
    L7:
        return new wbb.d.b(r102, false);
    L5:
        r102 = r101.path;
        goto L7
    }
}
