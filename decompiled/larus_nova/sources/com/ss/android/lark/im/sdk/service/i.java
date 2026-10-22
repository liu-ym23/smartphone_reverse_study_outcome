package com.ss.android.lark.im.sdk.service;

import com.bytedance.lark.pb.im.v1.GetChatApplicationBadgeResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class i<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i<T, R> f426101a = null;

    static {
        f426101a = new i();
    }

    public i() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        com.bytedance.lark.rustclient.api.x r101 = (com.bytedance.lark.rustclient.api.x) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return (GetChatApplicationBadgeResponse) r101.f253935c;
    }
}
