package com.bytedance.ee.bear.middleground.drive.rustsdk;

import com.bytedance.lark.pb.space.drive.v1.CancelUploadResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: classes18.dex */
public final class x implements SdkSender.IParser<Integer> {
    public x() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Integer parse(byte[] r100) throws IOException {
        return CancelUploadResponse.ADAPTER.decode(r100).result;
    }
}
