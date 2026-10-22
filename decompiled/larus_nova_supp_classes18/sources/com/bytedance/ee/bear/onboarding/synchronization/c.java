package com.bytedance.ee.bear.onboarding.synchronization;

import com.bytedance.lark.pb.onboarding.v1.PostUserConsumingGuideResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c<T> implements SdkSender.IParser {
    public static final c<T> a = null;

    static {
        a = new c();
    }

    public c() {
    }

    public final Object parse(byte[] r2) {
        PostUserConsumingGuideResponse.ADAPTER.decode(r2);
        return Boolean.TRUE;
    }
}
