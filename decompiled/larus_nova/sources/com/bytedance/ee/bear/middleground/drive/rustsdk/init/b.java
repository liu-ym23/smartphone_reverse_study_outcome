package com.bytedance.ee.bear.middleground.drive.rustsdk.init;

import com.bytedance.lark.pb.space.drive.v1.InitDriveResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes18.dex */
public final /* synthetic */ class b implements SdkSender.IParser {
    public /* synthetic */ b() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        InitDriveResponse r101 = InitDriveResponse.ADAPTER.decode(r100);
        tt5.a.h("Middleground_Drive_DriveRustSdkWrapper", "DriveRustPBWrapper sync parse: response result =" + r101.result);
        if (r101.result.booleanValue() == true) goto L6;
        DriveRustSdkWrapper.f232570a = null;
    L6:
        return r101.result;
    }
}
