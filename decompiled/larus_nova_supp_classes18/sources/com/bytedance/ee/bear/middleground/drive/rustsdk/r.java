package com.bytedance.ee.bear.middleground.drive.rustsdk;

import com.bytedance.lark.pb.space.drive.v1.CancelAllResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class r implements SdkSender.IParser<Integer> {
    public r() {
    }

    public final Object parse(byte[] r2) throws IOException {
        return ((CancelAllResponse) CancelAllResponse.ADAPTER.decode(r2)).result;
    }
}
