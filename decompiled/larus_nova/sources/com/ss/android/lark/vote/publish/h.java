package com.ss.android.lark.vote.publish;

import com.bytedance.lark.pb.vote.v1.PublishVoteResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes38.dex */
public final class h<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h<T> f445299a = null;

    static {
        f445299a = new h();
    }

    public h() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return PublishVoteResponse.ADAPTER.decode(r100);
    }
}
