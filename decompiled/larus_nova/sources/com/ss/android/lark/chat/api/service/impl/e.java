package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.SubscribeChatEventResponse;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes35.dex */
public final class e<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<SubscribeChatEventResponse, String> f411583a;

    public e(b0 r100) {
        this.f411583a = r100;
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return this.f411583a.invoke(SubscribeChatEventResponse.ADAPTER.decode(r100));
    }
}
