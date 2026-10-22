package com.bytedance.kmp.livesdk.gift.platform.dialog.datalayer;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicInteger f252334c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f252335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final kc6.o f252336b;

    public static final class a {
        public static u a(kc6.o r100) {
            Intrinsics.checkNotNullParameter(r100, "giftList");
            return new u(u.f252334c.incrementAndGet(), r100);
        }
    }

    static {
        f252334c = new AtomicInteger(0);
    }

    public u(int r100, kc6.o r101) {
        this.f252335a = r100;
        this.f252336b = r101;
    }
}
