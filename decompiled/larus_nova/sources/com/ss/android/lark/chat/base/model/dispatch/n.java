package com.ss.android.lark.chat.base.model.dispatch;

import com.bytedance.lark.pb.media.v1.PreprocessResourceResponse;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes35.dex */
public final class n<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n<T> f411793a = null;

    static {
        f411793a = new n();
    }

    public n() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        ProtoAdapter<PreprocessResourceResponse> r101 = PreprocessResourceResponse.ADAPTER;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r101.decode(r100).key;
    }
}
