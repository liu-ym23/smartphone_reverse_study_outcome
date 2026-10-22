package com.ss.android.lark.forwardv3.data.services;

import com.ss.android.lark.pb.messages.BatchShareMessageResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes36.dex */
public final class f<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f<T> f425324a = null;

    static {
        f425324a = new f();
    }

    public f() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return BatchShareMessageResponse.ADAPTER.decode(r100);
    }
}
