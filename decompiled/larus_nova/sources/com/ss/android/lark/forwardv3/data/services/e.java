package com.ss.android.lark.forwardv3.data.services;

import com.bytedance.lark.pb.im.v1.TransmitResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes36.dex */
public final class e<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<T> f425323a = null;

    static {
        f425323a = new e();
    }

    public e() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return TransmitResponse.ADAPTER.decode(r100);
    }
}
