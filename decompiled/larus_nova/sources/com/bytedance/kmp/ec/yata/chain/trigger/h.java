package com.bytedance.kmp.ec.yata.chain.trigger;

import com.bytedance.kmp.ec.yata.common.platform.YataPlatformAtomicBoolean;
import com.bytedance.kmp.ec.yata.common.platform.YataPlatformAtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f251326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f251327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final YataPlatformAtomicInteger f251328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final YataPlatformAtomicBoolean f251329d;

    public h(c r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "chainInput");
        this.f251326a = r100;
        this.f251327b = r101;
        this.f251328c = new YataPlatformAtomicInteger(0);
        this.f251329d = new YataPlatformAtomicBoolean(false);
    }
}
