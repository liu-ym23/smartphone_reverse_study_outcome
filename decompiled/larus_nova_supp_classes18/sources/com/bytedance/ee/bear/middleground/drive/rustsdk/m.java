package com.bytedance.ee.bear.middleground.drive.rustsdk;

import com.bytedance.lark.pb.space.drive.v1.DriveDecryptResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class m implements SdkSender.IParser {
    public /* synthetic */ m() {
    }

    public final Object parse(byte[] r3) {
        DriveDecryptResponse r4 = (DriveDecryptResponse) DriveDecryptResponse.ADAPTER.decode(r3);
        if (r4.success.booleanValue() == true) goto L7;
        tt5.a.d("Middleground_Drive_DriveRustPBWrapper", "driveDecrypt error: " + r4.error_message);
        return null;
    L7:
        return r4.body.toByteArray();
    }
}
