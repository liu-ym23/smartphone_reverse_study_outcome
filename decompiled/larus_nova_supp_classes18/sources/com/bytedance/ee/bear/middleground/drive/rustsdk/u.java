package com.bytedance.ee.bear.middleground.drive.rustsdk;

import com.bytedance.lark.pb.space.drive.v1.DownloadResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u implements SdkSender.IParser<String> {
    public u() {
    }

    public final Object parse(byte[] r2) throws IOException {
        return ((DownloadResponse) DownloadResponse.ADAPTER.decode(r2)).key;
    }
}
