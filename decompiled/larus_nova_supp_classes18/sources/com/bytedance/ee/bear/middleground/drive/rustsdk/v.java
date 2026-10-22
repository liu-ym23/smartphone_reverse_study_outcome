package com.bytedance.ee.bear.middleground.drive.rustsdk;

import com.bytedance.lark.pb.space.drive.v1.DownloadNormalResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class v implements SdkSender.IParser<String> {
    public v() {
    }

    public final Object parse(byte[] r2) throws IOException {
        return ((DownloadNormalResponse) DownloadNormalResponse.ADAPTER.decode(r2)).key;
    }
}
