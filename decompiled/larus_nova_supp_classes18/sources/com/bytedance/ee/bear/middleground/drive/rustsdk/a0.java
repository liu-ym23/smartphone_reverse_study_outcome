package com.bytedance.ee.bear.middleground.drive.rustsdk;

import com.bytedance.lark.pb.space.drive.v1.ResumeAllUploadResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a0 implements SdkSender.IParser<Integer> {
    public a0() {
    }

    public final Object parse(byte[] r2) throws IOException {
        return ((ResumeAllUploadResponse) ResumeAllUploadResponse.ADAPTER.decode(r2)).result;
    }
}
