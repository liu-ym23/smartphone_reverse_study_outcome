package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.GetChannelThreadsResponse;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes35.dex */
public final class h1<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<GetChannelThreadsResponse, l5b.b> f411599a;

    public h1(p1 r100) {
        this.f411599a = r100;
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return this.f411599a.invoke(GetChannelThreadsResponse.ADAPTER.decode(r100));
    }
}
