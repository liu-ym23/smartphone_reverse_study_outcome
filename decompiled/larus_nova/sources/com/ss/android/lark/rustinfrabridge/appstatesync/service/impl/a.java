package com.ss.android.lark.rustinfrabridge.appstatesync.service.impl;

import com.ss.android.lark.sdk.SdkSender;
import java.io.IOException;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements SdkSender.IParser<Boolean> {
    public a() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Boolean parse(byte[] r100) throws IOException {
        return Boolean.TRUE;
    }
}
