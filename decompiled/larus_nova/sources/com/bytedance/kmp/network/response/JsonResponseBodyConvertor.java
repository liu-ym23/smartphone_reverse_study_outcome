package com.bytedance.kmp.network.response;

import kotlin.jvm.internal.Intrinsics;
import ouc.v;
import ouc.w;

/* JADX INFO: loaded from: classes19.dex */
public final class JsonResponseBodyConvertor<T> implements f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final juc.d<T> f252561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f252562b;

    public JsonResponseBodyConvertor(juc.d<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "deserializer");
        this.f252561a = r100;
        this.f252562b = w.a(JsonResponseBodyConvertor$json$1.INSTANCE);
    }

    @Override // com.bytedance.kmp.network.response.f
    public final Object a(e r100) {
        if (r100 == null) goto L6;
        String r101 = r100.c();
        if (r101 == null) goto L6;
        return this.f252562b.c(this.f252561a, r101);
    L6:
        return null;
    }
}
