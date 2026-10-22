package com.bytedance.express;

import com.bytedance.express.util.ThreadTimeUtil;

/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f243185a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f243186b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f243187c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f243188d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f243189e;

    public c() {
        this.f243185a = System.nanoTime();
        this.f243186b = ThreadTimeUtil.a();
    }
}
