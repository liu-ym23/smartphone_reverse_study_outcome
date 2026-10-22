package com.obric.oui.push;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes34.dex */
public final class PushQueue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy<PushQueue> f402602a = null;

    public static final class a {
    }

    static {
        f402602a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, PushQueue$Companion$instance$2.INSTANCE);
    }

    public PushQueue() {
    }
}
