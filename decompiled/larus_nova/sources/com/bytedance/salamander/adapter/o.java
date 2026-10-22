package com.bytedance.salamander.adapter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f267794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f267795b;

    public static final class a {
    }

    static {
    }

    public o(p r100) {
        Intrinsics.checkNotNullParameter(r100, "impl");
        new i("salamander_storage_async_queue", false);
        this.f267795b = new e();
        this.f267794a = r100;
    }
}
