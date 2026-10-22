package com.ss.android.lark.forwardv3.data.services;

import com.bytedance.lark.pb.im.v1.MergeForwardMessagesResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes36.dex */
public final class c<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c<T> f425321a = null;

    static {
        f425321a = new c();
    }

    public c() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return MergeForwardMessagesResponse.ADAPTER.decode(r100);
    }
}
