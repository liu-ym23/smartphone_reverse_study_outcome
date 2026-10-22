package com.bytedance.ee.bear.middleground.drive.rustsdk;

import com.bytedance.lark.pb.space.drive.v1.MultiDownloadResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class h implements SdkSender.IParser {
    public /* synthetic */ h() {
    }

    public final Object parse(byte[] r2) {
        return ((MultiDownloadResponse) MultiDownloadResponse.ADAPTER.decode(r2)).keys_map;
    }
}
