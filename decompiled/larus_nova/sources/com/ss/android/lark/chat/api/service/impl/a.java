package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.CreateAddChatChatterApplyResponse;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes35.dex */
public final class a<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<CreateAddChatChatterApplyResponse, Boolean> f411566a;

    public a(x r100) {
        this.f411566a = r100;
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return this.f411566a.invoke(CreateAddChatChatterApplyResponse.ADAPTER.decode(r100));
    }
}
