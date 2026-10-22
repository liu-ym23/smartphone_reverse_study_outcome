package com.bytedance.locallife.live.util;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f260722a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicInteger f260723b;

    public static final class a {
    }

    static {
    }

    public m(String r100) {
        Intrinsics.checkNotNullParameter(r100, "roomId");
        this.f260722a = r100;
        this.f260723b = new AtomicInteger(1);
    }
}
