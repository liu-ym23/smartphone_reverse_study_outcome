package com.ss.android.lark.download.service.impl;

import com.bytedance.lark.pb.media.v1.GetFileStateResponse;
import com.ss.android.lark.download.service.FileState;
import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: classes35.dex */
public final class h implements SdkSender.IParser<FileState> {
    public h() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final FileState parse(byte[] r100) throws IOException {
        return FileState.forNumber(GetFileStateResponse.ADAPTER.decode(r100).state.getValue());
    }
}
