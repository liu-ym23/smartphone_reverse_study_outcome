package com.bytedance.ee.bear.onboarding.synchronization;

import com.bytedance.lark.pb.onboarding.v1.PostUserConsumingGuideResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes18.dex */
public final class e<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<T> f236184a = null;

    static {
        f236184a = new e();
    }

    public e() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        PostUserConsumingGuideResponse.ADAPTER.decode(r100);
        return Boolean.TRUE;
    }
}
