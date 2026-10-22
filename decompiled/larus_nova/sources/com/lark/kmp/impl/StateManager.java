package com.lark.kmp.impl;

import gy7.g;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;

/* JADX INFO: loaded from: classes7.dex */
public final class StateManager implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f278588a;

    public StateManager() {
        this.f278588a = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, StateManager$delegate$2.INSTANCE);
    }
}
