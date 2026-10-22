package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.GetThreadMessagesByPositionsResponse;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes35.dex */
public final class i1<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<GetThreadMessagesByPositionsResponse, l5b.a> f411604a;

    public i1(s1 r100) {
        this.f411604a = r100;
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return this.f411604a.invoke(GetThreadMessagesByPositionsResponse.ADAPTER.decode(r100));
    }
}
