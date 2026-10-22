package com.bytedance.lark.sdk.stream;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class i implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f254387a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f254388b = null;

    public i() {
    }

    static {
        f254387a = new i();
        f254388b = new a();
    }

    @Override // com.bytedance.lark.sdk.stream.h
    public final f a(long r100) {
        return f254388b.a(r100);
    }

    @Override // com.bytedance.lark.sdk.stream.h
    public final boolean b(long r100, com.larksuite.framework.http.v2.internal.rust.stream.i.a r101, j r102) {
        Intrinsics.checkNotNullParameter(r101, "callback");
        Intrinsics.checkNotNullParameter(r102, "requestBodyReader");
        return f254388b.b(r100, r101, r102);
    }
}
