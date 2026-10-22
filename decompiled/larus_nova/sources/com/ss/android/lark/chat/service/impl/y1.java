package com.ss.android.lark.chat.service.impl;

import com.bytedance.lark.pb.media.v1.GetPreviewVideoSourceResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class y1<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final y1<T, R> f416596a = null;

    static {
        f416596a = new y1();
    }

    public y1() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        com.bytedance.lark.rustclient.api.x r101 = (com.bytedance.lark.rustclient.api.x) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return ((GetPreviewVideoSourceResponse) r101.f253935c).video_src;
    }
}
