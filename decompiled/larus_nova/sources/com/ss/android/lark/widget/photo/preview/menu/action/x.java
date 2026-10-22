package com.ss.android.lark.widget.photo.preview.menu.action;

import com.bytedance.lark.pb.im.v1.GetTranslateOriginImageResponse;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: classes38.dex */
public final class x implements SdkSender.IParser<GetTranslateOriginImageResponse> {
    public x() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final GetTranslateOriginImageResponse parse(byte[] r100) throws IOException {
        return GetTranslateOriginImageResponse.ADAPTER.decode(r100);
    }
}
