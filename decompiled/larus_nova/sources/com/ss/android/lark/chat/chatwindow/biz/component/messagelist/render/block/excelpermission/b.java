package com.ss.android.lark.chat.chatwindow.biz.component.messagelist.render.block.excelpermission;

import com.bytedance.lark.pb.basic.v1.SendHttpResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes35.dex */
public final class b<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b<T> f412134a = null;

    static {
        f412134a = new b();
    }

    public b() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return SendHttpResponse.ADAPTER.decode(r100);
    }
}
