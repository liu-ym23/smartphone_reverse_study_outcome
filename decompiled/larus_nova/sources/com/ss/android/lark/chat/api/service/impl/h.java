package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.TranslateChatNameResponse;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes35.dex */
public final class h<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<TranslateChatNameResponse, Boolean> f411598a;

    public h(e0 r100) {
        this.f411598a = r100;
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return this.f411598a.invoke(TranslateChatNameResponse.ADAPTER.decode(r100));
    }
}
