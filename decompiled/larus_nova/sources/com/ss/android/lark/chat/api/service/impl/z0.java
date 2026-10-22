package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.url.v1.MGetUrlPreviewResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes35.dex */
public final class z0<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z0<T> f411708a = null;

    static {
        f411708a = new z0();
    }

    public z0() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return MGetUrlPreviewResponse.ADAPTER.decode(r100);
    }
}
