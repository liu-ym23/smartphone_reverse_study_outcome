package com.ss.android.lark.videosend.compress;

import com.bytedance.lark.pb.media.v1.ChunkyUploadResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes38.dex */
public final class k<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k<T> f444960a = null;

    static {
        f444960a = new k();
    }

    public k() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return ChunkyUploadResponse.ADAPTER.decode(r100).code;
    }
}
