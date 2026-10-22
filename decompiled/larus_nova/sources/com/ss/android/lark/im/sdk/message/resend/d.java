package com.ss.android.lark.im.sdk.message.resend;

import com.bytedance.lark.pb.im.v1.UploadResourceResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes36.dex */
public final class d<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d<T> f425957a = null;

    static {
        f425957a = new d();
    }

    public d() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return UploadResourceResponse.ADAPTER.decode(r100);
    }
}
