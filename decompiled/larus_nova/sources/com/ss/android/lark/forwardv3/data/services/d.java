package com.ss.android.lark.forwardv3.data.services;

import com.bytedance.lark.pb.im.v1.BatchTransmitResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes36.dex */
public final class d<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<T> f425322a = null;

    static {
        f425322a = new d();
    }

    public d() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return BatchTransmitResponse.ADAPTER.decode(r100);
    }
}
