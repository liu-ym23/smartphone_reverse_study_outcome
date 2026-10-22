package com.bytedance.bdp.appbase.base.bdptask;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes11.dex */
public final class j {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicInteger f200511c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f200512a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f200513b;

    public static final class a {
    }

    static {
        f200511c = new AtomicInteger(0);
    }

    public j() {
        this(Integer.MAX_VALUE);
    }

    public j(int r100) {
        this.f200512a = Math.max(r100, 1);
        this.f200513b = f200511c.incrementAndGet();
    }
}
