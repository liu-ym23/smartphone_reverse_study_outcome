package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.GetChatChatterKickResponse;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes35.dex */
public final class b<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<GetChatChatterKickResponse, com.ss.android.lark.chat.entity.chat.b> f411569a;

    public b(t r100) {
        this.f411569a = r100;
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return this.f411569a.invoke(GetChatChatterKickResponse.ADAPTER.decode(r100));
    }
}
