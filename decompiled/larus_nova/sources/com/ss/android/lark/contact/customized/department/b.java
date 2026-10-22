package com.ss.android.lark.contact.customized.department;

import com.bytedance.lark.pb.contact.v1.GetAnotherNameFormatResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes35.dex */
public final class b<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T> f419100a = null;

    static {
        f419100a = new b();
    }

    public b() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return GetAnotherNameFormatResponse.ADAPTER.decode(r100).rule;
    }
}
