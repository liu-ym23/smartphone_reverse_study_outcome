package com.bytedance.dux.push;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes15.dex */
public final class PushQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<PushQueue> f205542a = null;

    public static final class a {
    }

    static {
        f205542a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, PushQueue$Companion$instance$2.INSTANCE);
    }

    public PushQueue() {
    }
}
