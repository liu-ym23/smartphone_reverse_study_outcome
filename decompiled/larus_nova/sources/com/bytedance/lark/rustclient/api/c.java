package com.bytedance.lark.rustclient.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class c<RAW, DATA> extends s<RAW, DATA> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f253907c;

    public c(p r100, RAW r101, w r102) {
        Intrinsics.checkNotNullParameter(r100, "error");
        Intrinsics.checkNotNullParameter(r102, "scopePayload");
        super(r101, r102);
        this.f253907c = r100;
    }
}
