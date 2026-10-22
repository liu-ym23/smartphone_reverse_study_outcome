package com.ss.android.lark.filedetail.impl.detail;

import com.bytedance.lark.pb.media.v1.DecryptFileResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes35.dex */
public final class g<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g<T> f421605a = null;

    static {
        f421605a = new g();
    }

    public g() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return Boolean.valueOf(!DecryptFileResponse.ADAPTER.decode(r100).is_not_encrypted.booleanValue());
    }
}
