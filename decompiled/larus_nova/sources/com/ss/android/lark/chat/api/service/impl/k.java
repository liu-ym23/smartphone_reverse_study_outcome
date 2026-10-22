package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.im.v1.HideChatTranslatedNameResponse;
import io.reactivex.functions.Function;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class k<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<HideChatTranslatedNameResponse, Boolean> f411608a;

    public k(r r100) {
        this.f411608a = r100;
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        com.bytedance.lark.rustclient.api.s r101 = (com.bytedance.lark.rustclient.api.s) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        return com.bytedance.lark.rustclient.api.t.e(r101, this.f411608a);
    }
}
