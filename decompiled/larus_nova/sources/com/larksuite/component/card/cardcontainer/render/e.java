package com.larksuite.component.card.cardcontainer.render;

import com.bytedance.lark.pb.openplatform.v1.TransSer2CliUniversalCardEntityResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes24.dex */
public final class e<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e<T> f283253a = null;

    static {
        f283253a = new e();
    }

    public e() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return TransSer2CliUniversalCardEntityResponse.ADAPTER.decode(r100).universal_card_entity;
    }
}
