package com.suite.lark.platform.feature.forward.doubao.assembly.dependency;

import com.bytedance.lark.pb.im.v1.TransmitDoubaoMessagesResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes36.dex */
public final class a<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T> f461309a = null;

    static {
        f461309a = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return TransmitDoubaoMessagesResponse.ADAPTER.decode(r100);
    }
}
