package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.MGetChatsResponse;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.sdk.SdkSender;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes35.dex */
public final class f<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<MGetChatsResponse, Map<String, Chat>> f411588a;

    public f(a0 r100) {
        this.f411588a = r100;
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return this.f411588a.invoke(MGetChatsResponse.ADAPTER.decode(r100));
    }
}
