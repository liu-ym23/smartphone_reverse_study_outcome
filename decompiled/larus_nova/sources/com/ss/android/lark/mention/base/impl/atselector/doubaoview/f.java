package com.ss.android.lark.mention.base.impl.atselector.doubaoview;

import com.ss.android.lark.pb.graph.PullClosestChattersResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes36.dex */
public final class f<T> implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f<T> f431761a = null;

    static {
        f431761a = new f();
    }

    public f() {
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return PullClosestChattersResponse.ADAPTER.decode(r100);
    }
}
