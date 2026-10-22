package com.ss.android.lark.contact.base.service;

import com.ss.android.lark.pb.chatters.PutUserAgreementResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes35.dex */
public final class g<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g<T> f418922a = null;

    static {
        f418922a = new g();
    }

    public g() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return PutUserAgreementResponse.ADAPTER.decode(r100);
    }
}
