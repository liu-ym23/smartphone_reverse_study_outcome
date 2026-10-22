package com.bytedance.locallife.hybrid.router;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes21.dex */
public final class InterceptRule {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f259079b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f259080a;

    public static final class a {
    }

    static {
    }

    public InterceptRule() {
        this.f259080a = LazyKt.lazy(new InterceptRule$rules$2(this));
    }
}
