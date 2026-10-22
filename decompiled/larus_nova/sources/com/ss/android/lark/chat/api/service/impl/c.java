package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.HideChatTranslatedNameResponse;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes35.dex */
public final class c<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<HideChatTranslatedNameResponse, Boolean> f411572a;

    public c(r r100) {
        this.f411572a = r100;
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return this.f411572a.invoke(HideChatTranslatedNameResponse.ADAPTER.decode(r100));
    }
}
