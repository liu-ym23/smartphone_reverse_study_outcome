package com.larksuite.component.card.component.res;

import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes24.dex */
public final class a<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<T> f283559a = null;

    static {
        f283559a = new a();
    }

    public a() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return SendHttpResponse.ADAPTER.decode(r100);
    }
}
