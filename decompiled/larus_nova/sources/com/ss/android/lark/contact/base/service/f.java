package com.ss.android.lark.contact.base.service;

import com.ss.android.lark.pb.chatters.PullUserAgreementResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes35.dex */
public final class f<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f<T> f418921a = null;

    static {
        f418921a = new f();
    }

    public f() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return PullUserAgreementResponse.ADAPTER.decode(r100);
    }
}
