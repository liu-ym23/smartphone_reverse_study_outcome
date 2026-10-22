package com.bytedance.ee.bear.middleground.drive.rustsdk.init;

import com.bytedance.lark.pb.space.drive.v1.InitDriveResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class b implements SdkSender.IParser {
    public /* synthetic */ b() {
    }

    public final Object parse(byte[] r3) {
        InitDriveResponse r4 = (InitDriveResponse) InitDriveResponse.ADAPTER.decode(r3);
        tt5.a.h("Middleground_Drive_DriveRustSdkWrapper", "DriveRustPBWrapper sync parse: response result =" + r4.result);
        if (r4.result.booleanValue() == true) goto L6;
        DriveRustSdkWrapper.a = null;
    L6:
        return r4.result;
    }
}
