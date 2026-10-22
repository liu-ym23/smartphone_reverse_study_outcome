package com.bytedance.ee.bear.middleground.drive.rustsdk;

import com.bytedance.lark.pb.space.drive.v1.DownloadNormalResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: classes18.dex */
public final class v implements SdkSender.IParser<String> {
    public v() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final String parse(byte[] r100) throws IOException {
        return DownloadNormalResponse.ADAPTER.decode(r100).key;
    }
}
