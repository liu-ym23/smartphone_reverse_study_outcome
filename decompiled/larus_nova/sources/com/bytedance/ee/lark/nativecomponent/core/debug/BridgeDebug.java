package com.bytedance.ee.lark.nativecomponent.core.debug;

import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes19.dex */
public final class BridgeDebug {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f242835a;

    public BridgeDebug() {
        this.f242835a = LazyKt.lazy(BridgeDebug$observers$2.INSTANCE);
    }
}
