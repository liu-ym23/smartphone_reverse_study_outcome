package com.bytedance.ee.bear.middleground.drive.rustsdk;

import com.bytedance.lark.pb.space.drive.v1.DeleteUploadResourceResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class s implements SdkSender.IParser<Integer> {
    public s() {
    }

    public final Object parse(byte[] r2) throws IOException {
        return ((DeleteUploadResourceResponse) DeleteUploadResourceResponse.ADAPTER.decode(r2)).result;
    }
}
