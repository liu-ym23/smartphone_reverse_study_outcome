package com.ss.android.lark.integrator.ccm.dependency.di;

import com.ss.android.lark.dto.chat.ChatLinkTokenResponse;
import com.ss.android.lark.pb.chats.PullChatLinkTokenResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes36.dex */
public final class x0<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x0<T> f427871a = null;

    static {
        f427871a = new x0();
    }

    public x0() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        PullChatLinkTokenResponse r101 = PullChatLinkTokenResponse.ADAPTER.decode(r100);
        return new ChatLinkTokenResponse(r101.mtoken, r101.mshared_url, r101.mkouLing, r101.mexpire_time.longValue(), r101.mis_unlimited.booleanValue());
    }
}
